package com.example.outBox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OutBoxApplication {
	public static void main(String[] args) {
		SpringApplication.run(OutBoxApplication.class, args);
	}
}
