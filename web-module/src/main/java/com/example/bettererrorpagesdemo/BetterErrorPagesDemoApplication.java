package com.example.bettererrorpagesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BetterErrorPagesDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetterErrorPagesDemoApplication.class, args);
	}

	@Bean
	SampleServiceFromModule sampleServiceFromModule() {
		return new SampleServiceFromModule();
	}
}
