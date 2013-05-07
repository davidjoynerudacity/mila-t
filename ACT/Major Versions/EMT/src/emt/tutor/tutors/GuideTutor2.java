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
        
        MultipleAction nullMA=new MultipleAction(this);
        nullMA.addAction(cpaNeutralSide);
        myNullAction=nullMA;
        
//        //Check if phenomenon has been written
//        PhenomenonUnwrittenPercept pwp=new PhenomenonUnwrittenPercept(this);
//        QuestionItem QIphenomenon=new QuestionItem("How do I describe my phenonemon?");
//        TextFeedbackAction tfaPhenomenon1=new TextFeedbackAction(this,"A phenomenon description gives a nice, clear, concise description of exactly what it is you are trying to explain.");
//        TextFeedbackAction tfaPhenomenon2=new TextFeedbackAction(this,"Ask yourself what you are trying to explain, then try to write down how you would describe that to another person.");
//        TextFeedbackAction tfaPhenomenon3=new TextFeedbackAction(this,"Your phenomenon will be the final piece of every scientific model you make, so you can try to think of where your models will lead.");
//        tfaPhenomenon1.setNextAction(tfaPhenomenon2);
//        tfaPhenomenon2.setNextAction(tfaPhenomenon3);
//        QIphenomenon.setAction(tfaPhenomenon1);
//        HoldQuestionsAction hqaPhenomenon=new HoldQuestionsAction(this);
//        hqaPhenomenon.addQuestion(QIphenomenon);
//        addMapping(new Mapping(pwp,hqaPhenomenon));
//        
//        //Check if there are a lot of models and if the current model is very good
//        NodeCountPercept ncp5=new NodeCountPercept(this,5,'>');
//        EvidencedConnectionCountPercept eccp3=new EvidencedConnectionCountPercept(this,3,'>');
//        ModelCountPercept mcp3=new ModelCountPercept(this,1,'>','c');
//        QuestionItem QIdismiss1=new QuestionItem("Should I dismiss some of my other hypotheses?");
//        TextFeedbackAction tfaDismiss1=new TextFeedbackAction(this,"It's important to know when to dismiss a hypothesis when you're investigating a system.");
//        TextFeedbackAction tfaDismiss2=new TextFeedbackAction(this,"Sometimes you dismiss a hypothesis because you have evidence that it's false. Other times, you dismiss it because you can't find any evidence about it either way.");
//        TextFeedbackAction tfaDismiss3=new TextFeedbackAction(this,"Your current model looks like it's coming along nicely, but you're still considering a couple other hypotheses as well. It might be time to consider dismissing some of your other ideas to focus on the more promising ones.");
//        tfaDismiss1.setNextAction(tfaDismiss2);
//        tfaDismiss2.setNextAction(tfaDismiss3);
//        QIdismiss1.setAction(tfaDismiss1);
//        MultiplePercept mpDismiss1=new MultiplePercept(this);
//        mpDismiss1.addPercept(ncp5);
//        mpDismiss1.addPercept(eccp3);
//        mpDismiss1.addPercept(mcp3);
//        HoldQuestionsAction hqaDismiss1=new HoldQuestionsAction(this);
//        hqaDismiss1.addQuestion(QIdismiss1);
//        addMapping(new Mapping(mpDismiss1,hqaDismiss1));
//        
//        //Check if there are a lot of models and if the current model is not so good
//        NodeCountPercept ncp3=new NodeCountPercept(this,4,'<');
//        QuestionItem QIdismiss2=new QuestionItem("Should I dismiss this hypothesis?");
//        TextFeedbackAction tfaDismiss4=new TextFeedbackAction(this,"It's good that you're thinking about dismissing some of your original hypotheses -- that is how we narrow down our ideas for what causes a phenomenon.");
//        TextFeedbackAction tfaDismiss5=new TextFeedbackAction(this,"It looks like this model is a little sparse, and you have a couple others that you're working on. It might be time to focus on one of those and dismiss this one if they have more potential.");
//        tfaDismiss4.setNextAction(tfaDismiss5);
//        QIdismiss2.setAction(tfaDismiss4);
//        MultiplePercept mpDismiss2=new MultiplePercept(this);
//        mpDismiss2.addPercept(mcp3);
//        mpDismiss2.addPercept(ncp3);
//        HoldQuestionsAction hqaDismiss2=new HoldQuestionsAction(this);
//        hqaDismiss2.addQuestion(QIdismiss2);
//        addMapping(new Mapping(mpDismiss2,hqaDismiss2));
        
        
        
        
        
        
        
        
    }
    
    @Override
    public void checkMappings() {
        try {
            ArrayList<QuestionItem> qta=new ArrayList<QuestionItem>();
            
            if(StaticVars.currentInquiryModel.getIntermediateLevel()>6&&StaticVars.currentInquiryModel.getBasicLevel()>3) {
                QuestionItem hypothesisDismissal=new QuestionItem("When should hypotheses be dismissed?");
                TextFeedbackAction tfaHypothesisDismissal1=new TextFeedbackAction(this,"Dismissing old hypotheses is a crucial part of science. This is how scientists get rid of the wrong ideas to focus on the right ideas.");
                TextFeedbackAction tfaHypothesisDismissal2=new TextFeedbackAction(this,"Correctly dismissing a hypothesis is a great achievement: you have contributed to the community's knowledge by showing a hypothesis that is not true. That way, others can focus on other hypotheses.");
                TextFeedbackAction tfaHypothesisDismissal3=new TextFeedbackAction(this,"You can dismiss hypotheses for several reasons. Maybe you found evidence that directly contradicts the hypothesis. For example, if you hypothesized that a drought caused a forest to die, you might dismiss that hypothesis when you discover that there was no drought.");
                TextFeedbackAction tfaHypothesisDismissal4=new TextFeedbackAction(this,"You might also dismiss hypotheses because you just can't find any evidence at all. If you find more evidence for one hypothesis than another, that can be enough reason to dismiss the weaker hypothesis.");
                TextFeedbackAction tfaHypothesisDismissal5=new TextFeedbackAction(this,"The important thing is to be willing to dismiss hypotheses when you can't support them. That way, you can focus on the ones that have more evidence supporting them!");
                tfaHypothesisDismissal1.setNextAction(tfaHypothesisDismissal2);
                tfaHypothesisDismissal2.setNextAction(tfaHypothesisDismissal3);
                tfaHypothesisDismissal3.setNextAction(tfaHypothesisDismissal4);
                tfaHypothesisDismissal4.setNextAction(tfaHypothesisDismissal5);
                tfaHypothesisDismissal1.setFace(this.cpaHappyFront);
                hypothesisDismissal.setAction(tfaHypothesisDismissal1);
                qta.add(hypothesisDismissal);
                
                QuestionItem evidenceDepth=new QuestionItem("How can different types of evidence be used to create deep, strong arguments?");
                TextFeedbackAction tfaEvidenceDepth1=new TextFeedbackAction(this,"In science, we never accept anything based only on one piece of evidence. We re-test, we look for alternate explanations, and we experiment to get the best possible explanation.");
                TextFeedbackAction tfaEvidenceDepth2=new TextFeedbackAction(this,"There are lots of kinds of evidence, but none of them are enough on their own. You might make an observation, but how do you know your observation is important? You might mention an established theory, but how do you know the theory is really occurring in this system?");
                TextFeedbackAction tfaEvidenceDepth3=new TextFeedbackAction(this,"By combining different kinds of evidence, we can form deep, strong arguments.");
                TextFeedbackAction tfaEvidenceDepth4=new TextFeedbackAction(this,"For example, imagine you are trying to explain how a forest died. You might first mention the Expert Information that droughts cause forests to die. You might then mention the Direct Observation that there was a drought taking place. Finally, you might describe a Logical Explanation for how droughts kill forests.");
                TextFeedbackAction tfaEvidenceDepth5=new TextFeedbackAction(this,"By combining these different types of evidence, you create a very strong argument.");
                tfaEvidenceDepth1.setNextAction(tfaEvidenceDepth2);
                tfaEvidenceDepth2.setNextAction(tfaEvidenceDepth3);
                tfaEvidenceDepth3.setNextAction(tfaEvidenceDepth4);
                tfaEvidenceDepth4.setNextAction(tfaEvidenceDepth5);
                tfaEvidenceDepth1.setFace(this.cpaInterestedFront);
                evidenceDepth.setAction(tfaEvidenceDepth1);
                qta.add(evidenceDepth);
            }
            
            //Check if there's a bacteria node and offer information if so
            PresentNodePercept pnpBacteria=new PresentNodePercept(this,"Bacteria");
            if(pnpBacteria.isTrue()) {
                QuestionItem QIBacteria=new QuestionItem("What roles could bacteria play in an ecological system?");
                TextFeedbackAction tfaBacteria1=new TextFeedbackAction(this,"Bacteria interacts with lots of different systems in lots of different ways.");
                TextFeedbackAction tfaBacteria2=new TextFeedbackAction(this,"Some bacteria are known to eat chemicals that are harmful to fish. Nitrosomonas, for example, eat the ammonia in waste, cleaning up the water.");
                TextFeedbackAction tfaBacteria3=new TextFeedbackAction(this,"Other bacteria, though, can be harmful or poisonous. Some cause diseases, while others produce chemicals that are deadly in large quantities.");
                TextFeedbackAction tfaBacteria4=new TextFeedbackAction(this,"Try looking at the bacteria that are in the system you're exploring to try to figure out what role they could have played in your phenomenon.");
                tfaBacteria1.setNextAction(tfaBacteria2);
                tfaBacteria2.setNextAction(tfaBacteria3);
                tfaBacteria3.setNextAction(tfaBacteria4);
                QIBacteria.setAction(tfaBacteria1);
                tfaBacteria1.setFace(cpaInterestedFront);
                qta.add(QIBacteria);
            }
            
            //Check if there's an algae node and offer information if so
            PresentNodePercept pnp1=new PresentNodePercept(this,"Algae");
            if(pnp1.isTrue()) {
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
                tfa1.setFace(cpaInterestedFront);
                q5.setAction(tfa1);
                qta.add(q5);
            }
            PresentNodePercept pnp2=new PresentNodePercept(this,"Fish");
            if(pnp2.isTrue()) {
                QuestionItem q5=new QuestionItem("What could cause a lot of fish to die suddenly?");
                TextFeedbackAction tfa1=new TextFeedbackAction(this,"The sudden death of lots of fish -- called a \"fish kill\" -- is actually a pretty common natural phenomenon with lots of possible causes.");
                TextFeedbackAction tfa2=new TextFeedbackAction(this,"Sometimes, these events happen because a disease moves quickly through the entire system. Other times, the system becomes so overcrowded with fish that many start to suffocate or starve.");
                TextFeedbackAction tfa3=new TextFeedbackAction(this,"Sometimes, sudden significant pollution can cause lots of fish to die at once, especially if the pollutant limits the fish's ability to reproduce or breathe.");
                TextFeedbackAction tfa4=new TextFeedbackAction(this,"There are also events that suck the oxygen out of the water all at once, causing lots of fish and other organisms to suffocate.");
                TextFeedbackAction tfa5=new TextFeedbackAction(this,"Any or all of these things could contribute to a fish kill. It's always possible that more than one cause interacted to cause a the fish kill in a particular system.");
                tfa1.setFace(cpaInterestedFront);
                tfa1.setNextAction(tfa2);
                tfa2.setNextAction(tfa3);
                tfa3.setNextAction(tfa4);
                tfa4.setNextAction(tfa5);
                q5.setAction(tfa1);
                qta.add(q5);
            }
            
            PhenomenonUnwrittenPercept pwp=new PhenomenonUnwrittenPercept(this);
            if(pwp.isTrue()) {
                QuestionItem QIphenomenon=new QuestionItem("How do I describe my phenonemon?");
                TextFeedbackAction tfaPhenomenon1=new TextFeedbackAction(this,"A phenomenon description gives a nice, clear, concise description of exactly what it is you are trying to explain.");
                TextFeedbackAction tfaPhenomenon2=new TextFeedbackAction(this,"Ask yourself what you are trying to explain, then try to write down how you would describe that to another person.");
                TextFeedbackAction tfaPhenomenon3=new TextFeedbackAction(this,"Your phenomenon will be the final piece of every scientific model you make, so you can try to think of where your models will lead.");
                tfaPhenomenon1.setNextAction(tfaPhenomenon2);
                tfaPhenomenon1.setFace(cpaHappyFront);
                tfaPhenomenon2.setNextAction(tfaPhenomenon3);
                QIphenomenon.setAction(tfaPhenomenon1);
                qta.add(QIphenomenon);
            }
            if(StaticVars.currentModelingModel.getIntermediateLevel()>6&&StaticVars.currentModelingModel.getBasicLevel()>12) {
                QuestionItem modelFlow=new QuestionItem("What does it mean for a model to have causal flow?");
                TextFeedbackAction tfaFlow1=new TextFeedbackAction(this,"When we model a phenomenon, we are trying to explain how that phenomenon happened. That means that the end result of the model should be the phenomenon itself.");
                TextFeedbackAction tfaFlow2=new TextFeedbackAction(this,"For example, if we are modeling how iron levels got really low in a pond, our final result should be the iron levels dropping. Iron levels dropping doesn't cause something else because it is what we're trying to explain.");
                TextFeedbackAction tfaFlow3=new TextFeedbackAction(this,"Cycles do happen in systems, where two trends \'feedback\' on each other and make each other happen more. However, when we are explaining a certain phenomenon, we want to look at how those cycles cause the phenomenon to happen.");
                TextFeedbackAction tfaFlow4=new TextFeedbackAction(this,"This is what causal flow means. The model flows toward causing the phenomenon it is trying to explain.");
                tfaFlow1.setNextAction(tfaFlow2);
                tfaFlow2.setNextAction(tfaFlow3);
                tfaFlow3.setNextAction(tfaFlow4);
                tfaFlow1.setFace(this.cpaInterestedFront);
                qta.add(modelFlow);
                
                QuestionItem modelParallelCauses=new QuestionItem("What does it mean for something to have parallel effects?");
                TextFeedbackAction tfaParallel1=new TextFeedbackAction(this,"Just like something can be caused by more than one thing, something can cause more than one other thing to happen, too.");
                TextFeedbackAction tfaParallel2=new TextFeedbackAction(this,"For example, if algae population in a system went down, it would cause the concentration of carbon dioxide to go up, and would cause the population of fish that eat the algae to go down.");
                TextFeedbackAction tfaParallel3=new TextFeedbackAction(this,"Parallel effects help us explain how certain changes have such significant effects. We might not think that something as simple as algae dying would affect the system that much, but it affects so many different things that the result is enormous!");
                TextFeedbackAction tfaParallel4=new TextFeedbackAction(this,"Try to think about whether anything in your model has more than one effect.");
                tfaParallel2.setNextAction(tfaParallel1);
                tfaParallel3.setNextAction(tfaParallel2);
                tfaParallel4.setNextAction(tfaParallel3);
                tfaParallel1.setFace(this.cpaAmazedFront);
                qta.add(modelParallelCauses);
            }
            if(StaticVars.currentModelingModel.getBasicLevel()>10) {
                QuestionItem modelSize=new QuestionItem("How big should a good model be?");
                TextFeedbackAction tfaSize1=new TextFeedbackAction(this,"There's no firm rule on how big a good model needs to be. Some phenomena need more complicated explanations than others.");
                TextFeedbackAction tfaSize2=new TextFeedbackAction(this,"The important thing is that your model is convincing and informative. Try reading your model and imagining what someone else might ask you. That should tell you where to go look for more information. ");
                tfaSize1.setNextAction(tfaSize2);
                tfaSize1.setFace(cpaHappyFront);
                qta.add(modelSize);
                
                QuestionItem modelParallelCauses=new QuestionItem("What does it mean for something to have parallel causes?");
                TextFeedbackAction tfaParallel1=new TextFeedbackAction(this,"In ecological systems, not everything is only caused by one thing. For example, both sunlight and nutrients cause plants to flourish.");
                TextFeedbackAction tfaParallel2=new TextFeedbackAction(this,"Parallel causes are when two different things cause something to happen. In your model, this means that two different trends have connections pointing to the same other trend.");
                TextFeedbackAction tfaParallel3=new TextFeedbackAction(this,"Most ecological systems have lots of different connections with lots of parallel causes. Try to draw these kinds of chains in your model, too.");
                tfaParallel2.setNextAction(tfaParallel1);
                tfaParallel3.setNextAction(tfaParallel2);
                tfaParallel1.setFace(this.cpaInterestedFront);
                qta.add(modelParallelCauses);
            }
            if(StaticVars.currentInquiryModel.getBasicLevel()>2) {
                QuestionItem evidenceQs=new QuestionItem("What are the different forms of evidence?");
                TextFeedbackAction tfa1=new TextFeedbackAction(this,"There are lots of types of evidence, including many that are not mentioned here in MILA. What type of evidence do you want to read about?");
                evidenceQs.setAction(tfa1);
                tfa1.setFace(cpaInterestedFront);
                QuestionItem e1=new QuestionItem("What is a Direct Observation?");
                TextFeedbackAction e1tfa1=new TextFeedbackAction(this,"A direct observation is something you actually saw in the system. Chances are, the phenomenon you're trying to explain is something you observed: after all, that's why you're explaining it!");
                TextFeedbackAction e1tfa2=new TextFeedbackAction(this,"Direct observations are not the best source of evidence because they cannot be repeated or tested. However, they are useful in getting a starting point when you're exploring the system.");
                TextFeedbackAction e1tfa3=new TextFeedbackAction(this,"Try to pair direct observations with things like established scientific theories. If you can show that a theory explains a certain connection and that the parts of that theory are present in this system, then you've made a great case!");
                e1tfa1.setNextAction(e1tfa2);
                e1tfa2.setNextAction(e1tfa3);
                e1.setAction(e1tfa1);
                QuestionItem e2=new QuestionItem("What is a Simulation Observation?");
                TextFeedbackAction e2tfa1=new TextFeedbackAction(this,"Simulations let us test and see how a system reacts under different circumstances. If you can recreate the events that you are trying to explain in a simulation, then you could say that you have explained how the phenomenon happened!");
                TextFeedbackAction e2tfa2=new TextFeedbackAction(this,"Simulations are pretty good sources of evidence because you can repeat experiments with them and test them in different ways. You can also see how the system would react to different circumstances.");
                TextFeedbackAction e2tfa3=new TextFeedbackAction(this,"Simulations have weaknesses, however. The simulation might not be an accurate recreation of the system. Also, just because you made the same thing happen in a simulation that happened in real life, we can't be sure it happened in the same way or for the same reason.");
                e2tfa1.setNextAction(e2tfa2);
                e2tfa2.setNextAction(e2tfa3);
                e2.setAction(e2tfa1);
                QuestionItem e3=new QuestionItem("What is a Similar System Observation?");
                TextFeedbackAction e3tfa1=new TextFeedbackAction(this,"A similar system observation is something you saw happen with a phenomenon similar to the one you are trying to explain.");
                TextFeedbackAction e3tfa2=new TextFeedbackAction(this,"For example, if you were trying to explain what caused a volcano to erupt at a certain time, you might look at what caused other volcanoes to erupt in the past.");
                TextFeedbackAction e3tfa3=new TextFeedbackAction(this,"Similar system observations are good starting points for your model, but you probably want to back them up with better evidence once you research the phenomenon more.");
                e3tfa1.setNextAction(e3tfa2);
                e3tfa2.setNextAction(e3tfa3);
                e3.setAction(e3tfa1);
                
                QuestionItem e4=new QuestionItem("What is a Controlled Experiment?");
                TextFeedbackAction e4tfa1=new TextFeedbackAction(this,"A controlled experiment is when you change something and watch how it changes other things. For example, you might change the temperature of a classroom and observe how it changes scores on a test.");
                TextFeedbackAction e4tfa2=new TextFeedbackAction(this,"Controlled experiments are the most rigorous form of science. They are one of the only things that let us make very firm arguments about what causes stuff to happen.");
                TextFeedbackAction e4tfa3=new TextFeedbackAction(this,"Controlled experiments are difficult to do in ecology, though, because we cannot control ecological systems. How might you do a controlled experiment in an ecological system?");
                e4tfa1.setNextAction(e4tfa2);
                e4tfa2.setNextAction(e4tfa3);
                e4.setAction(e4tfa1);
                QuestionItem e5=new QuestionItem("What is Expert Information?");
                TextFeedbackAction e5tfa1=new TextFeedbackAction(this,"Expert Information is something you know because a trusted authority told you. Your textbook, research papers, and scientists are a few examples of Expert Information.");
                TextFeedbackAction e5tfa2=new TextFeedbackAction(this,"You might be surprised to learn some sources of information that aren't experts. News reporters, bloggers, and even your teacher are not sources of Expert Information.");
                TextFeedbackAction e5tfa3=new TextFeedbackAction(this,"Expert Information makes your model very strong, but it can be hard to come by. Where should you go to look for Expert Information?");
                e5tfa1.setNextAction(e5tfa2);
                e5tfa2.setNextAction(e5tfa3);
                e5.setAction(e5tfa1);
                QuestionItem e6=new QuestionItem("What is Non-Expert Information?");
                TextFeedbackAction e6tfa1=new TextFeedbackAction(this,"Non-Expert Information is information you got from a source that isn't an expert on the system you're investigating.");
                TextFeedbackAction e6tfa2=new TextFeedbackAction(this,"The internet, your classmates, your teachers, and news articles are examples of non-expert information. These kinds of information are not bad, but they should not be your only evidence.");
                TextFeedbackAction e6tfa3=new TextFeedbackAction(this,"Use Non-Expert Information to gather some initial ideas of what might have caused the phenomenon, then use that information to go looking for even better evidence.");
                e6tfa1.setNextAction(e6tfa2);
                e6tfa2.setNextAction(e6tfa3);
                e6.setAction(e6tfa1);
                
                QuestionItem e7=new QuestionItem("What is a Logical Explanation?");
                TextFeedbackAction e7tfa1=new TextFeedbackAction(this,"A Logical Explanation is an explanation of the system that just makes sense in your head. For example, if we are explaining why a bunch of fish died, we might explain it with pollution: pollution is poisonous, so it killed the fish, right?");
                TextFeedbackAction e7tfa2=new TextFeedbackAction(this,"Logical Explanations are good starting points, but they should not be the only source of evidence. There are lots of Logical Explanations for things. We know the right explanation because we have stronger evidence for it.");
                TextFeedbackAction e7tfa3=new TextFeedbackAction(this,"You can come up with a Logical Explanation to get you started, then go looking for other types of evidence to make your explanation even stronger!");
                e7tfa1.setNextAction(e7tfa2);
                e7tfa2.setNextAction(e7tfa3);
                e7.setAction(e7tfa1);
                
                QuestionItem e8=new QuestionItem("What are some other forms of evidence?");
                TextFeedbackAction e8tfa1=new TextFeedbackAction(this,"There are lots of types of evidence besides the ones we've listed here! Some people use personal experiences and their own personal beliefs as evidence for an explanation. You might also use semi-controlled experiments, case studies, and other more advanced ways of explaining a phenomenon.");
                TextFeedbackAction e8tfa2=new TextFeedbackAction(this,"The important thing to remember is that evidence is meant to convince someone else that your explanation is right. So, try to use types of evidence that are the hardest to argue against. Someone might argue that your Logical Explanation is wrong, but it would be harder to argue against an actual Observation.");
                e8tfa1.setNextAction(e8tfa2);
                e8.setAction(e8tfa1);
                
                QuestionItem seeMore1=new QuestionItem("See more kinds of evidence...");
                QuestionItem seeMore2=new QuestionItem("See more kinds of evidence...");
                QuestionItem seeMore3=new QuestionItem("See more kinds of evidence...");
                
                QuestionListAction eQs1=new QuestionListAction(this);
                eQs1.setFace(cpaHappyFront);
                QuestionListAction eQs2=new QuestionListAction(this);
                QuestionListAction eQs3=new QuestionListAction(this);
                
                seeMore1.setAction(eQs2);
                seeMore2.setAction(eQs3);
                seeMore3.setAction(eQs1);
                
                eQs1.addQuestion(e1);
                eQs1.addQuestion(e2);
                eQs1.addQuestion(e3);
                eQs1.addQuestion(seeMore1);
                
                eQs2.addQuestion(e4);
                eQs2.addQuestion(e5);
                eQs2.addQuestion(e6);
                eQs2.addQuestion(seeMore2);
                
                eQs3.addQuestion(e7);
                eQs3.addQuestion(e8);
                eQs3.addQuestion(seeMore3);
                
                tfa1.setNextAction(eQs1);
                qta.add(evidenceQs);
            }
            if(StaticVars.currentModelingModel.getBasicLevel()<15) {
                QuestionItem q1=new QuestionItem("How do I create MILA models?");
                QuestionListAction milaQs=new QuestionListAction(this);
                milaQs.setFace(cpaHappyFront);
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
                notesQs.setFace(cpaHappyFront);
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
                tutorsQs.setFace(cpaHappyFront);
                q3.setAction(tutorsQs);
                QuestionItem tutorQ1=new QuestionItem("How should I use Gabriel the Guide?", new TextFeedbackAction(this,"I'm here to try to answer any of your questions. Whenever you need help or want to ask something about MILA or the lesson for the day, just click me and I'll do my best to help! I'll never interrupt you, so make sure to click me if you need me."));
                QuestionItem tutorQ2=new QuestionItem("How should I use Craig the Critic?", new TextFeedbackAction(this,"Craig is here to look at your models and see if they show what you're trying to learn for the day. When you think your model is in good shape or you don't know what else to do with it, click him to see if he has any suggestions."));
                QuestionItem tutorQ3=new QuestionItem("How should I use Mercer the Mentor?", new TextFeedbackAction(this,"Mercer is always keeping track of what you're doing, and when he has something to say, he'll appear with his little lightbulb. When you see that, click him to get his feedback or suggestions."));
                QuestionItem tutorQ4=new QuestionItem("How should I use Isla the Interviewer?", new TextFeedbackAction(this,"Isla's goal is to ask you questions to understand a little more what you're thinking or what you've learned. When you see her appear with her lightbulb, click her to give her your thoughts on whatever she's asking. Sometimes she’ll ask you what you learned on trips to the aquarium or the lake, while other times she’ll ask you about your ideas in your models."));
                tutorsQs.addQuestion(tutorQ1);
                tutorsQs.addQuestion(tutorQ2);
                tutorsQs.addQuestion(tutorQ3);
                tutorsQs.addQuestion(tutorQ4);
                qta.add(q1);
                qta.add(q2);
                qta.add(q3);
            }
            QuestionItem milaQ4=new QuestionItem("What makes a good model?",new TextFeedbackAction(this,"We'll talk a lot about what makes a good model over the next several days. Generally, though, a good model is one that provides a good, thorough explanation of a phenomenon using the evidence you have gathered to support it."));
            milaQ4.getAction().setFace(cpaExcitedFront);
            QuestionItem q4=new QuestionItem("What makes a good scientific model?",milaQ4.getAction());
            qta.add(q4);
            
            QuestionListAction top=new QuestionListAction(this);
            top.setFace(cpaNeutralFront);
            QuestionListAction current=top;
            int qIndex=0;
            while(qta.size()>0) {
                current.addQuestion(qta.get(0));
                qta.remove(0);
                qIndex++;
                
                if(qIndex==3) {
                    qIndex=0;
                    QuestionListAction next=new QuestionListAction(this);
                    next.setFace(cpaNeutralFront);
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
