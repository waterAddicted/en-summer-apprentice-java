package com.endava.demo.services;

import com.endava.demo.model.Venue;
import org.springframework.stereotype.Service;
import com.endava.demo.repository.VenuesRepository;

import java.util.List;

@Service
public class VenueService implements IVenueService{
    private VenuesRepository VenueRepo;

    public VenueService(VenuesRepository VenueRepo){
        this.VenueRepo = VenueRepo;
    }

    @Override
    public VenuesRepository getVenueRepo(){
        return this.VenueRepo;
    }

    @Override
    public Venue createVenue(Venue Venue) {
        return this.VenueRepo.save(Venue);
    }

    @Override
    public Venue fetchOneVenue(Long VenueID) {
        return this.VenueRepo.findById(VenueID).get();
    }

    @Override
    public List<Venue> fetchAllVenues() {
        return (List<Venue>) this.VenueRepo.findAll();
    }

    @Override
    public void deleteVenue(Long VenueID) {
        this.VenueRepo.deleteById(VenueID);
    }

    @Override
    public Venue updateVenue(Venue Venue, Long VenueID) {
        Venue updateVenue = this.VenueRepo.findById(VenueID).get();
        updateVenue.setLocation(Venue.getLocation());
        updateVenue.setType(Venue.getType());
        updateVenue.setCapacity(Venue.getCapacity());
        return this.VenueRepo.save(updateVenue);
    }
}
