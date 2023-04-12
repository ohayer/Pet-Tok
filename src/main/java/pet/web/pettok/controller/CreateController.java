package pet.web.pettok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pet.web.pettok.entity.Pets;

import javax.servlet.http.HttpSession;

@Controller
public class CreateController {

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
}
