package com.project.hospital.hospital_app.controller;

import com.project.hospital.hospital_app.dto.ShiftDTO;
import com.project.hospital.hospital_app.Service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;

    @PostMapping
    public ResponseEntity<ShiftDTO> createShift(@RequestBody ShiftDTO shiftDTO) {
        ShiftDTO createdShift = shiftService.createShift(shiftDTO);
        return ResponseEntity.ok(createdShift);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShiftDTO> updateShift(@PathVariable Long id, @RequestBody ShiftDTO shiftDTO) {
        ShiftDTO updatedShift = shiftService.updateShift(id, shiftDTO);
        return ResponseEntity.ok(updatedShift);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShiftDTO> getShiftById(@PathVariable Long id) {
        ShiftDTO shiftDTO = shiftService.getShiftById(id);
        return ResponseEntity.ok(shiftDTO);
    }

    @GetMapping
    public ResponseEntity<List<ShiftDTO>> getAllShifts() {
        List<ShiftDTO> shifts = shiftService.getAllShifts();
        return ResponseEntity.ok(shifts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShift(@PathVariable Long id) {
        shiftService.deleteShift(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/doctor_shifts/{doctorId}")
    public ResponseEntity<List<ShiftDTO>> getShiftsByDoctorId(@PathVariable Long doctorId) {
        List<ShiftDTO> shifts = shiftService.getShiftsByDoctorId(doctorId);
        return ResponseEntity.ok(shifts);
    }

}
