package com.enoca.employeemanagement.employee.api;

import com.enoca.employeemanagement.company.api.CompanyDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private String department;
    private CompanyDto companyDto;
}
