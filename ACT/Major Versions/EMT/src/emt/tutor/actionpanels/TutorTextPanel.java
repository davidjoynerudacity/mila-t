/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TutorTextPanel.java
 *
 * Created on May 28, 2012, 1:54:03 PM
 */
package emt.tutor.actionpanels;

import emt.tutor.StaticVars;
import emt.tutor.TutorContentPanel;
import emt.tutor.actions.TextFeedbackAction;
import java.util.Date;

/**
 *
 * @author David
 */
public class TutorTextPanel extends javax.swing.JPanel {
    private TutorContentPanel myContentPanel;
    private TextFeedbackAction myTFA;
    
    /** Creates new form TutorTextPanel */
    public TutorTextPanel(TutorContentPanel contentPanel) {
        initComponents();
        myContentPanel=contentPanel;
    }
    
    public void giveTextFeedback(TextFeedbackAction tfa) {
        if(tfa.getLogThis()) {
            StaticVars.Log("Tutor Text Feedback given", myContentPanel.getTutorName(),tfa.getFeedback());
        }
        this.tutorTextLabel.setText("<html><p>" + tfa.getFeedback() + "</p></html>");
        myTFA=tfa;
        if(tfa.getNextAction()==null) {
            //nextButton.setVisible(false);
            nextButton.setText("Hide");
        } else {
            //nextButton.setVisible(true);
            nextButton.setText("Next");
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tutorTextLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();

        setName("Form"); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(emt.EMTApp.class).getContext().getResourceMap(TutorTextPanel.class);
        tutorTextLabel.setFont(resourceMap.getFont("tutorTextLabel.font")); // NOI18N
        tutorTextLabel.setText(resourceMap.getString("tutorTextLabel.text")); // NOI18N
        tutorTextLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        tutorTextLabel.setName("tutorTextLabel"); // NOI18N
        add(tutorTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 520, 130));

        nextButton.setText(resourceMap.getString("nextButton.text")); // NOI18N
        nextButton.setName("nextButton"); // NOI18N
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if(myTFA.getNextAction()!=null) {
            myTFA.getNextAction().doAction();
        } else {
            myContentPanel.hideTutor();
            if(myTFA.getTutor().getNullAction()!=null) {
                myTFA.getTutor().getNullAction().doAction();
                myTFA.getTutor().setLastFeedbackTime(new Date());
            }
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel tutorTextLabel;
    // End of variables declaration//GEN-END:variables
}