package com.karthik.eventmanagment.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.karthik.eventmanagment.bean.Participant;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

}
