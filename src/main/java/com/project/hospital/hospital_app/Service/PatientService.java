package com.project.hospital.hospital_app.Service;


import com.project.hospital.hospital_app.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDTO);
    PatientDTO updatePatient(Long id, PatientDTO patientDTO);
    PatientDTO getPatientById(Long id);
    List<PatientDTO> getAllPatients();
    void deletePatient(Long id);
    PatientDTO getPatientProfileByUserId(Long userId);
}
