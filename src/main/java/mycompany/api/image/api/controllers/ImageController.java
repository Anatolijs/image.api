package mycompany.api.image.api.controllers;

import mycompany.api.image.api.domain.ImageResponse;
import mycompany.api.image.api.domain.ImagesRequest;
import mycompany.api.image.api.model.Image;
import mycompany.api.image.api.service.impl.ImageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;


@Path("/images")
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Inject
    private ImageServiceImpl imageService;

    @GET
    @Produces("application/json")
    @CrossOrigin(origins="http://localhost:3000")
    public Collection<ImageResponse> getAllImages() {
        return imageService.getAllImages();
    }

    @Path("/image/{id}")
    @GET
    @Produces("application/json")
    public Image getImage(@PathParam("id") Integer id) throws NotFoundException {
        return imageService.getImage(id);
    }

    @Path("/image/{id}/png")
    @GET
    @Produces("image/png")
    public Response getImagePng(@PathParam("id") Integer id) throws NotFoundException {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:\\Users\\anatolijs.bikmulins\\Desktop\\Work\\image.api\\images\\images\\" + id + ".png"));
        } catch (IOException e) {

            e.printStackTrace();
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] imageData = baos.toByteArray();

        System.out.println("Image " + id);
        return Response.ok(new ByteArrayInputStream(imageData)).build();
    }

    @Path("/image")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addImage(ImagesRequest image) {
        imageService.addImage(image);
        return Response.created(URI.create("/" + image.images.get(0).getId())).build();
    }

    @Path("/image/{id}")
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateImage(@PathParam("id")Integer id, Image image) throws NotFoundException {
        imageService.updateImage(id, image);
        return Response.ok(image).build();
    }
}
