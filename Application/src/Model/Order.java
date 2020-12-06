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
    private String rideName;
    private int numberOfTickets;
    private double final_price;
    private boolean orderValid;
    
    // Constructeur Order
    public Order(String d_, String ride, int nb, double price_, boolean valid){
        date = d_;
        rideName = ride;
        numberOfTickets = nb;
        final_price = price_;
        orderValid = valid;
    }
    
    // Getters
    public String getDate () { return date; }
    public String getRideName () { return rideName; }
    public int getNumberOfTickets () { return numberOfTickets; }
    public double getPrice(){ return final_price; }
    public boolean getOrderValid () { return orderValid; }
    
    //Setter
    public void setOrderValid (boolean value) { orderValid = value; }
}
