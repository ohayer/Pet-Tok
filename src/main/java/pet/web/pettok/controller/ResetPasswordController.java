package pet.web.pettok.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<?> resetPassword(@RequestParam("email") String email) {
        userService.forgotPassword(email);
        return ResponseEntity.ok("Code sent successfully");
    }

}
