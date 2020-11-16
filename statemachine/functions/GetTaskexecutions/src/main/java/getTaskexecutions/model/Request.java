package getTaskexecutions.model;

/*
a request has this format:
{
  "tenantUuid": "DEADBEEF-0000-0000-0000-000000000000",
  "startDate": "2016-10-01T00:00:00Z",
  "enddate": "2016-10-01T00:00:00Z",
  "page": 0,
  "restart": {
    "StateMachineArn": "arn:any:where",
    "maxExecutionCount": 5000,
    "numberOfProcessedTaksExecutions": 0
  }

}

 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    private UUID tenantUuid;
    private Instant startDate;
    private Instant endDate;
    private int page;

}
