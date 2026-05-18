package com.jocata.employee.controller;

import com.jocata.employee.employee.Employee;
import com.jocata.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable int empId) {
        return employeeService.getEmployee(empId);
    }

    @PostMapping
    public int createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("{empId}")
    public int updateEmployee(@PathVariable int empId, @RequestBody Employee employee) {
        employee.setEmpId(empId);
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("{empId}")
    public int deleteEmployee(@PathVariable int empId) {
        return employeeService.deleteEmployee(empId);
    }

}
