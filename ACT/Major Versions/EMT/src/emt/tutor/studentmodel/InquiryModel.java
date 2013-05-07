/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.studentmodel;

import emt.tutor.StaticVars;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class InquiryModel  {
    private int cap=15;
    
    //BASIC CONSTRUCTS
    private int hypothesisGeneration;
    private int problemDescription;
    
    //INTERMEDIATE CONSTRUCTS
    private ArrayList<String> evidenceBreadth;
    private int evidenceStrength;
    
    //ADVANCED CONSTRUCTS
    private int evidenceDepth;
    private int hypothesisDismissal;

    public InquiryModel() {
        hypothesisGeneration=0;
        problemDescription=0;
        evidenceBreadth=new ArrayList<String>();
        evidenceStrength=0;
        evidenceDepth=0;
        hypothesisDismissal=0;
    }
    
    public int getBasicLevel() {
        return hypothesisGeneration+problemDescription;
    }
    public int getIntermediateLevel() {
        return Math.max(evidenceBreadth.size(),5)+evidenceStrength;
    }
    public int getAdvancedLevel() {
        return evidenceDepth+hypothesisDismissal;
    }

    public ArrayList<String> getEvidenceBreadth() {
        return evidenceBreadth;
    }

    public int getEvidenceDepth() {
        return evidenceDepth;
    }

    public int getEvidenceStrength() {
        return evidenceStrength;
    }

    public int getHypothesisDismissal() {
        return hypothesisDismissal;
    }

    public int getHypothesisGeneration() {
        return hypothesisGeneration;
    }

    public int getProblemDescription() {
        return problemDescription;
    }

    public void setEvidenceBreadth(ArrayList<String> evidenceBreadth) {
        this.evidenceBreadth = evidenceBreadth;
    }

    public void setEvidenceDepth(int evidenceDepth) {
        this.evidenceDepth = evidenceDepth;
    }

    public void setEvidenceStrength(int evidenceStrength) {
        this.evidenceStrength = evidenceStrength;
    }

    public void setHypothesisDismissal(int hypothesisDismissal) {
        this.hypothesisDismissal = hypothesisDismissal;
    }

    public void setHypothesisGeneration(int hypothesisGeneration) {
        this.hypothesisGeneration = hypothesisGeneration;
    }

    public void setProblemDescription(int problemDescription) {
        this.problemDescription = problemDescription;
    }
    public void incrementEvidenceBreadth(String evidence) {
        if(!evidenceBreadth.contains(evidence)) {
            evidenceBreadth.add(evidence);
            StaticVars.Log("Changing Student Model","Inquiry","Evidence Breadth",evidence,Integer.toString(evidenceBreadth.size()));
        }
    }

    public void incrementEvidenceDepth(int increment) {
        evidenceDepth=increment(evidenceDepth,increment);
        StaticVars.Log("Changing Student Model","Inquiry","Evidence Depth",Integer.toString(increment),Integer.toString(evidenceDepth));
    }

    public void incrementEvidenceStrength(int increment) {
        evidenceStrength=increment(evidenceStrength,increment);
        StaticVars.Log("Changing Student Model","Inquiry","Evidence Strength",Integer.toString(increment),Integer.toString(evidenceStrength));
    }

    public void incrementHypothesisDismissal(int increment) {
        hypothesisDismissal=increment(hypothesisDismissal,increment);
        StaticVars.Log("Changing Student Model","Inquiry","Hypothesis Dismissal",Integer.toString(increment),Integer.toString(hypothesisDismissal));
    }

    public void incrementHypothesisGeneration(int increment) {
        hypothesisGeneration=increment(hypothesisGeneration,increment);
        StaticVars.Log("Changing Student Model","Inquiry","Hypothesis Generation",Integer.toString(increment),Integer.toString(hypothesisGeneration));
    }

    public void incrementProblemDescription(int increment) {
        problemDescription=increment(problemDescription,increment);
        StaticVars.Log("Changing Student Model","Inquiry","Problem Description",Integer.toString(increment),Integer.toString(problemDescription));
    }
    
    private int increment(int construct,int increment) {
        construct+=increment;
        if(construct>cap) {
            construct=cap;
        } else if(construct<-cap) {
            construct=-cap;
        }
        return construct;
    }
}
