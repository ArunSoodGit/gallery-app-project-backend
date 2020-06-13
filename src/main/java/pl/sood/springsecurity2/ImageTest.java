package pl.sood.springsecurity2;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ImageTest {

    public static void main(String[] args) throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(

                "cloud_name", "dhha0rwuo",

                "api_key", "621269339965388",

                "api_secret", "PwrSWlPpmgssOqy-IjJzzpwAx3k"));




    File file = new File("D:\\ProgramyJava\\springsecurity2\\src\\main\\resources\\static\\download.jpg");
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    }
}
