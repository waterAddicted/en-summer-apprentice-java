package com.endava.demo.services;

import com.endava.demo.model.Event;
import com.endava.demo.repository.EventsRepository;

import java.util.List;

public interface IEventService {
    EventsRepository getEventRepo();
    Event createEvent(Event event);
    Event fetchOneEvent(Long eventID);
    List<Event> fetchAllEvents();
    void deleteEvent(Long eventID);
    Event updateEvent(Event event, Long eventID);
}
