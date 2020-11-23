package taskExecutionConverter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import taskExecutionConverter.repository.model.TaskExecutionImportedEventEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskExecutionImportedEventPayload implements Serializable {

    private UUID uuid;

    private UUID taskUuid;

    private UUID rootProcessControlUuid;

    // TODO mandantUuidHash?
    private UUID tenantUuid;

    private UUID rootQualityManualUuid;

    private OffsetDateTime timestampStart;

    private OffsetDateTime timestampEnd;

    private OffsetDateTime shiftStart;

    private OffsetDateTime shiftEnd;

    private ViolationLevelType violationLevelAggregated;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getTaskUuid() {
        return taskUuid;
    }

    public void setTaskUuid(UUID taskUuid) {
        this.taskUuid = taskUuid;
    }

    public UUID getRootProcessControlUuid() {
        return rootProcessControlUuid;
    }

    public void setRootProcessControlUuid(UUID rootProcessControlUuid) {
        this.rootProcessControlUuid = rootProcessControlUuid;
    }

    public UUID getTenantUuid() {
        return tenantUuid;
    }

    public void setTenantUuid(UUID tenantUuid) {
        this.tenantUuid = tenantUuid;
    }

    public UUID getRootQualityManualUuid() {
        return rootQualityManualUuid;
    }

    public void setRootQualityManualUuid(UUID rootQualityManualUuid) {
        this.rootQualityManualUuid = rootQualityManualUuid;
    }

    public OffsetDateTime getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(OffsetDateTime timestampStart) {
        this.timestampStart = timestampStart;
    }

    public OffsetDateTime getTimestampEnd() {
        return timestampEnd;
    }

    public void setTimestampEnd(OffsetDateTime timestampEnd) {
        this.timestampEnd = timestampEnd;
    }

    public OffsetDateTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(OffsetDateTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public OffsetDateTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(OffsetDateTime shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public ViolationLevelType getViolationLevelAggregated() {
        return violationLevelAggregated;
    }

    public void setViolationLevelAggregated(ViolationLevelType violationLevelAggregated) {
        this.violationLevelAggregated = violationLevelAggregated;
    }

    @Override
    public String toString() {
        return "TaskExecution{" +
                "uuid=" + uuid +
                ", rootProcessControlUuid=" + rootProcessControlUuid +
                ", tenantUuid=" + tenantUuid +
                ", rootQualityManualUuid=" + rootQualityManualUuid +
                ", timestampStart=" + timestampStart +
                ", timestampEnd=" + timestampEnd +
                ", shiftStart=" + shiftStart +
                ", shiftEnd=" + shiftEnd +
                ", violationLevelAggregated=" + violationLevelAggregated +
                '}';
    }

    public static TaskExecutionImportedEventPayload fromTaskExecutionImportedEventEntity(TaskExecutionImportedEventEntity taskExecutionImportedEventEntity) {
        TaskExecutionImportedEventPayload taskExecutionImportedEventPayload = new TaskExecutionImportedEventPayload();

        taskExecutionImportedEventPayload.setUuid(taskExecutionImportedEventEntity.getUuid());
        taskExecutionImportedEventPayload.setRootProcessControlUuid(taskExecutionImportedEventEntity.getRootProcessControlUuid());
        taskExecutionImportedEventPayload.setRootQualityManualUuid(taskExecutionImportedEventEntity.getRootQualityManualUuid());
        taskExecutionImportedEventPayload.setTenantUuid(taskExecutionImportedEventEntity.getTenantUuid());
        OffsetDateTime zonedStart = OffsetDateTime.ofInstant(taskExecutionImportedEventEntity.getTimestampStart(), taskExecutionImportedEventEntity.getTimestampStartZoneOffset());
        taskExecutionImportedEventPayload.setTimestampStart(zonedStart);

        LocalDateTime shiftStart = taskExecutionImportedEventEntity.getShiftStart();
        if (shiftStart != null) {
            taskExecutionImportedEventPayload.setShiftStart(OffsetDateTime.of(shiftStart, taskExecutionImportedEventEntity.getShiftStartZoneOffset()));
        }

        LocalDateTime shiftEnd = taskExecutionImportedEventEntity.getShiftEnd();
        if (shiftEnd != null) {
            taskExecutionImportedEventPayload.setShiftEnd(OffsetDateTime.of(shiftEnd, taskExecutionImportedEventEntity.getShiftEndZoneOffset()));
        }
        taskExecutionImportedEventPayload.setViolationLevelAggregated(taskExecutionImportedEventEntity.getViolationLevelAggregated());

        return taskExecutionImportedEventPayload;
    }
}

