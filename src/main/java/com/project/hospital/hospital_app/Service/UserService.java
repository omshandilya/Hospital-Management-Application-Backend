package com.project.hospital.hospital_app.Service;

import com.project.hospital.hospital_app.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    void deleteUser(Long id);
    UserDTO getUserByEmail(String email);
}
