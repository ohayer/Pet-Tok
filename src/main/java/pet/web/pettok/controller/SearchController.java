package pet.web.pettok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pet.web.pettok.entity.Likes;
import pet.web.pettok.entity.Pets;
import pet.web.pettok.entity.Users;
import pet.web.pettok.repository.LikesRepository;
import pet.web.pettok.repository.PetsRepository;
import pet.web.pettok.repository.UserRepository;
import pet.web.pettok.service.PetService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;

@Controller
public class SearchController {
    private final PetService petService;
    private final PetsRepository petsRepository;
    private final UserRepository userRepository;
    private final LikesRepository likesRepository;

    public SearchController(PetService petService, PetsRepository petsRepository, UserRepository userRepository, LikesRepository likesRepository) {
        this.petService = petService;
        this.petsRepository = petsRepository;
        this.userRepository = userRepository;
        this.likesRepository = likesRepository;
    }

    @GetMapping("/search")
    public String getSearchToId(HttpSession session) {
        if (session.getAttribute("email") == null) {
            return "redirect:/login";
        }
        try {
            String imageName = petService.returnImageName();
            String encodedImageName = Base64.getEncoder().encodeToString(imageName.getBytes());
            return "redirect:/search/" + encodedImageName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/search/{ids}")
    public String getSearch(Model model,
                            HttpSession session,
                            @PathVariable String ids) {
        String idd = new String(Base64.getDecoder().decode(ids));
        Long id = Long.valueOf(idd);
        if (session.getAttribute("email") == null) {
            return "redirect:/login";
        }
        try {
            String imagePath = petService.getImageByName(id);
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
            String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
            String imageSrc = "data:image/jpeg;base64," + encodedImage;


            Optional<Pets> pet = petsRepository.findById(id);
            String email = session.getAttribute("email").toString();
            Users actualUser = userRepository.findUsersByEmail(email);
            Users user = userRepository.findByIdPets(id);


            Likes likes = likesRepository.getLikesByUserIdAndPetId(actualUser.getId(), pet.get().getId());
            model.addAttribute("likes", likes);

            pet.ifPresent(p -> {
                model.addAttribute("pet", pet.get());
            });
            model.addAttribute("user", user);
            model.addAttribute("imageSrc", imageSrc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "search";
    }

    @Transactional
    @PostMapping("/search/{ids}")
    public String postLike(@PathVariable String ids,
                           HttpSession session) {
        String idd = new String(Base64.getDecoder().decode(ids));
        Long id = Long.parseLong(idd);
        String email = (String) session.getAttribute("email");
        Users users = userRepository.findUsersByEmail(email);
        Likes likes = likesRepository.getLikesByUserIdAndPetId(users.getId(), id);
        Optional<Pets> pet = petsRepository.findById(id);
        if (likes == null) {
            likes = new Likes();
            likes.setUser(users);


            likes.setPet(pet.get());
            int rating = pet.get().getRating();
            likesRepository.save(likes);
            pet.get().setRating(rating + 1);
            petsRepository.save(pet.get());
        } else {
            int rating = pet.get().getRating();
            pet.get().setRating(rating - 1);
            petsRepository.save(pet.get());
            likesRepository.deleteByPetId(id, users.getId());
        }
        return "redirect:/search/" + ids;
    }

}
