package com.vsc.controller;

import com.vsc.dto.Mapper;
import com.vsc.dto.request.EmployeeRequestDto;
import com.vsc.dto.response.EmployeeResponseDto;
import com.vsc.model.Employee;
import com.vsc.service.EmployeeService;
import jakarta.persistence.Embedded;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
   @Mock
    private EmployeeService employeeService;
   @InjectMocks
    private EmployeeController employeeController;
    private EmployeeRequestDto employeeRequestDto;
    private EmployeeResponseDto employeeResponseDto;
    @BeforeEach
    void setUp() {
        employeeRequestDto = new EmployeeRequestDto();
        employeeRequestDto.setName("John Doe");
        employeeRequestDto.setEmail("test@example.com");
        employeeRequestDto.setPhone("1234567890");
        employeeRequestDto.setHireDate(LocalDate.of(2023, 5, 1));

        employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setName("John Doe");
        employeeResponseDto.setEmail("test@example.com");
        employeeResponseDto.setPhone("1234567890");
        employeeResponseDto.setHireDate(LocalDate.of(2023, 5, 1));
    }


    @Test
    @DisplayName("Test addEmployee")
    void addEmployee() {
        Mockito.when(employeeService.addEmployee(employeeRequestDto)).thenReturn((employeeResponseDto));

        ResponseEntity<EmployeeResponseDto> response = employeeController.addEmployee(employeeRequestDto);
        System.out.println(response);
        EmployeeResponseDto employee = response.getBody();
        assertEquals(employeeResponseDto.getName(), employee.getName());
        assertEquals(employeeResponseDto.getPhone(), employee.getPhone());
        assertEquals(employeeResponseDto.getEmail(), employee.getEmail());
        assertEquals(employeeResponseDto.getHireDate(), employee.getHireDate());
        assertEquals(employeeResponseDto, employee);
    }
}