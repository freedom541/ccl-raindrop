package com.ccl.rain.netty.manage;

import com.ccl.rain.netty.client.RPCClientHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ccl
 */
public class SameInterfaceRPCHandlers {

    private List<RPCClientHandler> handlers;
    private AtomicInteger number = new AtomicInteger(0);

    public SameInterfaceRPCHandlers() {
        this.handlers = new ArrayList<RPCClientHandler>();
    }


    public RPCClientHandler getSLBHandler() {
        if (handlers == null || handlers.size() < 1) {
            return null;
        }
        int num = number.getAndIncrement() % handlers.size();
        return handlers.get(num);
    }


    public void addHandler(RPCClientHandler handler) {
        handlers.add(handler);
    }

    @Override
    public String toString() {
        String value="";
        for (RPCClientHandler handler : handlers) {
            value+=handler.getSocketAddress();
        }
        return "SameInterfaceRPCHandlers[" +value+"]";
    }
}
