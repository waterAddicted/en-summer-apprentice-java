package services;

import model.EventType;
import repository.EventTypesRepository;

import java.util.List;

public interface IEventTypeService {
    EventTypesRepository getEventTypeRepo();
    EventType createEventType(EventType EventType);
    EventType fetchOneEventType(Long EventTypeID);
    List<EventType> fetchAllEventTypes();
    void deleteEventType(Long EventTypeID);
    EventType updateEventType(EventType EventType, Long EventTypeID);
}
