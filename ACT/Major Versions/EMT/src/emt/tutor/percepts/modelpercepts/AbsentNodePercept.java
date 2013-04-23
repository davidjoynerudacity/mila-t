/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts.modelpercepts;

import emt.evexmodel.*;
import emt.tutor.Tutor;

/**
 *
 * @author David
 */
public class AbsentNodePercept extends ModelPercept {
    private String myNode;
    private String myProperty;

    public AbsentNodePercept() {
    }
    
    public AbsentNodePercept(Tutor myTutor) {
        super(myTutor);
        myNode="";
        myProperty="";
    }
    public AbsentNodePercept(Tutor myTutor,String node) {
        this(myTutor);
        myNode=node;
    }
    public AbsentNodePercept(Tutor myTutor,String node,String property) {
        this(myTutor);
        myNode=node;
        myProperty=property;
    }
    
    public boolean isTrue() {
        if(!super.modelSelected()) { return false; }
        EvexModel myModel=getModel();
        for(EvexNode node : myModel.getNodes()) {
            if(node.getName().equalsIgnoreCase(myNode)) {
                if(myProperty.length()>0) {
                    if(node.getComponent().equalsIgnoreCase(myProperty)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void setNode(String node) {
        myNode=node;
    }
    public void setProperty(String property) {
        myProperty=property;
    }
    public String getNode() {
        return myNode;
    }
    public String getProperty() {
        return myProperty;
    }
}
