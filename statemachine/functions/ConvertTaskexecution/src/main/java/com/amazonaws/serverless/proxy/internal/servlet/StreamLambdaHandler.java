package com.amazonaws.serverless.proxy.internal.servlet;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.AsyncInitializationWrapper;
import com.amazonaws.serverless.proxy.ExceptionHandler;
import com.amazonaws.serverless.proxy.SecurityContextWriter;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import taskExecutionConverter.TaskExecutionConverterApplication;
import taskExecutionConverter.model.Request;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class StreamLambdaHandler implements RequestStreamHandler {
    private final Logger log = LoggerFactory.getLogger(StreamLambdaHandler.class);
    private static SpringBootLambdaContainerHandler<LambdaProxyRequest, AwsHttpServletResponse> handler;

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());

    static {
        try {
            AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
            applicationContext.register(TaskExecutionConverterApplication.class);

            handler = new SpringBootLambdaContainerHandler<LambdaProxyRequest, AwsHttpServletResponse>(
                    LambdaProxyRequest.class,
                    AwsHttpServletResponse.class,
                    new TaskExecutionsRequestReader(),
                    new TaskExecutionsResponseWriter(),
                    // Obviously, you can create custom implementations of
                    // these objects too.
                    (SecurityContextWriter) (event, lambdaContext) -> null,
                    new ExceptionHandler() {
                        @Override
                        public Object handle(Throwable ex) {
                            throw new RuntimeException(ex);
                        }

                        @Override
                        public void handle(Throwable ex, OutputStream stream) throws IOException {}
                    },
                    TaskExecutionConverterApplication.class,
                    new AsyncInitializationWrapper(),
                    WebApplicationType.SERVLET
            );
            handler.getInitializationWrapper().start(handler);


            //  register our custom filters here
            // handler.onStartup(servletContext -> {
            // });

        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Spring Boot application", e);
        }
    }


    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        try {

            Request request = objectMapper.readValue(input, Request.class);
            input.reset();
            LambdaProxyRequest<Request> proxyRequest = new LambdaProxyRequest<>(context, request);
            proxyRequest.setInputStream(input);

            AwsHttpServletResponse response = handler.proxy(proxyRequest, context);

            output.write(response.getAwsResponseBodyBytes());


        } catch (JsonParseException e) {
            log.error("Error while parsing request object stream", e);
            objectMapper.writeValue(output, e);
        } catch (JsonMappingException e) {
            log.error("Error while mapping object to RequestType class", e);
            objectMapper.writeValue(output, e);
        } finally {
            output.flush();
            output.close();
        }


    }
}
