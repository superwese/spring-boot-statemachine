package taskExecutionConverter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import taskExecutionConverter.model.TaskExecutionImportedEventPayload;
import taskExecutionConverter.repository.SampleDataRepository;
import taskExecutionConverter.repository.model.TaskExecutionImportedEventEntity;

import java.util.UUID;

@Service
public class TaskExecutionConverterService {

    private static final Logger LOG = LoggerFactory.getLogger(TaskExecutionConverterService.class);
    private SampleDataRepository sampleDataRepository;

    public TaskExecutionConverterService(SampleDataRepository sampleDataRepository) {
        this.sampleDataRepository = sampleDataRepository;
    }

    public TaskExecutionImportedEventPayload getTaskExecution(UUID taskExecutionUuid) {
        TaskExecutionImportedEventEntity taskExecutionImportedEventEntity =
                sampleDataRepository
                        .findByUuid(taskExecutionUuid)
                        .orElseThrow( () -> new RuntimeException("Can't find TaskExecution " + taskExecutionUuid));

        final TaskExecutionImportedEventPayload taskExecutionImportedEventPayload = TaskExecutionImportedEventPayload.fromTaskExecutionImportedEventEntity(taskExecutionImportedEventEntity);

        LOG.info("Converting {} to {}",
                taskExecutionImportedEventEntity.toString(),
                taskExecutionImportedEventPayload.toString()
        );

        return taskExecutionImportedEventPayload;
    }
}
