package taskExecutionConverter.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import taskExecutionConverter.model.Request;
import taskExecutionConverter.model.TaskExecutionImportedEventPayload;
import taskExecutionConverter.model.ViolationLevelType;
import taskExecutionConverter.service.TaskExecutionConverterService;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles({"test"})
public class TaskExecutionConverterControllerTest {

    @Mock
    private TaskExecutionConverterService taskExecutionConverterService;

    @Autowired
    private TaskExecutionConverterController taskExecutionConverterController;

    @Test
    public void testController() {
        UUID taskExecutionUuid = UUID.randomUUID();
        TaskExecutionImportedEventPayload taskExecutionImportedEventPayload = new TaskExecutionImportedEventPayload();
        taskExecutionImportedEventPayload.setUuid(taskExecutionUuid);
        taskExecutionImportedEventPayload.setRootProcessControlUuid(UUID.randomUUID());
        taskExecutionImportedEventPayload.setRootQualityManualUuid(UUID.randomUUID());
        taskExecutionImportedEventPayload.setShiftEnd(OffsetDateTime.now().plus(2, ChronoUnit.HOURS));
        taskExecutionImportedEventPayload.setShiftStart(OffsetDateTime.now().minus(1L, ChronoUnit.HOURS));
        taskExecutionImportedEventPayload.setTenantUuid(UUID.randomUUID());
        taskExecutionImportedEventPayload.setTimestampStart(OffsetDateTime.now());
        taskExecutionImportedEventPayload.setViolationLevelAggregated(ViolationLevelType.okplusca);

        when(taskExecutionConverterService.getTaskExecution(taskExecutionUuid)).thenReturn(taskExecutionImportedEventPayload);

        Request request = new Request();
        request.setTaskExecutionUuid(taskExecutionUuid);

        ResponseEntity<TaskExecutionImportedEventPayload> response = taskExecutionConverterController.getTaskExecutionEventPayloadFor(request);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getUuid(), is(request.getTaskExecutionUuid()));
    }
}
