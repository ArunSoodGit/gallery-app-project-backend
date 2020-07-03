package pl.sood.springsecurity2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.sood.springsecurity2.service.ImageUploaderService;

import java.io.Console;
import java.io.File;
import java.io.IOException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ImageController {

    private ImageUploaderService imageUploaderService;

    @Autowired
    public ImageController(ImageUploaderService imageUploaderService) {
        this.imageUploaderService = imageUploaderService;
    }


    @PostMapping("/upload-image" )
    public void uploadImage2(@RequestParam("file") MultipartFile file) throws IOException {

        imageUploaderService.uploadFile(file);

    }
}
