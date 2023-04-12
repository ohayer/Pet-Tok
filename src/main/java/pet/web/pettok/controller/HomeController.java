package pet.web.pettok.controller;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pet.web.pettok.starts.AnimalsFunFacts;
import pet.web.pettok.repository.UserRepository;
import pet.web.pettok.entity.Holidays;
import pet.web.pettok.repository.HolidayRepository;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
@Slf4j
public class HomeController {

    private final HolidayRepository holidayRepository;
    private final UserRepository userRepository;
    private final AnimalsFunFacts animalsFunFacts;

    public HomeController(HolidayRepository holidayRepository, UserRepository userRepository, AnimalsFunFacts animalsFunFacts) {
        this.holidayRepository = holidayRepository;
        this.userRepository = userRepository;
        this.animalsFunFacts = animalsFunFacts;
    }

    @GetMapping(value = "/")
    public String Home(Model model, HttpSession session) {
        List<Holidays> all = holidayRepository.findAllByMonth();
        try {
            String email = session.getAttribute("email").toString();
            model.addAttribute("name", userRepository.findNameSurnameByEmail(email).replace(",", " "));
        }catch (NullPointerException e) {
            System.out.println(e.getMessage() + "sesja z emailem jest null");
        }
        Elements elements =  animalsFunFacts.animalsFacts();
        int randomIndex = new Random().nextInt(elements.size() - 16) + 8;
        Element randomElement = elements.get(randomIndex);
        model.addAttribute("randomElement", randomElement);
        model.addAttribute("holidays", all);
        return "home";
    }
}
