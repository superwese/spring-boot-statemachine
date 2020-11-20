package getTaskexecutions.repository.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

/**
 * Created by oliver on 18.08.2016.
 */
@Embeddable
public class UserEmbeddable {

    @Column(name = "user_uuid", nullable = false, insertable = true, updatable = true)
    private UUID uuid;

    @Column(name = "user_name", nullable = false, insertable = true, updatable = true)
    private String name;

    public UserEmbeddable(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UserEmbeddable() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID userUuid) {
        this.uuid = userUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
