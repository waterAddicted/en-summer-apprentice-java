package com.endava.demo.controllers;


import com.endava.demo.services.IEventService;
import com.endava.demo.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Event")
public class EventController {
    @Autowired
    private IEventService EventService;

    public EventController(com.endava.demo.services.EventService EventService){
        this.EventService = EventService;
    }

    @GetMapping("/{EventID}")
    public Event fetchOneEvent(@PathVariable("EventID") long EventID){
        return this.EventService.fetchOneEvent(EventID);
    }

    @GetMapping("/events")
    public List<Event> fetchAllEvents(){
        return this.EventService.fetchAllEvents();
    }

    @PostMapping
    public Event registerEvent(@RequestBody Event Event){
        return this.EventService.createEvent(Event);
    }

    @PutMapping("/{EventID}")
    public Event updateEvent(@RequestBody Event Event, @PathVariable("EventID") long EventID){
        return this.EventService.updateEvent(Event, EventID);
    }

    @DeleteMapping("/{EventID}")
    public void deleteEvent(@PathVariable("EventID") long EventID){
        this.EventService.deleteEvent(EventID);
    }
}
