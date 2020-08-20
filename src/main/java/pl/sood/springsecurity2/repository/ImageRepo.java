package pl.sood.springsecurity2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sood.springsecurity2.model.Image;

import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
}
