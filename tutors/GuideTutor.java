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
public class GuideTutor extends Tutor {
    public GuideTutor() {
        super("Guide");
        
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("1", "g1.jpg");
        addImage("2", "g2.jpg");
        addImage("3", "g3.jpg");
        
        TruePercept t1=new TruePercept(this);
        MultipleAction ma1=new MultipleAction(this);
        TextFeedbackAction tfa1=new TextFeedbackAction(this);
        tfa1.setFeedback("If this feedback is showing, then the Guide tutor successfully ran its checks and is presenting this text as textual feedback."); 
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
