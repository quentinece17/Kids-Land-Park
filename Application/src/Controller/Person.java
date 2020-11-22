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
    private String login;

    
    // Constructeur Person
    public Person (String n_, int a_, String log) {
        
        name = n_;
        age = a_;  
        
        //si c'est un GuestCustomer, le login sera null
        //Peut-être pas besoin de faire un attribut login, il suffit peut-être juste de regarder dans la DB
        login = log;
    }
    
    public String getName () { return name; }
    public int getAge () { return age; }
    
}
