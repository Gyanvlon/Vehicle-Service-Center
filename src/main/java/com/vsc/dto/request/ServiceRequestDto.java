package com.vsc.dto.request;

import lombok.Data;

@Data
public class ServiceRequestDto {
    private Long employeeId;
    private String serviceName;
    private double cost;
    private String vehicleType;
}
