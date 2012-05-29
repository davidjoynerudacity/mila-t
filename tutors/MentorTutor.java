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
public class MentorTutor extends Tutor {
    public MentorTutor() {
        super("Mentor");
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("1", "m1.jpg");
        addImage("2", "m2.jpg");
        addImage("3", "m3.jpg");
    
        TruePercept t1=new TruePercept(this);
        MultipleAction ma1=new MultipleAction(this);
        TextFeedbackAction tfa1=new TextFeedbackAction(this);
        tfa1.setFeedback("If this feedback is showing, then the Mentor tutor successfully ran its checks and is presenting this text as textual feedback."); 
        ma1.addAction(tfa1);
        
        ChangePictureAction cpa1=new ChangePictureAction(this);
        cpa1.setPicKey("2");
        ma1.addAction(cpa1);
        
        Mapping m1=new Mapping();
        m1.setPercept(t1);
        m1.setAction(ma1);
        addMapping(m1);
    }
}