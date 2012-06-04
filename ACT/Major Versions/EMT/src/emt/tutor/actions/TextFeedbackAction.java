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
public class TextFeedbackAction extends Action {
    private String myFeedback;
    
    public TextFeedbackAction(Tutor myTutor) {
        super(myTutor);
    }
    public TextFeedbackAction(Tutor myTutor,String feedback) {
        this(myTutor);
        myFeedback=feedback;
    }
    public void doAction() {
        getTutor().giveTextFeedback(myFeedback);
    }
    public String getFeedback() {
        return myFeedback;
    }
    public void setFeedback(String feedback) {
        myFeedback=feedback;
    }
}
