package getTaskexecutions.controller;

import getTaskexecutions.model.Request;
import getTaskexecutions.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;
import java.util.stream.IntStream;

@RestController
@EnableWebMvc
public class GetTaskExecutionsController {
    private final java.util.Random rand = new Random();

    @RequestMapping("/")
    public ResponseEntity<Response> handleRequest(@RequestBody Request event) {
        // Sample Lambda function which mocks the operation of getting a list of TaskExecutions
        // ------
        // returns a Response resembling the result of a paged result
        //

        List<UUID> uuids = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> {
            uuids.add(UUID.randomUUID());
        });

        int currentPage = Optional.ofNullable(event.getPage()).orElse(0);
        Response response = new Response();
        response.setPage(event.getPage());
        response.setLast(currentPage > 2?true:false);
        response.setContent(uuids);

        return ResponseEntity.ok(response);
    }
}
