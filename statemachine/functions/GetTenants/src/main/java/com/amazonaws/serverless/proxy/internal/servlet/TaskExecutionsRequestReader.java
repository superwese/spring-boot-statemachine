package com.amazonaws.serverless.proxy.internal.servlet;

import com.amazonaws.serverless.proxy.RequestReader;
import com.amazonaws.serverless.proxy.model.ContainerConfig;
import com.amazonaws.services.lambda.runtime.Context;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.SecurityContext;

public class TaskExecutionsRequestReader extends RequestReader<LambdaProxyRequest, HttpServletRequest> {
    @Override
    public HttpServletRequest readRequest(LambdaProxyRequest proxyRequest, SecurityContext securityContext, Context lambdaContext, ContainerConfig config) {

        return proxyRequest;
    }

    @Override
    protected Class<? extends LambdaProxyRequest> getRequestClass() {
        return LambdaProxyRequest.class;
    }
}
