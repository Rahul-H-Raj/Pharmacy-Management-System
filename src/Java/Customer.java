package Java;


import Java.AddMedicine;
import java.awt.Color;
import Project.JConnection;
import java.sql.*;
import javax.swing.*;
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
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    
    Color blue,white,black;
    DefaultTableModel model;
    public Customer() {
        initComponents();
        cust_Table();
        blue= new Color(0,118,225);
        white= new Color(255,255,255);
        black= new Color(0,0,0);
        jB1.setBackground(blue);
        jB1.setForeground(white);
        jB2.setBackground(white);
        jB2.setForeground(black);
        jB3.setBackground(blue);
        jB3.setForeground(white);
        jB4.setBackground(blue);
        jB4.setForeground(white);
        jB5.setBackground(blue);
        jB5.setForeground(white);
        jB6.setBackground(blue);
        jB6.setForeground(white);
        Stf.setEditable(true);
        Tf21.setEditable(false);
        Tf22.setEditable(false);
        Tf23.setEditable(false);
        Load.setVisible(false);
        Refr.setVisible(false);
    }
    
    private void cust_Table() {
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from customer");
            while(rs.next()){
                String CId= rs.getString("cId");
                String Name= rs.getString("name");
                String ContactNo= rs.getString("contactNo");
                String Gender= rs.getString("gender");
                Object[] obj={CId,Name,ContactNo,Gender};
                model= (DefaultTableModel)Cust_Table.getModel();
                model.addRow(obj);
            }        
        } catch(Exception e){
        }
    }
    
    public void deleteCust(){
        String id= Stf.getText();
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            st.executeUpdate("delete from customer where cId="+id);
            JOptionPane.showMessageDialog(null,"Deletion Successful!");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Deletion Failed!");
        }
    }
    
    public void clearTable(){
        DefaultTableModel model= (DefaultTableModel) Cust_Table.getModel();
        model.setRowCount(0);
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
        jLabel1 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jTP = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Tf11 = new javax.swing.JTextField();
        Tf12 = new javax.swing.JTextField();
        Cb13 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        svb = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        idl = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Tf21 = new javax.swing.JTextField();
        Tf22 = new javax.swing.JTextField();
        Tf23 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        update = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Stf = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Cust_Table = new rojeru_san.complementos.RSTableMetro();
        Refr = new javax.swing.JButton();
        Load = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLable1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jB1 = new javax.swing.JButton();
        jB2 = new javax.swing.JButton();
        jB3 = new javax.swing.JButton();
        jB4 = new javax.swing.JButton();
        jB5 = new javax.swing.JButton();
        jB6 = new javax.swing.JButton();
        jB7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update buyer.png"))); // NOI18N
        jLabel1.setText(" Customer");
        jPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 270, 80));

        edit.setBackground(new java.awt.Color(255, 51, 51));
        edit.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 90, 40));

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        add.setForeground(new java.awt.Color(0, 51, 204));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, 40));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(102, 204, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID   :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 56, -1));

        jLabel4.setBackground(new java.awt.Color(102, 204, 255));
        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contact No.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 114, -1));

        jLabel5.setBackground(new java.awt.Color(102, 204, 255));
        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gender");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 80, -1));

        Tf11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        Tf11.setForeground(new java.awt.Color(153, 153, 153));
        Tf11.setText("Enter Name...");
        Tf11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Tf11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Tf11FocusLost(evt);
            }
        });
        jPanel1.add(Tf11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 300, 40));

        Tf12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        Tf12.setForeground(new java.awt.Color(153, 153, 153));
        Tf12.setText("Enter Contact No.");
        Tf12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Tf12FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Tf12FocusLost(evt);
            }
        });
        jPanel1.add(Tf12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 300, 40));

        Cb13.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        Cb13.setForeground(new java.awt.Color(153, 153, 153));
        Cb13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));
        jPanel1.add(Cb13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 300, 40));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 388, 12));

        svb.setFont(new java.awt.Font("STXihei", 1, 16)); // NOI18N
        svb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        svb.setText(" Save & Add");
        svb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbActionPerformed(evt);
            }
        });
        jPanel1.add(svb, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 485, 170, 40));

        jLabel7.setBackground(new java.awt.Color(102, 204, 255));
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 56, -1));

        idl.setBackground(new java.awt.Color(255, 255, 255));
        idl.setFont(new java.awt.Font("Source Sans Pro", 1, 30)); // NOI18N
        idl.setForeground(new java.awt.Color(255, 204, 204));
        idl.setText("101");
        jPanel1.add(idl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 90, 50));

        jButton2.setFont(new java.awt.Font("STXihei", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reset.png"))); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 485, 100, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 560));

        jTP.addTab("tab1", jPanel2);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(102, 204, 255));
        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 23)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID   :");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 56, 40));

        jLabel11.setBackground(new java.awt.Color(102, 204, 255));
        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Contact No.");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 130, 30));

        jLabel12.setBackground(new java.awt.Color(102, 204, 255));
        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gender");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 110, 40));

        Tf21.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jPanel7.add(Tf21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 300, 40));

        Tf22.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jPanel7.add(Tf22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 300, 40));

        Tf23.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jPanel7.add(Tf23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 300, 40));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel7.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 388, 13));

        update.setFont(new java.awt.Font("STXihei", 1, 15)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel7.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 482, 120, 40));

        jLabel13.setBackground(new java.awt.Color(102, 204, 255));
        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Name");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 90, 30));

        Stf.setFont(new java.awt.Font("Noto Serif Light", 1, 19)); // NOI18N
        Stf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StfActionPerformed(evt);
            }
        });
        jPanel7.add(Stf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 120, -1));

        search.setFont(new java.awt.Font("Source Serif Pro Light", 1, 15)); // NOI18N
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel7.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 100, 40));

        delete.setFont(new java.awt.Font("STXihei", 1, 15)); // NOI18N
        delete.setForeground(new java.awt.Color(204, 0, 0));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel7.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 482, 110, 40));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 560));

        jTP.addTab("tab2", jPanel6);

        jPanel.add(jTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cust_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C_ID", "Name", "ContactNo", "Gender"
            }
        ));
        Cust_Table.setColorBackgoundHead(new java.awt.Color(255, 102, 102));
        Cust_Table.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        Cust_Table.setColorFilasForeground1(new java.awt.Color(102, 102, 102));
        Cust_Table.setColorFilasForeground2(new java.awt.Color(102, 102, 102));
        Cust_Table.setRowHeight(25);
        Cust_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cust_TableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Cust_Table);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 620, 350));

        jPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 660, 560));

        Refr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync_64px_1_48x48.png"))); // NOI18N
        Refr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefrActionPerformed(evt);
            }
        });
        jPanel.add(Refr, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 50, 50));

        Load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.gif"))); // NOI18N
        jPanel.add(Load, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 90, 110));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close_.gif"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 30, 50, 60));

        getContentPane().add(jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1096, 768));

        jPanel5.setBackground(new java.awt.Color(0, 118, 225));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLable1.setBackground(new java.awt.Color(64, 64, 64));
        jLable1.setFont(new java.awt.Font("Calibri", 1, 26)); // NOI18N
        jLable1.setForeground(new java.awt.Color(242, 242, 242));
        jLable1.setText("  Administrator");
        jPanel5.add(jLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 166, 44));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin3_1_100x100.png"))); // NOI18N
        jLabel6.setText("jLabel3");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 110, 120));

        jB1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashbord.png"))); // NOI18N
        jB1.setText("Dashboard");
        jB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB1ActionPerformed(evt);
            }
        });
        jPanel5.add(jB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 250, 40));

        jB2.setBackground(new java.awt.Color(0, 118, 225));
        jB2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB2.setForeground(new java.awt.Color(255, 255, 255));
        jB2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer_25px.png"))); // NOI18N
        jB2.setText(" Customer");
        jB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2ActionPerformed(evt);
            }
        });
        jPanel5.add(jB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 250, 40));

        jB3.setBackground(new java.awt.Color(0, 118, 225));
        jB3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB3.setForeground(new java.awt.Color(255, 255, 255));
        jB3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addMedic_48px_32x32.png"))); // NOI18N
        jB3.setText("Add Medicine");
        jB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3ActionPerformed(evt);
            }
        });
        jPanel5.add(jB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 250, 40));

        jB4.setBackground(new java.awt.Color(0, 118, 225));
        jB4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB4.setForeground(new java.awt.Color(255, 255, 255));
        jB4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modifyMedicine_32px.png"))); // NOI18N
        jB4.setText("Update Medicine");
        jB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4ActionPerformed(evt);
            }
        });
        jPanel5.add(jB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 250, 40));

        jB5.setBackground(new java.awt.Color(0, 118, 225));
        jB5.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB5.setForeground(new java.awt.Color(255, 255, 255));
        jB5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_64px_32x32.png"))); // NOI18N
        jB5.setText("View Medicines");
        jB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB5ActionPerformed(evt);
            }
        });
        jPanel5.add(jB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 250, 40));

        jB6.setBackground(new java.awt.Color(0, 118, 225));
        jB6.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB6.setForeground(new java.awt.Color(255, 255, 255));
        jB6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sellMedicine_64px_32x32.png"))); // NOI18N
        jB6.setText("Sell Medicine");
        jB6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB6ActionPerformed(evt);
            }
        });
        jPanel5.add(jB6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 250, 40));

        jB7.setBackground(new java.awt.Color(0, 118, 225));
        jB7.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jB7.setForeground(new java.awt.Color(255, 255, 255));
        jB7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout_32x32.png"))); // NOI18N
        jB7.setText("Logout");
        jB7.setBorder(null);
        jB7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB7ActionPerformed(evt);
            }
        });
        jPanel5.add(jB7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 210, 50));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select max(cId) from customer");
            if(rs.next()){
                int id= rs.getInt(1);
                id = id + 1;
                String str= String.valueOf(id);
                idl.setText(str);
            } else{
                idl.setText("101");
            }
        } catch(Exception e){
        }
    }//GEN-LAST:event_formComponentShown

    private void Tf11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tf11FocusGained
        // TODO add your handling code here:
        if(Tf11.getText().equals("Enter Name..."))
        {
            Tf11.setText("");
            Tf11.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_Tf11FocusGained

    private void Tf11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tf11FocusLost
        // TODO add your handling code here:
        if(Tf11.getText().equals(""))
        {
            Tf11.setText("Enter Name...");
            Tf11.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_Tf11FocusLost

    private void Tf12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tf12FocusGained
        // TODO add your handling code here:
        if(Tf12.getText().equals("Enter Contact No."))
        {
            Tf12.setText("");
            Tf12.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_Tf12FocusGained

    private void Tf12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tf12FocusLost
        // TODO add your handling code here:
        if(Tf12.getText().equals(""))
        {
            Tf12.setText("Enter Contact No.");
            Tf12.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_Tf12FocusLost

    private void svbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbActionPerformed
        // TODO add your handling code here:
        String cId= idl.getText();
        String name= Tf11.getText();
        String contactNo= Tf12.getText();
        try{
        if(!((name != null) && (!name.equals("") && (name.matches("^[a-zA-Z]*$"))))){
            JOptionPane.showMessageDialog(null,"Name can contain only Alphabets!");
        } else{
        if(contactNo.length() != 10){
            JOptionPane.showMessageDialog(null,"Please Enter a valid Contact_No.! (10-digit)","INVALID!",JOptionPane.ERROR_MESSAGE);
        } else{
        double phno= Double.parseDouble(contactNo);
        String gender= (String)Cb13.getSelectedItem();
        int bal= 0;
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            st.executeUpdate("insert into customer values("+cId+",'"+name+"',"+phno+",'"+gender+"',"+bal+")");
            JOptionPane.showMessageDialog(null,"Successfully Added!");
            new Customer().setVisible(true);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed!");
        }}}} catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,nfe);
        }
    }//GEN-LAST:event_svbActionPerformed

    private void Cust_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cust_TableMouseClicked
        // TODO add your handling code here:
        int rowNo= Cust_Table.getSelectedRow();
        TableModel model= Cust_Table.getModel();
        
        Stf.setText(model.getValueAt(rowNo, 0).toString());
        Tf21.setText(model.getValueAt(rowNo, 1).toString());
        Tf22.setText(model.getValueAt(rowNo, 2).toString());
        Tf23.setText(model.getValueAt(rowNo, 3).toString());
        Tf21.setEditable(true);
        Tf22.setEditable(true);
        Stf.setEditable(false);
    }//GEN-LAST:event_Cust_TableMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        String cid= Stf.getText();
        String name= Tf21.getText();
        String contactNo= Tf22.getText();
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            st.executeUpdate("update customer set name='"+name+"', contactNo='"+contactNo+"' where cId="+cid);
            JOptionPane.showMessageDialog(null,"Successfully Updated!");
            clearTable();
            cust_Table();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Updation Failed!");
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int a= JOptionPane.showConfirmDialog(null,"Do you want to Delete this Customer details?","Confirm!",JOptionPane.YES_NO_OPTION);
        if(a==0){
            deleteCust();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void StfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StfActionPerformed
        // TODO add your handling code here:
        String id= Stf.getText();
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from customer where cId="+id);
            if(rs.next()){
                Tf21.setText(rs.getString(2));
                Tf22.setText(rs.getString(3));
                Tf23.setText(rs.getString(4));
                Tf21.setEditable(true);
                Tf22.setEditable(true);
                Stf.setEditable(false);
            } else{
                JOptionPane.showMessageDialog(null,"Entered Customer_ID doesn't Exist!");
            }
        } catch(Exception e){
        }
    }//GEN-LAST:event_StfActionPerformed

    private void RefrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefrActionPerformed
        // TODO add your handling code here:
        Stf.setText("");
        Tf21.setText("");
        Tf22.setText("");
        Tf23.setText("");
        clearTable();
        cust_Table();
        Stf.setEditable(true);
        Tf21.setEditable(false);
        Tf22.setEditable(false);
    }//GEN-LAST:event_RefrActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        add.setBackground(new Color(255,255,255));
        add.setForeground(new Color(0,51,204));
        edit.setBackground(new Color(255,51,51));
        edit.setForeground(new Color(255,255,255));
        jTP.setSelectedIndex(0);
        Load.setVisible(false);
        Refr.setVisible(false);
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        add.setBackground(new Color(0,51,204));
        add.setForeground(new Color(255,255,255));
        edit.setBackground(new Color(255,255,255));
        edit.setForeground(new Color(255,51,51));
        jTP.setSelectedIndex(1);
        Load.setVisible(true);
        Refr.setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String[] options= {"Dashboard","Exit Application"};
        int a= JOptionPane.showOptionDialog(null,"Your Choice","Select",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
        if(a == 0){
            new Home().setVisible(true);
            dispose();
        } else if(a == 1){
            int b= JOptionPane.showConfirmDialog(null,"Do you really want to exit the Application?","Confirm!",JOptionPane.YES_NO_OPTION);
            if(b == 0){
                System.exit(0);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB1ActionPerformed
        // TODO add your handling code here
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB1ActionPerformed

    private void jB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2ActionPerformed
        // TODO add your handling code here:
        new Customer().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB2ActionPerformed

    private void jB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3ActionPerformed
        // TODO add your handling code here:
        new AddMedicine().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB3ActionPerformed

    private void jB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4ActionPerformed
        // TODO add your handling code here:
        new UpdateMedicine().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB4ActionPerformed

    private void jB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB5ActionPerformed
        // TODO add your handling code here:
        new ViewMedicine().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB5ActionPerformed

    private void jB6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB6ActionPerformed
        // TODO add your handling code here:
        new SellMedicine().setVisible(true);
    }//GEN-LAST:event_jB6ActionPerformed

    private void jB7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB7ActionPerformed
        int a= JOptionPane.showConfirmDialog(null,"Do you really want to Logout?","Confirm!",JOptionPane.YES_NO_OPTION);
        if(a==0){
            setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_jB7ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        String id= Stf.getText();
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from customer where cId="+id);
            if(rs.next()){
                Tf21.setText(rs.getString(2));
                Tf22.setText(rs.getString(3));
                Tf23.setText(rs.getString(4));
                Tf21.setEditable(true);
                Tf22.setEditable(true);
                Stf.setEditable(false);
            } else{
                JOptionPane.showMessageDialog(null,"Entered Customer_ID doesn't Exist!");
            }
        } catch(Exception e){
        }
    }//GEN-LAST:event_searchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Tf11.setText("");
        Tf12.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cb13;
    private rojeru_san.complementos.RSTableMetro Cust_Table;
    private javax.swing.JLabel Load;
    private javax.swing.JButton Refr;
    private javax.swing.JTextField Stf;
    private javax.swing.JTextField Tf11;
    private javax.swing.JTextField Tf12;
    private javax.swing.JTextField Tf21;
    private javax.swing.JTextField Tf22;
    private javax.swing.JTextField Tf23;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel idl;
    private javax.swing.JButton jB1;
    private javax.swing.JButton jB2;
    private javax.swing.JButton jB3;
    private javax.swing.JButton jB4;
    private javax.swing.JButton jB5;
    private javax.swing.JButton jB6;
    private javax.swing.JButton jB7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLable1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTP;
    private javax.swing.JButton search;
    private javax.swing.JButton svb;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
