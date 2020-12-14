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
    
    private final int idUser;
    private final String nameUser;
    private final int ageUser;
    private final String typeUser;
    private String image;
    
    // Attribut qu'on utilise uniquement si on a besoin d'insérer un MemberCustomer dans la JTable d'EmployeeFrame
    // --> On les set juste avant de les insérer pour la Person( Classe mère de la classe MemberCustomer en question)
    private String pseudoForJtable;
    private String loginForJtable;
    
    /**
     * Constructeur 
     * @param id
     * @param name
     * @param age
     * @param type
     * @param img
     */
    public Person (int id, String name, int age, String type, String img) {
        
        idUser = id;
        nameUser = name;
        ageUser = age;
        typeUser = type;
        image = img;
    }
    
    /**
     * Getters 
     * @return les attributs
     */
    public int getIdUser () { return idUser; }
    public String getNameUser () { return nameUser; }
    public int getAgeUser () { return ageUser; }
    public String getTypeUser () { return typeUser; }
    public String getImage () { return image; }
    public String getPseuTable() { return pseudoForJtable;  }
    public String getLogTable() { return loginForJtable;  }
    
    /**
     * Setters 
     * @param str
     */
    public void setPseuTable( String str ) { pseudoForJtable = str; }
    public void setLogTable( String str ) { loginForJtable = str; }
    public void setImage (String img) { image = img; }
}