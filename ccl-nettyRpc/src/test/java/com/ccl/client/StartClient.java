package com.ccl.client;

import com.ccl.rain.annotation.RemotingFace;
import com.ccl.rain.netty.client.RPCClient;
import com.ccl.rain.netty.utils.classscan.AnnotationScan;
import com.ccl.rain.greel.service.*;

import java.util.Set;

/**
 * Created by ccl on 17/8/30.
 */
public class StartClient {
    public static void main(String[] args) {
        Set<Class<?>> classes = AnnotationScan.scanClasspath("com.ccl", RemotingFace.class);
        System.out.println(classes);
        System.out.println("===================================");

        RPCClient rpcClient = new RPCClient("127.0.0.1:2181", classes);
        HelloService service = rpcClient.createProxy(HelloService.class);
        System.out.println("result:" + service.say());
        rpcClient.stop();
    }

}
