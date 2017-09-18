package com.ccl.interceptor;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Created by ccl on 17/9/15.
 */
public class JerseyFeature implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
        context.register(new JerseyBinding());
        return true;
    }
}
