package com.project.hospital.hospital_app.Repository;

import com.project.hospital.hospital_app.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    // Custom query methods if needed
    List<DoctorEntity> findBySpecialization(String specialization);
    List<DoctorEntity> findByAvailable(boolean available);
}
