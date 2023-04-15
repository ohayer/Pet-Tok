package pet.web.pettok.service;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pet.web.pettok.repository.PetImageRepository;
import pet.web.pettok.repository.PetsRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

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
        String extension = FilenameUtils.getExtension(imageFile.getOriginalFilename());
        Path path = Paths.get(folder + name + "." + extension);
        Files.write(path, bytes);
    }

    @Override
    public String getImage() throws IOException {
        String folder = "C:\\projectImages\\";
        File[] files = new File(folder).listFiles();
        Random rand = new Random();
        File randomFile = files[rand.nextInt(files.length)];
        return randomFile.getPath();
    }

}
