package com.enoca.employeemanagement.employee.impl;

import com.enoca.employeemanagement.employee.api.EmployeeDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmployeeListResponse {
    private List<EmployeeDto> employeeList;
}
