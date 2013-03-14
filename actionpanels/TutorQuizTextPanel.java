/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TutorFeedbackPanel.java
 *
 * Created on May 28, 2012, 1:54:50 PM
 */
package emt.tutor.actionpanels;

import emt.tutor.Action;
import emt.tutor.StaticLogs;
import emt.tutor.TutorContentPanel;
import emt.tutor.actions.ChangePictureAction;
import emt.tutor.actions.FeedbackPromptAction;
import emt.tutor.actions.MultipleAction;
import emt.tutor.actions.TextFeedbackAction;
import emt.tutor.actions.quiz.QuizTextAction;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author David
 */
public class TutorQuizTextPanel extends javax.swing.JPanel {
    private TutorContentPanel myContentPanel;
    private QuizTextAction myPrompt;
    
    /** Creates new form TutorFeedbackPanel */
    public TutorQuizTextPanel(TutorContentPanel contentPanel) {
        initComponents();
        myContentPanel=contentPanel;
    }
    
    public void setQuizTextAction(QuizTextAction prompt) {
        myPrompt=prompt;
        QuestionLabel.setText(prompt.getPrompt());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuestionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FeedbackTextArea = new javax.swing.JTextArea();
        NextButton = new javax.swing.JButton();

        setName("Form"); // NOI18N
        setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(emt.EMTApp.class).getContext().getResourceMap(TutorQuizTextPanel.class);
        QuestionLabel.setFont(resourceMap.getFont("QuestionLabel.font")); // NOI18N
        QuestionLabel.setText(resourceMap.getString("QuestionLabel.text")); // NOI18N
        QuestionLabel.setName("QuestionLabel"); // NOI18N
        add(QuestionLabel);
        QuestionLabel.setBounds(10, 11, 520, 17);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        FeedbackTextArea.setColumns(20);
        FeedbackTextArea.setLineWrap(true);
        FeedbackTextArea.setRows(4);
        FeedbackTextArea.setName("FeedbackTextArea"); // NOI18N
        jScrollPane1.setViewportView(FeedbackTextArea);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 38, 520, 78);

        NextButton.setText(resourceMap.getString("NextButton.text")); // NOI18N
        NextButton.setName("NextButton"); // NOI18N
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });
        add(NextButton);
        NextButton.setBounds(450, 120, 80, 23);
    }// </editor-fold>//GEN-END:initComponents

private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
    myPrompt.next();
}//GEN-LAST:event_NextButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea FeedbackTextArea;
    private javax.swing.JButton NextButton;
    private javax.swing.JLabel QuestionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
