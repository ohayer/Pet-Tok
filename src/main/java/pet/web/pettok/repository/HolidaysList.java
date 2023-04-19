package pet.web.pettok.repository;

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
        Holidays horseDay = new Holidays(25L, "30 kwietnia", "Dzień Konia", Month.APRIL);

        Holidays tunaDay = new Holidays(26L, "2 maja", "Dzień Tuńczyka", Month.MAY);
        Holidays koalaDay = new Holidays(27L, "3 maja", "Dzień Koali", Month.MAY);
        Holidays kangarooDay = new Holidays(28L, "15 maja", "Dzień Kangura", Month.MAY);
        Holidays beeDay = new Holidays(29L, "20 maja", "Światowy Dzień Pszczół", Month.MAY);
        Holidays parrotDay = new Holidays(30L, "21 maja", "Dzień Papugi", Month.MAY);
        Holidays animalRightsDay = new Holidays(31L, "22 maja", "Dzień Praw Zwierząt", Month.MAY);
        Holidays turtleDay = new Holidays(32L, "23 maja", "Dzień Żółwia", Month.MAY);
        Holidays storkDay = new Holidays(33L, "31 maja", "Dzień Bociana Białego", Month.MAY);
        Holidays migratoryBirdsDay = new Holidays(34L, "Drugi weekend maja", "Dzień Ptaków Wędrownych", Month.MAY);
        Holidays endangeredSpeciesDay = new Holidays(35L, "Trzeci piątek maja", "Dzień Zagrożonych Gatunków", Month.MAY);
        Holidays otterDay = new Holidays(36L, "Ostatnia środa maja", "Dzień Wydry", Month.MAY);

        Holidays circusWithoutAnimalsDay = new Holidays(37L, "8 czerwca", "Dzień Cyrku bez Zwierząt", Month.JUNE);
        Holidays dogTherapyDay = new Holidays(38L, "15 czerwca", "Dzień Dogoterapii", Month.JUNE);
        Holidays seaTurtleDay = new Holidays(39L, "16 czerwca", "Dzień Żółwia Morskiego", Month.JUNE);
        Holidays giraffeDay = new Holidays(40L, "21 czerwca", "Dzień Żyrafy", Month.JUNE);
        Holidays cabbageButterflyDay = new Holidays(41L, "30 czerwca", "Dzień Motyla Kapustnika", Month.JUNE);

        Holidays polishDogDay = new Holidays(42L, "1 lipca", "Polski Dzień Psa", Month.JULY);
        Holidays chimpanzeeDay = new Holidays(43L, "14 lipca", "Dzień Szympansa", Month.JULY);
        Holidays sharkDay = new Holidays(44L, "14 lipca", "Dzień Rekina", Month.JULY);
        Holidays snakeDay = new Holidays(45L, "16 lipca", "Dzień Węża", Month.JULY);
        Holidays guineaPigDay = new Holidays(46L, "21 lipca", "Dzień Świnki Morskiej", Month.JULY);
        Holidays tigerDay = new Holidays(47L, "29 lipca", "Dzień Tygrysa", Month.JULY);

        Holidays beesDay = new Holidays(48L, "8 sierpnia", "Polski Dzień Pszczół", Month.AUGUST);
        Holidays lionDay = new Holidays(49L, "10 sierpnia", "Dzień Lwa", Month.AUGUST);
        Holidays elephantsDay = new Holidays(50L, "12 sierpnia", "Dzień Słonia", Month.AUGUST);
        Holidays orangutanDay = new Holidays(51L, "19 sierpnia", "Dzień Orangutana", Month.AUGUST);
        Holidays mosquitoDay = new Holidays(52L, "20 sierpnia", "Dzień Komara", Month.AUGUST);
        Holidays sharksDay = new Holidays(53L, "30 sierpnia", "Dzień Rekina Wielorybiego", Month.AUGUST);
        Holidays chinchillaDay = new Holidays(54L, "30 sierpnia", "Dzień Szynszyli", Month.AUGUST);
        Holidays batNight = new Holidays(55L, "Noc między ostatnią sobotą a niedzielą sierpnia", "Noc Nietoperzy", Month.AUGUST);

        Holidays mooseDay = new Holidays(56L, "16 września", "Dzień Łosia", Month.SEPTEMBER);
        Holidays wildFloraFaunaDay = new Holidays(57L, "19 września", "Dzień Dzikiej Flory, Fauny i Naturalnych Siedlisk", Month.SEPTEMBER);
        Holidays rhinoDay = new Holidays(58L, "22 września", "Dzień Nosorożca", Month.SEPTEMBER);
        Holidays gorillaDay = new Holidays(59L, "24 września", "Dzień Goryla", Month.SEPTEMBER);
        Holidays vultureDay = new Holidays(60L, "Pierwsza sobota września", "Dzień Sępa", Month.SEPTEMBER);
        Holidays rabbitDay = new Holidays(61L, "Czwarta sobota września", "Dzień Królika", Month.SEPTEMBER);

        Holidays gliderDay = new Holidays(62L, "1 października", "Dzień Szopa Pracza", Month.OCTOBER);
        Holidays livestockDay = new Holidays(63L, "2 października", "Dzień Zwierząt Hodowlanych", Month.OCTOBER);
        Holidays worldAnimalDay = new Holidays(64L, "4 października", "Światowy Dzień Zwierząt", Month.OCTOBER);
        Holidays octopusDay = new Holidays(65L, "8 października", "Dzień Ośmiornicy", Month.OCTOBER);
        Holidays fishMigrationDay = new Holidays(66L, "24 października", "Dzień Migracji Ryb", Month.OCTOBER);
        Holidays mongrelDay = new Holidays(67L, "25 października", "Dzień Kundelka", Month.OCTOBER);
        Holidays animalRemembranceDay = new Holidays(68L, "1 niedziela października", "Dzień Pamięci o Zmarłych Zwierzętach", Month.OCTOBER);
        Holidays eggDay = new Holidays(69L, "2 piątek października", "Dzień Jaja", Month.OCTOBER);

        Holidays jellyfishDay = new Holidays(70L, "3 listopada", "Dzień Meduzy", Month.NOVEMBER);
        Holidays hedgehogDay = new Holidays(71L, "10 listopada", "Dzień Jeża", Month.NOVEMBER);
        Holidays blackCatDay = new Holidays(72L, "17 listopada", "Dzień Czarnego Kota", Month.NOVEMBER);
        Holidays walrusDay = new Holidays(73L, "24 listopada", "Dzień Morsa", Month.NOVEMBER);

        Holidays cheetahDay = new Holidays(74L, "4 grudnia", "Dzień Geparda", Month.DECEMBER);
        Holidays llamaDay = new Holidays(75L, "9 grudnia", "Dzień Lamy", Month.DECEMBER);
        Holidays monkeyDay = new Holidays(76L, "14 grudnia", "Dzień Małpy", Month.DECEMBER);
        Holidays fishDay = new Holidays(77L, "20 grudnia", "Dzień Ryby", Month.DECEMBER);

        holidayRepository.saveAll(Arrays.asList(eagleDay, penguinDay, squirrelDay, zebraDay, groundhogDay, hippoDay,
                catDay, polarBearDay, whaleDay, wildlifeDay, butterflyDay, pandaDay, frogDay, puppyDay, birdDay, animalDay,
                beaverDay, pigeonDay, hamsterDay, dolphinDay, elephantDay, penguin2Day, horseDay, tunaDay, koalaDay, kangarooDay,
                beeDay, parrotDay, animalRightsDay, turtleDay, storkDay, migratoryBirdsDay, endangeredSpeciesDay, otterDay));
        System.out.println("added");
    }
}

