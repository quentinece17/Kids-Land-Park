/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author quentin
 */
public class Date {
    
    //Par exemple, on a 30 tickets max de dispo pour une date
    private final int nbTicketMax = 30;
    
    //Pour une date, il y a un certain nombre de tickets disponible
    private ArrayList <Ticket> tickets;
    
    //S'il n'y a plus de tickets dispo pour une certaine date, le boolean passe à false -> la date n'est plus disponible
    private boolean validDate;
    
}
