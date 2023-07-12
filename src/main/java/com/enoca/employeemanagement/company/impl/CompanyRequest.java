package com.enoca.employeemanagement.company.impl;

import com.enoca.employeemanagement.company.api.CompanyDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyRequest {
    private String name;
    private String address;
    private String region;
    private String phoneNumber;

    public CompanyDto toDto() {
        return CompanyDto.builder()
                .name(name)
                .address(address)
                .region(region)
                .phoneNumber(phoneNumber)
                .build();
    }
}
