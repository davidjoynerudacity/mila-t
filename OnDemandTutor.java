/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import emt.ProjectModelPanel;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author David
 */
public class OnDemandTutor extends Tutor {
    public OnDemandTutor() {
        super();
    }
    public OnDemandTutor(String name) {
        super(name);
    }
    public OnDemandTutor(String name,ProjectModelPanel modelPanel) {
        super(name,modelPanel);
    }
    
    public void wasClicked() {
        checkMappings();
        super.wasClicked();
    }
    
    
}
