package com.enoca.employeemanagement.employee.impl;

import com.enoca.employeemanagement.employee.api.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest request) {
        return EmployeeResponse.fromDto(service.create(request.toDto()));
    }

    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@PathVariable(name = "id") String id,
                                           @RequestBody EmployeeRequest request) {
        return EmployeeResponse.fromDto(service.update(id, request.toDto()));
    }

    @GetMapping
    public EmployeeListResponse getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployee(@PathVariable(name = "id") String id) {
        service.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable(name = "id") String id) {
        return EmployeeResponse.fromDto(service.getById(id));
    }
}
