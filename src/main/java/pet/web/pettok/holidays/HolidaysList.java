package pet.web.pettok.holidays;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pet.web.pettok.entity.Holidays;
import java.time.Month;
import java.util.Arrays;

@Component
@Getter
@ToString
public class HolidaysList implements CommandLineRunner {

    private final HolidayRepository holidayRepository;

    public HolidaysList(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Holidays eagleDay = new Holidays(2L, "10 stycznia", "Dzień Orła", Month.JANUARY);
        Holidays penguinDay = new Holidays(3L, "20 stycznia", "Dzień Pingwina", Month.JANUARY);
        Holidays squirrelDay = new Holidays(4L, "21 stycznia", "Dzień Wiewiórki", Month.JANUARY);
        Holidays zebraDay = new Holidays(5L, "31 stycznia", "Dzień Zebry", Month.JANUARY);

        Holidays groundhogDay = new Holidays(6L, "2 lutego", "Dzień Świstaka", Month.FEBRUARY);
        Holidays hippoDay = new Holidays(7L, "15 lutego", "Dzień Hipopotama, Dzień Łuskowca", Month.FEBRUARY);
        Holidays catDay = new Holidays(8L, "17 lutego", "Dzień Kota", Month.FEBRUARY);
        Holidays polarBearDay = new Holidays(9L, "27 lutego", "Dzień Niedźwiedzia Polarnego", Month.FEBRUARY);
        Holidays whaleDay = new Holidays(10L, "druga lub trzecia niedziela lutego", "Dzień Wielorybów", Month.FEBRUARY);

        Holidays wildlifeDay = new Holidays(11L, "3 marca", "Dzień Dzikiej Przyrody", Month.MARCH);
        Holidays butterflyDay = new Holidays(12L, "14 marca", "Dzień Motyli, Dzień Pająka", Month.MARCH);
        Holidays pandaDay = new Holidays(13L, "16 marca", "Dzień Pandy", Month.MARCH);
        Holidays frogDay = new Holidays(14L, "20 marca", "Dzień Żaby, Dzień Wróbla", Month.MARCH);
        Holidays puppyDay = new Holidays(15L, "23 marca", "Dzień Szczeniaka", Month.MARCH);

        Holidays birdDay = new Holidays(16L, "1 kwietnia", "Dzień Ptaków", Month.APRIL);
        Holidays animalDay = new Holidays(17L, "4 kwietnia", "Dzień Zwierząt Bezdomnych, Dzień Szczura", Month.APRIL);
        Holidays beaverDay = new Holidays(18L, "7 kwietnia", "Dzień Bobra", Month.APRIL);
        Holidays pigeonDay = new Holidays(19L, "9 kwietnia", "Dzień Gołębia", Month.APRIL);
        Holidays hamsterDay = new Holidays(20L, "12 kwietnia", "Dzień Chomika", Month.APRIL);
        Holidays dolphinDay = new Holidays(21L, "14 kwietnia", "Dzień Delfina", Month.APRIL);
        Holidays elephantDay = new Holidays(22L, "16 kwietnia", "Dzień Ochrony Słoni", Month.APRIL);
        Holidays penguin2Day = new Holidays(23L, "24 kwietnia", "Dzień Pingwina, Dzień Zwierząt Laboratoryjnych", Month.APRIL);
        Holidays horseDay = new Holidays(25L, "30 kwietnia", "Dzień Konia",Month.APRIL);

        holidayRepository.saveAll(Arrays.asList(eagleDay, penguinDay, squirrelDay, zebraDay, groundhogDay, hippoDay,
                catDay, polarBearDay, whaleDay, wildlifeDay, butterflyDay, pandaDay, frogDay, puppyDay, birdDay, animalDay,
                beaverDay, pigeonDay, hamsterDay, dolphinDay, elephantDay, penguin2Day, horseDay));
        System.out.println("added");
    }
}

