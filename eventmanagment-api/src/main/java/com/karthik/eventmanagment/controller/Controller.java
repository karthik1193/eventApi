package com.karthik.eventmanagment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.karthik.eventmanagment.bean.Event;
import com.karthik.eventmanagment.repo.EventRepository;

@RepositoryRestController
@RequestMapping("/events")
public class Controller { 
	
	@Autowired
	private EventRepository eventrepository;
	
	@PostMapping("/start/{id}")
	public ResponseEntity start(@PathVariable Long id) {
		Event event= eventrepository.findOne(id);
		
		if(event == null) {
			throw new ResourceNotFoundException();
		}
		event.setStarted(true); 
		eventrepository.save(event);
		return ResponseEntity.ok(event.getName() + "Has Started");
	} 
}
