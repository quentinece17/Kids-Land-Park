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
   
    private int idRide;
    private String name;
    private double price;
    private String features;
    private int nbTicketsAvailable;

    
    // Constructeur Ride
    public Ride(int id, String name_, double price_, String features_ , int maxTicket){
        /// Initialisation des attributs de la nouvelle classe instanciée.
        idRide = id;
        name = name_;
        price = price_;
        features = features_;
        nbTicketsAvailable = maxTicket;
        
    }
    
    // Getters
    public int getIdRide () { return idRide; } 
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getFeatures() { return features;}
    public int getNbTicketsAvailable () { return nbTicketsAvailable;}
    
    public void setNbTicketsAvailable (int nb) { nbTicketsAvailable = nb; } 
}
