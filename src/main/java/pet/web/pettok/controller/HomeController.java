package pet.web.pettok.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pet.web.pettok.UserRepository;
import pet.web.pettok.entity.Holidays;
import pet.web.pettok.holidays.HolidayRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class HomeController {

    private final HolidayRepository holidayRepository;
    private final UserRepository userRepository;

    public HomeController(HolidayRepository holidayRepository, UserRepository userRepository) {
        this.holidayRepository = holidayRepository;
        this.userRepository = userRepository;
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
        model.addAttribute("holidays", all);
        return "home";
    }
}
