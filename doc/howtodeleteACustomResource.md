# How to delete a custom resource, when your Cf Stack is stuck in `update` state

get the delete request from your cloudwatch logs (usually the last one)
looks like (that's why it makes sense to log the incoming request)
```
{
  RequestType: 'Delete',
  ServiceToken: 'arn:aws:lambda:eu-central-1:832077700054:function:createTaskexecutionEvents-ApplyRestartPolicyFuncti-150JNXNS00GJ3',
  ResponseURL: 'https://cloudformation-custom-resource-response-eucentral1.s3.eu-central-1.amazonaws.com/arn%3Aaws%3Acloudformation%3Aeu-central-1%3A832077700054%3Astack/createTaskexecutionEvents/6fc50720-25af-11eb-9abc-0ab7fff4b680%7CApplyRestartPolicy%7Ccff374ea-4675-4806-bc4a-35ad9ba021d9?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20201113T164409Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Credential=AKIAYYGVRKE7KNEAWUMW%2F20201113%2Feu-central-1%2Fs3%2Faws4_request&X-Amz-Signature=3524cc75905cfb6a995d15c37dbf0f30884842d8b33a9d7b3c840c07a474816e',
  StackId: 'arn:aws:cloudformation:eu-central-1:832077700054:stack/createTaskexecutionEvents/6fc50720-25af-11eb-9abc-0ab7fff4b680',
  RequestId: 'cff374ea-4675-4806-bc4a-35ad9ba021d9',
  LogicalResourceId: 'ApplyRestartPolicy',
  PhysicalResourceId: 'createTaskexecutionEvents-ApplyRestartPolicy-1UBTGBA7OJXE2',
  ResourceType: 'Custom::ApplyRestartPolicy',
  ResourceProperties: {
    ServiceToken: 'arn:aws:lambda:eu-central-1:832077700054:function:createTaskexecutionEvents-ApplyRestartPolicyFuncti-150JNXNS00GJ3',
    FunctionArn: 'arn:aws:lambda:eu-central-1:832077700054:function:createTaskexecutionEvents-RestartFunction-CH2DPALGQVAS',
    StatemachineArn: 'EventCreatorStateMachine-sTFEROerODmO'
  }
}
```

make a curl request:
```
curl -H 'Content-Type: ''' -X PUT -d '{
    "Status": "SUCCESS",
    "PhysicalResourceId": "ApplyRestartPolicy",
    "StackId": "arn:aws:cloudformation:eu-central-1:832077700054:stack/createTaskexecutionEvents/6fc50720-25af-11eb-9abc-0ab7fff4b680",
    "RequestId": "cff374ea-4675-4806-bc4a-35ad9ba021d9",
    "LogicalResourceId": "ApplyRestartPolicy"
  }' 'https://cloudformation-custom-resource-response-eucentral1.s3.eu-central-1.amazonaws.com/arn%3Aaws%3Acloudformation%3Aeu-central-1%3A832077700054%3Astack/createTaskexecutionEvents/6fc50720-25af-11eb-9abc-0ab7fff4b680%7CApplyRestartPolicy%7Ccff374ea-4675-4806-bc4a-35ad9ba021d9?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20201113T164409Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Credential=AKIAYYGVRKE7KNEAWUMW%2F20201113%2Feu-central-1%2Fs3%2Faws4_request&X-Amz-Signature=3524cc75905cfb6a995d15c37dbf0f30884842d8b33a9d7b3c840c07a474816e'
```

https://aws.amazon.com/de/premiumsupport/knowledge-center/cloudformation-lambda-resource-delete/
