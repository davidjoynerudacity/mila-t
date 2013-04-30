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
public class EcologyModel    {
    private int cap=5;
    
    //BASIC CONSTRUCTS
    private int visibleComponents;
    
    //INTERMEDIATE CONSTRUCTS
    private int invisibleComponents;
    
    //ADVANCED CONSTRUCTS
    private int causalRelationships;

    public EcologyModel() {
        visibleComponents=0;
        invisibleComponents=0;
        causalRelationships=0;
    }
    
    public int getBasicLevel() {
        return visibleComponents;
    }
    public int getIntermediateLevel() {
        return invisibleComponents;
    }
    public int getAdvancedLevel() {
        return causalRelationships;
    }

    public int getInvisibleComponents() {
        return invisibleComponents;
    }

    public int getCausalRelationships() {
        return causalRelationships;
    }

    public int getVisibleComponents() {
        return visibleComponents;
    }

    public void setInvisibleComponents(int invisibleComponents) {
        this.invisibleComponents = invisibleComponents;
    }

    public void setCausalRelationships(int causalRelationships) {
        this.causalRelationships = causalRelationships;
    }

    public void setVisibleComponents(int visibleComponents) {
        this.visibleComponents = visibleComponents;
    }

    public void incrementInvisibleComponents(int increment) {
        invisibleComponents=increment(invisibleComponents,increment);
        StaticVars.Log("Changing Student Model","Ecology","Invisible Components",Integer.toString(increment),Integer.toString(invisibleComponents));
    }

    public void incrementCausalRelationships(int increment) {
        causalRelationships=increment(causalRelationships,increment);
        StaticVars.Log("Changing Student Model","Ecology","Causal Relationships",Integer.toString(increment),Integer.toString(causalRelationships));
    }

    public void incrementVisibleComponents(int increment) {
        visibleComponents=increment(visibleComponents,increment);
        StaticVars.Log("Changing Student Model","Ecology","Visible Components",Integer.toString(increment),Integer.toString(visibleComponents));
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
