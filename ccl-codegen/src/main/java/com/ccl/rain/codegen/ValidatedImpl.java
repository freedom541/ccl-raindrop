package com.ccl.rain.codegen;

import org.springframework.validation.annotation.Validated;

import java.lang.annotation.Annotation;

/**
 * @author ccl
 * @date 2017/8/27.
 */
public class ValidatedImpl implements Validated {

    private Class<?>[] group;

    public ValidatedImpl(Class<?>[] group) {
        this.group = group;
    }

    @Override
    public Class<?>[] value() {
        return group;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return Validated.class;
    }
}
