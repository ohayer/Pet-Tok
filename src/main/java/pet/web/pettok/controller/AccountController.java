package pet.web.pettok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pet.web.pettok.entity.Pets;
import pet.web.pettok.entity.Users;
import pet.web.pettok.repository.LikesRepository;
import pet.web.pettok.repository.PetsRepository;
import pet.web.pettok.repository.UserRepository;
import pet.web.pettok.service.PetService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class AccountController {
    private final UserRepository userRepository;
    private final PetsRepository petsRepository;
    private final PetService petService;
    private final LikesRepository likesRepository;

    public AccountController(UserRepository userRepository, PetsRepository petsRepository, PetService petService, LikesRepository likesRepository) {
        this.userRepository = userRepository;
        this.petsRepository = petsRepository;
        this.petService = petService;
        this.likesRepository = likesRepository;
    }

    @GetMapping("/account")
    public String getAccount(HttpSession session,
                             Model model) {
        if (session.getAttribute("email") != null) {
            String email = (String) session.getAttribute("email");
            Users user = userRepository.findUsersByEmail(email);
            List<Pets> pets = petsRepository.findPetsByUserId(user.getId());
            model.addAttribute("pets", pets);
        } else {
            return "home";
        }

        return "account";
    }

    @Transactional
    @PostMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        Users users = userRepository.findByIdPets(id);
        likesRepository.deleteByPetId(id, users.getId());
        petsRepository.deleteFromUserPets(id);
        petsRepository.deleteById(id);
        try {
            petService.deleteImage(String.valueOf(id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/account";
    }

}
