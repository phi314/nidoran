/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nidoran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author phi314
 */
public class DbConnection {
    private static Connection connection;
    
    public static Connection getConnection()
    {
        if(connection == null)
        {
            try
            {
                String url = "jdbc:mysql://localhost:3306/nidoran_library";
                String user = "root";
                String pass = "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.out.println("Connection Error!");
            }
        }
        return connection;
    }
}
