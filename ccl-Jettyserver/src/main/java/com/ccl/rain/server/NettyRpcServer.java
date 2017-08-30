package com.ccl.rain.server;

import com.ccl.rain.netty.server.RPCServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Created by ccl on 17/8/29.
 */
public class NettyRpcServer {
    private static final Logger logger = LoggerFactory.getLogger(NettyRpcServer.class);
    private String zookeeperAddr = "127.0.0.1:2181";
    private String rpcAddr = "127.0.0.1:2888";

    public NettyRpcServer(String zookeeperAddr, String rpcAddr) {
        this.zookeeperAddr = zookeeperAddr;
        this.rpcAddr = rpcAddr;
    }

    public NettyRpcServer() {
    }

    public void start() throws Exception {
        RPCServer server = new RPCServer(rpcAddr, zookeeperAddr);
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebJettyServer.SpringRootConfiguration.class);
        ctx.refresh();
        server.setApplicationContext(ctx);
        server.afterPropertiesSet();
        logger.info("rpc server start -- rpcAddr: " + rpcAddr);
    }
}
