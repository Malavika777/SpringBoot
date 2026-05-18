package com.jocata.employee.service;

import com.jocata.employee.dao.EmployeeDao;
import com.jocata.employee.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    public Employee getEmployee(int empId){
        return employeeDao.getEmployee(empId);
    }

    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    public int createEmployee(Employee employee) {
        return employeeDao.createEmployee(employee);
    }

    public int updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    public int deleteEmployee(int id) {
        return employeeDao.deleteEmployee(id);
    }
}
