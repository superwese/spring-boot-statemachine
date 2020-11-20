package taskExecutionConverter.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public class TaskexecutionImportedEvent {

    private UUID uuid;

    private UUID rootQualityManualUuid;

    private UUID rootProcessControlUuid;

    private OffsetDateTime timestampStart;

    private OffsetDateTime shiftStart;

    private OffsetDateTime shiftEnd;

    private UUID tenantUuid;

    private String violationLevelAggregated;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getRootQualityManualUuid() {
        return rootQualityManualUuid;
    }

    public void setRootQualityManualUuid(UUID rootQualityManualUuid) {
        this.rootQualityManualUuid = rootQualityManualUuid;
    }

    public UUID getRootProcessControlUuid() {
        return rootProcessControlUuid;
    }

    public void setRootProcessControlUuid(UUID rootProcessControlUuid) {
        this.rootProcessControlUuid = rootProcessControlUuid;
    }

    public OffsetDateTime getTimestampStart() {
        return timestampStart;
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

    public void setTimestampStart(OffsetDateTime timestampStart) {
        this.timestampStart = timestampStart;
    }

    public UUID getTenantUuid() {
        return tenantUuid;
    }

    public void setTenantUuid(UUID tenantUuid) {
        this.tenantUuid = tenantUuid;
    }

    public String getViolationLevelAggregated() {
        return violationLevelAggregated;
    }

    public void setViolationLevelAggregated(String violationLevelAggregated) {
        this.violationLevelAggregated = violationLevelAggregated;
    }

    @Override
    public String toString() {
        return "TaskExecutionImportedEvent{" +
                "uuid=" + uuid +
                ", rootQualityManualUuid=" + rootQualityManualUuid +
                ", rootProcessControlUuid=" + rootProcessControlUuid +
                ", timestampStart=" + timestampStart +
                ", shiftStart=" + shiftStart +
                ", shiftEnd=" + shiftEnd +
                ", tenantUuid=" + tenantUuid +
                ", violationLevelAggregated='" + violationLevelAggregated + '\'' +
                '}';
    }
}
