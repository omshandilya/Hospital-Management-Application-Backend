package com.project.hospital.hospital_app.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private String contact;
    private String role;
    private String address;
    private String password;
    // Constructors
    public UserDTO() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO(Long userId, String name, String email, String contact, String role, String address) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.role = role;
        this.address = address;
    }

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
