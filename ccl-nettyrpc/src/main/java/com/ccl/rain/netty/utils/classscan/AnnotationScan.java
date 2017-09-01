package com.ccl.rain.netty.utils.classscan;

/**
 * Created by ccl on 17/8/24.
 */

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 注解扫描方便类，用于从jar或者classpath中扫描使用了特定注解的类
 *
 */
public class AnnotationScan {
    /**
     * 从URL地址中扫描使用了特定注解的类
     *
     * @param classLoaders
     * @param basePackage
     * @param annotation
     * @param urls
     * @return
     */
    public static Set<Class<?>> scanURL(ClassLoader[] classLoaders, String basePackage, Class<? extends Annotation> annotation, URL... urls) {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(basePackage)));
        if (classLoaders != null) {
            for (ClassLoader classLoader : classLoaders) {
                configurationBuilder.addClassLoader(classLoader);
            }
        }
        List<URL> urlList = new ArrayList<URL>();
        if (urls != null) {
            for (int i = 0; i < urls.length; i++) {
                urlList.add(urls[i]);
            }
        }
        configurationBuilder.addUrls(urlList);
        Reflections reflections = new Reflections(configurationBuilder);
        Set<Class<?>> annotations = reflections.getTypesAnnotatedWith(annotation);
        return annotations;
    }

    /**
     * 从classpath中扫描使用了特定注解的类
     *
     * @param basePackage
     * @param annotation
     * @return
     */
    public static Set<Class<?>> scanClasspath(String basePackage, Class<? extends Annotation> annotation) {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(basePackage)));
        Collection<URL> forPackage = ClasspathHelper.forPackage(basePackage);
        configurationBuilder.addUrls(forPackage);
        Reflections reflections = new Reflections(configurationBuilder);
        Set<Class<?>> annotations = reflections.getTypesAnnotatedWith(annotation);
        return annotations;
    }

    /**
     * 从classpath中扫描使用了特定注解的方法
     *
     * @param basePackage
     * @param annotation
     * @return
     */
    public static Set<Method> scanClasspathWithMethod(String basePackage, Class<? extends Annotation> annotation) {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(basePackage)));
        Collection<URL> forPackage = ClasspathHelper.forPackage(basePackage);
        configurationBuilder.addUrls(forPackage);
        configurationBuilder.setScanners(new MethodAnnotationsScanner());
        Reflections reflections = new Reflections(configurationBuilder);
        Set<Method> methodsAnnotatedWith = reflections.getMethodsAnnotatedWith(annotation);
        return methodsAnnotatedWith;
    }

    /**
     * 从classpath中扫描使用了特定注解的方法
     *
     * @param basePackage
     * @param annotation
     * @return
     */
    public static Set<Field> scanClasspathWithField(String basePackage, Class<? extends Annotation> annotation) {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(basePackage)));
        Collection<URL> forPackage = ClasspathHelper.forPackage(basePackage);
        configurationBuilder.addUrls(forPackage);
        configurationBuilder.setScanners(new FieldAnnotationsScanner());
        Reflections reflections = new Reflections(configurationBuilder);
        Set<Field> annotatedWith = reflections.getFieldsAnnotatedWith(annotation);
        return annotatedWith;
    }

    public static void main(String[] args) {
        AnnotationScan.scanClasspath("", null);
    }
}
