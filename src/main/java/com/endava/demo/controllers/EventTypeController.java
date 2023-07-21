package com.endava.demo.controllers;


import com.endava.demo.services.IEventTypeService;
import com.endava.demo.model.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/EventType")
public class EventTypeController {
    @Autowired
    private IEventTypeService EventTypeService;

    public EventTypeController(com.endava.demo.services.EventTypeService EventTypeService){
        this.EventTypeService = EventTypeService;
    }

    @GetMapping("/{EventTypeID}")
    public EventType fetchOneEventType(@PathVariable("EventTypeID") long EventTypeID){
        return this.EventTypeService.fetchOneEventType(EventTypeID);
    }

    @GetMapping("/EventTypes")
    public List<EventType> fetchAllEventTypes(){
        return this.EventTypeService.fetchAllEventTypes();
    }

    @PostMapping
    public EventType registerEventType(@RequestBody EventType EventType){
        return this.EventTypeService.createEventType(EventType);
    }

    @PutMapping("/{EventTypeID}")
    public EventType updateEventType(@RequestBody EventType EventType, @PathVariable("EventTypeID") long EventTypeID){
        return this.EventTypeService.updateEventType(EventType, EventTypeID);
    }

    @DeleteMapping("/{EventTypeID}")
    public void deleteEventType(@PathVariable("EventTypeID") long EventTypeID){
        this.EventTypeService.deleteEventType(EventTypeID);
    }
}
