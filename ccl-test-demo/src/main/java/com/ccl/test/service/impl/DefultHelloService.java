package com.ccl.test.service.impl;

import com.ccl.test.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by ccl on 17/8/29.
 */
@Service
public class DefultHelloService implements HelloService {
    public String say() {
        return "ni hao !";
    }
}
