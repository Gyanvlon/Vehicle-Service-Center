package com.vsc.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeRequestDto {
    private String name;
    private String email;
    private String phone;
    private LocalDate hireDate;
}
