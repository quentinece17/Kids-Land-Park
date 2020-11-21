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
public class Ride {
   
    private String name;
    private double price;
    private String features;
    
    //Une attraction a un nombre de tickets maximum disponible, au-delà, on ne peut plus réserver de tickets pour cette attraction
    //Est ce que un INT suffit ou alors peut-être faire un tableau de Tickets pour bien relier les deux classes ? 
    private final int nbTicketsMax = 10;
    
    //Si la liste atteint la taille du nombre de tickets max (ici 10), alors 
    private ArrayList <Ticket> ticket;
}
