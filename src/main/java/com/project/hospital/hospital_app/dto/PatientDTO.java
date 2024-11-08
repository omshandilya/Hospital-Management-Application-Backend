package com.project.hospital.hospital_app.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Data
public class PatientDTO {
    private Long patientId;
//    private String gender;
//    private Integer age;
//    private String medicalHistory;
//    private Long userId;  // Reference to User
    private String name;
    private Integer age;
    private String address;
    private String phoneNumber;
    @Column(name = "date_of_registration")
    private LocalDate dateOfReg;

    public PatientDTO(Long patientId, String name, String address, Integer age, String phoneNumber, LocalDate dateOfReg) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.dateOfReg = dateOfReg;
    }

    // Constructors
    public PatientDTO() {}

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(LocalDate dateOfReg) {
        this.dateOfReg = dateOfReg;
    }
}
