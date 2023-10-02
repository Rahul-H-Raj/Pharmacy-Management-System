package Java;


import Java.Home;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author RAHUL H RAJ
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTF = new javax.swing.JTextField();
        jPF = new javax.swing.JPasswordField();
        jCB = new javax.swing.JCheckBox();
        jB1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jB2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 16)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 90, 30));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 16)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 90, 30));

        jTF.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        getContentPane().add(jTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 237, -1));

        jPF.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        getContentPane().add(jPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, 237, -1));

        jCB.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        jCB.setText("Show Password");
        jCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBActionPerformed(evt);
            }
        });
        getContentPane().add(jCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, -1, -1));

        jB1.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login.png"))); // NOI18N
        jB1.setText("Login");
        jB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB1ActionPerformed(evt);
            }
        });
        getContentPane().add(jB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 520, -1, -1));

        jButton2.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close Jframe.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 520, -1, -1));

        jLabel3.setFont(new java.awt.Font("ROG Fonts", 0, 48)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login ani.gif"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 270, 100));

        jLabel5.setFont(new java.awt.Font("ROG Fonts", 1, 30)); // NOI18N
        jLabel5.setText("  PHARMACY MANAGEMENT SYSYEM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 710, 60));

        jB2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginPage.jpg"))); // NOI18N
        getContentPane().add(jB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //To show password or not using JCheckBox
    private void jCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBActionPerformed
        if(jCB.isSelected())
            jPF.setEchoChar((char)0);
        else
            jPF.setEchoChar('*');
    }//GEN-LAST:event_jCBActionPerformed
    
    //Close Button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a= JOptionPane.showConfirmDialog(null,"Do you want to close Application?","Confirm!",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    //Login Button with required validations
    private void jB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB1ActionPerformed
        if(jTF.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter the Username!","Warning!",JOptionPane.ERROR_MESSAGE);
        }
        else if(jPF.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter a Valid Password!","Warning!",JOptionPane.ERROR_MESSAGE);
        }
        else if(jTF.getText().equals("RVadmin") && jPF.getText().equals("069104")){
            setVisible(false);
            new Home().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Incorrect Username or Password!","INVALID!",JOptionPane.ERROR_MESSAGE);
            jTF.setText("");
            jPF.setText("");
        }
    }//GEN-LAST:event_jB1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB1;
    private javax.swing.JLabel jB2;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPF;
    private javax.swing.JTextField jTF;
    // End of variables declaration//GEN-END:variables
}
