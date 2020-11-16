const AWS = require('aws-sdk');
const iam = new AWS.IAM({apiVersion: '2010-05-08'});
const lambda = new AWS.Lambda({apiVersion: '2015-03-31'});
const cfnresponse = require('cfnresponse');

exports.handler = async function(event, context) {
    console.log("event: ", event);
    const physicalID = event.PhysicalResourceId || "ApplyRestartPolicy-" + Math.random();
    const {ResourceProperties = {}} = event;
    const functionArn = ResourceProperties.FunctionArn;
    const statemachineArn = ResourceProperties.StatemachineArn;
    if (event.RequestType != 'Delete') { //check if this handles Update correctly

        var functionParams = {
            FunctionName: functionArn,
        };
        console.log("functionParams", functionParams);
        const func = await lambda.getFunction(functionParams).promise();
        console.log("function:", func);

        const roleArn = func.Configuration.Role;
        const resource = roleArn.split(":").pop();
        const roleName = resource.split("/").pop();

        console.log("role:", roleName);

        const policyDocument = {
            "Version": "2012-10-17",
            "Statement": [
                {
                    "Sid": "restartStatemachine",
                    "Effect": "Allow",
                    "Action": "states:StartExecution",
                    "Resource": statemachineArn
                }
            ]
        };

        var rolePutParams = {
            PolicyDocument: JSON.stringify(policyDocument),
            PolicyName: "AllowStartExecution",
            RoleName: roleName
        };
        console.log("putPolicyParams:", rolePutParams);
        const createdPolicy = await iam.putRolePolicy(rolePutParams).promise();
        physicalID: "" + Math.random();


    }
    await cfnresponse.send(event, context, cfnresponse.SUCCESS, {"hallo": "fertig"}, physicalID);
}
