var aws = require('aws-sdk');
var sfn = new aws.StepFunctions();

exports.handler = function(event, context, callback) {
    console.log("event:\n", event);

    const {StateMachineArn, input} = event;
    input.numberOfProcessedTaksExecutions = 0;

    let params = {
        input: JSON.stringify(input),
        stateMachineArn: StateMachineArn
    };

    sfn.startExecution(params, function(err, data) {
        if (err) callback(err);
        else callback(null,event);
    });

}
