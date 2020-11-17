package getTaskexecutions;

import getTaskexecutions.controller.GetTaskExecutionsController;
import getTaskexecutions.model.Request;
import getTaskexecutions.model.Response;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void successfulResponse() {
        GetTaskExecutionsController app = new GetTaskExecutionsController();


        Request event = new Request();
        event.setPage(13);
        event.setStartDate(Instant.now());
        event.setEndDate(Instant.now().plus(10, ChronoUnit.HOURS));
        event.setTenantUuid(UUID.randomUUID());

        ResponseEntity<Response> response = app.handleRequest(event);

        assertTrue(response.getStatusCode() == HttpStatus.OK);

        assertThat(response.getBody().getPage(), is(13));

    }
}
