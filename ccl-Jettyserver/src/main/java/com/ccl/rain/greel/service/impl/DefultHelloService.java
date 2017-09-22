package com.ccl.rain.greel.service.impl;

import com.ccl.rain.annotation.RemotingService;
import com.ccl.rain.greel.service.HelloService;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by ccl on 17/8/30.
 */
@RemotingService(HelloService.class)
public class DefultHelloService implements HelloService {
    @Value("${worker.name}")
    private String workname;
    @Override
    public String say(String name) {
        return "Hello " + name + ", connect " + workname + " ok.";
    }
}
