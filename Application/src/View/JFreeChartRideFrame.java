/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Application;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author quentin, nicolas & corentin
 */
public class JFreeChartRideFrame extends JFrame {
    
    Application controller;
    private ArrayList<String> tickets = new ArrayList<String> ();
    JFrame window = new JFrame();
    ChartFrame popularRides;
    int [] totalTickets = null;
    
    public JFreeChartRideFrame( Application app)
    {
        controller = app;
        //popularRides.pack();
    }
    
    // Pour redimenssioner le tout
    public void packing(){ popularRides.pack(); }
    
    // Getters
    public JFrame getWindow() {return window;}
    public ChartFrame getChart() {return popularRides;} // Pour le rendre visible depuis le controller
    
    // Setters
    public void setTickets (ArrayList<String> list_) {tickets = list_;}
    public void setTotalTickets (int tab[]) {totalTickets = tab;}
    public void setChart (ChartFrame cf) { popularRides = cf; }
    
}
