/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Application;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @authors : quentin, corentin and nicolas
 */

//Class qui crée la fenêtre d'accueil
public class AccueilFrame extends JFrame{
    
    //Intance du controller
    private Application controller;
    
    //Frame 
    private JFrame window = new JFrame ();
    
    //JPanel
    private JPanel p1 = new JPanel();   // Ecran d'accueil
    private JPanel p2 = new JPanel();   // Image d'accueil
    private JPanel p3 = new JPanel();    // Panel qui rassemble p1 et p2
    
    //JButton
    private JButton account = new JButton("Log in");
    private JButton noAccount = new JButton("Sign up");
    
    String space = "                   ";
    
    //JLabel
    private JLabel label = new JLabel(space + "Welcome to Kids Land Park" + space);
    private JLabel login = new JLabel("login : ");
    
    //JTextFiel
    private JTextField log = new JTextField(10);
    
    Font font= new Font("Arial",Font.BOLD,20);      // Font for the Label "Welcome..."
   
    ImageIcon img;                   // Image qu'on va mettre sur un JLabel
    JLabel imageLabel;               // JLabel qui va recevoir l'image
    
    
    public AccueilFrame(Application app){
        
        controller = app;
        
        try{
            img = new ImageIcon(new ImageIcon("icon.jpg").getImage().getScaledInstance(155, 131, Image.SCALE_DEFAULT));    // Chargement de l'image
            imageLabel = new JLabel(img);       // On place cette image dans le Label dédiée à l'image du park
        }
        catch (Exception e){ e.printStackTrace(); }
        
        // Frame Design
        window.setTitle("Kids Land Park");
        window.setSize(500, 350);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        // Border pour le JLabel 'label'(Color.RED) et Border pour les boutons (Color.BLACK) de l'écrand d'accueil ET Aussi pour l'image
        javax.swing.border.Border bLabel = BorderFactory.createLineBorder(Color.WHITE);
        javax.swing.border.Border bImage = BorderFactory.createLineBorder(new Color (96, 96, 96), 3 );
        javax.swing.border.Border bButtons = BorderFactory.createLineBorder(Color.RED);
        
        // Design des panels
        //p1.setSize(new Dimension(900, 350));
        //p2.setSize(new Dimension(900, 400));
        p1.setBackground(new Color (195, 195, 195)); //new Color(253, 233, 224)
        //p2.setBackground(new Color (195, 195, 195)); //new Color(253, 233, 224)
        
        // On met le Layout du panel 1 à null pour pouvoir placer les boutons comme bon nous semble
        p1.setLayout(null);
        label.setBounds(0, 20, 920, 45);            // Placer le JLabel "Welcome to Kids Land Park"
        account.setBounds(150, 85, 85, 25);         // Placer le bouton "Log in"
        noAccount.setBounds(250, 85, 85, 25);       // Placer le bouton "Sign up"
        imageLabel.setBounds(170, 140, 157, 133);
        
        // Design des label et bouttons 
        imageLabel.setBorder(bImage);
        label.setBorder(bLabel);
        label.setForeground( Color.BLACK );
        label.setFont(font);    // Police et taille du string dans le label
        label.setBackground( new Color (206, 206, 206) ); //new Color(253, 233, 224)
        account.setBorder(bLabel);
        account.setBackground(Color.BLACK); //new Color(254, 150, 160)
        account.setForeground(Color.WHITE);
        noAccount.setBorder(bLabel);
        noAccount.setBackground(Color.BLACK); //new Color(254, 150, 160)
        noAccount.setForeground(Color.WHITE);
        
        
        account.addActionListener(new InteractionButtonListener());
        noAccount.addActionListener(new InteractionButtonListener());
        // Ajouter 'label' et les bouttons sur le panel 1 et l'image sur le panel 2 sur la fenêtre d'accueil
        p1.add(label);
        p1.add(account);
        p1.add(noAccount);
        p1.add(imageLabel);//p2.add(imageLabel);
        
         // Ajouter panel 1 et 2 sur la fenêtre d'accueil
        window.add(p1, BorderLayout.CENTER);
        //window.add(p2, BorderLayout.SOUTH);        
        
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
         
         if(e.getSource()== account)
         {
             controller.AffichageRegister();
             window.dispose();
             
         } 
         else if(e.getSource()== noAccount)
         {
             controller.AffichageGuestInfo();
             window.dispose();             
         }

         // Display the result.
         //JOptionPane.showMessageDialog(null,  "you will pay "+ " $ for the call ");
      }

    }
    
    public JFrame getWindow () { return window; }

}
