package getTenants.controller;



import getTenants.model.Request;
import getTenants.model.Response;
import getTenants.repository.TaskExecutionsRepository;
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

import java.util.Optional;
import java.util.UUID;

@RestController
@EnableWebMvc
public class GetTenantsController {
    private final static int pageSize = 100;

    TaskExecutionsRepository taskExecutionRepository;
    private final Logger log = LoggerFactory.getLogger(GetTenantsController.class);


    public GetTenantsController(@Autowired TaskExecutionsRepository taskExecutionRepository) {
        this.taskExecutionRepository = taskExecutionRepository;
    }

    @RequestMapping("*")
    public ResponseEntity<Response> handleRequest(@RequestBody Request event) {
        // returns a Response resembling the result of a paged result
        //
        log.info("Got input " + event);
        int currentPage = Optional.ofNullable(event.getPage()).orElse(0);

        PageRequest pageRequest = PageRequest.of(currentPage, pageSize);

        Page<UUID> result = taskExecutionRepository.getDistinctTenantUuids(pageRequest);


        Response response = new Response();
        response.setPage(currentPage);
        response.setLast(result.isLast());
        response.setContent(result.getContent());

        return ResponseEntity.ok(response);

    }
}
