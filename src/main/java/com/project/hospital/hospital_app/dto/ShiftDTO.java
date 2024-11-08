package com.project.hospital.hospital_app.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
    public class ShiftDTO {
        private Long shiftId;
        private String shiftDay;
        private String shiftTime;  // Map to 'shiftTime' from ShiftEntity
        private Long doctorId;     // Reference to DoctorEntity

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftDay() {
        return shiftDay;
    }

    public void setShiftDay(String shiftDay) {
        this.shiftDay = shiftDay;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }




}



