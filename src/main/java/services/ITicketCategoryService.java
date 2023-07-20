package services;

import model.TicketCategory;
import repository.TicketCategoriesRepository;


import java.util.List;

public interface ITicketCategoryService {
    TicketCategoriesRepository getTicketCategoryRepo();
    TicketCategory createTicketCategory(TicketCategory TicketCategory);
    TicketCategory fetchOneTicketCategory(Long TicketCategoryID);
    List<TicketCategory> fetchAllTicketCategorys();
    void deleteTicketCategory(Long TicketCategoryID);
    TicketCategory updateTicketCategory(TicketCategory TicketCategory, Long TicketCategoryID);
}
