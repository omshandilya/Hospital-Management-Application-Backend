package com.project.hospital.hospital_app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}
