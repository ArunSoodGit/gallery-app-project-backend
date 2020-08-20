package pl.sood.springsecurity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sood.springsecurity2.model.Image;

import java.util.List;


public interface ImageRepo extends JpaRepository<Image, Long> {
}
