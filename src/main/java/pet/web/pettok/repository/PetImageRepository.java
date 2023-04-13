package pet.web.pettok.repository;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PetImageRepository {
    void saveImage(MultipartFile imageFile) throws IOException;
}
