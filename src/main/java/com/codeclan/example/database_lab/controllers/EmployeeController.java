package com.codeclan.example.database_lab.controllers;

import com.codeclan.example.database_lab.models.Employee;
import com.codeclan.example.database_lab.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
}
