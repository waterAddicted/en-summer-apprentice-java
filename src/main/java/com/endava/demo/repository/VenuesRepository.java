package com.endava.demo.repository;

import com.endava.demo.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenuesRepository extends JpaRepository<Venue, Long> {
}
