package com.endava.demo.repository;


import com.endava.demo.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends CrudRepository <Event, Long> {
}
