package pet.web.pettok;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.web.pettok.entity.Users;

public interface UserRepository extends JpaRepository<Users,Long> {

}
