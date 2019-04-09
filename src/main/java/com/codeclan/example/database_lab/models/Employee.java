package com.codeclan.example.database_lab.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "employee_number")
    private int employeeNum;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "projects_employees",
            joinColumns = {@JoinColumn(
                    name = "employee_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = {@JoinColumn(
                    name = "project_id",
                    nullable = false,
                    updatable = false
            )}

    )
    private List<Project> projects;


    public Employee() {

    }

    public Employee(String firstName, String lastName, int employeeNum, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNum = employeeNum;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }
}
