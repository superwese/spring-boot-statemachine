package getTaskexecutions.repository;

import java.util.UUID;

public interface UuidOnly {
    UUID getUuid();
    default String asString() {
        return getUuid().toString();
    }
}
