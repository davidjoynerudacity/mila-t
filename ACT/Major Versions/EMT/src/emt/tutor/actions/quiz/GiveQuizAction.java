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
public class GiveQuizAction extends Action {
    private QuizQuestionSet mySet;

    public GiveQuizAction() {
    }
    
    public GiveQuizAction(Tutor myTutor) {
        super(myTutor);
    }
    public void doAction() {
        mySet.getNextQuestion();
    }
    
    public QuizQuestionSet getQuizQuestionSet() {
        return mySet;
    }
    public void setQuizQuestionSet(QuizQuestionSet set) {
        mySet=set;
    }
}
