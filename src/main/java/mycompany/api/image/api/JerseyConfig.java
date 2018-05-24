package mycompany.api.image.api;

import mycompany.api.image.api.controllers.ImageController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import javax.ws.rs.ApplicationPath;


@ApplicationPath("/app")
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages(getClass().getPackage().getName() + ".resources");
        register(ImageController.class);
        register(CorsResponseFilter.class);
    }
}