package com.aakashkumar.microservices.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.aakashkumar.microservices")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
