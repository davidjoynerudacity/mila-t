/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

/**
 *
 * @author David
 */
public class Mapping {
    private Action myAction;
    private Percept myPercept;
    
    public Mapping() {
        
    }
    public Mapping(Percept percept,Action action) {
        myAction=action;
        myPercept=percept;
    }
    public Action getAction() {
        return myAction;
    }
    public void setAction(Action action) {
        myAction=action;
    }
    public Percept getPercept() {
        return myPercept;
    }
    public void setPercept(Percept percept) {
        myPercept=percept;
    }
    
    public Action check() {
        if(getPercept().isTrue()) {
            return getAction();
        } else {
            return null;
        }
    }
}
