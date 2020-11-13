package de.kulturbremen.kulturapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KulturApiApplication {

	private static final Logger log = LoggerFactory.getLogger(KulturApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(KulturApiApplication.class, args);
	}


}
