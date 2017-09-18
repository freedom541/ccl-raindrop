package com.ccl.filter;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

/**
 * Created by ccl on 17/9/15.
 */
public class LoggerDynaimcFeature implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        String name = resourceInfo.getResourceMethod().getName();
        System.out.println(name);
        if("mthod".equals(name)){
            context.register(LoggerFilter.class);
        }

    }
}
