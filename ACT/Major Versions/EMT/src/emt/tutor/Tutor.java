/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import emt.TutorPanel;
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
    private TutorPanel myPanel;
    private HashMap myImages;
    private ArrayList<Mapping> myMappings;
    
    public Tutor() {
        myPanel=null;
        myImages=new HashMap();
        myMappings=new ArrayList<Mapping>();
    }
    public Tutor(TutorPanel panel) {
        this();
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
}
