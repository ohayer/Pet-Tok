package pet.web.pettok.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pet.web.pettok.entity.Pets;
import pet.web.pettok.entity.Users;
import pet.web.pettok.repository.PetsRepository;
import pet.web.pettok.repository.UserRepository;
import pet.web.pettok.service.PetService;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateController {
    private final PetsRepository petsRepository;
    private final UserRepository userRepository;
    private final PetService petService;

    @Autowired
    public CreateController(PetsRepository petsRepository, UserRepository userRepository, PetService petService) {
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
        this.petService = petService;
    }

    @GetMapping("/create")
    public String createGet(Model model, HttpSession session) {
        if (session.getAttribute("email") != null) {
            Pets pets = new Pets();
            model.addAttribute("pet", pets);
            return "create";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute("pet") @Validated Pets pet,
                             BindingResult result, HttpSession session,
                             @RequestParam("image") MultipartFile imageFile) {
        if (result.hasErrors()) {
            return "/create";
        }
        try {
            String emailOfUser = (String) session.getAttribute("email");
            Users user = userRepository.findUsersByEmail(emailOfUser);
            List<Pets> userPets = user.getPets();
            if (userPets == null) {
                userPets = new ArrayList<>();
                user.setPets(userPets);
            }
            userPets.add(pet);
            petsRepository.save(pet);
            if (imageFile.isEmpty()) {
                result.rejectValue("image", "error.image", "Dodaj plik graficzny");
                return "redirect:/create";
            }
            petService.saveImage(imageFile, pet.getId().toString());
            return "redirect:/";
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "redirect:/create";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

