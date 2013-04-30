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
    private String id="";
    private String face="";
    
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

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }
    
}
