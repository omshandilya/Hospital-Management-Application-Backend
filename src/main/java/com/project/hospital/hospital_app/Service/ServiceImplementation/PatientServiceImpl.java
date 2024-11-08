package com.project.hospital.hospital_app.Service.ServiceImplementation;


import com.project.hospital.hospital_app.dto.PatientDTO;
import com.project.hospital.hospital_app.entities.PatientEntity;
import com.project.hospital.hospital_app.Exception.ResourceNotFoundException;
import com.project.hospital.hospital_app.Repository.PatientRepository;
import com.project.hospital.hospital_app.Service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        PatientEntity patientEntity = modelMapper.map(patientDTO, PatientEntity.class);
        PatientEntity savedPatient = patientRepository.save(patientEntity);
        return modelMapper.map(savedPatient, PatientDTO.class);
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        modelMapper.map(patientDTO, patientEntity);
        PatientEntity updatedPatient = patientRepository.save(patientEntity);
        return modelMapper.map(updatedPatient, PatientDTO.class);
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        return modelMapper.map(patientEntity, PatientDTO.class);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<PatientEntity> patientEntities = patientRepository.findAll();
        return patientEntities.stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePatient(Long id) {
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        patientRepository.delete(patientEntity);
    }
//    @Override
//    public PatientDTO getPatientProfileByUserId(Long userId) {
//        PatientEntity patientEntity = patientRepository.findByUserEntityUserId(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with user ID: " + userId));
//        return modelMapper.map(patientEntity, PatientDTO.class);
//    }

    @Override
    public PatientDTO getPatientProfileByUserId(Long userId) {
        // Fetch patient entity by userId
        PatientEntity patientEntity = patientRepository.findByUserEntityUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with user ID: " + userId));

        // Log the patient entity to verify if it's being fetched correctly
        System.out.println("PatientEntity fetched: " + patientEntity);

        // Map the fetched patientEntity to PatientDTO and return it
        return modelMapper.map(patientEntity, PatientDTO.class);
    }
}


