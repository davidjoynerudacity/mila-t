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
        
        MultipleAction ma8=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction tfa8=new TextFeedbackAction(this,"When you're done with what one of us has to say, just click the hide button in the bottom right to hide us. You can always bring us back up by clicking on our faces to the left.");
        ma8.addAction(tfa8);
        tfa7.setNextAction(ma8);
        
        MultipleAction ma9=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction tfa9=new TextFeedbackAction(this,"That's all there is to it! At the start of each day, I'll appear to let you know what we'll be working on that day. For today, focus on how to make models in MILA. When you think you've constructed a good model, click Craig the Critic to have him check it. If you need help on creating models, click Gabriel the Guide.");
        ma9.addAction(tfa9);
        tfa8.setNextAction(ma9);
        
        MultiplePercept mp1=new MultiplePercept(this);
        mp1.addPercept(clp7);
        mp1.addPercept(new UnreadTextFeedbackPercept(this,tfa1)); 
        addMapping(new Mapping(mp1,ma1));
        
        
        /* LESSON 9 ***********************************************************/
        CurrentLessonPercept clp9=new CurrentLessonPercept(this,"9");
        
        MultipleAction l9ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l9tfa1=new TextFeedbackAction(this,"Hey! Welcome to today's lesson. Today, your goal is going to be to come up with at least two different hypotheses for what might be causing the death of the fish in Lake Clara Meer.");
        l9ma1.addAction(l9tfa1);
        l9ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l9ma2=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l9tfa2=new TextFeedbackAction(this,"Try to think of different things that you suspect might have caused the fish to die off. Then, create a model for each idea you have. You should end up with at least three models -- one for each possible cause you can think of.");
        l9ma2.addAction(l9tfa2);
        l9tfa1.setNextAction(l9ma2); 
        
        MultipleAction l9ma3=new MultipleAction(this,new Action[]{cpaConcernedFront});
        TextFeedbackAction l9tfa3=new TextFeedbackAction(this,"Remember, you're explaining a new problem now, so you should have started a new project for this. If you're still working in your Aquarium project, go ahead and click File, select New Project, and create a new project called Fish Die-off.");
        l9ma3.addAction(l9tfa3);
        l9tfa2.setNextAction(l9ma3); 
        
        MultiplePercept l9mp1=new MultiplePercept(this);
        l9mp1.addPercept(clp9);
        l9mp1.addPercept(new UnreadTextFeedbackPercept(this,l9tfa1));
        addMapping(new Mapping(l9mp1,l9ma1));
        
        /* LESSON 11 **********************************************************/
        CurrentLessonPercept clp11=new CurrentLessonPercept(this,"11");
        
        MultipleAction l11ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l11tfa1=new TextFeedbackAction(this,"Hey! Welcome to today's lesson. You just got back from Lake Clara Meer, gathering information and exploring what could have caused the problem. Your goal now is to revise your models based on that information.");
        l11ma1.addAction(l11tfa1);
        l11ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l11ma2=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l11tfa2=new TextFeedbackAction(this,"This is an important part of the process of conducting science: you had models of what you think happened, and those models told you what to look for. Now, you've gotten more information, so it's time to put that information into the model.");
        l11ma2.addAction(l11tfa2);
        l11tfa1.setNextAction(l11ma2); 
        
        MultipleAction l11ma3=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l11tfa3=new TextFeedbackAction(this,"All of science is like this: you take what you know, and use it to figure out what information you need. Then, you obtain that information and put it into your model so that you can figure out the next thing you need.");
        l11ma3.addAction(l11tfa3);
        l11tfa2.setNextAction(l11ma3); 
        
        MultipleAction l11ma4=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l11tfa4=new TextFeedbackAction(this,"You're doing science the way scientists do it now. Throughout the camp, try to think about how you're gathering information to better explain the fish die-off, and then using that information to know what more you need to research.");
        l11ma4.addAction(l11tfa4);
        l11tfa3.setNextAction(l11ma4); 
        
        MultipleAction l11ma5=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l11tfa5=new TextFeedbackAction(this,"For today, try to add more information into your earlier hypotheses, and try also to come up with some new hypotheses based on what you learned at the lake. Try to have at least five hypotheses by the end of this lesson, including your three from earlier.");
        l11ma5.addAction(l11tfa5);
        l11tfa4.setNextAction(l11ma5); 
        
        MultiplePercept l11mp1=new MultiplePercept(this);
        l11mp1.addPercept(clp11);
        l11mp1.addPercept(new UnreadTextFeedbackPercept(this,l11tfa1));
        addMapping(new Mapping(l11mp1,l11ma1));
        
        
        /* LESSON 12/13 *******************************************************/
        CurrentLessonPercept clp12=new CurrentLessonPercept(this,"12");
        
        MultipleAction l12ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l12tfa1=new TextFeedbackAction(this,"Today you learned about acids and bases. Could that have had something to do with why the fish died? Try to think of ways these things might have impacted the lake.");
        l12ma1.addAction(l12tfa1);
        l12ma1.addAction(new ShowTutorAction(this)); 
        
        MultiplePercept l12mp1=new MultiplePercept(this);
        l12mp1.addPercept(clp12);
        l12mp1.addPercept(new UnreadTextFeedbackPercept(this,l12tfa1));
        addMapping(new Mapping(l12mp1,l12ma1));
        
        
        /* LESSON 14 **********************************************************/
        CurrentLessonPercept clp14=new CurrentLessonPercept(this,"14");
        
        MultipleAction l14ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l14tfa1=new TextFeedbackAction(this,"In this lesson, you'll be introduced to NetLogo simulations. Simulations are powerful tools generated by scientists and experts that allow us to experiment with simulated systems and see how they work under different conditions.");
        l14ma1.addAction(l14tfa1);
        l14ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l14ma2=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l14tfa2=new TextFeedbackAction(this,"Try to think of the NetLogo simulation as a stand-in for the real system. You can't change how many fish or plants are in a lake, and you can't easily watch the lake for years at a time. With these simulations, though, you can simulate years at a time to see how different events change.");
        l14ma2.addAction(l14tfa2);
        l14tfa1.setNextAction(l14ma2); 
        
        MultipleAction l14ma3=new MultipleAction(this,new Action[]{cpaExcitedFront});
        TextFeedbackAction l14tfa3=new TextFeedbackAction(this,"Scientists use simulations in lots of ways. They use simulations to try to predict what will happen in the future, or understand what happened in the past. If you can make a simulation mimic what happened in the lake, you can use that as evidence in constructing a model of what caused the die-off.");
        l14ma3.addAction(l14tfa3);
        l14tfa2.setNextAction(l14ma3); 
        
        MultipleAction l14ma4=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l14tfa4=new TextFeedbackAction(this,"While you use the simulations, try to think of ways you could use them that would help your models. Is there anything in your models you could test with the simulations?");
        l14ma4.addAction(l14tfa4);
        l14tfa3.setNextAction(l14ma4); 
        
        MultiplePercept l14mp1=new MultiplePercept(this);
        l14mp1.addPercept(clp14);
        l14mp1.addPercept(new UnreadTextFeedbackPercept(this,l14tfa1));
        addMapping(new Mapping(l14mp1,l14ma1));
        
        
        /* LESSON 15 **********************************************************/
        CurrentLessonPercept clp15=new CurrentLessonPercept(this,"15");
        
        MultipleAction l15ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l15tfa1=new TextFeedbackAction(this,"In this lesson, you'll be looking at the different food sources that exist for fish.");
        l15ma1.addAction(l15tfa1);
        l15ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l15ma2=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l15tfa2=new TextFeedbackAction(this,"One of the things that's important to understand about food sources is that every living thing has a food source of its own, and is a food source for something else. That's the food chain, and anything that affects one part of the chain affects everything.");
        l15ma2.addAction(l15tfa2);
        l15tfa1.setNextAction(l15ma2); 
        
        MultipleAction l15ma3=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l15tfa3=new TextFeedbackAction(this,"So, something to think about is whether the fish died because something happened to their food source. What do fish eat, and what could have happened to their food?");
        l15ma3.addAction(l15tfa3);
        l15tfa2.setNextAction(l15ma3); 
        
        MultipleAction l15ma4=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l15tfa4=new TextFeedbackAction(this,"If you've already made hypotheses that look at food, that's great! Try to use the information you learn today to build up those models. If you haven't, try to think of a hypothesis or two that might involve food.");
        l15ma4.addAction(l15tfa4);
        l15tfa3.setNextAction(l15ma4); 
        
        MultiplePercept l15mp1=new MultiplePercept(this);
        l15mp1.addPercept(clp15);
        l15mp1.addPercept(new UnreadTextFeedbackPercept(this,l15tfa1));
        addMapping(new Mapping(l15mp1,l15ma1));
        
        
        PresentNodePercept npp1=new PresentNodePercept(this);
        npp1.setNode("Food");
        TextFeedbackAction l15tfa5=new TextFeedbackAction(this,"Hmm, you created a node named Food. That's fine for now, but remember, in the future you probably want to be more clear about what the Food actually is: is it algae, plants, other fish? It will be easier to figure out if something happened to the food source if you say what the food source is.");
        MultipleAction l15ma5=new MultipleAction(this,new Action[]{l15tfa5,cpaConcernedFrontBulb});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{clp15,npp1}),l15ma5));
        
        
        /* LESSON 16 **********************************************************/
        CurrentLessonPercept clp16=new CurrentLessonPercept(this,"16");
        
        MultipleAction l16ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l16tfa1=new TextFeedbackAction(this,"Today, you'll be focusing on using more simulations, this time focusing on algae and photosynthesis.");
        l16ma1.addAction(l16tfa1);
        l16ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l16ma2=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l16tfa2=new TextFeedbackAction(this,"Remember, though, that these aren't unlike the simulations you've been using. Algae and plants both eat some things and are eaten by other things. Anything that changes the amount of one of these organisms in the system could have impact on lots of other parts of the system.");
        l16ma2.addAction(l16tfa2);
        l16tfa1.setNextAction(l16ma2); 
        
        MultipleAction l16ma3=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l16tfa3=new TextFeedbackAction(this,"As you use these simulations, try to understand the role that algae and plants play in the system, and then understand how changes to them might change the system as a whole.");
        l16ma3.addAction(l16tfa3);
        l16tfa2.setNextAction(l16ma3); 
        
        MultipleAction l16ma4=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l16tfa4=new TextFeedbackAction(this,"Remember also that you can use simulations to try to test out your models. If you observe something in the simulations that supports your model, note it as evidence -- if you notice something that suggests a model is false, don't be afraid to research further and dismiss it if necessary.");
        l16ma4.addAction(l16tfa4);
        l16tfa3.setNextAction(l16ma4); 
        
        MultiplePercept l16mp1=new MultiplePercept(this);
        l16mp1.addPercept(clp16);
        l16mp1.addPercept(new UnreadTextFeedbackPercept(this,l16tfa1));
        addMapping(new Mapping(l16mp1,l16ma1));
        
        
        /* LESSON 17 **********************************************************/
        CurrentLessonPercept clp17=new CurrentLessonPercept(this,"17");
        
        MultipleAction l17ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l17tfa1=new TextFeedbackAction(this,"In this lesson, you'll be using yet another simulation, this time focusing on how pollution affects aquatic systems.");
        l17ma1.addAction(l17tfa1);
        l17ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l17ma2=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l17tfa2=new TextFeedbackAction(this,"Pollution is an interesting element in systems. It can impact every part of the system directly, and the impacts that it has on individual parts of the system can then change the system even more. Pollution, for example, can kill some plant and some fish, and then the remaining fish could starve to death due to lack of food.");
        l17ma2.addAction(l17tfa2);
        l17tfa1.setNextAction(l17ma2); 
        
        MultipleAction l17ma3=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l17tfa3=new TextFeedbackAction(this,"If one of your hypotheses is that pollution is causing the fish die-off, make sure to use this simulation to further explain your model. You'll also want to try to back that theory up with information from the actual lake. Was there a spike in pollution before the fish die-off?");
        l17ma3.addAction(l17tfa3);
        l17tfa2.setNextAction(l17ma3); 
        
        MultiplePercept l17mp1=new MultiplePercept(this);
        l17mp1.addPercept(clp17);
        l17mp1.addPercept(new UnreadTextFeedbackPercept(this,l17tfa1));
        addMapping(new Mapping(l17mp1,l17ma1));
        
        
        /* LESSON 18 **********************************************************/
        CurrentLessonPercept clp18=new CurrentLessonPercept(this,"18");
        
        MultipleAction l18ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l18tfa1=new TextFeedbackAction(this,"In this lesson, you'll use a simulation on oxygen depletion and bacterial growth.");
        l18ma1.addAction(l18tfa1);
        l18ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l18ma2=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l18tfa2=new TextFeedbackAction(this,"We know that fish need oxygen to breathe, and we know that there are microscopic bacteria living in the lake and other aquatic ecosystems. What role do these play in the system?");
        l18ma2.addAction(l18tfa2);
        l18tfa1.setNextAction(l18ma2); 
        
        MultipleAction l18ma3=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l18tfa3=new TextFeedbackAction(this,"While you use these simulations, think about the notion of making the invisible visible. We can't see bacteria, we can't see oxygen, but we can see what happens when there's too much or too little of one of the other.");
        l18ma3.addAction(l18tfa3);
        l18tfa2.setNextAction(l18ma3); 
        
        MultipleAction l18ma4=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l18tfa4=new TextFeedbackAction(this,"Try to think of other invisible things that might be affecting the fish in the lake as well. Remember, as you use these simulations, try to find information that supports your hypotheses. When you find some, either expand your model by adding more components or justify some of your connections with evidence.");
        l18ma4.addAction(l18tfa4);
        l18tfa3.setNextAction(l18ma4); 
        
        MultiplePercept l18mp1=new MultiplePercept(this);
        l18mp1.addPercept(clp18);
        l18mp1.addPercept(new UnreadTextFeedbackPercept(this,l18tfa1));
        addMapping(new Mapping(l18mp1,l18ma1));
        
        
        /* LESSON 19 **********************************************************/
        CurrentLessonPercept clp19=new CurrentLessonPercept(this,"19");
        
        MultipleAction l19ma1=new MultipleAction(this,new Action[]{cpaExcitedFront});
        TextFeedbackAction l19tfa1=new TextFeedbackAction(this,"You've learned everything you need to know to investigate the fish die-off. Now, let's put those skills to the test!");
        l19ma1.addAction(l19tfa1);
        l19ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l19ma2=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l19tfa2=new TextFeedbackAction(this,"Our goal now is to start to really develop our models of how the fish die-off happened and to come to some really solid explanations. Now is the time to start trying to explain how every connection takes place and give some evidence for as many as we can.");
        l19ma2.addAction(l19tfa2);
        l19tfa1.setNextAction(l19ma2); 
        
        MultipleAction l19ma3=new MultipleAction(this,new Action[]{cpaConcernedFront});
        TextFeedbackAction l19tfa3=new TextFeedbackAction(this,"Over the past several lessons, you've come up with lots of hypotheses and lots of models. As you start to investigate them further, though, you're going to notice that some are better than others.");
        l19ma3.addAction(l19tfa3);
        l19tfa2.setNextAction(l19ma3);
        
        MultipleAction l19ma4=new MultipleAction(this,new Action[]{cpaConcernedFront});
        TextFeedbackAction l19tfa4=new TextFeedbackAction(this,"If you find that you have information showing one of your hypotheses is false, or if you find that you can't find information to support a hypothesis, it's time to dismiss that hypothesis and model.");
        l19ma4.addAction(l19tfa4);
        l19tfa3.setNextAction(l19ma4); 
        
        MultipleAction l19ma5=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l19tfa5=new TextFeedbackAction(this,"Dismissing models is a good thing, though! The entire scientific process is built around trying different hypotheses and figuring out which works best. So, don't be afraid to dismiss your models when you decide they don't present a good argument.");
        l19ma5.addAction(l19tfa5);
        l19tfa4.setNextAction(l19ma5); 
        
        MultipleAction l19ma6=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l19tfa6=new TextFeedbackAction(this,"Once you dismiss a model, you can still look at it, and you can always bring it back later. It'll just be crossed out in the model box -- it can still be viewed (but not edited), though.");
        l19ma6.addAction(l19tfa6);
        l19tfa5.setNextAction(l19ma6); 
        
        MultiplePercept l19mp1=new MultiplePercept(this);
        l19mp1.addPercept(clp19);
        l19mp1.addPercept(new UnreadTextFeedbackPercept(this,l19tfa1));
        addMapping(new Mapping(l19mp1,l19ma1));
        
        
        /* LESSON 20 **********************************************************/
        CurrentLessonPercept clp20=new CurrentLessonPercept(this,"20");
        
        MultipleAction l20ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l20tfa1=new TextFeedbackAction(this,"In this lesson, you'll get even more information about what might have caused the fish die-off. How does this new information change your understanding?");
        l20ma1.addAction(l20tfa1);
        l20ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l20ma2=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l20tfa2=new TextFeedbackAction(this,"Some of this information will give support for your existing hypotheses -- use that information to make those models better. Some of this information will show that some of your hypotheses were incorrect -- that's good! We're narrowing down our beliefs and coming to stronger conclusions.");
        l20ma2.addAction(l20tfa2);
        l20tfa1.setNextAction(l20ma2); 
        
        MultipleAction l20ma3=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l20tfa3=new TextFeedbackAction(this,"Some of this information might even make you think of even more new models and hypotheses -- don't be afraid to start some more new models. Your goal is to come up with multiple very solid explanations of the fish die-off, and it's never too late to start a new hypothesis!");
        l20ma3.addAction(l20tfa3);
        l20tfa2.setNextAction(l20ma3); 
        
        MultiplePercept l20mp1=new MultiplePercept(this);
        l20mp1.addPercept(clp20);
        l20mp1.addPercept(new UnreadTextFeedbackPercept(this,l20tfa1));
        addMapping(new Mapping(l20mp1,l20ma1));
        
        
        /* LESSON 21 **********************************************************/
        CurrentLessonPercept clp21=new CurrentLessonPercept(this,"21");
        
        MultipleAction l21ma1=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l21tfa1=new TextFeedbackAction(this,"We're getting near the end! It's time to really narrow down our models to a small set that we're very confident about. Try to narrow it down to three models or less that you want to show our visitors.");
        l21ma1.addAction(l21tfa1);
        l21ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l21ma2=new MultipleAction(this,new Action[]{cpaConfusedFront});
        TextFeedbackAction l21tfa2=new TextFeedbackAction(this,"You might still have models that you feel good about, but that aren't really well-defended. It's time to start dismissing those! We're not saying that they're incorrect, but a model is only as good as the argument you can make for it -- with the information we have now, we might not be able to defend some models.");
        l21ma2.addAction(l21tfa2);
        l21tfa1.setNextAction(l21ma2); 
        
        MultipleAction l21ma3=new MultipleAction(this,new Action[]{cpaInterestedFront});
        TextFeedbackAction l21tfa3=new TextFeedbackAction(this,"In your heads, try to look at your models as if you're an outside observer. If you saw someone present this explanation of the fish die-off, what would they challenge you on? How would you defend your model?");
        l21ma3.addAction(l21tfa3);
        l21tfa2.setNextAction(l21ma3); 
        
        MultipleAction l21ma4=new MultipleAction(this,new Action[]{cpaHappyFront});
        TextFeedbackAction l21tfa4=new TextFeedbackAction(this,"All of science is arguing. You argue in favor of your explanation, someone argues against you. your explanation is only as good as the argument you can make -- in real science, there is no right or wrong.");
        l21ma4.addAction(l21tfa4);
        l21tfa3.setNextAction(l21ma4); 
        
        MultiplePercept l21mp1=new MultiplePercept(this);
        l21mp1.addPercept(clp21);
        l21mp1.addPercept(new UnreadTextFeedbackPercept(this,l21tfa1));
        addMapping(new Mapping(l21mp1,l21ma1));
        
        
        /* LESSON 23 **********************************************************/
        CurrentLessonPercept clp23=new CurrentLessonPercept(this,"23");
        
        MultipleAction l23ma1=new MultipleAction(this,new Action[]{cpaExcitedFront});
        TextFeedbackAction l23tfa1=new TextFeedbackAction(this,"Congratulations! You've reached the end of the investigation, and it's time to present your findings to others.");
        l23ma1.addAction(l23tfa1);
        l23ma1.addAction(new ShowTutorAction(this)); 
        
        MultipleAction l23ma2=new MultipleAction(this,new Action[]{cpaExcitedFront});
        TextFeedbackAction l23tfa2=new TextFeedbackAction(this,"As a scientist, your goal isn't to present everything that you've done. Instead, your goal is to present your final, strongest conclusions. Choose the remaining models that you're most confident about and prepare to explain them to people that have never heard of the fish die-off before.");
        l23ma2.addAction(l23tfa2);
        l23tfa1.setNextAction(l23ma2); 
        
        MultipleAction l23ma3=new MultipleAction(this,new Action[]{cpaExcitedFront});
        TextFeedbackAction l23tfa3=new TextFeedbackAction(this,"Try to think of what they'll find interesting, or what might be confusing for them. Remember, your explanation is only as good as the argument you make for it, so make sure you're very confident in what you're saying!");
        l23ma3.addAction(l23tfa3);
        l23tfa2.setNextAction(l23ma3); 
        
        MultiplePercept l23mp1=new MultiplePercept(this);
        l23mp1.addPercept(clp23);
        l23mp1.addPercept(new UnreadTextFeedbackPercept(this,l23tfa1));
        addMapping(new Mapping(l23mp1,l23ma1));

        
        /* END LESSON-SPECIFIC CONTENT ****************************************/
        
        TruePercept tp1=new TruePercept(this);
        TextFeedbackAction tfa0=new TextFeedbackAction(this,"I don't really have anything to say right now.");
        tfa0.setLogThis(false);
        Mapping m1=new Mapping(tp1,new MultipleAction(this,new Action[]{cpaNeutralSide,tfa0}));
        addMapping(m1);
    }
}