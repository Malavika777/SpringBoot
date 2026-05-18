package com.jocata.detail.dao;

import com.jocata.detail.model.Department;
import com.jocata.detail.model.Employee;
import database.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl {

    public void createEmployee(Employee employee) {

        String sql = "INSERT INTO employee (empName, empDesign, deptId) VALUES ('"
                + employee.getEmpName() + "', '" + employee.getEmpDesign() + "', " + employee.getDepartment().getDeptId() + ")";

        try(Connection conn= DataBaseConnection.getConnection()){
            Statement stmt=conn.createStatement();
            if(conn==null){
                return;
            }
            stmt.executeUpdate(sql);
            System.out.println("Employee '" + employee.getEmpName() + "' created successfully.");
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
    }

    public Employee getEmployee(int empId){

        String sql = "SELECT e.empid, e.empname, e.empDesign, d.deptid, d.deptname " +
                "FROM employee e JOIN department d ON e.deptid = d.deptid WHERE e.empid = " + empId;
        Employee emp=null;

        try(Connection conn=DataBaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            if (conn == null) {
                return null;
            }
            try (ResultSet resultSet = stmt.executeQuery(sql)) {
                if (resultSet.next()) {
                    emp = new Employee();
                    emp.setEmpId(resultSet.getInt("empId"));
                    emp.setEmpName(resultSet.getString("empName"));
                    emp.setEmpDesign(resultSet.getString("empDesign"));
                    ;
                    Department depart = new Department();
                    depart.setDeptId(resultSet.getInt("deptId"));
                    depart.setDeptName(resultSet.getString("deptName"));
                    emp.setDepartment(depart);

                }
            }
        }
            catch(SQLException e) {
                System.out.println("SQL Error....");
                e.printStackTrace();
            }
        return emp;
    }

    public List<Employee> getAllEmployees(){

        String sql = "SELECT e.empid, e.empname, e.empDesign, d.deptid, d.deptname " +
                "FROM employee e JOIN department d ON e.deptid = d.deptid";
        List<Employee> empList=new ArrayList<>();
        try(Connection conn=DataBaseConnection.getConnection()){
            Statement stmt=conn.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            if(conn==null){
                return null;
            }
            while(resultSet.next()){
                Employee emp=new Employee();
                emp.setEmpId(resultSet.getInt("empId"));
                emp.setEmpName(resultSet.getString("empName"));
                emp.setEmpDesign(resultSet.getString("empDesign"));
                Department depart=new Department();
                depart.setDeptId(resultSet.getInt("deptId"));
                depart.setDeptName(resultSet.getString("deptName"));
                emp.setDepartment(depart);
                empList.add(emp);

            }
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
        return empList;
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET empname = '" + employee.getEmpName()
                + "', empDesign = '" + employee.getEmpDesign()
                + "', deptid = " + employee.getDepartment().getDeptId()
                + " WHERE empid = " + employee.getEmpId();
        try(Connection conn=DataBaseConnection.getConnection()){
            Statement stmt=conn.createStatement();
            if(conn==null){
                return ;
            }
            int rowsUpdated=stmt.executeUpdate(sql);
            if(rowsUpdated>0){
                System.out.println("Employee with ID " + employee.getEmpId() + " updated successfully.");
            }
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int empId){
        String sql = "DELETE FROM employee WHERE empid = " + empId;
        try(Connection conn=DataBaseConnection.getConnection()){
            Statement stmt=conn.createStatement();
            if(conn==null){
                return ;
            }
            int rowsDeleted=stmt.executeUpdate(sql);
            if(rowsDeleted>0){
                System.out.println("Employee with ID " + empId + " deleted successfully.");
            }
            else{
                System.out.println("Employee with ID " + empId + " not deleted successfully.");
            }
        }
        catch(SQLException e){
            System.out.println("SQL Error....");
            e.printStackTrace();
        }

    }
}
