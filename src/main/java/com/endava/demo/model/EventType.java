package com.endava.demo.model;

import jakarta.persistence.*;
@Entity
@Table(name = "EventType" )
public class  EventType{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventtypeID;

    @Column(name = "event_type_name")
    private String eventtypeName;

    public EventType(){
    }

    public Long getEventtypeID() {
        return this.eventtypeID;
    }

    public void setEventtypeID(Long eventtypeID) {
        this.eventtypeID = eventtypeID;
    }

    public String getEventtypeName() {
        return this.eventtypeName;
    }

    public void setEventtypeName(String eventtypeName) {
        this.eventtypeName = eventtypeName;
    }
}