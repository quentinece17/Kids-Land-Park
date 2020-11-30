/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author lonyf
 */
public class AgeException extends Exception {
    
    // Si il n'y a pas de paramètre, on appelle le constructeur par défaut
    public AgeException(){
        super("Please enter an appropriate age.");
    }
    
    public AgeException(String str){
        super( str + ", Please enter an appropriate age.");
    }
}
