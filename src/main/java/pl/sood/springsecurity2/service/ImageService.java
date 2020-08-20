package pl.sood.springsecurity2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sood.springsecurity2.model.Image;
import pl.sood.springsecurity2.repository.ImageRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    ImageRepo imageRepository;

    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    public Optional<Image> getOne(Long id) {
        return imageRepository.findById(id);
    }

    public void save(Image image) {
        imageRepository.save(image);
    }

    public void delete(Long id) {
        imageRepository.deleteById(id);
    }

    public boolean exists(Long id) {
        return imageRepository.existsById(id);
    }
}
