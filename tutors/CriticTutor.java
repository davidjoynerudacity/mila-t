/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.tutors;

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
    
    public void initializeTutor() {
        addImage("1", "c1.png");
        addImage("2", "c2.png");
        addImage("3", "c3.png");
        
        TruePercept t1=new TruePercept(this);
        MultipleAction ma1=new MultipleAction(this);
        QuestionListAction qla1=new QuestionListAction(this);
        qla1.addQuestion("Do you have any content advice for us?");
        qla1.addQuestion("How do I use a simulation?");
        qla1.addQuestion("What's the difference between biotic and abiotic substances?");
        qla1.addQuestion("When is it appropriate to ask for help?");
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
