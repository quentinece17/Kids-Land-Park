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
    
    //Une attraction a un nombre de tickets maximum disponible, au-delà, on ne peut plus réserver de tickets pour cette attraction
    //Est ce que un INT suffit ou alors peut-être faire un tableau de Tickets pour bien relier les deux classes ? 
    private final int nbTicketsMax = 10;
    
    //Si la liste atteint la taille du nombre de tickets max (ici 10), alors 
    private ArrayList <Ticket> ticket= new ArrayList <Ticket> ();
    
    // Constructeur Ride
    public Ride(String name_, double price_, String features_ ){
        /// Initialisation des attributs de la nouvelle classe instanciée.
        name = name_;
        price = price_;
        features = features_;
        ticket= new ArrayList <Ticket> ();
    }
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getFeatures() { return features;}
}
