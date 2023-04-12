package pet.web.pettok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.web.pettok.entity.Pets;

public interface PetsRepository extends JpaRepository<Pets,Long> {
}
