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
public class Ticket {
    
    private double price;
    
    //Ticket pour une attraction
    private Ride ride;
    
    // Constructeur Ticket
    public Ticket(double price_, Ride ride_){
        price = price_;
        ride = ride_;
    }
    
    // Getters
    public double getPrice(){ return price; }
    public Ride getRide() { return ride; }
    
}
