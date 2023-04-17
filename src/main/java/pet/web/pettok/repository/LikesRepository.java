package pet.web.pettok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pet.web.pettok.entity.Likes;

public interface LikesRepository extends JpaRepository<Likes,Long> {
    @Query(value = "SELECT * FROM LIKES where user_id = ?1 and pet_id=?2",nativeQuery = true)
    Likes getLikesByEmailAndId(Long userId, Long petId);
    @Modifying
    @Query("DELETE FROM Likes l WHERE l.user.id = :userId")
    void deleteByUserId(@Param("userId") Long userId);

}
