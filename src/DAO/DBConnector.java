package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    private static Connection connection = null;
    public static Connection getConnection()
    {
        String url = "jdbc:mysql://localhost:3306/pos";
        String username = "root";
        String password = "12345678";
        try{
            connection = DriverManager.getConnection(url,username,password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return connection;

    }
}
