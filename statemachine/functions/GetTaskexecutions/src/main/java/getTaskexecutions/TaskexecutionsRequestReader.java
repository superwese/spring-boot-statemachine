package getTaskexecutions;

import com.amazonaws.serverless.proxy.RequestReader;
import com.amazonaws.serverless.proxy.internal.servlet.AwsProxyHttpServletRequest;
import com.amazonaws.serverless.proxy.model.ContainerConfig;
import com.amazonaws.services.lambda.runtime.Context;
import getTaskexecutions.model.Request;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.SecurityContext;

public class TaskexecutionsRequestReader extends RequestReader<Request, HttpServletRequest> {
    @Override
    public AwsProxyHttpServletRequest readRequest(Request request, SecurityContext securityContext, Context lambdaContext, ContainerConfig config) {
        //implement me
        return null;
    }

    @Override
    protected Class<? extends Request> getRequestClass() {
        return Request.class;
    }
}
