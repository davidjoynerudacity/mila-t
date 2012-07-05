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
        
        /* LESSON 7 ***********************************************************/
        CurrentLessonPercept clp7=new CurrentLessonPercept(this,"7");
        addImage("critic-happy-front", "u-happy-front.jpg");
        addImage("interviewer-happy-front", "s-happy-front.jpg");
        addImage("guide-happy-front", "j-happy-front.jpg");
        ChangePictureAction cpaCriticHappyFront=new ChangePictureAction(this,"critic-happy-front");
        ChangePictureAction cpaGuideHappyFront=new ChangePictureAction(this,"guide-happy-front");
        ChangePictureAction cpaInterviewerHappyFront=new ChangePictureAction(this,"interviewer-happy-front");
        
        MultipleAction ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction tfa1=new TextFeedbackAction(this,"Hi! Welcome to MILA! Before you start, I'd like to take a second to introduce you to four people that are going to help you build models and investigate systems with MILA.");
        ma1.addAction(tfa1);
        ma1.addAction(new ShowTutorAction(this));
        
        MultipleAction ma2=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction tfa2=new TextFeedbackAction(this,"First of all, I'm Mercer. I'll be your Mentor. As you interact with MILA, I'll be observing what you do. If I see you have a great idea or suggest something that I know science supports, I'll pop up and let you know!");
        ma2.addAction(tfa2);
        tfa1.setNextAction(ma2);
        
        MultipleAction ma3=new MultipleAction(this,new Action[]{cpaGuideHappyFront});
        TextFeedbackAction tfa3=new TextFeedbackAction(this,"Hi! I'm Gabriel! I'll be your Guide. Whenever you have any questions, you can click on me and I'll do my best to give you an answer!");
        ma3.addAction(tfa3);
        tfa2.setNextAction(ma3);
        
        MultipleAction ma4=new MultipleAction(this,new Action[]{cpaCriticHappyFront});
        TextFeedbackAction tfa4=new TextFeedbackAction(this,"I'm Craig, and I'll be your Critic. My job is to look at the models you create and let you know what needs to be improved. When you're not sure what else to improve on or when you think your model is satisfactory, click me and I'll check on it.");
        ma4.addAction(tfa4);
        tfa3.setNextAction(ma4);
        
        MultipleAction ma5=new MultipleAction(this,new Action[]{cpaInterviewerHappyFront});
        TextFeedbackAction tfa5=new TextFeedbackAction(this,"Hello! I'm Isla! I'll be your Interviewer. While you use MILA, I might pop up sometimes to ask you for a little more information on what you're thinking or doing. I might also ask about what you learned on field trips or stuff like that. When I ask a question, just type in your answer to let me know!");
        ma5.addAction(tfa5);
        tfa4.setNextAction(ma5);
        
        MultipleAction ma6=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction tfa6=new TextFeedbackAction(this,"The four of us will always be sitting in that box on the lower left side of the program. You can use the arrow buttons to switch between us. Gabriel and Craig, your Guide and Critic, will only say something if you click them. If you have questions, click Gabriel the Guide, and if you want feedback on your model, click Craig the Critic.");
        ma6.addAction(tfa6);
        tfa5.setNextAction(ma6);
        
        MultipleAction ma7=new MultipleAction(this,new Action[]{cpaHappyFrontBulb});
        TextFeedbackAction tfa7=new TextFeedbackAction(this,"Isla the Interviewer and I, though, will sometimes interrupt you to either give you some information or to ask you a question. If you see us appear with this lightbulb icon, you'll know we have something we want to say or ask you. Just click on us to bring it up.");
        ma7.addAction(tfa7);
        tfa6.setNextAction(ma7);
        
        MultipleAction ma8=new MultipleAction(this,new Action[]{cpaHappyFrontBulb});
        TextFeedbackAction tfa8=new TextFeedbackAction(this,"That's all there is to it! At the start of each day, I'll appear to let you know what we'll be working on that day. For today, focus on how to make models in MILA. When you think you've constructed a good model, click Craig the Critic to have him check it. If you need help on creating models, click Gabriel the Guide.");
        ma7.addAction(tfa7);
        tfa6.setNextAction(ma7);
        
        MultiplePercept mp1=new MultiplePercept(this);
        mp1.addPercept(clp7);
        mp1.addPercept(new UnreadTextFeedbackPercept(this,tfa1)); 
        addMapping(new Mapping(mp1,ma1));
        
        
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
        TextFeedbackAction tfa0=new TextFeedbackAction(this,"I don't really have anything to say right now.");
        Mapping m1=new Mapping(tp1,new MultipleAction(this,new Action[]{cpaNeutralSide,tfa0}));
        addMapping(m1);
    }
}