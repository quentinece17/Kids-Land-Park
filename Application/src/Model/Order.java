/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @authors : quentin, corentin and nicolas
 */

public class Order {
    
    private int id;
    private String customer;
    private String date;
    private String datePurchase;
    private String rideName;
    private int AdultTickets;
    private int ChildTickets;
    private double final_price;
    private boolean orderValid;
    
    /**
     * Constructeur 
     * @param d_
     * @param ride
     * @param nbAdu
     * @param nbChild
     * @param price_
     * @param valid
     */
    public Order(String d_, String ride, int nbAdu, int nbChild, double price_, boolean valid){
        date = d_;
        rideName = ride;
        AdultTickets = nbAdu;
        ChildTickets = nbChild;
        final_price = price_;
        orderValid = valid;
    }
    
    /**
     * Constructeur surchargé avec la date de validité 
     * @param dpurchase
     * @param ride
     * @param nbAdu
     * @param nbChild
     * @param price
     * @param datevalid
     */
    public Order (String dpurchase, String ride, int nbAdu, int nbChild, double price, String datevalid)
    {
        datePurchase = dpurchase;
        rideName = ride;
        AdultTickets = nbAdu;
        ChildTickets = nbChild;
        final_price = price;
        date = datevalid;
    }
    
    
    /**
     * Constructeur surchargé avec la date d'achat 
     * @param id_
     * @param user
     * @param ride
     * @param nbAdu
     * @param nbChild
     * @param price
     * @param dateValid
     * @param dPurchase
     */
    public Order (int id_, String user, String ride, int nbAdu, int nbChild, double price, String dateValid, String dPurchase) 
    {
        id = id_;
        customer = user;
        rideName = ride;
        AdultTickets = nbAdu;
        ChildTickets = nbChild;
        final_price = price;
        date = dateValid;
        datePurchase = dPurchase;
    }
   
    /**
     * Getters 
     * @return les attributs
     */
    public int getId () { return id; }
    public String getCustomer () { return customer; }
    public String getDate () { return date; }
    public String getPurchaseDate () { return datePurchase; }
    public String getRideName () { return rideName; }
    public int getTicketsAdult () { return AdultTickets; }
    public int getTicketsChild () { return ChildTickets; }
    public double getPrice(){ return final_price; }
    public boolean getOrderValid () { return orderValid; }
    
    /**
     * Setters 
     * @param value
     */
    public void setOrderValid (boolean value) { orderValid = value; }
}
