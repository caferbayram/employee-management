package com.enoca.employeemanagement.company.api;

import com.enoca.employeemanagement.company.impl.CompanyListResponse;

public interface CompanyService {
    CompanyDto create(CompanyDto dto);

    CompanyListResponse getAll();

    CompanyDto update(String id, CompanyDto dto);

    void delete(String id);

    CompanyDto getById(String id);
}
