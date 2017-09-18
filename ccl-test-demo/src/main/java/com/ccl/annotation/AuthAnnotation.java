package com.ccl.annotation;

import java.lang.annotation.*;

/**
 * Created by ccl on 17/9/15.
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthAnnotation {
}
