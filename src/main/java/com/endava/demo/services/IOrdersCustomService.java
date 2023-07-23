package com.endava.demo.services;

import com.endava.demo.model.DTOs.EventOrdersDTO;
import com.endava.demo.model.Order;
import java.util.List;

public interface IOrdersCustomService {
    Order createOrder(Order orders, Long customerID, Long ticketCategoryID);

    EventOrdersDTO fetchOneByuserID(Long userID);

    EventOrdersDTO placeOrderByEventID(Long eventID, Long ticketCategoryID, Long userID, int numberOfTicketsID);
    EventOrdersDTO fetchOneByUserID(Long userID);
    Order fetchOneOrder(Long orderID);
    List<Order> fetchAllOrders();
    Order updateOrder(Order orders, Long orderID);
    void deleteOrder(Long orderID);
}