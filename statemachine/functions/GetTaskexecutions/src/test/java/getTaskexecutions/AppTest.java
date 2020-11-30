package getTaskexecutions;

import com.amazonaws.serverless.proxy.internal.servlet.StreamLambdaHandler;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import getTaskexecutions.controller.GetTaskExecutionsController;
import getTaskexecutions.model.Request;
import getTaskexecutions.model.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles({"test"})
public class AppTest {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());
    private final static MockLambdaContext context = new MockLambdaContext();

    @Autowired
    private GetTaskExecutionsController getTaskExecutionsController;

    @Test
    public void testController() {

        Request event = new Request();
        event.setPage(13);
        event.setStartDate(Instant.now());
        event.setEndDate(Instant.now().plus(10, ChronoUnit.HOURS));
        List<UUID> tenants = Collections.singletonList(UUID.randomUUID());

        event.setTenantUuids(tenants);

        ResponseEntity<Response> response = getTaskExecutionsController.handleRequest(event);

        assertTrue(response.getStatusCode() == HttpStatus.OK);

        assertThat(response.getBody().getPage(), is(13));

    }

    @Test
    public void testApp() throws IOException {

        Request request = new Request();
        List<UUID> tenants = Collections.singletonList(UUID.randomUUID());
        request.setTenantUuids(tenants);
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
