package pet.web.pettok.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pet.web.pettok.entity.Pets;
import pet.web.pettok.entity.Users;
import pet.web.pettok.repository.PetsRepository;
import pet.web.pettok.repository.UserRepository;
import pet.web.pettok.service.PetService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class SearchController {
    private final PetService petService;
    private final PetsRepository petsRepository;
    private final UserRepository userRepository;

    public SearchController(PetService petService, PetsRepository petsRepository, UserRepository userRepository) {
        this.petService = petService;
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
    }
    @GetMapping("/search")
    public String getSearch(Model model,
                            HttpSession session) {
        if (session.getAttribute("email")==null){
            return "redirect:/login";
        }
        try {
            String imagePath = petService.getImage();
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
            String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
            String imageSrc = "data:image/jpeg;base64," + encodedImage;
            String imageName = new File(imagePath).getName();
            String extension = imageName.substring(imageName.lastIndexOf('.') + 1);

            Long idName = Long.parseLong(imageName.substring(0, imageName.length() - extension.length() - 1));
            Optional<Pets> pet = petsRepository.findById(idName);
            Users user = userRepository.findByIdPets(idName);


            model.addAttribute("user", user);
            model.addAttribute("pet", pet.get());
            model.addAttribute("imageSrc", imageSrc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "search";
    }

}
