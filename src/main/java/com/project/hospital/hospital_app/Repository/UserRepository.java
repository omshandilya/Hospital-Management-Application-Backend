package com.project.hospital.hospital_app.Repository;

import com.project.hospital.hospital_app.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Custom query methods if needed
    UserEntity findByEmail(String email);
}
