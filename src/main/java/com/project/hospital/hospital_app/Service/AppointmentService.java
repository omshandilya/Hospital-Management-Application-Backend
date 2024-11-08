package com.project.hospital.hospital_app.Service;


import com.project.hospital.hospital_app.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);
    AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO);
    AppointmentDTO getAppointmentById(Long id);
    List<AppointmentDTO> getAllAppointments();
    void deleteAppointment(Long id);
    List<AppointmentDTO> getAppointmentsByPatientId(Long userId);
}
