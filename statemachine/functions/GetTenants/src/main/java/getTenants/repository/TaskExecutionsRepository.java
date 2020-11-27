package getTenants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TaskExecutionsRepository extends CrudRepository<TaskExecutionEntity, UUID> {
    @Query("SELECT DISTINCT te.tenantUuid FROM TaskExecutionEntity te order by te.tenantUuid")
    Page<UUID> getDistinctTenantUuids(Pageable pageable);

}
