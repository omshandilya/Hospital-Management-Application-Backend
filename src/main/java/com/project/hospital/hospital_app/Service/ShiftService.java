package com.project.hospital.hospital_app.Service;

import com.project.hospital.hospital_app.dto.ShiftDTO;

import java.util.List;

public interface ShiftService {
    ShiftDTO createShift(ShiftDTO shiftDTO);
    ShiftDTO updateShift(Long id, ShiftDTO shiftDTO);
    ShiftDTO getShiftById(Long id);
    List<ShiftDTO> getAllShifts();
    void deleteShift(Long id);
    List<ShiftDTO> getShiftsByDoctorId(Long doctorId);
}
