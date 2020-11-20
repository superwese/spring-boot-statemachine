package getTaskexecutions.repository.model;


import getTaskexecutions.repository.types.LimitMeasurementDisplayUnit;
import getTaskexecutions.repository.types.PhysicalQuantity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;


/**
 * The persistent class for the limits_measurement database table.
 *
 */
@Entity
@Table(name = "limits_diff_measurement")
@Generated(value = "JPAGenerator")
public class LimitsDiffMeasurementEntity extends
		ImmutableEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "uuid", nullable = false, insertable = true, updatable = false)
	private UUID uuid;

	@Column(name = "relative_limit_value", nullable = true, insertable = true, updatable = false)
	private BigDecimal relativeLimitValue;

	@Column(name = "maximum", nullable = true, insertable = true, updatable = false)
	private Integer maximum;

	@Column(name = "minimum", nullable = true, insertable = true, updatable = false)
	private Integer minimum;

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

	public BigDecimal getRelativeLimitValue() {
		return relativeLimitValue;
	}

	public void setRelativeLimitValue(BigDecimal relativeLimitValue) {
		this.relativeLimitValue = relativeLimitValue;
	}

	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
	}
}
