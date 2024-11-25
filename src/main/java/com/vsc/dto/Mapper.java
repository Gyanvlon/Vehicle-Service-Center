package com.vsc.dto;

import com.vsc.dto.request.EmployeeRequestDto;
import com.vsc.dto.request.ServiceRequestDto;
import com.vsc.dto.response.EmployeeResponseDto;
import com.vsc.dto.response.VehicleServiceResponseDto;
import com.vsc.model.Employee;
import com.vsc.model.VService;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Employee mapEmployee(EmployeeRequestDto employeeRequestDto) {
          Employee employee = new Employee();
            employee.setName(employeeRequestDto.getName());
            employee.setEmail(employeeRequestDto.getEmail());
            employee.setPhone(employeeRequestDto.getPhone());
            employee.setHireDate(employeeRequestDto.getHireDate());
            return employee;
    }
    public EmployeeResponseDto mapEmployeeResponse(Employee employee) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setName(employee.getName());
        employeeResponseDto.setEmail(employee.getEmail());
        employeeResponseDto.setPhone(employee.getPhone());
        employeeResponseDto.setHireDate(employee.getHireDate());
        return employeeResponseDto;
    }
    public VService mapVService(ServiceRequestDto vServiceDto) {
        VService vService1 = new VService();
//        vService1.setId(vServiceDto.getId());
        vService1.setServiceName(vService1.getServiceName());
        vService1.setCost(vService1.getCost());
        vService1.setVehicleType(vService1.getVehicleType());
        return vService1;
    }
    public VehicleServiceResponseDto mapVServiceResponse(VService vService) {
        VehicleServiceResponseDto vehicleServiceResponseDto = new VehicleServiceResponseDto();
        vehicleServiceResponseDto.setId(vService.getId());
        vehicleServiceResponseDto.setServiceName(vService.getServiceName());
        vehicleServiceResponseDto.setCost(vService.getCost());
        vehicleServiceResponseDto.setVehicleType(vService.getVehicleType());
        return vehicleServiceResponseDto;
    }
}
