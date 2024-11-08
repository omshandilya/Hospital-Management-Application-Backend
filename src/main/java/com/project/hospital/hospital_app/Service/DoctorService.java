package com.project.hospital.hospital_app.Service;

import com.project.hospital.hospital_app.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    DoctorDTO createDoctor(DoctorDTO doctorDTO);
    DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO);
    DoctorDTO getDoctorById(Long id);
    List<DoctorDTO> getAllDoctors();
    void deleteDoctor(Long id);
    List<DoctorDTO> getDoctorsBySpecialization(String specialization);
}
