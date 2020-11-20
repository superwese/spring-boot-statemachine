package com.amazonaws.serverless.proxy.internal.servlet;

import com.amazonaws.serverless.proxy.ResponseWriter;
import com.amazonaws.services.lambda.runtime.Context;

public class TaskExecutionsResponseWriter extends ResponseWriter<AwsHttpServletResponse, AwsHttpServletResponse> {
    @Override
    public AwsHttpServletResponse writeResponse(AwsHttpServletResponse containerResponse, Context lambdaContext) {
        //implement me
        return containerResponse;
    }
}
