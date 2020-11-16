package getTaskexecutions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private int page;
    private boolean last;
    private List<UUID> content;
}
