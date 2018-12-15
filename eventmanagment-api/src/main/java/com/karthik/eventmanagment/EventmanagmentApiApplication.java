package com.karthik.eventmanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication 
@EntityScan(basePackageClasses= {EventmanagmentApiApplication.class, Jsr310Converters.class})
public class EventmanagmentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventmanagmentApiApplication.class, args);
	}
}
