package mycompany.api.image.api.service.impl;

import mycompany.api.image.api.db.repository.ImageRepo;
import mycompany.api.image.api.domain.ImageResponse;
import mycompany.api.image.api.domain.ImagesRequest;
import mycompany.api.image.api.model.Image;
import mycompany.api.image.api.service.ImageNotFoundException;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl {

    private final ConcurrentMap<Integer, Image> images;

    @Inject
    private ImageRepo imageRepo;

    public ImageServiceImpl() {
        this.images = new ConcurrentHashMap<>();
    }

    public Collection<ImageResponse> getAllImages() {
        Collection<Image> allImages = images.values();
        return allImages.isEmpty() ? Collections.emptyList() : allImages.stream().map(this::convert).collect(Collectors.toList());
    }

    public Image getImage(Integer id) {
        return images.get(id);
    }

    public void addImage(ImagesRequest images) {
        images.images.forEach(image -> {
            if (Objects.isNull(image.getId())) image.setId(Integer.valueOf(UUID.randomUUID().toString()));
            Image imageModel = new Image();
            imageModel.setId(image.getId());
            imageModel.setTags(image.getTags());
            imageModel.setName(image.getName());
            this.images.put(image.getId(), imageModel);
            imageRepo.save(imageModel);
        });
        imageRepo.flush();
    }

    public Image updateImage(Integer id, Image image) {
        if (images.containsKey(id)) {
            return images.put(id, image);
        }
        throw new ImageNotFoundException("Can't update image. Image for id: " + id + " not found");
    }

    private ImageResponse convert(Image image) {
        ImageResponse imageResponse = new ImageResponse();
        imageResponse.id = image.getId();
        imageResponse.name = image.getName();
        imageResponse.tags = image.getTags();
        return imageResponse;
    }
}
