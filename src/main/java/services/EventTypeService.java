package services;

import model.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EventTypesRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EventTypeService implements IEventTypeService{
    private EventTypesRepository EventTypeRepo;

    public EventTypeService(EventTypesRepository EventTypeRepo){
        this.EventTypeRepo = EventTypeRepo;
    }

    @Override
    public EventTypesRepository getEventTypeRepo(){
        return this.EventTypeRepo;
    }

    @Override
    public EventType createEventType(EventType EventType) {
        return this.EventTypeRepo.save(EventType);
    }

    @Override
    public EventType fetchOneEventType(Long EventTypeID) {
        return this.EventTypeRepo.findById(EventTypeID).get();
    }

    @Override
    public List<EventType> fetchAllEventTypes() {
        return (List<EventType>) this.EventTypeRepo.findAll();
    }

    @Override
    public void deleteEventType(Long EventTypeID) {
        this.EventTypeRepo.deleteById(EventTypeID);
    }

    @Override
    public EventType updateEventType(EventType EventType, Long EventTypeID) {
        EventType updateEventType = this.EventTypeRepo.findById(EventTypeID).get();
        updateEventType.setEventtypeName(EventType.getEventtypeName());
        return this.EventTypeRepo.save(updateEventType);
    }
}
