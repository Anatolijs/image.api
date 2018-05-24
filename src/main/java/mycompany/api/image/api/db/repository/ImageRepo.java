package mycompany.api.image.api.db.repository;

import mycompany.api.image.api.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepo extends JpaRepository<Image, Integer> {

}