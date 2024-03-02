package com.grocery.groceryapp.service.impl;

import com.grocery.groceryapp.model.GroceryItem;
import com.grocery.groceryapp.repository.GroceryItemRepository;
import com.grocery.groceryapp.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    @Override
    public void removeGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }

    @Override
    public GroceryItem updateGroceryItem(Long id, GroceryItem updatedItem) {
        updatedItem.setId(id);
        return groceryItemRepository.save(updatedItem);
    }

    @Override
    public void manageInventory(Long id, int count) {
        GroceryItem item = groceryItemRepository.getById(id);
        item.setInventoryCount(count);
        groceryItemRepository.save(item);
    }
}