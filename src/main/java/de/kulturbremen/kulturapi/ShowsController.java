package de.kulturbremen.kulturapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ShowsController {

    /**
     * controller for /shows
     * @param allParams contains 'startdate' and 'stopdate' or null
     * @return Shows object with custom start and stop date, or standard (a week from now)
     */
    @GetMapping("/shows")
    public Shows show(@RequestParam Map<String,String> allParams){
        // /shows/?startdate=2020-09-30T12:29:29Z&stopdate=2020-10-02T12:29:29Z
        return Data.getTestShows(allParams.get("startdate"), allParams.get("stopdate"));
    }
}
