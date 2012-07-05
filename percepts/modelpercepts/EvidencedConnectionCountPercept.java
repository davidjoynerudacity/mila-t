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
public class EvidencedConnectionCountPercept extends ModelPercept {
    private int mySearchCount;
    private char mySearchType;
    
    public EvidencedConnectionCountPercept(Tutor myTutor) {
        super(myTutor);
        mySearchCount=0;
        mySearchType='=';
    }
    public EvidencedConnectionCountPercept(Tutor myTutor,int searchCount) {
        this(myTutor);
        mySearchCount=searchCount;
    }
    public EvidencedConnectionCountPercept(Tutor myTutor,int searchCount,char searchType) {
        this(myTutor);
        mySearchCount=searchCount;
        mySearchType=searchType;
    }
    
    
    public boolean isTrue() {
        if(!super.modelSelected()) { return false; }
        
        EvexModel myModel=getModel();
        int evidencedCount=0;
        for(EvexEdge edge : myModel.getEdges()) {
            if(edge.isEvidenced()) {
                evidencedCount++;
            }
        }
        if(mySearchType=='=') {
            if(evidencedCount==mySearchCount) {
                return true;
            }
        } else if(mySearchType=='<') {
            if(evidencedCount<=mySearchCount) {
                return true;
            }
        } else if(mySearchType=='>') {
            if(evidencedCount>=mySearchCount) {
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