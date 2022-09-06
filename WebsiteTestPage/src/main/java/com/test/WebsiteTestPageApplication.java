package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//Inializes the Web Application
@ComponentScan({"com.gcuCLC"})
@SpringBootApplication
public class WebsiteTestPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteTestPageApplication.class, args);
	}

}
