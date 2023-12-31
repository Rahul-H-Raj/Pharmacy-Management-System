package Java;


import Project.JConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author RAHUL H RAJ
 */
public class AddCompany extends javax.swing.JFrame {

    /**
     * Creates new form AddCompany
     */
    
    public String CID;
    DefaultTableModel model;
    public AddCompany() {
        initComponents();
        setCompDetails2Table();
    }
    
    private void setCompDetails2Table(){
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from company");
            while(rs.next()){
                String cId= rs.getString("compId");
                String cName= rs.getString("compName");
                String cAddr= rs.getString("compAddr");
                Object[] obj={cId,cName,cAddr};
                model= (DefaultTableModel)Comp_Table.getModel();
                model.addRow(obj);
            }        
        } catch(Exception e){
        }
    }
    
    public void deleteComp(String id){
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            st.executeUpdate("delete from company where compId="+id);
            JOptionPane.showMessageDialog(null,"Deletion Successful!");
        } catch(Exception e){
            
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

        jPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jL1 = new javax.swing.JLabel();
        jcid = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Tf1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Tf2 = new javax.swing.JTextField();
        sb = new javax.swing.JButton();
        rb = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        cb = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Comp_Table = new rojeru_san.complementos.RSTableMetro();
        db = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel.setBackground(new java.awt.Color(255, 51, 0));
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new product.png"))); // NOI18N
        jLabel2.setText(" Add Company Details");
        jPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, 404, 74));

        jL1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jL1.setForeground(new java.awt.Color(255, 255, 255));
        jL1.setText("Company ID :");
        jPanel.add(jL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 129, 37));

        jcid.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        jcid.setForeground(new java.awt.Color(255, 255, 0));
        jcid.setText("10");
        jPanel.add(jcid, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 140, 100, 37));

        jLabel7.setBackground(new java.awt.Color(102, 204, 255));
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Company Name");
        jPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 140, -1));

        Tf1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        Tf1.setForeground(new java.awt.Color(153, 153, 153));
        Tf1.setText("Enter Company Name...");
        Tf1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Tf1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Tf1FocusLost(evt);
            }
        });
        jPanel.add(Tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 320, 40));

        jLabel8.setBackground(new java.awt.Color(102, 204, 255));
        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Company Address");
        jPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 150, -1));

        Tf2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        Tf2.setForeground(new java.awt.Color(153, 153, 153));
        Tf2.setText("Enter the Address...");
        Tf2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Tf2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Tf2FocusLost(evt);
            }
        });
        jPanel.add(Tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 320, 40));

        sb.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        sb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        sb.setText("Save & Add");
        sb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbActionPerformed(evt);
            }
        });
        jPanel.add(sb, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        rb.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        rb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reset.png"))); // NOI18N
        rb.setText("Reset");
        rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActionPerformed(evt);
            }
        });
        jPanel.add(rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, -1, -1));
        jPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 410, 20));

        getContentPane().add(jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 430, 560));

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));

        cb.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        cb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close Jframe.png"))); // NOI18N
        cb.setText("Close");
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });

        Comp_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CompanyID", "CompanyName", "CompanyAddr"
            }
        ));
        Comp_Table.setColorBackgoundHead(new java.awt.Color(255, 102, 0));
        Comp_Table.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        Comp_Table.setColorSelBackgound(new java.awt.Color(255, 51, 0));
        Comp_Table.setFont(new java.awt.Font("Yu Gothic Light", 0, 25)); // NOI18N
        Comp_Table.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Comp_Table.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        Comp_Table.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        Comp_Table.setRowHeight(30);
        Comp_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Comp_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Comp_Table);

        db.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        db.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        db.setText("Delete");
        db.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(db)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cb)
                .addGap(73, 73, 73))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb)
                    .addComponent(db))
                .addGap(51, 51, 51))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 550, 560));

        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddMed_Page.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbActionPerformed
        // TODO add your handling code here:
        String cId= jcid.getText();
        String cName= Tf1.getText();
        String cAddr= Tf2.getText();
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            st.executeUpdate("insert into company values("+cId+",'"+cName+"','"+cAddr+"')");
            JOptionPane.showMessageDialog(null,"Successfully Updated!");
            new AddCompany().setVisible(true);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_sbActionPerformed

    private void rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new AddCompany().setVisible(true);
    }//GEN-LAST:event_rbActionPerformed

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_cbActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select max(compId) from company");
            if(rs.next()){
                int id= rs.getInt(1);
                id = id + 1;
                String str= String.valueOf(id);
                jcid.setText(str);
            } else{
                jcid.setText("10");
            }
        } catch(Exception e){
        }
    }//GEN-LAST:event_formComponentShown

    private void Tf1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tf1FocusGained
        // TODO add your handling code here:
        if(Tf1.getText().equals("Enter Company Name..."))
        {
            Tf1.setText("");
            Tf1.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_Tf1FocusGained

    private void Tf1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tf1FocusLost
        // TODO add your handling code here:
        if(Tf1.getText().equals(""))
        {
            Tf1.setText("Enter Company Name...");
            Tf1.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_Tf1FocusLost

    private void Tf2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tf2FocusGained
        // TODO add your handling code here:
        if(Tf2.getText().equals("Enter the Address..."))
        {
            Tf2.setText("");
            Tf2.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_Tf2FocusGained

    private void Tf2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tf2FocusLost
        // TODO add your handling code here:
        if(Tf2.getText().equals(""))
        {
            Tf2.setText("Enter the Address...");
            Tf2.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_Tf2FocusLost

    private void dbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbActionPerformed
        // TODO add your handling code here:
        int a= JOptionPane.showConfirmDialog(null,"Do you want to Delete this Company data?","Confirm!",JOptionPane.YES_NO_OPTION);
        if(a==0){
            deleteComp(CID);
        }
    }//GEN-LAST:event_dbActionPerformed

    private void Comp_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Comp_TableMouseClicked
        // TODO add your handling code here:
        int rowNo= Comp_Table.getSelectedRow();
        TableModel model= Comp_Table.getModel();
        CID= model.getValueAt(rowNo, 0).toString();
    }//GEN-LAST:event_Comp_TableMouseClicked

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
            java.util.logging.Logger.getLogger(AddCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCompany.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCompany().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSTableMetro Comp_Table;
    private javax.swing.JTextField Tf1;
    private javax.swing.JTextField Tf2;
    private javax.swing.JButton cb;
    private javax.swing.JButton db;
    private javax.swing.JLabel jL1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jcid;
    private javax.swing.JButton rb;
    private javax.swing.JButton sb;
    // End of variables declaration//GEN-END:variables
}
