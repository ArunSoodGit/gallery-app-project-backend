package pl.sood.springsecurity2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.sood.springsecurity2.service.ImageUploaderService;

import java.io.Console;
import java.io.File;
import java.io.IOException;

@Controller
public class ImageController {

    private ImageUploaderService imageUploaderService;

    @Autowired
    public ImageController(ImageUploaderService imageUploaderService) {
        this.imageUploaderService = imageUploaderService;
    }

    @GetMapping("/new-image")
    public String newImage() {

        return "upload-image";
    }

    @PostMapping("/upload-image")
    public String uploadImage(File file) {
      //  imageUploaderService.uploadFile(file);
        return "upload-image";
    }
    @PostMapping("/upload-image2" )
    public String uploadImage2(@RequestParam("file") MultipartFile file) throws IOException {

       // String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       // String path = file.getBytes().toString();
        imageUploaderService.uploadFile(file);
        return "upload-image";
    }
}
