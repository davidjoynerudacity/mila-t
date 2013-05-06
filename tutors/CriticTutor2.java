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
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author David
 */
public class CriticTutor2 extends OnDemandTutor {
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
    
    Random r;
    
    public CriticTutor2() {
        super("Critic");
        initializeTutor();
    }

    public CriticTutor2(ProjectModelPanel modelPanel) {
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
        
        MultipleAction nullMA=new MultipleAction(this);
        nullMA.addAction(cpaHappySide);
        myNullAction=nullMA;        
        
        r=new Random();
    }
    
    @Override
    public void checkMappings() {
        ArrayList<Action> foundActions=new ArrayList<Action>();
        if(this.getModelCount('a')==0) { //no models
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"Right now, you haven't created any models. I can only see the model you have selected, so go ahead and create one by clicking Propose New Hypothesis. If you need help, ask Gabriel the Guide.");
            tfa1.setFace(cpaConfusedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>0) { chooseAndDoAction(foundActions); return; }
        
        if(this.getModelCount('c')==0&&this.getModelCount('d')>0) { //all models dismissed
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like you've dismissed all your hypotheses. It's good that you've disproved so many ideas! Try to come up with a new idea for what might have cause the phenomenon to continue.");
            tfa1.setFace(cpaHappyFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>0) { chooseAndDoAction(foundActions); return; }
        
        if(this.getModel().getNodes().isEmpty()) { //empty model
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"It doesn't look like you've added anything to this model. Start by adding something to your model. If you need help with that, you can ask Gabriel.");
            tfa1.setFace(cpaConfusedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>0) { chooseAndDoAction(foundActions); return; }
        
        if(this.getModel().getNodes().size()==1) { //only one node
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"So far, you've only added one thing to your model. You'll need to add some more to start drawing connections and explaining the phenomenon.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"At the beginning, your model should usually contain two things: what happened, and what you think caused it. Then, you can explain how your hypothesis caused it to happen by expanding your model.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaConfusedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>0) { chooseAndDoAction(foundActions); return; }
        
        if(this.getModel().getNodes().size()==2) { //only two nodes
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"So far, you have two things in this model: that's a good start. Your next step is to describe in more detail how one thing caused the other to happen.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"There is likely a complicated process that caused the phenomenon you're investigating. Try to find some information on how the two things you've put in your model relate to each other.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaConcernedFront);
            foundActions.add(tfa1);
            
            TextFeedbackAction tfa3=new TextFeedbackAction(this,"How might the two things in your model be related? For example, if we were talking about pollution killing off an insect population, we might look into why pollution affected the insects.");
            TextFeedbackAction tfa4=new TextFeedbackAction(this,"Pollution could directly poison an insect. Or, pollution could kill a bacteria or plant that the insect relies on for food. Or, pollution could have killed a bacteria that eats a chemical that is poisonous to the insect. It can get complicated, but that's part of what makes it a good explanation!");
            tfa3.setNextAction(tfa4);
            tfa3.setFace(cpaConcernedFront);
            foundActions.add(tfa3);
        }
        if(this.getModel().getEdges().isEmpty()) { //no connections
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"You're off to a good start on your way to creating a good model. What you want to do next is link the things in your model together in order to show what is causing what else to happen.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"If you need help drawing connections, ask Gabriel the Guide for help with drawing MILA models.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaConcernedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>1) { chooseAndDoAction(foundActions); return; }
        
        if(this.getModel().getNodes().size()==3) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"So far, you have three things in this model. That's a good place to start, but a complex phenomenon probably needs a more thorough explanation.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"Try to look at models of other systems to see how they bring out the mechanisms of different phenomena.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        EvexNode emptyNode=this.getModel().getEmptyNode();
        if(emptyNode!=null) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like one of your nodes is totally empty. Make sure every node in your model has both a component and a property.");
            tfa1.setFace(cpaConcernedFront);
            foundActions.add(tfa1);
        }
        EvexNode nodeWithoutComponent=this.getModel().getNodeWithoutComponent();
        if(nodeWithoutComponent!=null) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like one of your nodes -- your " + nodeWithoutComponent.getComponent() + " node -- doesn't have a component listed.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"Make sure to list what physical piece of the system this node represents, such as water, a chemical, or an organism.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        EvexNode nodeWithoutProperty=this.getModel().getNodeWithoutProperty();
        if(nodeWithoutProperty!=null) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"One of your nodes -- your " + nodeWithoutProperty.getName() + " node -- doesn't have a variable listed.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"A variable is what feature of the physical part of the system is changing. For example, if the temperature of a lake is going up, then the Water is the component and the Temperature is the variable.");
            TextFeedbackAction tfa3=new TextFeedbackAction(this,"If a certain organism or creature is dying off, then the Creature is the component and its Population is the variable.");
            TextFeedbackAction tfa4=new TextFeedbackAction(this,"Try to think of what variable of your component is changing. Or, if what you've written as your component is actually a variable, try to think of what it's a variable of.");
            tfa1.setNextAction(tfa2);
            tfa2.setNextAction(tfa3);
            tfa3.setNextAction(tfa4);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>2) { chooseAndDoAction(foundActions); return; }
        
        EvexNode unconnectedNode=this.getModel().getUnconnectedNode();
        if(unconnectedNode!=null) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like right now something in your model -- " + unconnectedNode.toString() + " -- isn't connected to anything else.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"If that part of your model isn't actually affecting anything, you might want to take it out. Or, if you're waiting to figure out later how it might be importan, that's fine, too.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        if(this.getModel().getEvidencedEdgeCount()==0) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"You've started to build a pretty big model, so it's time to start justifying some of your claims with evidence.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"To add evidence to your connections, click on the blue line. When you've added some evidence to a connection, it will turn green to show you that connection has evidence for it.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        EvexEdge edgeWithoutEvidenceType=this.getModel().getEvidencedEdgeWithoutType();
        if(edgeWithoutEvidenceType!=null) { //edge without a type for one piece of evidence
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"On the connection you drew between " + edgeWithoutEvidenceType.getDirectedSource().toString() + " and " + edgeWithoutEvidenceType.getDirectedDest().toString() + ", one of your pieces of evidence doesn't have a type listed.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"It's important to understand what kind of evidence you're providing, so make sure to put a category for each piece of evidence you write.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaConcernedFront);
            foundActions.add(tfa1);
        }
        EvexEdge edgeWithoutEvidenceText=this.getModel().getEvidencedEdgeWithoutText();
        if(edgeWithoutEvidenceText!=null) { //edge without a type for one piece of evidence
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"On the connection you drew between " + edgeWithoutEvidenceType.getDirectedSource().toString() + " and " + edgeWithoutEvidenceType.getDirectedDest().toString() + ", you've selected a category for a piece of evidence, but you haven't actually written your evidence down.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"After selecting a category for your piece of evidence, write down what exactly the evidence is to the right.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaConcernedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>0) { chooseAndDoAction(foundActions); return; }
        
        if(this.getModel().hasNode("Food")) { //has a 'food' node
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"In your model right now, you're referring to 'food' as a component. 'Food' is kind of an abstract concept, though.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"Try to be more specific. What is the food? Is it plants? Other animals? Plankton, bacteria, or other micro-organisms?");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        if(this.getModel().getNodes().size()==4) { //only 4 nodes
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"Right now, your model has four things in it. That's getting to be a pretty good model, but most phenomena will need more to explain them.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"Try to be more detailed about how certain things are causing other things to happen. Or, you could try to explain what caused your hypothesis to happen in the first place.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        if(this.getModel().getEdges().size()-this.getModel().getEvidencedEdgeCount()>2) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like your model still has a few connections that don't have any evidence to support them.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"You can always add evidence later, but you probably want to make sure your model is worth pursuing by supporting some of your connections with evidence before you go further.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        ArrayList<String> typesOfEvidenceUsed=this.getModel().getTypesOfEvidenceUsed();
        if(typesOfEvidenceUsed.size()==1) { //only one kind of evidence used
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"Right now, your model is relying only on one kind of evidence -- " + typesOfEvidenceUsed.get(0) + ". Any explanation that only has one kind of evidence, though, is pretty weak.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"Try to come up with other things that give support to your model. If you can defend your model with multiple kinds of evidence, you're well on your way to make a good argument.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        if(typesOfEvidenceUsed.size()==2) { //only two kinds of evidence used
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"Right now, you're only using two kinds of evidence -- " + typesOfEvidenceUsed.get(0) + " and " + typesOfEvidenceUsed.get(1) + ".");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"There are several other kinds of evidence out there, though. Even if you're just supporting your model with your own observations, that can still make your model a bit stronger.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        if(typesOfEvidenceUsed.size()==3) { //only three kinds of evidence used
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"You're using three kinds of evidence throughout your model -- " + typesOfEvidenceUsed.get(0) + ", " + typesOfEvidenceUsed.get(1) + ", and " + typesOfEvidenceUsed.get(1) + ". You're coming along nicely, but you could still make your evidence a bit broader.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this);
            if(!typesOfEvidenceUsed.contains("Expert Information")) {
                tfa2.setFeedback("Try looking at some established sources, articles, or textbooks about this kind of phenomenon. Experts might have something useful for you to use!");
            } else if(!typesOfEvidenceUsed.contains("Similar System Observation")) {
                tfa2.setFeedback("Try finding some similar systems and seeing what happened in them. If you can show that your model describes other similar phenomena, that's great support for your explanation of this one.");
            }
                else if(!typesOfEvidenceUsed.contains("Simulation Observation")) {
                tfa2.setFeedback("Try using a simulation and see if you can recreate the events from the phenomenon itself. If you see the simulation demonstrate the same thing that your model says, that's great evidence for your hypothesis.");
            } else {
                tfa2.setFeedback("Controlled experiments are hard to do in ecological systems, but try to think of a way you could control for some variables and observe their effects.");
            }
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaHappyFront);
            foundActions.add(tfa1);
        }
        if(!(this.getModel().hasParallelCauses())&&!(this.getModel().hasParallelEffects())) { //overly simple model
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"It looks like right now your model is pretty simple and straightforward, with a straight line each thing causing the next thing to happen.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"Most systems aren't that simple though. What else is happening in the system? Do any of the things that you see happening have more than one effect? Or are they caused by more than one thing?");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaInterestedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>1) { chooseAndDoAction(foundActions); return; }
        
        ArrayList<EvexEdge> weakEvidenceEdges=this.getModel().getEdgesByMaxScore(3);
        for(EvexEdge weakEdge : weakEvidenceEdges) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this);
            TextFeedbackAction tfa2=new TextFeedbackAction(this);
            if(weakEdge.getDetailedEvidence().isEmpty()) {
                tfa1.setFeedback("It looks like your connection between " + weakEdge.getDirectedSource().toString() + " and " + weakEdge.getDirectedDest().toString() + " doesn't have any evidence to support it.");
                tfa2.setFeedback("Try to find a way to defend this connection to somene else. Why do you believe this connection is true? How do you know?");
            } else if(weakEdge.getEvidenceScore()==1) {
                tfa1.setFeedback("For your connection between " + weakEdge.getDirectedSource().toString() + " and " + weakEdge.getDirectedDest().toString() + ", you only have one kind of evidence, and it isn't a particularly strong kind.");
                tfa2.setFeedback("Try to support this connection further with some Expert Information, some observations from a similar system, or perhaps even a Controlled Experiment.");
            } else if(weakEdge.getEvidenceScore()==2&&weakEdge.getDetailedEvidence().size()==2) {
                tfa1.setFeedback("For your connection between " + weakEdge.getDirectedSource().toString() + " and " + weakEdge.getDirectedDest().toString() + ", you've got two pieces of evidence. That's a good start, but neither of the ones you have right now are particularly strong.");
                tfa2.setFeedback("Try to make your argument stronger by mentioning some Expert Information. You might also try to do a Controlled Experiment, or even consult a simulation.");
            } else if(weakEdge.getEvidenceScore()==2&&weakEdge.getDetailedEvidence().size()==1) {
                tfa1.setFeedback("For your connection between " + weakEdge.getDirectedSource().toString() + " and " + weakEdge.getDirectedDest().toString() + ", you've got one pretty good piece of evidence so far. Well done!");
                tfa2.setFeedback("Try to make this connection very strong by adding some Expert Information or some observations from a similar system.");
            } else {
                tfa1.setFeedback("For your connection between " + weakEdge.getDirectedSource().toString() + " and " + weakEdge.getDirectedDest().toString() + ", it's coming along nicely, but you could make the evidence a bit stronger.");
                tfa2.setFeedback("Try to make this connection very strong by adding a couple other pieces of strong evidence.");
            }
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaAmazedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>2) { chooseAndDoAction(foundActions); return; }
        
        ArrayList<EvexEdge> weakEvidenceEdges2=this.getModel().getEdgesByMaxScore(5);
        for(EvexEdge weakEdge : weakEvidenceEdges2) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this);
            TextFeedbackAction tfa2=new TextFeedbackAction(this);
            if(weakEdge.getDetailedEvidence().size()==4&&weakEdge.getEvidenceScore()==4) {
                tfa1.setFeedback("For your connection between " + weakEdge.getDirectedSource().toString() + " and " + weakEdge.getDirectedDest().toString() + ", you've got lots of evidence, but not very strong-looking evidence.");
                tfa2.setFeedback("You're almost there, but try to make this connection even clearer with some Expert Information or Similar System Observation.");
            } else {
                tfa1.setFeedback("For your connection between " + weakEdge.getDirectedSource().toString() + " and " + weakEdge.getDirectedDest().toString() + ", you've done a pretty good job of defending it with some good evidence.");
                tfa2.setFeedback("You're almost there, now try to finish it off with one or two more pieces of strong, good evidence. Focus on either Expert Information, Similar System Observations, Simulation Observations, or even a Controlled Experiment");
            } 
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaExcitedFront);
            foundActions.add(tfa1);
        }
        if(this.getModel().getNodes().size()==5) { //only 5 nodes
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"Five nodes can make a pretty strong model, but for most complex phenomena, the explanation get be even bigger and more detailed.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"Try to be more clear about at least one connection and add another node in it. I won't ask you to make your model bigger than six nodes, but if you can be even more clear, go for it!");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaExcitedFront);
            foundActions.add(tfa1);
        }
        
        if(foundActions.size()>0) { chooseAndDoAction(foundActions); return; }

        TextFeedbackAction tfa1=new TextFeedbackAction(this,"Great model! I actually do not see anything I can suggest for improving it.");
        TextFeedbackAction tfa2=new TextFeedbackAction(this,"Remember, though, that other humans are better critics of your theories and models than we are. Ask your teachers, classmates, or group members what weaknesses they can see in your model and see if you can find any room for improvement!");
        tfa1.setNextAction(tfa2);
        tfa1.setFace(cpaExcitedFront);
        tfa1.doAction();
    }
    public void chooseAndDoAction(ArrayList<Action> actions) {
        int c=r.nextInt(actions.size());
        actions.get(c).doAction();
    }
}