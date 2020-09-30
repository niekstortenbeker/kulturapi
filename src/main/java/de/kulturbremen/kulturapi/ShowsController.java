package de.kulturbremen.kulturapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowsController {

    @GetMapping("/shows")
    public Shows show(){
        return Data.getTestShows();
    }
}
