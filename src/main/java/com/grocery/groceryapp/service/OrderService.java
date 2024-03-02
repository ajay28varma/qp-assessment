package com.grocery.groceryapp.service;

import com.grocery.groceryapp.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
    List<Order> getOrdersByUserId(Long userId);
}
