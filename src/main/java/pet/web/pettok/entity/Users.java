package pet.web.pettok.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @Size(min = 6, message = "Hasło nie może mieć mniej niż 6 znaków")
    @Pattern.List({
            @Pattern(regexp = ".*[a-z].*", message = "Hasło musi zawierać co najmniej jedną małą literę"),
            @Pattern(regexp = ".*[A-Z].*", message = "Hasło musi zawierać co najmniej jedną dużą literę"),
            @Pattern(regexp = ".*\\d.*", message = "Hasło musi zawierać co najmniej jedną cyfrę"),
            @Pattern(regexp = ".*[@#$%^&+=].*", message = "Hasło musi zawierać co najmniej jeden znak specjalny (@#$%^&+=)")
    })
    private String password;
    @AssertTrue(message = "Musisz zaakceptować regulamin.")
    private boolean accepted;
    @OneToMany
    private List<Pets> pets;

    @Column(name = "password_reset_code")
    private String passwordResetCode;
}
