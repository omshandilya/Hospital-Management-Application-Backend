package com.project.hospital.hospital_app.controller;

import com.project.hospital.hospital_app.Repository.UserRepository;
import com.project.hospital.hospital_app.Service.ServiceImplementation.AuthService;
import com.project.hospital.hospital_app.Service.UserService;
import com.project.hospital.hospital_app.dto.LoginRequestDTO;
import com.project.hospital.hospital_app.dto.UserDTO;
import com.project.hospital.hospital_app.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//@RestController
//@RequestMapping("/api/auth")
//@AllArgsConstructor
//public class AuthController {
//
//    @Autowired
//    private AuthService authService;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequest) {
//        // Use AuthService for authentication logic
//        String role = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
//        if (role == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//        }
//        return ResponseEntity.ok(Collections.singletonMap("role", role));  // Respond with user's role
//    }
//}



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;  // Inject the UserService

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequest) {
        // Authenticate user using UserService
        UserDTO userDTO = userService.getUserByEmail(loginRequest.getEmail());

        if (userDTO == null || !userDTO.getPassword().equals(loginRequest.getPassword())) {
            // If user is null or password does not match, return Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        // Create response with user role and userId
        Map<String, Object> response = new HashMap<>();
        response.put("role", userDTO.getRole());
        response.put("userId", userDTO.getUserId());

        // Return the response
        return ResponseEntity.ok(response);
    }
}
