package getTaskexecutions.repository.model;

import getTaskexecutions.repository.types.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

// THIS CLASS IS GENERATED DO NOT CHANGE

/**
 * The persistent class for the processSteps database table.
 *
 */
@Entity
@Table(name = "process_steps")
@Generated(value = "JPAGenerator")
public class ProcessStepEntity extends
        ImmutableEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "uuid", nullable = false, insertable = true, updatable = false)
	private UUID uuid;

	@Column(name = "process_step_type", nullable = false, insertable = true, updatable = false)
	@Enumerated(EnumType.STRING)
	private ProcessStepEntityType processStepType;

	@Column(name = "process_step_detail_type", nullable = false, insertable = true, updatable = false)
	@Enumerated(EnumType.STRING)
	private ProcessStepDetailType processStepsDetailType;

	@Column(name = "input_instruction", nullable = true, insertable = true, updatable = false)
	private String instruction;

	@Column(name = "is_corrective_action", nullable = false, insertable = true, updatable = false)
	private boolean isCorrectiveAction;

	@Column(name = "has_escalation", nullable = false, insertable = true, updatable = false)
	private boolean hasEscalation;

	@Column(name = "violation_level", updatable = false)
	@Enumerated(EnumType.STRING)
	private ViolationLevelType violationLevel;

	@Column(name = "violation_type", updatable = false)
	@Enumerated(EnumType.STRING)
	private ViolationTypeType violationType;

	@Column(name = "sequence_nr", updatable = false)
	private Integer sequenceNr;

	private UserEmbeddable user;

	@Column(name = "action_uuid", nullable = false, insertable = true, updatable = false)
	private UUID actionUuid;


	@Column(name = "process_step_predecessor_uuid", nullable = true, insertable = true, updatable = false)
	private UUID processStepsPredecessorUuid;

	@Column(name = "limit_uuid", nullable = true, insertable = true, updatable = false)
	//if the ManyToOne annotation is used, please remove this annotation
	//@ForeignKeyRef(refTable = "limits")
	private UUID limitUuid;

	@ManyToOne
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name = "task_execution_uuid", updatable = false)
	private TaskExecutionEntity taskExecution;

	//if the ManyToOne annotation is used, please remove this annotation
	//@ForeignKeyRef(refTable = "task_executions")
	//private String taskExecutionUuid;
	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsCommentEntity> processStepsCommentEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsDateEntity> processStepsDateEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsMeasurementEntity> processStepsMeasurementEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsTextEntity> processStepsTextEntities;

	@OneToOne(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@BatchSize(size = 1000)
	private LimitsMeasurementEntity limitsMeasurementEntity;

    @OneToOne(mappedBy = "processStepEntity")
    @Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@BatchSize(size = 1000)
	private LimitsDiffMeasurementEntity limitsDiffMeasurementEntity;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsEquipmentEntity> processStepsEquipmentEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerInitialEntity> processStepsBestBurgerInitialEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerEquipmentEntity> processStepsBestBurgerEquipmentEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerContinuedEntity> processStepsBestBurgerContinuedEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerGrillTimeEntity> processStepsBestBurgerGrillTimeEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerMeasurementEntity> processStepsBestBurgerMeasurementEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerPattyTypeEntity> processStepsBestBurgerPattyTypeEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerPostponedEntity> processStepsBestBurgerPostponedEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerQuestionEntity> processStepsBestBurgerQuestionEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerResultEntity> processStepsBestBurgerResultEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerRunSizeEntity> processStepsBestBurgerRunSizeEntities;

	@OneToMany(mappedBy = "processStepEntity")
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 1000)
	private List<ProcessStepsBestBurgerCorrectiveActionEntity> processStepsBestBurgerCorrectiveActionEntities;

	@Column(name = "input_type")
	@Enumerated(EnumType.STRING)
	private ProcessStepInputType inputType;

	@Column(name="should_display_inputtype")
	private Boolean shouldDisplayInputType;

	public ProcessStepEntity() {
	}

	public ProcessStepEntity(ProcessStepEntityType processStepType, ProcessStepDetailType processStepsDetailType, String instruction, boolean isCorrectiveAction, boolean hasEscalation, ViolationLevelType violationLevel, ViolationTypeType violationType, Integer sequenceNr, UserEmbeddable user, UUID actionUuid, UUID processStepsPredecessorUuid, UUID limitUuid, TaskExecutionEntity taskExecution, List<ProcessStepsCommentEntity> processStepsCommentEntities, List<ProcessStepsDateEntity> processStepsDateEntities, List<ProcessStepsMeasurementEntity> processStepsMeasurementEntities, List<ProcessStepsTextEntity> processStepsTextEntities, LimitsMeasurementEntity limitsMeasurementEntity, LimitsDiffMeasurementEntity limitsDiffMeasurementEntity, List<ProcessStepsEquipmentEntity> processStepsEquipmentEntities) {
		this.processStepType = processStepType;
		this.processStepsDetailType = processStepsDetailType;
		this.instruction = instruction;
		this.isCorrectiveAction = isCorrectiveAction;
		this.hasEscalation = hasEscalation;
		this.violationLevel = violationLevel;
		this.violationType = violationType;
		this.sequenceNr = sequenceNr;
		this.user = user;
		this.actionUuid = actionUuid;
		this.processStepsPredecessorUuid = processStepsPredecessorUuid;
		this.limitUuid = limitUuid;
		this.taskExecution = taskExecution;
		this.processStepsCommentEntities = processStepsCommentEntities;
		this.processStepsDateEntities = processStepsDateEntities;
		this.processStepsMeasurementEntities = processStepsMeasurementEntities;
		this.processStepsTextEntities = processStepsTextEntities;
		this.limitsMeasurementEntity = limitsMeasurementEntity;
		this.limitsDiffMeasurementEntity = limitsDiffMeasurementEntity;
		this.processStepsEquipmentEntities = processStepsEquipmentEntities;
	}

	public ProcessStepEntityType getProcessStepType() {
		return processStepType;
	}

	public void setProcessStepType(ProcessStepEntityType processStepType) {
		this.processStepType = processStepType;
	}

	public ProcessStepDetailType getProcessStepsDetailType() {
		return processStepsDetailType;
	}

	public void setProcessStepsDetailType(ProcessStepDetailType processStepsDetailType) {
		this.processStepsDetailType = processStepsDetailType;
	}

	public UUID getUuid() {
		return this.uuid;
	}

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public boolean getIsCorrectiveAction() {
		return this.isCorrectiveAction;
	}

	public void setIsCorrectiveAction(boolean isCorrectiveAction) {
		this.isCorrectiveAction = isCorrectiveAction;
	}

	public boolean getHasEscalation() {
		return this.hasEscalation;
	}

	public void setHasEscalation(boolean hasEscalation) {
		this.hasEscalation = hasEscalation;
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

	public Integer getSequenceNr() {
		return sequenceNr;
	}

	public void setSequenceNr(Integer sequenceNr) {
		this.sequenceNr = sequenceNr;
	}

	public UserEmbeddable getUser() {
		return user;
	}

	public void setUser(UserEmbeddable user) {
		this.user = user;
	}

	public UUID getActionUuid() {
		return this.actionUuid;
	}

	public void setActionUuid(UUID actionUuid) {
		this.actionUuid = actionUuid;
	}

	public UUID getProcessStepsPredecessorUuid() {
		return this.processStepsPredecessorUuid;
	}

	public void setProcessStepsPredecessorUuid(UUID processStepsPredecessorUuid) {
		this.processStepsPredecessorUuid = processStepsPredecessorUuid;
	}

	public UUID getLimitUuid() {
		return this.limitUuid;
	}

	public void setLimitUuid(UUID limitUuid) {
		this.limitUuid = limitUuid;
	}

	public TaskExecutionEntity getTaskExecution() {
		return this.taskExecution;
	}

	public void setTaskExecution(TaskExecutionEntity taskExecution) {
		this.taskExecution = taskExecution;
	}

	public List<ProcessStepsCommentEntity> getProcessStepsCommentEntities() {
		return this.processStepsCommentEntities;
	}

	public void setProcessStepsCommentEntities(List<ProcessStepsCommentEntity> processStepsCommentEntities) {
		this.processStepsCommentEntities = processStepsCommentEntities;
	}

	public List<ProcessStepsDateEntity> getProcessStepsDateEntities() {
		return this.processStepsDateEntities;
	}

	public void setProcessStepsDateEntities(List<ProcessStepsDateEntity> processStepsDateEntities) {
		this.processStepsDateEntities = processStepsDateEntities;
	}

	public List<ProcessStepsMeasurementEntity> getProcessStepsMeasurementEntities() {
		return this.processStepsMeasurementEntities;
	}

	public void setProcessStepsMeasurementEntities(List<ProcessStepsMeasurementEntity> processStepsMeasurementEntities) {
		this.processStepsMeasurementEntities = processStepsMeasurementEntities;
	}

	public List<ProcessStepsTextEntity> getProcessStepsTextEntities() {
		return this.processStepsTextEntities;
	}

	public void setProcessStepsTextEntities(List<ProcessStepsTextEntity> processStepsTextEntities) {
		this.processStepsTextEntities = processStepsTextEntities;
	}

	public LimitsMeasurementEntity getLimitsMeasurementEntity() {
		return limitsMeasurementEntity;
	}

	public void setLimitsMeasurementEntity(LimitsMeasurementEntity limitsMeasurementEntity) {
		this.limitsMeasurementEntity = limitsMeasurementEntity;
	}

	public void setProcessStepsEquipmentEntities(List<ProcessStepsEquipmentEntity> processStepsEquipmentEntities) {
		this.processStepsEquipmentEntities = processStepsEquipmentEntities;

	}

	public List<ProcessStepsEquipmentEntity> getProcessStepsEquipmentEntities() {
		return processStepsEquipmentEntities;
	}

	public LimitsDiffMeasurementEntity getLimitsDiffMeasurementEntity() {
		return limitsDiffMeasurementEntity;
	}

	public void setLimitsDiffMeasurementEntity(LimitsDiffMeasurementEntity limitsDiffMeasurementEntity) {
		this.limitsDiffMeasurementEntity = limitsDiffMeasurementEntity;
	}

	public List<ProcessStepsBestBurgerInitialEntity> getProcessStepsBestBurgerInitialEntities() {
		return processStepsBestBurgerInitialEntities;
	}

	public void setProcessStepsBestBurgerInitialEntities(List<ProcessStepsBestBurgerInitialEntity> processStepsBestBurgerInitialEntities) {
		this.processStepsBestBurgerInitialEntities = processStepsBestBurgerInitialEntities;
	}

	public List<ProcessStepsBestBurgerEquipmentEntity> getProcessStepsBestBurgerEquipmentEntities() {
		return processStepsBestBurgerEquipmentEntities;
	}

	public void setProcessStepsBestBurgerEquipmentEntities(List<ProcessStepsBestBurgerEquipmentEntity> processStepsBestBurgerEquipmentEntities) {
		this.processStepsBestBurgerEquipmentEntities = processStepsBestBurgerEquipmentEntities;
	}

	public List<ProcessStepsBestBurgerContinuedEntity> getProcessStepsBestBurgerContinuedEntities() {
		return processStepsBestBurgerContinuedEntities;
	}

	public void setProcessStepsBestBurgerContinuedEntities(List<ProcessStepsBestBurgerContinuedEntity> processStepsBestBurgerContinuedEntities) {
		this.processStepsBestBurgerContinuedEntities = processStepsBestBurgerContinuedEntities;
	}

	public List<ProcessStepsBestBurgerGrillTimeEntity> getProcessStepsBestBurgerGrillTimeEntities() {
		return processStepsBestBurgerGrillTimeEntities;
	}

	public void setProcessStepsBestBurgerGrillTimeEntities(List<ProcessStepsBestBurgerGrillTimeEntity> processStepsBestBurgerGrillTimeEntities) {
		this.processStepsBestBurgerGrillTimeEntities = processStepsBestBurgerGrillTimeEntities;
	}

	public List<ProcessStepsBestBurgerMeasurementEntity> getProcessStepsBestBurgerMeasurementEntities() {
		return processStepsBestBurgerMeasurementEntities;
	}

	public void setProcessStepsBestBurgerMeasurementEntities(List<ProcessStepsBestBurgerMeasurementEntity> processStepsBestBurgerMeasurementEntities) {
		this.processStepsBestBurgerMeasurementEntities = processStepsBestBurgerMeasurementEntities;
	}

	public List<ProcessStepsBestBurgerPattyTypeEntity> getProcessStepsBestBurgerPattyTypeEntities() {
		return processStepsBestBurgerPattyTypeEntities;
	}

	public void setProcessStepsBestBurgerPattyTypeEntities(List<ProcessStepsBestBurgerPattyTypeEntity> processStepsBestBurgerPattyTypeEntities) {
		this.processStepsBestBurgerPattyTypeEntities = processStepsBestBurgerPattyTypeEntities;
	}

	public List<ProcessStepsBestBurgerPostponedEntity> getProcessStepsBestBurgerPostponedEntities() {
		return processStepsBestBurgerPostponedEntities;
	}

	public void setProcessStepsBestBurgerPostponedEntities(List<ProcessStepsBestBurgerPostponedEntity> processStepsBestBurgerPostponedEntities) {
		this.processStepsBestBurgerPostponedEntities = processStepsBestBurgerPostponedEntities;
	}

	public List<ProcessStepsBestBurgerQuestionEntity> getProcessStepsBestBurgerQuestionEntities() {
		return processStepsBestBurgerQuestionEntities;
	}

	public void setProcessStepsBestBurgerQuestionEntities(List<ProcessStepsBestBurgerQuestionEntity> processStepsBestBurgerQuestionEntities) {
		this.processStepsBestBurgerQuestionEntities = processStepsBestBurgerQuestionEntities;
	}

	public List<ProcessStepsBestBurgerResultEntity> getProcessStepsBestBurgerResultEntities() {
		return processStepsBestBurgerResultEntities;
	}

	public void setProcessStepsBestBurgerResultEntities(List<ProcessStepsBestBurgerResultEntity> processStepsBestBurgerResultEntities) {
		this.processStepsBestBurgerResultEntities = processStepsBestBurgerResultEntities;
	}

	public List<ProcessStepsBestBurgerRunSizeEntity> getProcessStepsBestBurgerRunSizeEntities() {
		return processStepsBestBurgerRunSizeEntities;
	}

	public void setProcessStepsBestBurgerRunSizeEntities(List<ProcessStepsBestBurgerRunSizeEntity> processStepsBestBurgerRunSizeEntities) {
		this.processStepsBestBurgerRunSizeEntities = processStepsBestBurgerRunSizeEntities;
	}

	public List<ProcessStepsBestBurgerCorrectiveActionEntity> getProcessStepsBestBurgerCorrectiveActionEntities() {
		return processStepsBestBurgerCorrectiveActionEntities;
	}

	public void setProcessStepsBestBurgerCorrectiveActionEntities(List<ProcessStepsBestBurgerCorrectiveActionEntity> processStepsBestBurgerCorrectiveActionEntities) {
		this.processStepsBestBurgerCorrectiveActionEntities = processStepsBestBurgerCorrectiveActionEntities;
	}

	public ProcessStepInputType getInputType() {
		return inputType;
	}

	public void setInputType(ProcessStepInputType inputType) {
		this.inputType = inputType;
	}

	public Boolean isShouldDisplayInputType() {
		return shouldDisplayInputType;
	}

	public void setShouldDisplayInputType(Boolean shouldDisplayInputType) {
		this.shouldDisplayInputType = shouldDisplayInputType;
	}
}
