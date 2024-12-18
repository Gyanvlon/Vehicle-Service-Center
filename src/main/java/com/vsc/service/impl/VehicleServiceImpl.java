package com.vsc.service.impl;

import com.vsc.dto.Mapper;
import com.vsc.dto.request.ServiceRequestDto;
import com.vsc.dto.response.VehicleServiceResponseDto;
import com.vsc.exception.ResourceNotFoundException;
import com.vsc.model.Employee;
import com.vsc.model.VService;
import com.vsc.repository.EmployeeRepository;
import com.vsc.repository.VehicleServiceRepository;
import com.vsc.service.VehicleService;
import lombok.RequiredArgsConstructor;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleServiceRepository vehicleServiceRepository;
    private final EmployeeRepository employeeRepository;
    private final Mapper mapper;

    @Override
    public VehicleServiceResponseDto assignService(ServiceRequestDto request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + request.getEmployeeId()));
        // Write your code here
        VService service = mapper.mapVService(request);
        service.setServiceName(request.getServiceName());
        service.setCost(request.getCost());
        service.setVehicleType(request.getVehicleType());
        service.setEmployee(employee);
        return mapper.mapVServiceResponse(vehicleServiceRepository.save(service));
    }
}
