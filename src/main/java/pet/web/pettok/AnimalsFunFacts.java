package pet.web.pettok;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AnimalsFunFacts {
//    public static void main(String[] args) {
////        try{
////            Document doc = Jsoup
////                    .connect("https://fajnepodroze.pl/ciekawostki-o-zwierzetach/")
////                    .get();
////            Elements links = doc.select("p");
////            for (int i = 8; i <links.size()-9 ; i++) {
////                System.out.println(links.get(i));
////            }
////
////        }catch (Exception e){
////            e.printStackTrace();
////        }
//    }
    @Bean
    public Elements animalsFacts(){
        try{
            Document doc = Jsoup
                    .connect("https://fajnepodroze.pl/ciekawostki-o-zwierzetach/")
                    .get();
            Elements links = doc.select("p");
//            for (int i = 8; i <links.size()-9 ; i++) {
//                System.out.println(links.get(i));
//                return links.get(i);
//            }
            return links;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
