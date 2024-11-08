package com.project.hospital.hospital_app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class AppointmentDTO {
    private Long appointmentId;
    private LocalDate appointmentDate;
    private String reason;
    private Long doctorId;  // Reference to Doctor
    private Long patientId; // Reference to Patient


    // Constructors
    public AppointmentDTO() {}

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }



    // Getters and Setters
    public Long getAppointmentId() { return appointmentId; }
    public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }



    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }


    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }


    public AppointmentDTO(Long appointmentId, LocalDate appointmentDate, String reason, Long doctorId, Long patientId) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.reason = reason;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }





}

