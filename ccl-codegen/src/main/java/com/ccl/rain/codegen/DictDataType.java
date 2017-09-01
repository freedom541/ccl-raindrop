package com.ccl.rain.codegen;

import java.lang.annotation.*;

/**
 * @author ccl
 * @date 2017/8/27.
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DictDataType {
    Class<? extends Enum> value();
}
