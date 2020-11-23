package taskExecutionConverter.application;

import com.amazonaws.serverless.proxy.internal.servlet.StreamLambdaHandler;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import taskExecutionConverter.model.Request;
import taskExecutionConverter.model.TaskExecutionImportedEventPayload;
import taskExecutionConverter.model.ViolationLevelType;
import taskExecutionConverter.service.TaskExecutionConverterService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles({"test"})
public class TaskExecutionConverterApplicationTest {

    @Mock
    private TaskExecutionConverterService taskExecutionConverterService;

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());
    private final static MockLambdaContext context = new MockLambdaContext();

    @Test
    public void testApp() throws IOException {
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
        request.setTaskExecutionUuid(UUID.randomUUID());

        InputStream inputStream = new ByteArrayInputStream(objectMapper.writeValueAsBytes(request));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StreamLambdaHandler handler = new StreamLambdaHandler();
        handler.handleRequest(inputStream, outputStream, context);

        TaskExecutionImportedEventPayload response = objectMapper.readValue(outputStream.toByteArray(), TaskExecutionImportedEventPayload.class);

        assertThat(request.getTaskExecutionUuid(), is(response.getUuid()));
    }
}
