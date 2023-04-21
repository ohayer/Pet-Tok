package pet.web.pettok.service;

public interface UserService {
    void forgotPassword(String email);
    void resetPassword(String email, String code, String password);
}
