package com.endava.demo.controllers;


import com.endava.demo.services.IVenueService;
import com.endava.demo.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Venue")
public class VenueController {
    @Autowired
    private IVenueService VenueService;

    public VenueController(com.endava.demo.services.VenueService VenueService){
        this.VenueService = VenueService;
    }

    @GetMapping("/{VenueID}")
    public Venue fetchOneVenue(@PathVariable("VenueID") long VenueID){
        return this.VenueService.fetchOneVenue(VenueID);
    }

    @GetMapping("/Venues")
    public List<Venue> fetchAllVenues(){
        return this.VenueService.fetchAllVenues();
    }

    @PostMapping
    public Venue registerVenue(@RequestBody Venue Venue){
        return this.VenueService.createVenue(Venue);
    }

    @PutMapping("/{VenueID}")
    public Venue updateVenue(@RequestBody Venue Venue, @PathVariable("VenueID") long VenueID){
        return this.VenueService.updateVenue(Venue, VenueID);
    }

    @DeleteMapping("/{VenueID}")
    public void deleteVenue(@PathVariable("VenueID") long VenueID){
        this.VenueService.deleteVenue(VenueID);
    }
}
