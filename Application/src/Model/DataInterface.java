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
    
    public String typeUser (String pseu, String log);
    
    public Employee createEmployee (String pseu, String log);
    
    public MemberCustomer createMember (String pseu, String log);
    
    public int verifUser (String pseu, String log);
    
    public GuestCustomer createGuest (String name, int age, String user_type);
    
}
