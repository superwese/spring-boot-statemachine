package getTenants.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "task_executions")
@Generated(value = "JPAGenerator")
public class TaskExecutionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uuid", nullable = false, insertable = true, updatable = false)
    private UUID uuid;

    @Column(name = "timestamp_start", nullable = false, insertable = true, updatable = false)
    private Instant timestampStart;

    @Column(name = "timestamp_end", nullable = true, insertable = true, updatable = true)
    private Instant timestampEnd;

    @Column(name = "tenant_uuid", insertable = true, updatable = false)
    @JsonIgnore
    private UUID tenantUuid;

}
