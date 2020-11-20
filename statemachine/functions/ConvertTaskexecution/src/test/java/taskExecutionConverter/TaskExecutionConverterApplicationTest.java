package taskExecutionConverter;

import com.amazonaws.serverless.proxy.internal.servlet.StreamLambdaHandler;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import taskExecutionConverter.controller.TaskExecutionConverterController;
import taskExecutionConverter.model.Request;
import taskExecutionConverter.model.TaskExecutionEventPayload;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TaskExecutionConverterApplicationTest {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());
    private final static MockLambdaContext context = new MockLambdaContext();

    @Test
    public void testController() {
        TaskExecutionConverterController taskExecutionConverterController = new TaskExecutionConverterController();

        Request request = new Request();
        request.setTaskExecutionUuid(UUID.randomUUID());

        ResponseEntity<TaskExecutionEventPayload> response = taskExecutionConverterController.getTaskExecutionEventPayloadFor(request);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getTaskUuid(), is(request.getTaskExecutionUuid()));
    }

    @Test
    public void testApp() throws IOException {
        Request request = new Request();
        request.setTaskExecutionUuid(UUID.randomUUID());

        InputStream inputStream = new ByteArrayInputStream(
                objectMapper.writeValueAsBytes(request));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StreamLambdaHandler handler = new StreamLambdaHandler();
        handler.handleRequest(inputStream, outputStream, context);

        TaskExecutionEventPayload response = objectMapper.readValue(outputStream.toByteArray(), TaskExecutionEventPayload.class);

        assertThat(request.getTaskExecutionUuid(), is(response.getTaskUuid()));
    }
}
