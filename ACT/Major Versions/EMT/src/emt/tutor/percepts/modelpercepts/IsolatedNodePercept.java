/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts.modelpercepts;

import emt.evexmodel.*;
import emt.tutor.Tutor;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class IsolatedNodePercept extends ModelPercept {
    public IsolatedNodePercept(Tutor myTutor) {
        super(myTutor);
    }
    
    public boolean isTrue() {
        if(!super.modelSelected()) { return false; }
        EvexModel myModel=getModel();
        
        ArrayList connectedNodes=new ArrayList<EvexNode>();
        for(EvexEdge edge : myModel.getEdges()) {
            if(!connectedNodes.contains(edge.getSourceNode())) {
                connectedNodes.add(edge.getSourceNode());
            }
            if(!connectedNodes.contains(edge.getDestNode())) {
                connectedNodes.add(edge.getDestNode());
            }
        }
        if(!(connectedNodes.size()==myModel.getNodes().size())) {
            return true;
        }
        return false;
    }
}
