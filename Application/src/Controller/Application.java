/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataBase;
import Model.DataInterface;
import Model.Employee;
import Model.GuestCustomer;
import Model.MemberCustomer;
import View.AccueilFrame;
import View.RegisterFrame;

import javax.swing.*;
import javax.swing.Icon;
import java.awt.*;
import javafx.scene.layout.Border;

/**
 *
 * @authors : quentin, corentin and nicolas
 */
public class Application{
    
       public Application(){  
           
           AccueilFrame accueil = new AccueilFrame();
       }
       

    public static String commData (String ps, String log, String info) {
           
        if (info.equals("name"))
        {
           String name;
           DataInterface verif = new DataBase ();
           name = verif.verifUser(ps, log, info);
           
           return name;
        }
        
        if (info.equals("user_type"))
        {
           String type;
           DataInterface verif = new DataBase ();
           type = verif.verifUser(ps, log, info);
           
           return type;
        }
       
        if (info.equals ("id"))
        {
            String type;
            DataInterface verif = new DataBase ();
            type = verif.verifUser(ps, log, info);
            return type;
        }
        
        else
            return null;
           
       }
    
    /**
     *
     * @param name
     * @param age
     * @param user_type
     */
    public static void createGuestData (String name, int age, String user_type)
    {
        DataInterface add = new DataBase ();
        add.createGuest(name, age, user_type);
    }
    
//    public static void createPerson (int id, String userType)
//    {
//        if (userType.equals ("MC"))
//        {
//            MemberCustomer member = new MemberCustomer (id);
//        }
//        else if (userType.equals ("E"))
//        {
//            Employee empl = new Employee (id);
//        }
//        else if (userType.equals("GC"))
//        {
////            GuestCustomer guest = new GuestCustomer (id);
//        }
//    }
}
    
