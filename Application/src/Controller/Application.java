 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataBase;
import Model.DataInterface;
import Model.Employee;
import Model.GuestCustomer;
import Model.MemberCustomer;
import Model.Person;
import View.AccueilFrame;
import View.AgeExceptionFrame;
import View.CustomerFrame;
import View.FieldsExceptionFrame;
import View.GuestInformationFrame;
import View.RegisterFrame;

import javax.swing.*;
import javax.swing.Icon;
import java.awt.*;
import javafx.scene.layout.Border;

/**
 *
 * @authors : quentin, corentin and nicolas
 */
public class Application{
    
    //Instance des différentes windows
    private AccueilFrame accueil;
    private RegisterFrame register;
    private GuestInformationFrame guestInfo;
    private CustomerFrame customer;
    private FieldsExceptionFrame field;
    private AgeExceptionFrame age;
    
    //Utilisateur
    Person user;
    
    //Constructeur
    public Application(){  

        Initialisation ();
    }

    //Initialisation des différentes window
    public void Initialisation () 
    {
        accueil = new AccueilFrame(this);
        accueil.getWindow().setVisible(true);
        register = new RegisterFrame (this);
        guestInfo = new GuestInformationFrame (this);
        customer = new CustomerFrame (this);
        field = new FieldsExceptionFrame(this);
        age = new AgeExceptionFrame(this);
    }

    //Méthodes d'affichage des différentes windows
    public void AffichageAccueil () { accueil.getWindow().setVisible(true);}
    public void AffichageRegister (){ register.getWindow().setVisible(true);}
    public void AffichageGuestInfo () { guestInfo.getWindow().setVisible(true);}
    public void AffichageFieldsException () { field.getWindow().setVisible(true);}
    public void AffichageAgeException () { field.getWindow().setVisible(true);}
    public void AffichageCustomer (){ 
        customer.getWindow().setVisible(true);
        customer.setText("Hello " + user.getNameUser());
    }

    public void personData (String pseu, String log)
    {
        //Permet de vérifier si la personne qui s'identifie existe
        int valid = 0;
        
        //Connection à la DB
        DataInterface verif = new DataBase ();
        valid = verif.verifUser(pseu, log);
        
        //Si la personne n'existe pas
        if (valid==0)
        {
            System.out.println ("user existe pas");
        }
        //Si la Personne existe
        else {
            user = verif.createPerson(pseu, log);
            System.out.println (user.getNameUser());
        }
    }
    

     public void createGuestData (String name, int age, String user_type)
     {
         DataInterface add = new DataBase ();
         user = add.createGuest(name, age, user_type);
         System.out.println ("Hello " + user.getNameUser() + "\nAge : " + user.getAgeUser() + " \nId : " + user.getIdUser() + "\nType : "+ user.getTypeUser());
     } 


     public Person getPerson () { return user; }
     
     // Exception Frame Setters
     // On initialise le message de la fenêtre d'exception correspondante
     public void setFieldExceptionLabel(String msg){
         field.setMessage(msg);
     }
     // Setter 
     public void setAgeExceptionLabel(String msg){
         field.setMessage(msg);
     }
}
    
