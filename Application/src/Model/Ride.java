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
public class Ride {
   
    private String name;
    private double price;
    private String features;
    private int nbTicketsMax;
    
    //Si la liste atteint la taille du nombre de tickets max (ici 10), alors 
    private ArrayList <Integer> ticket= new ArrayList <Integer> ();
    
    // Constructeur Ride
    public Ride(String name_, double price_, String features_ , int maxTicket){
        /// Initialisation des attributs de la nouvelle classe instanciée.
        name = name_;
        price = price_;
        features = features_;
        nbTicketsMax = maxTicket;
        
    }
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getFeatures() { return features;}
    public int getNbTicketsMax () { return nbTicketsMax;}
}
