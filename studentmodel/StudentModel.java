/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.studentmodel;

import java.util.HashMap;

/**
 *
 * @author David
 */
public class StudentModel {
    private AbstractTargetModel myTargetModel;
    private HashMap<String,Integer> myScores;
    
    public StudentModel() {
        
    }
    
    public StudentModel(AbstractTargetModel targetModel) {
        myTargetModel=targetModel;
        InitializeHashtable();
    }
    private void InitializeHashtable() {
        myScores=new HashMap<String,Integer>();
        for(String construct : myTargetModel.getConstructs()) {
            myScores.put(construct, new Integer(0));
        }
    }
    public HashMap getScores() {
        return myScores;
    }
    public void setScores(HashMap scores) {
        myScores=scores;
    }
    public Integer checkConstruct(String construct) {
        return myScores.get(construct);
    }
    public void incrementConstruct(String construct,int value) {
        try {
            Integer currentScore=myScores.get(construct);
            myScores.put(construct, new Integer(currentScore.intValue()+value));
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    public AbstractTargetModel getTargetModel() {
        return myTargetModel;
    }
    public void setTargetModel(AbstractTargetModel targetModel) {
        myTargetModel=targetModel;
    }
}
