package com.jocata.employee.service;

import com.jocata.employee.employee.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployee(int id);
    public List<Employee> getAllEmployees();
    public int createEmployee(Employee employee);
    public int updateEmployee(Employee employee);
    public int deleteEmployee(int id);
}
