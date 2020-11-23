package taskExecutionConverter.service;

import org.springframework.stereotype.Service;
import taskExecutionConverter.model.TaskExecutionImportedEventPayload;
import taskExecutionConverter.repository.SampleDataRepository;
import taskExecutionConverter.repository.model.TaskExecutionImportedEventEntity;

import java.util.UUID;

@Service
public class TaskExecutionConverterService {

    private SampleDataRepository sampleDataRepository;

    public TaskExecutionConverterService(SampleDataRepository sampleDataRepository) {
        this.sampleDataRepository = sampleDataRepository;
    }

    public TaskExecutionImportedEventPayload getTaskExecution(UUID taskExecutionUuid) {
        TaskExecutionImportedEventEntity taskExecutionImportedEventEntity = sampleDataRepository.findByTaskUuid(taskExecutionUuid).get();

        return TaskExecutionImportedEventPayload.fromTaskExecutionImportedEventEntity(taskExecutionImportedEventEntity);
    }
}
