package com.karthik.eventmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.karthik.eventmanagment.bean.Participant;
import com.karthik.eventmanagment.controller.exceptions.AlreadyCheckedInException;
import com.karthik.eventmanagment.repo.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckinController { 
	
	@Autowired
	private ParticipantRepository participantRepository;
	
	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler) {
		Participant participant= participantRepository.findOne(id);
		
		if(participant != null) {
			if(participant.getCheckedIn()) {
				throw new AlreadyCheckedInException();
			}
		participant.setCheckedIn(true);
		participantRepository.save(participant);
		}
		return ResponseEntity.ok(assembler.toResource(participant));
	}

}
