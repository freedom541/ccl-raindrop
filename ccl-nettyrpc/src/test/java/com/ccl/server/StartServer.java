package com.ccl.server;

import com.ccl.rain.netty.server.RPCServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Created by ccl on 17/8/30.
 */
public class StartServer {
    public static void main(String[] args) throws Exception {
        RPCServer server = new RPCServer("127.0.0.1:2888","127.0.0.1:2181");
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringParam.class);
        ctx.refresh();
        server.setApplicationContext(ctx);
        server.afterPropertiesSet();
    }




    @Configuration
    @ComponentScan("com.ccl.rain.greel.service")
    //@ImportResource({"classpath*:META-INF/spring/*.xml"})
    public static class SpringParam{

    }
}
