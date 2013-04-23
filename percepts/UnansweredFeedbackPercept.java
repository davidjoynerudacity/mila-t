/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts;

import emt.tutor.Percept;
import emt.tutor.Tutor;
import emt.tutor.actions.FeedbackPromptAction;

/**
 *
 * @author David
 */
public class UnansweredFeedbackPercept extends Percept {
    private FeedbackPromptAction myFPA;
    public UnansweredFeedbackPercept() {
        
    }
    public UnansweredFeedbackPercept(Tutor myTutor) {
        super(myTutor);
    }
    
    public void setFeedbackActionPrompt(FeedbackPromptAction fpa) {
        myFPA=fpa;
    }
    public FeedbackPromptAction getFeedbackActionPrompt() {
        return myFPA;
    }
    
    public boolean isTrue() {
        return !myFPA.getHasBeenAnswered();
    }
}
