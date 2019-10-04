package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class Junit5sampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Junit5sampleApplication.class, args);
	}

	@Bean
	public MathUtil getMathUtil() {
		return new MathUtil();
	}

}
