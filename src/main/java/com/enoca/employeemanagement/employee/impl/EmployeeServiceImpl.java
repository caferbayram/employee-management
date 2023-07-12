package com.enoca.employeemanagement.employee.impl;

import com.enoca.employeemanagement.company.api.CompanyDto;
import com.enoca.employeemanagement.company.api.CompanyService;
import com.enoca.employeemanagement.employee.api.EmployeeDto;
import com.enoca.employeemanagement.employee.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository repository;
    private final CompanyService companyService;

    @Autowired
    public EmployeeServiceImpl(@Lazy CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public EmployeeDto create(EmployeeDto dto) {
        return toDto(repository.save(toEntity(new Employee(), dto)));
    }

    @Override
    public EmployeeDto update(String id, EmployeeDto dto) {
        return repository.findById(Integer.parseInt(id))
                .map(employee -> toEntity(employee, dto))
                .map(repository::save)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found."));
    }

    @Override
    public EmployeeListResponse getAll() {
        return EmployeeListResponse.builder()
                .employeeList(repository.findAll()
                        .stream()
                        .map(this::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public void delete(String id) {
        repository.delete(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Employee not found.")));
    }

    @Override
    public EmployeeDto getById(String id) {
        return toDto(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Employee not found.")));
    }

    @Override
    public Employee toEntity(Employee employee, EmployeeDto dto) {
        employee.setName(dto.getName());
        employee.setAddress(dto.getAddress());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setDepartment(dto.getDepartment());
        employee.setCompany(companyService.findById(dto.getCompanyDto().getId()));
        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .address(employee.getAddress())
                .phoneNumber(employee.getPhoneNumber())
                .department(employee.getDepartment())
                .companyDto(CompanyDto.builder()
                        .id(employee.getCompany().getId())
                        .name(employee.getCompany().getName())
                        .address(employee.getCompany().getAddress())
                        .region(employee.getCompany().getRegion())
                        .phoneNumber(employee.getCompany().getPhoneNumber())
                        .build())
                .build();
    }
}
