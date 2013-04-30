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
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.Timer;
/**
 *
 * @author David
 */
public class MentorTutor2 extends InterruptTutor {
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
    ChangePictureAction cpaAmazedFrontBulb=new ChangePictureAction(this,"amazed-front-bulb");
    ChangePictureAction cpaAmazedSideBulb=new ChangePictureAction(this,"amazed-side-bulb");
    ChangePictureAction cpaConcernedFrontBulb=new ChangePictureAction(this,"concerned-front-bulb");
    ChangePictureAction cpaConcernedSideBulb=new ChangePictureAction(this,"concerned-side-bulb");
    ChangePictureAction cpaConfusedFrontBulb=new ChangePictureAction(this,"confused-front-bulb");
    ChangePictureAction cpaConfusedSideBulb=new ChangePictureAction(this,"confused-side-bulb");
    ChangePictureAction cpaExcitedFrontBulb=new ChangePictureAction(this,"excited-front-bulb");
    ChangePictureAction cpaExcitedSideBulb=new ChangePictureAction(this,"excited-side-bulb");
    ChangePictureAction cpaHappyFrontBulb=new ChangePictureAction(this,"happy-front-bulb");
    ChangePictureAction cpaHappySideBulb=new ChangePictureAction(this,"happy-side-bulb");
    ChangePictureAction cpaInterestedFrontBulb=new ChangePictureAction(this,"interested-front-bulb");
    ChangePictureAction cpaInterestedSideBulb=new ChangePictureAction(this,"interested-side-bulb");
    ChangePictureAction cpaNeutralFrontBulb=new ChangePictureAction(this,"neutral-front-bulb");
    ChangePictureAction cpaNeutralSideBulb=new ChangePictureAction(this,"neutral-side-bulb");
    
    public MentorTutor2() {
        super("Mentor");
        initializeTutor();
    }

    public MentorTutor2(ProjectModelPanel modelPanel) {
        super("Mentor",modelPanel);
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("amazed-front", "a-amazed-front.jpg");
        addImage("amazed-side", "a-amazed-side.jpg");
        addImage("concerned-front", "a-concerned-front.jpg");
        addImage("concerned-side", "a-concerned-side.jpg");
        addImage("confused-front", "a-confused-front.jpg");
        addImage("confused-side", "a-confused-side.jpg");
        addImage("excited-front", "a-excited-front.jpg");
        addImage("excited-side", "a-excited-side.jpg");
        addImage("happy-front", "a-happy-front.jpg");
        addImage("happy-side", "a-happy-side.jpg");
        addImage("interested-front", "a-interested-front.jpg");
        addImage("interested-side", "a-interested-side.jpg");
        addImage("neutral-front", "a-neutral-front.jpg");
        addImage("neutral-side", "a-neutral-side.jpg");
        addImage("amazed-front-bulb", "a-amazed-front.png");
        addImage("amazed-side-bulb", "a-amazed-side.png");
        addImage("concerned-front-bulb", "a-concerned-front.png");
        addImage("concerned-side-bulb", "a-concerned-side.png");
        addImage("confused-front-bulb", "a-confused-front.png");
        addImage("confused-side-bulb", "a-confused-side.png");
        addImage("excited-front-bulb", "a-excited-front.png");
        addImage("excited-side-bulb", "a-excited-side.png");
        addImage("happy-front-bulb", "a-happy-front.png");
        addImage("happy-side-bulb", "a-happy-side.png");
        addImage("interested-front-bulb", "a-interested-front.png");
        addImage("interested-side-bulb", "a-interested-side.png");
        addImage("neutral-front-bulb", "a-neutral-front.png");
        addImage("neutral-side-bulb", "a-neutral-side.png");
        
        
        
        /* END LESSON-SPECIFIC CONTENT ****************************************/
        
        TruePercept tp1=new TruePercept(this);
        TextFeedbackAction tfa0=new TextFeedbackAction(this,"I don't really have anything to say right now.");
        tfa0.setLogThis(false);
        Mapping m1=new Mapping(tp1,new MultipleAction(this,new Action[]{cpaNeutralSide,tfa0}));
        addMapping(m1);
    }
    
    @Override
    public void checkMappings() {
        //Construct prioritized list of possible responses
        System.out.println("Checking Mentor2 mappings...");
        ArrayList<Action> foundActions=new ArrayList<Action>();
        
        if(this.getModelCount('a')>0&&this.getPhenomenon().length()==0) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like you've started forming hypotheses, but you haven't really described the phenomenon you're addressing yet.");
            tfa1.setId("tfa1");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"It's important to have a good idea about what you're explaining before you start forming hypotheses. Use the box in the top left to describe what you're trying to explain.");
            tfa1.setNextAction(tfa2);
            MultipleAction ma1=new MultipleAction(this);
            ma1.addAction(tfa1);
            ma1.addAction(cpaConcernedSideBulb);
            ma1.addAction(new FocusTutorAction(this));
            ma1.setId("tfa1");
            foundActions.add(ma1);
        }
        
        //Iterate through responses and give the first one that hasn't been given already
        Action doAction=null;
        for(Action action : foundActions) {
            if(!StaticVars.usedActions.contains(action.getId())) {
                doAction=action;
                break;
            }
        }
        if(doAction!=null) {
            doAction.doAction();
        } else {
            TextFeedbackAction nullFeedback=new TextFeedbackAction(this,"I don't really have anything to say right now.");
            MultipleAction nullMA=new MultipleAction(this);
            nullMA.addAction(nullFeedback);
            nullMA.addAction(cpaNeutralSide);
            nullMA.doAction();
        }
        
        //Set timer for how long to wait before giving feedback again
    }
    
}