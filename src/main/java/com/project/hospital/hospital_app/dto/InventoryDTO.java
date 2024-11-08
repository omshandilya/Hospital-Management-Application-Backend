package com.project.hospital.hospital_app.dto;

import lombok.Data;

import java.util.Date;
@Data
public class InventoryDTO {
    private Long itemId;
    private String itemName;
    private String category;
    private Integer quantityInStock;
    private Date expiryDate;
    private String supplierInfo;

    // Constructors
    public InventoryDTO() {}

    public InventoryDTO(Long itemId, String itemName, String category, Integer quantityInStock, Date expiryDate, String supplierInfo) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.quantityInStock = quantityInStock;
        this.expiryDate = expiryDate;
        this.supplierInfo = supplierInfo;
    }

    // Getters and Setters
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getQuantityInStock() { return quantityInStock; }
    public void setQuantityInStock(Integer quantityInStock) { this.quantityInStock = quantityInStock; }

    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }

    public String getSupplierInfo() { return supplierInfo; }
    public void setSupplierInfo(String supplierInfo) { this.supplierInfo = supplierInfo; }
}
