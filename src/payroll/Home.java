/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payroll;

/**
 *
 * @author natto
 */
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;  
public class Home extends javax.swing.JFrame {
    
    
    
    /** Creates new form Home */
    public Home() {
        initComponents();
       panel1.setVisible(true);
       panel2.setVisible(false);
       this.employee("");
       
    }
  
    public void employee(String emp) {
        DefaultTableModel dm = (DefaultTableModel)empTable.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        String sql;
        try {
            Conn con = new Conn();
            if(emp.equals("")){
                sql = "select * from employee inner join position on employee.posid = position.posid";
            }else{
                sql = "select * from employee  inner join position on employee.posid = position.posid "
                        + "where employee.id = '"+emp+"' OR employee.lname = '"+emp+"' OR employee.fname = '"+emp+"'";
            }
            
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                DefaultTableModel table = (DefaultTableModel)empTable.getModel();
                table.addRow(new Object[]{rs.getInt("id"),rs.getString("lname"),rs.getString("fname"),rs.getString("mname"),
                rs.getString("department"),rs.getString("posname"),rs.getFloat("basicSalary"),rs.getInt("state")});
                
            }
            rs.close();
            st.close();
            
            position();
            con.connect.close();
        } catch (Exception var5) {
        }

    }
    
    public void position(){
        DefaultTableModel table = (DefaultTableModel)positionTable.getModel();
        table.getDataVector().removeAllElements();
        table.fireTableDataChanged();
        position.removeAllItems();
        
        try {
            Conn con = new Conn();
            
            String sql = "select * from position";
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
          
                position.addItem(rs.getString("posname"));
                table.addRow(new Object[]{rs.getInt("posid"),rs.getString("posname"),
                rs.getFloat("basicSalary"),rs.getFloat("allowance")});
            }
            
            rs.close();
            st.close();
            con.connect.close();
        } catch (Exception e) {
            
        }

    }
    
    
    public void payslip(String date){
        DefaultTableModel dm = (DefaultTableModel)payslipTable.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        
        String[] arrString = date.split("-");
        searchfield.setText(date);
         try {
            Conn con = new Conn();
            String sql = "select * from payslip inner join employee on payslip.id = employee.id inner join position"
                    + " on employee.posid = position.posid where Month(payslip.sdate)='"+arrString[0]+"'"
                    + " AND Year(payslip.sdate)='"+arrString[1]+"'";
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                DefaultTableModel table = (DefaultTableModel)payslipTable.getModel();
                String name = rs.getString("employee.fname") +" "+ rs.getString("employee.lname");
                table.addRow(new Object[]{rs.getString("payslip.sdate"),rs.getInt("employee.id"),name,
                rs.getInt("payslip.sattendance"),rs.getInt("payslip.sovertime"),rs.getInt("payslip.slate"),
                rs.getFloat("payslip.sgrosspay"),rs.getFloat("payslip.sovertimepay"),rs.getFloat("position.allowance"),
                rs.getFloat("payslip.sdeduction"),
                rs.getFloat("payslip.snetpay")});
                
            }
            rs.close();
            st.close();
            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    
    }
    
    
    public void clearEmpVal(){
        empid.setText("");
        lnamefield.setText("");
        fnamefield.setText("");
        mnamefield.setText("");
        departmentfield.setText("");
        status.setText("");
    }
    
    public void clearPosition(){
        posid.setText("");
        posname.setText("");
        basicSalary.setText("");
        allowance.setText("");
    }

  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        fnamefield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mnamefield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lnamefield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        departmentfield = new javax.swing.JTextField();
        position = new javax.swing.JComboBox<>();
        create = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        empid = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        empsearchfield = new javax.swing.JTextField();
        empsearch = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        payslipTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        positionTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        posid = new javax.swing.JLabel();
        jlabel232 = new javax.swing.JLabel();
        posname = new javax.swing.JTextField();
        jlabel233 = new javax.swing.JLabel();
        basicSalary = new javax.swing.JTextField();
        jlabel234 = new javax.swing.JLabel();
        allowance = new javax.swing.JTextField();
        poscreate = new javax.swing.JButton();
        posreset = new javax.swing.JButton();
        posupdate = new javax.swing.JButton();
        posdelete = new javax.swing.JButton();
        generatePayslip = new javax.swing.JButton();
        search = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        searchfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setBackground(new java.awt.Color(102, 102, 255));

        tab1.setBackground(new java.awt.Color(204, 204, 255));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee Management");

        org.jdesktop.layout.GroupLayout tab1Layout = new org.jdesktop.layout.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, tab1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab2.setBackground(new java.awt.Color(153, 153, 255));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Payroll");

        org.jdesktop.layout.GroupLayout tab2Layout = new org.jdesktop.layout.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout MenuLayout = new org.jdesktop.layout.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(tab2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(MenuLayout.createSequentialGroup()
                .add(89, 89, 89)
                .add(tab1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(5, 5, 5)
                .add(tab2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel1.setBackground(new java.awt.Color(181, 181, 255));

        empTable.setBackground(new java.awt.Color(204, 204, 204));
        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "lname", "fname", "mname", "department", "position", "basicSalary", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empTable.setGridColor(new java.awt.Color(102, 102, 255));
        empTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(empTable);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Firstname");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Middlename");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Lastname");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Department");

        position.setMaximumRowCount(20);

        create.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        create.setText("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setText("Activate/Deactive");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label.setText("ID: ");

        empid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jLabel12.setText("Enter Employee:");

        empsearchfield.setForeground(new java.awt.Color(102, 102, 102));
        empsearchfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        empsearchfield.setName("efewfw"); // NOI18N

        empsearch.setText("Search");
        empsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empsearchActionPerformed(evt);
            }
        });

        status.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label1.setText("Status:");

        org.jdesktop.layout.GroupLayout panel1Layout = new org.jdesktop.layout.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panel1Layout.createSequentialGroup()
                .add(68, 68, 68)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fnamefield)
                    .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(mnamefield)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panel1Layout.createSequentialGroup()
                        .add(label, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(empid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(position, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panel1Layout.createSequentialGroup()
                        .add(label1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(status, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(departmentfield, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(lnamefield))
                    .add(panel1Layout.createSequentialGroup()
                        .add(reset, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(create, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(update, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(delete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(panel1Layout.createSequentialGroup()
                        .add(jLabel12)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(empsearchfield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(empsearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 638, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(19, 19, 19))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panel1Layout.createSequentialGroup()
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(panel1Layout.createSequentialGroup()
                            .add(16, 16, 16)
                            .add(empsearch))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .add(jLabel12)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, empsearchfield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(label, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(empid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(label1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(status, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jLabel8))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(fnamefield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lnamefield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel9)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(mnamefield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(departmentfield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(panel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(position, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(reset, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(create, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(update, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(delete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(25, 25, 25))
        );

        panel2.setBackground(new java.awt.Color(181, 181, 255));

        payslipTable.setBackground(new java.awt.Color(204, 204, 204));
        payslipTable.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        payslipTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "id", "Name", "Attendance", "Overtime(Min)", "Late(Min)", "GrossPay", "OverTPay", "Allowance", "Deduction", "NetPay"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        payslipTable.setGridColor(new java.awt.Color(51, 51, 255));
        jScrollPane2.setViewportView(payslipTable);

        positionTable.setBackground(new java.awt.Color(204, 204, 204));
        positionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PosID", "PosName", "BasicSalary", "Allowance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        positionTable.setGridColor(new java.awt.Color(51, 51, 255));
        positionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positionTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(positionTable);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("ID: ");

        posid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jlabel232.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlabel232.setText("Position Name");

        jlabel233.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlabel233.setText("Basic Salary");

        jlabel234.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlabel234.setText("Allowance");

        poscreate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        poscreate.setText("Create");
        poscreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poscreateActionPerformed(evt);
            }
        });

        posreset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        posreset.setText("Reset");
        posreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posresetActionPerformed(evt);
            }
        });

        posupdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        posupdate.setText("Update");
        posupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posupdateActionPerformed(evt);
            }
        });

        posdelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        posdelete.setText("Delete");
        posdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posdeleteActionPerformed(evt);
            }
        });

        generatePayslip.setText("Generate Payslip");
        generatePayslip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePayslipActionPerformed(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel11.setText("Enter payslip date:");

        searchfield.setForeground(new java.awt.Color(102, 102, 102));
        searchfield.setText("[mm-yyyy]");

        org.jdesktop.layout.GroupLayout panel2Layout = new org.jdesktop.layout.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panel2Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panel2Layout.createSequentialGroup()
                        .add(panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(panel2Layout.createSequentialGroup()
                                .add(641, 641, 641)
                                .add(jLabel5))
                            .add(panel2Layout.createSequentialGroup()
                                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 317, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(23, 23, 23)
                                .add(panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(panel2Layout.createSequentialGroup()
                                        .add(panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(allowance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(panel2Layout.createSequentialGroup()
                                                .add(poscreate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(posupdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(posdelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                            .add(jlabel234, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(basicSalary, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(jlabel233, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(posname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(0, 0, Short.MAX_VALUE))
                                    .add(panel2Layout.createSequentialGroup()
                                        .add(panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(panel2Layout.createSequentialGroup()
                                                .add(4, 4, 4)
                                                .add(jLabel10)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(posid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                            .add(jlabel232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(posreset, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 638, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .add(panel2Layout.createSequentialGroup()
                        .add(jLabel11)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(searchfield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(search, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 170, Short.MAX_VALUE)
                        .add(generatePayslip, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(38, 38, 38))))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panel2Layout.createSequentialGroup()
                .add(0, 19, Short.MAX_VALUE)
                .add(panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(search)
                        .add(jLabel11)
                        .add(searchfield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, generatePayslip, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 217, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 217, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(panel2Layout.createSequentialGroup()
                        .add(panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(panel2Layout.createSequentialGroup()
                                .add(panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(posid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel10))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlabel232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(posreset, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(posname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jlabel233, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(basicSalary, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jlabel234, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(allowance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(panel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(poscreate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(posupdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(posdelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(16, 16, 16))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 679, Short.MAX_VALUE)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, panel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(panel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 532, Short.MAX_VALUE)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(panel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(panel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(Menu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(Menu, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
        panel1.setVisible(true);
        panel2.setVisible(false);
       
        tab1.setBackground(new java.awt.Color(204,204,255));
        tab2.setBackground(new java.awt.Color(153,153,255));

        
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        panel1.setVisible(false);
        panel2.setVisible(true);
       
        tab2.setBackground(new java.awt.Color(204,204,255));
        tab1.setBackground(new java.awt.Color(153,153,255));
 
        LocalDate currentdate = LocalDate.now();
       
        payslip(currentdate.getMonthValue()+"-"+currentdate.getYear());
        position();
        
    }//GEN-LAST:event_tab2MouseClicked

    private void empTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empTableMouseClicked
        clearEmpVal();
        DefaultTableModel mytable = (DefaultTableModel)empTable.getModel();
        int row = empTable.getSelectedRow();
        empid.setText(mytable.getValueAt(row,0).toString());
        lnamefield.setText(mytable.getValueAt(row,1).toString());
        fnamefield.setText(mytable.getValueAt(row,2).toString());
        mnamefield.setText(mytable.getValueAt(row,3).toString());
        departmentfield.setText(mytable.getValueAt(row,4).toString());
        position.setSelectedItem(mytable.getValueAt(row,5).toString());
        status.setText(mytable.getValueAt(row,7).toString());

    }//GEN-LAST:event_empTableMouseClicked

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
       clearEmpVal();
    }//GEN-LAST:event_resetActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        try {
            Conn con = new Conn();
            String sql = "Insert into employee (fname,lname,mname,department,posid) values('"+fnamefield.getText()+"','"+lnamefield.getText()+"',"
                    + "'"+mnamefield.getText()+"','"+departmentfield.getText()+"',(Select posid from position where posname = "
                    + "'"+position.getSelectedItem()+"'))";
     
            PreparedStatement st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            st.close();
   
            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
        employee("");
        clearEmpVal();
    }//GEN-LAST:event_createActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       try {
            Conn con = new Conn();
            String sql = "Update employee set fname ='"+fnamefield.getText()+"' ,lname = '"+lnamefield.getText()+"',"
                    + "mname = '"+mnamefield.getText()+"',"
                    + "department = '"+departmentfield.getText()+"',posid = (Select posid from position"
                    + " where posname = '"+position.getSelectedItem()+"') where id = '"+empid.getText()+"'";
                    
     
            PreparedStatement st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            st.close();
   
            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        employee("");
        position();
        clearEmpVal();
    }//GEN-LAST:event_updateActionPerformed

    private void positionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positionTableMouseClicked
        clearPosition();
        DefaultTableModel mytable = (DefaultTableModel)positionTable.getModel();
        int row = positionTable.getSelectedRow();
        posid.setText(mytable.getValueAt(row,0).toString());
        posname.setText(mytable.getValueAt(row,1).toString());
        basicSalary.setText(mytable.getValueAt(row,2).toString());
        allowance.setText(mytable.getValueAt(row,3).toString());
    
    }//GEN-LAST:event_positionTableMouseClicked

    private void posresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posresetActionPerformed
        clearPosition();
    }//GEN-LAST:event_posresetActionPerformed

    private void poscreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poscreateActionPerformed
        try {
            Conn con = new Conn();
            String sql = "Insert into position (posname,basicSalary,allowance) values('"+posname.getText()+"',"
                    + "'"+basicSalary.getText()+"','"+allowance.getText()+"')";
     
            PreparedStatement st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            st.close();
   
            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
        position();
        clearPosition();
    }//GEN-LAST:event_poscreateActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if(!searchfield.getText().equals("")){
            payslip(searchfield.getText());
        }    
    }//GEN-LAST:event_searchActionPerformed
        
    private void empsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empsearchActionPerformed
        employee(empsearchfield.getText());
    }//GEN-LAST:event_empsearchActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String stat = (status.getText().equals("0"))? "-1":"0";
        try {
            Conn con = new Conn();
            String sql = "Update employee set state = '"+stat+"' where id = '"+empid.getText()+"'";
            PreparedStatement st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            st.close();

            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        employee("");
        position();
        clearEmpVal();
    }//GEN-LAST:event_deleteActionPerformed

    private void posupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posupdateActionPerformed
        try {
            Conn con = new Conn();
            String sql = "Update position set posname ='"+posname.getText()+"' ,basicSalary = '"+basicSalary.getText()+"',"
                    + "allowance = '"+allowance.getText()+"' where posid = '"+posid.getText()+"'";
                    
     
            PreparedStatement st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            st.close();
   
            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        position();
        clearPosition();
    }//GEN-LAST:event_posupdateActionPerformed

    private void posdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posdeleteActionPerformed
       try {
            Conn con = new Conn();
            String sql = "Delete from position where posid = '"+posid.getText()+"'";
                
            PreparedStatement st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            st.close();
   
            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        position();
        clearPosition();
    }//GEN-LAST:event_posdeleteActionPerformed

    
    public void calculatePayslip(List<String[]> list,int count){
        int overtime = 0,late = 0,attendance = 0,total = 0, t_in = 0,t_out = 0;
       float gross = 0,deduc = 0, allo = 0,rate=0;
       double comp =0,net =0;
        
        
        
        for (String[] val : list){
            
            
            String[] time_in = val[2].split(":");
            String[] time_out = val[3].split(":");
           
            t_in = (Integer.parseInt(time_in[0])*60) + Integer.parseInt(time_in[1]);
            t_out = (Integer.parseInt(time_out[0])*60) + Integer.parseInt(time_out[1]);
            total = t_out - t_in;
            if(total>=480){
                overtime +=  (total- 480);
            }else{
                late +=  (480-total);
            }
            attendance++;
        }
        
         try {
            Conn con = new Conn();
            String sql = "select * from employee inner join position on employee.posid = position.posid where employee.id = '"+list.get(0)[0]+"'";
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                rate = ((rs.getFloat("position.basicSalary")/12)/26);
                gross = attendance * rate;
                deduc = late * ((rate/8)/60);
                comp = overtime * (((rate/8)/60)*1.45);
                net = gross + comp + (rs.getFloat("position.allowance")) ;
                net -=deduc;
            }
  
            String[] date = list.get(0)[1].split("/");
            String dateconcat = date[2]+"-"+date[0]+"-"+date[1];
            sql = "Insert into payslip (id,sgrosspay,snetpay,sdeduction,sovertimepay,slate,sovertime,sattendance,sdate) "
                    + "values ('"+list.get(0)[0]+"','"+gross+"','"+net+"','"+deduc+"','"+comp+"','"+late+"','"+overtime+"',"
                    + "'"+attendance+"','"+dateconcat+"')";
            st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            rs.close();
            st.close();
            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public boolean checkDuplicate(String id,String[]date){
        boolean flag = false;
         try {
            Conn con = new Conn();
            String sql = "select count(*) as count from payslip where id = '"+id+"' and Month(sdate) = '"+date[0]+"' and Year(sdate)='"+date[2]+"'";
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               flag = (rs.getInt("count") == 0)? true: false;
            }

            rs.close();
            st.close();
            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return flag;
    }
    private void generatePayslipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePayslipActionPerformed
       JFileChooser file = new JFileChooser();
       int response = file.showOpenDialog(null);
       if(response == JFileChooser.APPROVE_OPTION){
           File filepath = new File(file.getSelectedFile().getAbsolutePath());
          String filename = filepath.getName();
          
          
          String line = "";
          List<String[]> list = new ArrayList<String[]>();
          int count = 0;
  
           try{
               BufferedReader br = new  BufferedReader(new FileReader(filepath.toString()));
               
               line = br.readLine();
               do{
                  
                    line = br.readLine();
                    if(line !=null && !line.contains("*")){
                       String[] values = line.split(",");
                       list.add(values);
                       count++; 
                   }else{
                        
                      if(checkDuplicate(list.get(0)[0],list.get(0)[1].split("/"))){
                          calculatePayslip(list,count);
                      }
                      
                       count = 0;
                       list.clear();
                      
                   }
               }while(line !=null);
              
           }catch(FileNotFoundException e){
               e.printStackTrace();
           }catch(IOException e){
            e.printStackTrace();
        }
         
       }
       LocalDate currentdate = LocalDate.now();
       payslip(currentdate.getMonthValue()+"-"+currentdate.getYear());
    }//GEN-LAST:event_generatePayslipActionPerformed
    
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
    private javax.swing.JPanel Menu;
    private javax.swing.JTextField allowance;
    private javax.swing.JTextField basicSalary;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JTextField departmentfield;
    private javax.swing.JTable empTable;
    private javax.swing.JLabel empid;
    private javax.swing.JButton empsearch;
    private javax.swing.JTextField empsearchfield;
    private javax.swing.JTextField fnamefield;
    private javax.swing.JButton generatePayslip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlabel232;
    private javax.swing.JLabel jlabel233;
    private javax.swing.JLabel jlabel234;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JTextField lnamefield;
    private javax.swing.JTextField mnamefield;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTable payslipTable;
    private javax.swing.JButton poscreate;
    private javax.swing.JButton posdelete;
    private javax.swing.JLabel posid;
    private javax.swing.JComboBox<String> position;
    private javax.swing.JTable positionTable;
    private javax.swing.JTextField posname;
    private javax.swing.JButton posreset;
    private javax.swing.JButton posupdate;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchfield;
    private javax.swing.JLabel status;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}
