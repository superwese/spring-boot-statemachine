package getTaskexecutions.controller;

import getTaskexecutions.model.Request;
import getTaskexecutions.model.Response;
import getTaskexecutions.repository.TaskExecutionRepository;
import getTaskexecutions.repository.UuidOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@EnableWebMvc
public class GetTaskExecutionsController {
    private final static int pageSize = 10;

    @Autowired
    TaskExecutionRepository taskExecutionRepository;


    @RequestMapping("*")
    public ResponseEntity<Response> handleRequest(@RequestBody Request event) {
        // Sample Lambda function which mocks the operation of getting a list of TaskExecutions
        // ------
        // returns a Response resembling the result of a paged result
        //
        int currentPage = Optional.ofNullable(event.getPage()).orElse(0);

        PageRequest pageRequest = PageRequest.of(currentPage, pageSize);

        Page<UuidOnly> result = taskExecutionRepository.findAllByTenantUuidAndTimestampStartBetween(event.getTenantUuid(), event.getStartDate(), event.getEndDate(), pageRequest);

        List<UUID> uuids = result.getContent().stream().map(UuidOnly::getUuid).collect(Collectors.toList());

        Response response = new Response();
        response.setPage(currentPage);
        response.setLast(result.isLast());
        response.setContent(uuids);

        return ResponseEntity.ok(response);
    }
}
