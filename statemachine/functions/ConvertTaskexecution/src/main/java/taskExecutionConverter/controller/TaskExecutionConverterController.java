package taskExecutionConverter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import taskExecutionConverter.model.Request;
import taskExecutionConverter.model.TaskExecutionImportedEventPayload;
import taskExecutionConverter.service.TaskExecutionConverterService;

@RestController
@EnableWebMvc
public class TaskExecutionConverterController {

    private TaskExecutionConverterService taskExecutionConverterService;

    public TaskExecutionConverterController(TaskExecutionConverterService taskExecutionConverterService) {
        this.taskExecutionConverterService = taskExecutionConverterService;
    }

    @RequestMapping("*")
    public ResponseEntity<TaskExecutionImportedEventPayload> getTaskExecutionEventPayloadFor(@RequestBody Request request) {
        TaskExecutionImportedEventPayload taskExecutionImportedEventPayload = taskExecutionConverterService.getTaskExecution(request.getTaskExecutionUuid());

        return ResponseEntity.ok(taskExecutionImportedEventPayload);
    }
}
