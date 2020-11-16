package getTaskexecutions;

import org.junit.Test;

public class SlowAppTest {

    @Test
    public void slowAppInit_continuesInBackgroundThread_returnsCorrect() {
        /*
        StreamLambdaHandler slowApp = new StreamLambdaHandler();
        AwsProxyRequest req = new AwsProxyRequestBuilder("/hello", "GET").build();

        long startRequestTime = Instant.now().toEpochMilli();
        AwsProxyResponse resp = slowApp.handleRequest(req, new MockLambdaContext());
        long endRequestTime = Instant.now().toEpochMilli();
        assertTrue(endRequestTime - startRequestTime > SlowTestApplication.SlowDownInit.INIT_SLEEP_TIME_MS - 10_000);
        assertEquals(200, resp.getStatusCode());
        Assert.assertEquals(MessageController.HELLO_MESSAGE, resp.getBody());

         */
    }
}
