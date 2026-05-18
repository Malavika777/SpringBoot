package com.jocata.employee.dao;

import com.jocata.employee.employee.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee getEmployee(int id);
    List<Employee> getAllEmployees();
    public int createEmployee(Employee employee);;
    public int updateEmployee(Employee employee);;
    public int deleteEmployee(int id);
}
