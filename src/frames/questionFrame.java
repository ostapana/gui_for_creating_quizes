/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import guifortest.Informer;
import guifortest.JSONWorker;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author clear_atom
 */
public class questionFrame extends javax.swing.JFrame {

    /**
     * Creates new form questionFrame
     */
    
    String selectedFile;
    JSONWorker jsWorker;
    Informer informer;
    private final javax.swing.table.DefaultTableModel defaultTableModel;
    
    public questionFrame(String file, JSONWorker jsWorker, Informer informer) throws Exception {
        initComponents();
        this.selectedFile = file;
        this.jsWorker = jsWorker;
        this.defaultTableModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Question", "Answers", " Answer", "Media", "Group"
            }
        );
        jTable1.setModel(defaultTableModel);
        jsWorker.fillTable(this.defaultTableModel, "questions", new String [] {"body", "answers", "right_answer", "media", "group"});
        this.informer = informer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        textFieldQuestion = new java.awt.TextField();
        textFieldAnswers = new java.awt.TextField();
        jButtonBack = new javax.swing.JButton();
        textFieldMedia = new java.awt.TextField();
        textFieldGroup = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonConfirm = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textFieldRightAnswer = new java.awt.TextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 241, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 40, 840, 171));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Questions in application");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 0, 188, 34));

        textFieldQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldQuestionActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 238, 662, 28));

        textFieldAnswers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAnswersActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldAnswers, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 285, 430, 28));

        jButtonBack.setBackground(new java.awt.Color(241, 130, 141));
        jButtonBack.setText("Back");
        jButtonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBackMouseClicked(evt);
            }
        });
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 418, 77, -1));

        textFieldMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldMediaActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 380, 430, 28));

        textFieldGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldGroupActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 160, 28));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Question");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 249, 69, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Answers");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Right answer");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Media, fill only you have any media in your question");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 380, 344, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("1 argument is source: img for image, vid=video, mus=music");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 403, 382, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("2 argument is file name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 431, 246, -1));

        jButtonConfirm.setBackground(new java.awt.Color(123, 239, 178));
        jButtonConfirm.setText("Confirm");
        jButtonConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConfirmMouseClicked(evt);
            }
        });
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 90, -1));

        jButtonDelete.setBackground(new java.awt.Color(241, 231, 254));
        jButtonDelete.setText("Delete");
        jButtonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 90, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Group");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, -1, -1));

        textFieldRightAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRightAnswerActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldRightAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 332, 160, 28));

        jButton2.setBackground(new java.awt.Color(221, 109, 225));
        jButton2.setText("Help");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 80, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 894, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseClicked
        MainFrame mFrame = new MainFrame(selectedFile, informer);
        mFrame.setVisible(true);
        mFrame.pack();
        this.dispose();
    }//GEN-LAST:event_jButtonBackMouseClicked

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void textFieldQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldQuestionActionPerformed

    private void textFieldAnswersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAnswersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAnswersActionPerformed

    private void textFieldMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldMediaActionPerformed

    private void textFieldGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldGroupActionPerformed

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConfirmActionPerformed

    
    
    private void jButtonConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfirmMouseClicked
        if (textFieldQuestion.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Field question can't be empty");
            return;
        }
        if (textFieldAnswers.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Field answers can't be empty");
            return;
        }
        
        String media = textFieldMedia.getText();
        if (media.equals("")){
            textFieldMedia.setText("[]");
        }
        else if (!media.startsWith("img") && (! media.startsWith("vid"))&& (! media.startsWith("mus"))){
            JOptionPane.showMessageDialog(rootPane, "Wrong media type, media can be: img, vid, mus");
            return;
        }
        
        jsWorker.addObjectToTable(this.defaultTableModel, "questions", 
                new String [] {"body", "answers", "right_answer", "media", "group"}, 
                new java.awt.TextField [] {textFieldQuestion, textFieldAnswers, textFieldRightAnswer, textFieldMedia, textFieldGroup});
    }//GEN-LAST:event_jButtonConfirmMouseClicked

    private void jButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteMouseClicked
        try {
            jsWorker.deleteFromTable(defaultTableModel, jTable1, "questions", "");
        } catch (Exception ex) {
            Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDeleteMouseClicked

    private void textFieldRightAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRightAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRightAnswerActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String message = "If differen answers have different points\n "
        + "Write them as follows:\n"
        + "answer1: point1, answer2: point2, answer3: point3 \n"
        + "Otherwise: answer1, answer2, answer3";
        JOptionPane.showMessageDialog(rootPane, message);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.TextField textFieldAnswers;
    private java.awt.TextField textFieldGroup;
    private java.awt.TextField textFieldMedia;
    private java.awt.TextField textFieldQuestion;
    private java.awt.TextField textFieldRightAnswer;
    // End of variables declaration//GEN-END:variables
}
