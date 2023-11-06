
package Q2.DisplayFile;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Dialog_3 extends javax.swing.JDialog {

 
    Frame_3 frameParent;
    public Dialog_3(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        frameParent = (Frame_3) parent;
        String username = frameParent.getUsername();
        txtDUsername.setText("Hello " + username);
    }
    
    public String getPathFile(){
        return txtFilePath.getText();
    }
    
    public boolean isShowSize(){
        return ckShowSize.isSelected();
    }
    public boolean isShowDate(){
        return ckShowDate.isSelected();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFilePath = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        ckShowSize = new javax.swing.JCheckBox();
        ckShowDate = new javax.swing.JCheckBox();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtDUsername.setBackground(new java.awt.Color(51, 255, 204));
        txtDUsername.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        txtDUsername.setForeground(new java.awt.Color(204, 0, 51));
        txtDUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDUsername.setText("Hello Unknown");

        jLabel1.setText("Path file:");

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        ckShowSize.setText("show size");

        ckShowDate.setText("show date");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(txtDUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOK)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ckShowSize)
                                        .addGap(134, 134, 134)
                                        .addComponent(ckShowDate)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBrowse)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(txtDUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckShowSize)
                    .addComponent(ckShowDate))
                .addGap(18, 18, 18)
                .addComponent(btnOK)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        if(txtFilePath.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill path of file");
        }else{
            dispose();
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // tao doi tuong JFileChooser: la mot cua so con cho phep minh chon file trong may tinh
        JFileChooser jc = new JFileChooser();
        
        // show cua so nay len
        int ret = jc.showOpenDialog(this);
        
        if(ret == JFileChooser.APPROVE_OPTION){
            File file = jc.getSelectedFile();
            
            String pathFile = file.getPath();
            txtFilePath.setText(pathFile);
        }
    }//GEN-LAST:event_btnBrowseActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dialog_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialog_3 dialog = new Dialog_3(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnOK;
    private javax.swing.JCheckBox ckShowDate;
    private javax.swing.JCheckBox ckShowSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtDUsername;
    private javax.swing.JTextField txtFilePath;
    // End of variables declaration//GEN-END:variables
}
