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
    
    public AbsentNodePercept(Tutor myTutor) {
        super(myTutor);
        myNode="";
        myProperty="";
    }
    
    public boolean isTrue() {
        EvexModel myModel=getModel();
        for(EvexNode node : myModel.getNodes()) {
            if(node.getName().equals(myNode)) {
                if(myProperty.length()>0) {
                    if(node.getComponent().equals(myProperty)) {
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
