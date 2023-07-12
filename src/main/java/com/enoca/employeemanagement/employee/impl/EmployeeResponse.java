package com.enoca.employeemanagement.employee.impl;

import com.enoca.employeemanagement.company.api.CompanyDto;
import com.enoca.employeemanagement.employee.api.EmployeeDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResponse {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private String department;
    private CompanyDto companyDto;

    public static EmployeeResponse fromDto(EmployeeDto employeeDto) {
        return EmployeeResponse.builder()
                .id(employeeDto.getId())
                .name(employeeDto.getName())
                .phoneNumber(employeeDto.getPhoneNumber())
                .address(employeeDto.getAddress())
                .department(employeeDto.getDepartment())
                .companyDto(CompanyDto.builder()
                        .id(employeeDto.getCompanyDto().getId())
                        .name(employeeDto.getCompanyDto().getName())
                        .address(employeeDto.getCompanyDto().getAddress())
                        .region(employeeDto.getCompanyDto().getRegion())
                        .phoneNumber(employeeDto.getCompanyDto().getPhoneNumber())
                        .build())
                .build();
    }
}
