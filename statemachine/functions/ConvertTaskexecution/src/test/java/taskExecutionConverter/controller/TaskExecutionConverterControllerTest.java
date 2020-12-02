package taskExecutionConverter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import taskExecutionConverter.model.Request;
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
    ObjectMapper objectMapper;
    @Autowired
    SampleDataRepository sampleDataRepository;

    @Test
    public void testController() throws JsonProcessingException {
        UUID taskExecutionUuid = UUID.randomUUID();
        TaskExecutionImportedEventEntity entity = createEntity(taskExecutionUuid);
        sampleDataRepository.save(entity);

        Request request = new Request();
        request.setTaskExecutionUuid(taskExecutionUuid);

        ResponseEntity<String> response = taskExecutionConverterController.getTaskExecutionEventPayloadFor(request);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        //assertThat(response.getBody().getUuid(), is(request.getTaskExecutionUuid()));
    }

    @Disabled
    public void testSerialize() {
        //TODO: implement me
        /*
        create a sample TaskExecutionImportedEventPayload
        serialize it as a Map<String, String>
        test that OffsetDateTime.parse(map.get(EndDate())
        return the sam eas input
         */

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
