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
import View.EmployeeFrame;
import View.GuestProfil;
import View.InfosAttraction;
import View.JFreeChartRideFrame;
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
import java.util.HashSet;
import java.util.Set;
import javafx.scene.layout.Border;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

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
    private GuestProfil profilGuest;
    private OrderHistory orderhistory;
    private MatchingGuestExceptionFrame matchingGuestFields;
    private MatchingUserExceptionFrame matchingUserSQL;
    private EmployeeFrame employ;
    JFreeChartRideFrame rideChart;
    
    //Liste d'attractions
    private ArrayList <Ride> rides = null;
    private Ride ActualRide;
        
    //Utilisateur
    private Employee employee = null;
    private GuestCustomer guest = null;
    private MemberCustomer member = null;
    
    /**
     * Constructeur
     * @throws java.text.ParseException
     */
    public Application() throws ParseException{  

        InitialisationRide ();
        Initialisation ();
    }

    /**
     * Initialisation de chaque Frame
     * @throws java.text.ParseException
     */
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
        profilGuest = new GuestProfil (this);
        orderhistory = new OrderHistory (this);
        matchingGuestFields = new MatchingGuestExceptionFrame(this);
        matchingUserSQL = new MatchingUserExceptionFrame(this);
        employ = new EmployeeFrame(this);
        rideChart = new JFreeChartRideFrame(this);
    }
    
    /**
     * Sauvegarde du Ride actuelle 
     */
    public void saveActualRide (String name) {
        
        DataInterface save = new DataBase();
        ActualRide = save.findRide(name);
    }

    /**
     * Méthodes d'affichage de chaque Frame 
     */
    public void AffichageAccueil () { accueil.getWindow().setVisible(true);}
    public void AffichageRegister (){ 
        register.setPseudo(null);
        register.setLogin (null);
        register.getWindow().setVisible(true);
   
    }
    public void AffichageMatchingGuest () { matchingGuestFields.getWindow().setVisible(true); }
    public void AffichageMatchingUser () { matchingUserSQL.getWindow().setVisible(true); }
    public void AffichageProfilMember () {
        if (member!=null && guest==null)
        {
            profilMember.getWindow().setVisible(true);
            profilMember.setName(member.getNameUser());
            profilMember.setAge (String.valueOf(member.getAgeUser()));
            profilMember.setPseudo(member.getPseudoUser());
            profilMember.setLogin(member.getLoginUser());
            profilMember.setType(member.getMemberType()); 
            String img = member.getImage();
            ImageIcon image = new ImageIcon (new ImageIcon (img).getImage().getScaledInstance(profilMember.getImageLabel().getWidth(), profilMember.getImageLabel().getHeight(), Image.SCALE_SMOOTH));
            profilMember.getImageLabel().setIcon(image);
        }
        else if (guest!=null && member==null)
        {
            profilGuest.getWindow().setVisible(true);
            profilGuest.setName(guest.getNameUser());
            profilGuest.setAge(String.valueOf(guest.getAgeUser()));
            String img =guest.getImage();
            ImageIcon image = new ImageIcon (new ImageIcon (img).getImage().getScaledInstance(profilGuest.getImageLabel().getWidth(), profilGuest.getImageLabel().getHeight(), Image.SCALE_SMOOTH));
            profilGuest.getImageLabel().setIcon(image);
        }
 
    }
    public void AffichageSignUp (String prenom, String nom, int age, String image){
        newPerson.setDataSignUp(prenom, nom, age, image);
        newPerson.getWindow().setVisible(true);
    }
    public void AffichageGuestInfo () { guestInfo.getWindow().setVisible(true);}
    public void AffichageFieldsException () { field.getWindow().setVisible(true);}
    public void AffichageAgeException () { field.getWindow().setVisible(true);}
    public void AffichageChartAttraction () { rideChart.getChart().setVisible(true); }
    public void AffichageNumberOfTickets (String date) {
        numTickets.getWindow().setVisible(true);        
        numTickets.setDateChoosen(date);
    }
    
    public void AffichageEmployee()
    {
        employ.getWindow().setVisible(true);
        int nbPersons = employ.getTableModel1().getRowCount();
        int nbRides = employ.getTableModel2().getRowCount();
        int nbOrders = employ.getTableModel3().getRowCount();
        // Reinitialisation des lignes des JTable au cas où c'était rempli
        // -> JTable Customers
        if (nbPersons != 0)     employ.getTableModel1().setRowCount(0);
        // -> JTable Rides
        if (nbRides != 0)       employ.getTableModel2().setRowCount(0);
        // -> JTable Order
        if (nbOrders != 0)      employ.getTableModel3().setRowCount(0);
        
        ArrayList <GuestCustomer> allGuests;
        ArrayList <MemberCustomer> allMembers;
        ArrayList <Ride> allRides;
        ArrayList <Order> allOrders;
        // Instanciation des listes
        allGuests = AllGuestsRegistered();   /// On récupère une liste contenant tous les GUESTS enregistré jusqu'à présent dans la DB
        allMembers = AllMembersRegistered();    ///Idem que l'instruction de dessus mais avec les MEMBERS
        allRides = rides;
        allOrders = allOrderSaved();
      
        /// Dans cette partie du code on récupère le nom et les tickets restants de chaque attraction dans la base de données
        // --> pour pouvoir ensuite les représenter dans un fromage
        DataInterface verif = new DataBase ();
        ArrayList<String> ticketsAvailable = verif.getAvailableTickets();   // Récupération des tickets restants de chaque attraction dans la base de données
        ArrayList<String> nomRides = verif.getRideNames();   // Récupération des nom d'attraction dans la base de données
        int [] tousLesTickets = verif.getTotalTicketsOfEachRide();
        
        if (tousLesTickets.length != 0 )
            employ.setTotalTickets(tousLesTickets);
        
        
        
//        System.out.println (allRides.get(7).getName() + " - " + allRides.get(7).getImage());
        employ.centerTable(employ.getTable1()); // JTable des CUSTOMERS
        employ.centerTable(employ.getTable2()); // JTable des ATTRACTION
        employ.centerTable(employ.getTable3());
        
        // On rempli la JTable 'CUSTOMERS' récupéré ci-dessus
        if ( allGuests.size() != 0 )
        {
            for ( int i=0; i < allGuests.size(); ++i )
            {
                // Si on doit insérer un membre dans la JTable de la frame 'Employee'
                    //Person temp = allGuests.get(i);  // Pour pouvoir lire ensuite son pseudo et login
                    employ.getTableModel1().addRow(  new Object [] { allGuests.get(i).getIdUser(),
                                                                    allGuests.get(i).getNameUser(),
                                                                    allGuests.get(i).getAgeUser(),
                                                                    'X',    // pseudo temporairement occupé
                                                                    'X',     // login : idem
                                                                    "GC",
                                                                    'X',
                                                                    } );  
            }
        }
        
        if (allMembers.size() != 0)
        {
            for ( int i=0; i < allMembers.size(); ++i )
            {
                // Si on doit insérer un membre dans la JTable de la frame 'Employee'
                    //Person temp = allGuests.get(i);  // Pour pouvoir lire ensuite son pseudo et login
                    employ.getTableModel1().addRow(  new Object [] { allMembers.get(i).getIdUser(),
                                                                    allMembers.get(i).getNameUser(),
                                                                    allMembers.get(i).getAgeUser(),
                                                                    allMembers.get(i).getPseudoUser(),    // pseudo temporairement occupé
                                                                    allMembers.get(i).getLoginUser(),     // login : idem
                                                                    "MC",
                                                                    allMembers.get(i).getMemberType(),
                                                                    } );
            }
        }
        
        // On rempli la JTable 'CUSTOMERS' récupéré ci-dessus
        if ( allRides.size() != 0 )
        {
            for ( int i=0; i < allRides.size(); ++i )
            {
                employ.getTableModel2().addRow(  new Object [] {    allRides.get(i).getIdRide(),
                                                                    allRides.get(i).getName(),
                                                                    allRides.get(i).getPrice(),
                                                                    allRides.get(i).getFeatures(),
                                                                    allRides.get(i).getNbTicketsAvailable() } );
                
            }
        }
        
        if (allOrders.size() != 0)
        {
            for (int i=0; i< allOrders.size(); ++i)
            {
                employ.getTableModel3().addRow(new Object [] {  allOrders.get(i).getId(),
                                                                allOrders.get(i).getCustomer(),
                                                                allOrders.get(i).getRideName(),
                                                                allOrders.get(i).getTicketsAdult(),
                                                                allOrders.get(i).getTicketsChild(),
                                                                allOrders.get(i).getPrice(),
                                                                allOrders.get(i).getDate(),
                                                                allOrders.get(i).getPurchaseDate()});
            }
        }
        
        
    }
    
    public void AffichageOrderHistory () {
        orderhistory.getWindow().setVisible(true);
        int numberOfOrder = orderhistory.getTableModel().getRowCount();
        if (numberOfOrder!=0)
        {
            orderhistory.getTableModel().setRowCount(0);
        }
        ArrayList <Order> allOrders;
        allOrders = AllCommandOfTheUser();
        for (int i=0; i<allOrders.size(); ++i)
        {
            System.out.println (allOrders.get(i).getPurchaseDate() + " - " + allOrders.get(i).getDate());
        }
        orderhistory.centerTable(orderhistory.getTable());
        if (allOrders.size()!=0)
        {
            for (int i=0; i<allOrders.size(); ++i)
            {
                String datePurchase = allOrders.get(i).getPurchaseDate();
                String nameRide = allOrders.get(i).getRideName();
                int adultTicket = allOrders.get(i).getTicketsAdult();
                int childTicket = allOrders.get(i).getTicketsChild();
                double price = allOrders.get(i).getPrice();
                String dateValid = allOrders.get(i).getDate();
                orderhistory.getTableModel().addRow(new Object[] {datePurchase, nameRide, adultTicket, childTicket, price, dateValid});
            }
        } 
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
        chooseride.getComboBox().removeAllItems();
        chooseride.setDateChoosen(dateChoosen);
        chooseride.setDateChoosenLabel("Available Rides for : " + dateChoosen);
        chooseride.setInfoAttrac1(rides.get(0).getName());
        chooseride.setInfoAttrac2(rides.get(1).getName());
        chooseride.setInfoAttrac3(rides.get(2).getName());
        chooseride.setInfoAttrac4(rides.get(3).getName());
        chooseride.setInfoAttrac5(rides.get(4).getName());
        chooseride.setInfoAttrac6(rides.get(5).getName());
        
        for (int i=0; i<rides.size(); ++i)
        {
            chooseride.getComboBox().addItem(rides.get(i).getName());
        }
            
    }
    
    public void AffichageConfirmOrder (String date) {
        
        confirmation.getWindow().setVisible (true);
       
        //On envoit la date choisi à la frame ConfirmOrder
        confirmation.setDateChoosen(date);
        //On reset le JTable
        int numberOfOrder = confirmation.getTableModel().getRowCount();
        int numberOfOrder2 = confirmation.getTableModel2().getRowCount();
        if (numberOfOrder!=0)
        {
            confirmation.getTableModel().setRowCount(0);
        }
        if (numberOfOrder2!=0)
        {
            confirmation.getTableModel2().setRowCount(0);
        }
        confirmation.centerTable(confirmation.getTable());
        confirmation.centerTable(confirmation.getTable2());
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
            if (guest.getOrder().size()!=0)
            {
                double pTot = 0;
                for (int i=0; i<guest.getOrder().size(); ++i)
                {
                    if (guest.getOrder().get(i).getOrderValid() == false)
                    {
                      
                        String dateChoosen = guest.getOrder().get(i).getDate();
                        String nameRide = guest.getOrder().get(i).getRideName();
                        int adultTicket = guest.getOrder().get(i).getTicketsAdult();
                        int childTicket = guest.getOrder().get(i).getTicketsChild();
                        double price1 = guest.getOrder().get(i).getPrice();
                        pTot += price1;

                        confirmation.getTableModel().addRow(new Object[]{dateChoosen, nameRide, adultTicket, childTicket, price1});
                    }
                }
                String discountOrder = "No Discount";
                confirmation.getTableModel2().addRow(new Object[]{discountOrder, pTot});
            }
            
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
        for (int i=0; i<rides.size(); ++i)
        {
            if (rides.get(i).getName().equals(attraction))
            {
                
                infoAttrac.setName(rides.get(i).getName());
                infoAttrac.setPrice("$"+String.valueOf(rides.get(i).getPrice()));
                infoAttrac.setChildPrice("$"+String.valueOf(rides.get(i).getPrice()-2));
                infoAttrac.setFeatures(rides.get(i).getFeatures());
                
                DataInterface verif = new DataBase ();
                nbExist = verif.verifNumberOfTickets(dateChoosen, rides.get(i).getIdRide());
                
                infoAttrac.setTicketsAvailable(String.valueOf(rides.get(i).getNbTicketsAvailable()-nbExist));
                
                if (nbExist == rides.get(i).getNbTicketsAvailable())
                {
                    infoAttrac.getBouton().setEnabled(false);
                }
                
                //Affichage de l'image
                String img = rides.get(i).getImage();
                ImageIcon image = new ImageIcon (new ImageIcon (img).getImage().getScaledInstance(infoAttrac.getImageLabel().getWidth(), infoAttrac.getImageLabel().getHeight(), Image.SCALE_SMOOTH));
                infoAttrac.getImageLabel().setIcon(image);
                
            }
            
        }
        
    }

    /**
     * Initialisation de la liste de Rides 
     */
    public void InitialisationRide () 
    {
        DataInterface create = new DataBase ();
        rides = create.findRides();
        
    }
    
    /**
     * Ajout d'une ride dans la base de donnée
     * @param name
     * @param price
     * @param features
     * @param capacity
     * @param image
     */
    public void addRide_inSQL (String name, double price, String features, int capacity, String image) {
        DataInterface add = new DataBase();
        add.addRideFromEmployee(name, price, features, capacity, image);
    }
    /**
     * Modification d'une Ride en SQL
     * @param id
     * @param name
     * @param price
     * @param features
     * @param capacity
     * @param image
     */
    public void updateRide_inSQL (int id, String name, double price, String features, int capacity, String image) {
        
        DataInterface update = new DataBase ();
        update.updateRide(id, name, price, features, capacity, image);
    }
    
    /**
     * Modification d'un User en SQL
     * @param image
     */
    public void updateUser_inSQL (String image) {
        DataInterface update = new DataBase ();
        update.updateCustomer(member.getIdUser(), image);
        member.setImage(image);
    }
    
    /**
     * Suppression d'une Ride en SQL
     * @param id
     */
    public void deleteRide_inSQL (int id) {
        DataInterface delete = new DataBase();
        delete.deleteRide(id);
    }
    
    /**
     * Méthodes d'affichage de chaque Frame
     * @param id
     */
    public void deleteCustomer_inSQL (int id) {
        DataInterface delete = new DataBase();
        delete.deleteCustomer(id);
    }
    
    /**
     * Suppression d'un Order en SQL 
     * @param id
     */
    public void deleteOrder_inSQL (int id) {
        DataInterface delete = new DataBase();
        delete.deleteOrder(id);
        
    }

    /**
     * @param pseu
     * @param log
     * @return si la personne existe dans la base de Donnée
     */
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
    
    /** 
     * @return la liste de commande de l'utilisateur
     */
    public ArrayList<Order> AllCommandOfTheUser () {
        ArrayList <Order> commandsUser = null;
        DataInterface recup = new DataBase();
        
        if (member!=null && guest==null)
            commandsUser = recup.findOrder(member.getIdUser());
        else if (member==null && guest!=null)
            commandsUser = recup.findOrder(guest.getIdUser());
        
        return commandsUser;
    }
    
    /**
     * @return la liste de tous les membres de la base de donnée
     */
    public ArrayList<MemberCustomer> AllMembersRegistered () {
        
        ArrayList <MemberCustomer> members = null;
        DataInterface recup = new DataBase();
        
        // Si l'employee est bien instancié dans la classe Application --> on récupère tous les Membre de la DB
        if (employee != null)
            members = recup.findMembers_inSQL(); 
        
        else
            JOptionPane.showMessageDialog(null, "employee attribute not instanciated --> 'employee = null' ");

        return members;   
    }
    
    /** 
     * @return la liste de tous les orders de la base de donnée
     */
    public ArrayList<Order> allOrderSaved () {
        
        ArrayList <Order> orders = null;
        DataInterface recup = new DataBase();
        
        if (employee != null)
            orders = recup.findAllOrders_inSQL();
        
        else
            JOptionPane.showMessageDialog(null, "employee attribute not instanciated --> 'employee = null' ");
        
        return orders;
    }
    
    /** 
     * @return la liste de tous les Guest de la base de donnée
     */
    public ArrayList<GuestCustomer> AllGuestsRegistered () {
        
        ArrayList <GuestCustomer> guests = null;
        DataInterface recup = new DataBase();
        
        // Si l'employee est bien instancié dans la classe Application --> on récupère tous les Membre de la DB
        if (employee != null)
            guests = recup.findGuests_inSQL(); 
        
        else
            JOptionPane.showMessageDialog(null, "employee attribute not instanciated --> 'employee = null' ");

        return guests;   
    }
    
    /**
     * Création d'un Guest dans la base de donnée
     * @param name
     * @param age
     * @param user_type
     * @param image
     */
     public void createGuestData (String name, int age, String user_type, String image)
     {
         DataInterface add = new DataBase ();
         guest = add.createGuest(name, age, user_type,image);
     } 

     /**
     * Création d'une commande pour l'utilisateur 
     * @param date
     * @param nbAd
     * @param nbChild
     */
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
     
     /**
     * Suppression des commandes en cours de l'utilisateur 
     */
     public void deleteAllOrder () {
         
         if (member!= null && guest==null)
         {
             member.getOrder().clear();
         }
         else if (guest != null && member == null)
         {
             guest.getOrder().clear();
         }
     }
     
     /**
     * Création d'un ticket en SQL
     * @param dateOfPurchase
     */
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
                     for (int j=0; j<rides.size(); ++j)
                    {
                        if (rides.get(j).getName().equals(member.getOrder().get(i).getRideName()))
                            idRide = rides.get(j).getIdRide();
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
                     for (int j=0; j<rides.size(); ++j)
                    {
                        if (rides.get(j).getName().equals(guest.getOrder().get(i).getRideName()))
                            idRide = rides.get(j).getIdRide();
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
     
     /**
     * Création 'un nouveau member customer dans la base de donnéeset récupérationde ce MemberCustomer dans le programme
     * @param fullName
     * @param age
     * @param pseudo_
     * @param password_
     * @param image
     */
     public void createMember_inSQL(String fullName, int age, String pseudo_, String password_, String image){
         DataInterface add = new DataBase ();
         member = add.createSQL_Member(fullName, age, "MC", pseudo_, password_, image);
     }
     
     /**
     * Construction d'un diagramme de Ride 
     * @param name_
     * @param tickets_
     */
     public void buildRideChart(ArrayList<String> name_, int [] tickets_)
     {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < tickets_.length; ++i)
            dataset.setValue((Comparable) rides.get(i).getName(), tickets_[i] ); // Je ne sais pas pourquoi le compilateur veut un '(Comparable)'

            // create a chart...
            JFreeChart chart = ChartFactory.createPieChart3D(
                                                           "Popularity of Rides",
                                                            dataset,
                                                            true, // legend?
                                                            true, // tooltips?
                                                            false // URLs?
                                                        );

         // create and display a frame...
         ChartFrame frame = new ChartFrame("Popular Rides", chart);
         rideChart.setChart(frame);     // La chart est alors initialisé
         rideChart.packing();           // Une fonctiojn qui appelle juste pack() pour la JFreeChart de l'employée
         
     }
     
     /**
     * Initialisation des messages d'excpetion 
     * @param msg
     */
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
     
     /**
     *  Sauvegarde des paramètres
     * @param firstName
     * @param lastName
     * @param age_
     * @param image
     */
     public void setSavedData(String firstName, String lastName, int age_, String image){
         matchingGuestFields.setSave1Name(firstName);
         matchingGuestFields.setSaveLName(lastName);
         matchingGuestFields.setSaveAge(age_);
         matchingGuestFields.setSaveImage(image);
     }
          
     /**
     * @return les attributs 
     */
     public Employee getEmployee () { return employee; }
     public GuestCustomer getGuest () { return guest; }
     public MemberCustomer getMember () { return member; }
     public ArrayList <Ride> getRideForEmployee () { return rides; }
}