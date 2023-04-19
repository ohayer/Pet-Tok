package pet.web.pettok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pet.web.pettok.entity.Pets;

import java.util.List;

public interface PetsRepository extends JpaRepository<Pets, Long> {
            @Query(value = "SELECT  * from pets join users_pets up on pets.id = up.pets_id where users_id = ?1",nativeQuery = true)
            List<Pets> findPetsByUserId(Long id);
            @Modifying
            @Query(value = "DELETE FROM users_pets where pets_id = ?1",nativeQuery = true)
            void deleteFromUserPets(Long id);

}
