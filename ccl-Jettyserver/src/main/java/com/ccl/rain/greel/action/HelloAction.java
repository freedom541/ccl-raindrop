package com.ccl.rain.greel.action;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by ccl on 17/8/30.
 */
@Path("greel")
public class HelloAction {
    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    //访问路径 /greel/ccl
    public String hello(@PathParam("name") String name) throws Exception {
        return "hello wolrd! "+name;
    }
}
