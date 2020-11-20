package getTaskexecutions.repository.model;

import getTaskexecutions.repository.types.PhysicalQuantity;
import getTaskexecutions.repository.types.ViolationLevelType;
import getTaskexecutions.repository.types.ViolationTypeType;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

/**
 * The persistent class for the samples_measurement database table.
 *
 */
@Entity
@Table(name = "process_steps_measurement")
@Generated(value = "JPAGenerator")
public class ProcessStepsMeasurementEntity extends
        ImmutableEntity implements
Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "uuid", nullable = false, insertable = true, updatable = false)
	private UUID uuid;

	@Column(name = "process_step_value", nullable = true, insertable = true, updatable = false)
	private Double processStepValue;

	@Column(name = "process_step_expected_value", nullable = true, insertable = true, updatable = false)
	private Double processStepExpectedValue;

	@Column(name = "process_step_value_precision", nullable = true, insertable = true, updatable = false)
	private Integer processStepValuePrecision;

	@Column(name = "process_step_unit_title", nullable = true, insertable = true, updatable = false)
	private String processStepUnitTitle;

	@Column(name = "process_step_unit_iso_title", nullable = false, insertable = true, updatable = false)
	private String processStepUnitIsoTitle;

	@Column(name = "process_step_timestamp", nullable = false, insertable = true, updatable = false)
	private Instant processStepTimestamp;

	@Column(name = "process_step_timestamp_zoneoffset", nullable = false, updatable = false)
	@Convert(converter = ZoneOffsetJpaConverter.class)
	private ZoneOffset processStepTimestampZoneOffset;

	@Column(name = "serial_no_handle", nullable = true, insertable = true, updatable = false)
	private String serialNoHandle;

	@Column(name = "serial_no_probe", nullable = true, insertable = true, updatable = false)
	private String serialNoProbe;

	@Column(name = "probe_channel", nullable = true, insertable = true, updatable = false)
	private Long probeChannel;

	@Column(name = "violation_level", updatable = false)
	@Enumerated(EnumType.STRING)
	private ViolationLevelType violationLevel;

	@Column(name = "violation_type", updatable = false)
	@Enumerated(EnumType.STRING)
	private ViolationTypeType violationType;

	@Column(name = "is_valid", nullable = false, insertable = true, updatable = false)
	private boolean valid;

	@Column(name = "marked_as_deleted", nullable = false, insertable = true, updatable = false)
	private boolean markedAsDeleted;

	@Column(name = "physical_quantity", nullable = true, insertable = true, updatable = false)
	@Enumerated(value = EnumType.STRING)
	private PhysicalQuantity physicalQuantity;

	@ManyToOne
	@JoinColumn(name = "process_step_uuid", updatable = false)
	private ProcessStepEntity processStepEntity;

	@Column(name = "sequence_nr", updatable = false)
	private Integer sequenceNr;

	public UUID getUuid() {
		return this.uuid;
	}

	public Double getProcessStepValue() {
		return this.processStepValue;
	}

	public void setProcessStepValue(Double processStepValue) {
		this.processStepValue = processStepValue;
	}

	public Integer getProcessStepValuePrecision() {
		return processStepValuePrecision;
	}

	public void setProcessStepValuePrecision(Integer processStepValuePrecision) {
		this.processStepValuePrecision = processStepValuePrecision;
	}

	public String getProcessStepUnitTitle() {
		return this.processStepUnitTitle;
	}

	public void setProcessStepUnitTitle(String processStepUnitId) {
		this.processStepUnitTitle = processStepUnitId;
	}

	public String getProcessStepUnitIsoTitle() {
		return this.processStepUnitIsoTitle;
	}

	public void setProcessStepUnitIsoTitle(String sampleUnitIsoId) {
		this.processStepUnitIsoTitle = sampleUnitIsoId;
	}

	public Instant getProcessStepTimestamp() {
		return processStepTimestamp;
	}

	public void setProcessStepTimestamp(Instant processStepTimestamp) {
		this.processStepTimestamp = processStepTimestamp;
	}


	public String getSerialNoHandle() {
		return this.serialNoHandle;
	}

	public void setSerialNoHandle(String serialNoHandle) {
		this.serialNoHandle = serialNoHandle;
	}

	public String getSerialNoProbe() {
		return this.serialNoProbe;
	}

	public void setSerialNoProbe(String serialNoProbe) {
		this.serialNoProbe = serialNoProbe;
	}

	public Long getProbeChannel() {
		return this.probeChannel;
	}

	// ++++++++++ ManyToOne Fields ++++++++++++

	public void setProbeChannel(Long probeChannel) {
		this.probeChannel = probeChannel;
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

	public UUID getProcessStepUuid() {
		return this.getProcessStepEntity().getUuid();
	}

	public ProcessStepEntity getProcessStepEntity() {
		return this.processStepEntity;
	}

	public void setProcessStepEntity(ProcessStepEntity processStepEntity) {
		this.processStepEntity = processStepEntity;
	}

	public ZoneOffset getProcessStepTimestampZoneOffset() {
		return processStepTimestampZoneOffset;
	}

	public void setProcessStepTimestampZoneOffset(ZoneOffset processStepTimestampZoneOffset) {
		this.processStepTimestampZoneOffset = processStepTimestampZoneOffset;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

    public void setMarkedAsDeleted(boolean markedAsDeleted) {
        this.markedAsDeleted = markedAsDeleted;
    }

	public boolean isMarkedAsDeleted() {
		return markedAsDeleted;
	}

	public PhysicalQuantity getPhysicalQuantity() {
		return physicalQuantity;
	}

	public void setPhysicalQuantity(PhysicalQuantity physicalQuantity) {
		this.physicalQuantity = physicalQuantity;
	}

	public Double getProcessStepExpectedValue() {
		return processStepExpectedValue;
	}

	public void setProcessStepExpectedValue(Double processStepExpectedValue) {
		this.processStepExpectedValue = processStepExpectedValue;
	}

	public Integer getSequenceNr() {
		return sequenceNr;
	}

	public void setSequenceNr(Integer sequenceNr) {
		this.sequenceNr = sequenceNr;
	}
}
