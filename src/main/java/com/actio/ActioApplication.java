package com.actio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@EnableJpaRepositories
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
public class ActioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActioApplication.class, args);
	}

}
