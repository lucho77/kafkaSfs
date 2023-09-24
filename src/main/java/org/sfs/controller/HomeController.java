package org.sfs.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sfs.BuildInfoConfig;

@Path(value = "/")
public class HomeController {
	
	

	@GET()
	@Path(value = "/")
    public Object home() {
        return "Hello from RUS MS Provider Kafka";
    }

	@GET()
	@Path(value = "/ping")
    public Object ping() {
        return "Hello from RUS MS Provider Kafka ping";
    }

	@GET()
	@Path(value = "/version")
	@Produces(MediaType.APPLICATION_JSON)
	public Object version() {
         return new BuildInfoConfig().getBuildInfo();
	}

}
