package mycompany.api.image.api;

import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import static org.apache.catalina.webresources.TomcatURLStreamHandlerFactory.register;

@Configuration
@ApplicationPath("rest")
public class JerseyConfig {
    public JerseyConfig() {

    }

    @PostConstruct
    public void setUp() {
        register();
        register();
    }
}