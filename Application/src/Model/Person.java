/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @authors : quentin, corentin and nicolas
 */
// Class Person
public class Person {
    
    private int idUser;
    private String nameUser;
    private int ageUser;
    private String pseudoUser;
    private String loginUser;
    private String typeUser;
    private String memberTypeUser;
    
    // Constructeur Person
    public Person (int id) {
        
        idUser = id;
        
        Connection conn = null;
        Statement stmt = null;
        
        String request = "select * from Personne where user_id = " + idUser + ";";
        
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next())
            {
                nameUser = rs.getString(2);
                ageUser = Integer.parseInt(rs.getString(3));
                pseudoUser = rs.getString(4);
                loginUser = rs.getString (5);
                typeUser = rs.getString(6);
                memberTypeUser = rs.getString (7);
            }
            
            conn.close();
            stmt.close();
            
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
       
  
    }
    
    
    public String getName () { return nameUser; }
    public int getAge () { return ageUser; }
    
}