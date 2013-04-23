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
public class ShowTutorAction extends Action {
    public ShowTutorAction() {
        
    }
    public ShowTutorAction(Tutor myTutor) {
        super(myTutor);
    }
    public void doAction() {
        getTutor().showTutor();
    }
}
