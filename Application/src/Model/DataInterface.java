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
    
    public Ride findRide (String nameRide);
    
    public ArrayList<Order> findOrder (int idUser);
    
    public String findNameRideForOrder (int idRide);
    
    public int verifNumberOfTickets (String date, int id);
    
    public String typeUser (String pseu, String log);
    
    public Employee createEmployee (String pseu, String log);
    
    public MemberCustomer createMember (String pseu, String log);
    
    public int verifUser (String pseu, String log);
    
    public GuestCustomer createGuest (String name, int age, String user_type);
    
    public MemberCustomer createSQL_Member(String name, int age, String user_type, String pseudo, String password);
    
    public ArrayList<GuestCustomer> findGuests_inSQL ();
    public ArrayList<MemberCustomer> findMembers_inSQL ();
    
    /**
     *
     * @return an array List of Ride to display the list in the JTable of the 'Employee' frame
     */
    public ArrayList<Ride> findRides ();
    
}
