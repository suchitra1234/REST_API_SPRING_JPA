package com.example.easynotesexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EasyNotesExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyNotesExamplesApplication.class, args);
	}
}
