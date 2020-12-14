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
public class GuestCustomer extends Person {
    
    private double totalPrice;
    
    //Liste de tickets achetés par le customer
    private final ArrayList <Order> order = new ArrayList <> ();

    /**
     * Constructeur
     * @param id
     * @param name
     * @param age
     * @param type
     * @param img
     */
    public GuestCustomer(int id, String name, int age, String type, String img) {
        
        super (id, name, age,type, img);
        totalPrice = 0;
    }
    
    /**
     * Getters 
     * @return les attributs
     */
    public ArrayList <Order> getOrder () { return order; }
    public double getPrice () { return totalPrice; }
    
    /**
     * Setter 
     * @param p
     */
    public void setPrice (double p) { totalPrice = p; }
}
