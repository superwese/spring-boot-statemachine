package taskExecutionConverter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import taskExecutionConverter.repository.model.TaskExecutionImportedEventEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SampleDataRepository extends CrudRepository<TaskExecutionImportedEventEntity, UUID> {
    Optional<TaskExecutionImportedEventEntity> findByTaskUuid(UUID taskUuid);
}
