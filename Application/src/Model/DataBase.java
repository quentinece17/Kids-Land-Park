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
    public String typeUser (String pseu, String log)
    {
       String type = null;
       Connection conn = null;
       Statement stmt = null;
        
       String request = "select user_type from Personne where user_pseudo = '" + pseu + "' and user_login = '"
                        + log + "';";
       
       try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next()) {
                
                type = rs.getString(1);
            }
            
            conn.close();
            stmt.close();
        }
       
       catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
       
       return type;
    }
    
    @Override
    public Ride[] createRide ()
    {
        Connection conn = null;
        Statement stmt = null;
        int nbRide = 0;
        String request = "select count(*) from Ride;";
        Ride container [] = null;
        
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next())
            {
                nbRide = Integer.parseInt(rs.getString(1));
            }
            
            container = new Ride[nbRide];
            
            for (int i=1; i<=nbRide; ++i)
            {
                request = "select * from Ride where id_ride = " + i +";";
                rs = stmt.executeQuery(request);
                
                while (rs.next())
                {
                    container[i-1] = new Ride (rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), Integer.parseInt(rs.getString(5)));
                }
            }
            
            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        
        return container;
    }
    @Override
    public MemberCustomer createMember (String pseu, String log) 
    {
        
        Connection conn = null;
        Statement stmt = null;
        
        String request = "select * from Personne where user_pseudo = '" + pseu + "' and user_login = '"
                        + log + "';";
        MemberCustomer user = null;
                
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                int age = Integer.parseInt (rs.getString(3));
                //On crée un MemberCustomer
                user = new MemberCustomer (id, rs.getString(2), age, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    
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
    public Employee createEmployee (String pseu, String log)
    {
        Connection conn = null;
        Statement stmt = null;
        
        String request = "select * from Personne where user_pseudo = '" + pseu + "' and user_login = '"
                        + log + "';";
        Employee user = null;
                
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next()) {
               
                int id = Integer.parseInt(rs.getString(1));
                int age = Integer.parseInt (rs.getString(3));
                user = new Employee (id, rs.getString(2), age, rs.getString(4), rs.getString(5), rs.getString(6));
                    
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
    public GuestCustomer createGuest(String name, int age, String user_type) 
    {
        Connection conn = null;
        Statement stmt = null;
        GuestCustomer guest = null;
        
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
