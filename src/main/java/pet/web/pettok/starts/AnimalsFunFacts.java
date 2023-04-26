package pet.web.pettok.starts;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AnimalsFunFacts {
    @Bean
    public Elements animalsFacts() {
        try {
            Document doc = Jsoup
                    .connect("https://fajnepodroze.pl/ciekawostki-o-zwierzetach/")
                    .get();
            Elements links = doc.select("p");
            return links;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
