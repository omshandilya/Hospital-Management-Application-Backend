package com.project.hospital.hospital_app.Service;

import com.project.hospital.hospital_app.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    InventoryDTO createInventory(InventoryDTO inventoryDTO);
    InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO);
    InventoryDTO getInventoryById(Long id);
    List<InventoryDTO> getAllInventories();
    void deleteInventory(Long id);

    //    custom
    InventoryDTO updateQuantityByName(String itemName, Integer quantity);
}
