package de.kulturbremen.kulturapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class KulturApiApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(KulturApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(KulturApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("well we got here");
		DataService dataService = new DataService(jdbcTemplate);
		List<Show> shows = dataService.queryShows();
		shows.forEach(show -> log.info(show.toString()));
	}
}
