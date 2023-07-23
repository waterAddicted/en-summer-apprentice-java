package com.endava.demo.services;

import com.endava.demo.model.DTOs.EventOrdersDTO;
import com.endava.demo.model.Order;
import com.endava.demo.model.TicketCategory;
import com.endava.demo.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class OrdersCustomService implements IOrdersCustomService{
    private IOrderService ordersService;

    private IUserService userService;
    private ITicketCategoryService ticketCategoryService;

    public OrdersCustomService(IOrderService ordersService, IUserService userService, ITicketCategoryService ticketCategoryService){
        this.userService = userService;
        this.ordersService = ordersService;
        this.ticketCategoryService = ticketCategoryService;
    }


    @Override
    public Order createOrder(Order orders, Long userID, Long ticketCategoryID) {
        User user = (User) this.userService.getUserRepo().findById(userID).get();
        TicketCategory ticketCategory = this.ticketCategoryService.getTicketCategoryRepo().findById(ticketCategoryID).get();
        orders.setUser((com.endava.demo.model.User) user);
        orders.setTicketCategory(ticketCategory);
        return this.ordersService.createOrder(orders);
    }

    @Override
    public EventOrdersDTO fetchOneByuserID(Long userID) {
        List<Order> ordersList = this.ordersService.fetchAllOrders();
        for(Order orders: ordersList){
            if(Objects.equals(orders.getUser().getUserId(), userID)){
                return new EventOrdersDTO(
                        orders.getTicketCategory().getEvent().getEventId(),
                        orders.getOrderAt(),
                        orders.getTicketCategory().getTicketCategoryId(),
                        orders.getNumberOfTickets(),
                        orders.getTotalPrice()
                );
            }
        }
        return null;
    }

    @Override
    public EventOrdersDTO placeOrderByEventID(Long eventID, Long ticketCategoryID, Long userID, int numberOfTickets) {
        TicketCategory ticketCategory = this.ticketCategoryService.fetchOneTicketCategory(ticketCategoryID);
        Integer totalPrice = ticketCategory.getPrice();
        Order orders = new Order();
        orders.setOrderAt(new Date());
        orders.setNumberOfTickets(numberOfTickets);
        orders.setTotalPrice(totalPrice);

        this.createOrder(orders, userID, ticketCategoryID);
        return new EventOrdersDTO(
                eventID,
                orders.getOrderAt(),
                ticketCategoryID,
                numberOfTickets,
                totalPrice
        );
    }

    @Override
    public EventOrdersDTO fetchOneByUserID(Long userID) {
        return null;
    }

    @Override
    public Order fetchOneOrder(Long orderID) {
        return this.ordersService.fetchOneOrder(orderID);
    }

    @Override
    public List<Order> fetchAllOrders() {
        return this.ordersService.fetchAllOrders();
    }

    @Override
    public Order updateOrder(Order orders, Long orderID) {
        return this.ordersService.updateOrder(orders, orderID);
    }

    @Override
    public void deleteOrder(Long orderID) {
        this.ordersService.deleteOrder(orderID);
    }
}