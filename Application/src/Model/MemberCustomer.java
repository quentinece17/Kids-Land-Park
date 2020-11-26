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

    private double discount;
    private String pseudoUser;
    private String loginUser;
    private String memberTypeUser;

    
    public MemberCustomer(int id, String name, int age, String type, String pseu, String log, String memberType) {
       
       super (id, name, age,type);
       pseudoUser = pseu;
       loginUser = log;
       memberTypeUser = memberType;
        
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
    public String getPseudoUser () { return pseudoUser; }
    public String getLoginUser () { return loginUser; }
    public String getMemberType() { return memberTypeUser;}
    public double getDiscount() { return discount;} 
    
}
