package com.ccl.rain.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by ccl on 17/8/29.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RemotingFace {
}
