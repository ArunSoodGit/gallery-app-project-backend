package pl.sood.springsecurity2.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.sood.springsecurity2.model.Image;
import pl.sood.springsecurity2.repository.ImageRepo;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploaderService {
    Cloudinary cloudinary;


    private ImageRepo imageRepo;

    @Autowired
    public ImageUploaderService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
        cloudinary = new Cloudinary(ObjectUtils.asMap(

                "cloud_name", "dhha0rwuo",
                "api_key", "621269339965388",
                "api_secret", "PwrSWlPpmgssOqy-IjJzzpwAx3k"));
    }

    public String uploadFile(MultipartFile file) {

        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            saveUrlToDb(uploadResult.get("url").toString());
        } catch (IOException e) {
        }

        return uploadResult.get("url").toString();
    }

    public void saveUrlToDb(String path) {
        imageRepo.save(new Image(path));
    }


}

