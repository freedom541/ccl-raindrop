package com.ccl.rain.server;

/**
 * Created by ccl on 17/8/14.
 */

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;


public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("com.ccl");
        //打开日志,便于调试
        register(LoggingFilter.class);
        register(RequestContextFilter.class);
        //注册数据转换器
        register(JacksonFeature.class);
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
        System.out.println(this.getClass().getName() + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
