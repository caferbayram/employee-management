package com.enoca.employeemanagement.company.impl;

import com.enoca.employeemanagement.employee.impl.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String region;
    private String phoneNumber;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employeeList;
}
