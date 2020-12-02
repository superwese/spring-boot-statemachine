package taskExecutionConverter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ObjectMapper objectMapper;

    private TaskExecutionConverterService taskExecutionConverterService;

    public TaskExecutionConverterController(TaskExecutionConverterService taskExecutionConverterService) {
        this.taskExecutionConverterService = taskExecutionConverterService;
    }

    @RequestMapping("*")
    public ResponseEntity<String> getTaskExecutionEventPayloadFor(@RequestBody Request request) throws JsonProcessingException {
        TaskExecutionImportedEventPayload taskExecutionImportedEventPayload = taskExecutionConverterService.getTaskExecution(request.getTaskExecutionUuid());

        return ResponseEntity.ok(objectMapper.writeValueAsString(taskExecutionImportedEventPayload));
    }
}
