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
public abstract class AbstractQuizAction extends Action {
    private String myPrompt;
    private QuizQuestionSet mySet;
        
    public AbstractQuizAction(Tutor myTutor) {
        super(myTutor);
    }
    public void setQuestionSet(QuizQuestionSet set) {
        mySet=set;
    }
    public void next() {
        mySet.getNextQuestion();
    }
    public String getPrompt() {
        return myPrompt;
    }
    public void setPrompt(String prompt) {
        myPrompt=prompt;
    }
}
