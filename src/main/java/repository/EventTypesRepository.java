package repository;


import model.Event;
import model.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventTypesRepository extends CrudRepository <EventType, Long> {
}
