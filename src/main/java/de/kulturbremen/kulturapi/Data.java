package de.kulturbremen.kulturapi;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Data {
//    private static final Logger logger = LoggerFactory.getLogger(Data.class);

    public static Shows getTestShows(String startDate, String stopDate) {

        List<Show> shows = new ArrayList<>();
        shows.add(new Show(
                "A Dark Past",
                Instant.now(),
                "90 min. A very dark movie",
                "www.city46.de",
                "City 46",
                "film",
                false));
        shows.add(new Show(
                "Der grüne Baum",
                Instant.now(),
                "A theater play",
                "www.theaterbremen.de",
                "Theater Bremen",
                "stage",
                false)) ;

        Instant start = convertUserDate(startDate, Instant.now());
        Instant stop = convertUserDate(stopDate, Instant.now().plus(7, ChronoUnit.DAYS));
        return new Shows(shows, Instant.now(), start, stop);
    }

    /**
     * convert an ISO8601 UTC date string to a ZonedDateTime
     * @param userDate a ISO8601 UTC date (e.g. 2020-09-30T12:29:29Z)
     * @param alternativeDate date to use in case userDate is null or parseException is raised
     * @return a ZonedDateTime representation of that string, or now if fails
     */
    private static Instant convertUserDate(String userDate, Instant alternativeDate){
        if (userDate == null) {
            return alternativeDate;}
        try {
            return Instant.parse(userDate);
        } catch (DateTimeParseException exception) {
            return alternativeDate;
        }

    }
}
