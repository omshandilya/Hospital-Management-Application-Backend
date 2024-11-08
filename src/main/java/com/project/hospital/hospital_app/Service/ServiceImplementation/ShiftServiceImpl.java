package com.project.hospital.hospital_app.Service.ServiceImplementation;


import com.project.hospital.hospital_app.Exception.ResourceNotFoundException;
import com.project.hospital.hospital_app.Repository.ShiftRepository;
import com.project.hospital.hospital_app.Service.ShiftService;
import com.project.hospital.hospital_app.dto.ShiftDTO;

import com.project.hospital.hospital_app.entities.ShiftEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ShiftDTO createShift(ShiftDTO shiftDTO) {
        ShiftEntity shiftEntity = modelMapper.map(shiftDTO, ShiftEntity.class);
        ShiftEntity savedShift = shiftRepository.save(shiftEntity);
        return modelMapper.map(savedShift, ShiftDTO.class);
    }

    @Override
    public ShiftDTO updateShift(Long id, ShiftDTO shiftDTO) {
        ShiftEntity existingShift = shiftRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shift not found with id: " + id));

        modelMapper.map(shiftDTO, existingShift);
        ShiftEntity updatedShift = shiftRepository.save(existingShift);
        return modelMapper.map(updatedShift, ShiftDTO.class);
    }

    @Override
    public ShiftDTO getShiftById(Long id) {
        ShiftEntity shift = shiftRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shift not found with id: " + id));
        return modelMapper.map(shift, ShiftDTO.class);
    }

    @Override
    public List<ShiftDTO> getAllShifts() {
        return shiftRepository.findAll()
                .stream()
                .map(shift -> modelMapper.map(shift, ShiftDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteShift(Long id) {
        ShiftEntity shift = shiftRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shift not found with id: " + id));
        shiftRepository.delete(shift);
    }


    @Override
    public List<ShiftDTO> getShiftsByDoctorId(Long doctorId) {
        List<ShiftEntity> shiftEntities = shiftRepository.findByDoctorId(doctorId);
        return shiftEntities.stream()
                .map(shift -> modelMapper.map(shift, ShiftDTO.class))
                .collect(Collectors.toList());
    }

}
