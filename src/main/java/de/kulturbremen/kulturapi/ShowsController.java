package de.kulturbremen.kulturapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ShowsController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * controller for /shows
     * @param allParams contains 'startdate' and 'stopdate' or null
     * @return Shows object with custom start and stop date, or standard (a week from now)
     */
    @GetMapping("/shows")
    public Shows show(@RequestParam Map<String,String> allParams){
        // url: /shows/?startdate=2020-09-30T12:29:29Z&stopdate=2020-10-02T12:29:29Z or
        // /shows
        DataService ds = new DataService(jdbcTemplate);
        return ds.queryShows(allParams.get("startdate"), allParams.get("stopdate"));
    }
}
