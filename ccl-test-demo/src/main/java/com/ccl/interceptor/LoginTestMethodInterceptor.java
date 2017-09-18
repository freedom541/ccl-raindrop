package com.ccl.interceptor;

import com.ccl.annotation.LoginTest;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by ccl on 17/9/15.
 */
@LoginTest
public class LoginTestMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return "没有权限访问";
    }
}
