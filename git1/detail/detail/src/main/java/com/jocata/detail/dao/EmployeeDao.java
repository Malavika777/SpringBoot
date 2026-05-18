package com.jocata.detail.dao;

import com.jocata.detail.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int empId);
    Employee getEmployee(int empId);
    List<Employee> getAllEmployees();
}
