package com.endava.demo.services;

import com.endava.demo.model.Order;
import org.springframework.stereotype.Service;
import com.endava.demo.repository.OrdersRepository;

import java.util.List;

@Service
public class OrderService implements IOrderService{
    private OrdersRepository OrderRepo;

    public OrderService(OrdersRepository OrderRepo){
        this.OrderRepo = OrderRepo;
    }

    @Override
    public OrdersRepository getOrderRepo(){
        return this.OrderRepo;
    }

    @Override
    public Order createOrder(Order Order) {
        return this.OrderRepo.save(Order);
    }

    @Override
    public Order fetchOneOrder(Long OrderID) {
        return this.OrderRepo.findById(OrderID).get();
    }

    @Override
    public List<Order> fetchAllOrders() {
        return (List<Order>) this.OrderRepo.findAll();
    }

    @Override
    public void deleteOrder(Long OrderID) {
        this.OrderRepo.deleteById(OrderID);
    }

    @Override
    public Order updateOrder(Order Order, Long OrderID) {
        Order updateOrder = this.OrderRepo.findById(OrderID).get();
        updateOrder.setTicketCategory(Order.getTicketCategory());
        updateOrder.setOrderAt(Order.getOrderAt());
        updateOrder.setNumberOfTickets(Order.getNumberOfTickets());
        updateOrder.setTotalPrice(Order.getTotalPrice());
        return this.OrderRepo.save(updateOrder);
    }
}
