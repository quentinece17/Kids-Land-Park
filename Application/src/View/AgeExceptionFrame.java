/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Application;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @authors : quentin, corentin & nicolas
 */
public class AgeExceptionFrame extends JFrame {
    
    //Instance du controller
    private Application controller;
    
    //JFrame
    private JFrame window = new JFrame ();
    
    //JPanel
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    
    private JLabel exceptionMessage = new JLabel();
    private Button ok = new Button("OK");
    
    ImageIcon img;                   // Image qu'on va mettre sur un JLabel
    JLabel imageLabel; 
    
    /**
     * Constructeur 
     * @param app
     */
    public AgeExceptionFrame (Application app){
        
        controller = app;
        try{
            img = new ImageIcon("warning.png");    // Chargement de l'image
            imageLabel = new JLabel(img);       // On place cette image dans le Label dédiée à l'image du park
        }
        catch (Exception e){ e.printStackTrace(); }
        
        // Frame Design
        window.setTitle("Warning !");
        window.setSize(470, 330);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setBackground(new Color(123, 123, 123));
        
        ok.addActionListener(new InteractionButtonListener());
        
        window.add(imageLabel, BorderLayout.NORTH);
        window.add(exceptionMessage, BorderLayout.CENTER);
        window.add(ok, BorderLayout.SOUTH);

    }

    /**
     * Private classe gérant les événements 
     */
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
         // Si on clique sur le bouton ok, on revient à la fenêtre d'avant qui est ici la fenêtre des GuestCustomer
         if (e.getSource()== ok)
         {
            controller.AffichageGuestInfo();
            window.dispose();
         }
      }

    }
    
   /**
     * @return la window actuelle
     */
   public JFrame getWindow() { return window; }
   
   /**
     * Setters 
     * @param msg
     */
   public void setMessage(String  msg) { exceptionMessage.setText(msg); }
}
