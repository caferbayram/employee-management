package com.enoca.employeemanagement.employee.impl;

import com.enoca.employeemanagement.company.api.CompanyDto;
import com.enoca.employeemanagement.employee.api.EmployeeDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeRequest {
    private String name;
    private String phoneNumber;
    private String address;
    private String department;
    private int companyId;

    public EmployeeDto toDto() {
        return EmployeeDto.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .address(address)
                .department(department)
                .companyDto(CompanyDto.builder()
                        .id(companyId)
                        .build())
                .build();
    }
}
