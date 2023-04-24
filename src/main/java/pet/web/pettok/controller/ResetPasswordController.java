package pet.web.pettok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pet.web.pettok.service.UserService;

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
        return "redirect:/resetPassword/" + email;
    }

    @GetMapping("/resetPassword/{email}")
    public String getCode(@PathVariable String email) {
        return "code";
    }

    @PostMapping("/resetPassword/{email}")
    public String postCode(@PathVariable String email,
                           @RequestParam("code") String code,
                           @RequestParam("password") String password,
                           @RequestParam("password2") String password2,
                           RedirectAttributes redirectAttributes) {
        if (password.equals(password2)) {
           try{ userService.resetPassword(email, code, password);
            return "redirect:/login";
        }catch(Exception e){
               String message = "Wystąpił błąd z zapisem nowego hasła" + e.getMessage();
               throw new RuntimeException(message, e);
        }
        }else{
                String errorMessage = "Invalid passwords or reset code";
                redirectAttributes.addFlashAttribute("message", errorMessage);
            return "redirect:/resetPassword/{email}";
            }
    }
}
