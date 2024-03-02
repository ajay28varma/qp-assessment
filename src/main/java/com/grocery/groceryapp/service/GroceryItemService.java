package com.grocery.groceryapp.service;

import com.grocery.groceryapp.model.GroceryItem;

import java.util.List;

public interface GroceryItemService {
    List<GroceryItem> getAllGroceryItems();
    GroceryItem addGroceryItem(GroceryItem groceryItem);
    void removeGroceryItem(Long id);
    GroceryItem updateGroceryItem(Long id, GroceryItem updatedItem);
    void manageInventory(Long id, int count);
}