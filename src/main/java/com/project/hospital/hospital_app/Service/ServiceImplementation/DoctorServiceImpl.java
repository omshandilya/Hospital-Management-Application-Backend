package com.project.hospital.hospital_app.Service.ServiceImplementation;

import com.project.hospital.hospital_app.Exception.ResourceNotFoundException;
import com.project.hospital.hospital_app.Repository.DoctorRepository;
import com.project.hospital.hospital_app.Service.DoctorService;
import com.project.hospital.hospital_app.dto.DoctorDTO;
import com.project.hospital.hospital_app.entities.DoctorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;  // Inject ModelMapper

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        // Convert DTO to Entity
        DoctorEntity doctorEntity = modelMapper.map(doctorDTO, DoctorEntity.class);
        DoctorEntity savedDoctor = doctorRepository.save(doctorEntity);
        // Convert Entity back to DTO
        return modelMapper.map(savedDoctor, DoctorDTO.class);
    }

//    @Override
//    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
//        DoctorEntity existingDoctor = doctorRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
//
//        // Update the existing entity with new DTO values
//        modelMapper.map(doctorDTO, existingDoctor);
//
//        DoctorEntity updatedDoctor = doctorRepository.save(existingDoctor);
//        return modelMapper.map(updatedDoctor, DoctorDTO.class);
//    }

    @Override
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        // Fetch the existing doctor entity by id
        DoctorEntity existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));

        // Manually set the fields you want to update (but don't update the ID)
        existingDoctor.setName(doctorDTO.getName());
        existingDoctor.setSpecialization(doctorDTO.getSpecialization());
        existingDoctor.setAvailable(doctorDTO.isAvailable());

        // Save the updated entity back to the database
        DoctorEntity updatedDoctor = doctorRepository.save(existingDoctor);

        // Return the updated doctor as a DTO
        return modelMapper.map(updatedDoctor, DoctorDTO.class);
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        DoctorEntity doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDoctor(Long id) {
        DoctorEntity doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        doctorRepository.delete(doctor);
    }

    @Override
    public List<DoctorDTO> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization)
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }
}

