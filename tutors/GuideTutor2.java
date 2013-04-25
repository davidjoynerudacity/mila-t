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
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class GuideTutor2 extends OnDemandTutor {
    public GuideTutor2() {
        super("Guide");
        
        initializeTutor();
    }

    public GuideTutor2(ProjectModelPanel modelPanel) {
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
        
        //Check if phenomenon has been written
        PhenomenonUnwrittenPercept pwp=new PhenomenonUnwrittenPercept(this);
        QuestionItem QIphenomenon=new QuestionItem("How do I describe my phenonemon?");
        TextFeedbackAction tfaPhenomenon1=new TextFeedbackAction(this,"A phenomenon description gives a nice, clear, concise description of exactly what it is you are trying to explain.");
        TextFeedbackAction tfaPhenomenon2=new TextFeedbackAction(this,"Ask yourself what you are trying to explain, then try to write down how you would describe that to another person.");
        TextFeedbackAction tfaPhenomenon3=new TextFeedbackAction(this,"Your phenomenon will be the final piece of every scientific model you make, so you can try to think of where your models will lead.");
        tfaPhenomenon1.setNextAction(tfaPhenomenon2);
        tfaPhenomenon2.setNextAction(tfaPhenomenon3);
        QIphenomenon.setAction(tfaPhenomenon1);
        HoldQuestionsAction hqaPhenomenon=new HoldQuestionsAction(this);
        hqaPhenomenon.addQuestion(QIphenomenon);
        addMapping(new Mapping(pwp,hqaPhenomenon));
        
        //Check if there are a lot of models and if the current model is very good
        NodeCountPercept ncp5=new NodeCountPercept(this,5,'>');
        EvidencedConnectionCountPercept eccp3=new EvidencedConnectionCountPercept(this,3,'>');
        ModelCountPercept mcp3=new ModelCountPercept(this,1,'>','c');
        QuestionItem QIdismiss1=new QuestionItem("Should I dismiss some of my other hypotheses?");
        TextFeedbackAction tfaDismiss1=new TextFeedbackAction(this,"It's important to know when to dismiss a hypothesis when you're investigating a system.");
        TextFeedbackAction tfaDismiss2=new TextFeedbackAction(this,"Sometimes you dismiss a hypothesis because you have evidence that it's false. Other times, you dismiss it because you can't find any evidence about it either way.");
        TextFeedbackAction tfaDismiss3=new TextFeedbackAction(this,"Your current model looks like it's coming along nicely, but you're still considering a couple other hypotheses as well. It might be time to consider dismissing some of your other ideas to focus on the more promising ones.");
        tfaDismiss1.setNextAction(tfaDismiss2);
        tfaDismiss2.setNextAction(tfaDismiss3);
        QIdismiss1.setAction(tfaDismiss1);
        MultiplePercept mpDismiss1=new MultiplePercept(this);
        mpDismiss1.addPercept(ncp5);
        mpDismiss1.addPercept(eccp3);
        mpDismiss1.addPercept(mcp3);
        HoldQuestionsAction hqaDismiss1=new HoldQuestionsAction(this);
        hqaDismiss1.addQuestion(QIdismiss1);
        addMapping(new Mapping(mpDismiss1,hqaDismiss1));
        
        //Check if there are a lot of models and if the current model is not so good
        NodeCountPercept ncp3=new NodeCountPercept(this,4,'<');
        QuestionItem QIdismiss2=new QuestionItem("Should I dismiss this hypothesis?");
        TextFeedbackAction tfaDismiss4=new TextFeedbackAction(this,"It's good that you're thinking about dismissing some of your original hypotheses -- that is how we narrow down our ideas for what causes a phenomenon.");
        TextFeedbackAction tfaDismiss5=new TextFeedbackAction(this,"It looks like this model is a little sparse, and you have a couple others that you're working on. It might be time to focus on one of those and dismiss this one if they have more potential.");
        tfaDismiss4.setNextAction(tfaDismiss5);
        QIdismiss2.setAction(tfaDismiss4);
        MultiplePercept mpDismiss2=new MultiplePercept(this);
        mpDismiss2.addPercept(mcp3);
        mpDismiss2.addPercept(ncp3);
        HoldQuestionsAction hqaDismiss2=new HoldQuestionsAction(this);
        hqaDismiss2.addQuestion(QIdismiss2);
        addMapping(new Mapping(mpDismiss2,hqaDismiss2));
        
        //Check if there's an algae node and offer information if so
        PresentNodePercept pnp1=new PresentNodePercept(this,"Algae");
        QuestionItem q5=new QuestionItem("What roles could algae play in an ecological system?");
        TextFeedbackAction tfa1=new TextFeedbackAction(this,"Algae gets involved in ecological systems in a lot of ways.");
        TextFeedbackAction tfa2=new TextFeedbackAction(this,"Algae consumes carbon dioxide and produces oxygen, so if the algae dies off, it could cause oxygen levels to drop.");
        TextFeedbackAction tfa3=new TextFeedbackAction(this,"Some kinds of algae also produce poisons. Blue-green algae are especially notorious for producing chemicals that are poisonous to fish and humans.");
        TextFeedbackAction tfa4=new TextFeedbackAction(this,"Other forms of algae actually eat things that are harmful to fish or humans, so if algae dies off, it could cause the concentration of these poisons to spike.");
        TextFeedbackAction tfa5=new TextFeedbackAction(this,"Try conducting some experiments or looking at some scientific principles to figure out how algae might be related to your phenomenon.");
        tfa1.setNextAction(tfa2);
        tfa2.setNextAction(tfa3);
        tfa3.setNextAction(tfa4);
        tfa4.setNextAction(tfa5);
        q5.setAction(tfa1);
        HoldQuestionsAction hqa2=new HoldQuestionsAction(this);
        hqa2.addQuestion(q5);
        addMapping(new Mapping(pnp1,hqa2));
        
        //Check if there's a bacteria node and offer information if so
        PresentNodePercept pnpBacteria=new PresentNodePercept(this,"Bacteria");
        QuestionItem QIBacteria=new QuestionItem("What roles could bacteria play in an ecological system?");
        TextFeedbackAction tfaBacteria1=new TextFeedbackAction(this,"Bacteria interacts with lots of different systems in lots of different ways.");
        TextFeedbackAction tfaBacteria2=new TextFeedbackAction(this,"Some bacteria are known to eat chemicals that are harmful to fish. Nitrosomonas, for example, eat the ammonia in waste, cleaning up the water.");
        TextFeedbackAction tfaBacteria3=new TextFeedbackAction(this,"Other bacteria, though, can be harmful or poisonous. Some cause diseases, while others produce chemicals that are deadly in large quantities.");
        TextFeedbackAction tfaBacteria4=new TextFeedbackAction(this,"Try looking at the bacteria that are in the system you're exploring to try to figure out what role they could have played in your phenomenon.");
        tfaBacteria1.setNextAction(tfaBacteria2);
        tfaBacteria2.setNextAction(tfaBacteria3);
        tfaBacteria3.setNextAction(tfaBacteria4);
        QIBacteria.setAction(tfaBacteria1);
        HoldQuestionsAction hqaBacteria=new HoldQuestionsAction(this);
        hqaBacteria.addQuestion(QIBacteria);
        addMapping(new Mapping(pnpBacteria,hqaBacteria));
        
        
        TruePercept tp1=new TruePercept(this);
        QuestionItem q1=new QuestionItem("How do I create MILA models?");
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
        
        QuestionItem q2=new QuestionItem("How do I take notes?");
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
        
        QuestionItem q3=new QuestionItem("How do I use the tutors?");
        QuestionListAction tutorsQs=new QuestionListAction(this);
        q3.setAction(tutorsQs);
        QuestionItem tutorQ1=new QuestionItem("How should I use Gabriel the Guide?", new TextFeedbackAction(this,"I'm here to try to answer any of your questions. Whenever you need help or want to ask something about MILA or the lesson for the day, just click me and I'll do my best to help! I'll never interrupt you, so make sure to click me if you need me."));
        QuestionItem tutorQ2=new QuestionItem("How should I use Craig the Critic?", new TextFeedbackAction(this,"Craig is here to look at your models and see if they show what you're trying to learn for the day. When you think your model is in good shape or you don't know what else to do with it, click him to see if he has any suggestions."));
        QuestionItem tutorQ3=new QuestionItem("How should I use Mercer the Mentor?", new TextFeedbackAction(this,"Mercer is always keeping track of what you're doing, and when he has something to say, he'll appear with his little lightbulb. When you see that, click him to get his feedback or suggestions."));
        QuestionItem tutorQ4=new QuestionItem("How should I use Isla the Interviewer?", new TextFeedbackAction(this,"Isla's goal is to ask you questions to understand a little more what you're thinking or what you've learned. When you see her appear with her lightbulb, click her to give her your thoughts on whatever she's asking. Sometimes she’ll ask you what you learned on trips to the aquarium or the lake, while other times she’ll ask you about your ideas in your models."));
        tutorsQs.addQuestion(tutorQ1);
        tutorsQs.addQuestion(tutorQ2);
        tutorsQs.addQuestion(tutorQ3);
        tutorsQs.addQuestion(tutorQ4);
        
        QuestionItem q4=new QuestionItem("What makes a good scientific model?",milaQ4.getAction());
        
        HoldQuestionsAction hqa1=new HoldQuestionsAction(this);
        hqa1.getQuestions().add(q4);
        hqa1.getQuestions().add(q1);
        hqa1.getQuestions().add(q2);
        hqa1.getQuestions().add(q3);
        addMapping(new Mapping(tp1,hqa1));
        
    }
    
    @Override
    public void checkMappings() {
        try {
            ArrayList<QuestionItem> questionsToAsk=new ArrayList<QuestionItem>();
            for(Mapping mapping : myMappings) {
                HoldQuestionsAction result=(HoldQuestionsAction)mapping.check();
                if(result!=null) {
                        questionsToAsk.addAll(result.getQuestions());
                }
            }
            
            QuestionListAction top=new QuestionListAction(this);
            QuestionListAction current=top;
            int qIndex=0;
            while(questionsToAsk.size()>0) {
                current.addQuestion(questionsToAsk.get(0));
                questionsToAsk.remove(0);
                qIndex++;
                
                if(qIndex==3) {
                    qIndex=0;
                    QuestionListAction next=new QuestionListAction(this);
                    current.addQuestion(new QuestionItem("See more questions...",next));
                    current=next;
                }
            }
            current.addQuestion(new QuestionItem("See more questions...",top));
            top.doAction();
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
