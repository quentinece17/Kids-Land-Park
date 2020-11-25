/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.AccueilFrame;
import View.RegisterFrame;

/**
 *
 * @authors : quentin, corentin and nicolas
 */
// Class Person
public class Person {
    
    private int idUser;
    private String nameUser;
    private int ageUser;

    
    // Constructeur Person
    public Person (int id, String n_, int a_) {
        
        nameUser = n_;
        ageUser = a_;  
  
    }
    
    public static void createPerson (int id, String name)
    {
        
    }
    
    public String getName () { return nameUser; }
    public int getAge () { return ageUser; }
    
}
