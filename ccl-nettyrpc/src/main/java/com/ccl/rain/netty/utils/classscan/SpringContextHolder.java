package com.ccl.rain.netty.utils.classscan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by ccl on 17/8/23.
 */
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;
    private static BeanDefinitionRegistry beanDefinitonRegistry;

    public static ApplicationContext getApplicationContext() {
        return context;
    }
    public static Object getBean(String name){
        return context.getBean(name);
    }
    public static <T> T getBean(Class<T> clz){
        return context.getBean(clz);
    }
    public static <T> T getBean(String name , Class<T> clz){
        return context.getBean(name, clz);
    }
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        context = ac;
        //DefaultListableBeanFactory acf = (DefaultListableBeanFactory) app.getAutowireCapableBeanFactory();
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) context;
        beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();
    }
    /**
     * 动态注册bean
     * @param beanName
     * @param beanDefinition
     */
    public synchronized static void registerBean(String beanName, BeanDefinition beanDefinition){
        //DefaultListableBeanFactory beanDefinitonRegistry = (DefaultListableBeanFactory) app.getAutowireCapableBeanFactory();
        if(!beanDefinitonRegistry.containsBeanDefinition(beanName)){
            beanDefinitonRegistry.registerBeanDefinition(beanName, beanDefinition);
        }
    }
    public static void registerBean(BeanDefinition beanDefinition){
        //DefaultListableBeanFactory beanDefinitonRegistry = (DefaultListableBeanFactory) app.getAutowireCapableBeanFactory();
        String simpleNameString=beanDefinition.getBeanClassName();
        if(simpleNameString.contains(".")){
            simpleNameString=simpleNameString.substring(simpleNameString.lastIndexOf(".")+1);
        }
        //simpleNameString=StringUtil.lowerFirstChar(simpleNameString);
        registerBean(simpleNameString,beanDefinition);
    }
    public static BeanDefinitionBuilder getBeanDefinitionBuilder(Class clazz){
        return BeanDefinitionBuilder.genericBeanDefinition(clazz);
    }

}
