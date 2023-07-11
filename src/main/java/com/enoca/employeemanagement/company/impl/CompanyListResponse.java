package com.enoca.employeemanagement.company.impl;

import com.enoca.employeemanagement.company.api.CompanyDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CompanyListResponse {
    private List<CompanyDto>companyList;
}
