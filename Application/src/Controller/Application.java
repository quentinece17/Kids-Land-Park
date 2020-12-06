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
import Model.MatchingException;
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
import View.MatchingGuestExceptionFrame;
import View.MatchingUserExceptionFrame;
import View.NumberOfTickets;
import View.OrderHistory;
import View.ProfilMember;
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
    private ProfilMember profilMember;
    private OrderHistory orderhistory;
    private MatchingGuestExceptionFrame matchingGuestFields;
    private MatchingUserExceptionFrame matchingUserSQL;
    
    //Tableau d'attractions
    private Ride [] ride;
    
    private Ride ActualRide;
    
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
        profilMember = new ProfilMember (this);
        orderhistory = new OrderHistory (this);
        matchingGuestFields = new MatchingGuestExceptionFrame(this);
        matchingUserSQL = new MatchingUserExceptionFrame(this);
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
    
    public void saveActualRide (String name) {
        
        DataInterface save = new DataBase();
        ActualRide = save.findRide(name);
    }

    //Méthodes d'affichage des différentes windows
    public void AffichageAccueil () { accueil.getWindow().setVisible(true);}
    public void AffichageRegister (){ register.getWindow().setVisible(true);}
    public void AffichageMatchingGuest () { matchingGuestFields.getWindow().setVisible(true); }
    public void AffichageMatchingUser () { matchingUserSQL.getWindow().setVisible(true); }
    public void AffichageProfilMember () {
        profilMember.getWindow().setVisible(true);
        profilMember.setName(member.getNameUser());
        profilMember.setAge (String.valueOf(member.getAgeUser()));
        profilMember.setPseudo(member.getPseudoUser());
        profilMember.setLogin(member.getLoginUser());
        profilMember.setType(member.getMemberType());
    }
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
    public void AffichageOrderHistory () {
        orderhistory.getWindow().setVisible(true);
        Order [] allOrders;
        if (member!=null && guest==null)
        {
            
        }
    }
    public void AffichageCustomer (){ 
        customer.getWindow().setVisible(true);
        if (member != null && guest == null)
            customer.setText("Hello " + member.getNameUser());
        if (guest != null && member == null)
            customer.setText("Hello " + guest.getNameUser());
        
//        if (member.getOrder().size() != 0)
//        {
//            for (int i=0; i<member.getOrder().size(); ++i)
//            {
//                System.out.println (member.getOrder().get(i).getRideName() + " - " + member.getOrder().get(i).getNumberOfTickets() + " - " + member.getOrder().get(i).getDate());
//            }
//        }
//        else
//            System.out.println ("Pas de commande en cours");
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
    
    public void AffichageConfirmOrder (String date) {
        
        confirmation.getWindow().setVisible (true);
//        if (member.getOrder().size() != 0)
//        {
//            for (int i=0; i<member.getOrder().size(); ++i)
//            {
//                System.out.println (member.getOrder().get(i).getRideName() + " - " + member.getOrder().get(i).getTicketsAdult() + " - " + member.getOrder().get(i).getTicketsAdult() + " - " + member.getOrder().get(i).getDate());
//            }
//        }
//        else
//            System.out.println ("Pas de commande en cours");

        //On envoit la date choisi à la frame ConfirmOrder
        confirmation.setDateChoosen(date);
        //On reset le JTable
        int numberOfOrder = confirmation.getTableModel().getRowCount();
        int numberOfOrder2 = confirmation.getTableModel2().getRowCount();
        if (numberOfOrder!=0)
        {
            for (int i=0; i<numberOfOrder; ++i)
            {
                confirmation.getTableModel().removeRow(i);

            }
        }
        if (numberOfOrder2!=0)
        {
            for (int i=0; i<numberOfOrder; ++i)
            {
                confirmation.getTableModel2().removeRow(i);

            }
        }
        if (member != null && guest == null)
        {
            if (member.getOrder().size()!=0)
            {
                double pTot = 0;
                for (int i=0; i<member.getOrder().size(); ++i)
                {
                    if (member.getOrder().get(i).getOrderValid() == false)
                    {
                        String dateChoosen = member.getOrder().get(i).getDate();
                        String nameRide = member.getOrder().get(i).getRideName();
                        int adultTicket = member.getOrder().get(i).getTicketsAdult();
                        int childTicket = member.getOrder().get(i).getTicketsChild();
                        double price1 = member.getOrder().get(i).getPrice();
                        pTot += price1;

                        confirmation.getTableModel().addRow(new Object[]{dateChoosen, nameRide, adultTicket, childTicket, price1});
                    }
 
                }
                String discountOrder = String.valueOf(member.getDiscount()*100 + "%");
                pTot = pTot*(1-member.getDiscount());
                confirmation.getTableModel2().addRow(new Object[]{discountOrder, pTot});
            }
        }
        
        if (member == null && guest!= null)
        {
            double pTot = 0;
            for (int i=0; i<guest.getOrder().size(); ++i)
            {
                if (guest.getOrder().get(i).getOrderValid() == false)
                {
                    String dateChoosen = guest.getOrder().get(i).getDate();
                    String nameRide = guest.getOrder().get(i).getRideName();
                    int adultTicket = member.getOrder().get(i).getTicketsAdult();
                    int childTicket = member.getOrder().get(i).getTicketsChild();
                    double price1 = guest.getOrder().get(i).getPrice();
                    pTot += price1;
                    
                    confirmation.getTableModel().addRow(new Object[]{dateChoosen, nameRide, adultTicket, childTicket, price1});
                }
            }
            String discountOrder = "No Discount";
            confirmation.getTableModel2().addRow(new Object[]{discountOrder, pTot});
        }
                    
    }
    
    public void AffichageInfosAttraction (String attraction, String dateChoosen) {
        infoAttrac.getWindow().setVisible(true);
        infoAttrac.setChoosenDate(dateChoosen);
        infoAttrac.getBouton().setEnabled(true);
        
        saveActualRide (attraction);
                
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
                infoAttrac.setChildPrice(String.valueOf(ride[i].getPrice()-2));
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
            
        }
        
    }

    public void InitialisationRide () 
    {
        DataInterface create = new DataBase ();
        ride = create.createRide();
        
    }
    // Permet de vérifier si l'utilisateur existe dans la base de données
    public boolean personData (String pseu, String log)
    {
        //Permet de vérifier si la personne qui s'identifie existe
        int valid = 0;
        
        //Connection à la DB
        DataInterface verif = new DataBase ();
        valid = verif.verifUser(pseu, log);
        
        //Si la personne n'existe pas
        if (valid==0)
            return false;
        
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
            return true; // La personne existe
        }
    }
    
    public Order AllCommandOfTheUser () {
        
        return null;
    }
    
     public void createGuestData (String name, int age, String user_type)
     {
         DataInterface add = new DataBase ();
         guest = add.createGuest(name, age, user_type);
         System.out.println ("Hello " + guest.getNameUser() + "\n Age : " + guest.getAgeUser() + " \nId : " + guest.getIdUser() + "\nType : "+ guest.getTypeUser());
     } 

     public void create0rder (String date, int nbAd, int nbChild) {
         
         if (member!=null && guest==null)
         {
             //On ajoute la commande au tableau de commandes de l'utilisateur
             member.getOrder().add(new Order (date, ActualRide.getName(), nbAd, nbChild, ((nbAd*ActualRide.getPrice())+(nbChild*(ActualRide.getPrice()-2))), false));
             //On met à jour le prix total dépensé par l'utilisateur en lui ajoutant le prix de la commande actuelle
             member.setPrice (member.getPrice() + ((nbAd*ActualRide.getPrice())+(nbChild*ActualRide.getPrice()-2)));
         }
         else if (member==null && guest != null)
         {
             guest.getOrder().add(new Order (date, ActualRide.getName(), nbAd, nbChild, ((nbAd*ActualRide.getPrice())+(nbChild*(ActualRide.getPrice()-2))), false));
             guest.setPrice(guest.getPrice() + ((nbAd*ActualRide.getPrice())+(nbChild*ActualRide.getPrice()-2)));
             
         }
     }
     
     public void deleteAllOrder () {
         
         if (member!= null && guest==null)
         {
             for (int i=0; i<member.getOrder().size(); ++i)
             {
//                 if (member.getOrder().get(i).getOrderValid()==false)
//                     member.getOrder().remove(i);
             }
             member.getOrder().clear();
         }
     }
     
     public void createTicket_inSQL (String dateOfPurchase) {
         DataInterface add = new DataBase ();
         if (member!=null && guest == null)
         {
             //On parcourt toutes le commandes de l'utilisateur
             for (int i=0; i<member.getOrder().size(); ++i)
             {
                 //Si la commande n'est pas validé (boolean== false)
                 if (member.getOrder().get(i).getOrderValid() == false)
                 {
                     int idRide = 0;
                     for (int j=0; j<ride.length; ++j)
                    {
                        if (ride[j].getName().equals(member.getOrder().get(i).getRideName()))
                            idRide = ride[j].getIdRide();
                    }
                     int idUser = member.getIdUser();
                     String date = member.getOrder().get(i).getDate();
                     int adultTicket = member.getOrder().get(i).getTicketsAdult();
                     int childTicket = member.getOrder().get(i).getTicketsChild();
                     double price = member.getOrder().get(i).getPrice();
                     //On ajoute cette commande à la DB
                     add.createTicket(idRide, idUser, adultTicket, childTicket, date, dateOfPurchase, price);
   
                     //On valide la commande en passant le boolean à true
                     member.getOrder().get(i).setOrderValid(true);
                 }
             }
         }
         
         if (guest!= null && member==null)
         {
             //On parcourt toutes le commandes de l'utilisateur
             for (int i=0; i<guest.getOrder().size(); ++i)
             {
                 //Si la commande n'est pas validé (boolean== false)
                 if (guest.getOrder().get(i).getOrderValid() == false)
                 {
                     int idRide = 0;
                     for (int j=0; j<ride.length; ++j)
                    {
                        if (ride[j].getName().equals(guest.getOrder().get(i).getRideName()))
                            idRide = ride[j].getIdRide();
                    }
                     int idUser = guest.getIdUser();
                     String date = guest.getOrder().get(i).getDate();
                     int adultTicket = guest.getOrder().get(i).getTicketsAdult();
                     int childTicket = guest.getOrder().get(i).getTicketsChild();
                     double price = guest.getOrder().get(i).getPrice();
                     //On ajoute cette commande à la DB
                     add.createTicket(idRide, idUser, adultTicket, childTicket, date, dateOfPurchase, price);
                     
                     
                     
                     //On valide la commande en passant le boolean à true
                     
                     guest.getOrder().get(i).setOrderValid(true);
                 }
             }
         }
        
     }
     
     // Création 'un nouveau member customer dans la base de donnéeset récupérationde ce MemberCustomer dans le programme
     public void createMember_inSQL(String fullName, int age, String pseudo_, String password_){
         DataInterface add = new DataBase ();
         member = add.createSQL_Member(fullName, age, "MC", pseudo_, password_);
     }
     
     // Exception Frame Setters
     // On initialise le message de la fenêtre d'exception correspondante
     /////////////////////////////////////////////////////////////////////////
     public void setFieldExceptionLabel(String msg){
         field.setMessage(msg);
     }
     
     public void setMatchingGuestExceptionLabel(String msg){
         matchingGuestFields.setMessage(msg);
     }
     public void setMatchingUserExceptionLabel(String msg){
         matchingUserSQL.setMessage(msg);
     }
     
     public void setAgeExceptionLabel(String msg){
         age.setMessage(msg);
     }
    ////////////////////////////////////////////////////////////////////
     
     //Getters
     public Employee getEmployee () { return employee; }
     public GuestCustomer getGuest () { return guest; }
     public MemberCustomer getMember () { return member; }
     public Ride[] getRide () { return ride; }
     public ArrayList <Date> getAllDates () { return allDates; }
}