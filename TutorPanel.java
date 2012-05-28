/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TutorPanel.java
 *
 * Created on May 8, 2012, 2:40:37 PM
 */
package emt.tutor;

import emt.tutor.Mapping;
import emt.tutor.Tutor;
import emt.tutor.actions.ChangePictureAction;
import emt.tutor.percepts.SamplePercept;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class TutorPanel extends javax.swing.JPanel {

    /** Creates new form TutorPanel */
    private Tutor myTutor;
    
    public TutorPanel() {
        initComponents();
        
//        tutors=new ArrayList<Tutor>();     
//        Tutor t1=new Tutor(this);
//        t1.addImage("1", "test1.png");
//        t1.addImage("2", "test2.png");
//        t1.addImage("3", "test3.png");
//        t1.switchImage("3");
//        
//        SamplePercept sp1=new SamplePercept(t1);
//        sp1.setTarget(0);
//        SamplePercept sp2=new SamplePercept(t1);
//        sp2.setTarget(1);
//        SamplePercept sp3=new SamplePercept(t1);
//        sp3.setTarget(2);
//        
//        ChangePictureAction cpa1=new ChangePictureAction(t1);
//        cpa1.setPicKey("1");
//        ChangePictureAction cpa2=new ChangePictureAction(t1);
//        cpa2.setPicKey("2");
//        ChangePictureAction cpa3=new ChangePictureAction(t1);
//        cpa3.setPicKey("3");
//        
//        Mapping m1=new Mapping();
//        m1.setPercept(sp1);
//        m1.setAction(cpa1);
//        Mapping m2=new Mapping();
//        m2.setPercept(sp2);
//        m2.setAction(cpa2);
//        Mapping m3=new Mapping();
//        m3.setPercept(sp3);
//        m3.setAction(cpa3);
//        
//        t1.addMapping(m1);
//        t1.addMapping(m2);
//        t1.addMapping(m3);
//        
//        tutors.add(t1); 
//        //jLabel1.setVisible(false);
    }
    
    public void setTutor(Tutor tutor) {
        myTutor=tutor;
        tutor.setPanel(this);
    }
    public Tutor getTutor() {
        return myTutor;
    }
    
    public void switchImage(ImageIcon image) {
        tutorImageLabel.setIcon(image);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tutorImageLabel = new javax.swing.JLabel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(emt.EMTApp.class).getContext().getResourceMap(TutorPanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setMaximumSize(new java.awt.Dimension(148, 148));
        setMinimumSize(new java.awt.Dimension(148, 148));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(148, 148));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        tutorImageLabel.setIcon(resourceMap.getIcon("tutorImageLabel.icon")); // NOI18N
        tutorImageLabel.setText(resourceMap.getString("tutorImageLabel.text")); // NOI18N
        tutorImageLabel.setName("tutorImageLabel"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tutorImageLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(tutorImageLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        myTutor.checkMappings();
        myTutor.showTutor();
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel tutorImageLabel;
    // End of variables declaration//GEN-END:variables
}
