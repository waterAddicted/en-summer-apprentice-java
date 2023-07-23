package com.endava.demo.model.DTOs;


public class TicketCategoryDTO {
    private Long ticketCategoryID;
    private String description;
    private int price;

    public TicketCategoryDTO(Long ticketCategoryID, String description, int price) {
        this.ticketCategoryID = ticketCategoryID;
        this.description = description;
        this.price = price;
    }

    public Long getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(Long ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
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