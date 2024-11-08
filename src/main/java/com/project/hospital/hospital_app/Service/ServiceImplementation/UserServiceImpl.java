package com.project.hospital.hospital_app.Service.ServiceImplementation;

import com.project.hospital.hospital_app.Exception.ResourceNotFoundException;
import com.project.hospital.hospital_app.Repository.DoctorRepository;
import com.project.hospital.hospital_app.Repository.PatientRepository;
import com.project.hospital.hospital_app.Repository.UserRepository;
import com.project.hospital.hospital_app.Service.UserService;
import com.project.hospital.hospital_app.dto.UserDTO;
import com.project.hospital.hospital_app.entities.DoctorEntity;
import com.project.hospital.hospital_app.entities.PatientEntity;
import com.project.hospital.hospital_app.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // Convert DTO to Entity and save user in the UserEntity table
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        UserEntity savedUser = userRepository.save(userEntity);

        if (userDTO.getRole().equalsIgnoreCase("Doctor")) {
            // Map userDTO to DoctorEntity and set userEntity
            DoctorEntity doctorEntity = modelMapper.map(userDTO, DoctorEntity.class);
            doctorEntity.setUserEntity(savedUser);  // Set reference to User
            doctorRepository.save(doctorEntity);
        } else if (userDTO.getRole().equalsIgnoreCase("Patient")) {
            // Map userDTO to PatientEntity and set userEntity
            PatientEntity patientEntity = modelMapper.map(userDTO, PatientEntity.class);
            patientEntity.setUserEntity(savedUser);  // Set reference to User
            patientRepository.save(patientEntity);
        }

        // Convert saved UserEntity back to DTO and return
        return modelMapper.map(savedUser, UserDTO.class);
    }


    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        modelMapper.map(userDTO, existingUser); // Update the existing entity with new DTO values
        UserEntity updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with email: " + email);
        }
        return modelMapper.map(user, UserDTO.class);
    }
}

