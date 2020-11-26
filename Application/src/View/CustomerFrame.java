/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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

/**
 *
 * @author quentin
 * 
 **/

public class CustomerFrame extends JFrame {
    
    private JFrame window = new JFrame ();
    
    private JPanel panel = new JPanel();
    
    private JLabel label;
    
    //Information de l'utilisateur qu'on a besoin de récupérer dans Application
    private String typeUser;
    private String nameUser;
    private int idUser;
    
    private Application controller;
    
    public CustomerFrame (Application app)
    {
        controller = app;
        label = new JLabel ();
        
        // Frame Design
        window.setTitle("Kids Land Park");
        window.setSize(900, 750);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        panel.add (label);
        window.add(panel, BorderLayout.CENTER);
    }
    
    public void setText (String text)
    {
        label.setText(text);
    }
    

    public JFrame getWindow () { return window; }
    public JLabel getLabel () { return label; }
    
}
