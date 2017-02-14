package service.chordsource;

import model.Chords;
import model.ImmutableChords;
import model.Song;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.inject.Singleton;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Singleton
public class UltimateGuitar implements Chordsource {

    private static final Map<Integer, String> searchQueries;
    static {
        Map<Integer, String> querys = new TreeMap<>();
        querys.put(1, "https://www.ultimate-guitar.com/search.php?band_name=*artist*&song_name=*title*&type%5B2%5D=300&rating%5B4%5D=5");
        searchQueries = Collections.unmodifiableMap(querys);
    }

    @Override
    public String getChords(Song s) {
        boolean unsuccessfulQuery = true;
        Set<Chords> chordsSet = new TreeSet<>();
        while(unsuccessfulQuery) {
            System.out.println("New Query started");
            chordsSet.clear();
            unsuccessfulQuery = false;
            for (String query : searchQueries.values()) {
                String specificQuery = query.replace("*artist*", formatInput(s.artist())).replace("*title*", formatInput(s.title()));
                try {
                    Document search = Jsoup.connect(specificQuery).get();
                    Elements chordLinks = search.select("strong:containsOwn(chords)");
                    for (Element e : chordLinks) {
                        Element row = e.parent().parent();
                        Integer rating = row.getElementsByClass("icon-rating-sm__active").size();
                        Integer votes = 0;
                        Element votesElement = row.getElementsByClass("ratdig").first();
                        if (votesElement != null)
                            votes = Integer.parseInt(votesElement.text());
                        String link = row.getElementsByTag("a").first().attr("href");
                        String title = row.getElementsByTag("a").first().text();
                        if (title.equals("THIS APP DOESN'T HAVE RIGHTS TO DISPLAY TABS")) {
                            continue;
                        }
                        Chords c = ImmutableChords.builder().rating(rating).votes(votes).link(link).title(title).build();
                        chordsSet.add(c);
                    }
                } catch (HttpStatusException e) {
                    if (e.getStatusCode() == 404) {
                        System.out.println("404");
                        continue;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("\nQuery finished");
        chordsSet.forEach(c -> System.out.println(c.title()+" Rating: "+c.rating()+"x"+c.votes()+" "+c.link()));
        Optional<Chords> bestChordsOptional = chordsSet.stream().findFirst();
        if(bestChordsOptional.isPresent()) {
            try {
                Document chordHtml = Jsoup.connect(bestChordsOptional.get().link()).get();
                Element printElement = chordHtml.getElementById("print_link");
                Element contetElement = chordHtml.getElementById("cont");
                String printLink = "https://tabs.ultimate-guitar.com"+printElement.attr("href");
                System.out.println(printLink);
                Desktop.getDesktop().browse(new URI(printLink));
                //Desktop.getDesktop().browse(new URI(bestChordsOptional.get().link()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        else
            System.out.println("No Chords found");
        return null;
    }

    private String formatInput(String s) {
        return s.replace("'", "")
                .replace("`","")
                .replace("´","")
                .replace("’","");
    }
}
