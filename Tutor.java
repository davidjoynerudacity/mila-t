/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import emt.ProjectModelPanel;
import emt.evexmodel.EvexModel;
import emt.tutor.actions.*;
import emt.tutor.percepts.*;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class Tutor {
    private String myName;
    private TutorPanel myPanel;
    private TutorPopupFrame myFrame;
    private HashMap myImages;
    private ArrayList<Mapping> myMappings;
    private ProjectModelPanel myModelPanel;
    
    public Tutor() {
        myName="";
        myPanel=null;
        myImages=new HashMap();
        myMappings=new ArrayList<Mapping>();
        myFrame=new TutorPopupFrame();
        myFrame.pack();
        myFrame.setVisible(false);
        
        //initializeSampleTutor();
    }
    public Tutor(String name) {
        this();
        myName=name;
        myModelPanel=null;
        myFrame.setTitle(myName);
    }
    public Tutor(String name,ProjectModelPanel modelPanel) {
        this();
        myName=name;
        myModelPanel=modelPanel;
        myFrame.setTitle(myName);
    }
    public void checkMappings() {
        for(Mapping mapping : myMappings) {
            Action result=mapping.check();
            if(result!=null) {
                result.doAction();
                return;
            }
        }
    }
    public void addMapping(Mapping newMapping) {
        myMappings.add(newMapping);
    }
    public void wasClicked() {
        showTutor();
    }
    
    public void addImage(String label,String filename) {
        try {
            Image newImage=ImageIO.read(new File("lib"+File.separator+"Images"+File.separator+"Tutor/"+File.separator+filename));
            ImageIcon newImageIcon=new ImageIcon(newImage);
            myImages.put(label,newImageIcon);
        } catch(Exception ex) {
            System.out.println(ex);
            System.out.println(ex.getStackTrace());
        }
    }
    
    public void switchImage(String label) {
        if(myImages.containsKey(label)) {
            myPanel.switchImage((ImageIcon)myImages.get(label));
            myFrame.switchImage((ImageIcon)myImages.get(label));
        }
    }
    
    public void giveTextFeedback(String feedback) {
        myFrame.giveTextFeedback(feedback);
    }
    public void giveTextFeedback(TextFeedbackAction tfa) {
        myFrame.giveTextFeedback(tfa);
    }
    public void giveQuestionList(ArrayList<QuestionItem> questions,String intro) {
        myFrame.giveQuestionList(questions,intro);
    }
    public void giveFeedbackPrompt(FeedbackPromptAction prompt) {
        myFrame.giveFeedbackPrompt(prompt);
    }
    
    public String getName() {
        return myName;
    }
    public void setName(String name) {
        myName=name;
    }
    public TutorPanel getPanel() {
        return myPanel;
    }
    public void setPanel(TutorPanel panel) {
        myPanel=panel;
        switchImage("1");
    }
    public String toString() {
        return myName;
    }
    public void showTutor() {
        myFrame.setVisible(!myFrame.isVisible());
    }
    public void focusTutor() {
        myModelPanel.switchTutor(myName);
    }
    
    public EvexModel getModel() {
        return myModelPanel.getModel();
    }
    
    public void initializeSampleTutor() {
//        TruePercept t1=new TruePercept(this);
//        MultipleAction ma1=new MultipleAction(this);
        
        //TextFeedbackAction tfa1=new TextFeedbackAction(this);
        //tfa1.setFeedback("This is the feedback the tutor would give to the student if this TextFeedbackAction was triggered. The text would be put in the box you see here. This text could be generated from a tutor check or from the student clicking a question on a question list."); 
        //ma1.addAction(tfa1);
        
//        QuestionListAction qla1=new QuestionListAction(this);
//        qla1.addQuestion("Do you have any content advice for us?");
//        qla1.addQuestion("How do I use a simulation?");
//        qla1.addQuestion("What's the difference between biotic and abiotic substances?");
//        qla1.addQuestion("When is it appropriate to ask for help?");
//        ma1.addAction(qla1);
        
//        FeedbackPromptAction fpa1=new FeedbackPromptAction(this);
//        fpa1.setPrompt("What did you learn during the camp today?");
//        ma1.addAction(fpa1);
//        
//        ChangePictureAction cpa1=new ChangePictureAction(this);
//        cpa1.setPicKey("2");
//        ma1.addAction(cpa1);
//        
//        Mapping m1=new Mapping();
//        m1.setPercept(t1);
//        m1.setAction(ma1);
//        addMapping(m1);
//        SamplePercept sp1=new SamplePercept(this);
//        sp1.setTarget(0);
//        SamplePercept sp2=new SamplePercept(this);
//        sp2.setTarget(1);
//        SamplePercept sp3=new SamplePercept(this);
//        sp3.setTarget(2);
//        
//        ChangePictureAction cpa1=new ChangePictureAction(this);
//        cpa1.setPicKey("1");
//        ChangePictureAction cpa2=new ChangePictureAction(this);
//        cpa2.setPicKey("2");
//        ChangePictureAction cpa3=new ChangePictureAction(this);
//        cpa3.setPicKey("3");
//        
//        Mapping m1=new Mapping();
//        m1.setPercept(sp1);
//        m1.setAction(cpa1);
//        Mapping m2=new Mapping();
//        m2.setPercept(sp2);
//        m2.setAction(cpa2);
//        Mapping m3=new Mapping();
//        m3.setPercept(sp3);
//        m3.setAction(cpa3);
//        
//        addMapping(m1);
//        addMapping(m2);
//        addMapping(m3);
    }
}
