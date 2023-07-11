package com.enoca.employeemanagement.employee.impl;

import com.enoca.employeemanagement.company.impl.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private String department;
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;
}
