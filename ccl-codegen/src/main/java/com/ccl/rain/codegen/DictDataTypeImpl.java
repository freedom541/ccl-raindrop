package com.ccl.rain.codegen;

import java.lang.annotation.Annotation;

/**
 * @author ccl
 * @date 2017/8/27.
 */
public class DictDataTypeImpl implements DictDataType {

    Class<? extends Enum> value;

    public DictDataTypeImpl(Class<? extends Enum> value) {
        this.value = value;
    }

    @Override
    public Class<? extends Enum> value() {
        return value;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return DictDataType.class;
    }
}
