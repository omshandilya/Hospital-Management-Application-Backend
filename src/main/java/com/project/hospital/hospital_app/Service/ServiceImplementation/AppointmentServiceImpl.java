package com.project.hospital.hospital_app.Service.ServiceImplementation;


import com.project.hospital.hospital_app.Exception.ResourceNotFoundException;
import com.project.hospital.hospital_app.Repository.DoctorRepository;
import com.project.hospital.hospital_app.Repository.PatientRepository;
import com.project.hospital.hospital_app.Service.AppointmentService;
import com.project.hospital.hospital_app.dto.AppointmentDTO;
import com.project.hospital.hospital_app.Repository.AppointmentRepository;
import com.project.hospital.hospital_app.entities.AppointmentEntity;
import com.project.hospital.hospital_app.entities.DoctorEntity;
import com.project.hospital.hospital_app.entities.PatientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<AppointmentDTO> getAppointmentsByPatientId(Long userId) {
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findByPatientUserEntityUserId(userId);
        return appointmentEntities.stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                .collect(Collectors.toList());
    }


//    @Override
//    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
//        AppointmentEntity appointmentEntity = modelMapper.map(appointmentDTO, AppointmentEntity.class);
//        AppointmentEntity savedAppointment = appointmentRepository.save(appointmentEntity);
//        return modelMapper.map(savedAppointment, AppointmentDTO.class);
//    }


    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();

        // Set doctor and patient entities manually
        DoctorEntity doctor = doctorRepository.findById(appointmentDTO.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        PatientEntity patient = patientRepository.findById(appointmentDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        appointmentEntity.setDoctor(doctor);
        appointmentEntity.setPatient(patient);
        appointmentEntity.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointmentEntity.setReason(appointmentDTO.getReason());

        AppointmentEntity savedAppointment = appointmentRepository.save(appointmentEntity);

        // Convert back to DTO
        AppointmentDTO savedDTO = new AppointmentDTO();
        savedDTO.setAppointmentId(savedAppointment.getId());
        savedDTO.setAppointmentDate(savedAppointment.getAppointmentDate());
        savedDTO.setDoctorId(savedAppointment.getDoctor().getId());
        savedDTO.setPatientId(savedAppointment.getPatient().getId());
        savedDTO.setReason(savedAppointment.getReason());

        return savedDTO;
    }





    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        AppointmentEntity existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));

        modelMapper.map(appointmentDTO, existingAppointment);
        AppointmentEntity updatedAppointment = appointmentRepository.save(existingAppointment);
        return modelMapper.map(updatedAppointment, AppointmentDTO.class);
    }

    @Override
    public AppointmentDTO getAppointmentById(Long id) {
        AppointmentEntity appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        return modelMapper.map(appointment, AppointmentDTO.class);
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAppointment(Long id) {
        AppointmentEntity appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        appointmentRepository.delete(appointment);
    }
}
