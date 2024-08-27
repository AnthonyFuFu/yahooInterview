package com.yahooInterview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class YahooInterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(YahooInterviewApplication.class, args);
	}

}
