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
    public MultipleAction(Tutor tutor,Action action) {
        this(tutor);
        this.addAction(action);
    }
    public MultipleAction(Tutor tutor,Action[] actions) {
        this(tutor);
        for(Action p : actions) {
            addAction(p);
        }
    }
    public MultipleAction(Tutor tutor,ArrayList<Action> actions) {
        this(tutor);
        myActions.addAll(actions);
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
    public void addAction(Action action) {
        myActions.add(action);
    }
}
