package com.endava.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order{
    @Id
    private Long order_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ticket_category_id")
    private TicketCategory ticketCategory;

    @Temporal(TemporalType.TIMESTAMP)
    private Date order_at;

    private int number_of_tickets;

    private int total_price;

    // Constructors

    // Getters and Setters
    public Long getOrderId() {
        return order_id;
    }

    public void setOrderId(Long order_id) {
        this.order_id = order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(TicketCategory ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public Date getOrderAt() {
        return order_at;
    }

    public void setOrderAt(Date order_at) {
        this.order_at = order_at;
    }

    public int getNumberOfTickets() {
        return number_of_tickets;
    }

    public void setNumberOfTickets(int number_of_tickets) {
        this.number_of_tickets = number_of_tickets;
    }

    public int getTotalPrice() {
        return total_price;
    }

    public void setTotalPrice(int total_price) {
        this.total_price = total_price;
    }
}
