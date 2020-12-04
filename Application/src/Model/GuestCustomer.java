/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @authors : quentin, corentin and nicolas
 */
public class GuestCustomer extends Person implements CustomerInterface {
    
    private double totalPrice;
    
    //Liste de tickets achetés par le customer
    private ArrayList <Order> order = new ArrayList <Order> ();

    public GuestCustomer(int id, String name, int age, String type) {
        
        super (id, name, age,type);
        totalPrice = 0;
    }

    @Override
    public void calculateBills() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList <Order> getOrder () { return order; }
    public double getPrice () { return totalPrice; }
    
     public void setPrice (double p) { totalPrice = p; }
}
