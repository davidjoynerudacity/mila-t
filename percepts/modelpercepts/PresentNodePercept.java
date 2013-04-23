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
public class PresentNodePercept extends ModelPercept {
    private String myNode;
    private String myProperty;
    private String myColor;

    public PresentNodePercept() {
    }
    
    public PresentNodePercept(Tutor myTutor) {
        super(myTutor);
        myNode="";
        myProperty="";
        myColor="";
    }
    public PresentNodePercept(Tutor myTutor,String node) {
        this(myTutor);
        myNode=node;
    }
    public PresentNodePercept(Tutor myTutor,String node,String property) {
        this(myTutor,node);
        myProperty=property;
    }
    
    
    public boolean isTrue() {
        if(!super.modelSelected()) { return false; }
        EvexModel myModel=getModel();
        for(EvexNode node : myModel.getNodes()) {
            if(node.getName().equalsIgnoreCase(myNode)) {
                if(myProperty.length()>0) {
                    if(node.getComponent().equalsIgnoreCase(myProperty)) {
                        if(myColor.length()>0) {
                            if(node.getColor().equalsIgnoreCase(myColor)) {
                                return true;
                            }
                        } else {
                            return true;
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void setNode(String node) {
        myNode=node;
    }
    public void setProperty(String property) {
        myProperty=property;
    }
    public void setColor(String color) {
        myColor=color;
    }
    public String getNode() {
        return myNode;
    }
    public String getProperty() {
        return myProperty;
    }
    public String getColor() {
        return myColor;
    }
}
