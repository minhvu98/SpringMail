package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class SpringMail1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMail1Application.class, args);
	}

}
