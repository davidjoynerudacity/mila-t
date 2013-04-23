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
public class NoModelSelectedPercept extends ModelPercept {

    public NoModelSelectedPercept() {
    }
    public NoModelSelectedPercept(Tutor myTutor) {
        super(myTutor);
    }
    
    public boolean isTrue() {
        if(!super.modelSelected()) { return true; }
        return false;
    }
}