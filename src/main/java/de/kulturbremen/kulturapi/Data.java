package de.kulturbremen.kulturapi;

import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Data {
//    private static final Logger logger = LoggerFactory.getLogger(Data.class);

    public static Shows getTestShows(String startDate, String stopDate) {

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

        ZonedDateTime start = convertUserDate(startDate, ZonedDateTime.now());
        ZonedDateTime stop = convertUserDate(stopDate, ZonedDateTime.now().plusDays(7));
        return new Shows(shows, ZonedDateTime.now(), start, stop);
    }

    /**
     * convert an ISO8601 UTC date string to a ZonedDateTime
     * @param userDate a ISO8601 UTC date (e.g. 2020-09-30T12:29:29Z)
     * @param alternativeDate date to use in case userDate is null or parseException is raised
     * @return a ZonedDateTime representation of that string, or now if failes
     */
    private static ZonedDateTime convertUserDate(String userDate, ZonedDateTime alternativeDate){
        if (userDate == null) {
            return alternativeDate;}
        try {
            return ZonedDateTime.parse(userDate);
        } catch (DateTimeParseException exception) {
            return alternativeDate;
        }

    }
}
