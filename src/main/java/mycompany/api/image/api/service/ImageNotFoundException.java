package mycompany.api.image.api.service;

public class ImageNotFoundException extends RuntimeException {

    public ImageNotFoundException (String message) {
        super(message);
    }
}
