package taskExecutionConverter.model;

/*
a request has this format:
{
  "taskExecutionUuid": "DEADBEEF-0000-0000-0000-000000000000",
}

 */

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    @JsonProperty("uuid")
    private UUID taskExecutionUuid;
    @JsonGetter("uuid")
    public UUID getTaskExecutionUuid() {
        return taskExecutionUuid;
    }
    @JsonSetter("uuid")
    public void setTaskExecutionUuid(UUID taskExecutionUuid) {
        this.taskExecutionUuid = taskExecutionUuid;
    }
}
