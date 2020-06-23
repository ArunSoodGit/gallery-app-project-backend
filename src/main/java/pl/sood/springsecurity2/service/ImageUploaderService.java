package pl.sood.springsecurity2.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploaderService {
    Cloudinary cloudinary;

    public ImageUploaderService() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(

                "cloud_name", "dhha0rwuo",
                "api_key", "621269339965388",
                "api_secret", "PwrSWlPpmgssOqy-IjJzzpwAx3k"));
    }

    public String uploadFile(MultipartFile file) {

        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        } catch (IOException e) {
        }
        return uploadResult.get("url").toString();
    }


}

