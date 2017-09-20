package com.ccl.rain.server;

import com.ccl.rain.common.Configs;
import com.ccl.rain.netty.server.RPCServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Created by ccl on 17/8/29.
 */
public class NettyRpcServer {
    private static final Logger logger = LoggerFactory.getLogger(NettyRpcServer.class);
    private String zookeeperAddr = Configs.getString("zookeeper.server.host");
    private String rpcAddr = Configs.getString("worker.rpcServer.host");

    public NettyRpcServer(String zookeeperAddr, String rpcAddr) {
        this.zookeeperAddr = zookeeperAddr;
        this.rpcAddr = rpcAddr;
    }

    public NettyRpcServer(String rpcAddr) {
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
        logger.info("<><><><><><><><> rpc server start -- rpcAddr: " + rpcAddr);
    }

    public void start(AnnotationConfigWebApplicationContext ctx) throws Exception {
        RPCServer server = new RPCServer(rpcAddr, zookeeperAddr);
        server.setApplicationContext(ctx);
        server.afterPropertiesSet();
        logger.info("<><><><><><><><> rpc server start -- rpcAddr: " + rpcAddr);
    }
}
