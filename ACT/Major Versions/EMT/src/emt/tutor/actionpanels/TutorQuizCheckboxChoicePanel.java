/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TutorQuestionsPanel.java
 *
 * Created on May 28, 2012, 1:54:25 PM
 */
package emt.tutor.actionpanels;

import emt.tutor.QuestionItem;
import emt.tutor.StaticVars;
import emt.tutor.TutorContentPanel;
import emt.tutor.actions.quiz.QuizChoiceAction;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class TutorQuizCheckboxChoicePanel extends javax.swing.JPanel {
    private TutorContentPanel myContentPanel;
    private QuizChoiceAction myPrompt;
    
    public TutorQuizCheckboxChoicePanel(TutorContentPanel contentPanel) {
        initComponents();
        myContentPanel=contentPanel;
    }
    public void saveAnswer() {
        if(OptionBox1.isSelected()) {
            myPrompt.setAnswer(myPrompt.getAnswer().concat(OptionBox1.getText() + ";"));
        }
        if(OptionBox2.isSelected()) {
            myPrompt.setAnswer(myPrompt.getAnswer().concat(OptionBox2.getText() + ";"));
        }
        if(OptionBox3.isSelected()) {
            myPrompt.setAnswer(myPrompt.getAnswer().concat(OptionBox3.getText() + ";"));
        }
        if(OptionBox4.isSelected()) {
            myPrompt.setAnswer(myPrompt.getAnswer().concat(OptionBox4.getText() + ";"));
        }
        if(OptionBox5.isSelected()) {
            myPrompt.setAnswer(myPrompt.getAnswer().concat(OptionBox5.getText() + ";"));
        }
//        if(OptionBox6.isSelected()) {
//            myPrompt.setAnswer(myPrompt.getAnswer().concat(OptionBox6.getText() + ";"));
//        }
    }
    public void setQuizChoiceAction(QuizChoiceAction prompt) {
        myPrompt=prompt;
        OptionBox1.setSelected(false);
        OptionBox2.setSelected(false);
        OptionBox3.setSelected(false);
        OptionBox4.setSelected(false);
        OptionBox5.setSelected(false);
//        OptionBox6.setSelected(false);
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
        setIntro("<html><p>" + prompt.getPrompt() + "</p></html>");
        if(prompt.getOptions().size()>0) {
            setOption1(prompt.getOptions().get(0));
            OptionBox1.setVisible(true);
            if(myPrompt.getAnswer().contains(OptionBox1.getText())) {
                OptionBox1.setSelected(true);
            }
        } else {
            OptionBox1.setVisible(false);
        }
        if(prompt.getOptions().size()>1) {
            setOption2(prompt.getOptions().get(1));
            OptionBox2.setVisible(true);
            if(myPrompt.getAnswer().contains(OptionBox2.getText())) {
                OptionBox2.setSelected(true);
            }
        } else {
            OptionBox2.setVisible(false);
        }
        if(prompt.getOptions().size()>2) {
            setOption3(prompt.getOptions().get(2));
            OptionBox3.setVisible(true);
            if(myPrompt.getAnswer().contains(OptionBox3.getText())) {
                OptionBox3.setSelected(true);
            }
        } else {
            OptionBox3.setVisible(false);
        }
        if(prompt.getOptions().size()>3) {
            setOption4(prompt.getOptions().get(3));
            OptionBox4.setVisible(true);
            if(myPrompt.getAnswer().contains(OptionBox4.getText())) {
                OptionBox4.setSelected(true);
            }
        } else {
            OptionBox4.setVisible(false);
        }if(prompt.getOptions().size()>4) {
            setOption5(prompt.getOptions().get(4));
            OptionBox5.setVisible(true);
            if(myPrompt.getAnswer().contains(OptionBox5.getText())) {
                OptionBox5.setSelected(true);
            }
        } else {
            OptionBox5.setVisible(false);
        }
//        if(prompt.getOptions().size()>5) {
//            setOption6(prompt.getOptions().get(5));
//            OptionBox6.setVisible(true);
//            if(myPrompt.getAnswer().contains(OptionBox6.getText())) {
//                OptionBox6.setSelected(true);
//            }
//        } else {
//            OptionBox6.setVisible(false);
//        }
    }
    public void setIntro(String intro) {
        QuestionHeadingLabel.setText(intro);
    }
    public void setOption1(String option) {
        OptionBox1.setText(option);
    }
    public void setOption2(String option) {
        OptionBox2.setText(option);
    }
    public void setOption3(String option) {
        OptionBox3.setText(option);
    }
    public void setOption4(String option) {
        OptionBox4.setText(option);
    }
    public void setOption5(String option) {
        OptionBox5.setText(option);
    }
//    public void setOption6(String option) {
//        OptionBox6.setText(option);
//    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        QuestionHeadingLabel = new javax.swing.JLabel();
        OptionBox1 = new javax.swing.JCheckBox();
        OptionBox2 = new javax.swing.JCheckBox();
        OptionBox3 = new javax.swing.JCheckBox();
        OptionBox4 = new javax.swing.JCheckBox();
        NextButton = new javax.swing.JButton();
        OptionBox5 = new javax.swing.JCheckBox();
        PreviousButton = new javax.swing.JButton();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(emt.EMTApp.class).getContext().getResourceMap(TutorQuizCheckboxChoicePanel.class);
        QuestionHeadingLabel.setFont(resourceMap.getFont("QuestionHeadingLabel.font")); // NOI18N
        QuestionHeadingLabel.setText(resourceMap.getString("QuestionHeadingLabel.text")); // NOI18N
        QuestionHeadingLabel.setName("QuestionHeadingLabel"); // NOI18N

        buttonGroup1.add(OptionBox1);
        OptionBox1.setText(resourceMap.getString("OptionBox1.text")); // NOI18N
        OptionBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        OptionBox1.setName("OptionBox1"); // NOI18N

        buttonGroup1.add(OptionBox2);
        OptionBox2.setText(resourceMap.getString("OptionBox2.text")); // NOI18N
        OptionBox2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        OptionBox2.setName("OptionBox2"); // NOI18N

        buttonGroup1.add(OptionBox3);
        OptionBox3.setText(resourceMap.getString("OptionBox3.text")); // NOI18N
        OptionBox3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        OptionBox3.setName("OptionBox3"); // NOI18N

        buttonGroup1.add(OptionBox4);
        OptionBox4.setText(resourceMap.getString("OptionBox4.text")); // NOI18N
        OptionBox4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        OptionBox4.setName("OptionBox4"); // NOI18N

        NextButton.setText(resourceMap.getString("NextButton.text")); // NOI18N
        NextButton.setName("NextButton"); // NOI18N
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(OptionBox5);
        OptionBox5.setText(resourceMap.getString("OptionBox5.text")); // NOI18N
        OptionBox5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        OptionBox5.setName("OptionBox5"); // NOI18N

        PreviousButton.setText(resourceMap.getString("PreviousButton.text")); // NOI18N
        PreviousButton.setName("PreviousButton"); // NOI18N
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OptionBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OptionBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OptionBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OptionBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OptionBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuestionHeadingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(QuestionHeadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PreviousButton)
                    .addComponent(NextButton)))
        );
    }// </editor-fold>//GEN-END:initComponents

private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
    if(buttonGroup1.getSelection()==null&&myPrompt.getAnswerRequired()) {
        JOptionPane.showMessageDialog(this, "Please select at least one answer.");
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
    private javax.swing.JButton NextButton;
    private javax.swing.JCheckBox OptionBox1;
    private javax.swing.JCheckBox OptionBox2;
    private javax.swing.JCheckBox OptionBox3;
    private javax.swing.JCheckBox OptionBox4;
    private javax.swing.JCheckBox OptionBox5;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JLabel QuestionHeadingLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}
