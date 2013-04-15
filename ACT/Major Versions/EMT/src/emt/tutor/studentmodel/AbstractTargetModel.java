/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.studentmodel;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public abstract class AbstractTargetModel {
    protected ArrayList<String> constructs;
    
    public AbstractTargetModel() {
        constructs=new ArrayList<String>();
    }
    
    public ArrayList<String> getConstructs() {
        return constructs;
    }
    
}
