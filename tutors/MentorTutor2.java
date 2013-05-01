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
import java.util.Date;
import javax.swing.Timer;
/**
 *
 * @author David
 */
public class MentorTutor2 extends InterruptTutor {
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
    
    ChangePictureAction cpaGuidePreview=new ChangePictureAction(this,"guide-preview");
    ChangePictureAction cpaCriticPreview=new ChangePictureAction(this,"critic-preview");
    ChangePictureAction cpaInterviewerPreview=new ChangePictureAction(this,"interviewer-preview");
    
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
        
        addImage("guide-preview","j-neutral-front.jpg");
        addImage("interviewer-preview","s-neutral-front.jpg");
        addImage("critic-preview","u-neutral-front.jpg");
        
        MultipleAction nullMA=new MultipleAction(this);
        nullMA.addAction(cpaNeutralSide);
        TextFeedbackAction nullTFA=new TextFeedbackAction(this,"I don't really have anything to say right now.");
        nullTFA.setLogThis(false);
        nullMA.addAction(nullTFA);
        myNullAction=nullMA;
        
        /* END LESSON-SPECIFIC CONTENT ****************************************/
    }
    
    @Override
    public void checkMappings() {
        //Construct prioritized list of possible responses
        if(lastFeedbackTime==null||new Date().getTime()-lastFeedbackTime.getTime()>threshold) {
            System.out.println("Checking Mentor2 mappings...");
            ArrayList<Action> foundActions=new ArrayList<Action>();
            if(!StaticVars.usedActions.contains("tfaIntro1")) {
                TextFeedbackAction tfaIntro1=new TextFeedbackAction(this,"Hi! Welcome to MILA, the Modeling & Inquiry Learning Application. I'm Mercer, and I'd like to introduce you to the program real quick. Press the 'Next' button below to continue.");
                tfaIntro1.setFace(cpaHappyFront);
                TextFeedbackAction tfaIntro2=new TextFeedbackAction(this,"The goal of MILA is to let you do science the way scientists do it. You'll investigate a phenomenon, create a model of it, and use that model to tell you how to investigate the phenomenon more.");
                TextFeedbackAction tfaIntro3=new TextFeedbackAction(this,"A few friends of mine are here to help you. First, I'm Mercer, your Mentor. I'll interrupt you when I have some advice or information to share.");
                TextFeedbackAction tfaIntro4=new TextFeedbackAction(this,"When you see this light bulb, it means I have something to tell you. Just click on me to read what I have to say!");
                tfaIntro4.setFace(cpaInterestedFrontBulb);
                TextFeedbackAction tfaIntro5=new TextFeedbackAction(this,"This is Gabriel, the Guide. She's here to answer your questions. When you have a question, click on Gabriel to see what questions she's ready to answer.");
                tfaIntro5.setFace(cpaGuidePreview);
                TextFeedbackAction tfaIntro6=new TextFeedbackAction(this,"This is Craig, the Critic. He's here to take a closer look at your models. When you think your model is done, or when you are not sure how to make it better, click him to get some advice.");
                tfaIntro6.setFace(cpaCriticPreview);
                TextFeedbackAction tfaIntro7=new TextFeedbackAction(this,"This is Isla, the Interviewer. Sometimes, she'll ask you questions. When she does, just type your response in her box.");
                tfaIntro7.setFace(cpaInterviewerPreview);
                TextFeedbackAction tfaIntro8=new TextFeedbackAction(this,"Isla and I will occasionally interrupt you, while Gabriel and Craig are there for you to talk to when you need it. Remember, we all react to what you do in the software, so check with us often!");
                tfaIntro8.setFace(cpaHappyFront);
                TextFeedbackAction tfaIntro9=new TextFeedbackAction(this,"That's all there is to it! Why don't you get started by describing the phenomenon you're trying to explain in the box in the upper left?");
                tfaIntro9.setFace(cpaHappyFront);
                tfaIntro1.setNextAction(tfaIntro2);
                tfaIntro2.setNextAction(tfaIntro3);
                tfaIntro3.setNextAction(tfaIntro4);
                tfaIntro4.setNextAction(tfaIntro5);
                tfaIntro5.setNextAction(tfaIntro6);
                tfaIntro6.setNextAction(tfaIntro7);
                tfaIntro7.setNextAction(tfaIntro8);
                tfaIntro8.setNextAction(tfaIntro9);
                tfaIntro1.setId("tfaIntro1");
                MultipleAction ma1=new MultipleAction(this);
                ma1.addAction(tfaIntro1);
                ma1.addAction(new ShowTutorAction(this));
                ma1.setId("tfa1");
                foundActions.add(ma1);
            }
           

            if(this.getModelCount('a')>0&&this.getPhenomenon().length()==0) {
                TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like you've started forming hypotheses, but you haven't really described the phenomenon you're addressing yet.");
                tfa1.setId("tfa1");
                TextFeedbackAction tfa2=new TextFeedbackAction(this,"It's important to have a good idea about what you're explaining before you start forming hypotheses. Use the box in the top left to describe what you're trying to explain.");
                tfa1.setNextAction(tfa2);
                tfa1.setFace(cpaConcernedSideBulb);
                foundActions.add(tfa1);
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
                MultipleAction finalMA=new MultipleAction(this);
                finalMA.addAction(doAction);
                finalMA.addAction(new FocusTutorAction(this));
                if(doAction.getFace()!=null) {
                    finalMA.addAction(doAction.getFace());
                }
                finalMA.doAction();
                //setLastFeedbackTime(new Date());
            } else {
                this.getNullAction().doAction();
            }

            //Set timer for how long to wait before giving feedback again
        } else {
            System.out.println("Skipping Mentor check due to threshold");
        }
    }
    
}