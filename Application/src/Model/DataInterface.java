/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @authors : quentin, corentin& nicolas
 */
public interface DataInterface {
    
    public void createTicket (int idRide, int idUser, int adTick, int childTick, String date, String datePurchase, double price);
    
    public Ride [] createRide ();
    
    public void addRideFromEmployee (String name, double price, String features, int capacity, String image);
    
    public void updateRide (int id, String name, double price, String features, int capacity);
    
    public void deleteRide (int id);
    
    public Ride findRide (String nameRide);
    
    public ArrayList<Order> findOrder (int idUser);
    
    public String findNameRideForOrder (int idRide);
    
    public String findNameUserForOrder (int idUser);
    
    public int verifNumberOfTickets (String date, int id);
    
    public String typeUser (String pseu, String log);
    
    public Employee createEmployee (String pseu, String log);
    
    public MemberCustomer createMember (String pseu, String log);
    
    public int verifUser (String pseu, String log);
    
    public GuestCustomer createGuest (String name, int age, String user_type);
    
    public MemberCustomer createSQL_Member(String name, int age, String user_type, String pseudo, String password);
    
    public void deleteCustomer (int id);
    
    public void deleteOrder (int id);
    
    public ArrayList<GuestCustomer> findGuests_inSQL ();
    public ArrayList<MemberCustomer> findMembers_inSQL ();
    public ArrayList<Order> findAllOrders_inSQL ();
    /**
     *
     * @return an array List of Ride to display the list in the JTable of the 'Employee' frame
     */
    public ArrayList<Ride> findRides ();
    
}
