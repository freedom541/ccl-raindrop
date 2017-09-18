package com.ccl.annotation;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ccl on 17/9/15.
 */
@NameBinding            //标识名称绑定的注解
@Target({ElementType.TYPE, ElementType.METHOD})  //表示该注解可以使用在类和方法上。
@Retention(value = RetentionPolicy.RUNTIME)
public @interface TestLogger {
}
