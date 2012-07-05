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
        addImage("amazed-front", "u-amazed-front.jpg");
        addImage("amazed-side", "u-amazed-side.jpg");
        addImage("concerned-front", "u-concerned-front.jpg");
        addImage("concerned-side", "u-concerned-side.jpg");
        addImage("confused-front", "u-confused-front.jpg");
        addImage("confused-side", "u-confused-side.jpg");
        addImage("excited-front", "u-excited-front.jpg");
        addImage("excited-side", "u-excited-side.jpg");
        addImage("happy-front", "u-happy-front.jpg");
        addImage("happy-side", "u-happy-side.jpg");
        addImage("interested-front", "u-interested-front.jpg");
        addImage("interested-side", "u-interested-side.jpg");
        addImage("neutral-front", "u-neutral-front.jpg");
        addImage("neutral-side", "u-neutral-side.jpg");
        
        ChangePictureAction cpaAmazedFront=new ChangePictureAction(this,"amazed-front");
        ChangePictureAction cpaAmazedSide=new ChangePictureAction(this,"amazed-side");
        ChangePictureAction cpaConcernedFront=new ChangePictureAction(this,"concerned-front");
        ChangePictureAction cpaConcernedSide=new ChangePictureAction(this,"concerned-side");
        ChangePictureAction cpaConfusedFront=new ChangePictureAction(this,"confused-front");
        ChangePictureAction cpaConfusedSide=new ChangePictureAction(this,"confused-side");
        ChangePictureAction cpaExcitedFront=new ChangePictureAction(this,"excited-front");
        ChangePictureAction cpaExcitedSide=new ChangePictureAction(this,"excited-side");
        ChangePictureAction cpaHappyFront=new ChangePictureAction(this,"happy-front");
        ChangePictureAction cpaHappySide=new ChangePictureAction(this,"happy-side");
        ChangePictureAction cpaInterestedFront=new ChangePictureAction(this,"interested-front");
        ChangePictureAction cpaInterestedSide=new ChangePictureAction(this,"interested-side");
        ChangePictureAction cpaNeutralFront=new ChangePictureAction(this,"neutral-front");
        ChangePictureAction cpaNeutralSide=new ChangePictureAction(this,"neutral-side");
        
        /* LESSON 7 ***********************************************************/
        CurrentLessonPercept clp7=new CurrentLessonPercept(this,"7");
        NodeCountPercept ncp0=new NodeCountPercept(this,0);
        NodeCountPercept ncp1=new NodeCountPercept(this,1);
        NodeCountPercept ncp2=new NodeCountPercept(this,2,'>');
        NodeCountPercept ncp3=new NodeCountPercept(this,4,'<');
        ConnectionCountPercept ccp0=new ConnectionCountPercept(this,0);
        EvidencedConnectionCountPercept eccp0=new EvidencedConnectionCountPercept(this,0);
        ConnectionCountPercept ccp2=new ConnectionCountPercept(this,2,'<');
        IsolatedNodePercept inp1=new IsolatedNodePercept(this);
        UnevidencedEdgePercept uep1=new UnevidencedEdgePercept(this);
        
        MultipleAction ma1=new MultipleAction(this,new Action[]{cpaConcernedFront,new TextFeedbackAction(this,"For today, our goal is to make a simple model to get used to using MILA. To continue, you'll need to add at least one component to your model. Ask Gabriel if you need help with adding components.")});
        MultipleAction ma2=new MultipleAction(this,new Action[]{cpaConcernedFront,new TextFeedbackAction(this,"You've added a component, but there's nothing you can do with it by itself. To continue, you'll need to add another.")});
        MultipleAction ma3=new MultipleAction(this,new Action[]{cpaConfusedFront,new TextFeedbackAction(this,"You've added multiple components, so now you'll need to connect them together. Ask Gabriel if you need to know how to draw a connection.")});
        MultipleAction ma4=new MultipleAction(this,new Action[]{cpaConfusedFront,new TextFeedbackAction(this,"Now you've got multiple components and at least one connection. In order for that connection to be useful, though, you need to give evidence for why you think it's true. If you need help adding evidence, ask Gabriel.")});
        MultipleAction ma5=new MultipleAction(this,new Action[]{cpaHappyFront,new TextFeedbackAction(this,"Good! It looks like you've added multiple components and at least one evidenced connection. A good model for today will need at least 3 components, though, so what else do you think is significant to this system?")});
        MultipleAction ma6=new MultipleAction(this,new Action[]{cpaHappyFront,new TextFeedbackAction(this,"You have several components, but right now only one connection. What other connections can you draw?")});
        MultipleAction ma7=new MultipleAction(this,new Action[]{cpaExcitedFront,new TextFeedbackAction(this,"Your model satisfies the goals for this lesson, but there are still some improvements that can be made. It looks like there are components that are not connected to any other components. In a good model, every component is connected in some way. If you are not yet sure how this component interacts, though, it's fine to leave it unconnected for now.")});
        MultipleAction ma8=new MultipleAction(this,new Action[]{cpaExcitedFront,new TextFeedbackAction(this,"Well done! Your model is satisfactory for this lesson's goals. If you're interested, though, there are still improvements to be made. It looks like you still have connections without evidence. In a good model, every connection will have evidence.")});
        
        Mapping m1=new Mapping(new MultiplePercept(this,new Percept[]{clp7,ncp0}),ma1);
        Mapping m2=new Mapping(new MultiplePercept(this,new Percept[]{clp7,ncp1}),ma2);
        Mapping m3=new Mapping(new MultiplePercept(this,new Percept[]{clp7,ncp2,ccp0}),ma3);
        Mapping m4=new Mapping(new MultiplePercept(this,new Percept[]{clp7,ncp2,eccp0}),ma4);
        Mapping m5=new Mapping(new MultiplePercept(this,new Percept[]{clp7,ncp3}),ma5);
        Mapping m6=new Mapping(new MultiplePercept(this,new Percept[]{clp7,ccp2}),ma6);
        Mapping m7=new Mapping(new MultiplePercept(this,new Percept[]{clp7,inp1}),ma7);
        Mapping m8=new Mapping(new MultiplePercept(this,new Percept[]{clp7,uep1}),ma8);
        
        addMapping(m1);
        addMapping(m2);
        addMapping(m3);
        addMapping(m4);
        addMapping(m5);
        addMapping(m6);
        addMapping(m7);
        addMapping(m8);
        
        /* LESSON 9 ***********************************************************/
        CurrentLessonPercept clp9=new CurrentLessonPercept(this,"9");
        
        
        /* LESSON 11 **********************************************************/
        CurrentLessonPercept clp11=new CurrentLessonPercept(this,"11");
        
        
        /* LESSON 12/13 *******************************************************/
        CurrentLessonPercept clp12=new CurrentLessonPercept(this,"12");
        
        
        /* LESSON 14 **********************************************************/
        CurrentLessonPercept clp14=new CurrentLessonPercept(this,"14");
        
        
        /* LESSON 15 **********************************************************/
        CurrentLessonPercept clp15=new CurrentLessonPercept(this,"15");
        
        
        /* LESSON 16 **********************************************************/
        CurrentLessonPercept clp16=new CurrentLessonPercept(this,"16");
        
        
        /* LESSON 17 **********************************************************/
        CurrentLessonPercept clp17=new CurrentLessonPercept(this,"17");
        
        
        /* LESSON 18/19 *******************************************************/
        CurrentLessonPercept clp18=new CurrentLessonPercept(this,"18");
        
        
        /* LESSON 20 **********************************************************/
        CurrentLessonPercept clp20=new CurrentLessonPercept(this,"20");
        
        
        /* LESSON 21 **********************************************************/
        CurrentLessonPercept clp21=new CurrentLessonPercept(this,"21");
        
        
        /* LESSON 22 **********************************************************/
        CurrentLessonPercept clp22=new CurrentLessonPercept(this,"22");
        
        
        /* LESSON 23 **********************************************************/
        CurrentLessonPercept clp23=new CurrentLessonPercept(this,"23");
        
        
        /* END LESSON-SPECIFIC CONTENT ****************************************/
        
        TruePercept tp1=new TruePercept(this);
        MultipleAction ma0=new MultipleAction(this,new Action[]{cpaExcitedFront,new TextFeedbackAction(this,"Nicely done! I don't have anything to say right now, your model looks good to me for this lesson.")});
        Mapping m0=new Mapping(tp1,ma0);
        addMapping(m0);
    }
}