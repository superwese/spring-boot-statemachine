package convertTaskexecution;

import com.amazonaws.serverless.proxy.internal.servlet.StreamLambdaHandler;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import convertTaskexecution.controller.ConvertTaskexecutionController;
import convertTaskexecution.model.Request;
import convertTaskexecution.model.TaskExecution;
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

public class AppTest {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());
    private final static MockLambdaContext context = new MockLambdaContext();

    @Test
    public void testController() {
        ConvertTaskexecutionController convertTaskexecutionController = new ConvertTaskexecutionController();

        Request request = new Request();
        request.setTaskExecutionUuid(UUID.randomUUID());

        ResponseEntity<TaskExecution> response = convertTaskexecutionController.pushTaskExecutionToSnsFor(request);

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

        TaskExecution response = objectMapper.readValue(outputStream.toByteArray(), TaskExecution.class);

        assertThat(request.getTaskExecutionUuid(), is(response.getTaskUuid()));
    }
}
