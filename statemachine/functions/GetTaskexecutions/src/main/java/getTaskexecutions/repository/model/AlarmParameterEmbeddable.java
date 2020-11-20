package getTaskexecutions.repository.model;

import getTaskexecutions.repository.types.AlarmLimitType;
import getTaskexecutions.repository.types.AlarmType;
import getTaskexecutions.repository.types.MeasurementType;

import javax.persistence.*;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;


/**
 * Created by micha on 24.11.16.
 */
@Embeddable
public class AlarmParameterEmbeddable {

    @Column(name = "alarm_limit_type_name")
    @Enumerated(EnumType.STRING)
    private AlarmLimitType limitTypeName;

    @Enumerated(EnumType.STRING)
    private AlarmType alarmType;

    @Column(name = "alarm_limit_value")
    private Double limitValue;

    @Column(name = "alarm_converted_limit_value")
    private Double convertedLimitValue;

    @Column(name = "alarm_measuring_place_title")
    private String measuringPlaceTitle;

    @Column(name = "alarm_measuring_place_type")
    private String measuringPlaceType;

    @Column(name = "alarm_measuring_place_uuid")
    private UUID measuringPlaceUuid;

	@Column(name = "alarm_measurement_type_name")
	private MeasurementType measurementTypeName;

    @Column(name = "alarm_probe_name")
    private String probeName;

    @Column(name = "alarm_probe_serial_no")
    private String probeSerialNo;

    @Column(name = "alarm_probe_uuid")
    private UUID probeUuid;

    @Column(name = "alarm_timestamp")
    private Instant timestamp;

    @Column(name = "alarm_timestamp_zoneoffset")
    @Convert(converter = ZoneOffsetJpaConverter.class)
    private ZoneOffset timestampZoneOffset;

    @Column(name = "alarm_unit_label")
    private String unitLabel;

    @Column(name = "alarm_converted_unit_label")
    private String convertedUnitLabel;

    @Column(name = "alarm_violation_value")
    private Double violationValue;

    @Column(name = "alarm_converted_violation_value")
    private Double convertedViolationValue;

    @Column(name = "alarm_door_contact_delay")
    private Integer doorContactDelay;

    @Column(name = "alarm_probe_condition_type")
    private String probeConditionType;

    private UUID alarmLogUuid;

    private String purposeTitle;

    private UUID purposeReferenceUuid;

    public AlarmLimitType getLimitTypeName() {
        return limitTypeName;
    }

    public void setLimitTypeName(AlarmLimitType limitTypeName) {
        this.limitTypeName = limitTypeName;
    }

    public Double getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(Double limitValue) {
        this.limitValue = limitValue;
    }

    public String getMeasuringPlaceTitle() {
        return measuringPlaceTitle;
    }

    public void setMeasuringPlaceTitle(String measuringPlaceTitle) {
        this.measuringPlaceTitle = measuringPlaceTitle;
    }

    public String getMeasuringPlaceType() {
        return measuringPlaceType;
    }

    public void setMeasuringPlaceType(String measuringPlaceType) {
        this.measuringPlaceType = measuringPlaceType;
    }

    public UUID getMeasuringPlaceUuid() {
        return measuringPlaceUuid;
    }

    public void setMeasuringPlaceUuid(UUID measuringPlaceUuid) {
        this.measuringPlaceUuid = measuringPlaceUuid;
    }

    public String getProbeName() {
        return probeName;
    }

    public void setProbeName(String probeName) {
        this.probeName = probeName;
    }

    public String getProbeSerialNo() {
        return probeSerialNo;
    }

    public void setProbeSerialNo(String probeSerialNo) {
        this.probeSerialNo = probeSerialNo;
    }

    public UUID getProbeUuid() {
        return probeUuid;
    }

    public void setProbeUuid(UUID probeUuid) {
        this.probeUuid = probeUuid;
    }

    public ZoneOffset getTimestampZoneOffset() {
        return timestampZoneOffset;
    }

    public void setTimestampZoneOffset(ZoneOffset timestampZoneOffset) {
        this.timestampZoneOffset = timestampZoneOffset;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getUnitLabel() {
        return unitLabel;
    }

    public void setUnitLabel(String unitLabel) {
        this.unitLabel = unitLabel;
    }

    public Double getViolationValue() {
        return violationValue;
    }

    public void setViolationValue(Double violationValue) {
        this.violationValue = violationValue;
    }

    public Integer getDoorContactDelay() {
        return doorContactDelay;
    }

    public void setDoorContactDelay(Integer doorContactDelay) {
        this.doorContactDelay = doorContactDelay;
    }

    public Double getConvertedLimitValue() {
        return convertedLimitValue;
    }

    public void setConvertedLimitValue(Double convertedLimitValue) {
        this.convertedLimitValue = convertedLimitValue;
    }

    public String getConvertedUnitLabel() {
        return convertedUnitLabel;
    }

    public void setConvertedUnitLabel(String convertedUnitLabel) {
        this.convertedUnitLabel = convertedUnitLabel;
    }

    public Double getConvertedViolationValue() {
        return convertedViolationValue;
    }

    public void setConvertedViolationValue(Double convertedViolationValue) {
        this.convertedViolationValue = convertedViolationValue;
    }

    public String getProbeConditionType() { return probeConditionType; }

    public void setProbeConditionType(String probeConditionType) { this.probeConditionType = probeConditionType; }

    public void setAlarmLogUuid(UUID alarmLogUuid) {
        this.alarmLogUuid = alarmLogUuid;
    }

    public UUID getAlarmLogUuid() {
        return alarmLogUuid;
    }

    public AlarmType getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(AlarmType alarmType) {
        this.alarmType = alarmType;
    }

    public String getPurposeTitle() {
        return purposeTitle;
    }

    public void setPurposeTitle(String purposeTitle) {
        this.purposeTitle = purposeTitle;
    }

    public UUID getPurposeReferenceUuid() {
        return purposeReferenceUuid;
    }

    public void setPurposeReferenceUuid(UUID purposeReferenceUuid) {
        this.purposeReferenceUuid = purposeReferenceUuid;
    }

	public MeasurementType getMeasurementTypeName() {
		return measurementTypeName;
	}

	public void setMeasurementTypeName(MeasurementType measurementTypeName) {
		this.measurementTypeName = measurementTypeName;
	}
}
