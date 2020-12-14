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
    
    private final String pseudoUser;
    private final String loginUser;
        
    /**
     * Constructeur
     * @param id
     * @param name
     * @param age
     * @param type
     * @param pseu
     * @param log
     * @param img
     */
    public Employee (int id, String name, int age, String type, String pseu, String log, String img) { 
        
        super (id, name, age, type, img); 
        pseudoUser = pseu;
        loginUser = log;

    }
    
    /**
     * Getters
     * @return les attributs
     */
    public String getPseudoUser () { return pseudoUser; }
    public String getLoginUser () { return loginUser; }

}
