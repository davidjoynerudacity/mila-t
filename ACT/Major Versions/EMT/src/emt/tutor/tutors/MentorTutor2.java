/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.tutors;

import emt.ProjectModelPanel;
import emt.evexmodel.EvexEdge;
import emt.evexmodel.EvexNode;
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
    private long threshold=90000;
    
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
        
        lastFeedbackTime=new Date();
    }
    
    @Override
    public void checkMappings() {
        if(StaticVars.PROJECTOPENED&&StaticVars.TUTORSON) {
            //Construct prioritized list of possible responses
            System.out.println("Checking Mentor2 mappings...");
            ArrayList<Action> foundActions=new ArrayList<Action>();
            
            String lastActionString=StaticVars.mostRecentLog;
            String[] splitString=lastActionString.split("	");
            String command=splitString[0];

            //LESSON-SPECIFIC FEEDBACK (REMEMBER GUIDELINES)
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
                TextFeedbackAction tfaIntro9=new TextFeedbackAction(this,"That's all there is to it! I'll walk you through the first few steps. Why don't you get started by describing the phenomenon you're trying to explain in the box in the upper left? Your goal for today is to describe the phenomenon and come up with three hypotheses.");
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
            if(StaticVars.CURRENTDAY==7) {
                if(this.getPhenomenon().length()>0&&this.getModelCount('a')==0) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"Good job! It looks like you've written up a description of your phenomenon. Describing what you're trying to explain is the first step in science.");
                    tfa1.setId("GD5");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Next, try to think of some hypotheses for what might have caused your phenomenon to occur. To add a hypothesis, click Propose New Hypothesis.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                }
                if(this.getModelCount('a')>0&&this.getPhenomenon().length()>0) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"Nicely done! You've added your first hypothesis.");
                    tfa1.setId("step2");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Next, you probably want to add a node for what you're trying to explain. Click Add Component, then click on the canvas to add a new node.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                }
                if(this.getModel()!=null&&this.getModel().getNodes().size()>0) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"Good! You've added your first node. The first node should describe what you're trying to explain.");
                    tfa1.setId("step3");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Next, you probably want to add a node for what you think caused this to occur. Add another node to the model to show what you think caused this phenomenon.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                }
                if(this.getModel()!=null&&this.getModel().getNodes().size()>1) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"Well done! You should now have two nodes in your model.");
                    tfa1.setId("step4");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Now, you want to connect these two. Draw a connection from the cause to the phenomenon by clicking and dragging from the border of the cause.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                }
                if(this.getModel()!=null&&this.getModel().getEdges().size()>0) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"Good! You've now drawn a connection between your phenomenon and your hypothesized cause.");
                    tfa1.setId("step5");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Now what we want to do is explain more about how that cause caused the phenomenon. Click Insert Component, then click on this connection to add a new node between the cause and the phenomenon.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentMiscModel.getHasInserted()) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"Well done! You've successfully constructed a simple model for this hypothesis. Notice that when you insert a new node into a connection, any evidence you gave for that connection gets copied to both new connections.");
                    tfa1.setId("step6");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Now, do this for two other hypotheses as well. Then, try to make these models bigger, more detailed, and supported by with evidence by clicking on the connections. Good luck! I'll let you know if I have anything else to say.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                    myTimer.setDelay(10000);
                }
            }
            
            if(StaticVars.CURRENTDAY==9) {
                TextFeedbackAction tfa1=new TextFeedbackAction(this,"Today, your main goal is to focus on giving really solid evidence for your hypotheses. Remember, the biggest requirement of a good model is for it to be supported by lots of evidence.");
                tfa1.setId("B2T");
                TextFeedbackAction tfa2=new TextFeedbackAction(this,"Check with Gabriel the Guide if you need some tips on what the different kinds of evidence are. Remember to check with Craig the Critic if you want feedback on how good your evidence is and where your models could be improved.");
                tfa1.setNextAction(tfa2);
                tfa1.setFace(cpaHappyFrontBulb);
                foundActions.add(tfa1);
            }
            if(StaticVars.CURRENTDAY==10) {
                TextFeedbackAction tfa1=new TextFeedbackAction(this,"Today, you're using the simulations. Simulations can be fun to play around with, but remember to try to use what you observe in the simulations to support or refute your hypotheses, or to create new hypotheses.");
                tfa1.setId("BR0");
                tfa1.setFace(cpaHappyFrontBulb);
                foundActions.add(tfa1);
            }
//            if(StaticVars.CURRENTDAY==14) {
//                TextFeedbackAction tfa1=new TextFeedbackAction(this,"Today, your main goal is to focus on giving a really thorough explanation of how you think your hypotheses actually caused the phenomenon.");
//                tfa1.setId("GNB");
//                TextFeedbackAction tfa2=new TextFeedbackAction(this,"Try to have at least four or five things in each of your hypotheses by the end of the day. Feel free to add new hypotheses if any come to mind, or to dismiss ones that don't seem to be working.");
//                tfa1.setNextAction(tfa2);
//                tfa1.setFace(cpaHappyFrontBulb);
//                foundActions.add(tfa1);
//            }
            if(StaticVars.CURRENTDAY>=14) {
                TextFeedbackAction tfa1=new TextFeedbackAction(this,"Today, we're tying everything together. Using what you know, try to make one of your models really strong. Justify all your claims with evidence and give a really thorough description of your hypothesis.");
                tfa1.setId("9X9");
                TextFeedbackAction tfa2=new TextFeedbackAction(this,"Remember also to dismiss hypotheses that you don't think really worked. That's a crucial part of science, and it's something to be proud of! By the end of the day, remember to dismiss all but one of your hypotheses.");
                tfa1.setNextAction(tfa2);
                tfa1.setFace(cpaHappyFrontBulb);
                foundActions.add(tfa1);
            }
            
            if(new Date().getTime()-lastFeedbackTime.getTime()>threshold) {
                if(this.getModelCount('a')>0&&this.getPhenomenon().length()==0) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like you've started forming hypotheses, but you haven't really described the phenomenon you're addressing yet.");
                    tfa1.setId("tfa1");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"It's important to have a good idea about what you're explaining before you start forming hypotheses. Use the box in the top left to describe what you're trying to explain.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaConcernedSideBulb);
                    foundActions.add(tfa1);
                }

//                if(this.getModelCount('a')>0&&this.getModel().getNodes().isEmpty()) {
//                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see you've created a model, but you haven't put anything into it yet.");
//                    tfa1.setId("JD6");
//                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Usually the first thing to put in your model is something for what you're trying to explain. For example, maybe you're trying to explain that the Fish Population in a lake is going down, or that the Pigment Color of a Butterfly is going up.");
//                    tfa1.setNextAction(tfa2);
//                    TextFeedbackAction tfa3=new TextFeedbackAction(this,"If you need help adding things to your model, ask Gabriel the Guide.");
//                    tfa2.setNextAction(tfa3);
//                    tfa1.setFace(cpaHappyFrontBulb);
//                    foundActions.add(tfa1);
//                }

                if(this.getModel()!=null) {
                    EvexNode nodeWithoutProperty=this.getModel().getNodeWithoutProperty();
                    if(nodeWithoutProperty!=null) {
                        TextFeedbackAction tfa1=new TextFeedbackAction(this,"Hmm, it looks like you've added a component without a property.");
                        tfa1.setId("Z2K");
                        TextFeedbackAction tfa2=new TextFeedbackAction(this,"Remember, a component is the physical part of the system. What about " + nodeWithoutProperty.getName() + " is changing? Or, what is " + nodeWithoutProperty.getName() + " actually a variable of?");
                        tfa1.setNextAction(tfa2);
                        tfa1.setFace(cpaConfusedFrontBulb);
                        foundActions.add(tfa1);
                    }
                }
                if(StaticVars.currentEcologyModel.getInvisibleComponents()>0) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see that you've added something to your model that isn't visible to the human eye. Well done!");
                    tfa1.setId("BA5");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Learning to understand the role that invisible things play in ecology is one of the most important parts of life science. You're off to a great start with it!");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaExcitedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentEcologyModel.getInvisibleComponents()>3) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"You're really doing a great job of bringing invisible pieces into your model. That's crucial to understanding any ecological system. Nicely done!");
                    tfa1.setId("BA5");
                    tfa1.setFace(cpaExcitedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentEcologyModel.getInvisibleComponents()==0&&StaticVars.CURRENTDAY>10) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"It's looking to me like most of the things in your model so far are things visible to the human eye. However, invisible things can play huge roles in ecological systems, too!");
                    tfa1.setId("IGW");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Try to think about what role tiny organisms like bacteria or invisible chemicals like nitrate might play in the system.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaConcernedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentMiscModel.getGuideCount()>5) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see that you've been interacting with Gabriel a lot. I hope her information is useful!");
                    tfa1.setId("BSW");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Remember, her information changes based on what you do: as your model gets better or as your process gets deeper, the information she offers changes. Check back with her often to see if she has new ideas for you!");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentMiscModel.getCriticCount()>5) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see Craig the Critic has been giving you a lot of feedback. I hope you're finding ways to incorporate his advice!");
                    tfa1.setId("T14");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"As your model gets better and your understanding of the system gets stronger, he'll offer you deeper and more thorough feedback. With his help, your model will keep getting stronger and stronger over time.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentMiscModel.getGuideCount()<6&&StaticVars.CURRENTDAY>=10) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like you haven't been chatting with Gabriel very often. You might not need her help, but remember that the information she offers changes based on what you do. Check back with her regularly to see if she has new or useful information for you.");
                    tfa1.setId("ETU");
                    tfa1.setFace(cpaConcernedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentMiscModel.getCriticCount()<6&&StaticVars.CURRENTDAY>=10) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like you haven't been chatting with Craig very often. Remember to check with him to get feedback on potential problems with your model or places it could get stronger.");
                    tfa1.setId("074");
                    tfa1.setFace(cpaConcernedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentMiscModel.getSimulationCount()>4) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"You've been using the simulations quite a bit. That's great! Don't forget to add what you learn from the simulations into your model!");
                    tfa1.setId("000");
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentMiscModel.getSimulationCount()<5&&StaticVars.CURRENTDAY==15) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like you haven't been using the simulations all that much. Maybe you haven't had time to, and that's fine -- just remember they're there if you need them!");
                    tfa1.setId("001");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"The simulation of Oxygen Depletion is really useful in this situation, so see if you can use it to figure out some more information for your model.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaConcernedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentMiscModel.getNoteCount()>2) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"You've used your notepad a lot. That's a great idea! It's a good place to sort out your thoughts before trying to put them in your model.");
                    tfa1.setId("N01");
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentMiscModel.getNoteCount()<3&&StaticVars.CURRENTDAY>=13) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like you haven't been using your notepad much.");
                    tfa1.setId("N02");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Sometimes it's not clear how new information should be added to your model, like when you're doing an experiment or using a simulation. Try to take notes on these kinds of things and then use those notes to figure out how to improve your model.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaConcernedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.CURRENTDAY==9) {
                    ArrayList<String> typesOfEvidenceUsed=this.getModel().getTypesOfEvidenceUsed();
                    if(typesOfEvidenceUsed.contains("Direct Observation")) {
                        TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see you've added a Direct Observation as evidence to your model.");
                        tfa1.setId("002");
                        TextFeedbackAction tfa2=new TextFeedbackAction(this,"Observations are always the best place to start. Now, see if you can find some even better evidence for this part of your model.");
                        tfa1.setNextAction(tfa2);
                        tfa1.setFace(cpaHappyFrontBulb);
                        foundActions.add(tfa1);
                    }
                    if(typesOfEvidenceUsed.contains("Similar System Observation")){
                        TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see you've added a Similar System Observation as evidence to your model.");
                        tfa1.setId("003");
                        TextFeedbackAction tfa2=new TextFeedbackAction(this,"Observations from similar systems are great pieces of evidence as long as you can be sure that your system is similar. Can you be sure about that?");
                        tfa1.setNextAction(tfa2);
                        tfa1.setFace(cpaHappyFrontBulb);
                        foundActions.add(tfa1);
    //                } else if(typesOfEvidenceUsed.contains("Controlled Experiment")){
    //                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see you've added a Controlled Experiment as evidence to your model.");
    //                    tfa1.setId("004");
    //                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"Controlled experiments are the best form of evidence, but they can be really hard to get in ecology. How did you do a controlled experiment here?");
    //                    tfa1.setNextAction(tfa2);
    //                    tfa1.setFace(cpaHappyFrontBulb);
    //                    foundActions.add(tfa1);
                    }
                    if(typesOfEvidenceUsed.contains("Expert Information")){
                        TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see you've added some Expert Information as evidence to your model.");
                        tfa1.setId("005");
                        TextFeedbackAction tfa2=new TextFeedbackAction(this,"Expert Information is a great source of information. Your goal is to be an expert, too -- how can you move from repeating experts to being an expert?");
                        tfa1.setNextAction(tfa2);
                        tfa1.setFace(cpaExcitedFrontBulb);
                        foundActions.add(tfa1);                    
                    }
                    if(typesOfEvidenceUsed.contains("Simulation Observation")){
                        TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see you've added a Simulation Observation as evidence to your model.");
                        tfa1.setId("006");
                        TextFeedbackAction tfa2=new TextFeedbackAction(this,"Simulations are really good pieces of evidence, but you have to assume they're accurate versions of the system. Can you be sure about that?");
                        tfa1.setNextAction(tfa2);
                        tfa1.setFace(cpaHappyFrontBulb);
                        foundActions.add(tfa1);                    
                    } 
                    if(typesOfEvidenceUsed.contains("Non-Expert Information")){
                        TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see you've added some Non-Expert Information as evidence to your model.");
                        tfa1.setId("007");
                        TextFeedbackAction tfa2=new TextFeedbackAction(this,"Evidence from non-expert is a good place to start because it lets you know what to investigate. Now, how can you find some even stronger evidence for your model?");
                        tfa1.setNextAction(tfa2);
                        tfa1.setFace(cpaConcernedFrontBulb);
                        foundActions.add(tfa1);
                    } 
                    if(typesOfEvidenceUsed.contains("Logical Explanation")){
                        TextFeedbackAction tfa1=new TextFeedbackAction(this,"I see you've added a Logical Explanation as evidence to your model.");
                        tfa1.setId("008");
                        TextFeedbackAction tfa2=new TextFeedbackAction(this,"It's good to start with a logical explanation of your system, but what you think is logical might not be logical to something else. How can you convince someone that your explanation is true?");
                        tfa1.setNextAction(tfa2);
                        tfa1.setFace(cpaConcernedFrontBulb);
                        foundActions.add(tfa1);
                    }
                }
                ArrayList<EvexEdge> strongEvidenceEdges=this.getModel().getEdgesByMinScore(4);
                if(strongEvidenceEdges.size()>0) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"Nicely done! You've added some really strong evidence to your connection between " + strongEvidenceEdges.get(0).getDirectedSource().toString() + " and " + strongEvidenceEdges.get(0).getDirectedDest().toString() + ".");
                    tfa1.setId("009");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"You're well on your way to constructing a strong model with lots of evidence.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaAmazedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(strongEvidenceEdges.size()>2) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"Your model is getting really, really strong. I can see that several of your connections are justified with really nice evidence. Well done!");
                    tfa1.setId("010");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"If you want to know how to make your model even better, check with Craig the Critic.");
                    tfa1.setNextAction(tfa2);
                    tfa1.setFace(cpaAmazedFrontBulb);
                    foundActions.add(tfa1);
                }
                
                //STUDENT MODEL REACTIONS
                if(StaticVars.currentInquiryModel.getEvidenceBreadth().size()>3) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"I can see that you've started to use a few different kinds of evidence in your models. That's great! A variety of evidence can help you make a strong case for your model. It's like having lots of witnesses that an event actually occurred!");
                    TextFeedbackAction tfa2=new TextFeedbackAction(this,"I can see that you've started to use a few different kinds of evidence in your models. That's great! A variety of evidence can help you make a strong case for your model. It's like having lots of witnesses that an event actually occurred!");
                    tfa1.setNextAction(tfa2);
                    tfa1.setId("011B");
                    tfa1.setFace(cpaHappyFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentInquiryModel.getEvidenceBreadth().size()>5) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"Wow! You've used almost every kind of evidence we have. You're doing a great job of using a lot of different sources to defend your models.");
                    tfa1.setId("012");
                    tfa1.setFace(cpaExcitedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentInquiryModel.getEvidenceStrength()>4) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"Nicely done! I can tell you're using some very strong evidence to defend your model. Keep up the good work!");
                    tfa1.setId("OZC");
                    tfa1.setFace(cpaExcitedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentInquiryModel.getAdvancedLevel()>8&&StaticVars.CURRENTDAY>=13) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"You've come a long way since we started! You're showing some real ability with scientific inquiry. You ought to think about a career as a scientist!");
                    tfa1.setId("OZC");
                    tfa1.setFace(cpaAmazedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentModelingModel.getIntermediateLevel()>8&&StaticVars.CURRENTDAY>=13) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"You're getting to be a really strong modeler -- your models are large and complex, which means they have a lot more potential to describe complicated systems. Nicely done!");
                    tfa1.setId("Q3Z");
                    tfa1.setFace(cpaAmazedFrontBulb);
                    foundActions.add(tfa1);
                }
                if(StaticVars.currentModelingModel.getAdvancedLevel()>8&&StaticVars.currentModelingModel.getIntermediateLevel()>8&&StaticVars.CURRENTDAY>=13) {
                    TextFeedbackAction tfa1=new TextFeedbackAction(this,"You're doing an excellent job of modeling this system! Your skills have really come along. Scientific modeling like this is exactly what scientists do every day. You've shown that you have what it takes!");
                    tfa1.setId("Q3Z");
                    tfa1.setFace(cpaAmazedFrontBulb);
                    foundActions.add(tfa1);
                }
                

                //Iterate through responses and give the first one that hasn't been given already

                } else {
                System.out.println("Skipping Mentor check due to threshold");
            }

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
        }
    }
    
}