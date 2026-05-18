package com.jocata.detail.dao;

import com.jocata.detail.model.Department;
import database.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentDaoImpl implements DepartmentDao {

    public Department getDepartmentById(int id){
        String sql="select * from Department where id=?";
        Department dept=null;
        try(Connection conn= DataBaseConnection.getConnection()){
            Statement stmt=conn.createStatement();
            if(conn==null){
                return null;
            }
            try(ResultSet resultSet=stmt.executeQuery(sql)){
                if(resultSet.next()){
                    dept=new Department();
                    dept.setDeptId(resultSet.getInt("deptId"));
                    dept.setDeptName((resultSet.getString("deptName")));
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return dept;
    }
}
