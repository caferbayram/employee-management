package com.enoca.employeemanagement.company.impl;

import com.enoca.employeemanagement.company.api.CompanyDto;
import com.enoca.employeemanagement.company.api.CompanyService;
import com.enoca.employeemanagement.employee.api.EmployeeService;
import com.enoca.employeemanagement.employee.impl.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final EmployeeService employeeService;

    @Override
    public CompanyDto create(CompanyDto dto) {
        return toDto(repository.save(toEntity(new Company(), dto)));
    }

    @Override
    public CompanyDto update(String id, CompanyDto dto) {
        return repository.findById(Integer.parseInt(id))
                .map(company -> toEntity(company, dto))
                .map(repository::save)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Company not found."));
    }

    @Override
    public void delete(String id) {
        repository.delete(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Company not found.")));
    }

    @Override
    public CompanyListResponse getAll() {
        return CompanyListResponse.builder()
                .companyList(repository.findAll().stream()
                        .map(this::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public CompanyDto getById(String id) {
        return toDto(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Company not found.")));
    }

    @Override
    public Company findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found."));
    }

    private Company toEntity(Company company, CompanyDto dto) {
        company.setName(dto.getName());
        company.setAddress(dto.getAddress());
        company.setRegion(dto.getRegion());
        company.setPhoneNumber(dto.getPhoneNumber());
        company.setEmployeeList(Optional.of(dto.getEmployeeList().stream()
                .map(employeeDto -> employeeService.toEntity(new Employee(), employeeDto))
                .toList())
                .orElse(Collections.emptyList()));
        return company;
    }

    private CompanyDto toDto(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .address(company.getAddress())
                .region(company.getRegion())
                .phoneNumber(company.getPhoneNumber())
                .employeeList(Optional.of(company.getEmployeeList().stream()
                        .map(employeeService::toDto)
                        .collect(Collectors.toList()))
                        .orElse(Collections.emptyList()))
                .build();
    }
}
