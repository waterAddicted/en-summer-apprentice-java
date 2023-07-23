package com.endava.demo.services;

import com.endava.demo.model.DTOs.EventVenueEventTypeDTO;
import com.endava.demo.model.DTOs.TicketCategoryDTO;
import com.endava.demo.model.DTOs.VenueDTO;
import com.endava.demo.model.Event;
import com.endava.demo.model.EventType;
import com.endava.demo.model.TicketCategory;
import com.endava.demo.model.Venue;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventCustomService implements IEventCustomService{
    private IEventService eventService;
    private IEventTypeService eventTypeService;
    private IVenueService venueService;

    public EventCustomService(EventService eventService, EventTypeService eventTypeService, VenueService venueService){
        this.eventService = eventService;
        this.eventTypeService = eventTypeService;
        this.venueService = venueService;
    }

    @Override
    public Event createEvent(Event event, Long locationID, Long eventTypeID) {
        Venue venue = this.venueService.getVenueRepo().findById(locationID).get();
        EventType eventType = this.eventTypeService.getEventTypeRepo().findById(eventTypeID).get();
        event.setEventType(eventType);
        event.setVenue(venue);
        return this.eventService.createEvent(event);
    }

    @Override
    public Event fetchOneEvent(Long locationID) {
        return this.eventService.fetchOneEvent(locationID);
    }

    private EventVenueEventTypeDTO convertToEventVenueEventTypeDTO(Event event, VenueDTO venueDTO, List<TicketCategoryDTO> ticketCategoryDTOS){
        return new EventVenueEventTypeDTO(
                event.getEventId(),
                venueDTO,
                event.getEventType().getEventtypeName(),
                event.getEventDescription(),
                event.getStartDate(),
                event.getEndDate(),
                ticketCategoryDTOS
        );
    }

    private List<TicketCategoryDTO> convertToTicketCategoryDTOList(List<TicketCategory> ticketCategoryList){
        return ticketCategoryList.stream()
                .map(ticketCategory -> new TicketCategoryDTO(ticketCategory.getTicketCategoryId(), ticketCategory.getDescription(), ticketCategory.getPrice()))
                .collect(Collectors.toList());
    }

    private VenueDTO convertToVenueDTO(Venue venue){
        return new VenueDTO(
                venue.getVenueId(),
                venue.getLocation(),
                venue.getType(),
                venue.getCapacity()
        );
    }

    @Override
    public List<Event> fetchAllEvents() {
        return this.eventService.fetchAllEvents();
    }

    @Override
    public void deleteEvent(Long eventID) {
        this.eventService.deleteEvent(eventID);
    }

    @Override
    public Event updateEvent(Event event, Long eventID) {
        return this.eventService.updateEvent(event, eventID);
    }
}