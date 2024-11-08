package com.project.hospital.hospital_app.dto;

import lombok.Data;

@Data
public class DoctorDTO {
    private Long doctorId;
    private String specialization;
    private String name;
    private boolean available;
    private Long userId;  // Reference to User


    // Constructors
    public DoctorDTO() {}

    public DoctorDTO(Long doctorId, String specialization, String qualifications, String experience, String contact, boolean available, Long userId,String name) {
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.available = available;
        this.userId = userId;
        this.name=name;
    }

    // Getters and Setters
    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
