/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import emt.ProjectModelPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author David
 */
public class InterruptTutor extends Tutor implements ActionListener {
    private Timer myTimer;
    private int myDelay=5000;
    
    public InterruptTutor() {
        super();
        myTimer=new Timer(myDelay,this);
        myTimer.start();
    }
    public InterruptTutor(String name) {
        super(name);
        myTimer=new Timer(myDelay,this);
        myTimer.start();
    }
    public InterruptTutor(String name,ProjectModelPanel modelPanel) {
        super(name,modelPanel);
        myTimer=new Timer(myDelay,this);
        myTimer.start();
    }
    
    public void wasClicked() {
        super.wasClicked();
    }
    
    public void actionPerformed(ActionEvent e) {
        if(!super.isVisible()) {
            System.out.println("Checking mappings for " + this.getName());
            super.checkMappings();
        }
    }
}
