package com.endava.demo.controllers;


import com.endava.demo.services.IOrderService;
import com.endava.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Order")
public class OrderController {
    @Autowired
    private IOrderService OrderService;

    public OrderController(com.endava.demo.services.OrderService OrderService){
        this.OrderService = OrderService;
    }

    @GetMapping("/{OrderID}")
    public Order fetchOneOrder(@PathVariable("OrderID") long OrderID){
        return this.OrderService.fetchOneOrder(OrderID);
    }

    @GetMapping("/Orders")
    public List<Order> fetchAllOrders(){
        return this.OrderService.fetchAllOrders();
    }

    @PostMapping
    public Order registerOrder(@RequestBody Order Order){
        return this.OrderService.createOrder(Order);
    }

    @PutMapping("/{OrderID}")
    public Order updateOrder(@RequestBody Order Order, @PathVariable("OrderID") long OrderID){
        return this.OrderService.updateOrder(Order, OrderID);
    }

    @DeleteMapping("/{OrderID}")
    public void deleteOrder(@PathVariable("OrderID") long OrderID){
        this.OrderService.deleteOrder(OrderID);
    }
}
