package com.endava.demo.services;

import com.endava.demo.model.Venue;
import com.endava.demo.repository.VenuesRepository;

import java.util.List;

public interface IVenueService {
    VenuesRepository getVenueRepo();
    Venue createVenue(Venue Venue);
    Venue fetchOneVenue(Long VenueID);
    List<Venue> fetchAllVenues();
    void deleteVenue(Long VenueID);
    Venue updateVenue(Venue Venue, Long VenueID);
}
