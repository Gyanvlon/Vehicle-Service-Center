package com.vsc.service;


import com.vsc.dto.request.ServiceRequestDto;
import com.vsc.dto.response.VehicleServiceResponseDto;

public interface VehicleService {
    VehicleServiceResponseDto assignService(ServiceRequestDto request);
}
