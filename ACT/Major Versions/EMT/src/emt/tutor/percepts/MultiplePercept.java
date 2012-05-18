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
}
