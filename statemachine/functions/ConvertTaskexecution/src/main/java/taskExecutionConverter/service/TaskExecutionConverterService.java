package taskExecutionConverter.service;

import org.springframework.stereotype.Service;
import taskExecutionConverter.model.TaskExecutionEventPayload;
import taskExecutionConverter.model.ViolationLevelType;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class TaskExecutionConverterService {

    public TaskExecutionEventPayload getTaskExecution(UUID taskExecutionUuid) {
        TaskExecutionEventPayload taskExecutionEventPayload = new TaskExecutionEventPayload();
        taskExecutionEventPayload.setUuid(UUID.randomUUID());
        taskExecutionEventPayload.setTaskUuid(taskExecutionUuid);
        taskExecutionEventPayload.setRootProcessControlUuid(UUID.randomUUID());
        taskExecutionEventPayload.setRootQualityManualUuid(UUID.randomUUID());
        taskExecutionEventPayload.setShiftEnd(OffsetDateTime.now().plus(2, ChronoUnit.HOURS));
        taskExecutionEventPayload.setShiftStart(OffsetDateTime.now().minus(1L, ChronoUnit.HOURS));
        taskExecutionEventPayload.setTenantUuid(UUID.randomUUID());
        taskExecutionEventPayload.setTimestampStart(OffsetDateTime.now());
        taskExecutionEventPayload.setViolationLevelAggregated(ViolationLevelType.okplusca);

        return taskExecutionEventPayload;
    }
}
