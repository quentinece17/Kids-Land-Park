/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Person;

/**
 *
 * @authors : quentin, corentin and nicolas
 */
public class Customer extends Person {
    
    private double totalPrice;
 
    // Constructeur Customer
    public Customer (String n_, int a_) {
        
        super (n_, a_);  
    }
}
