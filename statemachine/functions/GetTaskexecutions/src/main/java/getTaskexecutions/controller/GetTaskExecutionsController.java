package getTaskexecutions.controller;

import com.amazonaws.services.lambda.runtime.Context;

import java.util.*;
import java.util.stream.IntStream;

public class GetTaskExecutionsController {
    private final java.util.Random rand = new Random();

    public Map<String,Object> handleRequest(Map<String, Object> event, Context context) {
        // Sample Lambda function which mocks the operation of getting a list of TaskExecutions
        // ------
        // returns a Map resembling the result of a paged result
        //     Map<String, Object>:

        List<String> uuids = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> {
            uuids.add(UUID.randomUUID().toString());
        });

        int currentPage = (int) Optional.ofNullable(event.get("page")).orElse(0);
        Map<String, Object> result = new HashMap();
        result.put("content", uuids);
        result.put("last", currentPage > 2?true:false);
        result.put("first", currentPage==0?true:false);


        return result;
    }
}
