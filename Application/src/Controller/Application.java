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
import View.FieldsExceptionFrame;
import View.GuestInformationFrame;
import View.RegisterFrame;
import View.CustomerFrame;

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
    private FieldsExceptionFrame field;
    private AgeExceptionFrame age;
    
    private CustomerFrame customer;
    
    //Utilisateur
    Person user;
    private Employee employee = null;
    private GuestCustomer guest = null;
    private MemberCustomer member = null;
    
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
        field = new FieldsExceptionFrame(this);
        age = new AgeExceptionFrame(this);
        customer = new CustomerFrame (this);
    }

    //Méthodes d'affichage des différentes windows
    public void AffichageAccueil () { accueil.getWindow().setVisible(true);}
    public void AffichageRegister (){ register.getWindow().setVisible(true);}
    public void AffichageGuestInfo () { guestInfo.getWindow().setVisible(true);}
    public void AffichageFieldsException () { field.getWindow().setVisible(true);}
    public void AffichageAgeException () { field.getWindow().setVisible(true);}
    
    public void AffichageCustomer (){ 
        customer.getWindow().setVisible(true);
        if (member != null && guest == null)
            customer.setText("Hello " + member.getNameUser());
        if (guest != null && member == null)
            customer.setText("Hello " + guest.getNameUser());
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
            //On regarde quel est le type de l'utilisateur
            String type = verif.typeUser(pseu, log);
            System.out.println (type);
            if (type.equals ("MC"))
            {
                member = verif.createMember(pseu, log);
            }
            else if (type.equals("E"))
            {
                employee = verif.createEmployee(pseu, log);
            }
        }
    }
    

     public void createGuestData (String name, int age, String user_type)
     {
         DataInterface add = new DataBase ();
         guest = add.createGuest(name, age, user_type);
         System.out.println ("Hello " + guest.getNameUser() + "\n Age : " + guest.getAgeUser() + " \nId : " + guest.getIdUser() + "\nType : "+ guest.getTypeUser());
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
     public Employee getEmployee () { return employee; }
     public GuestCustomer getGuest () { return guest; }
     public MemberCustomer getMember () { return member; }
}
    
