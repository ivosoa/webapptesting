package de.iso.restserviceexample;

import de.iso.restserviceexample.rest.HelloService;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Ivo
 */
@ApplicationPath("rest")
public class RestService extends ResourceConfig{

  public RestService() {
    register(HelloService.class);
  }

}
