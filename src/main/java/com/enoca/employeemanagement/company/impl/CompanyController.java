package com.enoca.employeemanagement.company.impl;

import com.enoca.employeemanagement.company.api.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService service;

    @PostMapping
    public CompanyResponse createCompany(@RequestBody CompanyRequest request) {
        return CompanyResponse.fromDto(service.create(request.toDto()));
    }

    @PutMapping("/{id}")
    public CompanyResponse updateCompany(@PathVariable(name = "id") String id,
                                         @RequestBody CompanyRequest request) {
        return CompanyResponse.fromDto(service.update(id, request.toDto()));
    }

    @GetMapping
    public CompanyListResponse getAllCompanies() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CompanyResponse getCompanyById(@PathVariable(name = "id") String id) {
        return CompanyResponse.fromDto(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCompany(@PathVariable(name = "id") String id) {
        service.delete(id);
        return HttpStatus.OK;
    }
}
