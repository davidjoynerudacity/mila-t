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
public class CriticTutor extends OnDemandTutor {
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
        
        ChangePictureAction cpa1=new ChangePictureAction(this);
        cpa1.setPicKey("2");
        ChangePictureAction cpa2=new ChangePictureAction(this);
        cpa2.setPicKey("3");
        
        MissingPropertiesPercept mpp1=new MissingPropertiesPercept(this);
        TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like you haven't added properties to all your components. Remember, a component is the physical thing in the system: the property is what it is about that thing that changes. So, for example, the physical thing 'water' might have the property 'temperature', and 'temperature' is what rises and falls.");
        MultipleAction ma1=new MultipleAction(this);
        ma1.addAction(cpa1);
        ma1.addAction(tfa1);
        Mapping m1=new Mapping();
        m1.setPercept(mpp1);
        m1.setAction(ma1);
        
        UnevidencedEdgePercept uep1=new UnevidencedEdgePercept(this);
        TextFeedbackAction tfa2=new TextFeedbackAction(this,"It looks like you haven't given evidence for all the connections you've drawn. A good model has some kind of evidence given for every connection it proposes. Evidence might be a observation, a known scientific theory, or a statement from an expert.");
        MultipleAction ma2=new MultipleAction(this);
        ma2.addAction(cpa1);
        ma2.addAction(tfa2);
        Mapping m2=new Mapping();
        m2.setPercept(uep1);
        m2.setAction(ma2);
        
        PresentNodePercept pnp1=new PresentNodePercept(this);
        pnp1.setNode("Nitrate");
        pnp1.setProperty("Amount");
        TextFeedbackAction tfa3=new TextFeedbackAction(this,"Right now you're using the word 'amount' to refer to nitrate. It would be more appropriate to use the word 'concentration'. The 'amount' of nitrate in the water would not change if the amount of water changed, but the concentration would.");
        MultipleAction ma3=new MultipleAction(this);
        ma3.addAction(cpa1);
        ma3.addAction(tfa3);
        Mapping m3=new Mapping();
        m3.setPercept(pnp1);
        m3.setAction(ma3);
        
        AbsentNodePercept anp1=new AbsentNodePercept(this);
        anp1.setNode("Fish");
        anp1.setProperty("Population");
        TextFeedbackAction tfa4=new TextFeedbackAction(this,"The phenomenon you're explaining is that the fish in the lake died, so you'll probably want to represent the fish population in your model. This can be done with a component named 'Fish' and a property named 'Population'.");
        MultipleAction ma4=new MultipleAction(this);
        ma4.addAction(cpa1);
        ma4.addAction(tfa4);
        Mapping m4=new Mapping();
        m4.setPercept(anp1);
        m4.setAction(ma4);
        
        TruePercept tp1=new TruePercept(this);
        TextFeedbackAction tfa5=new TextFeedbackAction(this,"Everything looks good to me!");
        MultipleAction ma5=new MultipleAction(this);
        ma5.addAction(cpa2);
        ma5.addAction(tfa5);
        Mapping m5=new Mapping();
        m5.setPercept(tp1);
        m5.setAction(ma5);
        
        this.addMapping(m4);
        this.addMapping(m3);
        this.addMapping(m1);
        this.addMapping(m2);
        this.addMapping(m5);
    }
}
