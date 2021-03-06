/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import emt.ProjectModelPanel;
import emt.evexmodel.EvexModel;
import emt.tutor.actions.*;
import emt.tutor.actions.quiz.*;
import emt.tutor.percepts.*;
import java.awt.Image;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class Tutor {
    protected String myName;
    private TutorPanel myPanel;
    private TutorPopupFrame myFrame;
    protected HashMap myImages;
    protected ArrayList<Mapping> myMappings;
    private ProjectModelPanel myModelPanel;
    protected Action myNullAction;
    protected Date lastFeedbackTime;
    
    public Tutor() {
        myName="";
        myPanel=null;
        myImages=new HashMap();
        myMappings=new ArrayList<Mapping>();
        myFrame=new TutorPopupFrame(this);
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
        if(myModelPanel.projectOpened()) {
            try {
                for(Mapping mapping : myMappings) {
                    Action result=mapping.check();
                    if(result!=null) {
                        result.doAction();
                        return;
                    }
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void addMapping(Mapping newMapping) {
        myMappings.add(newMapping);
    }
    public void addMapping(Mapping newMapping,boolean toFront) {
        if(toFront) {
            myMappings.add(0,newMapping);
        }
    }
    public void wasClicked() {
        showTutor();
        StaticVars.Log("Tutor Shown", myName);
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
    
    /*public void giveTextFeedback(String feedback) {
        myFrame.giveTextFeedback(feedback);
    }*/
    public void giveTextFeedback(TextFeedbackAction tfa) {
        myFrame.giveTextFeedback(tfa);
    }
    public void giveQuestionList(ArrayList<QuestionItem> questions,String intro) {
        myFrame.giveQuestionList(questions,intro);
    }public void giveQuizChoice(QuizChoiceAction prompt) {
        myFrame.giveQuizChoice(prompt);
    }
    public void giveQuizText(QuizTextAction prompt) {
        myFrame.giveQuizText(prompt);
    }
    public void giveFeedbackPrompt(FeedbackPromptAction prompt) {
        myFrame.giveFeedbackPrompt(prompt);
    }
    public void giveRepeatQuizAction(RepeatQuizAction rqa) {
        myFrame.giveRepeatQuizAction(rqa);
    }
    
    
    public String getName() {
        return myName;
    }
    public void setName(String name) {
        myName=name;
    }
    public HashMap getImages() {
        return myImages;
    }
    public void setImages(HashMap images) {
        myImages=images;
    }
    public ArrayList<Mapping> getMappings() {
        return myMappings;
    }
    public void setMappings(ArrayList<Mapping> mappings) {
        myMappings=mappings;
    }
    public TutorPanel returnPanel() {
        return myPanel;
    }
    public void initializePanel(TutorPanel panel) {
        myPanel=panel;
        switchImage("neutral-side");
    }
    public String toString() {
        return myName;
    }
    public void showTutor() {
        myFrame.setTFARead();
        myFrame.setVisible(true);
        if(myName.equals("Guide")) {
            StaticVars.currentMiscModel.incrementGuideCount(1);
        } else if(myName.equals("Critic")) {
            StaticVars.currentMiscModel.incrementCriticCount(1);
        }
    }
    public void hideTutor() {
        myFrame.setVisible(false);
    }
    public boolean isVisible() {
        return myFrame.isVisible();
    }
    public void focusTutor() {
        myModelPanel.switchTutor(myName);
    }
    
    public EvexModel getModel() {
        return myModelPanel.getModel();
    }
    public int getModelCount(char modelType) {
        return myModelPanel.getModelCount(modelType);
    }
    public String getPhenomenon() {
        return myModelPanel.getPhenomenon();
    }
    public void saveTutor() {
        new File("SavedTutors").mkdir();
        String tutorPath="SavedTutors" + File.separator;
        new File(tutorPath).mkdir();
        try {
            FileOutputStream save = new FileOutputStream(tutorPath + File.separator + myName +".xml");
            XMLEncoder encoder=new XMLEncoder(save);
            
           
            encoder.writeObject(myMappings);
            encoder.close();
        } catch(Exception ex) {
            System.out.println("Tutor save failed.");
            System.out.println(ex.getMessage());
        }
    }
    public void loadTutor() {
        File f = new File("LoadTutors");
        String names[] = f.list();

        try {
            FileInputStream reader=new FileInputStream("LoadTutors" + File.separator + myName + ".xml");
            XMLDecoder decoder=new XMLDecoder(reader);
            myMappings=(ArrayList<Mapping>)decoder.readObject();
            System.out.println("Tutor loaded!");
        } catch(Exception ex) {
            System.out.println("Tutor Load Failed.");
            System.out.println(ex);
        }
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

    public Action getNullAction() {
        return myNullAction;
    }

    public void setNullAction(Action myNullAction) {
        this.myNullAction = myNullAction;
    }

    public Date getLastFeedbackTime() {
        return lastFeedbackTime;
    }

    public void setLastFeedbackTime(Date lastFeedbackTime) {
        this.lastFeedbackTime = lastFeedbackTime;
    }
    
    
}
