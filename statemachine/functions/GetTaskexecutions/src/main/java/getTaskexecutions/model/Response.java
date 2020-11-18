package getTaskexecutions.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private int page;
    private boolean last;
    private List<UUID> content;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public List<UUID> getContent() {
        return content;
    }

    public void setContent(List<UUID> content) {
        this.content = content;
    }

    public boolean addAll(Collection<UUID> part) {
        return content.addAll(part);
    }

    public boolean addOne(UUID item) {
        return content.add(item);
    }
}
