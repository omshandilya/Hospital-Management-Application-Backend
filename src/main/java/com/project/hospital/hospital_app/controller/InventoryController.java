package com.project.hospital.hospital_app.controller;


import com.project.hospital.hospital_app.dto.InventoryDTO;
import com.project.hospital.hospital_app.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<InventoryDTO> createInventory(@RequestBody InventoryDTO inventoryDTO) {
        InventoryDTO createdInventory = inventoryService.createInventory(inventoryDTO);
        return ResponseEntity.ok(createdInventory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryDTO> updateInventory(@PathVariable Long id, @RequestBody InventoryDTO inventoryDTO) {
        InventoryDTO updatedInventory = inventoryService.updateInventory(id, inventoryDTO);
        return ResponseEntity.ok(updatedInventory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDTO> getInventoryById(@PathVariable Long id) {
        InventoryDTO inventoryDTO = inventoryService.getInventoryById(id);
        return ResponseEntity.ok(inventoryDTO);
    }

    @GetMapping
    public ResponseEntity<List<InventoryDTO>> getAllInventories() {
        List<InventoryDTO> inventories = inventoryService.getAllInventories();
        return ResponseEntity.ok(inventories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }
    // Update quantity by item name
    @PutMapping("/update-quantity")
    public ResponseEntity<InventoryDTO> updateInventoryQuantity(
            @RequestParam String itemName,
            @RequestParam Integer quantity) {

        // Call the service method to update the quantity
        InventoryDTO updatedItem = inventoryService.updateQuantityByName(itemName, quantity);

        return ResponseEntity.ok(updatedItem);
    }
}
