/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.tutors;

import emt.ProjectModelPanel;
import emt.tutor.*;
import emt.tutor.actions.*;
import emt.tutor.percepts.*;
import emt.tutor.percepts.modelpercepts.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Timer;
/**
 *
 * @author David
 */
public class ObserverTutor extends InterruptTutor {
    private ArrayList<String> visibleComponents=new ArrayList<String>(Arrays.asList("fish","plants","trees","algae","water","dead matter","copepods"));
    private ArrayList<String> invisibleComponents=new ArrayList<String>(Arrays.asList("bacteria","nitrate","nitrite","ammonia","ammonium","phosphorus","Nitrogen","Carbon","Carbon Dioxide","Oxygen","Pollution","Iron","Nutrients","Phosphate"));;
    
    public ObserverTutor() {
        super("Observer");
        myTimer.stop();
        initializeTutor();
    }

    public ObserverTutor(ProjectModelPanel modelPanel) {
        super("Observer",modelPanel);
        myTimer.stop();
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("neutral-front", "a-neutral-front.jpg");
        addImage("neutral-side", "a-neutral-side.jpg");
        
        
        
        //Construct prioritized list of possible responses
//        ArrayList<Action> foundActions=new ArrayList<Action>();
//        
//        
//        //Iterate through responses and give the first one that hasn't been given already
//        for(Action action : foundActions) {
//            if(!StaticVars.usedActions.contains(action.getId())) {
//                action.doAction();
//            }
//        }
        
    }
    
    @Override
    public void checkMappings() {
        String lastActionString=StaticVars.mostRecentLog;
        String[] splitString=lastActionString.split("	");
        String command=splitString[0];
        
        if(command.equals("Component Added")) {
            StaticVars.currentModelingModel.incrementAddComponents(1); //Increment Add Component Count
            if(splitString[3].length()>0&&splitString[4].length()>0) { //Increment Components and Properties Count
                StaticVars.currentModelingModel.incrementComponentsAndProperties(1); 
            } else { //Decrement Components and Properties Count
                StaticVars.currentModelingModel.incrementComponentsAndProperties(-1);
            }
            if(this.getModel().getNodes().size()>4) {
                StaticVars.currentModelingModel.incrementModelSize(1);
            }
            
            String componentName=splitString[3].toLowerCase();
            if(visibleComponents.contains(componentName)) {
                StaticVars.currentEcologyModel.incrementVisibleComponents(1);
            }
            if(invisibleComponents.contains(componentName)) {
                StaticVars.currentEcologyModel.incrementInvisibleComponents(1);
            }
        } else if(command.equals("New Connection")) {
            StaticVars.currentModelingModel.incrementAddConnections(1); //Increment Connections Count
            if(StaticVars.currentModelingModel.getModelParallelCauses()<5) {
                if(this.getModel().hasParallelCauses()) {
                    StaticVars.currentModelingModel.incrementModelParallelCauses(5);
                }
            }
            if(StaticVars.currentModelingModel.getModelParallelEffects()<5) {
                if(this.getModel().hasParallelEffects()) {
                    StaticVars.currentModelingModel.incrementModelParallelEffects(5);
                }
            }
            if(this.getModel().getNodes().size()>4) {
                if(this.getModel().hasCausalFlow()) {
                    StaticVars.currentModelingModel.incrementModelCausalFlow(1);
                } else {
                    StaticVars.currentModelingModel.incrementModelCausalFlow(-1);
                }
            }
        } else if(command.equals("Component Edited")) {
            if(!(splitString[5].length()>0)||!(splitString[6].length()>0)) { //Decrement Components and Properties Count if there is no component or property mentioned
                StaticVars.currentModelingModel.incrementComponentsAndProperties(-1);
            } else if(((splitString[5].length()>0)&&(splitString[3].length()==0))||((splitString[6].length()>0)&&(splitString[4].length()==0))) { //Increment Components and Properties Count if a new component or property was edited in
                StaticVars.currentModelingModel.incrementComponentsAndProperties(1);
            }
        } else if(command.equals("Component Removed")||command.equals("Inserted New Component")) {
            StaticVars.currentModelingModel.incrementInsertingAndDeleting(1);
        } else if(command.equals("New Model Added")) {
            StaticVars.currentInquiryModel.incrementHypothesisGeneration(1);
        } else if(command.equals("Model Dismissed")||command.equals("Model Reconsidered")) {
            StaticVars.currentInquiryModel.incrementHypothesisDismissal(1);
        } else if(command.equals("Problem Definition Changed")) {
            if(splitString[3].length()>0) {
                StaticVars.currentInquiryModel.incrementProblemDescription(1);
            } else {
                StaticVars.currentInquiryModel.incrementProblemDescription(-1);
            }
        } else if(command.equals("Evidence Added")) {
            StaticVars.currentInquiryModel.incrementEvidenceBreadth(splitString[2]);
            if(Integer.parseInt(splitString[4])>2) {
                StaticVars.currentInquiryModel.incrementEvidenceDepth(1);
            }
            
            String category=splitString[2];
            if(category.equals("Controlled Experiment")||category.equals("Expert Information")) {
                StaticVars.currentInquiryModel.incrementEvidenceStrength(1);
            } else if(category.equals("Non-Expert Information")||category.equals("Logical Explanation")||category.equals("Other")||category.equals("")) {
                StaticVars.currentInquiryModel.incrementEvidenceStrength(-1);
            }
        } else if(command.equals("Evidence Changed")) {
            if(!(splitString[2].equals(splitString[4]))) {
                String category=splitString[4];
                if(category.equals("Controlled Experiment")||category.equals("Expert Information")) {
                    StaticVars.currentInquiryModel.incrementEvidenceStrength(1);
                } else if(category.equals("Non-Expert Information")||category.equals("Logical Explanation")||category.equals("Other")||category.equals("")) {
                    StaticVars.currentInquiryModel.incrementEvidenceStrength(-1);
                }
            }
        } else if(command.equals("Opened Simulation Dialog")) {
            StaticVars.currentMiscModel.incrementSimulationCount(1);
        } else if(command.equals("Opened Notes Dialog")) {
            StaticVars.currentMiscModel.incrementNoteCount(1);
        }
    }
}