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
public class FeedbackPromptAction extends Action {
    private String myPrompt;
    private boolean hasBeenAnswered=false;
    
    public FeedbackPromptAction(Tutor myTutor) {
        super(myTutor);
    }
    public void doAction() {
        getTutor().giveFeedbackPrompt(this);
    }
    public String getPrompt() {
        return myPrompt;
    }
    public void setPrompt(String prompt) {
        myPrompt=prompt;
    }
    public boolean getHasBeenAnswered() {
        return hasBeenAnswered;
    }
    public void setHasBeenAnswered(boolean answered) {
        hasBeenAnswered=answered;
    }
}
