package com.project.hospital.hospital_app.Repository;

import com.project.hospital.hospital_app.entities.ShiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<ShiftEntity, Long> {
    List<ShiftEntity> findByDoctorId(Long doctorId);  // Access the 'id' of the 'doctor' field
}

