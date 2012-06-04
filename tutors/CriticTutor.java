/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.tutors;

import emt.ProjectModelPanel;
import emt.tutor.*;
import emt.tutor.actions.*;
import emt.tutor.percepts.*;
/**
 *
 * @author David
 */
public class CriticTutor extends Tutor {
    public CriticTutor() {
        super("Critic");
        initializeTutor();
    }

    public CriticTutor(ProjectModelPanel modelPanel) {
        super("Critic",modelPanel);
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("1", "c1.jpg");
        addImage("2", "c2.jpg");
        addImage("3", "c3.jpg");
        
        TruePercept t1=new TruePercept(this);
        MultipleAction ma1=new MultipleAction(this);
        QuestionListAction qla1=new QuestionListAction(this);
        qla1.addQuestion(new QuestionItem("Do you have any content advice for us?",new TextFeedbackAction(this,"Feedback for Q1")));
        qla1.addQuestion(new QuestionItem("How do I use a simulation?",new TextFeedbackAction(this,"Feedback for Q2")));
        qla1.addQuestion(new QuestionItem("What's the difference between biotic and abiotic substances?",new TextFeedbackAction(this,"Feedback for Q3")));
        qla1.addQuestion(new QuestionItem("When is it appropriate to ask for help?",new TextFeedbackAction(this,"Feedback for Q4")));
        ma1.addAction(qla1);
        
        ChangePictureAction cpa1=new ChangePictureAction(this);
        cpa1.setPicKey("2");
        ma1.addAction(cpa1);
        
        Mapping m1=new Mapping();
        m1.setPercept(t1);
        m1.setAction(ma1);
        addMapping(m1);
    }
}
