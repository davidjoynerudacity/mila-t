/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions;

import emt.tutor.Action;
import emt.tutor.Tutor;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class MultipleAction extends Action {
    private ArrayList<Action> myActions;
    
    public MultipleAction(Tutor tutor) {
        super(tutor);
        myActions=new ArrayList<Action>();
    }
    public void doAction() {
        for(Action action : myActions) {
            action.doAction();
        }
    }
    public void setActions(ArrayList<Action> actions) {
        myActions=actions;
    }
    public ArrayList<Action> getActions() {
        return myActions;
    }
}
