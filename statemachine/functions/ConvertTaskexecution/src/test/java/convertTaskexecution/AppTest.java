package convertTaskexecution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void successfulResponse() {
        App app = new App();
        Map<String, Object> event = new HashMap<>();
        UUID teUuid = UUID.randomUUID();
        event.put("uuid", teUuid.toString());

        TaskexecutionImportedEvent result = app.handleRequest(event, null);

        assertEquals(teUuid, result.getUuid());
    }
}
