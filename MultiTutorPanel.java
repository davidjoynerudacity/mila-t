/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MultiTutorPanel.java
 *
 * Created on May 23, 2012, 1:21:04 PM
 */
package emt.tutor;

import emt.tutor.Tutor;
import java.awt.CardLayout;

/**
 *
 * @author David
 */
public class MultiTutorPanel extends javax.swing.JPanel {
    private CardLayout myLayout;
    
    /** Creates new form MultiTutorPanel */
    public MultiTutorPanel() {
        initComponents();
        
        myLayout=new CardLayout();
        this.setLayout(myLayout);
    }
    public void addTutor(Tutor tutor) {
        this.add(tutor.returnPanel(),tutor.getName());
    }
    public void switchTutor(String name) {
        ((CardLayout)this.getLayout()).show(this, name);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(emt.EMTApp.class).getContext().getResourceMap(MultiTutorPanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setMaximumSize(new java.awt.Dimension(148, 148));
        setMinimumSize(new java.awt.Dimension(148, 148));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(148, 148));
        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
