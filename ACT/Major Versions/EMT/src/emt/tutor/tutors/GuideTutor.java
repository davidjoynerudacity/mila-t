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
        addImage("1", "g1.jpg");
        addImage("2", "g2.jpg");
        addImage("3", "g3.jpg");
        
        PresentNodePercept pn1=new PresentNodePercept(this);
        pn1.setNode("Nitrate");
        PresentNodePercept pn2=new PresentNodePercept(this);
        pn2.setNode("Fish");
        
        MultiplePercept mp1=new MultiplePercept(this);  //triggers if both Fish and Nitrate nodes are present
        mp1.addPercept(pn1);
        mp1.addPercept(pn2);
        
        
        QuestionListAction list1=new QuestionListAction(this);  //Questions for if Fish and Nitrate are both present
        QuestionListAction list2=new QuestionListAction(this);  //Questions for if only Fish is present
        QuestionListAction list3=new QuestionListAction(this);  //Questions for if Fish is not present
        QuestionItem l1q1=new QuestionItem();
        l1q1.setQuestion("How do nitrate and fish interact?");
        l1q1.setAction(new TextFeedbackAction(this,"Nitrate has been observed in the wild to be poisonous to fish when found in large quantities. However, it is significantly less poisonous to fish than ammonium, which is present in fish waste. Nitrate is not present in large quantities in fish waste."));
        
        QuestionItem l1q2=new QuestionItem();
        l1q2.setQuestion("Could nitrate have killed off the fish?");
        l1q2.setAction(new TextFeedbackAction(this,"Nitrate could conceivably kill off a fish population if it was present in extremely high quantities. Was there a high quantity of nitrate before the fish died off?"));
        
        QuestionItem l1q3=new QuestionItem();
        l1q3.setQuestion("What causes nitrate levels to spike?");
        l1q3.setAction(new TextFeedbackAction(this,"Generally, the most common producer of nitrate in lakes is bacteria. Bacteria feed on the ammonia in fish waste and use it to reproduce, and put out nitrate themselves. In this way, these bacteria make the lake less poisonous for the fish to live in."));
        
        QuestionItem l1q4=new QuestionItem();
        l1q4.setQuestion("Let me see more questions I can ask.");
        l1q4.setAction(list2);
        
        list1.addQuestion(l1q1);
        list1.addQuestion(l1q2);
        list1.addQuestion(l1q3);
        list1.addQuestion(l1q4);
        
        
        QuestionItem l2q1=new QuestionItem();
        l2q1.setQuestion("What are some things that might have affected the fish in the pond?");
        l2q1.setAction(new TextFeedbackAction(this,"Remember, the fish in the pond did not seem to show any external signs of stress or trauma. That means what killed them was probably something chemical or biological. They could have starved, suffocated, or been poisoned."));
        
        QuestionItem l2q2=new QuestionItem();
        l2q2.setQuestion("What are some tests that could be run to determine what might have killed the fish?");
        l2q2.setAction(new TextFeedbackAction(this,"Generally, since the fish didn't show any outward signs of trauma, you'll be interested in the levels of certain chemicals in the lake, as well as the levels of different bacteria and other living organisms, like algae."));
        
        QuestionItem l2q3=new QuestionItem();
        l2q3.setQuestion("Are there any known examples of things like this happening in other lakes?");
        l2q3.setAction(new TextFeedbackAction(this,"This is where I would put an answer to this if I had one. But I don't. Oh well!"));
        
        QuestionItem l2q4=new QuestionItem();
        l2q4.setQuestion("Let me see more questions I can ask.");
        //l2q4.setAction(list3);
        
        list2.addQuestion(l2q1);
        list2.addQuestion(l2q2);
        list2.addQuestion(l2q3);
        list2.addQuestion(l2q4);
        
        
        QuestionItem l3q1=new QuestionItem();
        l3q1.setQuestion("What are some things I might want to put into my model?");
        l3q1.setAction(new TextFeedbackAction(this,"The most important thing to put in your model is some component representing fish. After all, you're trying to explain how fish populations dropped, so it makes sense that you should have a component in your model representing fish population."));
        
        QuestionItem l3q2=new QuestionItem();
        l3q2.setQuestion("How do I add a component to my model?");
        l3q2.setAction(new TextFeedbackAction(this,"To add a component to your model, first click the Add Component button at the top to select that tool. Then, click anywhere on the canvas to the right to create your node. Enter the component name and component property, then choosing a color and click OK."));
        
        QuestionItem l3q3=new QuestionItem();
        l3q3.setQuestion("What's the difference between components and properties?");
        l3q3.setAction(new TextFeedbackAction(this,"A component is something physical in the system. Fish, water, algae, bacteria, and ammonia are all possible components. A property is a characteristic of that component. For example, Temperature would be a property of Water: water is the physical component, and Temperature is something about the water."));
        
        QuestionItem l3q4=new QuestionItem();
        l3q4.setQuestion("What do the colored arrows represent?");
        l3q4.setAction(new TextFeedbackAction(this,"The colored arrows in the top right corner of the components indicate in what direction that property of that component is changing. For example, if water temperature is rising, then there will be a component Water with a property Temperature, and the arrow will be pointing up. If fish populations are falling, there will be a Fish component with a Population property and a downward red arrow."));
        
        list3.addQuestion(l3q1);
        list3.addQuestion(l3q2);
        list3.addQuestion(l3q3);
        list3.addQuestion(l3q4);
        
        
        ChangePictureAction cpa1=new ChangePictureAction(this); //for if any of the nodes are present
        cpa1.setPicKey("2");
        ChangePictureAction cpa2=new ChangePictureAction(this); //for if none of the nodes are present
        cpa2.setPicKey("3");
        
        MultipleAction ma1=new MultipleAction(this);    //triggers if both Fish and Nitrate nodes are present
        MultipleAction ma2=new MultipleAction(this);    //triggers if Fish is present, but not Nitrate
        MultipleAction ma3=new MultipleAction(this);    //triggers if neither Fish nor Nitrate are present

        ma1.addAction(list1);
        ma1.addAction(cpa1);
        
        ma2.addAction(list2);
        ma2.addAction(cpa1);
        
        ma3.addAction(list3);
        ma3.addAction(cpa2);
        l2q4.setAction(ma3);
        
        
        Mapping m1=new Mapping();   //Fish and Nitrate both present
        m1.setPercept(mp1);
        m1.setAction(ma1);
        
        Mapping m2=new Mapping();   //Fish is present, but not Nitrate
        m2.setPercept(pn2);
        m2.setAction(ma2);
        
        Mapping m3=new Mapping();
        m3.setPercept(new TruePercept(this));
        m3.setAction(ma3);
        
        this.addMapping(m1);
        this.addMapping(m2);
        this.addMapping(m3);
        
    }
}
