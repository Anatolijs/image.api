package mycompany.api.image.api.endpoint;

import org.springframework.stereotype.Component;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/api")
public class Endpoint {

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public Response.ok("pong").build();
}
