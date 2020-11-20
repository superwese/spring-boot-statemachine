package getTaskexecutions.repository.model;

import getTaskexecutions.repository.types.ViolationLevelType;
import getTaskexecutions.repository.types.ViolationTypeType;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

import static getTaskexecutions.repository.model.StringLimiter.limitComment;
import static getTaskexecutions.repository.model.StringLimiter.limitProcessStepInput;


/**
 * The persistent class for the samples_text database table.
 *
 */
@Entity
@Table(name = "process_steps_text")
@Generated(value = "JPAGenerator")
public class ProcessStepsTextEntity extends
        ImmutableEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "uuid", nullable = false, insertable = true, updatable = false)
	private UUID uuid;

	@Column(name = "is_delayed", nullable = true, insertable = true, updatable = true)
	private Boolean isDelayed;

	@Column(name = "associated_process_step_uuid", nullable = true, insertable = true, updatable = true)
	private UUID associatedProcessStepUuid;

	@Column(name = "text_type", nullable = false, insertable = true, updatable = false)
	private String textType;

	@Column(name = "process_step_input", nullable = true, insertable = true, updatable = false)
	private String processStepInput;

	@Column(name = "process_step_timestamp", nullable = false, insertable = true, updatable = false)
	private Instant processStepTimestamp;

	@Column(name = "process_step_timestamp_zoneoffset", nullable = false, insertable = true, updatable = false)
	@Convert(converter = ZoneOffsetJpaConverter.class)
	private ZoneOffset processStepTimestampZoneOffset;

	@Column(name = "violation_level", updatable = false)
	@Enumerated(EnumType.STRING)
	private ViolationLevelType violationLevel;

	@Column(name = "violation_type", updatable = false)
	@Enumerated(EnumType.STRING)
	private ViolationTypeType violationType;

	@Column(name = "comment", nullable = true, insertable = true, updatable = true, length = 1024)
	private String comment;

	@Column(name = "choice_uuid", nullable = true, insertable = true, updatable = false)
	private UUID choiceUuid;

	@Column(name = "is_user_input", nullable = true, insertable = true, updatable = true)
	private Boolean isUserInput;

	@ManyToOne
	@JoinColumn(name = "process_step_uuid", updatable = false)
	private ProcessStepEntity processStepEntity;

	@Column(name = "sequence_nr", updatable = false)
	private Integer sequenceNr;

	public UUID getUuid() {
		return this.uuid;
	}

	public String getTextType() {
		return this.textType;
	}

	public void setTextType(String textType) {
		this.textType = textType;
	}

	public String getProcessStepInput() {
		return this.processStepInput;
	}

	public void setProcessStepInput(String processStepInput) {
		this.processStepInput = limitProcessStepInput(processStepInput);
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

	public Boolean getDelayed() {
		return isDelayed;
	}

	public void setDelayed(Boolean delayed) {
		isDelayed = delayed;
	}

	public UUID getAssociatedProcessStepUuid() {
		return associatedProcessStepUuid;
	}

	public void setAssociatedProcessStepUuid(UUID associatedProcessStepUuid) {
		this.associatedProcessStepUuid = associatedProcessStepUuid;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = limitComment(comment);
	}

	public Integer getSequenceNr() {
		return sequenceNr;
	}

	public void setSequenceNr(Integer sequenceNr) {
		this.sequenceNr = sequenceNr;
	}

	public UUID getChoiceUuid() {
		return choiceUuid;
	}

	public void setChoiceUuid(UUID choiceUuid) {
		this.choiceUuid = choiceUuid;
	}

	public Boolean getIsUserInput() {
		return isUserInput;
	}

	public void setIsUserInput(Boolean isUserInput) {
		this.isUserInput = isUserInput;
	}
}
