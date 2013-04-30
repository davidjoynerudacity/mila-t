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
public class ModelingModel   {
    private int cap=5;
    
    //BASIC CONSTRUCTS
    private int addComponents;
    private int addConnections;
    private int componentsandproperties;
    private int insertinganddeleting;
    
    //INTERMEDIATE CONSTRUCTS
    private int modelSize;
    private int modelParallelCauses;
    
    //ADVANCED CONSTRUCTS
    private int modelCausalFlow;
    private int modelParallelEffects;

    public ModelingModel() {
        addComponents=0;
        addConnections=0;
        componentsandproperties=0;
        insertinganddeleting=0;
        modelSize=0;
        modelParallelCauses=0;
        modelCausalFlow=0;
        modelParallelEffects=0;
    }
    
    public int getBasicLevel() {
        return addComponents+addConnections+componentsandproperties+insertinganddeleting;
    }
    public int getIntermediateLevel() {
        return modelSize+modelParallelCauses;
    }
    public int getAdvancedLevel() {
        return modelCausalFlow+modelParallelEffects;
    }

    public int getModelSize() {
        return modelSize;
    }

    public int getModelCausalFlow() {
        return modelCausalFlow;
    }

    public int getModelParallelCauses() {
        return modelParallelCauses;
    }

    public int getModelParallelEffects() {
        return modelParallelEffects;
    }

    public int getAddComponents() {
        return addComponents;
    }

    public int getAddConnections() {
        return addConnections;
    }

    public int getComponentsAndProperties() {
        return componentsandproperties;
    }

    public int getInsertingAndDeleting() {
        return insertinganddeleting;
    }

    public void setModelSize(int modelSize) {
        this.modelSize = modelSize;
    }

    public void setModelCausalFlow(int modelCausalFlow) {
        this.modelCausalFlow = modelCausalFlow;
    }

    public void setModelParallelCauses(int modelParallelCauses) {
        this.modelParallelCauses = modelParallelCauses;
    }

    public void setModelParallelEffects(int modelParallelEffects) {
        this.modelParallelEffects = modelParallelEffects;
    }

    public void setAddComponents(int addComponents) {
        this.addComponents = addComponents;
    }

    public void setAddConnections(int addConnections) {
        this.addConnections = addConnections;
    }

    public void setComponentsAndProperties(int componentsandproperties) {
        this.componentsandproperties = componentsandproperties;
    }

    public void setInsertingAndDeleting(int insertinganddeleting) {
        this.insertinganddeleting = insertinganddeleting;
    }
    
    
    public void incrementModelSize(int increment) {
        modelSize=increment(modelSize,increment);
        StaticVars.Log("Changing Student Model","Modeling","Model Size",Integer.toString(increment),Integer.toString(modelSize));
    }

    public void incrementModelCausalFlow(int increment) {
        modelCausalFlow=increment(modelCausalFlow,increment);
        StaticVars.Log("Changing Student Model","Modeling","Model Causal Flow",Integer.toString(increment),Integer.toString(modelCausalFlow));
    }

    public void incrementModelParallelCauses(int increment) {
        modelParallelCauses=increment(modelParallelCauses,increment);
        StaticVars.Log("Changing Student Model","Modeling","Model Parallel Causes",Integer.toString(increment),Integer.toString(modelParallelCauses));
    }

    public void incrementModelParallelEffects(int increment) {
        modelParallelEffects=increment(modelParallelEffects,increment);
        StaticVars.Log("Changing Student Model","Modeling","Model Parallel Effects",Integer.toString(increment),Integer.toString(modelParallelEffects));
    }

    public void incrementAddComponents(int increment) {
        insertinganddeleting=increment(insertinganddeleting,increment);
        StaticVars.Log("Changing Student Model","Modeling","Add Components",Integer.toString(increment),Integer.toString(insertinganddeleting));
    }

    public void incrementAddConnections(int increment) {
        addConnections=increment(addConnections,increment);
        StaticVars.Log("Changing Student Model","Modeling","Add Connections",Integer.toString(increment),Integer.toString(addConnections));
    }
    public void incrementInsertingAndDeleting(int increment) {
        addComponents=increment(addComponents,increment);
        StaticVars.Log("Changing Student Model","Modeling","Add Components",Integer.toString(increment),Integer.toString(addComponents));
    }

    public void incrementComponentsAndProperties(int increment) {
        componentsandproperties=increment(componentsandproperties,increment);
        StaticVars.Log("Changing Student Model","Modeling","Components and Properties",Integer.toString(increment),Integer.toString(componentsandproperties));
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
