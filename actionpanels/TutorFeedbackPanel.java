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
import emt.tutor.StaticVars;
import emt.tutor.TutorContentPanel;
import emt.tutor.actions.ChangePictureAction;
import emt.tutor.actions.FeedbackPromptAction;
import emt.tutor.actions.MultipleAction;
import emt.tutor.actions.TextFeedbackAction;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author David
 */
public class TutorFeedbackPanel extends javax.swing.JPanel {
    private TutorContentPanel myContentPanel;
    private FeedbackPromptAction myFPA;
    
    /** Creates new form TutorFeedbackPanel */
    public TutorFeedbackPanel(TutorContentPanel contentPanel) {
        initComponents();
        myContentPanel=contentPanel;
    }
    
    public void setPrompt(FeedbackPromptAction prompt) {
        QuestionLabel.setText(prompt.getPrompt());
        myFPA=prompt;
        StaticVars.Log("Tutor Feedback Asked", myContentPanel.getTutorName(),myFPA.getPrompt());
    }
    
    private void saveFeedback() {
        try {
            new File("Feedback Answers").mkdir();
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            PrintWriter save = new PrintWriter("Feedback Answers" + File.separator + "feedback-"+sdf.format(cal.getTime())+".txt");
            save.println(QuestionLabel.getText());
            save.println(FeedbackTextArea.getText());
            save.close();
            myFPA.setHasBeenAnswered(true);
            StaticVars.Log("Tutor Feedback Received", myContentPanel.getTutorName(),myFPA.getPrompt(),FeedbackTextArea.getText());
        } catch(Exception ex) {}
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
        jButton1 = new javax.swing.JButton();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(emt.EMTApp.class).getContext().getResourceMap(TutorFeedbackPanel.class);
        QuestionLabel.setFont(resourceMap.getFont("QuestionLabel.font")); // NOI18N
        QuestionLabel.setText(resourceMap.getString("QuestionLabel.text")); // NOI18N
        QuestionLabel.setName("QuestionLabel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        FeedbackTextArea.setColumns(20);
        FeedbackTextArea.setLineWrap(true);
        FeedbackTextArea.setRows(4);
        FeedbackTextArea.setName("FeedbackTextArea"); // NOI18N
        jScrollPane1.setViewportView(FeedbackTextArea);

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addComponent(QuestionLabel)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QuestionLabel)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        saveFeedback();
        new MultipleAction(myFPA.getTutor(),new Action[]{new ChangePictureAction(myFPA.getTutor(),"happy-front"),new TextFeedbackAction(myFPA.getTutor(),"Thanks for your response! You can close me now -- I'll let you know if I have any more questions.")}).doAction();
        FeedbackTextArea.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea FeedbackTextArea;
    private javax.swing.JLabel QuestionLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
