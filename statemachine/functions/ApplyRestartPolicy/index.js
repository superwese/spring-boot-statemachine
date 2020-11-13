var aws = require('aws-sdk');
var sfn = new aws.StepFunctions();

const AWS = require('aws-sdk')
const lambda = new AWS.Lambda({apiVersion: '2015-03-31'});
const response = require('cfnresponse');

exports.handler = function(event, context) {
    console.log("event: ", event);
    const functionArn = event.ResourceProperties.functionArn;
    const statemachineArn = event.ResourceProperties.stateMachineArn ;
    if (event.RequestType != 'Delete') { //check if this handles Update correctly
/*
        var params = {
            FunctionName: "ContextTest",
            Qualifier: "Dings"
        };
        const func = await lambda.getFunction(params).promise();
        const role = func.Role
        console.log("policy:", func);

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

 */
    }
    response.send(event, context, response.SUCCESS, {"hallo": "fertig"});
}
