package repository;

import model.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface VenuesRepository extends CrudRepository<Venue, Long> {
}
