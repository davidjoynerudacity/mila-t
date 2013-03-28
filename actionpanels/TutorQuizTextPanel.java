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
import javax.swing.JOptionPane;

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
    public void saveAnswer() {
        myPrompt.setAnswer(FeedbackTextArea.getText());
    }
    public void setQuizTextAction(QuizTextAction prompt) {
        myPrompt=prompt;
        if(myPrompt.getIsLast()) {
            NextButton.setText("Finish");
        } else {
            NextButton.setText("Next");
        }
        if(myPrompt.getIsFirst()) {
            PreviousButton.setVisible(false);
        } else {
            PreviousButton.setVisible(true);
        }
        FeedbackTextArea.setText(myPrompt.getAnswer());
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
        PreviousButton = new javax.swing.JButton();

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
        FeedbackTextArea.setWrapStyleWord(true);
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

        PreviousButton.setText(resourceMap.getString("PreviousButton.text")); // NOI18N
        PreviousButton.setName("PreviousButton"); // NOI18N
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });
        add(PreviousButton);
        PreviousButton.setBounds(370, 120, 80, 23);
    }// </editor-fold>//GEN-END:initComponents

private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
    if(FeedbackTextArea.getText().length()==0&&myPrompt.getAnswerRequired()) {
        JOptionPane.showMessageDialog(this, "Please type an answer before proceeding.");
    } else {
        saveAnswer();
        myPrompt.next();
    }
}//GEN-LAST:event_NextButtonActionPerformed

private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
    saveAnswer();
    myPrompt.previous();
}//GEN-LAST:event_PreviousButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea FeedbackTextArea;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JLabel QuestionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}