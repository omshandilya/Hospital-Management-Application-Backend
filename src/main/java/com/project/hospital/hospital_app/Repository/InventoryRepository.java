package com.project.hospital.hospital_app.Repository;

import com.project.hospital.hospital_app.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    // Custom query methods if needed
    List<InventoryEntity> findByCategory(String category);
    Optional<InventoryEntity> findByItemName(String itemName);
}
