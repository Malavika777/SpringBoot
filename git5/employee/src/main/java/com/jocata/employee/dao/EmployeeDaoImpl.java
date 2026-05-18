package com.jocata.employee.dao;

import com.jocata.employee.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee getEmployee(int empId){

        String sql="select * from employee where empId=?";

        return jdbcTemplate.queryForObject(sql,new Object[]{empId},new BeanPropertyRowMapper<>(Employee.class));
    }

    public List<Employee> getAllEmployees(){

        String sql="select * from employee";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Employee.class));
    }
    public int createEmployee(Employee emp) {

        String sql="insert into employee(empName,deptName,salary) values(?,?,?)";

        return jdbcTemplate.update(sql, emp.getEmpName(),emp.getDeptName(),emp.getSalary());
    }
    public int updateEmployee(Employee emp) {

        String sql="update employee set empName=?,deptName=?,salary=? where empId=?";

        return jdbcTemplate.update(sql, emp.getEmpName(),emp.getDeptName(),emp.getSalary(),emp.getEmpId());
    }
    public int deleteEmployee(int id) {

        String sql="delete from employee where empId=?";

        return jdbcTemplate.update(sql, id);
    }

}
