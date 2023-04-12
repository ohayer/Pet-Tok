package pet.web.pettok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pet.web.pettok.entity.Holidays;

import java.util.List;

public interface HolidayRepository extends JpaRepository<Holidays,Long> {
    @Query(value = "SELECT * FROM holidays where month = MONTH(NOW())-1", nativeQuery = true)
    public List<Holidays> findAllByMonth();
}
