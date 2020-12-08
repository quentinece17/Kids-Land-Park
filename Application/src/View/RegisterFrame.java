/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author ccore
 */

import Controller.Application;
import Model.MatchingException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Classe qui crée la fenêtre où l'utilisateur doit se connecter
public class RegisterFrame extends JFrame {
    
    //Instance du controller
    private Application controller;
    
    //JFrame
    private JFrame window = new JFrame ();
    
    //JPanel
    private JPanel p1 = new JPanel();   // Ecran d'accueil
    private JPanel p2 = new JPanel();
    
    //JButton
    private JButton register = new JButton(" Register ");
    private JButton retour ;

    //Gestion du titre de la fenêtre
    String space = "               ";
    private JLabel label = new JLabel(space +"Please enter your personnal information : " );
    Font font= new Font("Arial",Font.BOLD,20);
    
    //Gestion du login
    private JLabel login = new JLabel("Login : ");
    private JPasswordField log = new JPasswordField();
    
    //Gestion du pseudo
    private JLabel pseudo = new JLabel("Pseudo : ");
    private JTextField pseu = new JTextField(10);
    

    //Information de l'utilisateur qu'on a besoin de récupérer dans Application
    private String typeUser;
    private String nameUser;
    private int idUser;
    private int ageUser;
     
    ImageIcon img;                   // Image qu'on va mettre sur un JLabel
    JLabel imageLabel; 

    public RegisterFrame(Application app) {
        
        controller = app;
        
        try{
            // Importation et Redimensionnement de la taille de l'image du parc d'attraction
            img = new ImageIcon(new ImageIcon("icon.jpg").getImage().getScaledInstance(155, 131, Image.SCALE_DEFAULT));    
            imageLabel = new JLabel(img);       // On place cette image dans le Label dédiée à l'image du park
        }
        catch (Exception e){ e.printStackTrace(); }
         
         // Frame Design
        window.setTitle("Register ");
        window.setSize(550, 435);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        imageLabel.setBounds(340, 170, 157, 133);

        
        javax.swing.border.Border bImage = BorderFactory.createLineBorder(new Color (96, 96, 96), 3 );
//        imageLabel.setBorder(bImage);
           
        // Design des panels
        //p1.setSize(new Dimension(900, 350));
        //p2.setSize(new Dimension(900, 400));
        p1.setBackground(new Color (102, 102, 102));
        //p2.setBackground(Color.BLACK);  
         
        buildpanel1();    
        //p2.add(imageLabel);
        
        register.addActionListener(new InteractionButtonListener());
        retour.addActionListener(new InteractionButtonListener());
         // Ajouter panel 1 et 2 sur la fenêtre d'accueil
        window.add(p1, BorderLayout.CENTER);
        //window.add(p2, BorderLayout.SOUTH);        
        
    }
    
    public void buildpanel1()
    {
        
        // Border pour le JLabel 'label'(Color.RED) et Border pour les boutons (Color.BLACK) de l'écrand d'accueil
        javax.swing.border.Border bLabel = BorderFactory.createLineBorder(new Color (255, 255, 255), 2);
        javax.swing.border.Border bButtons = BorderFactory.createLineBorder(Color.WHITE);
        javax.swing.border.Border bTextFields = BorderFactory.createLineBorder(new Color (204, 204, 204), 2 );
        
        try{
            img = new ImageIcon(new ImageIcon("fleche.png").getImage().getScaledInstance(55, 40, Image.SCALE_DEFAULT));    // Chargement de l'image
            retour = new JButton(img);       // On place cette image dans le Label dédiée à l'image du park
        }catch (Exception e){ e.printStackTrace(); }

        // On met le Layout du panel 1 à null pour pouvoir placer les boutons comme bon nous semble
        p1.setLayout(null);
        label.setBounds(0, 45, 925, 45);
        pseudo.setBounds(50,160,60,40);
        pseu.setBounds(125,170,140,20);
        login.setBounds(50,240,80,40);
        log.setBounds(125,250,140,20);
        register.setBounds(125,310,85,25);
        retour.setBounds(0,0,55,40);    /// On met la meme largeur et hauteur que le redimensionnement du bouton retourn ici
        
        // Design des label et bouttons et JTextFields
        label.setBorder(bLabel);
        label.setForeground(Color.WHITE);
        label.setFont(font);
        //label.setBackground(Color.BLACK);
        register.setBorder(bButtons);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        pseudo.setForeground(Color.WHITE);
        pseu.setBorder(bTextFields);
        log.setBorder(bTextFields);
        login.setForeground(Color.WHITE);
        retour.setForeground(Color.WHITE);
        

        
        //ajouter les éléments au panel
        p1.add(pseudo);
        p1.add(pseu);
        p1.add(login);
        p1.add(log);
        p1.add(label);
        p1.add(register);
        p1.add(retour);
        p1.add(imageLabel);

    }
    
    // Vérifie si le pseudo comporte bien un '@' et un '.' pour une addresse e-mail
    public boolean checkPseudo (String str) {
        // Non valide
        if ( (str.indexOf('@') == -1) || (str.indexOf('.') == -1) )
            return false;
        // Valide
        else
            return true;
    }
    
    private class InteractionButtonListener implements ActionListener
    {
      /**
         The actionPerformed method executes when the user
         clicks on the Calculate button.
         @param e The event object.
      */

      @Override
      public void actionPerformed(ActionEvent e)
      {
            if (e.getSource() == register)
            {
                
                boolean exist = controller.personData(pseu.getText(), log.getText());
                /// SI IL YA DES WARNINGS ///////////////////////////
                // Si le pseudo est valide
                if ( !checkPseudo(pseu.getText()) )
                {
                    MatchingException ex = new MatchingException("Your pseudo must be an email address !");
                    controller.setMatchingUserExceptionLabel(ex.getMessage()); // Une fenetre de warning pop-up ici 
                    controller.AffichageMatchingUser();
                }
                
                // Si la personne n'existe pas
                else if (!exist)
                {
                    MatchingException ex = new MatchingException("Your pseudo and password don't exist");
                    controller.setMatchingUserExceptionLabel(ex.getMessage()); // Une fenetre de warning pop-up ici 
                    controller.AffichageMatchingUser();
                }
                
                // Sinon, si il n'y a PAS de warning à signaler ///////////////
                else
                {
                       //Si l'utilisateur est un MemberCustomer
                    if (controller.getMember() != null && controller.getEmployee() == null)
                    {
                        controller.AffichageCustomer();
                        window.dispose();

                    }
                    //Si l'utilisateur est un Employee
                    else if (controller.getMember() == null && controller.getEmployee() != null)
                    {
                        controller.AffichageEmployee();
                        window.dispose();
                    }
                }
                
                
            }
//              else if (name == null)
//              {
//                //Message d'erreur ou redemander à l'utilisateur d'essayer de se reconnecter
//                  window.dispose ();
//              }
            
            if(e.getSource()== retour)
          {
              controller.AffichageAccueil();
              window.dispose();
          }

              
          }
          
          
      }

   
    public JFrame getWindow () { return window; }
    
    public String getTypeUser () { return typeUser; }
    public String getNameUser () { return nameUser; }
    public int getIdUser () { return idUser; }
}
    
