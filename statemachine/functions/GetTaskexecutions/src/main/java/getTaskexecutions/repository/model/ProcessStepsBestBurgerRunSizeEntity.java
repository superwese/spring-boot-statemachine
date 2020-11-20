package getTaskexecutions.repository.model;

import getTaskexecutions.repository.types.ProcessStepDetailStateType;
import getTaskexecutions.repository.types.ViolationLevelType;
import getTaskexecutions.repository.types.ViolationTypeType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

@Entity
@Table(name = "process_steps_best_burger_run_size")
@Generated(value = "JPAGenerator")
public class ProcessStepsBestBurgerRunSizeEntity extends ImmutableEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "uuid", nullable = false, insertable = true, updatable = false)
    private UUID uuid;

    @Column(name = "process_step_timestamp", nullable = false, insertable = true, updatable = false)
    private Instant processStepTimestamp;

    @Column(name = "process_step_timestamp_zoneoffset", nullable = false, updatable = false)
    @Convert(converter = ZoneOffsetJpaConverter.class)
    private ZoneOffset processStepTimestampZoneOffset;

    @ManyToOne
    @JoinColumn(name = "process_step_uuid", updatable = true)
    private ProcessStepEntity processStepEntity;

    @Column(name = "detail_type", nullable = false, insertable = true, updatable = false)
    @Enumerated(EnumType.STRING)
    private ProcessStepDetailStateType detailType;

    @Column(name = "sequence_nr", updatable = false)
    private Integer sequenceNr;

    @Column(name = "ordinal", nullable = false, updatable = false)
    private Integer ordinal;

    @Column(name = "loop_nr", updatable = false)
    private Integer loopNumber;

    @Column(name = "violation_level", updatable = false)
    @Enumerated(EnumType.STRING)
    private ViolationLevelType violationLevel;

    @Column(name = "violation_type", updatable = false)
    @Enumerated(EnumType.STRING)
    private ViolationTypeType violationType;

    @OneToOne
    @JoinColumn(name = "process_steps_detail_context_uuid")
    @Cascade({CascadeType.ALL})
    private ProcessStepsDetailContextEntity processStepsDetailContextEntity;

    //Selection
    @Column(name = "selected_run_size")
    private Integer selectedRunSize;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Instant getProcessStepTimestamp() {
        return processStepTimestamp;
    }

    public void setProcessStepTimestamp(Instant processStepTimestamp) {
        this.processStepTimestamp = processStepTimestamp;
    }

    public ZoneOffset getProcessStepTimestampZoneOffset() {
        return processStepTimestampZoneOffset;
    }

    public void setProcessStepTimestampZoneOffset(ZoneOffset processStepTimestampZoneOffset) {
        this.processStepTimestampZoneOffset = processStepTimestampZoneOffset;
    }

    public ProcessStepEntity getProcessStepEntity() {
        return processStepEntity;
    }

    public void setProcessStepEntity(ProcessStepEntity processStepEntity) {
        this.processStepEntity = processStepEntity;
    }

    public ProcessStepDetailStateType getDetailType() {
        return detailType;
    }

    public void setDetailType(ProcessStepDetailStateType detailType) {
        this.detailType = detailType;
    }

    public Integer getSequenceNr() {
        return sequenceNr;
    }

    public void setSequenceNr(Integer sequenceNr) {
        this.sequenceNr = sequenceNr;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public Integer getLoopNumber() {
        return loopNumber;
    }

    public void setLoopNumber(Integer loopNumber) {
        this.loopNumber = loopNumber;
    }

    public ViolationLevelType getViolationLevel() {
        return violationLevel;
    }

    public void setViolationLevel(ViolationLevelType violationLevel) {
        this.violationLevel = violationLevel;
    }

    public ViolationTypeType getViolationType() {
        return violationType;
    }

    public void setViolationType(ViolationTypeType violationType) {
        this.violationType = violationType;
    }

    public ProcessStepsDetailContextEntity getProcessStepsDetailContextEntity() {
        return processStepsDetailContextEntity;
    }

    public void setProcessStepsDetailContextEntity(ProcessStepsDetailContextEntity processStepsDetailContextEntity) {
        this.processStepsDetailContextEntity = processStepsDetailContextEntity;
    }

    public Integer getSelectedRunSize() {
        return selectedRunSize;
    }

    public void setSelectedRunSize(Integer selectedRunSize) {
        this.selectedRunSize = selectedRunSize;
    }
}
