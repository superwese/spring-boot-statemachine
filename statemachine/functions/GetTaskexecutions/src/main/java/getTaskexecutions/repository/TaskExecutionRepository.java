package getTaskexecutions.repository;

import getTaskexecutions.repository.model.TaskExecutionEntity;
import getTaskexecutions.repository.types.ProcessStepInputType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskExecutionRepository extends CrudRepository<TaskExecutionEntity, UUID> {

    Page<UuidOnly> findAllByTenantUuidAndTimestampStartBetween(UUID tenantuuid, Instant from, Instant to, Pageable pageable);
    Page<UuidOnly> findAllByTimestampStartBetween(Instant from, Instant to, Pageable pageable);
    Page<UuidOnly> findAllProjectedBy(Pageable pageRequest);
    List<UuidOnly> findAllProjectedBy();


    Page<UuidOnly> findPagedProjectedByShouldDisplayInputTypeTrueAndInputType(ProcessStepInputType inputType, PageRequest pageRequest);
}
