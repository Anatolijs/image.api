package mycompany.api.image.api;

import mycompany.api.image.api.controllers.ImageController;
import mycompany.api.image.api.service.ImageService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/app")
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages(getClass().getPackage().getName() + ".resources");
        register(ImageController.class);
        register(ImageService.class);
    }

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".json");
        return resolver;
   }
}