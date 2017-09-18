package com.ccl.filter;

import com.ccl.annotation.AuthAnnotation;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccl on 17/9/15.
 */
@Provider
public class AuthorizationFilterFeature implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {

        List<Annotation> authzSpecs = new ArrayList<>();

        Annotation classAuthzSpec =
                resourceInfo.getResourceClass().getAnnotation(AuthAnnotation.class);
        Annotation methodAuthzSpec =
                resourceInfo.getResourceMethod().getAnnotation(AuthAnnotation.class);

        if (classAuthzSpec != null)
            authzSpecs.add(classAuthzSpec);
        if (methodAuthzSpec != null)
            authzSpecs.add(methodAuthzSpec);

        if (!authzSpecs.isEmpty()) {
            // 需要拦截的api
            context.register(LoggerFilter.class);
        }
    }
}