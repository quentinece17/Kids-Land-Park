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
public class DataBase {
    
    public DataBase () {
        
        Connection conn = null;
        
        try {
            
            String url = "jdbc:mysql://localhost:3306/KidsLand";
            String user = "root";
            String password = "Ajojo1718";

            conn = DriverManager.getConnection(url, user, password);
            
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("select * from Personne");

            while (rs.next()) {
                System.out.println (rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));

            }
            
            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            System.out.println ("xyz " + e.getMessage ());
        }
    }
}
