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

    private Cloudinary cloudinary;

    private ImageRepo imageRepo;

    @Autowired
    public ImageUploaderService(ImageRepo imageRepo) {

        this.imageRepo = imageRepo;

        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dhha0rwuo",
                "api_key", "621269339965388",
                "api_secret", "PwrSWlPpmgssOqy-IjJzzpwAx3k"));
    }

    public Map uploadFile(MultipartFile file) {

        Map uploadResult = null;
        try {
            System.out.println(file.getBytes());
            uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            Image image = new Image((String) uploadResult.get("original_filename"),
                    (String) uploadResult.get("url"),
                    (String) uploadResult.get("public_id"));
            imageRepo.save(image);

        } catch (IOException e) {
        }

        return uploadResult;
    }

    public Map delete(String id) throws IOException {

        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;

    }

}




