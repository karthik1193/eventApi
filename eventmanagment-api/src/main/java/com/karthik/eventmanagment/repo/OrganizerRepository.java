package com.karthik.eventmanagment.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.karthik.eventmanagment.bean.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}
