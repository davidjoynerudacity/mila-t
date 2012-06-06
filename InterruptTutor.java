/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import emt.ProjectModelPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David
 */
public class InterruptTutor extends Tutor implements ActionListener {
    public InterruptTutor() {
        super();
    }
    public InterruptTutor(String name) {
        super(name);
    }
    public InterruptTutor(String name,ProjectModelPanel modelPanel) {
        super(name,modelPanel);
    }
    
    public void wasClicked() {
        super.wasClicked();
    }
    
    public void actionPerformed(ActionEvent e) {
        super.checkMappings();
    }
}
