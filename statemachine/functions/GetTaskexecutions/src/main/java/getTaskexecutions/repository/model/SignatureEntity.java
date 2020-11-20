package getTaskexecutions.repository.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "signatures")
@Generated(value = "JPAGenerator")
public class SignatureEntity extends
        JpaEntity implements
        Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid", nullable = false, insertable = false, updatable = false)
    private UUID uuid;

    @Column(name = "signed_day")
    private Date signedDay;

    @Column(name = "signed_at")
    private Instant signedAt;

    @Column(name = "signed_at_zone_offset")
    @Convert(converter = ZoneOffsetJpaConverter.class)
    private ZoneOffset zoneOffset;

    @Column(name = "tenant_uuid")
    private UUID tenantUuid;

    @Column(name = "user_uuid")
    private UUID userUuid;

    @Column(name = "signed_by_name")
    private String signedByName;

    @Column(name = "signed_by_email")
    private String signedByEmail;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "signatureEntity")
    @Cascade(value = CascadeType.ALL)
    private List<TaskExecutionEntity> taskExecutionEntities;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getSignedDay() {
        return signedDay;
    }

    public void setSignedDay(Date signedDay) {
        this.signedDay = signedDay;
    }

    public Instant getSignedAt() {
        return signedAt;
    }

    public void setSignedAt(Instant signedAt) {
        this.signedAt = signedAt;
    }

    public ZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public void setZoneOffset(ZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }

    public UUID getTenantUuid() {
        return tenantUuid;
    }

    public void setTenantUuid(UUID tenantUuid) {
        this.tenantUuid = tenantUuid;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public String getSignedByName() {
        return signedByName;
    }

    public void setSignedByName(String signedByName) {
        this.signedByName = signedByName;
    }

    public String getSignedByEmail() {
        return signedByEmail;
    }

    public void setSignedByEmail(String signedByEmail) {
        this.signedByEmail = signedByEmail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<TaskExecutionEntity> getTaskExecutionEntities() {
        return taskExecutionEntities;
    }

    public void setTaskExecutionEntities(List<TaskExecutionEntity> taskExecutionEntities) {
        this.taskExecutionEntities = taskExecutionEntities;
    }
}
