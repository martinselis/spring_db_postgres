package com.codeclan.example.database_lab.repositories;

import com.codeclan.example.database_lab.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
