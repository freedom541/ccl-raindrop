package com.ccl.filter;

import com.ccl.annotation.TestLogger;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
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
@TestLogger
@Priority(Priorities.USER)
public class LoggerAnnotationFilter implements ContainerRequestFilter,ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("AnnotationFilter--访问请求日志过滤器执行了<<<<<<<<<<<");
    }
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        System.out.println("AnnotationFilter--访问响应日志过滤器执行了>>>>>>>>>>>");
    }
}
