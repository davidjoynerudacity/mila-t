/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts.modelpercepts;

import emt.evexmodel.*;
import emt.tutor.Tutor;

/**
 *
 * @author David
 */
public class ConnectionCountPercept extends ModelPercept {
    private int mySearchCount;
    private char mySearchType;

    public ConnectionCountPercept() {
    }
    
    public ConnectionCountPercept(Tutor myTutor) {
        super(myTutor);
        mySearchCount=0;
        mySearchType='=';
    }
    public ConnectionCountPercept(Tutor myTutor,int searchCount) {
        this(myTutor);
        mySearchCount=searchCount;
    }
    public ConnectionCountPercept(Tutor myTutor,int searchCount,char searchType) {
        this(myTutor);
        mySearchCount=searchCount;
        mySearchType=searchType;
    }
    
    
    public boolean isTrue() {
        if(!super.modelSelected()) { return false; }
        
        EvexModel myModel=getModel();
        if(mySearchType=='=') {
            if(myModel.getEdges().size()==mySearchCount) {
                return true;
            }
        } else if(mySearchType=='<') {
            if(myModel.getEdges().size()<=mySearchCount) {
                return true;
            }
        } else if(mySearchType=='>') {
            if(myModel.getEdges().size()>=mySearchCount) {
                return true;
            }
        }
        return false;
    }
    
    public void setSearchCount(int searchCount) {
        mySearchCount=searchCount;
    }
    public int getSearchCount() {
        return mySearchCount;
    }
    public void setSearchType(char searchType) {
        mySearchType=searchType;
    }
    public char getSearchType() {
        return mySearchType;
    }
}