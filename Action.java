/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import emt.tutor.actions.ChangePictureAction;

/**
 *
 * @author David
 */
public abstract class Action {
    private Tutor myTutor;
    private String id="";
    private ChangePictureAction face;
    
    public abstract void doAction();
    
    public Action() {
        
    }
    public Action(Tutor tutor) {
        myTutor=tutor;
    }
    public void setTutor(Tutor tutor) {
        myTutor=tutor;
    }
    public Tutor getTutor() {
        return myTutor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChangePictureAction getFace() {
        return face;
    }

    public void setFace(ChangePictureAction face) {
        this.face = face;
    }
    
}
