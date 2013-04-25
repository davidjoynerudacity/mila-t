/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.tutors;

import emt.ProjectModelPanel;
import emt.tutor.*;
import emt.tutor.actions.*;
import emt.tutor.percepts.*;
import emt.tutor.percepts.modelpercepts.*;
import javax.swing.Timer;
/**
 *
 * @author David
 */
public class ObserverTutor extends InterruptTutor {
    
    public ObserverTutor() {
        super("Observer");
        initializeTutor();
    }

    public ObserverTutor(ProjectModelPanel modelPanel) {
        super("Observer",modelPanel);
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("neutral-front", "a-neutral-front.jpg");
        addImage("neutral-side", "a-neutral-side.jpg");
        
        
    }
}