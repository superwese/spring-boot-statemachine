package convertTaskexecution;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<Map<String, Object>, TaskexecutionImportedEvent> {
    private final Random rand = new Random();

    public TaskexecutionImportedEvent handleRequest(Map<String, Object> event, Context context) {
        // Sample Lambda function which mocks the operation of checking the current price
        // of a stock.

        // For demonstration purposes this Lambda function simply returns
        // a random integer between 0 and 100 as the stock price.

        // Parameters
        // ----------
        // event: Map<String, String>, required
        //     Input event to the Lambda function

        // context: Context, required
        //     Lambda Context runtime methods and attributes

        // Returns
        // ------
        //     Map<String, Integer>: Object containing the current price of the stock

        UUID uuid = UUID.fromString((String) event.get("uuid"));

        TaskexecutionImportedEvent taskexecutionImportedEvent = new TaskexecutionImportedEvent();
        taskexecutionImportedEvent.setUuid(uuid);
        taskexecutionImportedEvent.setRootProcessControlUuid(UUID.randomUUID());
        taskexecutionImportedEvent.setRootQualityManualUuid(UUID.randomUUID());
        taskexecutionImportedEvent.setShiftEnd(OffsetDateTime.now().plus(2, ChronoUnit.HOURS));
        taskexecutionImportedEvent.setShiftStart(OffsetDateTime.now().minus(1L, ChronoUnit.HOURS));
        taskexecutionImportedEvent.setTenantUuid(UUID.randomUUID());
        taskexecutionImportedEvent.setTimestampStart(OffsetDateTime.now());
        taskexecutionImportedEvent.setViolationLevelAggregated("AnyLevel");
        Map<String, Object> response = new HashMap<>();
        response.put("stockPrice", rand.nextInt(100));

        return taskexecutionImportedEvent;
    }
}
