package com.enoca.employeemanagement.employee.impl;

import com.enoca.employeemanagement.employee.api.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
}
