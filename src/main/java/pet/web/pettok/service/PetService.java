package pet.web.pettok.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pet.web.pettok.entity.Pets;
import pet.web.pettok.repository.PetImageRepository;
import pet.web.pettok.repository.PetsRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PetService implements PetImageRepository {
    private final PetsRepository petsRepository;

    public PetService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    @Override
    public void saveImage(MultipartFile imageFile, String name) throws IOException {
        String folder = "C:\\projectImages\\";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + name + ".jpg");
        Files.write(path, bytes);
    }

}
