package pet.web.pettok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pet.web.pettok.service.UserService;

import java.util.Base64;

@Controller
public class ResetPasswordController {

    private final UserService userService;


    public ResetPasswordController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/resetPassword")
    public String getResetPassword() {
        return "resetPass";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam("email") String email) {
        userService.forgotPassword(email);
        String encodedEmail = Base64.getEncoder().encodeToString(email.getBytes());
        return "redirect:/resetPassword/" + encodedEmail;
    }

        @GetMapping("/resetPassword/{email}")
    public String getCode(@PathVariable String email,
                          Model model) {
        System.out.println(email);
        String emails = new String(Base64.getDecoder().decode(email.getBytes()));
        System.out.println(emails);
        int atIndex = emails.lastIndexOf('@');
        String maskedEmail = emails.substring(0, Math.min(6, atIndex)) + emails.substring(Math.min(6, atIndex), atIndex).replaceAll("[^@]", "*") + emails.substring(atIndex);
        model.addAttribute("email", maskedEmail);
        return "code";
    }

    @PostMapping("/resetPassword/{email}")
    public String postCode(@PathVariable String email,
                           @RequestParam("code") String code,
                           @RequestParam("password") String password,
                           @RequestParam("password2") String password2,
                           RedirectAttributes redirectAttributes) {
        String emails = new String(Base64.getDecoder().decode(email.getBytes()));
        if (password.equals(password2)) {
            try {
                userService.resetPassword(emails, code, password);
                return "redirect:/login";
            } catch (Exception e) {
                String message = "Wystąpił błąd z zapisem nowego hasła " + e.getMessage();
                throw new RuntimeException(message, e);
            }
        } else {
            String errorMessage = "Invalid passwords or reset code";
            redirectAttributes.addFlashAttribute("message", errorMessage);
            return "redirect:/resetPassword/{email}";
        }
    }
}

