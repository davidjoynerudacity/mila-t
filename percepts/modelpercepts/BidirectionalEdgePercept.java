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
public class BidirectionalEdgePercept extends ModelPercept {
    private int mySearchCount;
    private char mySearchType;

    public BidirectionalEdgePercept() {
    }
    
    public BidirectionalEdgePercept(Tutor myTutor) {
        super(myTutor);
        mySearchCount=0;
        mySearchType='=';
    }
    public BidirectionalEdgePercept(Tutor myTutor,int searchCount) {
        this(myTutor);
        mySearchCount=searchCount;
    }
    public BidirectionalEdgePercept(Tutor myTutor,int searchCount,char searchType) {
        this(myTutor);
        mySearchCount=searchCount;
        mySearchType=searchType;
    }
    
    
    public boolean isTrue() {
        if(!super.modelSelected()) { return false; }
        
        EvexModel myModel=getModel();
        for(EvexEdge edge : myModel.getEdges()) {
            if(edge.getDestArrow() && edge.getSourceArrow()) {
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