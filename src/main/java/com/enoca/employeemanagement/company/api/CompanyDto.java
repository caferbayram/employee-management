package com.enoca.employeemanagement.company.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDto {
    private int id;
    private String name;
    private String address;
    private String region;
    private String phoneNumber;
}
