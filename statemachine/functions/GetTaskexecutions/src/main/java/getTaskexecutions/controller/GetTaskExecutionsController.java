package getTaskexecutions.controller;

import getTaskexecutions.model.Request;
import getTaskexecutions.model.Response;
import getTaskexecutions.repository.TaskExecutionRepository;
import getTaskexecutions.repository.UuidOnly;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static int pageSize = 100;

    TaskExecutionRepository taskExecutionRepository;
    private final Logger log = LoggerFactory.getLogger(GetTaskExecutionsController.class);


    public GetTaskExecutionsController(@Autowired TaskExecutionRepository taskExecutionRepository) {
        this.taskExecutionRepository = taskExecutionRepository;
    }

    @RequestMapping("*")
    public ResponseEntity<Response> handleRequest(@RequestBody Request event) {
        // returns a Response resembling the result of a paged result
        //
        log.info("Got input " + event);
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
