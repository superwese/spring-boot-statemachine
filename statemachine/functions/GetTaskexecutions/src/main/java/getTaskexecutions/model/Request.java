package getTaskexecutions.model;

/*
a request has this format:
{
  "tenantUuid": "DEADBEEF-0000-0000-0000-000000000000",
  "startDate": "2016-10-01T00:00:00Z",
  "enddate": "2016-10-01T00:00:00Z",
  "page": 0

}

 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    private List<UUID> tenantUuids;
    private Instant startDate;
    private Instant endDate;
    private int page;

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<UUID> getTenantUuids() {
        return tenantUuids;
    }

    public void setTenantUuids(List<UUID> tenantUuids) {
        this.tenantUuids = tenantUuids;
    }
}
