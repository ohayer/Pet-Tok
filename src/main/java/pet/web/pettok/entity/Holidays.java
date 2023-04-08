package pet.web.pettok.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Holidays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String day;
    private String name;
    private Month month;


}
