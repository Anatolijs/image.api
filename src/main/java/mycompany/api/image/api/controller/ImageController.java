package mycompany.api.image.api.controller;

import mycompany.api.image.api.model.Image;
import mycompany.api.image.api.service.ImageService;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Collection;

@Component
@Path("/images")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GET
    @Path("application/json")
    public Collection getAllImages() {
        return imageService.getAllImages();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Image getImage(@PathParam("id") String id) {
        return imageService.getImage(id);
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addImage(Image image) {
        imageService.addImage(image);
        return Response.created(URI.create("/" + image.getId())).build();
    }

    @PUT
    @Consumes("application/json")
    @Path("/{id}")
    public Response updateImage(@PathParam("id") String id, Image image) {
        imageService.updateImage(id, image);
        return Response.noContent().build();
    }
}
