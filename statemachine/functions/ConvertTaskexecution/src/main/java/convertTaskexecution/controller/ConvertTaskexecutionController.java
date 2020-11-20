package convertTaskexecution.controller;

import convertTaskexecution.model.Request;
import convertTaskexecution.model.TaskExecution;
import convertTaskexecution.model.ViolationLevelType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@RestController
@EnableWebMvc
public class ConvertTaskexecutionController {

    @RequestMapping("*")
    public ResponseEntity<TaskExecution> pushTaskExecutionToSnsFor(@RequestBody Request request) {
        TaskExecution taskExecution = new TaskExecution();
        taskExecution.setUuid(UUID.randomUUID());
        taskExecution.setTaskUuid(request.getTaskExecutionUuid());
        taskExecution.setRootProcessControlUuid(UUID.randomUUID());
        taskExecution.setRootQualityManualUuid(UUID.randomUUID());
        taskExecution.setShiftEnd(OffsetDateTime.now().plus(2, ChronoUnit.HOURS));
        taskExecution.setShiftStart(OffsetDateTime.now().minus(1L, ChronoUnit.HOURS));
        taskExecution.setTenantUuid(UUID.randomUUID());
        taskExecution.setTimestampStart(OffsetDateTime.now());
        taskExecution.setViolationLevelAggregated(ViolationLevelType.okplusca);

        return ResponseEntity.ok(taskExecution);
    }
}
