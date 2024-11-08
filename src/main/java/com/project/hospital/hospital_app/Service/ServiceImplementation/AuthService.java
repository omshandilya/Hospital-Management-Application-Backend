package com.project.hospital.hospital_app.Service.ServiceImplementation;

import com.project.hospital.hospital_app.Repository.UserRepository;
import com.project.hospital.hospital_app.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String authenticate(String email, String password) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            return null; // Indicates invalid credentials
        }
        return user.getRole(); // Return role if authentication succeeds
    }
}
