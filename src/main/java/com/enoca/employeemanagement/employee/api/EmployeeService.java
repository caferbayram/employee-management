package com.enoca.employeemanagement.employee.api;

import com.enoca.employeemanagement.employee.impl.Employee;
import com.enoca.employeemanagement.employee.impl.EmployeeListResponse;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto dto);

    EmployeeDto update(String id, EmployeeDto dto);

    EmployeeListResponse getAll();

    void delete(String id);

    EmployeeDto getById(String id);
    Employee toEntity(Employee employee, EmployeeDto dto);
    EmployeeDto toDto(Employee employee);
}
