package com.actio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ActioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActioApplication.class, args);
	}

}
