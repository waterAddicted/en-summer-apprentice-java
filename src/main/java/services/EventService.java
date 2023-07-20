package services;

import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EventsRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EventService implements IEventService{
    private EventsRepository eventRepo;

    public EventService(EventsRepository eventRepo){
        this.eventRepo = eventRepo;
    }

    @Override
    public EventsRepository getEventRepo(){
        return this.eventRepo;
    }

    @Override
    public Event createEvent(Event event) {
        return this.eventRepo.save(event);
    }

    @Override
    public Event fetchOneEvent(Long eventID) {
        return this.eventRepo.findById(eventID).get();
    }

    @Override
    public List<Event> fetchAllEvents() {
        return (List<Event>) this.eventRepo.findAll();
    }

    @Override
    public void deleteEvent(Long eventID) {
        this.eventRepo.deleteById(eventID);
    }

    @Override
    public Event updateEvent(Event event, Long eventID) {
        Event updateEvent = this.eventRepo.findById(eventID).get();
        updateEvent.setEventName(event.getEventName());
        updateEvent.setEventDescription(event.getEventDescription());
        updateEvent.setStartDate(event.getStartDate());
        updateEvent.setEndDate(event.getEndDate());
        return this.eventRepo.save(updateEvent);
    }
}
