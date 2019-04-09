package com.codeclan.example.database_lab;

import com.codeclan.example.database_lab.models.Department;
import com.codeclan.example.database_lab.models.Employee;
import com.codeclan.example.database_lab.models.Project;
import com.codeclan.example.database_lab.repositories.DepartmentRepository;
import com.codeclan.example.database_lab.repositories.EmployeeRepository;
import com.codeclan.example.database_lab.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.DefaultPersistenceDelegate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseLabApplicationTests {

	@Autowired
	DepartmentRepository departmentRepo;

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	ProjectRepository projectRepo;


	@Test
	public void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment() {
		Department department = new Department("HR");
		departmentRepo.save(department);

		Employee employee1 = new Employee("John", "Smith", 1, department);
		employeeRepo.save(employee1);
	}

	@Test
	public void addEmployeesAndProjects() {
		Department department = new Department("HR");
		departmentRepo.save(department);

		Employee employee1 = new Employee("John", "Smith", 1, department);
		employeeRepo.save(employee1);

		Project project1 = new Project("Downsizing", 10);
		projectRepo.save(project1);

		project1.addEmployee(employee1);
		projectRepo.save(project1);
	}

}
