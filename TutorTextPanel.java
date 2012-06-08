/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TutorTextPanel.java
 *
 * Created on May 28, 2012, 1:54:03 PM
 */
package emt.tutor;

/**
 *
 * @author David
 */
public class TutorTextPanel extends javax.swing.JPanel {
    private TutorContentPanel myContentPanel;
    
    /** Creates new form TutorTextPanel */
    public TutorTextPanel(TutorContentPanel contentPanel) {
        initComponents();
        myContentPanel=contentPanel;
    }
    
    public void giveTextFeedback(String feedback) {
        this.tutorTextLabel.setText("<html><p>" + feedback + "</p></html>");
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

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(emt.EMTApp.class).getContext().getResourceMap(TutorTextPanel.class);
        tutorTextLabel.setFont(resourceMap.getFont("tutorTextLabel.font")); // NOI18N
        tutorTextLabel.setText(resourceMap.getString("tutorTextLabel.text")); // NOI18N
        tutorTextLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        tutorTextLabel.setName("tutorTextLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tutorTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tutorTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel tutorTextLabel;
    // End of variables declaration//GEN-END:variables
}
