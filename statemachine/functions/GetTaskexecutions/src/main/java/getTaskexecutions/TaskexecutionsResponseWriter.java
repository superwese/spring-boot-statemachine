package getTaskexecutions;

import com.amazonaws.serverless.proxy.ResponseWriter;
import com.amazonaws.serverless.proxy.internal.servlet.AwsHttpServletResponse;
import com.amazonaws.services.lambda.runtime.Context;
import getTaskexecutions.model.Response;

public class TaskexecutionsResponseWriter extends ResponseWriter<AwsHttpServletResponse, Response> {
    @Override
    public Response writeResponse(AwsHttpServletResponse containerResponse, Context lambdaContext) {
        //implement me
        return null;
    }
}
