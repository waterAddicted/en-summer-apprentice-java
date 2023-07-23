package com.endava.demo.services;


import com.endava.demo.model.DTOs.EventVenueEventTypeDTO;
import com.endava.demo.model.Event;

import java.util.List;

public interface IEventCustomService {
    Event createEvent(Event event, Long venueID, Long eventTypeID);
    Event fetchOneEvent(Long eventID);
    List<Event> fetchAllEvents();
    void deleteEvent(Long eventID);
    Event updateEvent(Event event, Long eventID);
}