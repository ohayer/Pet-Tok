package pet.web.pettok.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "To pole nie może być puste.")
    private String name;
    @NotBlank(message = "To pole nie może być puste.")
    private String surname;
    @Column(unique = true)
    @Email(message = "Wpisz poprawny email.")
    @NotBlank(message = "To pole nie może być puste.")
    private String email;
    @Size(min = 6, message = "To pole musi być trochę dłuższe.")
    private String password;
    @AssertTrue(message = "Musisz zaakceptować regulamin.")
    private boolean accepted;
    @OneToMany
    private List<Pets> pets;
}
