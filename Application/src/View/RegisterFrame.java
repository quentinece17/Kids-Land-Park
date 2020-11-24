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


public class RegisterFrame extends JFrame {
    
        private JButton register = new JButton(" Register ");
        private JButton start = new JButton(" Start the command ");

     String space = "                                                      ";
     private JLabel label = new JLabel(space + " Hello dear customer register please !" + space);
     Font font= new Font("Arial",Font.BOLD,20); 
     
     private JLabel label2 = new JLabel(space + " Welcome New customer !" + space);
     Font font2 = new Font("Arial",Font.BOLD,20); 
    
     private JLabel login = new JLabel("login : ");
    private JTextField log = new JTextField(10);
    
    private JLabel pseudo = new JLabel("pseudo : ");
    private JTextField pseu = new JTextField(10);
    
     private JPanel p1 = new JPanel();   // Ecran d'accueil
     private JPanel p2 = new JPanel();
     
     
      ImageIcon img;                   // Image qu'on va mettre sur un JLabel
    JLabel imageLabel; 

    public RegisterFrame(int choice) {
        
         try{
            img = new ImageIcon("park.jpg");    // Chargement de l'image
            imageLabel = new JLabel(img);       // On place cette image dans le Label dédiée à l'image du park
        }
        catch (Exception e){ e.printStackTrace(); }
         
         // Frame Design
        setTitle("Register ");
        setSize(900, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
           
         // Design des panels
        p1.setSize(new Dimension(900, 350));
        p2.setSize(new Dimension(900, 400));
        p1.setBackground(new Color(253, 233, 224));
        p2.setBackground(new Color(253, 233, 224));  
         
        buildpanel1(choice);    
        p2.add(imageLabel);
        
         // Ajouter panel 1 et 2 sur la fenêtre d'accueil
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        setVisible(true);           // Fenêtre visible
        
        
    }
    public void buildpanel1(int choice)
    {
        
        if(choice==1)
        { // Border pour le JLabel 'label'(Color.RED) et Border pour les boutons (Color.BLACK) de l'écrand d'accueil
        javax.swing.border.Border bLabel = BorderFactory.createLineBorder(Color.RED);
        javax.swing.border.Border bButtons = BorderFactory.createLineBorder(Color.BLACK);
        
         // On met le Layout du panel 1 à null pour pouvoir placer les boutons comme bon nous semble
        p1.setLayout(null);
        label.setBounds(0, 20, 900, 45);
        login.setBounds(150,110,40,40);
        log.setBounds(200,120,60,20);
        pseudo.setBounds(350,110,80,40);
        pseu.setBounds(440,120,60,20);
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
        p1.add(login);
        p1.add(log);
        p1.add(pseudo);
        p1.add(pseu);
        p1.add(label);
        p1.add(register);
        }
        else if(choice==2)
        {
        javax.swing.border.Border bLabel = BorderFactory.createLineBorder(Color.RED);
        javax.swing.border.Border bButtons = BorderFactory.createLineBorder(Color.BLACK);
        
        p1.setLayout(null);
        label2.setBounds(0, 20, 900, 45);
        start.setBounds(430,120,130,30);
         
         label2.setBorder(bLabel);
        label2.setForeground(Color.red);
        label2.setFont(font2);
        label2.setBackground(new Color(253, 233, 224));
        start.setBorder(bButtons);
        start.setBackground(new Color(254, 150, 160));
        start.setForeground(Color.WHITE);
            
        p1.add(label2);
        p1.add(start);
        
        }
    }
    
    
}
