package com.vsc.dto.response;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class EmployeeResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate hireDate;
    private List<VehicleServiceResponseDto> services;
}
