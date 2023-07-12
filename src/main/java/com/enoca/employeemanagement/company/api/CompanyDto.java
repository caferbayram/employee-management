package com.enoca.employeemanagement.company.api;

import com.enoca.employeemanagement.employee.api.EmployeeDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CompanyDto {
    private int id;
    private String name;
    private String address;
    private String region;
    private String phoneNumber;
    private List<EmployeeDto> employeeDtos;
}
