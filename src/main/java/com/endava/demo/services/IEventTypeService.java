package com.endava.demo.services;

import com.endava.demo.model.EventType;
import com.endava.demo.repository.EventTypesRepository;

import java.util.List;

public interface IEventTypeService {
    EventTypesRepository getEventTypeRepo();
    EventType createEventType(EventType EventType);
    EventType fetchOneEventType(Long EventTypeID);
    List<EventType> fetchAllEventTypes();
    void deleteEventType(Long EventTypeID);
    EventType updateEventType(EventType EventType, Long EventTypeID);
}
