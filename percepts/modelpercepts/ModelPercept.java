/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts.modelpercepts;

import emt.evexmodel.*;
import emt.tutor.Percept;
import emt.tutor.Tutor;

/**
 *
 * @author David
 */
public abstract class ModelPercept extends Percept {
    public ModelPercept() {
        
    }
    public ModelPercept(Tutor myTutor) {
        super(myTutor);
    }
    
    public EvexModel getModel() {
        return getTutor().getModel();
    }
    public boolean modelSelected() {
        return !(getTutor().getModel()==null);
    }
}
