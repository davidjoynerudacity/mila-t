/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts;

import emt.tutor.Percept;
import emt.tutor.Tutor;
import emt.tutor.actions.TextFeedbackAction;

/**
 *
 * @author David
 */
public class UnreadTextFeedbackPercept extends Percept {
    private TextFeedbackAction myTFA;
    
    public UnreadTextFeedbackPercept(Tutor myTutor) {
        super(myTutor);
    }
    public UnreadTextFeedbackPercept(Tutor myTutor,TextFeedbackAction tfa) {
        super(myTutor);
        myTFA=tfa;
    }
    public void setTextFeedbackAction(TextFeedbackAction tfa) {
        myTFA=tfa;
    }
    public TextFeedbackAction getTextFeedbackAction() {
        return myTFA;
    }
    
    public boolean isTrue() {
        return !myTFA.getIsRead();
    }
}
