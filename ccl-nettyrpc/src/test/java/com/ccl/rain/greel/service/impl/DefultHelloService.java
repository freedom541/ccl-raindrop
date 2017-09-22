package com.ccl.rain.greel.service.impl;

import com.ccl.rain.annotation.RemotingService;
import com.ccl.rain.greel.service.HelloService;

/**
 * Created by ccl on 17/8/30.
 */
@RemotingService(HelloService.class)
public class DefultHelloService implements HelloService {
    @Override
    public String say() {
        return "hello.";
    }
}
