/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @authors : quentin, corentin and nicolas
 */
// Class Person
public class Person {
    
    private String name;
    private int age;
    
    // Constructeur Person
    public Person (String n_, int a_) {
        
        name = n_;
        age = a_;  
    }
    
    public String getName () { return name; }
    public int getAge () { return age; }
    
}
