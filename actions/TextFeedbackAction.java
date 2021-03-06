/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions;

import emt.tutor.Action;
import emt.tutor.StaticVars;
import emt.tutor.Tutor;

/**
 *
 * @author David
 */
public class TextFeedbackAction extends Action {
    private String myFeedback;
    private boolean isRead=false;
    private Action myNextAction;
    private boolean myLogThis;
    
    public TextFeedbackAction() {
        myLogThis=true;
    }
    public TextFeedbackAction(Tutor myTutor) {
        super(myTutor);
        myLogThis=true;
    }
    public TextFeedbackAction(Tutor myTutor,String feedback) {
        this(myTutor);
        myFeedback=feedback;
    }
    public void doAction() {
        getTutor().giveTextFeedback(this);
        if(this.getFace()!=null) {
            this.getFace().doAction();
        }
    }
    public String getFeedback() {
        return myFeedback;
    }
    public void setFeedback(String feedback) {
        myFeedback=feedback;
    }
    public Action getNextAction() {
        return myNextAction;
    }
    public void setNextAction(Action action) {
        myNextAction=action;
    }
    
    public boolean getIsRead() {
        return isRead;
    }
    public void setIsRead(boolean read) {
        isRead=read;
        if(this.getId().length()>0) {
            StaticVars.usedActions.add(this.getId());
        }
    }
    public void setLogThis(boolean logThis) {
        this.myLogThis=logThis;
    }
    public boolean getLogThis() {
        return myLogThis;
    }
    
}
