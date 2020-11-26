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
import static Controller.Application.commData;
import static Controller.Application.createGuestData;

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
    
    private JFrame window = new JFrame ();
    
    private boolean affich_menu = false;
    
    private JButton register = new JButton(" Register ");
    private JButton start = new JButton(" Confirm ");

    String space = "                                                      ";
    private JLabel label = new JLabel(space + " Please enter your informations : " + space);
    Font font= new Font("Arial",Font.BOLD,20); 
     
    private JLabel label2 = new JLabel(space + " Welcome New customer !" + space);
    Font font2 = new Font("Arial",Font.BOLD,20); 
    
    private JLabel lastname = new JLabel ("Last name : ");
    private JTextField l_name = new JTextField (10);
    
    private JLabel firstname = new JLabel ("First name : ");
    private JTextField f_name = new JTextField (10);
    
    private JLabel age = new JLabel ("Age : ");
    private JTextField agetext = new JTextField (10);
    
    private JLabel login = new JLabel("Login : ");
    private JTextField log = new JTextField(10);
    
    private JLabel pseudo = new JLabel("Pseudo : ");
    private JTextField pseu = new JTextField(10);
    
    private JPanel p1 = new JPanel();   // Ecran d'accueil
    private JPanel p2 = new JPanel();
     
    //Information de l'utilisateur qu'on a besoin de récupérer dans Application
    private String typeUser;
    private String nameUser;
    private int idUser;
    private int ageUser;
     
    ImageIcon img;                   // Image qu'on va mettre sur un JLabel
    JLabel imageLabel; 

    public RegisterFrame(int choice) {
        
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
        start.addActionListener(new InteractionButtonListener());
        
        register.addActionListener(new InteractionButtonListener());
           
         // Design des panels
        p1.setSize(new Dimension(900, 350));
        p2.setSize(new Dimension(900, 400));
        p1.setBackground(new Color(253, 233, 224));
        p2.setBackground(new Color(253, 233, 224));  
         
        buildpanel1(choice);    
        p2.add(imageLabel);
        
         // Ajouter panel 1 et 2 sur la fenêtre d'accueil
        window.add(p1, BorderLayout.CENTER);
        window.add(p2, BorderLayout.SOUTH);
        
        window.setVisible(true);           // Fenêtre visible
        
        
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
        
        firstname.setBounds(150,110,80,40);
        f_name.setBounds(240,120,110,20);
        lastname.setBounds(150,150,80,40);
        l_name.setBounds(240,160,110,20);
        age.setBounds(150, 190, 80, 40);
        agetext.setBounds(240, 200, 110, 20);
        
        start.setBorder(bButtons);
        start.setBackground(new Color(254, 150, 160));
        start.setForeground(Color.WHITE);
            
        p1.add (firstname);
        p1.add (f_name);
        p1.add (lastname);
        p1.add (l_name);
        p1.add (age);
        p1.add(agetext);
        p1.add(label2);
        p1.add(start);
        
        }
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
              String name, type, id;
              //On récupère le nom de l'utilisateur
              name = commData (pseu.getText(), log.getText(), "name");
              if (name != null)
              {
                nameUser = name;
                //On récupère son identifiant
                id = commData (pseu.getText(), log.getText(), "id");
                idUser = Integer.parseInt(id);
                //On récupère son type (MC ou E)
                type = commData (pseu.getText(), log.getText(), "user_type");
                typeUser = type;
                                
                if (typeUser.equals("MC"))
                {
                    //Ici appeler une fonction qui crée un MC et qui le retourne comme ca on l'envoi à CustomerFrame
                    //Frame du Customer
                    CustomerFrame customer = new CustomerFrame (idUser, nameUser, typeUser);
                }
                else if (typeUser.equals("E"))
                {
                    //Ici appeler une fonction qui crée un Employé et qui le retourne comme ca on l'envoi à CustomerFrame
                    //Frame de l'employé
                }
                window.dispose();
                
              }
              else if (name == null)
              {
                //Message d'erreur ou redemander à l'utilisateur d'essayer de se reconnecter
//                  window.dispose ();
              }
              
          }
          
          if (e.getSource() == start)
          {
              //On récupère les informations de l'utilisateur
              nameUser = f_name.getText() +" " + l_name.getText();
              typeUser = "GC";
              idUser = -1;
              ageUser = Integer.parseInt(agetext.getText());
              
              //Création du GuestCustomer dans la base de donnée
              createGuestData (nameUser, ageUser, typeUser);
              
              //Ici appeler une fonction qui crée un GC et qui le retourne comme ca on l'envoi à CustomerFrame
              
              //Affichage de la page pour un Customer
              CustomerFrame customer = new CustomerFrame (idUser, nameUser, typeUser);
              window.dispose();
          }
      }

       
    }
    
    public boolean getAffich_menu () { return affich_menu;}
    
    public String getTypeUser () { return typeUser; }
    public String getNameUser () { return nameUser; }
    public int getIdUser () { return idUser; }
}
    
