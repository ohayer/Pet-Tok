package pet.web.pettok.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
    @NotNull(message = "To pole nie może być puste.")
    private String name;
    @NotNull(message = "To pole nie może być puste.")
    private String surname;
    @Email(message = "Wpisz poprawny email.")
    private String email;
    private String password;
    @AssertTrue(message = "Musisz zaakceptować regulamin.")
    private boolean accepted;

}
