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
public class MemberCustomer extends Person implements CustomerInterface {

    private double discount;
    private double totalPrice;
    private String pseudoUser;
    private String loginUser;
    private String memberTypeUser;
    
    //Liste de tickets achetés par le customer
    private ArrayList <Ticket> ticket= new ArrayList <Ticket> ();

    
    public MemberCustomer(int id, String name, int age, String type, String pseu, String log, String memberType) {
       
       super (id, name, age,type);
       pseudoUser = pseu;
       loginUser = log;
       memberTypeUser = memberType;
       
       if (memberType.equals("children"))
           discount = 0.3;
       
       else if (memberType.equals("regular"))
           discount = 0.2;
       
       else if (memberType.equals("senior"))
           discount = 0.1;
        
    }

    @Override
    public void calculateBills() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Getters
    public String getPseudoUser () { return pseudoUser; }
    public String getLoginUser () { return loginUser; }
    public String getMemberType() { return memberTypeUser;}
    public double getDiscount() { return discount;} 
    
}
