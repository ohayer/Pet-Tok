package pet.web.pettok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pet.web.pettok.UserRepository;
import pet.web.pettok.entity.Users;
import org.mindrot.jbcrypt.BCrypt;
@Controller
public class LoginController {
    private final UserRepository userRepository;

    String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") @Validated Users user,
                             BindingResult result){
        if (result.hasErrors()) {
            return "register";
        }
        String hashedPass = hashPassword(user.getPassword());
        user.setPassword(hashedPass);
        userRepository.save(user);
        return "redirect:/login";
    }
    //BCrypt.checkpw(password, hashedPassword) do sprawdzenia poprawnosci hasla
}
