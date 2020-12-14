/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @authors : quentin, corentin & nicolas
 */
public class FieldException extends RuntimeException {
    
    /**
     * Constructeur
     */
    public FieldException(){
        super("Please fill all the text fields.");
    }
    
}
