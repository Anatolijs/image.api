package mycompany.api.image.api.service;

import mycompany.api.image.api.db.repository.ImageRepo;
import mycompany.api.image.api.model.Image;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ImageService {
    private ImageRepo imageRepo;

    public ImageService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    public Iterable<Image> list() {
        return imageRepo.findAll();
    }

    public Iterable<Image> saveAll(List<Image> images) {
        return imageRepo.saveAll(images);
    }
}
