# task-execution-migration

Project to migrate task executions

## Usage
### Start a statemachine
* Go to AWS Console Stepfunctions
* select the state machine according your needs:
    they are named `EventCreatorStateMachine-${Stage}-Express`
    the stage corresponds to the SNS-Topic the state machine publishes the events to.
* Click `start execution`
* provide something like 
```json 
    {
      "tenantUuid": "15512d8f-dcd2-4ffe-bfd9-1a2080429120",
      "startDate": "2019-04-26T12:00:00Z",
      "endDate": "2019-04-27T00:00:00Z",
      "page": 0
    }
```
as the input.
### Monitoring
* Use the State Machine's Monitoring tab
* have a look at the SQS queue the that is subscribed to the topic your are publishing to.
* follow the executions in CW insight. There is a **saved** Query in the *createTaskExecutionsEvent* folder



