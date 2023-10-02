package Java;


import Java.UpdateMedicine;
import Java.SellMedicine;
import Java.Login;
import Java.Home;
import Java.Customer;
import Java.AddMedicine;
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
public class ViewMedicine extends javax.swing.JFrame {

    /**
     * Creates new form ViewMedicine
     */
    
    Color blue, blue1, black, green, grey, orange, white;
    DefaultTableModel model1, model2, model3, model4;
    public String AMID, CMID;
    
    public ViewMedicine() {
        initComponents();
        AllMed_Table();
        ValidMed_Table();
        ExpMed_Table();
        blue1= new Color(0,102,204);
        green= new Color(0,102,51);
        grey= new Color(102,102,102);
        orange= new Color(255,51,0);
        white= new Color(255,255,255);
        blue= new Color(0,118,225);
        black= new Color(0,0,0);
        jB8.setBackground(blue);
        jB8.setForeground(white);
        jB9.setBackground(blue);
        jB9.setForeground(white);
        jB10.setBackground(blue);
        jB10.setForeground(white);
        jB11.setBackground(blue);
        jB11.setForeground(white);
        jB12.setBackground(white);
        jB12.setForeground(black);
        jB13.setBackground(blue);
        jB13.setForeground(white);
    }
    
    private void AllMed_Table() {
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from medicine");
            while(rs.next()){
                String mId= rs.getString(1);
                String mName= rs.getString(2);
                java.util.Date mfgDate= rs.getDate(4);
                java.util.Date expDate= rs.getDate(5);
                String compId= rs.getString(3);
                String price= rs.getString(6);
                String quantity= rs.getString(7);
                String status= rs.getString(9);
                Object[] obj={mId,mName,compId,mfgDate,expDate,price,quantity,status};
                model1= (DefaultTableModel)AllMeds.getModel();
                model1.addRow(obj);
            }        
        } catch(Exception e){
        }
    }
    
    private void ValidMed_Table() {
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from medicine where validity='valid'");
            while(rs.next()){
                String mId= rs.getString(1);
                String mName= rs.getString(2);
                java.util.Date mfgDate= rs.getDate(4);
                java.util.Date expDate= rs.getDate(5);
                String compId= rs.getString(3);
                String price= rs.getString(6);
                String quantity= rs.getString(7);
                Object[] obj={mId,mName,compId,mfgDate,expDate,price,quantity};
                model2= (DefaultTableModel)ValidMeds.getModel();
                model2.addRow(obj);
            }        
        } catch(Exception e){
        }
    }
    
    private void ExpMed_Table() {
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from medicine where validity='expired'");
            while(rs.next()){
                String mId= rs.getString(1);
                String mName= rs.getString(2);
                java.util.Date mfgDate= rs.getDate(4);
                java.util.Date expDate= rs.getDate(5);
                String compId= rs.getString(3);
                String price= rs.getString(6);
                String quantity= rs.getString(7);
                Object[] obj={mId,mName,compId,mfgDate,expDate,price,quantity};
                model3= (DefaultTableModel)ExpMeds.getModel();
                model3.addRow(obj);
            }        
        } catch(Exception e){
        }
    }
    
    public void clearTable(){
        DefaultTableModel model= (DefaultTableModel) CompMeds.getModel();
        model.setRowCount(0);
    }
    
    public void deleteRow(String id){
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            st.executeUpdate("delete from medicine where medId="+id);
            JOptionPane.showMessageDialog(null,"Deletion Successful!");
        } catch(Exception e){}
    }

    public void deleteMed(String id){
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            st.executeUpdate("delete from medicine where medId="+id);
        } catch(Exception e){}
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
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        jTP = new javax.swing.JTabbedPane();
        tp1 = new javax.swing.JPanel();
        jsp1 = new javax.swing.JScrollPane();
        AllMeds = new rojeru_san.complementos.RSTableMetro();
        db1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tp2 = new javax.swing.JPanel();
        jsp2 = new javax.swing.JScrollPane();
        ValidMeds = new rojeru_san.complementos.RSTableMetro();
        tp3 = new javax.swing.JPanel();
        jsp3 = new javax.swing.JScrollPane();
        ExpMeds = new rojeru_san.complementos.RSTableMetro();
        db3 = new javax.swing.JButton();
        tp4 = new javax.swing.JPanel();
        Sb = new javax.swing.JButton();
        jsp4 = new javax.swing.JScrollPane();
        CompMeds = new rojeru_san.complementos.RSTableMetro();
        stf = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        db2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cTf1 = new javax.swing.JTextField();
        cTf3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cTf2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLable2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jB8 = new javax.swing.JButton();
        jB9 = new javax.swing.JButton();
        jB10 = new javax.swing.JButton();
        jB11 = new javax.swing.JButton();
        jB12 = new javax.swing.JButton();
        jB13 = new javax.swing.JButton();
        jB14 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        b1.setForeground(new java.awt.Color(0, 102, 204));
        b1.setText("ALL");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel1.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 130, 40));

        b2.setBackground(new java.awt.Color(0, 102, 51));
        b2.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        b2.setForeground(new java.awt.Color(255, 255, 255));
        b2.setText("VALID");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel1.add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 130, 40));

        b3.setBackground(new java.awt.Color(102, 102, 102));
        b3.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setText("EXPIRED");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel1.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 130, 40));

        b4.setBackground(new java.awt.Color(255, 51, 0));
        b4.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setText("COMPANY");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        jPanel1.add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 130, 40));

        tp1.setBackground(new java.awt.Color(0, 102, 204));
        tp1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AllMeds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Med_ID", "Med_Name", "Comp_ID", "Mfg_Date", "Expr_Date", "Price", "Quantity", "Status"
            }
        ));
        AllMeds.setColorBackgoundHead(new java.awt.Color(0, 51, 153));
        AllMeds.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        AllMeds.setColorSelBackgound(new java.awt.Color(0, 51, 153));
        AllMeds.setRowHeight(25);
        AllMeds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AllMedsMouseClicked(evt);
            }
        });
        jsp1.setViewportView(AllMeds);

        tp1.add(jsp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 890, 320));

        db1.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        db1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        db1.setText("Delete");
        db1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db1ActionPerformed(evt);
            }
        });
        tp1.add(db1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 382, -1, 40));

        jButton3.setFont(new java.awt.Font("STXihei", 1, 16)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync_64px_1_24x24.png"))); // NOI18N
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        tp1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 384, 120, -1));

        jTP.addTab("tab1", tp1);

        tp2.setBackground(new java.awt.Color(0, 153, 102));
        tp2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ValidMeds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Med_ID", "Med_Name", "Comp_ID", "Mfg_Date", "Expr_Date", "Price", "Quantity"
            }
        ));
        ValidMeds.setColorBackgoundHead(new java.awt.Color(0, 102, 0));
        ValidMeds.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        ValidMeds.setColorSelBackgound(new java.awt.Color(0, 51, 153));
        ValidMeds.setRowHeight(25);
        jsp2.setViewportView(ValidMeds);

        tp2.add(jsp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 35, 820, 330));

        jTP.addTab("tab2", tp2);

        tp3.setBackground(new java.awt.Color(153, 153, 153));
        tp3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExpMeds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Med_ID", "Med_Name", "Comp_ID", "Mfg_Date", "Expr_Date", "Price", "Quantity"
            }
        ));
        ExpMeds.setColorBackgoundHead(new java.awt.Color(75, 75, 75));
        ExpMeds.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        ExpMeds.setColorSelBackgound(new java.awt.Color(0, 51, 153));
        ExpMeds.setRowHeight(25);
        jsp3.setViewportView(ExpMeds);

        tp3.add(jsp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 35, 820, 330));

        db3.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        db3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove_25px.png"))); // NOI18N
        db3.setText("Disposal");
        db3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db3ActionPerformed(evt);
            }
        });
        tp3.add(db3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 130, 40));

        jTP.addTab("tab3", tp3);

        tp4.setBackground(new java.awt.Color(255, 102, 0));
        tp4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sb.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        Sb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        Sb.setText("Search");
        Sb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SbActionPerformed(evt);
            }
        });
        tp4.add(Sb, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 120, 40));

        CompMeds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Med_ID", "Med_Name", "Comp_ID", "Mfg_Date", "Expr_Date", "Price", "Quantity", "Status"
            }
        ));
        CompMeds.setColorBackgoundHead(new java.awt.Color(255, 51, 0));
        CompMeds.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        CompMeds.setColorSelBackgound(new java.awt.Color(0, 51, 153));
        CompMeds.setRowHeight(25);
        CompMeds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CompMedsMouseClicked(evt);
            }
        });
        jsp4.setViewportView(CompMeds);

        tp4.add(jsp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 890, 220));

        stf.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 20)); // NOI18N
        stf.setForeground(new java.awt.Color(153, 153, 153));
        stf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stf.setText("ID or Name...");
        stf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stfFocusLost(evt);
            }
        });
        tp4.add(stf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 200, 40));

        jButton2.setFont(new java.awt.Font("STXihei", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reset.png"))); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        tp4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 110, 30));

        db2.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        db2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        db2.setText("Delete");
        db2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db2ActionPerformed(evt);
            }
        });
        tp4.add(db2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 392, 110, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID           :");
        tp4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 80, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Address :");
        tp4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 80, 30));

        cTf1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        tp4.add(cTf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 140, 30));

        cTf3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        tp4.add(cTf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 140, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name     :");
        tp4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 80, 30));

        cTf2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        tp4.add(cTf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 140, 30));

        jTP.addTab("tab4", tp4);

        jPanel1.add(jTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 930, 480));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 34)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vm_64x64.png"))); // NOI18N
        jLabel1.setText("  View Medicine");
        jLabel1.setAutoscrolls(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 350, 90));

        bg.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Meds.jpg"))); // NOI18N
        bg.setText("jLabel8");
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1096, 660));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.gif"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 110, 110));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close_.gif"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 30, 50, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1096, 768));

        jPanel5.setBackground(new java.awt.Color(0, 118, 225));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLable2.setBackground(new java.awt.Color(64, 64, 64));
        jLable2.setFont(new java.awt.Font("Calibri", 1, 26)); // NOI18N
        jLable2.setForeground(new java.awt.Color(242, 242, 242));
        jLable2.setText("  Administrator");
        jPanel5.add(jLable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 166, 44));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin3_1_100x100.png"))); // NOI18N
        jLabel6.setText("jLabel3");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 110, 120));

        jB8.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashbord.png"))); // NOI18N
        jB8.setText("Dashboard");
        jB8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB8ActionPerformed(evt);
            }
        });
        jPanel5.add(jB8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 250, 40));

        jB9.setBackground(new java.awt.Color(0, 118, 225));
        jB9.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB9.setForeground(new java.awt.Color(255, 255, 255));
        jB9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer_25px.png"))); // NOI18N
        jB9.setText(" Customer");
        jB9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB9ActionPerformed(evt);
            }
        });
        jPanel5.add(jB9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 250, 40));

        jB10.setBackground(new java.awt.Color(0, 118, 225));
        jB10.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB10.setForeground(new java.awt.Color(255, 255, 255));
        jB10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addMedic_48px_32x32.png"))); // NOI18N
        jB10.setText("Add Medicine");
        jB10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB10ActionPerformed(evt);
            }
        });
        jPanel5.add(jB10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 250, 40));

        jB11.setBackground(new java.awt.Color(0, 118, 225));
        jB11.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB11.setForeground(new java.awt.Color(255, 255, 255));
        jB11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modifyMedicine_32px.png"))); // NOI18N
        jB11.setText("Update Medicine");
        jB11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB11ActionPerformed(evt);
            }
        });
        jPanel5.add(jB11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 250, 40));

        jB12.setBackground(new java.awt.Color(0, 118, 225));
        jB12.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB12.setForeground(new java.awt.Color(255, 255, 255));
        jB12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view_64px_32x32.png"))); // NOI18N
        jB12.setText("View Medicines");
        jB12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB12ActionPerformed(evt);
            }
        });
        jPanel5.add(jB12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 250, 40));

        jB13.setBackground(new java.awt.Color(0, 118, 225));
        jB13.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB13.setForeground(new java.awt.Color(255, 255, 255));
        jB13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sellMedicine_64px_32x32.png"))); // NOI18N
        jB13.setText("Sell Medicine");
        jB13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB13ActionPerformed(evt);
            }
        });
        jPanel5.add(jB13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 250, 40));

        jB14.setBackground(new java.awt.Color(0, 118, 225));
        jB14.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jB14.setForeground(new java.awt.Color(255, 255, 255));
        jB14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout_32x32.png"))); // NOI18N
        jB14.setText("Logout");
        jB14.setBorder(null);
        jB14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB14ActionPerformed(evt);
            }
        });
        jPanel5.add(jB14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 210, 50));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        b1.setBackground(white);
        b1.setForeground(blue1);
        b2.setBackground(green);
        b2.setForeground(white);
        b3.setBackground(grey);
        b3.setForeground(white);
        b4.setBackground(orange);
        b4.setForeground(white);
        jTP.setSelectedIndex(0);
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        b1.setBackground(blue1);
        b1.setForeground(white);
        b2.setBackground(white);
        b2.setForeground(green);
        b3.setBackground(grey);
        b3.setForeground(white);
        b4.setBackground(orange);
        b4.setForeground(white);
        jTP.setSelectedIndex(1);
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        b1.setBackground(blue1);
        b1.setForeground(white);
        b2.setBackground(green);
        b2.setForeground(white);
        b3.setBackground(white);
        b3.setForeground(grey);
        b4.setBackground(orange);
        b4.setForeground(white);
        jTP.setSelectedIndex(2);
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
        b1.setBackground(blue1);
        b1.setForeground(white);
        b2.setBackground(green);
        b2.setForeground(white);
        b3.setBackground(grey);
        b3.setForeground(white);
        b4.setBackground(white);
        b4.setForeground(orange);
        jTP.setSelectedIndex(3);
    }//GEN-LAST:event_b4ActionPerformed

    private void SbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SbActionPerformed
        // TODO add your handling code here:
        clearTable();
        String iname= stf.getText();
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs1= st.executeQuery("select * from medicine where compId ="+iname);
            while(rs1.next()){
                String mId= rs1.getString(1);
                String mName= rs1.getString(2);
                java.util.Date mfgDate= rs1.getDate(4);
                java.util.Date expDate= rs1.getDate(5);
                String compId= rs1.getString(3);
                String price= rs1.getString(6);
                String quantity= rs1.getString(7);
                String status= rs1.getString(9);
                Object[] obj={mId,mName,compId,mfgDate,expDate,price,quantity,status};
                model4= (DefaultTableModel)CompMeds.getModel();
                model4.addRow(obj);
            }
            ResultSet rs12= st.executeQuery("select * from company where compId ="+iname);
            if(rs12.next()){
                cTf1.setText(rs12.getString(1));
                cTf2.setText(rs12.getString(2));
                cTf3.setText(rs12.getString(3));
            }
        }catch(Exception e){
            try{
                Connection con= JConnection.getCon();
                Statement st= con.createStatement();
                ResultSet rs2= st.executeQuery("select * from medicine where compId in (select compId from company where compName like '"+iname+"%')");
                while(rs2.next()){
                String mId= rs2.getString(1);
                String mName= rs2.getString(2);
                java.util.Date mfgDate= rs2.getDate(4);
                java.util.Date expDate= rs2.getDate(5);
                String compId= rs2.getString(3);
                String price= rs2.getString(7);
                String quantity= rs2.getString(6);
                String status= rs2.getString(9);
                Object[] obj={mId,mName,compId,mfgDate,expDate,quantity,price,status};
                model4= (DefaultTableModel)CompMeds.getModel();
                model4.addRow(obj);
            }
            ResultSet rs21= st.executeQuery("select * from company where compName like '"+iname+"%'");
            if(rs21.next()){
                cTf1.setText(rs21.getString(1));
                cTf2.setText(rs21.getString(2));
                cTf3.setText(rs21.getString(3));
            }
        }catch(Exception ex){}
        }
    }//GEN-LAST:event_SbActionPerformed

    private void stfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stfFocusGained
        // TODO add your handling code here:
        if(stf.getText().equals("ID or Name..."))
        {
            stf.setText("");
            stf.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_stfFocusGained

    private void stfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stfFocusLost
        // TODO add your handling code here:
        if(stf.getText().equals(""))
        {
            stf.setText("ID or Name...");
            stf.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_stfFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model= (DefaultTableModel) CompMeds.getModel();
        model.setRowCount(0);
        stf.setText("ID or Name...");
        stf.setForeground(new Color(153,153,153));
        cTf1.setText("");
        cTf2.setText("");
        cTf3.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void db2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db2ActionPerformed
        // TODO add your handling code here:
        int a= JOptionPane.showConfirmDialog(null,"Do you want to Delete the medicine of this Company?","Confirm!",JOptionPane.YES_NO_OPTION);
        if(a==0){
            deleteRow(CMID);
        }
    }//GEN-LAST:event_db2ActionPerformed

    private void db1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db1ActionPerformed
        // TODO add your handling code here:
        int a= JOptionPane.showConfirmDialog(null,"Do you want to Delete this medicine?","Confirm!",JOptionPane.YES_NO_OPTION);
        if(a==0){
            deleteRow(AMID);
        }
    }//GEN-LAST:event_db1ActionPerformed

    private void AllMedsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllMedsMouseClicked
        // TODO add your handling code here:
        int rowNo= AllMeds.getSelectedRow();
        TableModel model= AllMeds.getModel();
        AMID= model.getValueAt(rowNo, 0).toString();
    }//GEN-LAST:event_AllMedsMouseClicked

    private void CompMedsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CompMedsMouseClicked
        // TODO add your handling code here:
        int rowNo= CompMeds.getSelectedRow();
        TableModel model= CompMeds.getModel();
        CMID= model.getValueAt(rowNo, 0).toString();
    }//GEN-LAST:event_CompMedsMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new ViewMedicine().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void jB8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB8ActionPerformed
        // TODO add your handling code here
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB8ActionPerformed

    private void jB9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB9ActionPerformed
        // TODO add your handling code here:
        new Customer().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB9ActionPerformed

    private void jB10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB10ActionPerformed
        // TODO add your handling code here:
        new AddMedicine().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB10ActionPerformed

    private void jB11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB11ActionPerformed
        // TODO add your handling code here:
        new UpdateMedicine().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB11ActionPerformed

    private void jB12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB12ActionPerformed
        // TODO add your handling code here:
        new ViewMedicine().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB12ActionPerformed

    private void jB13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB13ActionPerformed
        // TODO add your handling code here:
        new SellMedicine().setVisible(true);
    }//GEN-LAST:event_jB13ActionPerformed

    private void jB14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB14ActionPerformed
        int a= JOptionPane.showConfirmDialog(null,"Do you really want to Logout?","Confirm!",JOptionPane.YES_NO_OPTION);
        if(a==0){
            setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_jB14ActionPerformed

    private void db3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db3ActionPerformed
        // TODO add your handling code here:
        if(ExpMeds.getRowCount() != 0){
            int a= JOptionPane.showConfirmDialog(null,"Do you want to remove these medicines?","Confirm!",JOptionPane.YES_NO_OPTION);
            if(a == 0){
                for(int i=0; i<ExpMeds.getRowCount(); i++){
                    String id= ExpMeds.getValueAt(i, 0).toString();
                    deleteMed(id);
                }
                JOptionPane.showMessageDialog(null,"Deletion Successful!");
                DefaultTableModel model= (DefaultTableModel) ExpMeds.getModel();
                model.setRowCount(0);
            }
        }
    }//GEN-LAST:event_db3ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSTableMetro AllMeds;
    private rojeru_san.complementos.RSTableMetro CompMeds;
    private rojeru_san.complementos.RSTableMetro ExpMeds;
    private javax.swing.JButton Sb;
    private rojeru_san.complementos.RSTableMetro ValidMeds;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JLabel bg;
    private javax.swing.JTextField cTf1;
    private javax.swing.JTextField cTf2;
    private javax.swing.JTextField cTf3;
    private javax.swing.JButton db1;
    private javax.swing.JButton db2;
    private javax.swing.JButton db3;
    private javax.swing.JButton jB10;
    private javax.swing.JButton jB11;
    private javax.swing.JButton jB12;
    private javax.swing.JButton jB13;
    private javax.swing.JButton jB14;
    private javax.swing.JButton jB8;
    private javax.swing.JButton jB9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLable2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTP;
    private javax.swing.JScrollPane jsp1;
    private javax.swing.JScrollPane jsp2;
    private javax.swing.JScrollPane jsp3;
    private javax.swing.JScrollPane jsp4;
    private javax.swing.JTextField stf;
    private javax.swing.JPanel tp1;
    private javax.swing.JPanel tp2;
    private javax.swing.JPanel tp3;
    private javax.swing.JPanel tp4;
    // End of variables declaration//GEN-END:variables
}
