/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions;

import emt.tutor.TutorPanel;
import emt.tutor.Action;
import emt.tutor.QuestionItem;
import emt.tutor.Tutor;
import java.util.ArrayList;

/**
 *
 * @author David
 * 
 * This Action breaks the normal paradigm of Percepts and Actions; it holds QuestionItems to provide to a GuideTutor2.
 */
public class HoldQuestionsAction extends Action {
    private ArrayList<QuestionItem> myQuestions;
    
    public HoldQuestionsAction() {
        
    }
    public HoldQuestionsAction(Tutor myTutor) {
        super(myTutor);
        myQuestions=new ArrayList<QuestionItem>();
    }
    public HoldQuestionsAction(Tutor myTutor,String picKey) {
        this(myTutor);
    }
    public void doAction() {

    }
    public void setQuestions(ArrayList<QuestionItem> questions) {
        myQuestions=questions;
    }
    public void addQuestion(QuestionItem question) {
        myQuestions.add(question);
    }
    public ArrayList<QuestionItem> getQuestions() {
        return myQuestions;
    }
    
}
