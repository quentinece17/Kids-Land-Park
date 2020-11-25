/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.DataBase;


import Model.DataBase;

//Le problème c est que quand je recupere les données dans "Application" elles sont à nulles et à 0 car j ai pas encore cliqué 
//sur le bouton au moment où ça se lance. Donc faudrait que ca recupère les infos seulement quand j ai cliqué sur le bouton mais 
//je sais pas comment on fait.
//Soit y'a une fonction ou un truc qui existe 
//Soit on crée des fonctions de Application qu'on appelle dans RegisterFrame mais ca fait des fonction qui appellent des fonctions 
//qui se re appellent elles-même ca fait vraiment bizarre et pas clean je trouve


/**
 *
 * @authors : quentin, corentin & nicolas
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DataBase base = new DataBase ();
        // TODO code application logic here
        Application park = new Application();
    }  
}
