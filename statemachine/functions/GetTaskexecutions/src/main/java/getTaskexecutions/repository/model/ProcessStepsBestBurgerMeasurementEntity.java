package getTaskexecutions.repository.model;


import getTaskexecutions.repository.types.PhysicalQuantity;
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
@Table(name = "process_steps_best_burger_measurement")
@Generated(value = "JPAGenerator")
public class ProcessStepsBestBurgerMeasurementEntity extends ImmutableEntity {

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

    //Measurement
    @Column(name = "is_invalid")
    private Boolean isInvalid;

    @Column(name = "marked_as_deleted")
    private Boolean markedAsDeleted;

    @Column(name = "measuring_position")
    private Integer measuringPosition;

    @Column(name = "value")
    private Double value;

    @Column(name = "measurement_precision")
    private Integer measurementPrecision;

    @Column(name = "physical_quantity")
    @Enumerated(value = EnumType.STRING)
    private PhysicalQuantity physicalQuantity;

    @Column(name = "unit_title", nullable = false, insertable = true, updatable = false)
    private String unitTitle;

    @Column(name = "unit_iso_title", nullable = false, insertable = true, updatable = false)
    private String unitIsoTitle;

    @Column(name = "serial_no_handle", nullable = true, insertable = true, updatable = false)
    private String serialNoHandle;

    @Column(name = "serial_no_probe", nullable = true, insertable = true, updatable = false)
    private String serialNoProbe;

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

    public Boolean getIsInvalid() {
        return isInvalid;
    }

    public void setIsInvalid(Boolean isInvalid) {
        this.isInvalid = isInvalid;
    }

    public Boolean getMarkedAsDeleted() {
        return markedAsDeleted;
    }

    public void setMarkedAsDeleted(Boolean markedAsDeleted) {
        this.markedAsDeleted = markedAsDeleted;
    }

    public Integer getMeasuringPosition() {
        return measuringPosition;
    }

    public void setMeasuringPosition(Integer measuringPosition) {
        this.measuringPosition = measuringPosition;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getMeasurementPrecision() {
        return measurementPrecision;
    }

    public void setMeasurementPrecision(Integer measurementPrecision) {
        this.measurementPrecision = measurementPrecision;
    }

    public PhysicalQuantity getPhysicalQuantity() {
        return physicalQuantity;
    }

    public void setPhysicalQuantity(PhysicalQuantity physicalQuantity) {
        this.physicalQuantity = physicalQuantity;
    }

    public String getUnitTitle() {
        return unitTitle;
    }

    public void setUnitTitle(String unitTitle) {
        this.unitTitle = unitTitle;
    }

    public String getUnitIsoTitle() {
        return unitIsoTitle;
    }

    public void setUnitIsoTitle(String unitIsoTitle) {
        this.unitIsoTitle = unitIsoTitle;
    }

    public String getSerialNoHandle() {
        return serialNoHandle;
    }

    public void setSerialNoHandle(String serialNoHandle) {
        this.serialNoHandle = serialNoHandle;
    }

    public String getSerialNoProbe() {
        return serialNoProbe;
    }

    public void setSerialNoProbe(String serialNoProbe) {
        this.serialNoProbe = serialNoProbe;
    }
}
