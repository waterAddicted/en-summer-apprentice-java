package com.endava.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "venue" )
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venue_id;

    private String location;

    private String type;

    private int capacity;

    @OneToMany(mappedBy = "venue")
    @JsonIgnore
    private List<Event> eventList;

    public Venue(){
    }

    public Long getVenueId() {
        return venue_id;
    }

    public void setVenueId(Long venue_id) {
        this.venue_id = venue_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
