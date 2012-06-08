/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.tutors;

import emt.ProjectModelPanel;
import emt.tutor.*;
import emt.tutor.actions.*;
import emt.tutor.percepts.*;
import emt.tutor.percepts.modelpercepts.*;
/**
 *
 * @author David
 */
public class FeedbackTutor extends InterruptTutor {
    public FeedbackTutor() {
        super("Feedback");
        initializeTutor();
    }

    public FeedbackTutor(ProjectModelPanel modelPanel) {
        super("Feedback",modelPanel);
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("1", "s1.jpg");
        addImage("2", "s2.jpg");
        addImage("3", "s3.jpg");
    
        PresentNodePercept pnp1=new PresentNodePercept(this);
        pnp1.setNode("Bacteria");
        pnp1.setProperty("Population");
        
        MultipleAction ma1=new MultipleAction(this);
        ChangePictureAction cpa1=new ChangePictureAction(this);
        cpa1.setPicKey("2");
        ma1.addAction(cpa1);
        FeedbackPromptAction fpa1=new FeedbackPromptAction(this);
        fpa1.setPrompt("I noticed you added Bacteria Population to your model. Why did you add that?");
        ma1.addAction(fpa1);
        ma1.addAction(new FocusTutorAction(this));
        
        UnansweredFeedbackPercept fap1=new UnansweredFeedbackPercept(this);
        fap1.setFeedbackActionPrompt(fpa1);
        MultiplePercept mp1=new MultiplePercept(this);
        mp1.addPercept(pnp1);
        mp1.addPercept(fap1);
        
        Mapping m1=new Mapping();
        m1.setPercept(mp1);
        m1.setAction(ma1);
        this.addMapping(m1);
        
        TruePercept t1=new TruePercept(this);
        MultipleAction ma2=new MultipleAction(this);
        ma2.addAction(new TextFeedbackAction(this,"I don't have anything to ask right now. Keep up the good work!"));
        ChangePictureAction cpa2=new ChangePictureAction(this);
        cpa2.setPicKey("3");
        ma2.addAction(cpa2);
        
        Mapping m2=new Mapping();
        m2.setPercept(t1);
        m2.setAction(ma2);
        this.addMapping(m2);
    }
}
