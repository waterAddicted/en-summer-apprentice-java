package repository;


import model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventsRepository extends CrudRepository <Event, Long> {
}
