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
public class MissingPropertiesPercept extends ModelPercept {
    public MissingPropertiesPercept(Tutor myTutor) {
        super(myTutor);
    }
    
    public boolean isTrue() {
        EvexModel myModel=getModel();
        for(EvexNode node : myModel.getNodes()) {
            if(node.getComponent().length()<1) {
                return true;
            }
        }
        return false;
    }
}
