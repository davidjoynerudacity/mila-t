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
    
    public FeedbackPromptAction(Tutor myTutor) {
        super(myTutor);
    }
    public void doAction() {
        getTutor().giveFeedbackPrompt(myPrompt);
    }
    public String getPrompt() {
        return myPrompt;
    }
    public void setPrompt(String prompt) {
        myPrompt=prompt;
    }
}
