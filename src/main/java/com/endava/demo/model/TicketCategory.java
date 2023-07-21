package com.endava.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ticket_category")
public class TicketCategory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_category_id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String description;

    private int price;

    // Constructors

    // Getters and Setters
    public Long getTicketCategoryId() {
        return ticket_category_id;
    }

    public void setTicketCategoryId(Long ticket_category_id) {
        this.ticket_category_id = ticket_category_id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
