package de.kulturbremen.kulturapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DataService {
    private static final Logger log = LoggerFactory.getLogger(DataService.class);

    private final JdbcTemplate jdbcTemplate;

    public DataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Show> queryShows() {
        log.info("query info here maybe:");
        return jdbcTemplate.query(
                "SELECT date_time, title, description, url_info, location, category, dubbed FROM shows LIMIT ?",
                new Object[] { 5 },
                new ShowRowMapper()
        );
    }

    public static class ShowRowMapper implements RowMapper<Show>{
        @Override
        public Show mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Show(
                    rs.getString("title"),
                    null,
                    rs.getString("description"),
                    rs.getString("url_info"),
                    rs.getString("location"),
                    rs.getString("category"),
                    rs.getBoolean("dubbed")
                    );
        }
    }
}
