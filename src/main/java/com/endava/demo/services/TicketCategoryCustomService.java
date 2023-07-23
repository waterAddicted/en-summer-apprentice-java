package com.endava.demo.services;

import com.endava.demo.model.Event;
import com.endava.demo.model.TicketCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCategoryCustomService implements ITicketCategoryCustomService{
    private ITicketCategoryService ticketCategoryService;
    private IEventService eventService;

    public TicketCategoryCustomService(TicketCategorieservice ticketCategoryService, EventService eventService) {
        this.ticketCategoryService = ticketCategoryService;
        this.eventService = eventService;
    }

    @Override
    public TicketCategory fetchOneTicketCategory(Long ticketCategoryID) {
        return ticketCategoryService.fetchOneTicketCategory(ticketCategoryID);
    }

    @Override
    public List<TicketCategory> fetchAllTicketCategory() {
        return this.ticketCategoryService.fetchAllTicketCategorys();
    }

    @Override
    public TicketCategory createTicketCategory(TicketCategory ticketCategory, Long eventID) {
        Event event=this.eventService.getEventRepo().findById(eventID).get();
        ticketCategory.setEvent(event);
        return this.ticketCategoryService.createTicketCategory(ticketCategory);
    }

    @Override
    public TicketCategory updateTicketCategory(TicketCategory ticketCategory, Long ticketCategoryID) {
        return this.ticketCategoryService.updateTicketCategory(ticketCategory, ticketCategoryID);
    }

    @Override
    public void deleteTicketCategory(Long ticketCategoryID) {
        this.ticketCategoryService.deleteTicketCategory(ticketCategoryID);
    }
}