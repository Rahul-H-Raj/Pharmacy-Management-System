package Java;


import Java.Customer;
import Java.AddMedicine;
import Project.JConnection;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author RAHUL H RAJ
 */
public class Home extends javax.swing.JFrame {
    public int vm=0, em=0, c=0, o=0, m=0;
    String[] months={null,"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
    String day, month, year;

    /**
     * Creates new form Home
     */
    Color blue, white, black; 
    public Home() {
        initComponents();
        blue= new Color(0,118,225);
        white= new Color(255,255,255);
        black= new Color(0,0,0);
        jB1.setBackground(white);
        jB1.setForeground(black);
        jB2.setBackground(blue);
        jB2.setForeground(white);
        jB3.setBackground(blue);
        jB3.setForeground(white);
        jB4.setBackground(blue);
        jB4.setForeground(white);
        jB5.setBackground(blue);
        jB5.setForeground(white);
        jB6.setBackground(blue);
        jB6.setForeground(white);
        
        Date date= new Date();
        SimpleDateFormat df1= new SimpleDateFormat("dd");
        day= df1.format(date);
        SimpleDateFormat df2= new SimpleDateFormat("MM");
        month= months[Integer.parseInt(df2.format(date))];
        SimpleDateFormat df3= new SimpleDateFormat("yyyy");
        year= df3.format(date);
        jBDate.setText(month+" "+day+", "+year);
    }
    
    //To create a pie-chart for valid and expired medicines
    private void showPieChart(){
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs1= st.executeQuery("select count(medId) from medicine where validity='valid'");
            if(rs1.next()){
                vm= rs1.getInt(1);
            }
            ResultSet rs2= st.executeQuery("select count(medId) from medicine where validity='expired'");
            if(rs2.next()){
                em= rs2.getInt(1);
            }
        } catch(Exception e){
        }
        DefaultPieDataset barDataset = new DefaultPieDataset( );  
        barDataset.setValue("Valid Meds" , Double.valueOf(vm));   
        barDataset.setValue("Expired Meds" , Double.valueOf(em));
      
        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Medicine Stock",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
        //changing pie chart blocks colors
        piePlot.setSectionPaint("Valid Meds", new Color(51,204,0));
        piePlot.setSectionPaint("Expired Meds", new Color(255,51,51));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        jpch.removeAll();
        jpch.add(barChartPanel, BorderLayout.CENTER);
        jpch.validate();
    }
    
    //To get the count of the customers, medicines and total number of orders 
    public void getCount(){
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs1= st.executeQuery("select count(cId) from customer");
            if(rs1.next()){
                c= rs1.getInt(1);
            }
            ResultSet rs2= st.executeQuery("select count(orderId) from bill");
            if(rs2.next()){
                o= rs2.getInt(1);
            }
            ResultSet rs3= st.executeQuery("select count(medId) from medicine");
            if(rs3.next()){
                m= rs3.getInt(1);
            }
        } catch(Exception e){
        }
    }
    
    public void updateStock(){
        Date today= new Date();
        String td= date2str(today);
        int t= Integer.parseInt(td);
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from medicine");
            while(rs.next()){
                int mId= rs.getInt(1);
                java.util.Date expDate= rs.getDate(5);
                String ed= date2str(expDate);
                int e= Integer.parseInt(ed);
                if(e <= t){
                    ExpMed(mId);
                }
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public String date2str(java.util.Date sdate){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
        return sdf.format(sdate);
    }
    
    public void ExpMed(int mId){
        try{
            Connection con= JConnection.getCon();
            Statement st= con.createStatement();
            st.executeUpdate("update medicine set validity='expired', status='inactive' where medId="+mId);
        } catch(Exception e){}
    }
    
    class AutoCall extends TimerTask{
        public void run(){
            new ValidityPeriod().setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLable1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jB1 = new javax.swing.JButton();
        jB2 = new javax.swing.JButton();
        jB3 = new javax.swing.JButton();
        jB4 = new javax.swing.JButton();
        jB5 = new javax.swing.JButton();
        jB6 = new javax.swing.JButton();
        jB7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jpch = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nc = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        nm = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        vam = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        exm = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        no = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jBDate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(242, 242, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 118, 225));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLable1.setBackground(new java.awt.Color(64, 64, 64));
        jLable1.setFont(new java.awt.Font("Calibri", 1, 26)); // NOI18N
        jLable1.setForeground(new java.awt.Color(242, 242, 242));
        jLable1.setText("  Administrator");
        jPanel2.add(jLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 166, 44));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin3_1_100x100.png"))); // NOI18N
        jLabel2.setText("jLabel3");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 110, 120));

        jB1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 14)); // NOI18N
        jB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashbord.png"))); // NOI18N
        jB1.setText("Dashboard");
        jB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB1ActionPerformed(evt);
            }
        });
        jPanel2.add(jB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 250, 40));

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
        jPanel2.add(jB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 250, 40));

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
        jPanel2.add(jB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 250, 40));

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
        jPanel2.add(jB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 250, 40));

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
        jPanel2.add(jB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 250, 40));

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
        jPanel2.add(jB6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 250, 40));

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
        jPanel2.add(jB7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 210, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 768));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close all jframe.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 30, 50, 50));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 32)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pharmacy_100px.png"))); // NOI18N
        jLabel1.setText("Dashboard");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 290, 100));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard 2.0.gif"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 630, 390));

        jpch.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jpch, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 340, 390));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 4, 4, 4, new java.awt.Color(255, 102, 102)));
        jPanel4.setForeground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No. of Customers");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 160, 40));

        nc.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        nc.setForeground(new java.awt.Color(102, 102, 102));
        nc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nc.setText("0");
        jPanel4.add(nc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 100, 80));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_People_50px.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 50, 60));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 230, 140));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 4, 4, 190, new java.awt.Color(0, 102, 51)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No. of Medicines");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 40));

        nm.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        nm.setForeground(new java.awt.Color(102, 102, 102));
        nm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nm.setText("0");
        jPanel5.add(nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 100, 80));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 91, 2, 2, new java.awt.Color(51, 204, 0)));
        jPanel8.setForeground(new java.awt.Color(255, 51, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel11.setText("Valid");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        vam.setBackground(new java.awt.Color(255, 255, 255));
        vam.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        vam.setForeground(new java.awt.Color(102, 102, 102));
        vam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vam.setText("0");
        jPanel8.add(vam, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 60, 50));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 170, 50));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 91, 2, 2, new java.awt.Color(255, 51, 51)));
        jPanel7.setForeground(new java.awt.Color(255, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel12.setText("Expired");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        exm.setBackground(new java.awt.Color(255, 255, 255));
        exm.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        exm.setForeground(new java.awt.Color(102, 102, 102));
        exm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exm.setText("0");
        jPanel7.add(exm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 60, 50));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 170, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/meds.png"))); // NOI18N
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 90, 80));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 170, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 420, 140));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 4, 4, 4, new java.awt.Color(204, 51, 0)));
        jPanel6.setForeground(new java.awt.Color(204, 51, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        no.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        no.setForeground(new java.awt.Color(102, 102, 102));
        no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        no.setText("0");
        jPanel6.add(no, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 100, 80));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 19)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("No. of Orders");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 130, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bill.jpg"))); // NOI18N
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 80));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 230, 140));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 1030, 610));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sync_64px_1_48x48.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 50, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, 110));

        jLabel13.setText("Click the Refresh Button");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, -1));

        jBDate.setBackground(new java.awt.Color(51, 51, 51));
        jBDate.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jBDate.setForeground(new java.awt.Color(255, 255, 255));
        jBDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDateActionPerformed(evt);
            }
        });
        jPanel1.add(jBDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 90, 180, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Logout Button
    private void jB7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB7ActionPerformed
        int a= JOptionPane.showConfirmDialog(null,"Do you really want to Logout?","Confirm!",JOptionPane.YES_NO_OPTION);
        if(a==0){
            setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_jB7ActionPerformed
    
    //Exit Button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a= JOptionPane.showConfirmDialog(null,"Do you want to close Application?","Confirm!",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jB6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB6ActionPerformed
        // TODO add your handling code here:
        new SellMedicine().setVisible(true);
    }//GEN-LAST:event_jB6ActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        updateStock();
        showPieChart();
        getCount();
        String nC= String.valueOf(c);
        String nO= String.valueOf(o);
        String nM= String.valueOf(m);
        String nVM= String.valueOf(vm);
        String nEM= String.valueOf(em);
        nc.setText(nC);
        no.setText(nO);
        nm.setText(nM);
        vam.setText(nVM);
        exm.setText(nEM);
        TimerTask task= new AutoCall();
        Timer timer= new Timer();
        timer.schedule(task, 5000);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB1ActionPerformed
        // TODO add your handling code here
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jB1ActionPerformed

    private void jBDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDateActionPerformed
        // TODO add your handling code here:
        new ValidityPeriod().setVisible(true);
    }//GEN-LAST:event_jBDateActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exm;
    private javax.swing.JButton jB1;
    private javax.swing.JButton jB2;
    private javax.swing.JButton jB3;
    private javax.swing.JButton jB4;
    private javax.swing.JButton jB5;
    private javax.swing.JButton jB6;
    private javax.swing.JButton jB7;
    private javax.swing.JButton jBDate;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLable1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpch;
    private javax.swing.JLabel nc;
    private javax.swing.JLabel nm;
    private javax.swing.JLabel no;
    private javax.swing.JLabel vam;
    // End of variables declaration//GEN-END:variables
}
