package pet.web.pettok.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pet.web.pettok.entity.Users;
import pet.web.pettok.repository.UserRepository;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private JavaMailSender javaMailSender;


    public UserServiceImpl(UserRepository userRepository, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.javaMailSender = javaMailSender;
    }

    String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public void forgotPassword(String email) {
        Users user = userRepository.findUsersByEmail(email);
        if (user == null) {
            throw new RuntimeException("User with email " + email + " not found.");
        }
        String code = UUID.randomUUID().toString();
        user.setPasswordResetCode(code);
        userRepository.save(user);
        String subject = "Password Reset Required";
        String message = "Dear " + user.getName() + ",\n\n" +
                "Please use the following code to reset your password: " + code + "\n\n" +
                "Best regards,\n" +
                "Your Pet-Tok Team";
        sendEmail(email, subject, message);
    }

    @Override
    public void resetPassword(String email, String code, String password) {
        Users user = userRepository.findUsersByEmail(email);
        if (user == null) {
            throw new RuntimeException("User with email " + email + " not found.");
        }
        if (!user.getPasswordResetCode().equals(code)) {
            throw new RuntimeException("Invalid password reset code.");
        }
        String hashedPass = hashPassword(password);
        user.setPassword(hashedPass);
        user.setPasswordResetCode(null);
        userRepository.save(user);
    }


    private void sendEmail(String to, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }
}
