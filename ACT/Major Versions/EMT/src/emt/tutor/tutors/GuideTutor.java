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
public class GuideTutor extends OnDemandTutor {
    public GuideTutor() {
        super("Guide");
        
        initializeTutor();
    }

    public GuideTutor(ProjectModelPanel modelPanel) {
        super("Guide",modelPanel);
        
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("amazed-front", "j-amazed-front.jpg");
        addImage("amazed-side", "j-amazed-side.jpg");
        addImage("concerned-front", "j-concerned-front.jpg");
        addImage("concerned-side", "j-concerned-side.jpg");
        addImage("confused-front", "j-confused-front.jpg");
        addImage("confused-side", "j-confused-side.jpg");
        addImage("excited-front", "j-excited-front.jpg");
        addImage("excited-side", "j-excited-side.jpg");
        addImage("happy-front", "j-happy-front.jpg");
        addImage("happy-side", "j-happy-side.jpg");
        addImage("interested-front", "j-interested-front.jpg");
        addImage("interested-side", "j-interested-side.jpg");
        addImage("neutral-front", "j-neutral-front.jpg");
        addImage("neutral-side", "j-neutral-side.jpg");
        
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
        
        QuestionListAction day1Qs=new QuestionListAction(this);
        MultipleAction day1MA=new MultipleAction(this,new Action[]{day1Qs,cpaHappyFront});
        day1Qs.setIntro("Do you need help with the basics of MILA? What can I help you with?");
        QuestionItem q1=new QuestionItem("How do I create MILA models?");
        QuestionItem q2=new QuestionItem("How do I take notes?");
        QuestionItem q3=new QuestionItem("How do I use the Internet or hypermedia?");
        QuestionItem q4=new QuestionItem("How do I use the tutors?");
        day1Qs.addQuestion(q1);
        day1Qs.addQuestion(q2);
        day1Qs.addQuestion(q3);
        day1Qs.addQuestion(q4);
        
        QuestionListAction milaQs=new QuestionListAction(this);
        q1.setAction(milaQs);
        QuestionItem milaQ1=new QuestionItem("How and when do I create new models?");
            TextFeedbackAction milaQ1tfa1=new TextFeedbackAction(this,"When you first start a new project in MILA, you first describe the phenomenon you're explaining in the box in the top left. For example, 'fish are dying' or 'fish are growing out of control' would be two phenomena to explain. In MILA, you're always trying to explain phenomena.");
            milaQ1.setAction(milaQ1tfa1);
            TextFeedbackAction milaQ1tfa2=new TextFeedbackAction(this,"Every model you create in MILA is one hypothesis about what is causing that phenomenon. For example, maybe you hypothesize that fish are dying because of pollution. In that case, you'd want to create a model called 'pollution.");
            milaQ1tfa1.setNextAction(milaQ1tfa2);
            TextFeedbackAction milaQ1tfa3=new TextFeedbackAction(this,"To create a new model, just click the Add Model button. You'll be asked to enter a name for your model -- this is what you put in a short description of what you're hypothesizing is causing the phenomenon. Click OK and your model will be added to the box. Click it to edit it on the canvas at the right.");
            milaQ1tfa2.setNextAction(milaQ1tfa3);
        QuestionListAction milaQs2=new QuestionListAction(this);
        QuestionItem milaQ2=new QuestionItem("How do I read and use a MILA model?",milaQs2);
            QuestionItem milaQ21=new QuestionItem("What are components?");
                TextFeedbackAction milaQ21tfa1=new TextFeedbackAction(this,"Components are the physical things in the system. In an aquarium, for example, Fish, Water, Algae, Rocks, Bacteria, and Food are all physical parts of the aquarium. Chemicals, like Nitrate and Ammonia, are also physical parts of the system, although they are unable to be seen by the human eye alone.");
                milaQ21.setAction(milaQ21tfa1);
                TextFeedbackAction milaQ21tfa2=new TextFeedbackAction(this,"Components also have variables about them. For example, Water has Temperature, Fish have Population, and Food has Quantity. When a Component changes, you wouldn't say 'Food went up'; you would say 'Food Quantity went up'. The variable changes, not the component itself.");
                milaQ21tfa1.setNextAction(milaQ21tfa2);
                TextFeedbackAction milaQ21tfa3=new TextFeedbackAction(this,"The arrow in the top right corner of a component says which way the variable is changing. If Fish Population is going down, then the component in the middle would be 'Fish', the variable in the top left would be 'Population', and the arrow would be red and pointed 'down'.");
                milaQ21tfa2.setNextAction(milaQ21tfa3);
            QuestionItem milaQ22=new QuestionItem("What are connections?");
                TextFeedbackAction milaQ22tfa1=new TextFeedbackAction(this,"A connection shows how two events in the system are connected. Imagine if we had a component showing Pollution Concentration was going up and Fish Population was going down. If we drew a connection from Pollution to Fish, it would say that Pollution Concentration going up causes Fish Population to go down.");
                milaQ22.setAction(milaQ22tfa1);
                TextFeedbackAction milaQ22tfa2=new TextFeedbackAction(this,"These connections allow us to explain the phenomenon as a sequence of events that each cause the next, like a series of dominoes. We can build more complicated models, too, that have more than one cause and more than one result.");
                milaQ22tfa1.setNextAction(milaQ22tfa2);
//                TextFeedbackAction milaQ22tfa3=new TextFeedbackAction(this,"Connections do not have to say that one thing caused another, either. Instead, we can also click on the arrow on the connection to toggle it to a dot. This means that the two events are observed to happen together, but we do not know which causes the other. This is called 'correlation'.");
//                milaQ22tfa2.setNextAction(milaQ22tfa3);
            QuestionItem milaQ23=new QuestionItem("What is evidence?");
                TextFeedbackAction milaQ23tfa1=new TextFeedbackAction(this,"When drawing a model, you are trying to explain a phenomenon. To be good, your explanation needs to have evidence -- otherwise, why should anyone believe your explanation?");
                milaQ23.setAction(milaQ23tfa1);
                TextFeedbackAction milaQ23tfa2=new TextFeedbackAction(this,"There's a lot of kinds of evidence that you could use. If you observe something actually happening in the wild or in a simulation, that's evidence. If you mention something that's an accepted scientific fact, that's evidence. If an expert on this subject tells you something is true, that's evidence.");
                milaQ23tfa1.setNextAction(milaQ23tfa2);
            QuestionListAction milaQs21=new QuestionListAction(this);
            QuestionItem milaQ24=new QuestionItem("See more questions...",milaQs21);
            QuestionItem milaQ25=new QuestionItem("What do the red and green arrows on the components mean?",new TextFeedbackAction(this,"These arrows represent the direction in which the variable is changing. If the component was Fish and the variable was Population, a green arrow would say Fish Population is going up. If the component was Water and the variable was temperature, a red arrow would say Water Temperature is decreasing."));
            //QuestionItem milaQ26=new QuestionItem("What's the difference between components and variables?",new TextFeedbackAction(this,"Components are the physical pieces of the system, large or small, living or non-living, solid, liquid or gas. Variables are things we used to describe those components. Water, for example, might have variables for Temperature, Pressure, Quantity, Cleanliness, etc."));
            QuestionItem milaQ27=new QuestionItem("What are the colors for the components used for?",new TextFeedbackAction(this,"The colors you can add to components can be used a lot of ways. You could use them just to add a splash of color, or you could use them to separate things you've observed from things you propose, or biotic (living) components from abiotic (non-living) ones."));
            milaQs2.addQuestion(milaQ21);
            milaQs2.addQuestion(milaQ22);
            milaQs2.addQuestion(milaQ23);
            milaQs2.addQuestion(milaQ24);
            milaQs21.addQuestion(milaQ25);
            //milaQs21.addQuestion(milaQ26);
            milaQs21.addQuestion(milaQ27);
        QuestionListAction milaQs3=new QuestionListAction(this);
        QuestionItem milaQ3=new QuestionItem("How do I add components, connections, and evidence?",milaQs3);
            QuestionItem milaQ31=new QuestionItem("How do I add components?",new TextFeedbackAction(this,"To add a new component, first select the Add Component tool. Then, click anywhere in the blank white space of your model canvas. A window will pop up asking you for the component, variable, and color of your component. Enter those, then click OK."));
            QuestionItem milaQ32=new QuestionItem("How do I add connections?",new TextFeedbackAction(this,"To a connection, click on the big bold border of one component and drag the new connection to another component. Let go of the connection when the other end is on top of another component to create the new connection."));
            QuestionItem milaQ33=new QuestionItem("How do I add or edit evidence?",new TextFeedbackAction(this,"To add evidence, first click on a connection line. You'll see a green box appear -- this is where your evidence appears. To add or edit evidence, click the Pen icon in the top right of this box. After adding your evidence, you can hide this box by clicking the Minimize box. If you've added evidence, the connection will now appear green instead of blue."));
            QuestionListAction milaQs32=new QuestionListAction(this);
            QuestionItem milaQ34=new QuestionItem("See more questions...",milaQs32);
            QuestionItem milaQ35=new QuestionItem("How do I delete a part of my model?",new TextFeedbackAction(this,"To delete any part of your model (components or connections), first select the Erase Part of Model tool. Then, click what you want to erase. If you erase a component, remember any connections that were connected to it will also be deleted."));
            QuestionItem milaQ36=new QuestionItem("How do I edit my components?",new TextFeedbackAction(this,"To edit a component, first select the Edit Component tool, then click the component you want to edit. You can also change the direction of each component's red or green arrow by clicking on the arrow by itself."));
            QuestionItem milaQ37=new QuestionItem("What's the difference between adding components and inserting them?");
                TextFeedbackAction milaQ37tfa1=new TextFeedbackAction(this,"Adding a component adds it to the canvas by itself, without being connected to anything. Inserting a component actually places the new component in the middle of a connection between two other components. For example, if you have a connection Pollution->Fish, you might insert a Bacteria node between them to create Pollution->Bacteria->Fish");
                milaQ37.setAction(milaQ37tfa1);
                milaQ37tfa1.setNextAction(new TextFeedbackAction(this,"To insert a component, first select the Insert Component tool, then click on the connection where you'd like to insert the component. The same dialog will appear as the Add Component tool."));
            QuestionItem milaQ38=new QuestionItem("How do I change the directions of my connections?",new TextFeedbackAction(this,"When you first draw a connection, it always points from one component to another. You can click on the dots and arrows at either end of the connection to change them between arrows and dots."));
            milaQs3.addQuestion(milaQ31);
            milaQs3.addQuestion(milaQ32);
            milaQs3.addQuestion(milaQ33);
            milaQs3.addQuestion(milaQ34);
            milaQs32.addQuestion(milaQ35);
            milaQs32.addQuestion(milaQ36);
            milaQs32.addQuestion(milaQ37);
            milaQs32.addQuestion(milaQ38);
        QuestionItem milaQ4=new QuestionItem("What makes a good model?",new TextFeedbackAction(this,"We'll talk a lot about what makes a good model over the next several days. Generally, though, a good model is one that provides a good, thorough explanation of a phenomenon using the evidence you have gathered to support it."));
        milaQs.addQuestion(milaQ1);
        milaQs.addQuestion(milaQ2);
        milaQs.addQuestion(milaQ3);
        milaQs.addQuestion(milaQ4);
        
        QuestionListAction notesQs=new QuestionListAction(this);
        q2.setAction(notesQs);
        QuestionItem noteQ1=new QuestionItem("How do I open up the notepad?", new TextFeedbackAction(this,"To open up the Notepad, just click the Take Notes button on the left."));
        QuestionItem noteQ2=new QuestionItem("How do I create new notes?", new TextFeedbackAction(this,"With the Notepad open, click Add Note to create a new note. You'll be asked to name your note. Give it a name, then click OK."));
        QuestionItem noteQ3=new QuestionItem("How do I view or edit notes?", new TextFeedbackAction(this,"With the Notepad open, just select the note you want to view or edit on the left. The note's text will appear on the right for you to read and change."));
        QuestionItem noteQ4=new QuestionItem("How do I save my notes?", new TextFeedbackAction(this,"MILA automatically saves your notes for you, so you don't need to worry about losing them."));
        notesQs.addQuestion(noteQ1);
        notesQs.addQuestion(noteQ2);
        notesQs.addQuestion(noteQ3);
        notesQs.addQuestion(noteQ4);
        
        QuestionListAction internetQs=new QuestionListAction(this);
        q3.setAction(internetQs);
        QuestionItem internetQ1=new QuestionItem("How do I access the Internet?", new TextFeedbackAction(this,"To access the Internet, click the Consult Internet button on the left side of MILA. Your Internet browser will launch to the camp's homepage."));
        QuestionItem internetQ2=new QuestionItem("What sites do I have access to?", new TextFeedbackAction(this,"You have access to a selection of sites based around the phenomena that you're trying to explain, as well as a couple other general knowledge sites. Wikipedia is available, although remember that claims made on Wikipedia are not always reliable."));
        TextFeedbackAction internetQ3tfa1=new TextFeedbackAction(this,"In science, the Internet should always be used as a source for background information and scientific principles, but it does not take the place of actually solving problems and explaining phenomena.");
        internetQ3tfa1.setNextAction(new TextFeedbackAction(this,"The Internet can provide valuable information, though, to confirm your suspicions about the phenomenon or to refute them. Always go to the Internet looking for answers to particular questions; never go just to browse. Remember, too, that anything you find online needs to be confirmed by more than one source. Anyone can write anything they want online, so make sure you're only looking at the work of scientists and researchers."));
        QuestionItem internetQ3=new QuestionItem("How should the Internet be used in science?", internetQ3tfa1);
        internetQs.addQuestion(internetQ1);
        internetQs.addQuestion(internetQ2);
        internetQs.addQuestion(internetQ3);
        
        QuestionListAction tutorsQs=new QuestionListAction(this);
        q4.setAction(tutorsQs);
        QuestionItem tutorQ1=new QuestionItem("How should I use Gabriel the Guide?", new TextFeedbackAction(this,"I'm here to try to answer any of your questions. Whenever you need help or want to ask something about MILA or the lesson for the day, just click me and I'll do my best to help! I'll never interrupt you, so make sure to click me if you need me."));
        QuestionItem tutorQ2=new QuestionItem("How should I use Craig the Critic?", new TextFeedbackAction(this,"Craig is here to look at your models and see if they show what you're trying to learn for the day. When you think your model is in good shape or you don't know what else to do with it, click him to see if he has any suggestions."));
        QuestionItem tutorQ3=new QuestionItem("How should I use Mercer the Mentor?", new TextFeedbackAction(this,"Mercer is always keeping track of what you're doing, and when he has something to say, he'll appear with his little lightbulb. When you see that, click him to get his feedback or suggestions."));
        QuestionItem tutorQ4=new QuestionItem("How should I use Isla the Interviewer?", new TextFeedbackAction(this,"Isla's goal is to ask you questions to understand a little more what you're thinking or what you've learned. When you see her appear with her lightbulb, click her to give her your thoughts on whatever she's asking. Sometimes she’ll ask you what you learned on trips to the aquarium or the lake, while other times she’ll ask you about your ideas in your models."));
        tutorsQs.addQuestion(tutorQ1);
        tutorsQs.addQuestion(tutorQ2);
        tutorsQs.addQuestion(tutorQ3);
        tutorsQs.addQuestion(tutorQ4);
        
        addMapping(new Mapping(clp7,day1MA));
        
        /* LESSON 9 ***********************************************************/
        CurrentLessonPercept clp9=new CurrentLessonPercept(this,"9");
        QuestionListAction l9qla1=new QuestionListAction(this);
        MultipleAction l9ma1=new MultipleAction(this,new Action[]{l9qla1,cpaHappyFront});
        QuestionItem l9q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l9q1tfa1=new TextFeedbackAction(this,"For this lesson, your goal is to come up with multiple hypotheses for what might have caused the fish in Lake Clara Meer to die off.");
            l9q1.setAction(l9q1tfa1);
            TextFeedbackAction l9q1tfa2=new TextFeedbackAction(this,"Try to come up with at least two different hypotheses, and then create a model for each hypothesis. In each of these models, make sure you're including the fact that the Fish Population is decreasing, along with whatever else you're hypothesizing (for example, that Pollution Concentration was rising or that Oxygen Levels were decreasing).");
            l9q1tfa1.setNextAction(l9q1tfa2);
        QuestionItem l9q2=new QuestionItem("What should my models look like?");
            TextFeedbackAction l9q2tfa1=new TextFeedbackAction(this,"The goal of your model is to explain why and how the fish in Lake Clara Meer all died. So, your model should include an initial event that caused the Fish Population to drop. Eventually, you'll have a long explanation for how this took place, but for now focus on the initial hypotheses.");
            l9q2.setAction(l9q2tfa1);
        QuestionItem l9q3=new QuestionItem("What else should I keep in mind?");
            TextFeedbackAction l9q3tfa1=new TextFeedbackAction(this,"Try to think about how the fish die-off problem and the Aquarium problem are similar and how they're different. Is there anything you learned with the Aquarium that you can transfer to the fish die-off?");
            l9q3.setAction(l9q3tfa1);
        QuestionItem l9q4=new QuestionItem("See more questions...", day1MA);
        l9qla1.addQuestion(l9q1);
        l9qla1.addQuestion(l9q2);
        l9qla1.addQuestion(l9q3);
        l9qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp9,l9ma1));
        
        /* LESSON 11 **********************************************************/
        CurrentLessonPercept clp11=new CurrentLessonPercept(this,"11");
        QuestionListAction l11qla1=new QuestionListAction(this);
        MultipleAction l11ma1=new MultipleAction(this,new Action[]{l11qla1,cpaConfusedFront});
        QuestionItem l11q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l11q1tfa1=new TextFeedbackAction(this,"In this lesson, your goal is to add in some of the new information you've gathered into your models. You are also encouraged to create new models if you have new ideas for what might have caused the fish die-off.");
            l11q1.setAction(l11q1tfa1);
            TextFeedbackAction l11q1tfa2=new TextFeedbackAction(this,"By the end of the lesson, try to have at least five models, each representing a different hypothesis. The models don't need to be complicated, but try also to incorporate some of what you learned at the lake into your models.");
            l11q1tfa1.setNextAction(l11q1tfa2);
        QuestionItem l11q2=new QuestionItem("How do I incorporate the information I've gathered into my models?");
            TextFeedbackAction l11q2tfa1=new TextFeedbackAction(this,"In science, scientists go out and find new information to either support or fill in their models. There are lots of ways you can add the information you've learned into your model.");
            l11q2.setAction(l11q2tfa1);
            TextFeedbackAction l11q2tfa2=new TextFeedbackAction(this,"The information you gathered might give evidence to some of the connections you've already made. Or, it might also let you know how a connection you've made occurs. You might know that the rise in levels of a certain chemical kills fish, but how does it do that?");
            l11q2tfa1.setNextAction(l11q2tfa2);
            TextFeedbackAction l11q2tfa3=new TextFeedbackAction(this,"Or, the information you gathered might reflect on the model as a whole. You might have gathered data that shows that some of the events you mention in your model really did happen around that time, which would suggest your model could be true.");
            l11q2tfa2.setNextAction(l11q2tfa3);
            TextFeedbackAction l11q2tfa4=new TextFeedbackAction(this,"One of the most important parts of the scientific process is also using information you gathered to decide one of your hypotheses is wrong. Being wrong in science is not a bad thing: a good scientist will make lots of hypotheses and decide almost all of them are false. This is good!");
            l11q2tfa3.setNextAction(l11q2tfa4);
            TextFeedbackAction l11q2tfa5=new TextFeedbackAction(this,"It's probably too early to be dismissing any of your hypotheses now, but keep that in mind as you go through the camp. When you think you've gathered enough information to decide a hypothesis isn't worth pursuing, click Dismiss to dismiss it. You can still view it, but it will just be marked as dismissed.");
            l11q2tfa4.setNextAction(l11q2tfa5);
        QuestionItem l11q3=new QuestionItem("How do I use more than one model?");
            TextFeedbackAction l11q3tfa1=new TextFeedbackAction(this,"In MILA, each model represents a hypothesis for what might be causing the problem you're investigating.");
            l11q3.setAction(l11q3tfa1);
            TextFeedbackAction l11q3tfa2=new TextFeedbackAction(this,"As you investigate, look for information that confirms or clarifies your model. Use your model to figure out what evidence you need to gather, or what problems you need to do a better job explaining.");
            l11q3tfa1.setNextAction(l11q3tfa2);
            TextFeedbackAction l11q3tfa3=new TextFeedbackAction(this,"Sometimes, while investigating, you might come up with all-new hypotheses. That's great! You can create new models for new hypotheses at any time. Scientists do that all the time: they'll investigate one hypothesis, but come up with a different one at the same time.");
            l11q3tfa2.setNextAction(l11q3tfa3);
            TextFeedbackAction l11q3tfa4=new TextFeedbackAction(this,"As you investigate, you might also start to notice that some of your hypotheses aren't really separate. You might notice that two causes you hypothesized interact with each other. If that's the case, copy some of the things from one model into another to merge them together.");
            l11q3tfa3.setNextAction(l11q3tfa4);
        l11qla1.addQuestion(l11q1);
        l11qla1.addQuestion(l11q2);
        l11qla1.addQuestion(l11q3);
        l11qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp11,l11ma1));
        
        /* LESSON 12/13 *******************************************************/
        CurrentLessonPercept clp12=new CurrentLessonPercept(this,"12");
        
        /*QuestionListAction l12qla1=new QuestionListAction(this);
        QuestionItem l12q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l12q1tfa1=new TextFeedbackAction(this,"In this lesson, your goal is to learn about how acids and bases work.");
            l12q1.setAction(l12q1tfa1);
            TextFeedbackAction l12q1tfa2=new TextFeedbackAction(this,"Understanding how acids and bases work, however, is only part of the goal. Try to also figure out if acids and bases could have contributed to the fish dying off in the lake. If they might have, what could have caused the levels of acids and bases to change?");
            l12q1tfa1.setNextAction(l12q1tfa2);
        QuestionItem l12q2=new QuestionItem("What is the pH scale and how does it work?");
            TextFeedbackAction l12q2tfa1=new TextFeedbackAction(this,"The pH scale is a number scale from 1 to 14 to measure how acidic or basic a liquid is. A low score on the pH scale means a liquid is acidic, while a high score means it is very basic.");
            l12q2.setAction(l12q2tfa1);
            TextFeedbackAction l12q2tfa2=new TextFeedbackAction(this,"Acids and bases interact in lots of ways, but most importantly, when a liquid is very acidic or very basic, it can be difficult for life to thrive. In an aquarium, for example, you must carefully monitor the pH of the water to ensure the fish stay healthy and live a long time.");
            l12q2tfa1.setNextAction(l12q2tfa2);
        QuestionItem l12q3=new QuestionItem("What are some common acids and bases?");
            TextFeedbackAction l12q3tfa1=new TextFeedbackAction(this,"Lots of common substances are acids and bases. Soda and fruit juices are common acids, while chemicals like ammonia are very basic.");
            l12q3.setAction(l12q3tfa1);
            TextFeedbackAction l12q3tfa2=new TextFeedbackAction(this,"Ammonia is actually one of the chemicals in the waste that fish give off. If you introduce lots of fish into an aquarium too fast, their waste will quickly poison them. Could this have something to do with the fish die-off in the Lake?");
            l12q3tfa1.setNextAction(l12q3tfa2);
            TextFeedbackAction l12q3tfa3=new TextFeedbackAction(this,"If ammonia is poisonous to fish, how do you think fish can live in the same water for long periods of time without being poisoned by the ammonia?");
            l12q3tfa2.setNextAction(l12q3tfa3);
        l12qla1.addQuestion(l12q1);
        l12qla1.addQuestion(l12q2);
        l12qla1.addQuestion(l12q3);
        l12qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp12,l12qla1));*/
        addMapping(new Mapping(clp12,day1MA));
        
        /* LESSON 14 **********************************************************/
        CurrentLessonPercept clp14=new CurrentLessonPercept(this,"14");
        
        QuestionListAction l14qla1=new QuestionListAction(this);
        MultipleAction l14ma1=new MultipleAction(this,new Action[]{l14qla1,cpaConfusedFront});
        QuestionItem l14q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l14q1tfa1=new TextFeedbackAction(this,"In this lesson, your goal is to learn how to use NetLogo simulations, and to learn how scientists use simulations in real science.");
            l14q1.setAction(l14q1tfa1);
            TextFeedbackAction l14q1tfa2=new TextFeedbackAction(this,"As you use the simulations, try to think of ways you could test your models with the simulations. If the simulations demonstrate something you've put in your model, you can use the simulation's results as evidence.");
            l14q1tfa1.setNextAction(l14q1tfa2);
        QuestionItem l14q2=new QuestionItem("How do I use NetLogo simulations?");
            QuestionListAction l14qla2=new QuestionListAction(this);
            l14q2.setAction(l14qla2);
            QuestionItem l14q21=new QuestionItem("How do I open a NetLogo simulation?");
                l14q21.setAction(new TextFeedbackAction(this,"To open a NetLogo simulation, click the Use Simulation button on the left. Then, choose a simulation from the box that pops up and click OK. The NetLogo simulation will open, and you're good to go!"));
            QuestionItem l14q22=new QuestionItem("How do I use a NetLogo simulation?");
                TextFeedbackAction l14q22tfa1=new TextFeedbackAction(this,"On the left side of the simulation, you'll see a bunch of sliders. You can use these to change the starting conditions of the simulation. Before running a simulation, drag these to where you want them to start.");
                l14q22.setAction(l14q22tfa1);
                TextFeedbackAction l14q22tfa2=new TextFeedbackAction(this,"Once you've set the variables, click Setup. This applies those changes to the simulation window in the middle. Make sure to remember to click Setup before the next step!");
                l14q22tfa1.setNextAction(l14q22tfa2);
                TextFeedbackAction l14q22tfa3=new TextFeedbackAction(this,"Once you've clicked Setup, click Go to run the simulation. You'll see the middle window changing. You can drag the slider across the top back and forth to speed things up or slow them down.");
                l14q22tfa2.setNextAction(l14q22tfa3);
            QuestionItem l14q23=new QuestionItem("How do I get data out of a NetLogo simulation?");
                TextFeedbackAction l14q23tfa1=new TextFeedbackAction(this,"As the simulation runs, you can watch the status of things on the right. You can watch as populations of different living organisms grow and shrink, and as concentrations of different chemicals rise and fall. Try to see if you can figure out what causes the different things you observe.");
                l14q23.setAction(l14q23tfa1);
                TextFeedbackAction l14q23tfa2=new TextFeedbackAction(this,"If the simulation gets to a point where something significant in it completely dies off (the fish, for example), it will automatically stop. When this happens, see if you can use the graphs to figure out what made the organism die.");
                l14q23tfa1.setNextAction(l14q23tfa2);
            QuestionItem l14q24=new QuestionItem("How can I be sure the conclusions I get in the simulations are reliable?");
                TextFeedbackAction l14q24tfa1=new TextFeedbackAction(this,"Good question! The essence of scientific rigor is repeatability. Observing something happening once could just be a random event, but observing something happening over and over again must be something more.");
                l14q24.setAction(l14q24tfa1);
                TextFeedbackAction l14q24tfa2=new TextFeedbackAction(this,"So, if you see something interesting happening in the simulation, try to recreate it again. If you can make the same thing happen over and over, you have a good case for that being a real event.");
                l14q24tfa1.setNextAction(l14q24tfa2);
            l14qla2.addQuestion(l14q21);
            l14qla2.addQuestion(l14q22);
            l14qla2.addQuestion(l14q23);
            l14qla2.addQuestion(l14q24);
        QuestionItem l14q3=new QuestionItem("How do scientists use simulations in research?");
            TextFeedbackAction l14q3tfa1=new TextFeedbackAction(this,"Simulations are used in a lot of different ways in science. First of all, scientists sometimes use simulations to try to figure out what happened in the past. If you can recreate what happened in the lake using the simulation, then it's possible that what you did to recreate the fish die-off is what actually happened in the lake.");
            l14q3.setAction(l14q3tfa1);
            TextFeedbackAction l14q3tfa2=new TextFeedbackAction(this,"Scientists also use simulations to support their hypotheses. You can use a simulation to see if your model accurately predicts what happens in the simulation. If you say that rising levels of ammonia causes fish populations to rise, then observe the opposite happening in the simulation, you know that your model is flawed.");
            l14q3tfa1.setNextAction(l14q3tfa2);
            TextFeedbackAction l14q3tfa3=new TextFeedbackAction(this,"Try to think of the NetLogo simulation as a stand-in for the real system. You can’t put a ton of extra fish into Lake Clara Meer and then watch what happens for the next few years. With these simulations, though, you can simulate years at a time to see how different events change.");
            l14q3tfa2.setNextAction(l14q3tfa3);
            TextFeedbackAction l14q3tfa4=new TextFeedbackAction(this,"Try to think of what you would have to observe in the simulations to make you certain that your model makes sense. Then, try to make that happen!");
            l14q3tfa3.setNextAction(l14q3tfa4);
        l14qla1.addQuestion(l14q1);
        l14qla1.addQuestion(l14q2);
        l14qla1.addQuestion(l14q3);
        l14qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp14,l14ma1));
        
        /* LESSON 15 **********************************************************/
        CurrentLessonPercept clp15=new CurrentLessonPercept(this,"15");
        
        QuestionListAction l15qla1=new QuestionListAction(this);
        MultipleAction l15ma1=new MultipleAction(this,new Action[]{l15qla1,cpaConcernedFront});
        QuestionItem l15q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l15q1tfa1=new TextFeedbackAction(this,"In this lesson, your goal is to explore the different food sources available to fish, and figure out if food might have played a role in the fish die-off.");
            l15q1.setAction(l15q1tfa1);
            TextFeedbackAction l15q1tfa2=new TextFeedbackAction(this,"As you learn about the role of food, think about how a change in the food supply might have affected the fish population. Could it have caused all the fish to die?");
            l15q1tfa1.setNextAction(l15q1tfa2);
            TextFeedbackAction l15q1tfa3=new TextFeedbackAction(this,"If you don't already have any hypotheses that deal with food, try to make one or two. If you've thought about that before, see if the information you learn in this lesson could help make your model better.");
            l15q1tfa2.setNextAction(l15q1tfa3);
//        QuestionItem l15q2=new QuestionItem("Why is food so important in a system?");
//            TextFeedbackAction l15q2tfa1=new TextFeedbackAction(this,"Like Mercer mentioned, every living thing both eats and is eaten. Fish in the lake might eat plants, algae, and other fish, but those things themselves also eat other things.");
//            l15q2.setAction(l15q2tfa1);
//            TextFeedbackAction l15q2tfa2=new TextFeedbackAction(this,"Even though plants don't have mouths, they still eat: they \"eat\" sunlight, nutrients from the soil, and carbon dioxide.");
//            l15q2tfa1.setNextAction(l15q2tfa2);
//            TextFeedbackAction l15q2tfa3=new TextFeedbackAction(this,"What that means is that anything that impacts one part of the food chain impacts the entire system. If fish eat plants and something kills the plants, that also kills the fish!");
//            l15q2tfa2.setNextAction(l15q2tfa3);
//            TextFeedbackAction l15q2tfa4=new TextFeedbackAction(this,"Understanding how the parts of a system interact and affect each other is one of the most complicated ideas in science. Everything from climate change to species extinction, and even unrelated fields like economics or politics, are examples of interacting systems.");
//            l15q2tfa3.setNextAction(l15q2tfa4);
//            TextFeedbackAction l15q2tfa5=new TextFeedbackAction(this,"Try to think of all the different ways a change in food source could impact the lake. Now you're thinking in systems!");
//            l15q2tfa4.setNextAction(l15q2tfa5);
        QuestionItem l15q3=new QuestionItem("How do I say 'fish eat food' in a MILA model?");
            TextFeedbackAction l15q3tfa1=new TextFeedbackAction(this,"Remember, MILA models describe what happened. They aren't meant to describe all the different relationships in the system -- they're meant to describe how a change in one thing led to a change in another thing.");
            l15q3.setAction(l15q3tfa1);
            TextFeedbackAction l15q3tfa2=new TextFeedbackAction(this,"So, think about what the impact of fish eating food actually was in this system. Did a decline in the food quantity lead to a decline in fish populations? If that's the case, you could model it by showing a drop in Food Quantity causing a drop in Fish Population. Remember, though, that it's good to be more specific than \"food\" when referring to what fish eat.");
            l15q3tfa1.setNextAction(l15q3tfa2);
        l15qla1.addQuestion(l15q1);
        //l15qla1.addQuestion(l15q2);
        l15qla1.addQuestion(l15q3);
        l15qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp15,l15ma1));
        
        /* LESSON 16 **********************************************************/
        CurrentLessonPercept clp16=new CurrentLessonPercept(this,"16");
        
        QuestionListAction l16qla1=new QuestionListAction(this);
        MultipleAction l16ma1=new MultipleAction(this,new Action[]{l16qla1,cpaConcernedFront});
        QuestionItem l16q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l16q1tfa1=new TextFeedbackAction(this,"In this lesson, your goal is to understand how real data and simulations can both help a scientist research a problem or phenomenon.");
            l16q1.setAction(l16q1tfa1);
            TextFeedbackAction l16q1tfa2=new TextFeedbackAction(this,"While you use the lake samples as well as the NetLogo simulations, consider what the strengths of each kind of data are. How does the real sample help? What does the simulation give us that the water sample doesn't?");
            l16q1tfa1.setNextAction(l16q1tfa2);
//        QuestionItem l16q2=new QuestionItem("How do scientists use real data like the lake water samples?");
//            TextFeedbackAction l16q2tfa1=new TextFeedbackAction(this,"Science is all about an ongoing process of modeling your understanding, and then using that model to guide further research. Scientists would analyze the water samples, incorporate that information into their models, and then use those models to figure out what to do next.");
//            l16q2.setAction(l16q2tfa1);
//            TextFeedbackAction l16q2tfa2=new TextFeedbackAction(this,"As you analyze the water, ask yourself: does this information help make my model bigger? Does it suggest more components or connections? Does it prove some connections I've already drawn are true? Does it suggest my model is inaccurate?");
//            l16q2tfa1.setNextAction(l16q2tfa2);
        l16qla1.addQuestion(l16q1);
        //l16qla1.addQuestion(l16q2);
        l16qla1.addQuestion(l14q3);
        l16qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp16,l16ma1));
        
        /* LESSON 17 **********************************************************/
        CurrentLessonPercept clp17=new CurrentLessonPercept(this,"17");
        
        QuestionListAction l17qla1=new QuestionListAction(this);
        MultipleAction l17ma1=new MultipleAction(this,new Action[]{l17qla1,cpaInterestedFront});
        QuestionItem l17q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l17q1tfa1=new TextFeedbackAction(this,"Your goal for this lesson is to use the AQWA simulation to learn more about how pollution might have affected the lake.");
            l17q1.setAction(l17q1tfa1);
            TextFeedbackAction l17q1tfa2=new TextFeedbackAction(this,"While you use the simulation, try to look for information that shows your hypotheses are correct, or gives you more information that you can use to make your models bigger and more powerful.");
            l17q1tfa1.setNextAction(l17q1tfa2);
            TextFeedbackAction l17q1tfa3=new TextFeedbackAction(this,"Remember, you can use your Notebook to take notes on the simulation as you go. Later, you can use these notes to put more refined ideas into your models.");
            l17q1tfa2.setNextAction(l17q1tfa3);
//        QuestionItem l17q2=new QuestionItem("How might pollution have affected the lake?");
//            TextFeedbackAction l17q2tfa1=new TextFeedbackAction(this,"In biology, pollution is interesting because it has both a direct effect and an indirect effect. Pollution can directly affect organisms by poisoning them, but it can also affect organisms my poisoning their food supply.");
//            l17q2.setAction(l17q2tfa1);
//            TextFeedbackAction l17q2tfa2=new TextFeedbackAction(this,"Because of this, pollution can have both very clear and very unclear effects on the environment and the ecological systems it comes in contact with. We can never fully understand the damage pollution does.");
//            l17q2tfa1.setNextAction(l17q2tfa2);
        l17qla1.addQuestion(l17q1);
        //l17qla1.addQuestion(l17q2);
        l17qla1.addQuestion(l14q3);
        l17qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp17,l17ma1));
        
        
        /* LESSON 18 **********************************************************/
        CurrentLessonPercept clp18=new CurrentLessonPercept(this,"18");
        
        QuestionListAction l18qla1=new QuestionListAction(this);
        MultipleAction l18ma1=new MultipleAction(this,new Action[]{l18qla1,cpaInterestedFront});
        QuestionItem l18q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l18q1tfa1=new TextFeedbackAction(this,"The goal for this lesson is to understand how oxygen depletion and bacteria can impact the system.");
            l18q1.setAction(l18q1tfa1);
            TextFeedbackAction l18q1tfa2=new TextFeedbackAction(this,"Remember, oxygen and bacteria are two invisible components of the system that can still have enormous visible effects. Changes in the concentration of either could wreak havoc on fish populations.");
            l18q1tfa1.setNextAction(l18q1tfa2);
        QuestionItem l18q2=new QuestionItem("How do scientists figure out how invisible chemicals work?");
            TextFeedbackAction l18q2tfa1=new TextFeedbackAction(this,"A key part of science is modeling the effects of things we can't see, just like you're doing now! The trick is to use what we can test and use that to infer things about what we cannot see.");
            l18q2.setAction(l18q2tfa1);
            TextFeedbackAction l18q2tfa2=new TextFeedbackAction(this,"For example, we cannot directly see oxygen, but we can test for its concentration using technological sensors. Then, we can monitor its change over time, and also watch how the system changes as the oxygen level changes.");
            l18q2tfa1.setNextAction(l18q2tfa2);
            TextFeedbackAction l18q2tfa3=new TextFeedbackAction(this,"Remember as always, science is all about rigor and repeated experiments. Noticing that fish die when oxygen levels drop once is not enough to claim that the oxygen levels caused the fish to die. We have to observe things happening over and over to be sure that they're true.");
            l18q2tfa2.setNextAction(l18q2tfa3);
        QuestionItem l18q3=new QuestionItem("Aren't bacteria bad?");
            TextFeedbackAction l18q3tfa1=new TextFeedbackAction(this,"Bacteria gets a bad rap! Although most of the bacteria we hear about are harmful to us, a lot of bacteria are beneficial. Your body is filled with millions of bacteria right now that help you breathe air and digest food!");
            l18q2.setAction(l18q2tfa1);
            TextFeedbackAction l18q3tfa2=new TextFeedbackAction(this,"The same is true in systems: there exist bacteria that serve help ecological systems behave normally. For example, there exist bacteria called nitrosomonas that eat ammonia and produce nitrite. Ammonia is very poisonous to fish, while nitrite is less harmful -- so, these bacteria help the fish stay healthy by removing poisonous materials!");
            l18q2tfa1.setNextAction(l18q2tfa2);
            TextFeedbackAction l18q3tfa3=new TextFeedbackAction(this,"It's important to remember, though, that the bacteria \"helping\" the fish is only our interpretation. As far as the bacteria know, they're just having a good meal on some yummy ammonia. They don't set out to help the fish, but the system forms itself in such a way that the bacteria's presence helps keeps the fish healthy.");
            l18q2tfa2.setNextAction(l18q2tfa3);
        
        l18qla1.addQuestion(l18q1);
        l18qla1.addQuestion(l18q2);
        l18qla1.addQuestion(l18q3);
        l18qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp18,l18ma1));
        
        
        /* LESSON 19 **********************************************************/
        CurrentLessonPercept clp19=new CurrentLessonPercept(this,"19");
        
        QuestionListAction l19qla1=new QuestionListAction(this);
        MultipleAction l19ma1=new MultipleAction(this,new Action[]{l19qla1,cpaAmazedFront});
        QuestionItem l19q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l19q1tfa1=new TextFeedbackAction(this,"The goal for this lesson is to start to make final progress toward coming up with a good, solid explanation for why the fish in Lake Clara Meer died. Your goal is also to start ruling out some of the hypotheses that don't seem to be true or are difficult to research further.");
            l19q1.setAction(l19q1tfa1);
            TextFeedbackAction l19q1tfa2=new TextFeedbackAction(this,"You've learned all the important skills in the scientific process: data gathering, using simulations, consulting sources, and creating models and hypotheses. Now, it's time to put those skills to the test.");
            l19q1tfa1.setNextAction(l19q1tfa2);
            TextFeedbackAction l19q1tfa3=new TextFeedbackAction(this,"Try to focus on making your models really solid. A good model of these systems will have several components and several connections, each justified with evidence. If you can't go much further with a model, it might be time to dismiss it and focus on your others.");
            l19q1tfa2.setNextAction(l19q1tfa3);
        QuestionItem l19q2=new QuestionItem("How do I know if my model is good?");
            TextFeedbackAction l19q2tfa1=new TextFeedbackAction(this,"In science, there are no right or wrong answers. Scientists try to come up with the best explanations they can of how the world works, and then they defend those explanations with evidence and reasoning.");
            l19q2.setAction(l19q2tfa1);
            TextFeedbackAction l19q2tfa2=new TextFeedbackAction(this,"So, your model is only as good as your argument for it! If you have a large, thorough explanation with lots of evidence, chances are your model is pretty good.");
            l19q2tfa1.setNextAction(l19q2tfa2);
            TextFeedbackAction l19q2tfa3=new TextFeedbackAction(this,"Remember, arguing in science is good! Arguing is what lets us make sure our ideas are very strong. Try to argue against your models and see what other people might have to say.");
            l19q2tfa2.setNextAction(l19q2tfa3);
        
        l19qla1.addQuestion(l19q1);
        l19qla1.addQuestion(l19q2);
        l19qla1.addQuestion(l18q2);
        l19qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp19,l19ma1));
        
        
        /* LESSON 20 **********************************************************/
        CurrentLessonPercept clp20=new CurrentLessonPercept(this,"20");
        
        QuestionListAction l20qla1=new QuestionListAction(this);
        MultipleAction l20ma1=new MultipleAction(this,new Action[]{l20qla1,cpaAmazedFront});
        QuestionItem l20q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l20q1tfa1=new TextFeedbackAction(this,"For this lesson, your goal is to make your scientific claims and arguments even better.");
            l20q1.setAction(l20q1tfa1);
            TextFeedbackAction l20q1tfa2=new TextFeedbackAction(this,"Up until now, you've been finding evidence for your models and hypotheses. Today, try to make sure everything that you're claiming is very, very solid.");
            l20q1tfa1.setNextAction(l20q1tfa2);
            TextFeedbackAction l20q1tfa3=new TextFeedbackAction(this,"Remember, in science, argumentation is good! Argue against your models and see where their weaknesses are, and see if that can help you make them more solid.");
            l20q1tfa2.setNextAction(l20q1tfa3);
        QuestionItem l20q2=new QuestionItem("How do scientists make arguments?");
            TextFeedbackAction l20q2tfa1=new TextFeedbackAction(this,"In science, arguing is good! It's only because we argue that we figure things out. Imagine a world in which scientists always accepted the very first thing that was proposed. We'd still think the sun revolved around the earth!");
            l20q2.setAction(l20q2tfa1);
            TextFeedbackAction l20q2tfa2=new TextFeedbackAction(this,"So, when scientists argue, they present their evidence. They say, \"This explanation is right because all of this evidence supports it.\" So, in making your models and explanations, make sure you're defending them with lots of good evidence.");
            l20q2tfa1.setNextAction(l20q2tfa2);
        QuestionItem l20q3=new QuestionItem("What is good evidence?");
            TextFeedbackAction l20q3tfa1=new TextFeedbackAction(this,"There's lots of different kinds of evidence, and some is better than others. The best kind of data is always actual observations. Actual observations show that there is something in the real world that supports your explanation.");
            l20q3.setAction(l20q3tfa1);
            TextFeedbackAction l20q3tfa2=new TextFeedbackAction(this,"Other kinds of evidence include information from experts, established scientific theories, and logical explanations. Try to use real data and observations as much as possible, along with established scientific theories.");
            l20q3tfa1.setNextAction(l20q3tfa2);
        
        l20qla1.addQuestion(l20q1);
        l20qla1.addQuestion(l20q2);
        l20qla1.addQuestion(l20q3);
        l20qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp20,l20ma1));
        
        
        /* LESSON 21 **********************************************************/
        CurrentLessonPercept clp21=new CurrentLessonPercept(this,"21");
        
        QuestionListAction l21qla1=new QuestionListAction(this);
        MultipleAction l21ma1=new MultipleAction(this,new Action[]{l21qla1,cpaExcitedFront});
        QuestionItem l21q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l21q1tfa1=new TextFeedbackAction(this,"We're coming down to the end! Today should be the day you really reach a consensus on what models you think are strong enough to present.");
            l21q1.setAction(l21q1tfa1);
            TextFeedbackAction l21q1tfa2=new TextFeedbackAction(this,"Tomorrow, you'll be getting your presentation ready to show our visitors your explanations of the fish die-off. You'll be showing them your models, so try to choose which models you have you really want to present.");
            l21q1tfa1.setNextAction(l21q1tfa2);
        QuestionItem l21q2=new QuestionItem("What does consensus mean in science?");
            TextFeedbackAction l21q2tfa1=new TextFeedbackAction(this,"'Consensus' means agreement. We've said before that in science there is no 'right' or 'wrong', so how do we know things like gravity and photosynthesis exist? The answer is that scientists, thanks to lots of data, have come to a consensus that these are true.");
            l21q2.setAction(l21q2tfa1);
            TextFeedbackAction l21q2tfa2=new TextFeedbackAction(this,"'Consensus' doesn't have to mean only one explanation. Scientists can come to consensus that some explanations are good and some are bad, and focus on the good ones. Try to come to a consensus in your group about which models are strong enough to present.");
            l21q2tfa1.setNextAction(l21q2tfa2);
        QuestionItem l21q3=new QuestionItem("How do we know which of our models are best?");
            TextFeedbackAction l21q3tfa1=new TextFeedbackAction(this,"A good model has several features. The best models will have as much evidence as possible -- ideally, everything in your model should have evidence supporting it.");
            l21q3.setAction(l21q3tfa1);
            TextFeedbackAction l21q3tfa2=new TextFeedbackAction(this,"A good model should also be complex and large enough to explain a complex phenomenon. The fish die-off is a complicated problem, so you should have several components in your model to explain it.");
            l21q3tfa1.setNextAction(l21q3tfa2);
        
        l21qla1.addQuestion(l21q1);
        l21qla1.addQuestion(l21q2);
        l21qla1.addQuestion(l21q3);
        l21qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp21,l21ma1));
        
        
        /* LESSON 23 **********************************************************/
        CurrentLessonPercept clp23=new CurrentLessonPercept(this,"23");
        
        QuestionListAction l23qla1=new QuestionListAction(this);
        MultipleAction l23ma1=new MultipleAction(this,new Action[]{l23qla1,cpaExcitedFront});
        QuestionItem l23q1=new QuestionItem("What is the goal for this lesson?");
            TextFeedbackAction l23q1tfa1=new TextFeedbackAction(this,"In this lesson, your goal is to make your presentation for our visitors. Try to decide what three models (or fewer) that you want to present tomorrow.");
            l23q1.setAction(l23q1tfa1);
        QuestionItem l23q2=new QuestionItem("How do I put my models on a poster?");
            TextFeedbackAction l23q2tfa1=new TextFeedbackAction(this,"To put a model on a poster, you'll need to make it an image. Click the Save Model as Image button, then ask one of your teachers for help printing it.");
            l23q2.setAction(l23q2tfa1);
        
        l23qla1.addQuestion(l23q1);
        l23qla1.addQuestion(l23q2);
        l23qla1.addQuestion(l21q3);
        l23qla1.addQuestion(l9q4);
        
        addMapping(new Mapping(clp23,l23ma1));
        
        
        /* END LESSON-SPECIFIC CONTENT ****************************************/
        
        TruePercept tp1=new TruePercept(this);
        TextFeedbackAction tfa1=new TextFeedbackAction(this,"I don't really have anything to say right now.");
        Mapping m1=new Mapping(tp1,new MultipleAction(this,new Action[]{cpaNeutralSide,tfa1}));
        addMapping(m1);
        

        
    }
}
