package getTaskexecutions.repository.model;

import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

import static getTaskexecutions.repository.model.StringLimiter.limitComment;


/**
 * The persistent class for the process_steps_equipment database table.
 *
 */
@Entity
@Table(name = "process_steps_equipment")
@Generated(value = "JPAGenerator")
public class ProcessStepsEquipmentEntity extends
        ImmutableEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;

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

	@Column(name = "equipment_part_title")
	private String equipmentPartTitle;

	@Column(name = "equipment_part_title_key")
	private String equipmentPartTitleKey;

	@Column(name = "equipment_part_uuid")
	private UUID equipmentPartUuid;

	@Column(name = "equipment_title")
	private String equipmentTitle;

	@Column(name = "equipment_uuid")
	private UUID equipmentUuid;

	@Column(name = "equipment_skipped")
	private Boolean skipped;

	@Column(name = "equipment_no_equipment")
	private Boolean noEquipment = false;

	@Column(name = "comment", nullable = true, insertable = true, updatable = true, length = 1024)
	private String comment;

	@ManyToOne
	@JoinColumn(name = "process_step_uuid", updatable = true)
	private ProcessStepEntity processStepEntity;

	@Column(name = "sequence_nr", updatable = false)
	private Integer sequenceNr;

	public UUID getUuid() {
		return this.uuid;
	}

	public Instant getProcessStepTimestamp() {
		return processStepTimestamp;
	}

	public void setProcessStepTimestamp(Instant processStepTimestamp) {
		this.processStepTimestamp = processStepTimestamp;
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

	public String getEquipmentPartTitle() {
		return equipmentPartTitle;
	}

	public void setEquipmentPartTitle(String equipmentPartTitle) {
		this.equipmentPartTitle = equipmentPartTitle;
	}

	public String getEquipmentPartTitleKey() {
		return equipmentPartTitleKey;
	}

	public void setEquipmentPartTitleKey(String equipmentPartTitleKey) {
		this.equipmentPartTitleKey = equipmentPartTitleKey;
	}

	public UUID getEquipmentPartUuid() {
		return equipmentPartUuid;
	}

	public void setEquipmentPartUuid(UUID equipmentPartUuid) {
		this.equipmentPartUuid = equipmentPartUuid;
	}

	public String getEquipmentTitle() {
		return equipmentTitle;
	}

	public void setEquipmentTitle(String equipmentTitle) {
		this.equipmentTitle = equipmentTitle;
	}

	public UUID getEquipmentUuid() {
		return equipmentUuid;
	}

	public void setEquipmentUuid(UUID equipmentUuid) {
		this.equipmentUuid = equipmentUuid;
	}

	public Boolean getSkipped() {
		return skipped;
	}

	public void setSkipped(Boolean skipped) {
		this.skipped = skipped;
	}

	public Boolean getNoEquipment() {
		return noEquipment;
	}

	public void setNoEquipment(Boolean noEquipment) {
		this.noEquipment = noEquipment;
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
}
