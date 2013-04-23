/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions;

import emt.tutor.Action;
import emt.tutor.Tutor;

/**
 *
 * @author David
 */
public class FocusTutorAction extends Action {
    public FocusTutorAction() {
        
    }
    public FocusTutorAction(Tutor myTutor) {
        super(myTutor);
    }
    public void doAction() {
            getTutor().focusTutor();
    }
}
