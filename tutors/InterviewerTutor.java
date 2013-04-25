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
import java.awt.event.ActionListener;
/**
 *
 * @author David
 */
public class InterviewerTutor extends InterruptTutor implements ActionListener {
    public InterviewerTutor() {
        super("Interviewer");
        initializeTutor();
    }

    public InterviewerTutor(ProjectModelPanel modelPanel) {
        super("Interviewer",modelPanel);
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("amazed-front", "s-amazed-front.jpg");
        addImage("amazed-side", "s-amazed-side.jpg");
        addImage("concerned-front", "s-concerned-front.jpg");
        addImage("concerned-side", "s-concerned-side.jpg");
        addImage("confused-front", "s-confused-front.jpg");
        addImage("confused-side", "s-confused-side.jpg");
        addImage("excited-front", "s-excited-front.jpg");
        addImage("excited-side", "s-excited-side.jpg");
        addImage("happy-front", "s-happy-front.jpg");
        addImage("happy-side", "s-happy-side.jpg");
        addImage("interested-front", "s-interested-front.jpg");
        addImage("interested-side", "s-interested-side.jpg");
        addImage("neutral-front", "s-neutral-front.jpg");
        addImage("neutral-side", "s-neutral-side.jpg");
        addImage("amazed-front-bulb", "s-amazed-front.png");
        addImage("amazed-side-bulb", "s-amazed-side.png");
        addImage("concerned-front-bulb", "s-concerned-front.png");
        addImage("concerned-side-bulb", "s-concerned-side.png");
        addImage("confused-front-bulb", "s-confused-front.png");
        addImage("confused-side-bulb", "s-confused-side.png");
        addImage("excited-front-bulb", "s-excited-front.png");
        addImage("excited-side-bulb", "s-excited-side.png");
        addImage("happy-front-bulb", "s-happy-front.png");
        addImage("happy-side-bulb", "s-happy-side.png");
        addImage("interested-front-bulb", "s-interested-front.png");
        addImage("interested-side-bulb", "s-interested-side.png");
        addImage("neutral-front-bulb", "s-neutral-front.png");
        addImage("neutral-side-bulb", "s-neutral-side.png");
    
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
        
        TruePercept tp1=new TruePercept(this);
        TextFeedbackAction tfa1=new TextFeedbackAction(this,"I don't really have anything to say right now.");
        tfa1.setLogThis(false);
        Mapping m1=new Mapping(tp1,new MultipleAction(this,new Action[]{cpaNeutralSide,tfa1}));
        addMapping(m1);
    }
}
