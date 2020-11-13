package de.kulturbremen.kulturapi;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class DataService {

    private final JdbcTemplate jdbcTemplate;

    public DataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Shows queryShows(String start, String stop) {
        Instant startInstant = convertUserDate(start, Instant.now());
        Instant stopInstant = convertUserDate(stop, Instant.now().plus(7, ChronoUnit.DAYS));
        return queryShows(startInstant, stopInstant);
    }

    public Shows queryShows(Instant start, Instant stop) {
        Timestamp startTimeStamp= Timestamp.from(start);
        Timestamp stopTimeStamp = Timestamp.from(stop);
        List<Show> shows = jdbcTemplate.query(
                "SELECT date_time, title, description, url_info, location, category, dubbed FROM shows " +
                "WHERE date_time >= ? and date_time < ? " +
                "ORDER BY date_time",
                new Object[] { startTimeStamp, stopTimeStamp },
                new ShowRowMapper()
        );
        return new Shows(shows, Instant.now(), start, stop);
    }

    /**
     * convert an ISO8601 UTC date string to a ZonedDateTime
     * @param userDate a ISO8601 UTC date (e.g. 2020-09-30T12:29:29Z)
     * @param alternativeDate date to use in case userDate is null or parseException is raised
     * @return a ZonedDateTime representation of that string, or now if fails
     */
    private Instant convertUserDate(String userDate, Instant alternativeDate){
        if (userDate == null) {
            return alternativeDate;}
        try {
            return Instant.parse(userDate);
        } catch (DateTimeParseException exception) {
            return alternativeDate;
        }

    }

    public static class ShowRowMapper implements RowMapper<Show>{
        @Override
        public Show mapRow(ResultSet rs, int rowNum) throws SQLException {

            return new Show(
                    rs.getString("title"),
                    getDateTime(rs),
                    rs.getString("description"),
                    rs.getString("url_info"),
                    rs.getString("location"),
                    rs.getString("category"),
                    rs.getBoolean("dubbed")
                    );
        }

        private Instant getDateTime(ResultSet rs) throws SQLException{
            Timestamp date_time = rs.getTimestamp("date_time");
            if (date_time != null) {
                return date_time.toInstant();
            } else {
                return null;
            }
        }
    }
}
