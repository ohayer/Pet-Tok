package pet.web.pettok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;
import pet.web.pettok.entity.Pets;

import java.io.IOException;

public interface PetsRepository extends JpaRepository<Pets,Long> {

}
