package mycompany.api.image.api.service;

import mycompany.api.image.api.model.Image;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class ImageService {

    private final ConcurrentMap<Integer, Image> images;

    public ImageService() {
        this.images = new ConcurrentHashMap<>();
    }

    public Collection<Image> getAllImages() {
        Collection<Image> allImages = images.values();
        return allImages.isEmpty() ? Collections.emptyList(): new ArrayList<>(allImages);
    }

    public Image getImage(Integer id) {
        return images.get(id);
    }

    public void addImage(Image image) {
        if (Objects.isNull(image.getId())) image.setId(Integer.valueOf(UUID.randomUUID().toString()));

        this.images.put(image.getId(), image);
    }

    public Image updateImage(Integer id, Image image) {
        if (images.containsKey(id)) {
            return images.put(id, image);
        }
        throw new ImageNotFoundException("Can't update image. Image for id: " + id + " not found");
    }
}
