package de.iso.restserviceexample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ivo
 */
@Path("/hello")
public class HelloService {
  
  @GET
  @Path("/{param}")
  public Response getMsg(@PathParam("param") String message){
    
    String output = "Hello "+message;
    
    return Response.status(200).entity(output).build();
  }
  
}
