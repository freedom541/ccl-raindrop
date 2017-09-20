package com.ccl.rain.client;

import com.ccl.rain.annotation.RemotingFace;
import com.ccl.rain.common.Configs;
import com.ccl.rain.netty.client.RPCClient;
import com.ccl.rain.netty.utils.classscan.ClassScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.util.Set;

/**
 * Created by ccl on 17/8/31.
 */
public class RemotingFaceRegistry implements BeanDefinitionRegistryPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(RemotingFaceRegistry.class);
    private RPCClient rpcClient;
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        logger.info("<><><><><><><><> postProcessBeanDefinitionRegistry();");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("<><><><><><><><> postProcessBeanFactory();");
        //Set<Class<?>> remoteServiceTypes = AnnotationScan.scanClasspath("com.ccl", RemotingFace.class);
        ClassScanner scanner = new ClassScanner();
        Set<Class<?>> remotingfacetypes = scanner.scan(new String[] {"com.ccl"}, RemotingFace.class);

        rpcClient = new RPCClient(Configs.getString("zookeeper.server.host"), remotingfacetypes);
        for (Class<?> remoteService : remotingfacetypes) {
            if (remoteService.isInterface() && !containsBean(beanFactory, remoteService)) {
                String beanName = getBeanName(remoteService.getSimpleName());
                Object instance = getRemoteServiceInstance(remoteService);
                if (instance == null){
                    throw new RuntimeException(remoteService.getName() + " not found.");
                }
                beanFactory.registerSingleton(beanName, instance);
                logger.info("<><><><><><><><> registy class : " + remoteService.getName());
            }
        }
    }

    private boolean containsBean(ConfigurableListableBeanFactory beanFactory, Class beanType) {
        try {
            if (beanFactory.getBeanNamesForType(beanType).length > 0) {
                return true;
            }
        } catch (BeansException e) {
        }
        return false;
    }

    //首字母小写
    private String getBeanName(String remoteService) {
        return Character.toLowerCase(remoteService.charAt(0)) + remoteService.substring(1);
    }

    //使用cglib实现远程接口
    private Object getRemoteServiceInstance(Class remoteServiceClass) {
        return rpcClient.createProxy(remoteServiceClass);
    }
}
