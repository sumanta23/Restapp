package com.sumanta;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {


	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_HTML)
	public String HelloWorld()
	{
		return "<p>hello world</p>";
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public String  xmlHello() {
		return "<?xml version=\"1.0\"?>" +
				"<hello> Hello Jersey" + "</hello>";
		
	}
	
	@GET
	@Path("/add/{id1}/{id2}")
	@Produces(MediaType.TEXT_PLAIN)
	public int getDeatils(@PathParam("id1") int id1,@PathParam("id2") int id2) {
		return id1+id2;
	}
	
	@POST
	@Path("got")
	@Produces(MediaType.TEXT_PLAIN)
	public String add(@FormParam("id") int id){
		return "got: "+id;
	}
	
	
}
