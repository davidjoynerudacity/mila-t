/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions;

import emt.tutor.TutorPanel;
import emt.tutor.Action;
import emt.tutor.Tutor;

/**
 *
 * @author David
 */
public class ChangePictureAction extends Action {
    private String myPicKey;
    public ChangePictureAction(Tutor myTutor) {
        super(myTutor);
    }
    public void doAction() {
            getTutor().switchImage(myPicKey);
    }
    public String getPicKey() {
        return myPicKey;
    }
    public void setPicKey(String picKey) {
        myPicKey=picKey;
    }
}
