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

//A voir plutôt comme une classe "Commande"
public class Order {
    
    private String date;
    private String datePurchase;
    private String rideName;
    private int AdultTickets;
    private int ChildTickets;
    private double final_price;
    private boolean orderValid;
    
    // Constructeur Order
    public Order(String d_, String ride, int nbAdu, int nbChild, double price_, boolean valid){
        date = d_;
        rideName = ride;
        AdultTickets = nbAdu;
        ChildTickets = nbChild;
        final_price = price_;
        orderValid = valid;
    }
    
    //Constructeur pour l'historique des commandes
    public Order (String dpurchase, String ride, int nbAdu, int nbChild, double price, String datevalid)
    {
        datePurchase = dpurchase;
        rideName = ride;
        AdultTickets = nbAdu;
        ChildTickets = nbChild;
        final_price = price;
        datePurchase = datevalid;
    }
    
    // Getters
    public String getDate () { return date; }
    public String getPurchaseDate () { return datePurchase; }
    public String getRideName () { return rideName; }
    public int getTicketsAdult () { return AdultTickets; }
    public int getTicketsChild () { return ChildTickets; }
    public double getPrice(){ return final_price; }
    public boolean getOrderValid () { return orderValid; }
    
    //Setter
    public void setOrderValid (boolean value) { orderValid = value; }
}
