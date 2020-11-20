package getTaskexecutions.repository.model;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Instant;

/**
 *
 *
 */
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
})
@MappedSuperclass
public abstract class JpaEntity {

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "modified")
    private Instant modified;


    public Instant getCreated() {
        return this.created;
    }

    public Instant getModified() {
        return this.modified;
    }

    @PrePersist
    protected void onCreate() {
        modified = created = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modified = Instant.now();
    }


}
