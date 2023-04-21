package pet.web.pettok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pet.web.pettok.repository.UserRepository;
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
                            HttpSession session,
                            RedirectAttributes redirectAttributes) {
        try {
            String hashed = userRepository.findPasswordByEmail(email);
            boolean passwordMatch = BCrypt.checkpw(password, hashed);
            if (hashed != null && passwordMatch) {
                System.out.println("logged in");
                session.setAttribute("email", email);
                session.setMaxInactiveInterval(60 * 5);
                return "redirect:/";
            } else {
                redirectAttributes.addAttribute("error", "invalid_credentials");
                return "redirect:login";
            }
        } catch (NullPointerException e) {
            redirectAttributes.addAttribute("error", "invalid_credentials");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String getLogout(HttpSession session) {
        session.removeAttribute("email");
        return "redirect:http://localhost:8080/";
    }
}