/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions;

import emt.tutor.Action;
import emt.tutor.Tutor;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class QuestionListAction extends Action {
    private ArrayList<String> myQuestions;
    
    public QuestionListAction(Tutor myTutor) {
        super(myTutor);
        myQuestions=new ArrayList<String>();
    }
    public void doAction() {
        getTutor().giveQuestionList(myQuestions);
    }
    public ArrayList<String> getQuestions() {
        return myQuestions;
    }
    public void setQuestions(ArrayList<String> questions) {
        myQuestions=questions;
    }
    public void addQuestion(String question) {
        myQuestions.add(question);
    }
    
}
