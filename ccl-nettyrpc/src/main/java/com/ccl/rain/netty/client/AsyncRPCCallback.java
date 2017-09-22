package com.ccl.rain.netty.client;

/**
 * AsyncRPCCallback
 */
public interface AsyncRPCCallback {

    void success(Object result);

    void fail(Exception e);

}
