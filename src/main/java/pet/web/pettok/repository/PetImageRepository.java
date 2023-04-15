package pet.web.pettok.repository;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PetImageRepository {
    void saveImage(MultipartFile imageFile,String name) throws IOException;
    String getImage()throws IOException;
}
