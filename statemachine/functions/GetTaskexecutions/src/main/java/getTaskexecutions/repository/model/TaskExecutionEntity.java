package getTaskexecutions.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import getTaskexecutions.repository.types.ProcessStepInputType;
import getTaskexecutions.repository.types.TabletStatusType;
import getTaskexecutions.repository.types.ViolationLevelType;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// THIS CLASS IS GENERATED DO NOT CHANGE

/**
 * The persistent class for the task_executions database table.
 *
 */
@Entity
@Table(name = "task_executions")
@Generated(value = "JPAGenerator")
public class TaskExecutionEntity extends
		JpaEntity implements
		Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "uuid", nullable = false, insertable = true, updatable = false)
	private UUID uuid;

	@Column(name = "quality_manual_version_uuid", nullable = true, insertable = true, updatable = false)
	private UUID qualityManualVersionUuid;

	@Column(name = "root_quality_manual_uuid", nullable = true, insertable = true, updatable = false)
	private UUID rootQualityManualUuid;

	@Column(name = "root_quality_manual_version_uuid", nullable = true, insertable = true, updatable = false)
	private UUID rootQualityManualVersionUuid;

	private QualityManualEmbeddable qualityManual;

	@Column(name = "process_ctrl_version_uuid", nullable = true, insertable = true, updatable = false)
	private UUID processCtrlVersionUuid;

	@Column(name = "root_process_ctrl_uuid", nullable = true, insertable = true, updatable = false)
	private UUID rootProcessCtrlUuid;

	@Column(name = "root_process_ctrl_version_uuid", nullable = true, insertable = true, updatable = false)
	private UUID rootProcessCtrlVersionUuid;

	private ProcessControlEmbeddable processControl;

	private AlarmParameterEmbeddable alarmParameter;

	private ProcessCtrlCategoryEmbeddable processCtrlCategory;

	@Column(name = "task_uuid", nullable = false, insertable = true, updatable = false)
	private UUID taskUuid;

	@Column(name = "task_title", nullable = true, insertable = true, updatable = false)
	private String taskTitle;

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

	@Column(name = "serial_no_tablet", nullable = false, insertable = true, updatable = false)
	private String serialNoTablet;

	@Column(name = "restaurant_name", updatable = false)
	private String restaurantName;

	@Column(name = "restaurant_number", updatable = false)
	private String restaurantNumber;

	@Column(name = "violation_level", updatable = true)
	@Enumerated(EnumType.STRING)
	private ViolationLevelType violationLevel;

	@Column(name = "violation_level_aggregated", updatable = true)
	@Enumerated(EnumType.STRING)
	private ViolationLevelType violationLevelAggregated;

	@Column(name = "best_burger_violation_level_aggregated", updatable = true)
	@Enumerated(EnumType.STRING)
	private ViolationLevelType bestBurgerViolationLevelAggregated;

	@Column(name = "status", updatable = true)
	@Enumerated(EnumType.STRING)
	private TabletStatusType status;

	@Column( name = "period_uuid", updatable = true)
	private UUID periodUuid;

	@Column( name = "is_corrective_action")
	private boolean isCorrectiveAction;

	@Column( name = "is_alarm")
	private boolean isAlarm;

	@Column( name = "is_adhoc")
	private Boolean isAdhoc;

	@Column(name = "taskexecution_uuid")
	private UUID taskexecutionUuid;

	@Transient
	private boolean isUserDataAccessGranted;

	//bi-directional mapping
	@OneToMany(mappedBy = "taskExecution")
	@OrderColumn(name = "sequence_nr")
	@BatchSize(size = 100)
	@Cascade(value = {org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
	private List<ProcessStepEntity> processStepEntities = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "signature_uuid")
	private SignatureEntity signatureEntity;

	@Column(name = "should_display_input_type")
	private Boolean shouldDisplayInputType;

	@Column(name = "input_type")
	@Enumerated(EnumType.STRING)
	private ProcessStepInputType inputType;


	public TaskExecutionEntity() {
	}

	public TaskExecutionEntity(UUID uuid,
			UUID qualityManualVersionUuid,
			UUID rootQualityManualUuid,
			UUID rootQualityManualVersionUuid,
			QualityManualEmbeddable qualityManual,
			UUID processCtrlVersionUuid,
			UUID rootProcessCtrlUuid,
			UUID rootProcessCtrlVersionUuid,
			ProcessControlEmbeddable processControl,
			ProcessCtrlCategoryEmbeddable processCtrlCategory,
			AlarmParameterEmbeddable alarmParameter,
			UUID taskUuid,
			String taskTitle,
			Instant timestampStart,
			ZoneOffset timestampStartZoneOffset,
			Instant timestampEnd,
			ZoneOffset timestampEndZoneOffset,
			LocalDateTime shiftStart,
			ZoneOffset shiftStartZoneOffset,
			LocalDateTime shiftEnd,
			ZoneOffset shiftEndZoneOffset,
			UUID tenantUuid,
			String serialNoTablet,
			String restaurantName,
			String restaurantNumber,
			ViolationLevelType violationLevel,
			ViolationLevelType violationLevelAggregated,
			TabletStatusType status,
			UUID periodUuid,
			boolean isCorrectiveAction,
			boolean isAlarm,
			Boolean isAdhoc,
			UUID taskexecutionUuid,
			List<ProcessStepEntity> processStepEntities,
			Boolean isUserDataAccessGranted) {
		this.uuid = uuid;
		this.qualityManualVersionUuid = qualityManualVersionUuid;
		this.rootQualityManualUuid = rootQualityManualUuid;
		this.rootQualityManualVersionUuid = rootQualityManualVersionUuid;
		this.qualityManual = qualityManual;
		this.processCtrlVersionUuid = processCtrlVersionUuid;
		this.rootProcessCtrlUuid = rootProcessCtrlUuid;
		this.rootProcessCtrlVersionUuid = rootProcessCtrlVersionUuid;
		this.processControl = processControl;
		this.processCtrlCategory = processCtrlCategory;
		this.alarmParameter = alarmParameter;
		this.taskUuid = taskUuid;
		this.taskTitle = taskTitle;
		this.timestampStart = timestampStart;
		this.timestampStartZoneOffset = timestampStartZoneOffset;
		this.timestampEnd = timestampEnd;
		this.timestampEndZoneOffset = timestampEndZoneOffset;
		this.shiftStart = shiftStart;
		this.shiftStartZoneOffset = shiftStartZoneOffset;
		this.shiftEnd = shiftEnd;
		this.shiftEndZoneOffset = shiftEndZoneOffset;
		this.tenantUuid = tenantUuid;
		this.serialNoTablet = serialNoTablet;
		this.restaurantName = restaurantName;
		this.restaurantNumber = restaurantNumber;
		this.violationLevel = violationLevel;
		this.violationLevelAggregated = violationLevelAggregated;
		this.status = status;
		this.periodUuid = periodUuid;
		this.isCorrectiveAction = isCorrectiveAction;
		this.isAlarm = isAlarm;
		this.isAdhoc = isAdhoc;
		this.taskexecutionUuid = taskexecutionUuid;
		this.processStepEntities = processStepEntities;
		this.isUserDataAccessGranted = isUserDataAccessGranted;
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

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String title) {
		this.taskTitle = title;
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

	public UUID getQualityManualVersionUuid() {
		return qualityManualVersionUuid;
	}

	public void setQualityManualVersionUuid(UUID qualityManualVersionUuid) {
		this.qualityManualVersionUuid = qualityManualVersionUuid;
	}

	public UUID getRootQualityManualUuid() {
		return rootQualityManualUuid;
	}

	public void setRootQualityManualUuid(UUID rootQualityManualUuid) {
		this.rootQualityManualUuid = rootQualityManualUuid;
	}

	public UUID getRootQualityManualVersionUuid() {
		return rootQualityManualVersionUuid;
	}

	public void setRootQualityManualVersionUuid(UUID rootQualityManualVersionUuid) {
		this.rootQualityManualVersionUuid = rootQualityManualVersionUuid;
	}

	public QualityManualEmbeddable getQualityManual() {
		return qualityManual;
	}

	public void setQualityManual(QualityManualEmbeddable qualityManual) {
		this.qualityManual = qualityManual;
	}

	public UUID getProcessCtrlVersionUuid() {
		return processCtrlVersionUuid;
	}

	public void setProcessCtrlVersionUuid(UUID processCtrlVersionUuid) {
		this.processCtrlVersionUuid = processCtrlVersionUuid;
	}

	public UUID getRootProcessCtrlUuid() {
		return rootProcessCtrlUuid;
	}

	public void setRootProcessCtrlUuid(UUID rootProcessCtrlUuid) {
		this.rootProcessCtrlUuid = rootProcessCtrlUuid;
	}

	public UUID getRootProcessCtrlVersionUuid() {
		return rootProcessCtrlVersionUuid;
	}

	public void setRootProcessCtrlVersionUuid(UUID rootProcessCtrlVersionUuid) {
		this.rootProcessCtrlVersionUuid = rootProcessCtrlVersionUuid;
	}

	public ProcessControlEmbeddable getProcessControl() {
		return processControl;
	}

	public void setProcessControl(ProcessControlEmbeddable processControl) {
		this.processControl = processControl;
	}

	public UUID getTaskUuid() {
		return this.taskUuid;
	}

	public void setTaskUuid(UUID taskUuid) {
		this.taskUuid = taskUuid;
	}

	public List<ProcessStepEntity> getProcessStepEntities() {
		return this.processStepEntities;
	}

	public void setProcessStepEntities(List<ProcessStepEntity> processStepEntities) {
		this.processStepEntities = processStepEntities;
	}

	public String getSerialNoTablet() {
		return serialNoTablet;
	}

	public void setSerialNoTablet(String serialNoTablet) {
		this.serialNoTablet = serialNoTablet;
	}

	public boolean isCorrectiveAction() {
		return isCorrectiveAction;
	}

	public void setCorrectiveAction(boolean correctiveAction) {
		isCorrectiveAction = correctiveAction;
	}

	public int getCountTotal() {
		return getProcessStepEntities().size();
	}

	public int getCountDone() {
		return getProcessStepEntities().size();
	}

	public TabletStatusType getStatus() {
		return status;
	}

	public void setStatus(TabletStatusType status) {
		this.status = status;
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

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantNumber() {
		return restaurantNumber;
	}

	public void setRestaurantNumber(String restaurantNumber) { this.restaurantNumber = restaurantNumber; }

	public ViolationLevelType getViolationLevel() {
		return violationLevel;
	}

	public void setViolationLevel(ViolationLevelType violationLevel) {
		this.violationLevel = violationLevel;
	}

	public ViolationLevelType getViolationLevelAggregated() {
		return violationLevelAggregated;
	}

	public void setViolationLevelAggregated(ViolationLevelType violationLevelAggregated) {
		this.violationLevelAggregated = violationLevelAggregated;
	}

	public ViolationLevelType getBestBurgerViolationLevelAggregated() {
		return bestBurgerViolationLevelAggregated;
	}

	public void setBestBurgerViolationLevelAggregated(ViolationLevelType bestBurgerViolationLevelAggregated) {
		this.bestBurgerViolationLevelAggregated = bestBurgerViolationLevelAggregated;
	}

	public UUID getPeriodUuid() {
		return periodUuid;
	}

	public void setPeriodUuid(UUID periodUuid) {
		this.periodUuid = periodUuid;
	}

	public boolean isAlarm() {
		return isAlarm;
	}

	public void setIsAlarm(boolean isAlarm) {
		this.isAlarm = isAlarm;
	}

	public AlarmParameterEmbeddable getAlarmParameter() {
		return alarmParameter;
	}

	public void setAlarmParameter(AlarmParameterEmbeddable alarmParameter) {
		this.alarmParameter = alarmParameter;
	}

	public Boolean getIsAdhoc() {
		return isAdhoc;
	}

	public void setIsAdhoc(Boolean isAdhoc) {
		this.isAdhoc = isAdhoc;
	}

	public UUID getTaskexecutionUuid() {
		return taskexecutionUuid;
	}

	public void setTaskexecutionUuid(UUID taskexecutionUuid) {
		this.taskexecutionUuid = taskexecutionUuid;
	}

    public boolean isUserDataAccessGranted() {
        return isUserDataAccessGranted;
    }

    public void setUserDataAccessGranted(boolean userDataAccessGranted) {
        isUserDataAccessGranted = userDataAccessGranted;
    }

	public ProcessCtrlCategoryEmbeddable getProcessCtrlCategory() {
		return processCtrlCategory;
	}

	public void setProcessCtrlCategory(ProcessCtrlCategoryEmbeddable processCtrlCategory) {
		this.processCtrlCategory = processCtrlCategory;
	}

	public SignatureEntity getSignatureEntity() {
		return signatureEntity;
	}

	public void setSignatureEntity(SignatureEntity signatureEntity) {
		this.signatureEntity = signatureEntity;
	}

	public Boolean getShouldDisplayInputType() {
		return shouldDisplayInputType;
	}

	public void setShouldDisplayInputType(Boolean shouldDisplayInputtype) {
		this.shouldDisplayInputType = shouldDisplayInputtype;
	}

	public ProcessStepInputType getInputType() {
		return inputType;
	}

	public void setInputType(ProcessStepInputType inputType) {
		this.inputType = inputType;
	}
}
