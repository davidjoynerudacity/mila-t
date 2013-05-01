/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.studentmodel;

import emt.tutor.StaticVars;

/**
 *
 * @author David
 */
public class MiscModel    {
    private int guideCount;
    private int criticCount;
    private int mentorCount;
    private int interviewerCount;
    private int simulationCount;
    private int noteCount;

    public MiscModel() {
          guideCount=0;
          criticCount=0;
          mentorCount=0;
          interviewerCount=0;
          simulationCount=0;
          noteCount=0;
    }

    public int getCriticCount() {
        return criticCount;
    }

    public int getGuideCount() {
        return guideCount;
    }

    public int getInterviewerCount() {
        return interviewerCount;
    }

    public int getMentorCount() {
        return mentorCount;
    }

    public int getNoteCount() {
        return noteCount;
    }

    public int getSimulationCount() {
        return simulationCount;
    }

    public void setCriticCount(int criticCount) {
        this.criticCount = criticCount;
    }

    public void setGuideCount(int guideCount) {
        this.guideCount = guideCount;
    }

    public void setInterviewerCount(int interviewerCount) {
        this.interviewerCount = interviewerCount;
    }

    public void setMentorCount(int mentorCount) {
        this.mentorCount = mentorCount;
    }

    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }

    public void setSimulationCount(int simulationCount) {
        this.simulationCount = simulationCount;
    }

    public void incrementCriticCount(int increment) {
        this.criticCount+=increment;
    }

    public void incrementGuideCount(int increment) {
        this.guideCount+=increment;
    }

    public void incrementInterviewerCount(int increment) {
        this.interviewerCount+=increment;
    }

    public void incrementMentorCount(int increment) {
        this.mentorCount+=increment;
    }

    public void incrementNoteCount(int increment) {
        this.noteCount+=increment;
    }

    public void incrementSimulationCount(int increment) {
        this.simulationCount+=increment;
    }
    
    
}
