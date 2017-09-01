package com.ccl.rain.netty.client;

import com.ccl.rain.netty.manage.ConnectManage;
import com.ccl.rain.netty.proxy.AsyncRPCProxy;
import com.ccl.rain.netty.proxy.RPCProxy;
import com.ccl.rain.netty.registry.ServiceDiscovery;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ccl
 */
public class RPCClient {

    private ServiceDiscovery serviceDiscovery;

    public RPCClient(String zookeeper, List<String> interfaces) {
        this.serviceDiscovery = new ServiceDiscovery(zookeeper, interfaces);
    }
    public RPCClient(String zookeeper, Set<Class<?>> classes) {
        List<String> interfaces = classes.stream().map(c->c.getName()).collect(Collectors.toList());
        this.serviceDiscovery = new ServiceDiscovery(zookeeper, interfaces);
    }

    /**
     * 创建用于同步调用的代理对象
     *
     * @param interfaceClass
     * @param <T>
     * @return
     */
    public static <T> T createProxy(Class<T> interfaceClass) {
        // 创建动态代理对象
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class<?>[]{interfaceClass},new RPCProxy<T>(interfaceClass));
    }
    /**
     * 创建用于异步调用的代理对象
     *
     * @param interfaceClass
     * @param <T>
     * @return
     */
    public static <T> AsyncRPCProxy createAsyncProxy(Class<T> interfaceClass) {
        return new AsyncRPCProxy<T>(interfaceClass);
    }


    public void stop() {
        serviceDiscovery.stop();
        ConnectManage.getInstance().stop();
    }

}
