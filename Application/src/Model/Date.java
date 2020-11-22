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
public class Date {
    
    //Il faut un attribut pour la date en question : String ? 3 int ? GregorianCalendar ? 
    
    //Par exemple, on a 30 tickets max de dispo pour une date
    private final int nbTicketMax = 30;
    
    //Pour une date, il y a un certain nombre de tickets disponible
    //Pas sûr que ce soit utile, on peut tout simplement regarder dans la DB "Tickets", le nombre de tickets qu'il y a a la date en question
    private ArrayList <Integer> tickets;
    
    //S'il n'y a plus de tickets dispo pour une certaine date, le boolean passe à false -> la date n'est plus disponible
    private boolean validDate;
    
    // Constructeur Date
    public Date(){
        tickets = new ArrayList<Integer>();  // Instanciation de la liste de Ticket 'tickets' en attributs
        validDate = true;                   /// Etant donnée qu'une classe date vient d'être créer, son boolean vaut 'true'
    }
    
    // Getter
    public ArrayList<Integer> getTickets() { return tickets; }
    
    
    
}
