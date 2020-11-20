package taskExecutionConverter.model;

/*
a request has this format:
{
  "taskExecutionUuid": "DEADBEEF-0000-0000-0000-000000000000",
}

 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    private UUID taskExecutionUuid;

    public UUID getTaskExecutionUuid() {
        return taskExecutionUuid;
    }

    public void setTaskExecutionUuid(UUID taskExecutionUuid) {
        this.taskExecutionUuid = taskExecutionUuid;
    }
}
