package taskExecutionConverter.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import taskExecutionConverter.model.ViolationLevelType;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Entity
@Table(name = "task_executions")
@Generated(value = "JPAGenerator")
public class TaskExecutionImportedEventEntity extends JpaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uuid", nullable = false, insertable = true, updatable = false)
    private UUID uuid;

    @Column(name = "root_quality_manual_uuid", nullable = true, insertable = true, updatable = false)
    private UUID rootQualityManualUuid;

    @Column(name = "root_process_ctrl_uuid", nullable = true, insertable = true, updatable = false)
    private UUID rootProcessControlUuid;

    @Column(name = "timestamp_start", nullable = false, insertable = true, updatable = false)
    private Instant timestampStart;

    @Column(name = "timestamp_start_zoneoffset", nullable = false, insertable = true, updatable = false)
    @Convert(converter = ZoneOffsetJpaConverter.class)
    private ZoneOffset timestampStartZoneOffset;

    @Column(name = "timestamp_end", nullable = true, insertable = true, updatable = true)
    private Instant timestampEnd;

    @Column(name = "timestamp_end_zoneoffset", nullable = true, insertable = true, updatable = true)
    @Convert(converter = ZoneOffsetJpaConverter.class)
    private ZoneOffset timestampEndZoneOffset;

    @Column(name = "shift_start", nullable = true, insertable = true, updatable = true)
    private LocalDateTime shiftStart;

    @Column(name = "shift_start_zoneoffset", nullable = true, insertable = true, updatable = true)
    @Convert(converter = ZoneOffsetJpaConverter.class)
    private ZoneOffset shiftStartZoneOffset;

    @Column(name = "shift_end", nullable = true, insertable = true, updatable = true)
    private LocalDateTime shiftEnd;

    @Column(name = "shift_end_zoneoffset", nullable = true, insertable = true, updatable = true)
    @Convert(converter = ZoneOffsetJpaConverter.class)
    private ZoneOffset shiftEndZoneOffset;

    @Column(name = "tenant_uuid", insertable = true, updatable = false)
    @JsonIgnore
    private UUID tenantUuid;

    @Column(name = "violation_level_aggregated", updatable = true)
    @Enumerated(EnumType.STRING)
    private ViolationLevelType violationLevelAggregated;

    public TaskExecutionImportedEventEntity() {
    }

    public TaskExecutionImportedEventEntity(UUID uuid,
                                            UUID rootQualityManualUuid,
                                            UUID rootProcessCtrlUuid,
                                            Instant timestampStart,
                                            ZoneOffset timestampStartZoneOffset,
                                            Instant timestampEnd,
                                            ZoneOffset timestampEndZoneOffset,
                                            LocalDateTime shiftStart,
                                            ZoneOffset shiftStartZoneOffset,
                                            LocalDateTime shiftEnd,
                                            ZoneOffset shiftEndZoneOffset,
                                            UUID tenantUuid,
                                            ViolationLevelType violationLevelAggregated) {
        this.uuid = uuid;
        this.rootQualityManualUuid = rootQualityManualUuid;
        this.rootProcessControlUuid = rootProcessCtrlUuid;
        this.timestampStart = timestampStart;
        this.timestampStartZoneOffset = timestampStartZoneOffset;
        this.timestampEnd = timestampEnd;
        this.timestampEndZoneOffset = timestampEndZoneOffset;
        this.shiftStart = shiftStart;
        this.shiftStartZoneOffset = shiftStartZoneOffset;
        this.shiftEnd = shiftEnd;
        this.shiftEndZoneOffset = shiftEndZoneOffset;
        this.tenantUuid = tenantUuid;
        this.violationLevelAggregated = violationLevelAggregated;
    }

    public UUID getTenantUuid() {
        return this.tenantUuid;
    }

    public void setTenantUuid(UUID tenantUuid) {
        this.tenantUuid = tenantUuid;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Instant getTimestampStart() {
        return this.timestampStart;
    }

    public void setTimestampStart(Instant timestampStart) {
        this.timestampStart = timestampStart;
    }

    public Instant getTimestampEnd() {
        return this.timestampEnd;
    }

    public void setTimestampEnd(Instant timestampEnd) {
        this.timestampEnd = timestampEnd;
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

    public void setRootProcessControlUuid(UUID rootProcessCtrlUuid) {
        this.rootProcessControlUuid = rootProcessCtrlUuid;
    }

    public ZoneOffset getTimestampStartZoneOffset() {
        return timestampStartZoneOffset;
    }

    public void setTimestampStartZoneOffset(ZoneOffset timestampStartZoneOffset) {
        this.timestampStartZoneOffset = timestampStartZoneOffset;
    }

    public ZoneOffset getTimestampEndZoneOffset() {
        return timestampEndZoneOffset;
    }

    public void setTimestampEndZoneOffset(ZoneOffset timestampEndZoneOffset) {
        this.timestampEndZoneOffset = timestampEndZoneOffset;
    }

    public LocalDateTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalDateTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public ZoneOffset getShiftStartZoneOffset() {
        return shiftStartZoneOffset;
    }

    public void setShiftStartZoneOffset(ZoneOffset shiftStartZoneOffset) {
        this.shiftStartZoneOffset = shiftStartZoneOffset;
    }

    public LocalDateTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(LocalDateTime shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public ZoneOffset getShiftEndZoneOffset() {
        return shiftEndZoneOffset;
    }

    public void setShiftEndZoneOffset(ZoneOffset shiftEndZoneOffset) {
        this.shiftEndZoneOffset = shiftEndZoneOffset;
    }


    public ViolationLevelType getViolationLevelAggregated() {
        return violationLevelAggregated;
    }

    public void setViolationLevelAggregated(ViolationLevelType violationLevelAggregated) {
        this.violationLevelAggregated = violationLevelAggregated;
    }

    @Override
    public String toString() {
        return "TaskExecutionImportedEventEntity{" +
                "uuid=" + uuid +
                ", rootQualityManualUuid=" + rootQualityManualUuid +
                ", rootProcessControlUuid=" + rootProcessControlUuid +
                ", timestampStart=" + timestampStart +
                ", timestampStartZoneOffset=" + timestampStartZoneOffset +
                ", timestampEnd=" + timestampEnd +
                ", timestampEndZoneOffset=" + timestampEndZoneOffset +
                ", shiftStart=" + shiftStart +
                ", shiftStartZoneOffset=" + shiftStartZoneOffset +
                ", shiftEnd=" + shiftEnd +
                ", shiftEndZoneOffset=" + shiftEndZoneOffset +
                ", tenantUuid=" + tenantUuid +
                ", violationLevelAggregated=" + violationLevelAggregated +
                '}';
    }
}

