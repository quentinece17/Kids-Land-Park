/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @authors : quentin, corentin and nicolas
 */
public class AccueilFrame extends JFrame{
    
    private JButton account = new JButton("Log in");
    private JButton noAccount = new JButton("Sign up");
    String space = "                                                          ";
    private JLabel label = new JLabel(space + "Welcome to Kids Land Park" + space);
    Font font= new Font("Arial",Font.BOLD,20);      // Font for the Label "Welcome..."
    
    private JLabel login = new JLabel("login : ");
    private JTextField log = new JTextField(10);
    private JPanel p1 = new JPanel();   // Ecran d'accueil
    private JPanel p2 = new JPanel();   // Image d'accueil
    private JPanel p3 = new JPanel();    // Panel qui rassemble p1 et p2
    
    ImageIcon img;                   // Image qu'on va mettre sur un JLabel
    JLabel imageLabel;               // JLabel qui va recevoir l'image
    
    public AccueilFrame(){
        
        try{
            img = new ImageIcon("park.jpg");    // Chargement de l'image
            imageLabel = new JLabel(img);       // On place cette image dans le Label dédiée à l'image du park
        }
        catch (Exception e){ e.printStackTrace(); }
        
        // Frame Design
        setTitle("Kids Land Park");
        setSize(900, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Border pour le JLabel 'label'(Color.RED) et Border pour les boutons (Color.BLACK) de l'écrand d'accueil
        javax.swing.border.Border bLabel = BorderFactory.createLineBorder(Color.RED);
        javax.swing.border.Border bButtons = BorderFactory.createLineBorder(Color.BLACK);
        
        // Design des panels
        p1.setSize(new Dimension(900, 350));
        p2.setSize(new Dimension(900, 400));
        p1.setBackground(new Color(253, 233, 224));
        p2.setBackground(new Color(253, 233, 224));
        
        // On met le Layout du panel 1 à null pour pouvoir placer les boutons comme bon nous semble
        p1.setLayout(null);
        label.setBounds(0, 20, 900, 45);            // Placer le JLabel "Welcome to Kids Land Park"
        account.setBounds(320, 85, 85, 25);         // Placer le bouton "Log in"
        noAccount.setBounds(540, 85, 85, 25);       // Placer le bouton "Sign up"
        
        // Design des label et bouttons 
        label.setBorder(bLabel);
        label.setForeground(Color.red);
        label.setFont(font);
        label.setBackground(new Color(253, 233, 224));
        account.setBorder(bButtons);
        account.setBackground(new Color(254, 150, 160));
        account.setForeground(Color.WHITE);
        noAccount.setBorder(bButtons);
        noAccount.setBackground(new Color(254, 150, 160));
        noAccount.setForeground(Color.WHITE);
        
        
        // Ajouter 'label' et les bouttons sur le panel 1 et l'image sur le panel 2 sur la fenêtre d'accueil
        p1.add(label);
        p1.add(account);
        p1.add(noAccount);
        p2.add(imageLabel);
        
         // Ajouter panel 1 et 2 sur la fenêtre d'accueil
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        setVisible(true);           // Fenêtre visible
    }
}
