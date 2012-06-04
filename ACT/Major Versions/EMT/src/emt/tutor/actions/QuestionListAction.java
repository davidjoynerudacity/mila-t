/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions;

import emt.tutor.Action;
import emt.tutor.QuestionItem;
import emt.tutor.Tutor;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class QuestionListAction extends Action {
    //private ArrayList<String> myQuestions;
    private ArrayList<QuestionItem> myQuestions;
    
    public QuestionListAction(Tutor myTutor) {
        super(myTutor);
        myQuestions=new ArrayList<QuestionItem>();
    }
    public void doAction() {
        getTutor().giveQuestionList(myQuestions);
    }
    public ArrayList<QuestionItem> getQuestions() {
        return myQuestions;
    }
    public void setQuestions(ArrayList<QuestionItem> questions) {
        myQuestions=questions;
    }
    public void addQuestion(QuestionItem question) {
        myQuestions.add(question);
    }
    
}
