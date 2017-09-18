package com.ccl.interceptor;

import org.glassfish.hk2.api.InterceptionService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

/**
 * Created by ccl on 17/9/15.
 */
public class JerseyBinding extends AbstractBinder {
    @Override
    protected void configure() {
        this.bind(JerseyInterceptor.class).to(InterceptionService.class).in(Singleton.class);
    }
}
