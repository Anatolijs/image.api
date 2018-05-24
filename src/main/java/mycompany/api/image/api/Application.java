package mycompany.api.image.api;

import mycompany.api.image.api.model.Image;
import mycompany.api.image.api.service.ImageService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
    CommandLineRunner runner (ImageService imageService) {
	    return args -> {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Collection<Image>> typeReference = new TypeReference<Collection<Image>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/images.json");
        try {
            List<Image> images = mapper.readValue(inputStream, typeReference);
            imageService.saveAll(images);
            System.out.println("Users Saved!");
        } catch (IOException e) {
            System.out.println("Unable to save users: " + e.getMessage());
        }
    };
    }
}
