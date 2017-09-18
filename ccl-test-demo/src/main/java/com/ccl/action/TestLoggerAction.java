package com.ccl.action;

import com.ccl.annotation.TestLogger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by ccl on 17/9/15.
 */
@Path("log")
@TestLogger
public class TestLoggerAction {
    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    //访问路径 /greel/ccl
    public String hello(@PathParam("name") String name) throws Exception {
        return "hello wolrd! "+name;
    }
}
