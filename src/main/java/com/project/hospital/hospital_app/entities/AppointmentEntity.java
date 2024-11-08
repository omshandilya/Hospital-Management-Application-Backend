package com.project.hospital.hospital_app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Appointments")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;
    private LocalDate appointmentDate;
    private String reason;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}