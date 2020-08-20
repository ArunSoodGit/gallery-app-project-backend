package pl.sood.springsecurity2.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.sood.springsecurity2.model.Image;
import pl.sood.springsecurity2.repository.ImageRepo;
import pl.sood.springsecurity2.service.ImageService;
import pl.sood.springsecurity2.service.ImageUploaderService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ImageController {
    private ImageService imageService;
    private ImageUploaderService imageUploaderService;
    private ImageRepo imageRepo;

    @Autowired
    public ImageController(ImageUploaderService imageUploaderService, ImageRepo imageRepo, ImageService imageService) {
        this.imageService = imageService;
        this.imageRepo = imageRepo;
        this.imageUploaderService = imageUploaderService;
    }

    @PostMapping("/upload-image")
    public void uploadImage2(@RequestParam("file") MultipartFile file) throws IOException {

     Map result = imageUploaderService.uploadFile(file);
        Image image =
                new Image((String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        imageService.save(image);

    }

    @GetMapping("/get-images")
    public List<Image> getImages() {

        return imageService.getAll();

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) throws IOException {

        Image image = imageRepo.getOne(id);

        imageUploaderService.delete(image.getImageId());
        imageService.delete(id);

    }
}
