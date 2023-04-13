package pet.web.pettok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
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
import java.util.Optional;
import java.util.function.Function;

@Service
public class PetService implements PetImageRepository {

    @Override
    public void saveImage(MultipartFile imageFile) throws IOException {
        String folder = "C:\\projectImages\\";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

}
