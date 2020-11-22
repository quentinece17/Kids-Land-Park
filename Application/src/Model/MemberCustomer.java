/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author quentin
 */
public class MemberCustomer extends Customer implements CustomerInterface {

    //Pour le memberType, si le customer est bien un MemberCustomer, son memberType sera indiqué dans la DB, c'est comme ça qu'on le construira
    private String memberType;
    private double discount;
    
    public MemberCustomer(String n_, int a_, String type, String log) {
       
        super(n_, a_, log);
        
        //Si login ok (vérifier dans DB) : 
            //On regarde memberType :
                // if (memberType.equals ("regular")) { discount = ...; }
                // else if (memberType.equals ("senior")) { discount = ...; }
                // else if ((memberType.equals ("children")) { discount = ...; }
        
        //Sinon, on ne crée pas le Member car il est invalide, du coup peut-être vérifier le login avant d'appeler le constructeur
        
        
        
    }

    @Override
    public void calculateBills() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Getters
    public String getMemberType() { return memberType;}
    public double getDiscount() { return discount;} 
    
}
