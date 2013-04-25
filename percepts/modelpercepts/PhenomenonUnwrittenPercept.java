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
public class PhenomenonUnwrittenPercept extends ModelPercept {
    
    public PhenomenonUnwrittenPercept() {
    }
    
    public PhenomenonUnwrittenPercept(Tutor myTutor) {
        super(myTutor);
    }
    
    public boolean isTrue() {
        return !(getTutor().getPhenomenon().length()>0);
    }
}