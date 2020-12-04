/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataBase;
import Model.DataInterface;
import Model.Date;
import Model.Employee;
import Model.GuestCustomer;
import Model.MemberCustomer;
import Model.Order;
import Model.Person;
import Model.Ride;
import View.AccueilFrame;
import View.AgeExceptionFrame;
import View.ChooseRide;
import View.ConfirmOrder;
import View.FieldsExceptionFrame;
import View.GuestInformationFrame;
import View.RegisterFrame;
import View.CustomerFrame;
import View.InfosAttraction;
import View.NumberOfTickets;
import View.SignUpFrame;

import javax.swing.*;
import javax.swing.Icon;
import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
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
    private SignUpFrame newPerson;
    private ChooseRide chooseride;
    private InfosAttraction infoAttrac;
    private NumberOfTickets numTickets;
    private ConfirmOrder confirmation;
    
    //Tableau d'attractions
    private Ride [] ride;
    private String actualRide;
    
    //Liste de dates
    ArrayList <Date> allDates = new ArrayList <>();
    
    //Utilisateur
    private Employee employee = null;
    private GuestCustomer guest = null;
    private MemberCustomer member = null;
    
    //Constructeur
    public Application() throws ParseException{  

        InitialisationRide ();
        Initialisation ();
    }

    //Initialisation des différentes window
    public void Initialisation () throws ParseException 
    {
        accueil = new AccueilFrame(this);
        accueil.getWindow().setVisible(true);
        register = new RegisterFrame (this);
        guestInfo = new GuestInformationFrame (this);
        field = new FieldsExceptionFrame(this);
        age = new AgeExceptionFrame(this);
        customer = new CustomerFrame (this);
        newPerson = new SignUpFrame(this);
        chooseride = new ChooseRide (this);
        infoAttrac = new InfosAttraction (this);
        numTickets = new NumberOfTickets (this);
        confirmation = new ConfirmOrder (this);
    }
    
    public void AddDate (String date) {
        boolean valid = true;
        int indiceDate = 0;
        int indiceRide = 0;
        //On regarde si la date choisie existe déjà dans la liste de dates
        for (int i =0; i<allDates.size(); ++i)
        {
            if (allDates.get(i).getDateActuelle().equals(date))
                valid = false;
        }
        //Si elle n'existe pas, on l'ajouter
        if (valid)
            allDates.add(new Date (date));
       
        
        
    }

    //Méthodes d'affichage des différentes windows
    public void AffichageAccueil () { accueil.getWindow().setVisible(true);}
    public void AffichageRegister (){ register.getWindow().setVisible(true);}
    
    public void AffichageSignUp (String prenom, String nom, int age){
        newPerson.setDataSignUp(prenom, nom, age);
        newPerson.getWindow().setVisible(true);
    }
    public void AffichageGuestInfo () { guestInfo.getWindow().setVisible(true);}
    public void AffichageFieldsException () { field.getWindow().setVisible(true);}
    public void AffichageAgeException () { field.getWindow().setVisible(true);}
    public void AffichageNumberOfTickets (String date) {
        numTickets.getWindow().setVisible(true);
        numTickets.setDateChoosen(date);
    }
    
    public void AffichageCustomer (){ 
        customer.getWindow().setVisible(true);
        if (member != null && guest == null)
            customer.setText("Hello " + member.getNameUser());
        if (guest != null && member == null)
            customer.setText("Hello " + guest.getNameUser());
    }
    
    public void AffichageChooseRide (String dateChoosen) {
        chooseride.getWindow().setVisible(true);
        chooseride.setDateChoosen(dateChoosen);
        chooseride.setDateChoosenLabel(dateChoosen);
        chooseride.setInfoAttrac1(ride[0].getName());
        chooseride.setInfoAttrac2(ride[1].getName());
        chooseride.setInfoAttrac3(ride[2].getName());
        chooseride.setInfoAttrac4(ride[3].getName());
        chooseride.setInfoAttrac5(ride[4].getName());
        chooseride.setInfoAttrac6(ride[5].getName());
    }
    
    public void AffichageConfirmOrder (String date, String nbTickets) {
        
        confirmation.getWindow().setVisible (true);
        confirmation.setDateChoosen(date);
        confirmation.setDateChoosenLabel(date);
        confirmation.setNbOfTickets(Integer.parseInt(nbTickets));
        double price=0;
        double discount=0;
        String discountField=null;
        for (int i=0; i<ride.length; ++i)
        {
            if (ride[i].getName().equals(actualRide))
                price = ride[i].getPrice();
        }
        confirmation.setRide(actualRide);
        confirmation.setNbTickets(nbTickets);
        double finalPrice = price * (Integer.parseInt(nbTickets));
        confirmation.setPrice1(String.valueOf(finalPrice));
        if (member != null && guest == null)
        {
            discount = member.getDiscount()*100;
            discountField = discount + " %";
            confirmation.setDiscount(discountField); 
            confirmation.setPrice2(String.valueOf(member.getDiscount()*finalPrice));
            member.setPrice(member.getPrice() + member.getDiscount()*finalPrice); 
        }
        else if (member == null && guest != null)
        {
            confirmation.setDiscount ("No discount");
            confirmation.setPrice2(String.valueOf(finalPrice));
            guest.setPrice (guest.getPrice() + finalPrice);
        }
            
    }
    
    public void AffichageInfosAttraction (String attraction, String dateChoosen) {
        infoAttrac.getWindow().setVisible(true);
        infoAttrac.setChoosenDate(dateChoosen);
        infoAttrac.getBouton().setEnabled(true);
        actualRide = attraction;
        
        boolean valid = false;
        int indiceDate=0;
        int indiceRide = 0;
        int nbExist = 0;
        
        //On regarde à quelle attraction correspond celle envoyé en paramètre (celle sur laquelle l'utilisateur a cliqué)
        for (int i=0; i<ride.length; ++i)
        {
            if (ride[i].getName().equals(attraction))
            {
                infoAttrac.setName(ride[i].getName());
                infoAttrac.setPrice(String.valueOf(ride[i].getPrice()));
                infoAttrac.setFeatures(ride[i].getFeatures());
                
                DataInterface verif = new DataBase ();
                nbExist = verif.verifNumberOfTickets(dateChoosen, ride[i].getIdRide());
                
                infoAttrac.setTicketsAvailable(String.valueOf(ride[i].getNbTicketsAvailable()-nbExist));
                
                if (nbExist == ride[i].getNbTicketsAvailable())
                {
                    infoAttrac.getBouton().setEnabled(false);
                }
                
                //On regarde si la date chosie existe dans la liste (si elle a déjà été sélectionné au paravant)
//                for (int j=0; j<allDates.size(); ++j)
//                {
//                    if (allDates.get(j).getDateActuelle().equals(dateChoosen))
//                    {
//                        valid = true;
//                        indiceDate = j;
//                    }
//                        
//                }
//                
//                if (valid)
//                {
////                    //On recupère l'indice du Ride correspondant à celui choisi
////                    for (int k=0; k<allDates.get(indiceDate).getRide().length; ++k)
////                    {
////                        if (allDates.get(indiceDate).getRide()[k].getName().equals(attraction))
////                            indiceRide =k;
////    
////                    }
//                    //On récupère le nombre de tickets restant de l'attraction choisie pour la date choisie
//                    int container = allDates.get(indiceDate).getRide()[i].getNbTicketsAvailable();
//                    
//                    infoAttrac.setTicketsAvailable(String.valueOf(container));
//                    
//                }
//                //Si la date n'a jamais été sélectionné au paravant, on affiche la valeur non mise à jour se trouvant dans le tableau d'attraction de la classe Application
//                else
//                {
//                    infoAttrac.setTicketsAvailable(String.valueOf(ride[i].getNbTicketsAvailable()));
//                }
            }
            else {
                //Exception
                System.out.println ("Attraction pas trouvé");
            }
        }
        
    }

    public void InitialisationRide () 
    {
        DataInterface create = new DataBase ();
        ride = create.createRide();
        
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

     public void create0rder (String date, int nbTickets) {
         
         if (member!=null && guest==null)
         {
             member.getOrder().add(new Order (date, actualRide, nbTickets, member.getPrice()));
         }
         else if (member==null && guest != null)
         {
             guest.getOrder().add(new Order (date, actualRide, nbTickets, guest.getPrice()));
         }
     }
     
     public void createTicket_inSQL (String date) {
         DataInterface add = new DataBase ();
         int idUser = 0;
         int idRide = 0;
         if (member!= null && guest==null)
             idUser = member.getIdUser();
         else if (member==null && guest!=null)
             idUser = guest.getIdUser();
         
         for (int i=0; i<ride.length; ++i)
         {
             if (ride[i].getName().equals(actualRide))
                 idRide = ride[i].getIdRide();
         }
         
         add.createTicket(idRide, idUser, date);
     }
     
     // Création 'un nouveau member customer dans la base de donnéeset récupérationde ce MemberCustomer dans le programme
     public void createMember_inSQL(String fullName, int age, String pseudo_, String password_){
         DataInterface add = new DataBase ();
         member = add.createSQL_Member(fullName, age, "MC", pseudo_, password_);
     }
     
     // Exception Frame Setters
     // On initialise le message de la fenêtre d'exception correspondante
     public void setFieldExceptionLabel(String msg){
         field.setMessage(msg);
     }
     // Setter 
     public void setAgeExceptionLabel(String msg){
         field.setMessage(msg);
     }
    
     //Getters
     public Employee getEmployee () { return employee; }
     public GuestCustomer getGuest () { return guest; }
     public MemberCustomer getMember () { return member; }
     public Ride[] getRide () { return ride; }
     public ArrayList <Date> getAllDates () { return allDates; }
}