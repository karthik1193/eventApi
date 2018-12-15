package com.karthik.eventmanagment.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import com.karthik.eventmanagment.bean.Event;
import java.lang.String;
import java.time.ZoneId;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	Page<Event> findByName(@Param("name")String name, Pageable pageable); 
	Page<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId, Pageable pageable); 
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Long id);
}
