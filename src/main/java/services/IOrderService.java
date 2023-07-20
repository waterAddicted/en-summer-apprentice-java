package services;

import model.Order;
import repository.OrdersRepository;

import java.util.List;

public interface IOrderService {
    OrdersRepository getOrderRepo();
    Order createOrder(Order Order);
    Order fetchOneOrder(Long OrderID);
    List<Order> fetchAllOrders();
    void deleteOrder(Long OrderID);
    Order updateOrder(Order Order, Long OrderID);
}
