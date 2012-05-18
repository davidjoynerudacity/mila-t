/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts;

import emt.tutor.Percept;
import emt.tutor.Tutor;
import java.util.Calendar;

/**
 *
 * @author David
 */
public class SamplePercept extends Percept {
    private int myTarget;
    public SamplePercept(Tutor tutor) {
        super(tutor);
        myTarget=0;
    }
    public boolean isTrue() {
        Calendar calendar=Calendar.getInstance();
        if(calendar.get(Calendar.SECOND)%3==myTarget%3) {
            return true;
        } else {
            return false;
        }
    }
    public void setTarget(int target) {
        myTarget=target;
    }
    public int getTarget() {
        return myTarget;
    }
}
