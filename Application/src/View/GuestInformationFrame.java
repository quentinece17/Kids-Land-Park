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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javafx.scene.control.RadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
    
    //JButton
    private JButton start = new JButton(" Confirm ");
    private JButton retour ;

    //Gestion du titre de la fenêtre
    String space = "                                         ";
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
    
    // Gestion du type du membre
    private JLabel type = new JLabel ("Customer type : ");
    private ButtonGroup customerType = new ButtonGroup();           // Button group qui laisse libre choix quand a la sélection du typer de 'customer'
    private JRadioButton guestButton = new JRadioButton("Guest");     // Boutton Guest 
    private JRadioButton memberButton = new JRadioButton("Member");   // Boutton Member
    private JLabel sexe = new JLabel ("Genre : ");
    private ButtonGroup sexeUser = new ButtonGroup ();
    private JRadioButton hommeButton = new JRadioButton ("Male");
    private JRadioButton femmeButton = new JRadioButton ("Female");
    
    ImageIcon img;                   // Image qu'on va mettre sur un JLabel
    JLabel imageLabel; 
    
    private String Message = new String(""); // Si il y a une exception --> Message récupère alors le String généré par cette Exception
    
    /**
     * Constructeur 
     * @param app
     */
    public GuestInformationFrame (Application app)
    {
        controller = app;
        
        try{
            img = new ImageIcon(new ImageIcon("icon.jpg").getImage().getScaledInstance(155, 131, Image.SCALE_DEFAULT));    // Chargement de l'image
            imageLabel = new JLabel(img);       // On place cette image dans le Label dédiée à l'image du park
            
        }
        catch (Exception e){ e.printStackTrace(); }
         
        // On set du border de l'image
        javax.swing.border.Border bImage = BorderFactory.createLineBorder(new Color (96, 96, 96), 2 );
        imageLabel.setBounds(455, 150, 155, 131);
        
         // Frame Design
        window.setTitle("Register ");
        window.setSize(750, 490);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        // Design des panels
        p1.setBackground( new Color (102, 102, 102) );
        p1.add(imageLabel);
         
        buildpanel1();    
        
        start.addActionListener(new InteractionButtonListener());
        retour.addActionListener(new InteractionButtonListener());
        
         // Ajouter panel 1 et 2 sur la fenêtre d'accueil
        window.add(p1, BorderLayout.CENTER);
        window.setLocationRelativeTo(null);
          
    }
    
    /**
     * Construit le panel 
     */
    public void buildpanel1 ()
    {
        javax.swing.border.Border bLabel = BorderFactory.createLineBorder(Color.WHITE, 2);
        javax.swing.border.Border bTextFields = BorderFactory.createLineBorder(new Color (96, 96, 96), 2 );
        javax.swing.border.Border bButtons = BorderFactory.createLineBorder(Color.WHITE);
        
        try{
            img = new ImageIcon(new ImageIcon("fleche.png").getImage().getScaledInstance(55, 40, Image.SCALE_DEFAULT));    // Chargement de l'image
            retour = new JButton(img);       // On place cette image dans le Label dédiée à l'image du park
        }catch (Exception e){ e.printStackTrace(); }

        // Customr type : construction du button Group pour le type de customer
        customerType.add(memberButton);
        customerType.add(guestButton);
        
        sexeUser.add(hommeButton);
        sexeUser.add(femmeButton);
        
        p1.setLayout(null);
        label2.setBounds(0, 60, 900, 45);
        start.setBounds(480,320,130,30);
        retour.setBounds(0,0,55,40);    /// On met la meme largeur et hauteur que le redimensionnement du bouton retourn ici
         
        label2.setBorder(bLabel);
        label2.setForeground(Color.WHITE);
        label2.setFont(font2);
        label2.setBackground(Color.BLACK);
        
        firstname.setBounds(150,150,80,40);
        firstname.setForeground(Color.WHITE);
        f_name.setBounds(245,160,110,20);
        f_name.setBorder(bTextFields);
        lastname.setBounds(150,190,80,40);
        lastname.setForeground(Color.WHITE);
        l_name.setBounds(245,200,110,20);
        l_name.setBorder(bTextFields);
        age.setBounds(150, 230, 80, 40);
        agetext.setBounds(245, 240, 110, 20);
        agetext.setBorder(bTextFields);
        age.setForeground(Color.WHITE);
        type.setBounds(150, 280, 140, 40);
        type.setForeground(Color.WHITE);
        memberButton.setBounds(268, 280, 100, 40);
        guestButton.setBounds(268, 320, 100, 40);
        sexe.setBounds(150, 360, 50, 40);
        sexe.setForeground(Color.WHITE);
        hommeButton.setBounds (210, 360, 100, 40);
        femmeButton.setBounds(210, 400, 100, 40);
        
        // Initialiser les couleurs des boutyons pour les laisser se fojndre dans la couleur de fond du panel
        type.setBackground(new Color (195, 195, 195));
        type.setForeground(Color.WHITE);
        guestButton.setBackground(new Color (195, 195, 195));
        guestButton.setForeground(Color.WHITE);
        memberButton.setBackground(new Color (195, 195, 195));
        memberButton.setForeground(Color.WHITE);
        sexe.setBackground(new Color (195, 195, 195));
        sexe.setForeground(Color.WHITE);
        hommeButton.setBackground(new Color (195, 195, 195));
        hommeButton.setForeground(Color.WHITE);
        femmeButton.setBackground(new Color (195, 195, 195));
        femmeButton.setForeground(Color.WHITE);
        
        
        start.setBorder(bButtons);
        start.setBackground(Color.BLACK);
        start.setForeground(Color.WHITE);
        
        p1.add (firstname);
        p1.add (f_name);
        p1.add (lastname);
        p1.add (l_name);
        p1.add (age);
        p1.add(agetext);
        p1.add(label2);
        p1.add(start);
        p1.add(retour);
        p1.add(type);
        p1.add(memberButton);
        p1.add(guestButton);
        p1.add (sexe);
        p1.add (hommeButton);
        p1.add(femmeButton);

    }
    
    /**
     * Classe gérant les événements 
     */
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
                //Si tout ce qui est rentré dans les champs est bon
                else {
                        /// Si c'est le button 'member' qui a été sélectionner
                        if (memberButton.isSelected()){
                           {
                            // Si aucune exception n'est envoyée à l'appelant, on exécute la suite car tous les JTextField sont remplies.
                            //On récupère les informations de l'utilisateur
                            String nameUser = f_name.getText() +" " + l_name.getText();
                            int ageUser = Integer.parseInt(agetext.getText());
                            String image=null;
                            if (hommeButton.isSelected())
                                image = "/Users/quentin/NetBeansProjects/Project-Databases/Application/Images/Personnes/Member_Homme.jpg";
                            else if (femmeButton.isSelected())
                                image = "/Users/quentin/NetBeansProjects/Project-Databases/Application/Images/Personnes/Member_Femme.jpg";
                            if (image != null)
                            {
                                controller.AffichageSignUp(f_name.getText(), l_name.getText(), ageUser, image);
                                window.dispose();
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Please, select all the information");
                            } 
                        }

                        /// Si c'est le button 'guest' qui a été sélectionner
                        else if (guestButton.isSelected()){
                           {
                            // Si aucune exception n'est envoyée à l'appelant, on exécute la suite car tous les JTextField sont remplies.
                            //On récupère les informations de l'utilisateur
                            String nameUser = f_name.getText() +" " + l_name.getText();
                            String typeUser = "GC";
                            String image = null;
                            int ageUser = Integer.parseInt(agetext.getText());
                            if (hommeButton.isSelected())
                                image = "/Users/quentin/NetBeansProjects/Project-Databases/Application/Images/Personnes/Guest_Homme.jpg";
                            else if (femmeButton.isSelected())
                                image = "/Users/quentin/NetBeansProjects/Project-Databases/Application/Images/Personnes/Guest_Femme.jpg";
                            //Création du GuestCustomer dans la base de donnée
                            
                            if (image!=null)
                            {
                                controller.createGuestData (nameUser, ageUser, typeUser, image);

                            //Affichage de la page pour un Customer
                            //controller.AffichageFieldsException();
                            
                            controller.AffichageCustomer();
                            window.dispose();
                            }
                            else 
                                JOptionPane.showMessageDialog(null, "Please, select all the information");
                            } 
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
       
    /**
     * Getters 
     * @return 
     */
    public JFrame getWindow () { return window; }
    public String getMessage () { return Message; }
    
    }
    
    
