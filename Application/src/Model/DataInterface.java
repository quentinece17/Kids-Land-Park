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
    
    public String verifUser (String pseu, String log, String info);
    
    public void createGuest (String name, int age, String user_type);
    
}
