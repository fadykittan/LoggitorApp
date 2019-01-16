package com.LoggitorApp.LoggitorApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LoggitorAppApplication {

	private static final Logger logger = LoggerFactory.getLogger(LoggitorAppApplication.class);

	
	
	public static void main(String[] args) {
		SpringApplication.run(LoggitorAppApplication.class, args);
		
		logger.info("Hello Sping Boot!");
	}

}

