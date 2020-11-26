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
public interface DataInterface {
    
    public Person createPerson (String pseu, String log);
    
    public int verifUser (String pseu, String log);
    
    public Person createGuest (String name, int age, String user_type);
    
}
