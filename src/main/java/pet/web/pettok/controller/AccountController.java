package pet.web.pettok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pet.web.pettok.entity.Pets;
import pet.web.pettok.entity.Users;
import pet.web.pettok.repository.PetsRepository;
import pet.web.pettok.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AccountController {
    private final UserRepository userRepository;
    private final PetsRepository petsRepository;

    public AccountController(UserRepository userRepository, PetsRepository petsRepository) {
        this.userRepository = userRepository;
        this.petsRepository = petsRepository;
    }

    @GetMapping("/account")
    public String getAccount(HttpSession session,
                             Model model) {
        if (session.getAttribute("email")!=null) {
            String email = (String) session.getAttribute("email");
            Users user = userRepository.findUsersByEmail(email);
            List<Pets> pets = petsRepository.findPetsByUserId(user.getId());
            model.addAttribute("pets", pets);
        }else {
            return "home";
        }

        return "account";
    }
}
