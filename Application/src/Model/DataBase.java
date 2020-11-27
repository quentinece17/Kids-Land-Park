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
    public Person createPerson (String pseu, String log) 
    {
        
        Connection conn = null;
        Statement stmt = null;
        
        String request = "select * from Personne where user_pseudo = '" + pseu + "' and user_login = '"
                        + log + "';";
        Person user = null;
                
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next()) {
                //Si l'utilisateur est un MemberCustomer
                if (rs.getString(6).equals("MC"))
                {
                    int id = Integer.parseInt(rs.getString(1));
                    int age = Integer.parseInt (rs.getString(3));
                    //On crée un MemberCustomer
                    user = new MemberCustomer (id, rs.getString(2), age, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                }
                //Si l'utilisateur est un Employée
                else if (rs.getString(6).equals ("E"))
                {
                    int id = Integer.parseInt(rs.getString(1));
                    int age = Integer.parseInt (rs.getString(3));
                    user = new Employee (id, rs.getString(2), age, rs.getString(4), rs.getString(5), rs.getString(6));
                }
                    
            }
            
            conn.close();
            stmt.close();
            
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        
        return user;
    }
    
    @Override
    public int verifUser(String pseu, String log) {
        
        Connection conn = null;
        Statement stmt = null;
        
        String temp=null;
        int valid = 0;
        
        String request = "select exists (select * from Personne where user_pseudo = '" + pseu + "' and user_login = '"
                        + log + "');";
        
        
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next()) {
                 temp = rs.getString(1);
            }
            valid = Integer.parseInt (temp);
            
            conn.close();
            stmt.close();
            
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        
        return valid;
    }

    @Override
    public Person createGuest(String name, int age, String user_type) 
    {
        Connection conn = null;
        Statement stmt = null;
        Person guest = null;
        
        String request = "insert into Personne (user_name, user_age, user_type) values ('" + name +"', " + age + ", '" + user_type + "');";
        
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement();
            stmt.executeUpdate(request);
            
            request = "select user_id from Personne where user_name ='" + name + "' and user_age = "+ age + " and user_type ='" + user_type +"';";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                guest = new GuestCustomer (id, name, age, user_type);
            }

            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        return guest;
    }

    

}
