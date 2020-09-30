package de.kulturbremen.KulturApi;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static Shows getTestShows() {
        List<Show> shows = new ArrayList<>();
        shows.add(new Show(
                "A Dark Past",
                ZonedDateTime.now(),
                "90 min. A very dark movie",
                "www.city46.de",
                "City 46",
                "film",
                false));
        shows.add(new Show(
                "Der grüne Baum",
                ZonedDateTime.now(),
                "A theater play",
                "www.theaterbremen.de",
                "Theater Bremen",
                "stage",
                false)) ;

        return new Shows(shows, ZonedDateTime.now());
    }
}
