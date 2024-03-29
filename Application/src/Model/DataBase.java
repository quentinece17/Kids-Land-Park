/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.lang.reflect.Member;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author quentin
 */

//Voir l'interface DataInterface pour les JavaDoc
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
            
            JOptionPane.showMessageDialog(null, "Your order have been registered");
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
    public void addRideFromEmployee (String name, double price, String features, int capacity, String image) {
        
        Connection conn = null;
        Statement stmt = null;
        String request = "insert into Ride (name_ride, price_ride, features_ride, max_tickets, image) values ('" + name + "', " + price + ", '" + features + "', " + capacity + ", '" + image + "');";
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
    
    @Override
    public void updateRide (int id, String name, double price, String features, int capacity, String image) {
        
        Connection conn = null;
        Statement stmt = null;
        String request = "UPDATE Ride SET name_ride = '" + name + "', price_ride ='" + price + "', features_ride = '" + features + "', max_tickets = " + capacity + ", image = '" + image +"' where id_ride = " + id + ";";
        
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement();
            stmt.executeUpdate(request);
            JOptionPane.showMessageDialog(null, "Updated Sucessfully");
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
    }
    
    @Override
    public void deleteRide (int id) {
        
        Connection conn = null;
        Statement stmt = null;
        String request = "DELETE FROM Ride where id_ride = " + id + ";";
 
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement();
            stmt.executeUpdate(request);
            JOptionPane.showMessageDialog(null, "Deleted Successfully !");
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
            JOptionPane.showMessageDialog(null, "Deleted impossible, some orders are associated with this Ride");
        }
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
    
    // Fonction différente de findRide() qui récupère l'attraction voulu
    // -->Cette fonction récupère TOUTES les attractions du park
    @Override
    public  ArrayList<Ride> findRides () {
        
        ArrayList <Ride> container = new ArrayList <>(); // List d'attraction qui récupère toutes celles présente
                                                         // ->> dans la table 'Ridde' de la base de données
        Connection conn = null;
        Statement stmt = null;
        
        String request = "select * from Ride;";
        
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next())
            {
                container.add(new Ride (Integer.parseInt(rs.getString(1)), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), Integer.parseInt(rs.getString(5)), rs.getString(6)) );
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
    public ArrayList<GuestCustomer> findGuests_inSQL () {
        
        ArrayList <GuestCustomer> contain = new ArrayList <>();
        Connection conn = null;
        Statement stmt = null;

        // On sélectrionne tous les customers de type 'guest'
        String request = "select * from Personne where user_type='GC';"; 
        
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            // On ajoute tous les guest a la list 
            while (rs.next())
            {
                    contain.add(new GuestCustomer ( Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)), rs.getString(6), rs.getString(8)) );
            }
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        System.out.println("Taille contain list : " + contain.size());
        return contain;
    }
    
    @Override
    public ArrayList<MemberCustomer> findMembers_inSQL () {
        
        ArrayList <MemberCustomer> contain = new ArrayList <>();
        Connection conn = null;
        Statement stmt = null;

        // On sélectionne tous les customers de type 'membre'
        String request = "select * from Personne where user_type='MC';"; 
        
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            // On ajoute tous les guest a la list 
            while (rs.next())
            {
                    contain.add(new MemberCustomer ( Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)) );
            }
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        System.out.println("Taille contain list : " + contain.size());
        return contain;
    }
    
    @Override
    public ArrayList <Order> findAllOrders_inSQL () {
        ArrayList <Order> orders = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;

        // On sélectionne tous les customers de type 'membre'
        String request = "select * from Command;"; 
        
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            // On ajoute tous les guest a la list 
            while (rs.next())
            {
                int id = Integer.parseInt(rs.getString(1));
                int valueRide = Integer.parseInt(rs.getString(2));
                String nameRide = findNameRideForOrder (valueRide);
                int valueUser = Integer.parseInt(rs.getString(3));
                String nameUser = findNameUserForOrder (valueUser);
                int adultTicket = Integer.parseInt(rs.getString(4));
                int childTicket = Integer.parseInt(rs.getString(5));
                String date = rs.getString(6);
                String datePurchase = rs.getString(7);
                double price = Double.parseDouble(rs.getString(8));
                
                orders.add(new Order (id, nameUser, nameRide, adultTicket, childTicket, price, date, datePurchase));
                
            }
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        return orders;
    }
   
    @Override
    public ArrayList<Order> findOrder (int idUser) {
        
        ArrayList <Order> contain = new ArrayList <>();
        Connection conn = null;
        Statement stmt = null;
//        ArrayList <String> name_ride = new ArrayList<>();
        
//        name_ride = findNameRideForOrder(idUser);
//        System.out.println (name_ride.size());
        String request ="select date_purchase, ride_command, adult_ticket, child_ticket, total_price, date_command from Command where user_command = " + idUser + ";";
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next())
            {
                
                String name_ride = findNameRideForOrder (Integer.parseInt(rs.getString(2)));
                contain.add(new Order (rs.getString(1), name_ride, Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(4)), Double.parseDouble(rs.getString(5)), rs.getString(6)));

            }
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        
        return contain;
    }
    
    @Override
    public String findNameRideForOrder (int idRide) {
        Connection conn = null;
        Statement stmt = null;
        String name=null;
        String request = "select name_ride from Ride where id_ride = " + idRide + ";";
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next())
            {
                name = rs.getString(1);
            }
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        return name;
    }
    
    @Override
    public String findNameUserForOrder (int idUser) {
        Connection conn = null;
        Statement stmt = null;
        String name=null;
        String request = "select user_name from Personne where user_id = " + idUser + ";";
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = stmt.executeQuery(request);
            
            while (rs.next())
            {
                name = rs.getString(1);
            }
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        return name;
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
                user = new MemberCustomer (id, rs.getString(2), age, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                    
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
    public void updateCustomer (int id, String image) {
        Connection conn = null;
        Statement stmt = null;
        String request = "UPDATE Personne SET image = '" + image + "' where user_id = " + id + ";";       
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement();
            stmt.executeUpdate(request);
            JOptionPane.showMessageDialog(null, "Updated Sucessfully");
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
    }
    
    @Override
    public void deleteCustomer (int id) {
        Connection conn = null;
        Statement stmt = null;
        String request = "DELETE FROM Command where user_command =" + id + ";";
                
        System.out.println (request);
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement();
            stmt.executeUpdate(request);
            request = "DELETE FROM Personne where user_id = " + id + ";";
            stmt.executeUpdate(request);
            JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
            JOptionPane.showMessageDialog(null, "Deleted impossible, some orders are associated with this Ride");
        }
    }
    
    @Override
    public void deleteOrder (int id) {
        Connection conn = null;
        Statement stmt = null;
        String request = "DELETE FROM Command where id_command =" + id + ";";
                
         try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
            
            stmt = conn.createStatement();
            stmt.executeUpdate(request);
            
            JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
            conn.close();
            stmt.close();
        }
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
            JOptionPane.showMessageDialog(null, "Deleted impossible, some orders are associated with this Ride");
        }
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
                user = new Employee (id, rs.getString(2), age, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8));
                    
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
    public GuestCustomer createGuest(String name, int age, String user_type, String image) 
    {
        Connection conn = null;
        Statement stmt = null;
        GuestCustomer guest = null;
        
        String request = "insert into Personne (user_name, user_age, user_type, image) values ('" + name +"', " + age + ", '" + user_type + "', '" + image + "');";
        
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
                guest = new GuestCustomer (id, name, age, user_type, image);
            }

            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        return guest;
    }

    @Override
    public MemberCustomer createSQL_Member(String name, int age, String user_type, String pseudo, String password, String image) {
        
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
        String request = "insert into Personne (user_name, user_age, user_pseudo, user_login, user_type, member_type, image) values ('" + name + "', " + age + ", '" + pseudo + "', '" + password + "', 'MC', '" + mType + "', '" + image + "');";
        
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
    
    
    @Override
    public int [] getTotalTicketsOfEachRide() {
        
        ArrayList<String> tickets = new ArrayList<String> ();
        
        Connection conn = null;
        Statement stmt = null;
        MemberCustomer member = null;
        int nbCommandes = 0;
        int nbRides = 0;
        int [] totalTicketsForaRide = null;
        
        String request = "select id_ride from Ride;";
        
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
                  
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(request);
            while (rs.next()) {
                nbRides = Integer.parseInt(rs.getString(1));
            }
            totalTicketsForaRide = new int [nbRides];
           // for (int i : totalTicketsForaRide)
            
            
            request = "select ride_command from Command;";
            rs = stmt.executeQuery(request);
            
            while (rs.next()) {
                totalTicketsForaRide[Integer.parseInt(rs.getString(1))] +=1;
            }
            
            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        
        return totalTicketsForaRide;
    }
    
    @Override
    public ArrayList<String> getAvailableTickets() {
        
        ArrayList<String> tickets = new ArrayList<String> ();
        
        Connection conn = null;
        Statement stmt = null;
        MemberCustomer member = null;
        
        
        String request = "select max_tickets from Ride;";
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
                  
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(request);

            while (rs.next()) {
                tickets.add( rs.getString(1) );
            }
            
            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        
        return tickets;
    }
    
    @Override
    public ArrayList<String> getRideNames() {
        
        ArrayList<String> rides = new ArrayList<> ();
        
        Connection conn = null;
        Statement stmt = null;
        MemberCustomer member = null;
        
        
        String request = "select name_ride from Ride;";
        //System.out.println("Test");
        try 
        {
            DataSource data = new DataSource ();
            conn = data.createConnection();
                  
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(request);

            while (rs.next()) {
                rides.add( rs.getString(1) );
            }
            
            conn.close();
            stmt.close();
        }
        
        catch (SQLException e){
            
            System.out.println ("Error Occured " + e.getMessage ());
        }
        
        return rides;
    }
    
}
