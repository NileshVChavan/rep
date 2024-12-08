package com.grocery.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.grocery.entity.GroceryItem;
import com.grocery.responsebean.GroceryItemResponseBean;
import com.grocery.responsebean.GroceryItemsResponseBean;
import com.grocery.service.GroceryService;
import com.grocery.serviceImpl.GroceryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping("/grocery-items")
//   @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<GroceryItemResponseBean> addItem(@RequestBody List<GroceryItem> item) {
        return ResponseEntity.ok(groceryService.addGroceryItem(item));
    }

    @GetMapping("/grocery-items")
    public ResponseEntity<GroceryItemsResponseBean> getAllItems() {
        return ResponseEntity.ok(groceryService.getAllGroceryItems());
    }

    @DeleteMapping("/grocery-items/{id}")
    public ResponseEntity<GroceryItemResponseBean> deleteItem(@PathVariable Long id) {
        groceryService.deleteGroceryItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/grocery-items/{id}")
    public ResponseEntity<GroceryItem> updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return ResponseEntity.ok(groceryService.updateGroceryItem(id, item));
    }
}
