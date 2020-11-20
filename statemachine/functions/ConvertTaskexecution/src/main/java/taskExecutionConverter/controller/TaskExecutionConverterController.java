package taskExecutionConverter.controller;

import taskExecutionConverter.model.Request;
import taskExecutionConverter.model.TaskExecutionEventPayload;
import taskExecutionConverter.model.ViolationLevelType;
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
public class TaskExecutionConverterController {

    @RequestMapping("*")
    public ResponseEntity<TaskExecutionEventPayload> pushTaskExecutionToSnsFor(@RequestBody Request request) {
        TaskExecutionEventPayload taskExecutionEventPayload = new TaskExecutionEventPayload();
        taskExecutionEventPayload.setUuid(UUID.randomUUID());
        taskExecutionEventPayload.setTaskUuid(request.getTaskExecutionUuid());
        taskExecutionEventPayload.setRootProcessControlUuid(UUID.randomUUID());
        taskExecutionEventPayload.setRootQualityManualUuid(UUID.randomUUID());
        taskExecutionEventPayload.setShiftEnd(OffsetDateTime.now().plus(2, ChronoUnit.HOURS));
        taskExecutionEventPayload.setShiftStart(OffsetDateTime.now().minus(1L, ChronoUnit.HOURS));
        taskExecutionEventPayload.setTenantUuid(UUID.randomUUID());
        taskExecutionEventPayload.setTimestampStart(OffsetDateTime.now());
        taskExecutionEventPayload.setViolationLevelAggregated(ViolationLevelType.okplusca);

        return ResponseEntity.ok(taskExecutionEventPayload);
    }
}
