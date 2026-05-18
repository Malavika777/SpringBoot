package com.jocata.detail;

import com.jocata.detail.dao.DepartmentDaoImpl;
import com.jocata.detail.dao.EmployeeDaoImpl;
import com.jocata.detail.model.Department;
import com.jocata.detail.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DetailApplication {

	public static void main(String[] args) {

        SpringApplication.run(DetailApplication.class, args);

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
        List<Employee> allEmployees = employeeDao.getAllEmployees();


        System.out.println("1.Creating a new employee");
        Employee newEmployee = new Employee();
        newEmployee.setEmpName("Mark Cooper");
        newEmployee.setEmpDesign("Java Developer");

        Department engineeringDept = new Department();
        engineeringDept.setDeptId(1);
        newEmployee.setDepartment(engineeringDept);
        employeeDao.createEmployee(newEmployee);

        System.out.println("All employees after CREATE:");
        allEmployees = employeeDao.getAllEmployees();
        allEmployees.forEach(System.out::println);

        System.out.println("2.Getting all employees");
        allEmployees.forEach(System.out::println);

        System.out.println("3.Getting employee by ID (9)");
        Employee fetchedEmployee = employeeDao.getEmployee(9);
        if (fetchedEmployee != null) {
            System.out.println("Fetched: " + fetchedEmployee);

            // 4. UPDATE an employee ONLY IF they were found
            System.out.println("4.Updating employee (9) designation");
            fetchedEmployee.setEmpDesign("Senior Software Engineer");
            employeeDao.updateEmployee(fetchedEmployee);

        } else {
            System.out.println("Employee not found, cannot update or delete.");
        }


        System.out.println("5.Getting all employees after update");
        allEmployees = employeeDao.getAllEmployees();
        allEmployees.forEach(System.out::println);

//        System.out.println("6.Deleting employee by ID (1)");
//        employeeDao.deleteEmployee(1);

        System.out.println("7.Getting all employees after delete");
        allEmployees = employeeDao.getAllEmployees();
        allEmployees.forEach(System.out::println);

    }
}

