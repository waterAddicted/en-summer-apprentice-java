package com.endava.demo.repository;

import com.endava.demo.model.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenuesRepository extends CrudRepository<Venue, Long> {
}
