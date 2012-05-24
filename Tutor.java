/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import emt.tutor.actions.ChangePictureAction;
import emt.tutor.percepts.SamplePercept;
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
    
    public Tutor() {
        myName="";
        myPanel=null;
        myImages=new HashMap();
        myMappings=new ArrayList<Mapping>();
        myFrame=new TutorPopupFrame();
        myFrame.pack();
        myFrame.setVisible(false);
        
        initializeSampleTutor();
    }
    public Tutor(String name) {
        this();
        myName=name;
    }
    public Tutor(String name,TutorPanel panel) {
        this(name);
        myPanel=panel;
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
        }
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
    
    public void initializeSampleTutor() {
        SamplePercept sp1=new SamplePercept(this);
        sp1.setTarget(0);
        SamplePercept sp2=new SamplePercept(this);
        sp2.setTarget(1);
        SamplePercept sp3=new SamplePercept(this);
        sp3.setTarget(2);
        
        ChangePictureAction cpa1=new ChangePictureAction(this);
        cpa1.setPicKey("1");
        ChangePictureAction cpa2=new ChangePictureAction(this);
        cpa2.setPicKey("2");
        ChangePictureAction cpa3=new ChangePictureAction(this);
        cpa3.setPicKey("3");
        
        Mapping m1=new Mapping();
        m1.setPercept(sp1);
        m1.setAction(cpa1);
        Mapping m2=new Mapping();
        m2.setPercept(sp2);
        m2.setAction(cpa2);
        Mapping m3=new Mapping();
        m3.setPercept(sp3);
        m3.setAction(cpa3);
        
        addMapping(m1);
        addMapping(m2);
        addMapping(m3);
    }
}
