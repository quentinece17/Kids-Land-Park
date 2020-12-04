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
    
    // Constructeur Order
    public Order(String d_, String ride, int nb, double price_){
        date = d_;
        rideName = ride;
        numberOfTickets = nb;
        final_price = price_;
    }
    
    // Getters
    private String getDate () { return date; }
    private String getRideName () { return rideName; }
    private int getNumberOfTickets () { return numberOfTickets; }
    public double getPrice(){ return final_price; }
    
}
