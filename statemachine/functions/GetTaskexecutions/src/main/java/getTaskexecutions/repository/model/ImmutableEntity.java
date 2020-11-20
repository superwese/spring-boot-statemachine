package getTaskexecutions.repository.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.OffsetDateTime;

import static java.lang.annotation.ElementType.FIELD;

@MappedSuperclass
public abstract class ImmutableEntity {

    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    public OffsetDateTime getCreated() {
        return this.created;
    }

    @PrePersist
    protected void onCreate() {
        created = OffsetDateTime.now();
    }

    @Target({FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ForeignKeyRef {
        String refTable();
    }
}
