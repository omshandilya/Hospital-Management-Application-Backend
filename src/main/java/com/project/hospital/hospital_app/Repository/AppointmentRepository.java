package com.project.hospital.hospital_app.Repository;

import com.project.hospital.hospital_app.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    // Method to find appointments by patient ID
    List<AppointmentEntity> findByPatientUserEntityUserId(Long userId);
}