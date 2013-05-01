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
    private String myIntro;
    
    public QuestionListAction() {
        myQuestions=new ArrayList<QuestionItem>();
        myIntro="Hi! What can I help you with today?";
    }
    public QuestionListAction(Tutor myTutor) {
        super(myTutor);
        myQuestions=new ArrayList<QuestionItem>();
        myIntro="Hi! What can I help you with today?";
    }
    public void doAction() {
        getTutor().giveQuestionList(myQuestions,myIntro);
        if(this.getFace()!=null) {
            this.getFace().doAction();
        }
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
    public void setIntro(String intro) {
        myIntro=intro;
    }
    public String getIntro() {
        return myIntro;
    }
    
}
