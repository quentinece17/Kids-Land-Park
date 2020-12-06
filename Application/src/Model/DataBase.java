/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
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
    
    public void createTicket (int idRide, int idUser, int adTick, int childTick, String date, String datePurchase, double price) {
        
        Connection conn = null;
        Statement stmt = null;
        
        String request = "insert into Command (ride_command, user_command, adult_ticket, child_ticket, date_command, date_purchase, total_price) values (" + idRide + ", " + idUser + ", " + adTick + ", "+ childTick +",'" + date + "', '" + datePurchase +"', " + price + ");"; 
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
                    container[i-1] = new Ride (Integer.parseInt(rs.getString(1)), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), Integer.parseInt(rs.getString(5)));
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
    public Ride findRide (String nameRide) {
        
        Ride container = null;
        Connection conn = null;
        Statement stmt = null;
        
        String request = "select * from Ride where name_ride = '" + nameRide + "';";
        
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next())
            {
                container = new Ride (Integer.parseInt(rs.getString(1)), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), Integer.parseInt(rs.getString(5)));
            }
            
            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        return container;
    }
    
    public Order findOrder (int idUser) {
        
        ArrayList <Order> contain = new ArrayList <>();
        Order container = null;
        Connection conn = null;
        Connection conn2 = null;
        Statement stmt = null;
        Statement stmt2 = null;
        String name_ride;
        String request = "select * from Command where user_command = " + idUser + ";";
        
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next())
            {
                int ride_cmd = Integer.parseInt(rs.getString(2));
                String rqst = "Select name_ride from Ride where id_ride = " + ride_cmd + ";";
                try 
                {
                     stmt2 = conn2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                     ResultSet rs2 = stmt.executeQuery(request);
                     while (rs.next())
                     {
                         name_ride = rs.getString(1);
                     }
                     conn2.close();
                     stmt2.close();
                }
                catch (SQLException e){
            
                    System.out.println ("Error Occured " + e.getMessage ());
                }
                
//                contain.add(new Order (rs.getString(7), name_ride, Integer.parseInt(rs.getString(4), Integer.parseInt(rs.getString(5)), Double.parseDouble(rs.getString(8)), rs.getString(6)));
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

    public int verifNumberOfTickets (String date, int id) {
        
        int nb = 0;
        Connection conn = null;
        Statement stmt = null;
        
        String request = "select * from Command where date_command = '" + date + "' and ride_command = " + id + ";";
        
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next())
            {
                nb += Integer.parseInt(rs.getString(4)) + Integer.parseInt(rs.getString(5));
            }
            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured loulou " + e.getMessage ());
        }
        
        
        return nb;
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

    // Fonction qui insère un member customer à part entière dans la base de données 
    @Override
    public MemberCustomer createSQL_Member(String name, int age, String user_type, String pseudo, String password) {
        
        Connection conn = null;
        Statement stmt = null;
        MemberCustomer member = null;
        String mType = "X";
        
        // On défini ici le type du member customer en fonction de son age
        // On commence du + grand au plus petit sinon par exemple si l'age est de 13 et qu'on vérifie si l'age est <= 55 en dernier, la personne sera senior automatiquement
        if (age >= 55)  mType = "senior";
        if (age < 55)   mType = "regular";
        if (age < 13)   mType = "children";
        
            
        //MemberCustomer member = new MemberCustomer(name, age, user_type, pseudo , password); 
        String request = "insert into Personne (user_name, user_age, user_pseudo, user_login, user_type, member_type) values ('" + name + "', " + age + ", '" + pseudo + "', '" + password + "', 'MC', '" + mType + "');";
        
        // Insertion dans la base de données du nouveau Member Customer
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement();
            stmt.executeUpdate(request);

            member = createMember(pseudo, password);
            
            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        return member;
    }
    
}
