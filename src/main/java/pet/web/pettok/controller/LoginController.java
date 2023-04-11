package pet.web.pettok.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pet.web.pettok.UserRepository;
import pet.web.pettok.entity.Users;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpSession;

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
                               BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        String hashedPass = hashPassword(user.getPassword());
        user.setPassword(hashedPass);
        userRepository.save(user);
        return "redirect:/login";
    }
    //BCrypt.checkpw(password, hashedPassword) do sprawdzenia poprawnosci hasla

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session) {
        String hashed = userRepository.findPasswordByEmail(email);
        boolean passwordMatch = BCrypt.checkpw(password, hashed);
        System.out.println(passwordMatch);
        try {
            if (hashed != null && passwordMatch) {
                System.out.println("logged in");
                session.setAttribute("email",email);
                session.setMaxInactiveInterval(60*5);
                System.out.println(session.getAttribute("email"));
                return "redirect:/";
            } else {
                return "redirect:login";
            }
        } catch (NullPointerException  e) {
            System.err.println(e.getMessage() + " nie ma takiego emiala bądź hasła");
            return "redirect:/login";
        }
    }
}