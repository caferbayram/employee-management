package com.enoca.employeemanagement.company.impl;

import com.enoca.employeemanagement.company.api.CompanyDto;
import com.enoca.employeemanagement.employee.api.EmployeeDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CompanyRequest {
    private String name;
    private String address;
    private String region;
    private String phoneNumber;
    private List<EmployeeDto> employeeList;

    public CompanyDto toDto() {
        return CompanyDto.builder()
                .name(name)
                .address(address)
                .region(region)
                .phoneNumber(phoneNumber)
                .employeeList(employeeList)
                .build();
    }
}
