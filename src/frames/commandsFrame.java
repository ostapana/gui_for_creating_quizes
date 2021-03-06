/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import guifortest.Informer;
import guifortest.JSONWorker;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author clear_atom
 */
public class commandsFrame extends javax.swing.JFrame {

    String selectedFile;
    JSONWorker jsWorker;
    DefaultListModel<String> modelStop = new DefaultListModel<>();
    DefaultListModel<String> modelUp = new DefaultListModel<>();
    DefaultListModel<String> modelDown = new DefaultListModel<>();
    Informer informer;
    /**
     * Creates new form commandsFrame
     * @param file
     * @param jsWorker
     * @throws java.lang.Exception
     */
    public commandsFrame(String file, JSONWorker jsWorker, Informer informer) throws Exception {
        initComponents();
        this.setLocationRelativeTo(null);
        this.informer = informer;
        this.jsWorker = jsWorker;
        this.selectedFile = file;
        this.listStopCmd.setModel(modelStop);
        this.listVolumeUp.setModel(modelUp);
        this.listVolumeDown.setModel(modelDown);
        jsWorker.fillList("commands", "stop", modelStop);
        jsWorker.fillList("commands", "volume_up", modelUp);
        jsWorker.fillList("commands", "volume_down", modelDown);
    }

    @Override
    protected void processWindowEvent(WindowEvent e){
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            if (informer == null)
                System.exit(0);
            boolean exit = informer.checkIfNoEmptyFields();
            if (exit)
                System.exit(0);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextVdown = new javax.swing.JTextField();
        jButtonOKstop = new javax.swing.JButton();
        jTextFieldStop = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonOkVD = new javax.swing.JButton();
        jTextFieldVUp = new javax.swing.JTextField();
        jButtonOkVUP = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listVolumeDown = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listStopCmd = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listVolumeUp = new javax.swing.JList<>();
        jButtonDelDwn = new javax.swing.JButton();
        jButtonDelStop = new javax.swing.JButton();
        jButtonDelUp = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 241, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Commands in application");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 11, 293, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Stop Commands");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 162, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Volume Up");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 162, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Volume Down");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 162, -1));
        jPanel1.add(jTextVdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 670, 30));

        jButtonOKstop.setBackground(new java.awt.Color(123, 239, 178));
        jButtonOKstop.setText("OK");
        jButtonOKstop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOKstop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOKstopMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonOKstop, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 70, 30));

        jTextFieldStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStopActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 670, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Add volume command");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 509, 130, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Add stop command");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 110, -1));

        jButtonOkVD.setBackground(new java.awt.Color(123, 239, 178));
        jButtonOkVD.setText("OK");
        jButtonOkVD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOkVD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOkVDMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonOkVD, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 530, 70, 30));
        jPanel1.add(jTextFieldVUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 670, 30));

        jButtonOkVUP.setBackground(new java.awt.Color(123, 239, 178));
        jButtonOkVUP.setText("OK");
        jButtonOkVUP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOkVUP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonOkVUPMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonOkVUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 70, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Add volume command");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 130, -1));

        jButtonBack.setBackground(new java.awt.Color(241, 130, 141));
        jButtonBack.setText("Back");
        jButtonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBackMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

        jScrollPane1.setViewportView(listVolumeDown);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 670, 110));

        jScrollPane2.setViewportView(listStopCmd);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 50, 670, 100));

        jScrollPane3.setViewportView(listVolumeUp);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 670, 110));

        jButtonDelDwn.setBackground(new java.awt.Color(241, 231, 254));
        jButtonDelDwn.setText("Delete");
        jButtonDelDwn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDelDwnMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonDelDwn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 460, -1, -1));

        jButtonDelStop.setBackground(new java.awt.Color(241, 231, 254));
        jButtonDelStop.setText("Delete");
        jButtonDelStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDelStopMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonDelStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, -1, -1));

        jButtonDelUp.setBackground(new java.awt.Color(241, 231, 254));
        jButtonDelUp.setText("Delete");
        jButtonDelUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDelUpMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonDelUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKstopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOKstopMouseClicked
        jsWorker.addText(modelStop, jTextFieldStop, "commands", "stop");
    }//GEN-LAST:event_jButtonOKstopMouseClicked

    private void jButtonOkVUPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOkVUPMouseClicked
        jsWorker.addText(modelUp, jTextFieldVUp, "commands", "volume_up");
    }//GEN-LAST:event_jButtonOkVUPMouseClicked

    private void jButtonOkVDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOkVDMouseClicked
        jsWorker.addText(modelDown, jTextVdown, "commands", "volume_down");
    }//GEN-LAST:event_jButtonOkVDMouseClicked

    private void jButtonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseClicked
        MainFrame mFrame = new MainFrame(selectedFile, informer);
        mFrame.setVisible(true);
        mFrame.pack();
        this.dispose();
    }//GEN-LAST:event_jButtonBackMouseClicked

    private void jButtonDelStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDelStopMouseClicked
        try {
            jsWorker.deleteFromList(modelStop, this.listStopCmd, "commands", "stop");
        } catch (Exception ex) {
            Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDelStopMouseClicked

    private void jButtonDelUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDelUpMouseClicked
        try {
            jsWorker.deleteFromList(modelUp, this.listVolumeUp, "commands", "volume_up");
        } catch (Exception ex) {
            Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDelUpMouseClicked

    private void jButtonDelDwnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDelDwnMouseClicked
        try {
            jsWorker.deleteFromList(modelDown, this.listVolumeDown, "commands", "volume_down");
        } catch (Exception ex) {
            Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDelDwnMouseClicked

    private void jTextFieldStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStopActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDelDwn;
    private javax.swing.JButton jButtonDelStop;
    private javax.swing.JButton jButtonDelUp;
    private javax.swing.JButton jButtonOKstop;
    private javax.swing.JButton jButtonOkVD;
    private javax.swing.JButton jButtonOkVUP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFieldStop;
    private javax.swing.JTextField jTextFieldVUp;
    private javax.swing.JTextField jTextVdown;
    private javax.swing.JList<String> listStopCmd;
    private javax.swing.JList<String> listVolumeDown;
    private javax.swing.JList<String> listVolumeUp;
    // End of variables declaration//GEN-END:variables
}
