
package Q2.DisplayFile;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Frame_3 extends javax.swing.JFrame {


    public Frame_3() {
        initComponents();
    }
    
    public String getUsername(){
        return txtUsername.getText();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaContent = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setRows(5);
        jScrollPane1.setViewportView(jTextAreaContent);

        jLabel1.setText("Username:");

        txtUsername.setText("Unknown");

        jMenu1.setText("File");

        jMenuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpen.setText("Open");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemOpen);

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        // TODO add your handling code here:
        Dialog_3 da = new Dialog_3(this, true);
        // hien thi dialog 3 nay len
        da.setVisible(true);
        
        // sau khi ma dialog 3 bi tat thi code chay tiep duoi day
        String filePath = da.getPathFile();
        boolean isShowSize = da.isShowSize();
        boolean isShowDate = da.isShowDate();
        
        // tao mot doi tuong file 
        File file = new File(filePath);
        if(!file.exists()){
            JOptionPane.showMessageDialog(this, "File Path is wrong");
        }else{
            String text = "";
            if(isShowSize){
                text += "Size of file: " + getSizeOfFile(file) + " bytes\n";
            }
            
            if(isShowDate){
                text += "Date: " + getDate() + "\n";
            }
            
            text += getContentOfFile(file);
            
            jTextAreaContent.setText(text);
            
        }
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        // TODO add your handling code here:
        int buttonType = JOptionPane.YES_NO_OPTION;
        int ret = JOptionPane.showConfirmDialog(this, "Do you want to close this app?", 
                "Title...", buttonType);
        
        if(ret == JOptionPane.YES_OPTION){
            // dong fram 3 lai
            dispose();
        }
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    public String getSizeOfFile(File file){
        String size = String.valueOf(file.length());
        return size;
    }
    
    public String getDate(){
        String currDate = null;
        
        // lay ngay thang hien tai
        Date date = Calendar.getInstance().getTime();
        // format du lieu ngay thang
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        currDate = sdf.format(date);
        return currDate;
    }
    
    public String getContentOfFile(File file){
        String content = "";
        
        try {
            FileInputStream fis = new FileInputStream(file);
            LineInputStream lis = new LineInputStream(fis);
            String line = null;
            
            // doc tung dong cho den dong cuoi dung
            while( (line = lis.readLine()) != null){
                content += line+"\n";
            }
            
            if(fis != null) fis.close();
            if(lis != null) lis.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frame_3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Frame_3.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return content;
        
    }
    

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
            java.util.logging.Logger.getLogger(Frame_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaContent;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
