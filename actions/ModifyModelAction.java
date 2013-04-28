/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions;

import emt.tutor.Action;
import emt.tutor.Tutor;
import emt.tutor.studentmodel.StudentModel;

/**
 *
 * @author David
 */
public class ModifyModelAction extends Action {
    private StudentModel model;
    private String construct;
    private int amount;
    
    public ModifyModelAction() {
        
    }
    public ModifyModelAction(Tutor tutor) {
        super(tutor);
    }
    public ModifyModelAction(Tutor tutor,StudentModel model,String construct,int amount) {
        super(tutor);
        this.model=model;
        this.construct=construct;
        this.amount=amount;
    }
    
    public void doAction() {
        if(model.hasConstruct(construct)) {
            model.incrementConstruct(construct, amount);
        }
    }

    public int getAmount() {
        return amount;
    }

    public String getConstruct() {
        return construct;
    }

    public StudentModel getModel() {
        return model;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setConstruct(String construct) {
        this.construct = construct;
    }

    public void setModel(StudentModel model) {
        this.model = model;
    }
    
    
}
