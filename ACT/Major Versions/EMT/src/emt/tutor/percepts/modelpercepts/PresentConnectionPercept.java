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
public class PresentConnectionPercept extends ModelPercept {
    private String myNode1;
    private String myNode2;
    private String myProperty1;
    private String myProperty2;
    
    public PresentConnectionPercept(Tutor myTutor) {
        super(myTutor);
        myNode1="";
        myNode2="";
        myProperty1="";
        myProperty2="";
    }
    
    public boolean isTrue() {
        EvexModel myModel=getModel();
        if(myModel==null) {
            return false;
        }
        for(EvexEdge edge : myModel.getEdges()) {
            String node1=edge.getSourceNode().getName();
            String node2=edge.getDestNode().getName();
            String property1=edge.getSourceNode().getComponent();
            String property2=edge.getDestNode().getComponent();
            
            if(myNode1.equalsIgnoreCase(node1) && myNode2.equalsIgnoreCase(node2)) {
                if((myProperty1.length()<1 || myProperty1.equalsIgnoreCase(property1)) && (myProperty2.length()<1 || myProperty2.equalsIgnoreCase(property2))) {
                    return true;
                }
            }
            if(myNode2.equalsIgnoreCase(node1) && myNode1.equalsIgnoreCase(node2)) {
                if((myProperty1.length()<1 || myProperty1.equalsIgnoreCase(property2)) && (myProperty2.length()<1 || myProperty2.equalsIgnoreCase(property1))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void setNode1(String node) {
        myNode1=node;
    }
    public void setProperty1(String property) {
        myProperty1=property;
    }
    public String getNode1() {
        return myNode1;
    }
    public String getProperty1() {
        return myProperty1;
    }
    public void setNode2(String node) {
        myNode2=node;
    }
    public void setProperty2(String property) {
        myProperty2=property;
    }
    public String getNode2() {
        return myNode2;
    }
    public String getProperty2() {
        return myProperty2;
    }
}