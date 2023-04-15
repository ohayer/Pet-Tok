package pet.web.pettok.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pet.web.pettok.entity.Pets;
import pet.web.pettok.repository.PetsRepository;
import pet.web.pettok.service.PetService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
public class SearchController {
    private final PetService petService;
    private final PetsRepository petsRepository;

    public SearchController(PetService petService, PetsRepository petsRepository) {
        this.petService = petService;
        this.petsRepository = petsRepository;
    }

    @GetMapping("/search")
    public String getSearch(Model model) {
        try {
            String imagePath = petService.getImage();
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
            String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
            String imageSrc = "data:image/jpeg;base64," + encodedImage;
            String imageName = new File(imagePath).getName();
            String extension = imageName.substring(imageName.lastIndexOf('.') + 1);
            Long idName = Long.parseLong(imageName.substring(0, imageName.length() - extension.length() - 1));
            System.out.println(idName);
                Optional<Pets> pet = petsRepository.findById(idName);
            System.out.println(pet.get());
                    model.addAttribute("pet", pet.get());
                    model.addAttribute("imageSrc", imageSrc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "search";
    }

}
