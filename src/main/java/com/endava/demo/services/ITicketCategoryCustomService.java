package com.endava.demo.services;


import com.endava.demo.model.TicketCategory;
import java.util.List;

public interface ITicketCategoryCustomService {
    TicketCategory fetchOneTicketCategory(Long ticketCategoryID);
    List<TicketCategory> fetchAllTicketCategory();
    TicketCategory createTicketCategory(TicketCategory ticketCategory, Long eventID);
    TicketCategory updateTicketCategory(TicketCategory ticketCategory, Long ticketCategoryID);
    void deleteTicketCategory(Long ticketCategoryID);
}