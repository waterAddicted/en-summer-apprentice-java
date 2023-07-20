package services;

import model.Venue;
import repository.VenuesRepository;

import java.util.List;

public interface IVenueService {
    VenuesRepository getVenueRepo();
    Venue createVenue(Venue Venue);
    Venue fetchOneVenue(Long VenueID);
    List<Venue> fetchAllVenues();
    void deleteVenue(Long VenueID);
    Venue updateVenue(Venue Venue, Long VenueID);
}
