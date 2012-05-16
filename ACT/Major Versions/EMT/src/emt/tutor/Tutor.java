/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import emt.TutorPanel;
import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class Tutor {
    private TutorPanel myPanel;
    private HashMap images;
    
    public Tutor() {
        myPanel=null;
        images=new HashMap();
    }
    public Tutor(TutorPanel panel) {
        this();
        myPanel=panel;
    }
    
    public void AddImage(String label,String filename) {
        try {
            Image newImage=ImageIO.read(new File("lib"+File.separator+"Images"+File.separator+"Tutor/"+File.separator+filename));
            ImageIcon newImageIcon=new ImageIcon(newImage);
            images.put(label,newImageIcon);
        } catch(Exception ex) {
            System.out.println(ex);
            System.out.println(ex.getStackTrace());
        }
    }
    
    public void SwitchImage(String label) {
        if(images.containsKey(label)) {
            myPanel.SwitchImage((ImageIcon)images.get(label));
        }
    }
}
