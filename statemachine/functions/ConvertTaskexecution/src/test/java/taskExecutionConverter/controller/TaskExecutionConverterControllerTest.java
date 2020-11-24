package taskExecutionConverter.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import taskExecutionConverter.model.Request;
import taskExecutionConverter.model.TaskExecutionImportedEventPayload;
import taskExecutionConverter.model.ViolationLevelType;
import taskExecutionConverter.repository.SampleDataRepository;
import taskExecutionConverter.repository.model.TaskExecutionImportedEventEntity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles({"test"})
public class TaskExecutionConverterControllerTest {

    @Autowired
    private TaskExecutionConverterController taskExecutionConverterController;

    @Autowired
    SampleDataRepository sampleDataRepository;

    @Test
    public void testController() {
        UUID taskExecutionUuid = UUID.randomUUID();
        TaskExecutionImportedEventEntity entity = createEntity(taskExecutionUuid);
        sampleDataRepository.save(entity);

        Request request = new Request();
        request.setTaskExecutionUuid(taskExecutionUuid);

        ResponseEntity<TaskExecutionImportedEventPayload> response = taskExecutionConverterController.getTaskExecutionEventPayloadFor(request);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getUuid(), is(request.getTaskExecutionUuid()));
    }

    public static TaskExecutionImportedEventEntity createEntity(UUID id) {
        //consider using random values here
        TaskExecutionImportedEventEntity taskExecutionImportedEventEntity = new TaskExecutionImportedEventEntity();
        taskExecutionImportedEventEntity.setUuid(id);
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
        return taskExecutionImportedEventEntity;
    }
}
