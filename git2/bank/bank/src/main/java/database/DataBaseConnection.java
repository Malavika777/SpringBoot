package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    private static final String url="jdbc:mysql://localhost:3306/jocata";
    private static final String user="root";
    private static final String password="Malu@2005";

    public static Connection getConnection(){

        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,password);
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found error.....");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Connection error.....");
            e.printStackTrace();
        }
        return conn;

    }
}
