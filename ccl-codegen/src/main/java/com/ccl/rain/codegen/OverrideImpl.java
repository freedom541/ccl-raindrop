package com.ccl.rain.codegen;

import java.lang.annotation.Annotation;

/**
 * @author ccl
 * @date 2017/8/27.
 */
public class OverrideImpl implements Override {
    @Override
    public Class<? extends Annotation> annotationType() {
        return Override.class;
    }
}
