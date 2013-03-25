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
    private String myAnswer;
    private boolean myIsLast;
    private boolean myIsFirst;
    private boolean myAnswerRequired;
    private QuizQuestionSet mySet;
        
    public AbstractQuizAction(Tutor myTutor) {
        super(myTutor);
        myAnswer="";
        myAnswerRequired=true;
    }
    public void setQuestionSet(QuizQuestionSet set) {
        mySet=set;
    }
    public void next() {
        mySet.getNextQuestion();
    }
    public void previous() {
        mySet.getPreviousQuestion();
    }
    public String getPrompt() {
        return myPrompt;
    }
    public void setPrompt(String prompt) {
        myPrompt=prompt;
    }
    public String getAnswer() {
        return myAnswer;
    }
    public void setAnswer(String answer) {
        myAnswer=answer;
    }
    
    public boolean getIsLast() {
        return myIsLast;
    }
    public void setIsLast(boolean isLast) {
        myIsLast=isLast;
    }
    public boolean getIsFirst() {
        return myIsFirst;
    }
    public void setIsFirst(boolean isFirst) {
        myIsFirst=isFirst;
    }
    public boolean getAnswerRequired() {
        return myAnswerRequired;
    }
    public void setAnswerRequired(boolean AnswerRequired) {
        myAnswerRequired=AnswerRequired;
    }
}
