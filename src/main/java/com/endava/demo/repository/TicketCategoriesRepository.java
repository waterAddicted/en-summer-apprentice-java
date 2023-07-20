package com.endava.demo.repository;

import com.endava.demo.model.TicketCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCategoriesRepository extends CrudRepository<TicketCategory, Long> {
}
