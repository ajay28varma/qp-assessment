package com.grocery.groceryapp.controller;

import com.grocery.groceryapp.exceptions.ResourceNotFoundException;
import com.grocery.groceryapp.model.GroceryItem;
import com.grocery.groceryapp.model.Order;
import com.grocery.groceryapp.service.GroceryItemService;
import com.grocery.groceryapp.service.OrderService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private GroceryItemService groceryItemService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/grocery-items")
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        List<GroceryItem> allGroceryItems = groceryItemService.getAllGroceryItems();
        if (allGroceryItems == null || allGroceryItems.size() == 0) {
            throw new ResourceNotFoundException("Grocery items not present");
        }
        return ResponseEntity.ok(allGroceryItems);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody @NotNull Order order) {
        Long userId = order.getUserId();
        return orderService.createOrder(order);
    }

    @GetMapping("/orders/{userId}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable @NotNull Long userId) {
        List<Order> orderList = orderService.getOrdersByUserId(userId);
        if (orderList == null  || orderList.size() == 0) {
            throw new ResourceNotFoundException("Orders not present for given userId: "+ userId);
        }
        return ResponseEntity.ok(orderList);
    }
}
