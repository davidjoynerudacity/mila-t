/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions.quiz;

import emt.tutor.Action;
import emt.tutor.Tutor;

/**
 *
 * @author David
 */
public class QuizTextAction extends AbstractQuizAction {
    private String myPrompt;
    
    public QuizTextAction(Tutor myTutor) {
        super(myTutor);
    }
    public QuizTextAction(Tutor tutor,String prompt) {
        this(tutor);
        setPrompt(prompt);
    }
    public void doAction() {
        getTutor().giveQuizText(this);
    }
    public String getPrompt() {
        return myPrompt;
    }
    public void setPrompt(String prompt) {
        myPrompt=prompt;
    }
}
