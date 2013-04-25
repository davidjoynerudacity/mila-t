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
public class CriticTutor2 extends OnDemandTutor {
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
        
        /* GLOBAL INITIAL MAPPINGS ********************************************/
        ModelCountPercept mcp0=new ModelCountPercept(this,0);
        MultipleAction gma0=new MultipleAction(this,new Action[]{cpaConcernedFront,new TextFeedbackAction(this,"Right now, you haven't created any models. I can only see the model you have selected, so go ahead and create one by clicking Propose New Hypothesis. If you need help, ask Gabriel the Guide.")});
        addMapping(new Mapping(mcp0,gma0));
        NoModelSelectedPercept nmsp=new NoModelSelectedPercept(this);
        MultipleAction gma1=new MultipleAction(this,new Action[]{cpaConcernedFront,new TextFeedbackAction(this,"It doesn't look like you have a model selected. I can only see the model you have selected, so select or create one and then ask for my help again.")});
        addMapping(new Mapping(nmsp,gma1));
        
        NodeCountPercept l15ncp1=new NodeCountPercept(this,0);
        TextFeedbackAction l15tfa1=new TextFeedbackAction(this,"It looks like right now there isn't anything in your model. Try adding a component first. The first component should usually be the one that shows the phenomenon -- for example, that fish in the lake are dying.");
        MultipleAction l15ma1=new MultipleAction(this,new Action[]{l15tfa1,cpaConfusedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15ncp1}),l15ma1));
        
        AbsentNodePercept l15anp1=new AbsentNodePercept(this,"Fish","Population");
        TextFeedbackAction l15tfa2=new TextFeedbackAction(this,"The phenomenon you're describing is that the fish population is dropping, but I don't see a component for that. Try adding a component Fish with a variable Population, and set the arrow to the red downward arrow.");
        MultipleAction l15ma2=new MultipleAction(this,new Action[]{l15tfa2,cpaConfusedFront}); 
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15anp1}),l15ma2));
        
        NodeCountPercept l15ncp2=new NodeCountPercept(this,1);
        TextFeedbackAction l15tfa3=new TextFeedbackAction(this,"You've created your Fish Population component, but there isn't anything else in your model. Try adding another component next.");
        MultipleAction l15ma3=new MultipleAction(this,new Action[]{l15tfa3,cpaConfusedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15ncp2}),l15ma3));
        
        ConnectionCountPercept l15ccp1=new ConnectionCountPercept(this,0);
        TextFeedbackAction l15tfa4=new TextFeedbackAction(this,"You've got more than one component, so now it's time to connect them together in some way. How do these two components relate to each other? Drag a connection from one component to the other.");
        MultipleAction l15ma4=new MultipleAction(this,new Action[]{l15tfa4,cpaConcernedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15ccp1}),l15ma4));
        
        NodeCountPercept l15ncp3=new NodeCountPercept(this,3,'<');
        TextFeedbackAction l15tfa5=new TextFeedbackAction(this,"You've got a simple model connecting two components. Now, try to make this model more complete. What other components are important to this model?");
        MultipleAction l15ma5=new MultipleAction(this,new Action[]{l15tfa5,cpaConcernedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15ncp3}),l15ma5));
        
        ConnectionCountPercept l15ccp2=new ConnectionCountPercept(this,1);
        TextFeedbackAction l15tfa6=new TextFeedbackAction(this,"Good! You've started to add more components to your model. Now, try to think of how they are connected. In a good model, every component is connected to at least one other component.");
        MultipleAction l15ma6=new MultipleAction(this,new Action[]{l15tfa6,cpaConcernedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15ccp2}),l15ma6));
        
        MissingPropertiesPercept l15mpp1=new MissingPropertiesPercept(this);
        TextFeedbackAction l15tfa7=new TextFeedbackAction(this,"It looks like not all your components have variables written for them. Remember, a component is just the physical piece of the system -- the variables are what change. For example, 'Water' doesn't go up; water 'Temperature' goes up.");
        MultipleAction l15ma7=new MultipleAction(this,new Action[]{l15tfa7,cpaInterestedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15mpp1}),l15ma7));
        
        PresentNodePercept l15pnp1=new PresentNodePercept(this,"Food");
        TextFeedbackAction l15tfa8=new TextFeedbackAction(this,"It looks like right now you have a 'Food' component. Food is an abstract concept, though. What kind of food are you talking about? What are these fish eating? Do they eat algae, plants, other fish, or what?");
        l15tfa8.setNextAction(new TextFeedbackAction(this,"Understanding what the fish eat will be important in figuring out if the food source had something to do with the fish die-off."));
        MultipleAction l15ma8=new MultipleAction(this,new Action[]{l15tfa8,cpaInterestedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15pnp1}),l15ma8));
        
        BidirectionalEdgePercept l15bap1=new BidirectionalEdgePercept(this);
        TextFeedbackAction l15tfa9=new TextFeedbackAction(this,"Right now you have a connection with arrows on both sides. Does this make sense? You're trying to explain what caused the fish die-off, but when a connection has arrows on both sides, it isn't clear what is causing what.");
        MultipleAction l15ma9=new MultipleAction(this,new Action[]{l15tfa9,cpaInterestedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15bap1}),l15ma9));
        
        IsolatedNodePercept l15inp=new IsolatedNodePercept(this);
        TextFeedbackAction l15tfa10=new TextFeedbackAction(this,"There's a component in your model that isn't connected to anything. In a good model, every component should be connected to something. What could this component be connected to? If it shouldn't be connected to anything, it probably isn't relevant to the model.");
        MultipleAction l15ma10=new MultipleAction(this,new Action[]{l15tfa10,cpaInterestedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15inp}),l15ma10));
        
        NodeCountPercept l15ncp4=new NodeCountPercept(this,5,'<');
        TextFeedbackAction l15tfa11=new TextFeedbackAction(this,"Good! Your model is getting very strong. For this kind of phenomenon, a good model would probably have at least 5 components, so try to figure out what else might be important.");
        l15tfa11.setNextAction(new TextFeedbackAction(this,"Remember, you're looking for information relevant to this model. How could your hypothesis be causing this phenomenon, or what could be causing your hypothesis to happen in the first place?"));
        MultipleAction l15ma11=new MultipleAction(this,new Action[]{l15tfa11,cpaHappyFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15ncp4}),l15ma11));
        
        EvidencedConnectionCountPercept l15eccp1=new EvidencedConnectionCountPercept(this,3,'<');
        TextFeedbackAction l15tfa12=new TextFeedbackAction(this,"Your model is starting to look very strong and complete, but right now you have a lot of connections without evidence. Try to figure out how to defend some more of your connections.");
        MultipleAction l15ma12=new MultipleAction(this,new Action[]{l15tfa12,cpaHappyFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15ccp1}),l15ma12));
        
        NodeCountPercept l15ncp5=new NodeCountPercept(this,7,'<');
        TextFeedbackAction l15tfa13=new TextFeedbackAction(this,"Nicely done! It looks like you're almost there! Your explanation could still probably be made a bit more complex with a couple more components and connections, though. Try to think of how some of your current connections are happening.");
        MultipleAction l15ma13=new MultipleAction(this,new Action[]{l15tfa13,cpaExcitedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15ncp5}),l15ma13));
        
        UnevidencedEdgePercept l15uep1=new UnevidencedEdgePercept(this);
        TextFeedbackAction l15tfa14=new TextFeedbackAction(this,"You're close! It looks like your model is strong and thorough, the last thing you really need is to make sure you're justifying all your connections with evidence.");
        MultipleAction l15ma14=new MultipleAction(this,new Action[]{l15tfa14,cpaExcitedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15uep1}),l15ma14));
        
        TruePercept l15tp1=new TruePercept(this);
        TextFeedbackAction l15tfa15=new TextFeedbackAction(this,"Well done! Your model is complete and has evidence justifying all of its connections. There's nothing more I can suggest! Nicely done!");
        MultipleAction l15ma15=new MultipleAction(this,new Action[]{l15tfa15,cpaExcitedFront});
        addMapping(new Mapping(new MultiplePercept(this,new Percept[]{l15tp1}),l15ma15));
        
        /* END LESSON-SPECIFIC CONTENT ****************************************/
        
        TruePercept tp1=new TruePercept(this);
        MultipleAction ma0=new MultipleAction(this,new Action[]{cpaExcitedFront,new TextFeedbackAction(this,"Your model looks good! I can only see the model you're looking at, though, so remember to ask me for advice on your other models, too.")});
        Mapping m0=new Mapping(tp1,ma0);
        addMapping(m0);
    }
}