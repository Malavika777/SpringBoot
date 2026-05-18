package com.jocata.employee.employee;

public class Employee {

    private int empId;
    private String empName;
    private String deptName;
    private double salary;

    public int getEmpId(){
        return empId;
    }
    public void setEmpId(int empId){
        this.empId=empId;
    }
    public String getEmpName(){
        return empName;
    }
    public void setEmpName(String empName){
        this.empName=empName;
    }
    public String getDeptName(){
        return deptName;
    }
    public void setDeptName(String deptName){
        this.deptName=deptName;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
}
