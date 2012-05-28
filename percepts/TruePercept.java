/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts;

import emt.tutor.Percept;
import emt.tutor.Tutor;

/**
 *
 * @author David
 */
public class TruePercept extends Percept {
    public TruePercept(Tutor myTutor) {
        super(myTutor);
    }
    
    public boolean isTrue() {
        return true;
    }
}
