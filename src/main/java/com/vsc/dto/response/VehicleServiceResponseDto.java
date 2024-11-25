package com.vsc.dto.response;

import lombok.Data;

@Data
public class VehicleServiceResponseDto {
    private Long id;
    private String serviceName;
    private double cost;
    private String vehicleType;
}
