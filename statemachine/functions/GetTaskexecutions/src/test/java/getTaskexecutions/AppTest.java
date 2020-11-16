package getTaskexecutions;

import getTaskexecutions.controller.GetTaskExecutionsController;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    @Ignore
    public void successfulResponse() {
        GetTaskExecutionsController app = new GetTaskExecutionsController();


        Map<String, Object> event = new HashMap<>();
        event.put("page", 0);
        event.put("tenantUuid", "DEADBEEF-0000-0000-0000-000000000000");
        event.put("startDate", "2016-10-01T00:00:00Z");
        event.put("enddate", "2016-10-01T00:00:00Z");

         Map<String, Object> result = app.handleRequest(event, null);

        assertTrue(result.get("content") != null);

    }
}
