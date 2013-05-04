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
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author David
 */
public class InterviewerTutor extends InterruptTutor implements ActionListener {
    private long threshold=15000;
    
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
    
        MultipleAction nullMA=new MultipleAction(this);
        nullMA.addAction(cpaNeutralSide);
        TextFeedbackAction nullTFA=new TextFeedbackAction(this,"I don't have anything to ask right now.");
        nullTFA.setLogThis(false);
        nullMA.addAction(nullTFA);
        myNullAction=nullMA;
    }
    
    @Override
    public void checkMappings() {
        if(StaticVars.PROJECTOPENED) {
            if(lastFeedbackTime==null||new Date().getTime()-lastFeedbackTime.getTime()>threshold) {
                System.out.println("Checking Interviewer mappings...");
                ArrayList<Action> foundActions=new ArrayList<Action>();

                String lastActionString=StaticVars.mostRecentLog;
                String[] splitString=lastActionString.split("	");
                System.out.println("Interviewer's line: " + lastActionString);
                String command=splitString[0];

                if(command.equals("Model Dismissed")) {
                    FeedbackPromptAction fpa1=new FeedbackPromptAction(this);
                    fpa1.setPrompt("What made you want to dismiss that hypothesis?");
                    //fpa1.setId("fpa1");
                    fpa1.setFace(cpaInterestedFrontBulb);
                    foundActions.add(fpa1);
                }
                if(command.equals("Model Reconsidered")) {
                    FeedbackPromptAction fpa2=new FeedbackPromptAction(this);
                    fpa2.setPrompt("What made you reconsider that hypothesis?");
                    fpa2.setFace(cpaHappyFrontBulb);
                    foundActions.add(fpa2);
                }
                //ask about a newly-created model if it's created on a later day
                //ask about model dismissal specifically on an early day
                //clarify 'other' evidence
                //general request for thoughts on later days (delay until later in the lesson?)

                //Iterate through responses and give the first one that hasn't been given already
                Action doAction=null;
                for(Action action : foundActions) {
                    if(!StaticVars.usedActions.contains(action.getId())) {
                        doAction=action;
                        break;
                    }
                }
                if(doAction!=null) {
                    MultipleAction finalMA=new MultipleAction(this);
                    finalMA.addAction(doAction);
                    finalMA.addAction(new FocusTutorAction(this));
                    if(doAction.getFace()!=null) {
                        finalMA.addAction(doAction.getFace());
                    }
                    finalMA.doAction();
                    //setLastFeedbackTime(new Date());
                } else {
                    //this.getNullAction().doAction();
                }

                //Set timer for how long to wait before giving feedback again
            } else {
                System.out.println("Skipping Interviewer check due to threshold");
            }
        }
    }
}
