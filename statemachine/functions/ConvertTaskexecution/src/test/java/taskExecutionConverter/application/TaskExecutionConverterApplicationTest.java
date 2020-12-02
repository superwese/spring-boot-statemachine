package taskExecutionConverter.application;

import com.amazonaws.serverless.proxy.internal.servlet.StreamLambdaHandler;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import taskExecutionConverter.model.Request;
import taskExecutionConverter.model.TaskExecutionImportedEventPayload;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskExecutionConverterApplicationTest {

    private final static ObjectMapper objectMapper = new ObjectMapper()
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());

    private final static MockLambdaContext context = new MockLambdaContext();

    @Test
    //@Disabled("We cannot inject Beans here because this test's ApplicationContext is different from the one created by the Requesthandler")
    public void testApp() throws IOException, InterruptedException {
        UUID taskExecutionUuid = UUID.fromString("DEADBEEF-0000-000-0000-0000000000000");
        //TaskExecutionImportedEventEntity entity = createEntity(taskExecutionUuid);
        //sampleDataRepository.save(entity);


        Request request = new Request();
        request.setTaskExecutionUuid(taskExecutionUuid);

        InputStream inputStream = new ByteArrayInputStream(objectMapper.writeValueAsBytes(request));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StreamLambdaHandler streamLambdaHandler = new StreamLambdaHandler();

        streamLambdaHandler.handleRequest(inputStream, outputStream, context);


        TaskExecutionImportedEventPayload response = objectMapper.readValue(outputStream.toByteArray(), TaskExecutionImportedEventPayload.class);

        assertThat(request.getTaskExecutionUuid(), is(response.getUuid()));
    }

    /**
     * This tests that the request hits the controller and the controller "answers" with the expected exception
     * @throws JsonProcessingException
     */
    @Test
    public void app_throws() throws JsonProcessingException {
        UUID taskExecutionUuid = UUID.randomUUID();
        Request request = new Request();
        request.setTaskExecutionUuid(taskExecutionUuid);
        InputStream inputStream = new ByteArrayInputStream(objectMapper.writeValueAsBytes(request));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StreamLambdaHandler handler = new StreamLambdaHandler();
        Exception thrown = assertThrows(
                RuntimeException.class,
                () -> {handler.handleRequest(inputStream, outputStream, context);}
        );
        StackTraceElement stackTraceElement;
        assertThat(thrown.getMessage(), containsString(taskExecutionUuid.toString()));

    }
}
