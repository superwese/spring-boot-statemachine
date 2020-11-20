package getTaskexecutions.repository.model;

import getTaskexecutions.repository.types.ViolationLevelType;
import getTaskexecutions.repository.types.ViolationTypeType;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.UUID;

// THIS CLASS IS GENERATED DO NOT CHANGE

/**
 * The persistent class for the samples_date database table.
 *
 */
@Entity
@Table(name = "process_steps_date")
@Generated(value = "JPAGenerator")
public class ProcessStepsDateEntity extends
        ImmutableEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "uuid", nullable = false, insertable = true, updatable = false)
	private UUID uuid;


	@Column(name = "process_step_timestamp_zoneoffset", nullable = false, insertable = true, updatable = false)
	@Convert(converter = ZoneOffsetJpaConverter.class)
	private ZoneOffset processStepTimeStampZoneOffset;

	@Column(name = "days_offset", nullable = true, insertable = true, updatable = false)
	private Long daysOffset;

	@Column(name = "process_step_offset", nullable = true, insertable = true, updatable = false)
	private String processStepOffset;

	@Column(name = "process_step_input", nullable = false, insertable = true, updatable = false)
	@Convert(converter = LocalDateJpaConverter.class)
	private LocalDate processStepInput;

	@Column(name = "process_step_timestamp", nullable = false, insertable = true, updatable = false)
	private Instant processStepTimestamp;

	@Column(name = "violation_level", updatable = false)
	@Enumerated(EnumType.STRING)
	private ViolationLevelType violationLevel;

	@Column(name = "violation_type", updatable = false)
	@Enumerated(EnumType.STRING)
	private ViolationTypeType violationType;

	@ManyToOne
	@JoinColumn(name = "process_step_uuid", updatable = false)
	private ProcessStepEntity processStepEntity;

	@Column(name = "sequence_nr", updatable = false)
	private Integer sequenceNr;

	public UUID getUuid() {
		return this.uuid;
	}

	public Long getDaysOffset() {
		return this.daysOffset;
	}

	public void setDaysOffset(Long daysOffset) {
		this.daysOffset = daysOffset;
	}

	public String getProcessStepOffset() {
		return this.processStepOffset;
	}

	public void setProcessStepOffset(String processStepOffset) {
		this.processStepOffset = processStepOffset;
	}

	public Instant getProcessStepTimestamp() {
		return processStepTimestamp;
	}

	public void setProcessStepTimestamp(Instant processStepTimestamp) {
		this.processStepTimestamp = processStepTimestamp;
	}

	public UUID getProcessStepUuid() {
		return this.processStepEntity.getUuid();
	}

	public ZoneOffset getProcessStepTimeStampZoneOffset() {
		return processStepTimeStampZoneOffset;
	}

	public void setProcessStepTimeStampZoneOffset(ZoneOffset processStepTimeStampZoneOffset) {
		this.processStepTimeStampZoneOffset = processStepTimeStampZoneOffset;
	}

	public LocalDate getProcessStepInput() {
		return processStepInput;
	}

	public void setProcessStepInput(LocalDate processStepInput) {
		this.processStepInput = processStepInput;
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

// ++++++++++ ManyToOne Fields ++++++++++++

	public ProcessStepEntity getProcessStepEntity() {
		return this.processStepEntity;
	}

	public void setProcessStepEntity(ProcessStepEntity processStepEntity) {
		this.processStepEntity = processStepEntity;
	}

	//++++++++++ OneToMany Fields ++++++++++++


	public Integer getSequenceNr() {
		return sequenceNr;
	}

	public void setSequenceNr(Integer sequenceNr) {
		this.sequenceNr = sequenceNr;
	}
}
