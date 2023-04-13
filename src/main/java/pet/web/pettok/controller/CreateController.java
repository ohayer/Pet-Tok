package pet.web.pettok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pet.web.pettok.entity.Pets;
import pet.web.pettok.entity.Users;
import pet.web.pettok.repository.PetsRepository;
import pet.web.pettok.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateController {
    private final PetsRepository petsRepository;
    private final UserRepository userRepository;

    public CreateController(PetsRepository petsRepository, UserRepository userRepository) {
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/create")
    public String createGet(Model model, HttpSession session){
        if (session.getAttribute("email")!=null) {
            Pets pets = new Pets();
            model.addAttribute("pet", pets);
            return "create";
        }else {
            return "redirect:/login";
        }
    }
    //make tomorrow post save pet
    @PostMapping("/create")
    public String createPost(@ModelAttribute("pet") @Validated Pets pet,
                             BindingResult result, HttpSession session){
        if (result.hasErrors()) {
            return "create";
        }
        try {
            String emailOfUser = (String) session.getAttribute("email");
            Users user = userRepository.findUsersByEmail(emailOfUser);
            List<Pets> pets = new ArrayList<>();
            pets.add(pet);
            user.setPets(pets);
            //I have to find the way to save correctly an image
//            pet.setImage();
            petsRepository.save(pet);
            return "redirect:/";
        }catch (NullPointerException e){
            e.printStackTrace();
            return "redirect:/create";
        }
    }
}
