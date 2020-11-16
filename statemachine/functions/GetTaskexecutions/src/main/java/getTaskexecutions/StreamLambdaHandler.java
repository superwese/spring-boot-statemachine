package getTaskexecutions;


import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.AsyncInitializationWrapper;
import com.amazonaws.serverless.proxy.ExceptionHandler;
import com.amazonaws.serverless.proxy.SecurityContextWriter;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import getTaskexecutions.model.Request;
import getTaskexecutions.model.Response;
import org.springframework.boot.WebApplicationType;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class StreamLambdaHandler implements RequestStreamHandler {
    private static SpringBootLambdaContainerHandler<Request, Response> handler;
    static {
        try {
            AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
            applicationContext.register(App.class);

            handler = new SpringBootLambdaContainerHandler<Request, Response>(
                    Request.class,
                    Response.class,
                    new TaskexecutionsRequestReader(),
                    new TaskexecutionsResponseWriter(),
                    // this assumes you are still happy to use the default security context writers
                    // and exception handler. Obviously, you can create custom implementations of
                    // these objects too.
                    (SecurityContextWriter) (event, lambdaContext) -> null,
                    new ExceptionHandler() {
                        @Override
                        public Object handle(Throwable ex) {
                            return ex;
                        }

                        @Override
                        public void handle(Throwable ex, OutputStream stream) throws IOException {

                        }
                    },
                    App.class,
                    new AsyncInitializationWrapper(),
                    WebApplicationType.SERVLET
            );
            handler.getInitializationWrapper().start(handler);
/*
original:

            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(App.class);

            // For applications that take longer than 10 seconds to start, use the async builder:
            // long startTime = Instant.now().toEpochMilli();
            // handler = new SpringBootProxyHandlerBuilder()
            //                    .defaultProxy()
            //                    .asyncInit(startTime)
            //                    .springBootApplication(Application.class)
            //                    .buildAndInitialize();

            //  register our custom filters here
            handler.onStartup(servletContext -> {
           });

 */
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Spring Boot application", e);
        }
    }


    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }
}
