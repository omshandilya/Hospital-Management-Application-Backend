package com.project.hospital.hospital_app.Service.ServiceImplementation;

import com.project.hospital.hospital_app.Exception.ResourceNotFoundException;
import com.project.hospital.hospital_app.Repository.InventoryRepository;
import com.project.hospital.hospital_app.Service.InventoryService;
import com.project.hospital.hospital_app.dto.InventoryDTO;

import com.project.hospital.hospital_app.entities.InventoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InventoryDTO createInventory(InventoryDTO inventoryDTO) {
        InventoryEntity inventoryEntity = modelMapper.map(inventoryDTO, InventoryEntity.class);
        InventoryEntity savedInventory = inventoryRepository.save(inventoryEntity);
        return modelMapper.map(savedInventory, InventoryDTO.class);
    }

    @Override
    public InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) {
        InventoryEntity existingInventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory item not found with id: " + id));

        modelMapper.map(inventoryDTO, existingInventory);
        InventoryEntity updatedInventory = inventoryRepository.save(existingInventory);
        return modelMapper.map(updatedInventory, InventoryDTO.class);
    }

    @Override
    public InventoryDTO getInventoryById(Long id) {
        InventoryEntity inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory item not found with id: " + id));
        return modelMapper.map(inventory, InventoryDTO.class);
    }

    @Override
    public List<InventoryDTO> getAllInventories() {
        return inventoryRepository.findAll()
                .stream()
                .map(inventory -> modelMapper.map(inventory, InventoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteInventory(Long id) {
        InventoryEntity inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory item not found with id: " + id));
        inventoryRepository.delete(inventory);
    }

//    custom
    @Override
public InventoryDTO updateQuantityByName(String itemName, Integer quantity) {
    // Find the inventory item by name
    InventoryEntity inventoryItem = inventoryRepository.findByItemName(itemName)
            .orElseThrow(() -> new ResourceNotFoundException("Inventory item not found with name: " + itemName));

    // Update the quantity
    inventoryItem.setQuantityInStock(quantity);

    // Save the updated item
    InventoryEntity updatedItem = inventoryRepository.save(inventoryItem);

    // Return the updated item as DTO
    return modelMapper.map(updatedItem, InventoryDTO.class);
}


}
