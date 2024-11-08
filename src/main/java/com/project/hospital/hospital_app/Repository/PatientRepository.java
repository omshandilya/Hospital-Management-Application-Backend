package com.project.hospital.hospital_app.Repository;

import com.project.hospital.hospital_app.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    // Existing method to find patients by age
    List<PatientEntity> findByAge(Integer age);

    // Custom method to find a patient by userId (from UserEntity)
    Optional<PatientEntity> findByUserEntityUserId(Long userId); // Uses the relation with UserEntity
}

