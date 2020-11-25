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
public class DataBase implements DataInterface {
    
    @Override
    public String verifUser (String pseu, String log, String info) 
    {
        Connection conn = null;
        Statement stmt = null;
        
        String request = "select user_id, user_name, user_type, member_type from Personne where user_pseudo = '" + pseu + "' and user_login = '"
                        + log + "';";
        
        String value = null;
                
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next()) {
                if (info.equals("name"))
                    value = rs.getString(2);
                else if (info.equals("user_type"))
                    value = rs.getString(3);
                else if (info.equals("id"))
                    value = rs.getString(1);
                
            }
            
            conn.close();
            stmt.close();
            
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        return value;
    }

    @Override
    public void createGuest(String name, int age, String user_type) 
    {
        Connection conn = null;
        Statement stmt = null;
        
        String request = "insert into Personne (user_name, user_age, user_type) values ('" + name +"', " + age + ", '" + user_type + "');";
        System.out.println (request);
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement();
            stmt.executeUpdate(request);
            
            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
    }

}
