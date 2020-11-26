/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @authors : quentin, corentin and nicolas
 */
// Class Person
public class Person {
    
    private int idUser;
    private String nameUser;
    private int ageUser;
    private String typeUser;
    
    // Constructeur Person
    public Person (int id, String name, int age, String type) {
        
        idUser = id;
        nameUser = name;
        ageUser = age;
        typeUser = type;
    }
    
    public int getIdUser () { return idUser; }
    public String getNameUser () { return nameUser; }
    public int getAgeUser () { return ageUser; }
    public String getTypeUser () { return typeUser; }
    
}