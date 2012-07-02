/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts;

import emt.tutor.Percept;
import emt.tutor.Tutor;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class MultiplePercept extends Percept {
    private ArrayList<Percept> myPercepts;
    
    public MultiplePercept(Tutor tutor) {
        super(tutor);
        myPercepts=new ArrayList<Percept>();
    }
    public MultiplePercept(Tutor tutor,Percept percept) {
        this(tutor);
        this.addPercept(percept);
    }
    public MultiplePercept(Tutor tutor,Percept[] percepts) {
        this(tutor);
        for(Percept p : percepts) {
            addPercept(p);
        }
    }
    public MultiplePercept(Tutor tutor,ArrayList<Percept> percepts) {
        this(tutor);
        myPercepts.addAll(percepts);
    }
    public boolean isTrue() {
        for(Percept percept : myPercepts) {
            if(!percept.isTrue()) {
                return false;
            }
        }
        return true;
    }
    public void setPercepts(ArrayList<Percept> percepts) {
        myPercepts=percepts;
    }
    public ArrayList<Percept> getPercepts() {
        return myPercepts;
    }
    public void addPercept(Percept percept) {
        myPercepts.add(percept);
    }
}
