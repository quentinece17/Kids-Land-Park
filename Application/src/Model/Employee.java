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
public class Employee extends Person {
    
    private String pseudoUser;
    private String loginUser;
        
    public Employee (int id, String name, int age, String type, String pseu, String log) { 
        
        super (id, name, age, type); 
        pseudoUser = pseu;
        loginUser = log;

    }
    
    public String getPseudoUser () { return pseudoUser; }
    public String getLoginUser () { return loginUser; }

}
