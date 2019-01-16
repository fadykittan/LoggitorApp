package com.LoggitorApp.LoggitorApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.LoggitorApp.LoggitorApp.domain.Action;
import com.LoggitorApp.LoggitorApp.domain.Action_Repo;
import com.LoggitorApp.LoggitorApp.domain.App;
import com.LoggitorApp.LoggitorApp.domain.App_Repo;
import com.LoggitorApp.LoggitorApp.domain.Defect_Severity;
import com.LoggitorApp.LoggitorApp.domain.Defect_Severity_Repo;
import com.LoggitorApp.LoggitorApp.domain.Event;
import com.LoggitorApp.LoggitorApp.domain.Event_Instance_Repo;
import com.LoggitorApp.LoggitorApp.domain.Event_Repo;
import com.LoggitorApp.LoggitorApp.domain.Event_Severity;
import com.LoggitorApp.LoggitorApp.domain.Event_Severity_Repo;




@SpringBootApplication
public class LoggitorAppApplication {

	private static final Logger logger = LoggerFactory.getLogger(LoggitorAppApplication.class);

	
	@Autowired
	private App_Repo app;
	@Autowired
	private Event_Severity_Repo evSev;
	@Autowired
	private Defect_Severity_Repo defSev;
	@Autowired
	private Action_Repo act;
	@Autowired
	private Event_Repo eve;
	@Autowired
	private Event_Instance_Repo eveIns;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LoggitorAppApplication.class, args);
		
		logger.info("Hello Sping Boot!");
	}
	
	
	
	@Bean
    CommandLineRunner runner(){
      return args -> {
    	  
    	  App a1 = new App("BLM","core");
    	  App a2 = new App("CLM","core");

    	  Event_Severity e1 = new Event_Severity("critical");
    	  Event_Severity e2 = new Event_Severity("error");
    	  
    	  Defect_Severity d1 = new Defect_Severity("d Critical");
    	  Defect_Severity d2 = new Defect_Severity("d error");
    	  
    	  Action ac1 = new Action("SMS","SMS");
    	  Action ac2 = new Action("email","email");
    	  
    	  Event ev1 = new Event();
    	  
    	  
    	  app.save(a1);
    	  app.save(a2);
    	  
    	  evSev.save(e1);
    	  evSev.save(e2);
    	  
    	  
      };
    } 
	
	
	

}

