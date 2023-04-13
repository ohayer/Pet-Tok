package pet.web.pettok.controller;

import lombok.SneakyThrows;
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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
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
            List<Pets> pets = new ArrayList<>();
            pets.add(pet);
            user.setPets(pets);
            petService.saveImage(imageFile);
            petsRepository.save(pet);
            return "redirect:/";
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "redirect:/create";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/image")
    public String imageGet() {
        return "image";
    }

    @PostMapping("/image")
    public String imagePost(@RequestParam("image") MultipartFile imageFile) {
        try {
            petService.saveImage(imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }
}

