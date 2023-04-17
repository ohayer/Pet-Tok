package pet.web.pettok.entity;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "To pole nie może być puste")
    private String name;
    @NotBlank(message = "To pole nie może być puste")
    private String description;
    @NotBlank(message = "To pole nie może być puste")
    private String type;
    private int rating;

}
