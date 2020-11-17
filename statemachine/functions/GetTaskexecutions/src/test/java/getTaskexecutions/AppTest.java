package getTaskexecutions;

import com.amazonaws.serverless.proxy.internal.servlet.StreamLambdaHandler;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import getTaskexecutions.controller.GetTaskExecutionsController;
import getTaskexecutions.model.Request;
import getTaskexecutions.model.Response;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AppTest {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());
    private final static MockLambdaContext context = new MockLambdaContext();

    @Test
    public void testController() {
        GetTaskExecutionsController controller = new GetTaskExecutionsController();


        Request event = new Request();
        event.setPage(13);
        event.setStartDate(Instant.now());
        event.setEndDate(Instant.now().plus(10, ChronoUnit.HOURS));
        event.setTenantUuid(UUID.randomUUID());

        ResponseEntity<Response> response = controller.handleRequest(event);

        assertTrue(response.getStatusCode() == HttpStatus.OK);

        assertThat(response.getBody().getPage(), is(13));

    }

    @Test
    public void testApp() throws IOException {

        Request request = new Request();
        request.setTenantUuid(UUID.randomUUID());
        request.setPage(5);
        request.setStartDate(Instant.now());
        request.setEndDate(Instant.now().plus(10, ChronoUnit.MINUTES));

        InputStream inputStream = new ByteArrayInputStream(
                objectMapper.writeValueAsBytes(request));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StreamLambdaHandler handler = new StreamLambdaHandler();
        handler.handleRequest(inputStream, outputStream, context);

        Response response = objectMapper.readValue(outputStream.toByteArray(), Response.class);

        assertEquals(request.getPage(), response.getPage());
        assertTrue(response.isLast());

    }
}
