package com.ccl.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by ccl on 17/9/15.
 */
@Provider
public class LoggerFilter implements ContainerRequestFilter,ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("NOFilter--访问请求日志过滤器执行了<<<<<<<<<<<");
    }
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        System.out.println("NOFilter--访问响应日志过滤器执行了>>>>>>>>>>>");
    }
}
