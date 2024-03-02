package com.grocery.groceryapp.controller;

import com.grocery.groceryapp.exceptions.ResourceNotFoundException;
import com.grocery.groceryapp.model.GroceryItem;
import com.grocery.groceryapp.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/admin/grocery-items")
public class AdminController {

    @Autowired
    private GroceryItemService groceryItemService;

    @PostMapping
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem groceryItem) {
        GroceryItem addedItem = groceryItemService.addGroceryItem(groceryItem);
        if (addedItem == null) {
            throw new ResourceNotFoundException("Grocery items insertion failed for this item : " + groceryItem);
        }
        return ResponseEntity.ok(addedItem);
    }

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        List<GroceryItem> allGroceryItems = groceryItemService.getAllGroceryItems();
        if (allGroceryItems == null || allGroceryItems.size() == 0 ) {
            throw new ResourceNotFoundException("Grocery items not present");
        }
        return ResponseEntity.ok(allGroceryItems);
    }

    @DeleteMapping("/{id}")
    public void removeGroceryItem(@PathVariable Long id) {
        groceryItemService.removeGroceryItem(id);
    }

    @PutMapping("/{id}")
    public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem updatedItem) {
        return groceryItemService.updateGroceryItem(id, updatedItem);
    }

    @PutMapping("/{id}/inventory")
    public void manageInventory(@PathVariable Long id, @RequestParam int count) {
        groceryItemService.manageInventory(id, count);
    }
}
