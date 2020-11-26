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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

    //Gestion du titre de la fenêtre
    String space = "                                                      ";
    private JLabel label = new JLabel(space + " Please enter your informations : " + space);
    Font font= new Font("Arial",Font.BOLD,20);
    
    //Gestion du login
    private JLabel login = new JLabel("Login : ");
    private JTextField log = new JTextField(10);
    
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
            img = new ImageIcon("park.jpg");    // Chargement de l'image
            imageLabel = new JLabel(img);       // On place cette image dans le Label dédiée à l'image du park
        }
        catch (Exception e){ e.printStackTrace(); }
         
         // Frame Design
        window.setTitle("Register ");
        window.setSize(900, 750);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        register.addActionListener(new InteractionButtonListener());
        
           
        // Design des panels
        p1.setSize(new Dimension(900, 350));
        p2.setSize(new Dimension(900, 400));
        p1.setBackground(new Color(253, 233, 224));
        p2.setBackground(new Color(253, 233, 224));  
         
        buildpanel1();    
        p2.add(imageLabel);
        
         // Ajouter panel 1 et 2 sur la fenêtre d'accueil
        window.add(p1, BorderLayout.CENTER);
        window.add(p2, BorderLayout.SOUTH);        
        
    }
    
    public void buildpanel1()
    {
        
        // Border pour le JLabel 'label'(Color.RED) et Border pour les boutons (Color.BLACK) de l'écrand d'accueil
        javax.swing.border.Border bLabel = BorderFactory.createLineBorder(Color.RED);
        javax.swing.border.Border bButtons = BorderFactory.createLineBorder(Color.BLACK);
        
        // On met le Layout du panel 1 à null pour pouvoir placer les boutons comme bon nous semble
        p1.setLayout(null);
        label.setBounds(0, 20, 900, 45);
        pseudo.setBounds(150,110,60,40);
        pseu.setBounds(220,120,90,20);
        login.setBounds(370,110,80,40);
        log.setBounds(440,120,90,20);
        register.setBounds(600,120,85,25);
        
        // Design des label et bouttons 
        label.setBorder(bLabel);
        label.setForeground(Color.red);
        label.setFont(font);
        label.setBackground(new Color(253, 233, 224));
        register.setBorder(bButtons);
        register.setBackground(new Color(254, 150, 160));
        register.setForeground(Color.WHITE);
        
        //ajouter les éléments au panel
        p1.add(pseudo);
        p1.add(pseu);
        p1.add(login);
        p1.add(log);
        p1.add(label);
        p1.add(register);

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
              controller.personData(pseu.getText(), log.getText());
              controller.AffichageCustomer(); 
              window.dispose();
                
              }
//              else if (name == null)
//              {
//                //Message d'erreur ou redemander à l'utilisateur d'essayer de se reconnecter
//                  window.dispose ();
//              }
              
          }
          
          
      }

   
    public JFrame getWindow () { return window; }
    
    public String getTypeUser () { return typeUser; }
    public String getNameUser () { return nameUser; }
    public int getIdUser () { return idUser; }
}
    
