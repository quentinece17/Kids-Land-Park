/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @authors : quentin, corentin& nicolas
 */
public interface DataInterface {
    
    /**
     * Création des tickets
     * @param idRide
     * @param idUser
     * @param adTick
     * @param childTick
     * @param date
     * @param datePurchase
     * @param price
     */
    public void createTicket (int idRide, int idUser, int adTick, int childTick, String date, String datePurchase, double price);
    
    /** 
     * @return le tableau de Ride
     */
    public Ride [] createRide ();
    
    /**
     * Initialisation de la liste de Rides 
     * @param name
     * @param price
     * @param features
     * @param capacity
     * @param image
     */
    public void addRideFromEmployee (String name, double price, String features, int capacity, String image);
    
    /**
     * Modification d'une Ride 
     * @param id
     * @param name
     * @param price
     * @param features
     * @param capacity
     * @param image
     */
    public void updateRide (int id, String name, double price, String features, int capacity, String image);
    
    /**
     * Suppression d'un Ride 
     * @param id
     */
    public void deleteRide (int id);
    
    /**
     * @param nameRide
     * @return une Ride
     */
    public Ride findRide (String nameRide);
    
    /**
     * @param idUser
     * @return la liste des Order
     */
    public ArrayList<Order> findOrder (int idUser);
    
    /** 
     * @param idRide
     * @return le nom de l'attraction de la commande
     */
    public String findNameRideForOrder (int idRide);
    
    /** 
     * @param idUser
     * @return le nom de l'utilisateur de la commande
     */
    public String findNameUserForOrder (int idUser);
    
    /** 
     * @param date
     * @param id
     * @return le nombre de Tickets
     */
    public int verifNumberOfTickets (String date, int id);
    
    /** 
     * @param pseu
     * @param log
     * @return le type de l'utilisateur
     */
    public String typeUser (String pseu, String log);
    
    /**
     * @param pseu
     * @param log
     * @return l'employé Crée
     */
    public Employee createEmployee (String pseu, String log);
    
    /**
     * @param pseu
     * @param log
     * @return le member crée
     */
    public MemberCustomer createMember (String pseu, String log);
    
    /**
     * @param pseu
     * @param log
     * @return un int pour voir si l'utilisateur existe
     */
    public int verifUser (String pseu, String log);
    
    /**
     * @param name
     * @param age
     * @param user_type
     * @param image
     * @return le guest crée
     */
    public GuestCustomer createGuest (String name, int age, String user_type, String image);
    
    /**
     * @param name
     * @param age
     * @param user_type
     * @param pseudo
     * @param password
     * @param image
     * @return Le member crée en SQL
     */
    public MemberCustomer createSQL_Member(String name, int age, String user_type, String pseudo, String password, String image);
    
    /**
     * Modification d'un customer 
     * @param id
     * @param image
     */
    public void updateCustomer (int id, String image);
    
    /**
     * Suppression d'un customer 
     * @param id
     */
    public void deleteCustomer (int id);
    
    /**
     * Suppression d'une commande
     * @param id
     */
    public void deleteOrder (int id);
    
    /**
     * @return la liste de tous les guests de la base de donnée
     */
    public ArrayList<GuestCustomer> findGuests_inSQL ();
    
    /**
     * @return la liste de tous les membres de la base de donnée 
     */
    public ArrayList<MemberCustomer> findMembers_inSQL ();
    
    /**
     * @return la liste de toutes les commandes de la base de donnée
     */
    public ArrayList<Order> findAllOrders_inSQL ();

    /**
     * @return la liste de tous les Rides de la base de donnée
     */
    public ArrayList<Ride> findRides ();
    
    /**
     * @return la liste des tickets disponibles
     */
    public ArrayList<String> getAvailableTickets();

    /**
     * @return la liste de noms des Rides
     */
    public ArrayList<String> getRideNames();
    
    public int getTotalTicketsOfEachRide(int id);
    
}
