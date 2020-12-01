/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Application;
import Model.AgeException;
import Model.FieldException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author quentin
 */
public class GuestInformationFrame extends JFrame{
    
    //Instance du controller
    private Application controller;
    
    //JFrame
    private JFrame window = new JFrame ();
    
    //JPanel
    private JPanel p1 = new JPanel();   // Ecran d'accueil
    private JPanel p2 = new JPanel();
    
    // JButtonGroup --> Le nouveau venu est soit un Member customer soit un Guest customer
    
    
    //JButton
    private JButton start = new JButton(" Confirm ");
    private JButton retour ;

    //Gestion du titre de la fenêtre
    String space = "                                                      ";
    private JLabel label2 = new JLabel(space + " Welcome New customer !" + space);
    Font font2 = new Font("Arial",Font.BOLD,20); 
    
    //Gestion du Nom de Famille
    private JLabel lastname = new JLabel ("Last name : ");
    private JTextField l_name = new JTextField (10);
    
    //Gestion du Prénom
    private JLabel firstname = new JLabel ("First name : ");
    private JTextField f_name = new JTextField (10);
    
    //Gestion de l'âge
    private JLabel age = new JLabel ("Age : ");
    private JTextField agetext = new JTextField (10);
    
    ImageIcon img;                   // Image qu'on va mettre sur un JLabel
    JLabel imageLabel; 
    
    private String Message = new String(""); // Si il y a une exception --> Message récupère alors le String généré par cette Exception
    
    public GuestInformationFrame (Application app)
    {
        controller = app;
        
        try{
            img = new ImageIcon("park.jpg");    // Chargement de l'image
            imageLabel = new JLabel(img);       // On place cette image dans le Label dédiée à l'image du park
        }
        catch (Exception e){ e.printStackTrace(); }
         
         // Frame Design
        window.setTitle("Register ");
        window.setSize(900, 820);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        // block try-catch pour voir si tous les champs demandés pour le 'GuestCustomer' sont bien rentrés.
        //try{
           start.addActionListener(new InteractionButtonListener()); 
        //}
        //catch( FieldException eField) {
            //Message = eField.getMessage(); // Message récupère le String généré dans le constructeur de FieldException
            //controller.setie;ldExceptionLabel(Message);
            //controller.AffichageFielFdsException()
        //}
        
        // Design des panels
        p1.setSize(new Dimension(900, 350));
        p2.setSize(new Dimension(900, 400));
        p1.setBackground(new Color(253, 233, 224));
        p2.setBackground(new Color(253, 233, 224));  
         
        buildpanel1();    
        p2.add(imageLabel);
        
        start.addActionListener(new InteractionButtonListener());
        retour.addActionListener(new InteractionButtonListener());
        
         // Ajouter panel 1 et 2 sur la fenêtre d'accueil
        window.add(p1, BorderLayout.CENTER);
        window.add(p2, BorderLayout.SOUTH);    
          
    }
    
    public void buildpanel1 ()
    {
        javax.swing.border.Border bLabel = BorderFactory.createLineBorder(Color.RED);
        javax.swing.border.Border bButtons = BorderFactory.createLineBorder(Color.BLACK);
        
        try{
            img = new ImageIcon("retour2.jpg");    // Chargement de l'image
            retour = new JButton(img);       // On place cette image dans le Label dédiée à l'image du park
        }catch (Exception e){ e.printStackTrace(); }

        p1.setLayout(null);
        label2.setBounds(0, 20, 900, 45);
        start.setBounds(430,120,130,30);
        retour.setBounds(0,0,22,15);
         
        label2.setBorder(bLabel);
        label2.setForeground(Color.red);
        label2.setFont(font2);
        label2.setBackground(new Color(253, 233, 224));
        
        firstname.setBounds(150,110,80,40);
        f_name.setBounds(240,120,110,20);
        lastname.setBounds(150,150,80,40);
        l_name.setBounds(240,160,110,20);
        age.setBounds(150, 190, 80, 40);
        agetext.setBounds(240, 200, 110, 20);
        
        start.setBorder(bButtons);
        start.setBackground(new Color(254, 150, 160));
        start.setForeground(Color.WHITE);
        
        retour.setBorder(bButtons);
        //retour.setBackground(new Color(254, 150, 160));
        retour.setForeground(Color.WHITE);

        
        p1.add (firstname);
        p1.add (f_name);
        p1.add (lastname);
        p1.add (l_name);
        p1.add (age);
        p1.add(agetext);
        p1.add(label2);
        p1.add(start);
        p1.add(retour);

    }
    
    private class InteractionButtonListener implements ActionListener
    {

        @Override
        // Comme on ne peut pas envoyer d'exception créer par nous même héritant de Exception,
        //nous avons regardé dans l'interface ActionListener les Exceptions qui pouvaient être envoyé par sa méthode 'actionPerformed'
        // --> il se trouve que actionPerformed montre dans sa signature dans l'interface qu'il peut envoyé des 'RuntimeException' 
        // Donc notre FieldException hérite de RuntimeException et non de Exception
        
        public void actionPerformed(ActionEvent e) throws RuntimeException {
            
            if (e.getSource() == start)
            {
                // Si tout les JTextField sont remplie ont peut rajouter le customer dans la base de données --> Une exception est envoyé à son appelant
                if ( f_name.getText().equals("") || l_name.getText().equals("") || agetext.getText().equals(""))
                {
                    FieldException ex = new FieldException();
                    controller.setFieldExceptionLabel(ex.getMessage());
                    controller.AffichageFieldsException();
                    //window.dispose();
                }
                
                
                // Si l'âge est différent de "" --> vérifier si c'est bien un nombre
                if (!agetext.getText().equals("")){
                    try{
                        Integer test = Integer.parseInt(agetext.getText());
                    }
                    catch (NumberFormatException eAge){
                        AgeException ex = new AgeException("You must enter a number in the age field");
                        controller.setAgeExceptionLabel(ex.getMessage());
                        controller.AffichageAgeException();
                    }
                }
                    
                // Si on entre un âge négatif
                if (Integer.parseInt(agetext.getText()) < 0)
                {
                    AgeException ex = new AgeException("You can't enter a negative age");
                    controller.setAgeExceptionLabel(ex.getMessage());
                    controller.AffichageAgeException();
                }
                
                // Si on entre un âge supérieur à 100
                if (Integer.parseInt(agetext.getText()) > 100)
                {
                    AgeException ex = new AgeException("We're sorry but you are too old");
                    controller.setAgeExceptionLabel(ex.getMessage());
                    controller.AffichageAgeException();
                }
                
                else {
                        {
                        // Si aucune exception n'est envoyée à l'appelant, on exécute la suite car tous les JTextField sont remplies.
                        //On récupère les informations de l'utilisateur
                        String nameUser = f_name.getText() +" " + l_name.getText();
                        String typeUser = "GC";
                        int ageUser = Integer.parseInt(agetext.getText());
                        
                        //Création du GuestCustomer dans la base de donnée
                        //controller.createGuestData (nameUser, ageUser, typeUser);
                        
                        //Affichage de la page pour un Customer
                        //controller.AffichageFieldsException();
                        // JE NE SAIS PLUS CE QUI ETAIT CODER A CE MOMENT LA !!!!!!!!!!!!!! ON AFFICHE QUELLE FENETRE
                        controller.AffichageSignUp();
                        window.dispose();
                        }
                }
                }
            
            if(e.getSource()== retour)
            {
                controller.AffichageAccueil();
                window.dispose();
            }
                
            }
            
        }
       
    // Getters
    public JFrame getWindow () { return window; }
    public String getMessage () { return Message; }
    
    }
    
    
