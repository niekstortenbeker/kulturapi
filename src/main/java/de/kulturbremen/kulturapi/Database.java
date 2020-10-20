package de.kulturbremen.kulturapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;


public class Database {
    private static final Logger log = LoggerFactory.getLogger(Database.class);

    private final JdbcTemplate jdbcTemplate;

    public Database(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public void queryShows() {
//        jdbcTemplate.query(
//                "SELECT date_time, title, description, url_info, location, category, dubbed FROM shows LIMIT ?",
//                new Object[] { 5 },
//                (rs, rowNum) -> new Show(rs.getString("title"),
//                        rs.getString("description"),
//                        rs.getString("url_info"),
//                        rs.getString("location"),
//                        rs.getString("category"))
//        ).forEach(show -> log.info(show.toString()));
//    }

    public int simpleQuery() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(title) FROM shows", Integer.class);
        return (count == null) ? 0 : count;
    }
}
