/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Person;
import java.util.ArrayList;

/**
 *
 * @authors : quentin, corentin and nicolas
 */
public class Customer extends Person {
    
    private double totalPrice;
    
    //Liste de tickets achetés par le customer
    private ArrayList <Ticket> ticket= new ArrayList <Ticket> ();
 
    // Constructeur Customer
    public Customer (String n_, int a_, String log) {
        
        super (n_, a_, log);  
    }
}
