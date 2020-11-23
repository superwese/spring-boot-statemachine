package taskExecutionConverter.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import taskExecutionConverter.model.TaskExecutionImportedEventPayload;
import taskExecutionConverter.model.ViolationLevelType;
import taskExecutionConverter.repository.SampleDataRepository;
import taskExecutionConverter.repository.model.TaskExecutionImportedEventEntity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles({"test"})
public class TaskExecutionServiceTest {

    @Mock
    private SampleDataRepository sampleDataRepository;

    @Autowired
    private TaskExecutionConverterService taskExecutionConverterService;

    @Test
    public void service_converts_correct_the_db_entity_to_payload() {
        UUID taskExecutionUuid = UUID.randomUUID();

        TaskExecutionImportedEventEntity taskExecutionImportedEventEntity = new TaskExecutionImportedEventEntity();
        taskExecutionImportedEventEntity.setUuid(taskExecutionUuid);
        taskExecutionImportedEventEntity.setRootProcessControlUuid(UUID.randomUUID());
        taskExecutionImportedEventEntity.setRootQualityManualUuid(UUID.randomUUID());
        taskExecutionImportedEventEntity.setShiftEnd(LocalDateTime.now().plus(2, ChronoUnit.HOURS));
        taskExecutionImportedEventEntity.setShiftStart(LocalDateTime.now().minus(1L, ChronoUnit.HOURS));
        taskExecutionImportedEventEntity.setTenantUuid(UUID.randomUUID());
        taskExecutionImportedEventEntity.setTimestampStart(Instant.now());
        taskExecutionImportedEventEntity.setViolationLevelAggregated(ViolationLevelType.okplusca);

        when(sampleDataRepository.findByUuid(taskExecutionUuid)).thenReturn(java.util.Optional.of(taskExecutionImportedEventEntity));

        TaskExecutionImportedEventPayload taskExecutionImportedEventPayload = taskExecutionConverterService.getTaskExecution(taskExecutionUuid);

        assertThat(taskExecutionImportedEventPayload.getUuid(), is(taskExecutionImportedEventEntity.getUuid()));
        assertThat(taskExecutionImportedEventPayload.getRootProcessControlUuid(), is(taskExecutionImportedEventEntity.getRootProcessControlUuid()));
        assertThat(taskExecutionImportedEventPayload.getRootQualityManualUuid(), is(taskExecutionImportedEventEntity.getRootQualityManualUuid()));
        assertThat(taskExecutionImportedEventPayload.getShiftStart(), is(taskExecutionImportedEventEntity.getShiftStart()));
        assertThat(taskExecutionImportedEventPayload.getShiftEnd(), is(taskExecutionImportedEventEntity.getShiftEnd()));
        assertThat(taskExecutionImportedEventPayload.getTenantUuid(), is(taskExecutionImportedEventEntity.getTenantUuid()));
        assertThat(taskExecutionImportedEventPayload.getTimestampStart(), is(taskExecutionImportedEventEntity.getTimestampStart()));
        assertThat(taskExecutionImportedEventPayload.getViolationLevelAggregated(), is(taskExecutionImportedEventEntity.getViolationLevelAggregated()));
    }
}
