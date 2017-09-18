package com.ccl.action;

import com.ccl.annotation.LoginTest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by ccl on 17/9/15.
 */
@Path("log2")
public class TestLoggerAction2 {

    @GET
    @Path("mthod/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String mthod(@PathParam("name") String name) throws Exception {
        return "hello wolrd -- mthod:  "+name;
    }


    @GET
    @LoginTest
    @Path("login/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String login(@PathParam("name") String name) throws Exception {
        return "hello wolrd -- login:  "+name;
    }

    @GET
    @Path("auth/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String auth(@PathParam("name") String name) throws Exception {
        return "hello wolrd -- auth:  "+name;
    }
}
