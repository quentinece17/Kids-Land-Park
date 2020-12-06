/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author quentin
 */
public class DataSource {
    
    Connection conn = null;
    
    public Connection createConnection () 
    {
        try {
            
            String url = "jdbc:mysql://localhost:3306/KidsLand";
            String user = "root";
            String password = "33lovelyseals__";

            conn = DriverManager.getConnection(url, user, password);
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        
        return conn;
    }
}
