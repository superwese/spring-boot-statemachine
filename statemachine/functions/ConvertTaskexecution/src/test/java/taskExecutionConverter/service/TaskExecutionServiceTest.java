package taskExecutionConverter.service;

import org.junit.jupiter.api.Test;
import taskExecutionConverter.model.TaskExecutionImportedEventPayload;
import taskExecutionConverter.model.ViolationLevelType;
import taskExecutionConverter.repository.model.TaskExecutionImportedEventEntity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TaskExecutionServiceTest {


    @Test
    public void service_converts_correct_the_db_entity_to_payload() {
        UUID taskExecutionUuid = UUID.randomUUID();

        TaskExecutionImportedEventEntity taskExecutionImportedEventEntity = new TaskExecutionImportedEventEntity();
        taskExecutionImportedEventEntity.setUuid(taskExecutionUuid);
        taskExecutionImportedEventEntity.setRootProcessControlUuid(UUID.randomUUID());
        taskExecutionImportedEventEntity.setRootQualityManualUuid(UUID.randomUUID());
        taskExecutionImportedEventEntity.setShiftEnd(LocalDateTime.now().plus(2, ChronoUnit.HOURS));
        taskExecutionImportedEventEntity.setShiftEndZoneOffset(ZoneOffset.of("-02:00"));
        taskExecutionImportedEventEntity.setShiftStart(LocalDateTime.now().minus(1L, ChronoUnit.HOURS));
        taskExecutionImportedEventEntity.setShiftStartZoneOffset(ZoneOffset.of("+02:00"));
        taskExecutionImportedEventEntity.setTenantUuid(UUID.randomUUID());
        taskExecutionImportedEventEntity.setTimestampStart(Instant.now());
        taskExecutionImportedEventEntity.setTimestampStartZoneOffset(ZoneOffset.ofHours(2));
        taskExecutionImportedEventEntity.setViolationLevelAggregated(ViolationLevelType.okplusca);


        TaskExecutionImportedEventPayload taskExecutionImportedEventPayload =
                TaskExecutionImportedEventPayload.fromTaskExecutionImportedEventEntity(taskExecutionImportedEventEntity);

        assertThat(taskExecutionImportedEventPayload.getUuid(), is(taskExecutionImportedEventEntity.getUuid()));
        assertThat(taskExecutionImportedEventPayload.getRootProcessControlUuid(), is(taskExecutionImportedEventEntity.getRootProcessControlUuid()));
        assertThat(taskExecutionImportedEventPayload.getRootQualityManualUuid(), is(taskExecutionImportedEventEntity.getRootQualityManualUuid()));
        assertThat(taskExecutionImportedEventPayload.getShiftStart().toInstant(),
                is(taskExecutionImportedEventEntity.getShiftStart().toInstant(taskExecutionImportedEventEntity.getShiftStartZoneOffset())));
        assertThat(taskExecutionImportedEventPayload.getShiftEnd().toInstant(),
                is(taskExecutionImportedEventEntity.getShiftEnd().toInstant(taskExecutionImportedEventEntity.getShiftEndZoneOffset())));
        assertThat(taskExecutionImportedEventPayload.getTenantUuid(), is(taskExecutionImportedEventEntity.getTenantUuid()));
        assertThat(taskExecutionImportedEventPayload.getTimestampStart().toInstant(), is(taskExecutionImportedEventEntity.getTimestampStart()));
        assertThat(taskExecutionImportedEventPayload.getViolationLevelAggregated(), is(taskExecutionImportedEventEntity.getViolationLevelAggregated()));
    }
}
