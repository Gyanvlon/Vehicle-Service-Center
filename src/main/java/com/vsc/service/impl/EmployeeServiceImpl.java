package com.vsc.service.impl;

import com.vsc.dto.Mapper;
import com.vsc.dto.request.EmployeeRequestDto;
import com.vsc.dto.response.EmployeeResponseDto;
import com.vsc.dto.response.VehicleServiceResponseDto;
import com.vsc.exception.ResourceNotFoundException;
import com.vsc.model.Employee;
import com.vsc.repository.EmployeeRepository;
import com.vsc.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Mapper mapper;

    @Override
    public EmployeeResponseDto addEmployee(EmployeeRequestDto request) {
        return mapper.mapEmployeeResponse(employeeRepository.save(mapper.mapEmployee(request)));
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(mapper::mapEmployeeResponse)
                .toList();
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        return mapper.mapEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponseDto partiallyUpdateEmployee(Long id, Map<String, Object> updates) {
        // Fetch the employee by ID or throw an exception if not found
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));

        // Apply each update based on the key
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    employee.setName((String) value);
                    // Write your code here

                    break;
                case "email":
                    employee.setEmail((String) value);
                    // Write your code here

                    break;
                case "phone":
                    employee.setPhone((String) value);
                    // Write your code here

                    break;
                case "hireDate":
                    employee.setHireDate((LocalDate) value);
                    // Write your code here

                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });
        // Write your code here

        return mapper.mapEmployeeResponse(employeeRepository.save(employee));
    }

//    private EmployeeResponseDto mapToResponseDto(Employee employee) {
//        List<VehicleServiceResponseDto> serviceDtos = employee.getVServices().stream()
//                .map(service -> new VehicleServiceResponseDto(
//                        service.getId(),
//                        service.getServiceName(),
//                        service.getCost(),
//                        service.getVehicleType()
//                )).toList();
//
//        return new EmployeeResponseDto(
//                employee.getId(),
//                employee.getName(),
//                employee.getEmail(),
//                employee.getPhone(),
//                employee.getHireDate(),
//                serviceDtos
//        );
//    }
}
