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
public class GuideTutor extends Tutor {
    public GuideTutor() {
        super("Guide");
        
        initializeTutor();
    }

    public GuideTutor(ProjectModelPanel modelPanel) {
        super("Guide",modelPanel);
        
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("1", "g1.jpg");
        addImage("2", "g2.jpg");
        addImage("3", "g3.jpg");
        
        TruePercept t1=new TruePercept(this);
        
        //UnevidencedEdgePercept t1=new UnevidencedEdgePercept(this);
        
        //MissingPropertiesPercept t1=new MissingPropertiesPercept(this);
        
        //AbsentNodePercept t1=new AbsentNodePercept(this);
        //t1.setNode("Fish");
        //t1.setProperty("Population");
        
        //AbsentConnectionPercept t1=new AbsentConnectionPercept(this);
        //t1.setNode1("Fish");
        //t1.setProperty1("Population");
        //t1.setNode2("Nitrate");
        //t1.setProperty2("Concentration");
        
        MultipleAction ma1=new MultipleAction(this);
        TextFeedbackAction tfa1=new TextFeedbackAction(this);
        tfa1.setFeedback("The percept was true."); 
        ma1.addAction(tfa1);
        
        ChangePictureAction cpa1=new ChangePictureAction(this);
        cpa1.setPicKey("2");
        ma1.addAction(cpa1);
        
        Mapping m1=new Mapping();
        m1.setPercept(t1);
        m1.setAction(ma1);
        addMapping(m1);
        
        TruePercept t2=new TruePercept(this);
        MultipleAction ma2=new MultipleAction(this);
        TextFeedbackAction tfa2=new TextFeedbackAction(this);
        tfa2.setFeedback("The percept was false.");
        ma2.addAction(tfa2);
        
        ChangePictureAction cpa2=new ChangePictureAction(this);
        cpa2.setPicKey("3");
        ma2.addAction(cpa2);
        
        Mapping m2=new Mapping();
        m2.setPercept(t2);
        m2.setAction(ma2);
        addMapping(m2);
    }
}
