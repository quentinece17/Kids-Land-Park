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
    private ArrayList <Ticket> ticket= new ArrayList <Ticket> ();

    public GuestCustomer(int id, String name, int age, String type) {
        
        super (id, name, age,type);
    }

    @Override
    public void calculateBills() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
