package pet.web.pettok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pet.web.pettok.entity.Users;

public interface UserRepository extends JpaRepository<Users,Long> {

    @Query(value = "SELECT password FROM USERS WHERE email = ?1",nativeQuery = true)
    public String findPasswordByEmail(String email);
    @Query(value = "SELECT name,surname FROM USERS WHERE email = ?1",nativeQuery = true)
    String findNameSurnameByEmail(String email);

    Users findUsersByEmail(String email);

    @Query(value = "SELECT * FROM USERS join users_pets up on users.id = up.users_id where pets_id = ?1",nativeQuery = true)
    Users findByIdPets(Long id);

}
