package com.amande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AmandeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmandeApplication.class, args);
	}

}
