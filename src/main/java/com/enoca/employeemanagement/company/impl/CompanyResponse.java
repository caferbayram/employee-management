package com.enoca.employeemanagement.company.impl;

import com.enoca.employeemanagement.company.api.CompanyDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyResponse {
    private int id;
    private String name;
    private String address;
    private String region;
    private String phoneNumber;
    public static CompanyResponse fromDto(CompanyDto companyDto) {
        return CompanyResponse.builder()
                .id(companyDto.getId())
                .address(companyDto.getAddress())
                .name(companyDto.getName())
                .region(companyDto.getRegion())
                .phoneNumber(companyDto.getPhoneNumber())
                .build();
    }
}
