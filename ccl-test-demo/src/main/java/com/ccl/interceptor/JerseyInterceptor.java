package com.ccl.interceptor;

import org.aopalliance.intercept.ConstructorInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.glassfish.hk2.api.Descriptor;
import org.glassfish.hk2.api.Filter;
import org.glassfish.hk2.api.InterceptionService;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ccl on 17/9/15.
 * 方法拦截器
 */
public class JerseyInterceptor implements InterceptionService {
    private static Map<Annotation, MethodInterceptor> map = new HashMap<>();
    static{
        Annotation[] annotations = LoginTestMethodInterceptor.class.getAnnotations();
        for(Annotation annotation : annotations){
            map.put(annotation, new LoginTestMethodInterceptor());
        }
    }
    @Override
    public Filter getDescriptorFilter() {
        return new Filter() {
            public boolean matches(Descriptor descriptor) {
                return true;
            }
        };
    }
    @Override
    public List<MethodInterceptor> getMethodInterceptors(Method method) {
        Annotation[] annotations = method.getAnnotations();
        List<MethodInterceptor> list = new ArrayList<>();
        for (Annotation annotation :annotations){
            if(map.get(annotation) != null){
                list.add(map.get(annotation));
            }
        }
        return list;
    }
    @Override
    public List<ConstructorInterceptor> getConstructorInterceptors(Constructor<?> constructor) {
        return null;
    }
}
