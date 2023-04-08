package pet.web.pettok.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pet.web.pettok.entity.Holidays;
import pet.web.pettok.holidays.HolidayRepository;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@Slf4j
public class HomeController {

    private final HolidayRepository holidayRepository;

    public HomeController(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @GetMapping(value = "/")
    public String Home(Model model) {
        List<Holidays> all = holidayRepository.findAllByMonth();
        model.addAttribute("holidays", all);
        return "home";
    }
}
