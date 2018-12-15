package com.karthik.eventmanagment.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.karthik.eventmanagment.bean.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

}
