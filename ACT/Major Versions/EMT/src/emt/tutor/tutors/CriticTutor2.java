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
        nullMA.addAction(cpaNeutralSide);
        myNullAction=nullMA;        
        
        r=new Random();
    }
    
    @Override
    public void checkMappings() {
        ArrayList<Action> foundActions=new ArrayList<Action>();
        if(this.getModelCount('a')==0) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"Right now, you haven't created any models. I can only see the model you have selected, so go ahead and create one by clicking Propose New Hypothesis. If you need help, ask Gabriel the Guide.");
            tfa1.setFace(cpaConfusedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>0) { chooseAndDoAction(foundActions); return; }
        
        if(this.getModel().getNodes().isEmpty()) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"It doesn't look like you've added anything to this model. Start by adding something to your model. If you need help with that, you can ask Gabriel.");
            tfa1.setFace(cpaConfusedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>0) { chooseAndDoAction(foundActions); return; }
        
        if(this.getModel().getNodes().size()==1) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"So far, you've only added one thing to your model. You'll need to add some more to start drawing connections and explaining the phenomenon.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"At the beginning, your model should usually contain two things: what happened, and what you think caused it. Then, you can explain how your hypothesis caused it to happen by expanding your model.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaConfusedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>0) { chooseAndDoAction(foundActions); return; }
        
        if(this.getModel().getNodes().size()==2) {
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
        if(this.getModel().getEdges().isEmpty()) {
            TextFeedbackAction tfa1=new TextFeedbackAction(this,"You're off to a good start on your way to creating a good model. What you want to do next is link the things in your model together in order to show what is causing what else to happen.");
            TextFeedbackAction tfa2=new TextFeedbackAction(this,"If you need help drawing connections, ask Gabriel the Guide for help with drawing MILA models.");
            tfa1.setNextAction(tfa2);
            tfa1.setFace(cpaConcernedFront);
            foundActions.add(tfa1);
        }
        if(foundActions.size()>0) { chooseAndDoAction(foundActions); return; }
    }
    public void chooseAndDoAction(ArrayList<Action> actions) {
        int c=r.nextInt(actions.size());
        actions.get(c).doAction();
    }
}