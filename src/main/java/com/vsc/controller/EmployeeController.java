package com.vsc.controller;

import com.vsc.dto.request.EmployeeRequestDto;
import com.vsc.dto.response.EmployeeResponseDto;
import com.vsc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // Add a new employee
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> addEmployee(@RequestBody EmployeeRequestDto request) {
        // Write your code here

        return new ResponseEntity<>(employeeService.addEmployee(request), HttpStatus.CREATED);
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        // Write your code here
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    // Get a specific employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {
        // Write your code here

        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    // Update partially an existing employee
    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> partiallyUpdateEmployee(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates
    ) {
        // Write your code here

        return new ResponseEntity<>(employeeService.partiallyUpdateEmployee(id, updates), HttpStatus.OK);
    }
}
