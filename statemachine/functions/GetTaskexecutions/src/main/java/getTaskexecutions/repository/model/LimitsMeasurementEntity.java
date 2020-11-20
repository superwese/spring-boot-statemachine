package getTaskexecutions.repository.model;


import getTaskexecutions.repository.types.LimitMeasurementDisplayUnit;
import getTaskexecutions.repository.types.PhysicalQuantity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


/**
 * The persistent class for the limits_measurement database table.
 *
 */
@Entity
@Table(name = "limits_measurement")
@Generated(value = "JPAGenerator")
public class LimitsMeasurementEntity extends
		ImmutableEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "uuid", nullable = false, insertable = true, updatable = false)
	private UUID uuid;

	@Column(name = "lower_violation", nullable = true, insertable = true, updatable = false)
	private Double lowerViolation;

	@Column(name = "lower_warning", nullable = true, insertable = true, updatable = false)
	private Double lowerWarning;

	@Column(name = "upper_warning", nullable = true, insertable = true, updatable = false)
	private Double upperWarning;

	@Column(name = "upper_violation", nullable = true, insertable = true, updatable = false)
	private Double upperViolation;

	@Column(name = "measurement_type", nullable = true, insertable = true, updatable = false)
	private String measurementType;

	@Column(name = "display_unit", nullable = true, insertable = true, updatable = false)
	@Enumerated(value = EnumType.STRING)
	private LimitMeasurementDisplayUnit displayUnit;

	@Column(name = "physical_quantity", nullable = true, insertable = true, updatable = false)
	@Enumerated(value = EnumType.STRING)
	private PhysicalQuantity physicalQuantity;

	@OneToOne
	@JoinColumn(name = "process_step_uuid", updatable = false)
	private ProcessStepEntity processStepEntity;

	public UUID getUuid() {
		return this.uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Double getLowerViolation() {
		return lowerViolation;
	}

	public void setLowerViolation(Double lowerViolation) {
		this.lowerViolation = lowerViolation;
	}

	public Double getLowerWarning() {
		return lowerWarning;
	}

	public void setLowerWarning(Double lowerWarning) {
		this.lowerWarning = lowerWarning;
	}

	public Double getUpperWarning() {
		return upperWarning;
	}

	public void setUpperWarning(Double upperWarning) {
		this.upperWarning = upperWarning;
	}

	public Double getUpperViolation() {
		return upperViolation;
	}

	public void setUpperViolation(Double upperViolation) {
		this.upperViolation = upperViolation;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}

	public UUID getProcessStepUuid() {
		return processStepEntity.getUuid();
	}

	public LimitMeasurementDisplayUnit getDisplayUnit() {
		return displayUnit;
	}

	public void setDisplayUnit(LimitMeasurementDisplayUnit displayUnit) {
		this.displayUnit = displayUnit;
	}

	public PhysicalQuantity getPhysicalQuantity() {
		return physicalQuantity;
	}

	public void setPhysicalQuantity(PhysicalQuantity physicalQuantity) {
		this.physicalQuantity = physicalQuantity;
	}

	public ProcessStepEntity getProcessStepEntity() {
		return processStepEntity;
	}

	public void setProcessStepEntity(ProcessStepEntity processStepEntity) {
		this.processStepEntity = processStepEntity;
	}
}
