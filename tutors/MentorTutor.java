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
import javax.swing.Timer;
/**
 *
 * @author David
 */
public class MentorTutor extends InterruptTutor {
    
    public MentorTutor() {
        super("Mentor");
        initializeTutor();
    }

    public MentorTutor(ProjectModelPanel modelPanel) {
        super("Mentor",modelPanel);
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("1", "m1.jpg");
        addImage("2", "m2.jpg");
        addImage("3", "m3.jpg");
        
//        CurrentLessonPercept clp1=new CurrentLessonPercept(this);
//        clp1.setLesson("1");
//        
//        CurrentLessonPercept clp2=new CurrentLessonPercept(this);
//        clp2.setLesson("2");
//        
//        TextFeedbackAction tfa1=new TextFeedbackAction(this,"It is currently Lesson 1");
//        TextFeedbackAction tfa2=new TextFeedbackAction(this,"It is currently Lesson 2");
//        
//        Mapping m1=new Mapping();
//        m1.setPercept(clp1);
//        m1.setAction(tfa1);
//        
//        Mapping m2=new Mapping();
//        m2.setPercept(clp2);
//        m2.setAction(tfa2);
//        
//        this.addMapping(m1); 
//        this.addMapping(m2);
    
        PresentConnectionPercept t1=new PresentConnectionPercept(this);
        t1.setNode1("Fish");
        t1.setProperty1("Population");
        t1.setNode2("Nitrate");
        t1.setProperty2("Concentration");
        
        MultipleAction ma1=new MultipleAction(this);
        TextFeedbackAction tfa1=new TextFeedbackAction(this);
        tfa1.setFeedback("I noticed you just connected Fish Population with Nitrate Concentration. Did you know that Nitrate itself is increased by the presence of bacteria?"); 
        ma1.addAction(tfa1);
        ChangePictureAction cpa1=new ChangePictureAction(this);
        cpa1.setPicKey("2");
        ma1.addAction(cpa1);
        
        MultiplePercept mp1=new MultiplePercept(this);
        UnreadTextFeedbackPercept utfp1=new UnreadTextFeedbackPercept(this);
        utfp1.setTextFeedbackAction(tfa1);
        mp1.addPercept(t1);
        mp1.addPercept(utfp1);
        
        Mapping m1=new Mapping();
        m1.setPercept(mp1);
        m1.setAction(ma1);

        
        PresentConnectionPercept t2=new PresentConnectionPercept(this);
        t2.setNode1("Bacteria");
        t2.setProperty1("Population");
        t2.setNode2("Nitrate");
        t2.setProperty2("Concentration");
        
        MultipleAction ma2=new MultipleAction(this);
        TextFeedbackAction tfa2=new TextFeedbackAction(this,"Nice! You connected Bacteria with Nitrate Concentration. Did you know that bacteria producing nitrate is a known scientific fact? You can use that as evidence, if you'd like.");
        ma2.addAction(tfa2);
        ChangePictureAction cpa2=new ChangePictureAction(this);
        cpa2.setPicKey("3");
        ma2.addAction(cpa2);
        
        MultiplePercept mp2=new MultiplePercept(this);
        UnreadTextFeedbackPercept utfp2=new UnreadTextFeedbackPercept(this);
        utfp2.setTextFeedbackAction(tfa2);
        mp2.addPercept(t2);
        mp2.addPercept(utfp2);
        
        Mapping m2=new Mapping();
        m2.setPercept(mp2);
        m2.setAction(ma2);

        
        TruePercept t3=new TruePercept(this);
        MultipleAction ma3=new MultipleAction(this);
        TextFeedbackAction tfa3=new TextFeedbackAction(this);
        tfa3.setFeedback("I don't have anything to say right now. Keep up the good work!");
        ma3.addAction(tfa3);
        
        ChangePictureAction cpa3=new ChangePictureAction(this);
        cpa3.setPicKey("1");
        ma3.addAction(cpa3);
        
        Mapping m3=new Mapping();
        m3.setPercept(t3);
        m3.setAction(ma3);
        
        addMapping(m2);
        addMapping(m1);
        addMapping(m3);
    }
}