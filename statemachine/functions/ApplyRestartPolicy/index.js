var aws = require('aws-sdk');
var sfn = new aws.StepFunctions();

const AWS = require('aws-sdk')
const lambda = new AWS.Lambda({apiVersion: '2015-03-31'});
const response = require('cfnresponse');

exports.handler = async function(event, context) {
    console.log("event: ", event);
    const physicalID = event.PhysicalResourceId || "ApplyRestartPolicy-" + Math.random();
    const { ResourceProperties = {} } = event;
    const functionArn = ResourceProperties.FunctionArn;
    const statemachineArn = ResourceProperties.StateMachineArn ;
    if (event.RequestType != 'Delete') { //check if this handles Update correctly

        var functionParams = {
            FunctionName: functionArn,
        };
        console.log("functionParams", functionParams);
        const func =  await lambda.getFunction(functionParams).promise();
        const role = func.Role
        console.log("function:", func);
/*
        - get Role from lamda
        - createPolicy:
        {
            "Version": "2012-10-17",
            "Statement": [
            {
                "Sid": "VisualEditor0",
                "Effect": "Allow",
                "Action": "states:StartExecution",
                "Resource": "arn:aws:states:*:832077700054:stateMachine:*" $stateMachineArn
            }
        ]
        }
        returns policy.arn
        - attach the policy that allows startExecution for this statemachine to that role:
            var roleParams = {
                PolicyArn: 'arn:aws:iam::aws:policy/AmazonDynamoDBFullAccess',
                RoleName: process.argv[2]
            };
        iam.attachRolePolicy(roleParams, function(err, data) {
            if (err) {
                console.log("Unable to attach policy to role", err);
            } else {
                console.log("Role attached successfully");
            }
        });
        physicalID: "" + Math.random();

 */
    }
    return response.send(event, context, response.SUCCESS, {"hallo": "fertig"}, physicalID );
}
