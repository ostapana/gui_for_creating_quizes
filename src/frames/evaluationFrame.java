

package frames;

import guifortest.Informer;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author clear_atom
 */
public class evaluationFrame extends javax.swing.JFrame {

    String selectedFile;
    private final javax.swing.table.DefaultTableModel defaultTableModel;
    Informer informer;
    /** Creates new form evaluationFrame
     * @param file
     * @param informer */
    public evaluationFrame(String file, Informer informer) throws Exception {
        initComponents();
        this.selectedFile = file;
        this.defaultTableModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Points", "Evaluation"
            }
        );
        jTable1.setModel(defaultTableModel);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        fillEvalTable();
        this.informer = informer;
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        textFieldNumOfPoints = new java.awt.TextField();
        textFieldEvalPhrase = new java.awt.TextField();
        jButtonBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonConfirm = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(228, 241, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 40, 840, 260));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Evaluation");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 0, 188, 34));

        textFieldNumOfPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNumOfPointsActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldNumOfPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 120, 28));

        textFieldEvalPhrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEvalPhraseActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldEvalPhrase, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 650, 28));

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Number of points");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 210, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Single \"point\" can have several phrases");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 260, -1));

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Evaluation phrase");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 894, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNumOfPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNumOfPointsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNumOfPointsActionPerformed

    private void textFieldEvalPhraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEvalPhraseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldEvalPhraseActionPerformed

    private void jButtonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseClicked
        MainFrame mFrame = new MainFrame(selectedFile, informer);
        mFrame.setVisible(true);
        mFrame.pack();
        this.dispose();
    }//GEN-LAST:event_jButtonBackMouseClicked

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void fillEvalTable() throws Exception{
        Object[] row = new Object[2];
        
        Object obj = new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), Charset.forName("UTF8")))); 
        
        JSONObject jo = (JSONObject) obj; 

        JSONObject joPoints = (JSONObject) jo.get("points");
        
        for (Iterator it = joPoints.keySet().iterator(); it.hasNext();) {
            String key = it.next().toString();
            JSONArray evaluations = (JSONArray) joPoints.get(key);
            row[0] = key;
            
            for (Iterator it2 = evaluations.iterator(); it2.hasNext();) {
                row[1] = it2.next();
                this.defaultTableModel.addRow(row);
            }
        }
    }
    private void addNewEvaluation(){
        String[] row = new String[2];
        row [0] = this.textFieldNumOfPoints.getText();
        row [1] = this.textFieldEvalPhrase.getText();
            
        this.defaultTableModel.addRow(row);
                        
        Object obj = null;
        try {
            obj =
            new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), "UTF8")));
        }
        catch (ParseException | IOException ex) {
            Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (obj != null){
            JSONObject jo = (JSONObject) obj;
            JSONObject joPoints = (JSONObject) jo.get("points");
            JSONArray ja = (JSONArray) joPoints.get(row[0]);
            if (ja == null){
                ja = new JSONArray();
                joPoints.put(row[0], ja);
            }
            try {
                try (PrintWriter pw = new PrintWriter(selectedFile, "UTF8")) {
                    byte[] bytes = row[1].getBytes(StandardCharsets.UTF_8);
                    String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
                    ja.add(utf8EncodedString);
                    pw.write(jo.toJSONString());
                    pw.flush();
                    pw.close();
            } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "The file couldn't be opened");
        }
        this.textFieldEvalPhrase.setText("");
        this.textFieldNumOfPoints.setText("");
    }
    
    private void delete() throws Exception{
        int rowNum = this.jTable1.getSelectedRow();
        
        if (rowNum == -1){
            JOptionPane.showMessageDialog(this, "Choose element to delete");
            return;
        }
        
        String point = (String) defaultTableModel.getValueAt(rowNum, 0);
        String value = (String) jTable1.getValueAt(rowNum, 1);
        
        int answ = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + defaultTableModel.getColumnName(1) + " " + value);
        if (answ == 1 || answ == 2 || answ == -1)
            return;
        
        defaultTableModel.removeRow(rowNum);
        Object obj = new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), Charset.forName("UTF8")))); 
        
        if (obj != null){
            JSONObject jo = (JSONObject) obj;
            JSONObject joPoints = (JSONObject) jo.get("points");
            JSONArray ja = (JSONArray) joPoints.get(point);
            ja.remove(value);

            try {
                try (PrintWriter pw = new PrintWriter(selectedFile, "UTF8")) {
                    pw.write(jo.toJSONString());
                    pw.flush();
                    pw.close();
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(greetingFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private void jButtonConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConfirmMouseClicked
        if (this.textFieldNumOfPoints.getText().equals(""))
            JOptionPane.showMessageDialog(rootPane, "Field number of points can't be empty");
        if (textFieldEvalPhrase.getText().equals(""))
            JOptionPane.showMessageDialog(rootPane, "Field evaluation phrase can't be empty");

        addNewEvaluation();
    }//GEN-LAST:event_jButtonConfirmMouseClicked

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConfirmActionPerformed

    private void jButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteMouseClicked
        try {
            delete();
        } catch (Exception ex) {
            Logger.getLogger(evaluationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDeleteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.TextField textFieldEvalPhrase;
    private java.awt.TextField textFieldNumOfPoints;
    // End of variables declaration//GEN-END:variables

}
