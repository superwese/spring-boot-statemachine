var aws = require('aws-sdk');
var sfn = new aws.StepFunctions();

exports.handler = function(event, context, callback) {

    const StateMachineArn = event.restart.StateMachineArn;
    event.numberOfProcessedTaksExecutions = 0;
    event = JSON.stringify(event);

    let params = {
        input: event,
        stateMachineArn: StateMachineArn
    };

    sfn.startExecution(params, function(err, data) {
        if (err) callback(err);
        else callback(null,event);
    });

}
