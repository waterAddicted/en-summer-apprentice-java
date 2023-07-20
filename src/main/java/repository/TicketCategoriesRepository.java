package repository;

import model.TicketCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketCategoriesRepository extends CrudRepository<TicketCategory, Long> {
}
