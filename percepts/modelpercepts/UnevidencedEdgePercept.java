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
public class UnevidencedEdgePercept extends ModelPercept {
    public UnevidencedEdgePercept(Tutor myTutor) {
        super(myTutor);
    }
    
    public boolean isTrue() {
        if(!super.modelSelected()) { return false; }
        EvexModel myModel=getModel();
        for(EvexEdge edge : myModel.getEdges()) {
            if(!edge.isEvidenced()) {
                return true;
            }
        }
        return false;
    }
}
