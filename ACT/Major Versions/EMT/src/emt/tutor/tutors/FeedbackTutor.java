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
public class FeedbackTutor extends Tutor {
    public FeedbackTutor() {
        super("Feedback");
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("1", "s1.png");
        addImage("2", "s2.png");
        addImage("3", "s3.png");
    
        TruePercept t1=new TruePercept(this);
        MultipleAction ma1=new MultipleAction(this);
        FeedbackPromptAction fpa1=new FeedbackPromptAction(this);
        fpa1.setPrompt("This question represents a question the Feedback tutor would ask.");
        ma1.addAction(fpa1);
        
        ChangePictureAction cpa1=new ChangePictureAction(this);
        cpa1.setPicKey("2");
        ma1.addAction(cpa1);
        
        Mapping m1=new Mapping();
        m1.setPercept(t1);
        m1.setAction(ma1);
        addMapping(m1);
    }
}
