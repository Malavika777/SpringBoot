package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String url="jdbc:mysql://localhost:3306/jocata";
    private static final String username="root";
    private static final String password="Malu@2005";

    public static Connection getConnection(){

        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,username,password);
        }
        catch(SQLException e){
            System.out.println("SQL Error.....");
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            System.out.println("Class Not Found.....");
            e.printStackTrace();
        }
        return conn;
    }
}
