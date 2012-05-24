/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

/**
 *
 * @author David
 */
public abstract class Action {
    private Tutor myTutor;
    
    public abstract void doAction();
    
    public Action(Tutor tutor) {
        myTutor=tutor;
    }
    public void setTutor(Tutor tutor) {
        myTutor=tutor;
    }
    public Tutor getTutor() {
        return myTutor;
    }
}
