package mycompany.api.image.api.controllers;

import mycompany.api.image.api.model.Image;
import mycompany.api.image.api.service.ImageService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Collection;


@Path("/images")
public class ImageController {

    @Inject
    private ImageService imageService;

    @GET
    @Produces("application/json")
    public Collection<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @Path("/image/{id}")
    @GET
    @Produces("application/json")
    public Image getImage(@PathParam("id") Integer id) throws NotFoundException {
        return imageService.getImage(id);
    }

    @Path("/image/{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addImage(Image image) {
        imageService.addImage(image);
        return Response.created(URI.create("/" + image.getId())).build();
    }

    @Path("/image/{id}")
    @PUT
    @Consumes("application/json")
    public Response updateImage(@PathParam("id") Integer id, Image image) throws NotFoundException {
        imageService.updateImage(id, image);
        return Response.noContent().build();
    }
}
