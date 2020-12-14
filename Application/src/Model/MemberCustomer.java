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
public class MemberCustomer extends Person {

    private double discount;
    private double totalPrice;
    private final String pseudoUser;
    private final String loginUser;
    private final String memberTypeUser;
    
    
    //Liste de commandes achetés par le customer
    private final ArrayList <Order> order= new ArrayList <> ();

    /**
     * Constructeur
     * @param id
     * @param name
     * @param age
     * @param pseu
     * @param log
     * @param type
     * @param memberType
     * @param img
     */
    public MemberCustomer(int id, String name, int age, String pseu, String log, String type, String memberType, String img) {
       
       super (id, name, age,type, img);
       pseudoUser = pseu;
       loginUser = log;
       memberTypeUser = memberType;
       totalPrice = 0;
       
        switch (memberType) {
            case "children":
                discount = 0.3;
                break;
            case "regular":
                discount = 0.2;
                break;
            case "senior":
                discount = 0.1;
                break;
        }
        
    }
    
    /**
     * Getters 
     * @return 
     */
    public String getPseudoUser () { return pseudoUser; }
    public String getLoginUser () { return loginUser; }
    public String getMemberType() { return memberTypeUser;}
    public double getDiscount() { return discount;} 
    public double getPrice () { return totalPrice; }
    public ArrayList <Order> getOrder () { return order; }

    /**
     * Setter 
     * @param p
     */
    public void setPrice (double p) { totalPrice = p; }
    
}
