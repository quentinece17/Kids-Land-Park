/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.Person;

/**
 *
 * @author quentin
 */
public class Employee extends Person {
    
    //Il faut vérifier que c'est un employé, donc il doit saisir son login ? 
    private String login;
    
    public Employee (String n_, int a_, String log) { 
        
        super (n_, a_); 
        login = log;
    }
    
 
}
