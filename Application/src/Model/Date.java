/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Application;
import java.util.ArrayList;

/**
 *
 * @authors : quentin, corentin and nicolas
 */
public class Date {
    
    //Instance d'Application pour accéder au tableau d'attractions
    private Application controller;
    private String dateActuelle; 
    
    //Tableau d'attractions :  Pour chaque date, chaque attraction a un nombre de tickets disponible
    private Ride [] rideOfTheDate = new Ride [6];
    
    //S'il n'y a plus de tickets dispo pour une certaine date, le boolean passe à false -> la date n'est plus disponible
    private boolean validDate;
    
    // Constructeur Date
    public Date(String date){
        
        validDate = true;                   // Etant donnée qu'une classe date vient d'être créer, son boolean vaut 'true'
        dateActuelle = date;
        
        DataInterface add = new DataBase ();
        rideOfTheDate = add.createRide();
        
    }

    public Date() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String getDateActuelle () { return dateActuelle; }
    public Ride[] getRide () { return rideOfTheDate; }
            
    
    
}
