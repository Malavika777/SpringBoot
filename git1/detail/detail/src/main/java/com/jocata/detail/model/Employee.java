package com.jocata.detail.model;

public class Employee {

    private int empId;
    private String empName;
    private String empDesign;
    private Department department;

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
    public String getEmpDesign(){
        return empDesign;
    }
    public void setEmpDesign(String empDesign){
        this.empDesign=empDesign;
    }
    public Department getDepartment(){
        return department;
    }
    public void setDepartment(Department department){
        this.department=department;
    }
    public String toString() {
        return "Employee{" +
                "empid=" + empId +
                ", empname='" + empName + '\'' +
                ", designation='" + empDesign + '\'' +
                ", department=" + department +
                '}';
    }
}
