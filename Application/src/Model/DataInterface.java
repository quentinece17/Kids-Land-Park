/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @authors : quentin, corezntin& nicolas
 */
public interface DataInterface {
    
    public void createTicket (int idRide, int idUser, int adTick, int childTick, String date, String datePurchase, double price);
    
    public Ride [] createRide ();
    
    public Ride findRide (String nameRide);
    
    public Order findOrder (int idUser);
    
    public int verifNumberOfTickets (String date, int id);
    
    public String typeUser (String pseu, String log);
    
    public Employee createEmployee (String pseu, String log);
    
    public MemberCustomer createMember (String pseu, String log);
    
    public int verifUser (String pseu, String log);
    
    public GuestCustomer createGuest (String name, int age, String user_type);
    
    public MemberCustomer createSQL_Member(String name, int age, String user_type, String pseudo, String password);
    
}
