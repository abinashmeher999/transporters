
import com.sun.media.sound.InvalidFormatException;
import com.transporters.Address;
import com.transporters.Branch;
import com.transporters.Consignment;
import com.transporters.Database;
import com.transporters.HeadOffice;
import com.transporters.Office;
import com.transporters.Truck;
import com.transporters.Login;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.transporters.Branch;
import com.transporters.Consignment;
import com.transporters.Database;
import com.transporters.HeadOffice;
import com.transporters.Truck;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author best1yash
 */
public class Manager extends javax.swing.JFrame {

    Database db;
    HeadOffice head_office;
    List<Branch> branch_list;
    List<Truck> truck_list;
    List<Consignment> consignment_list;
    List<Login> login_list;
    int head_counter;
    int branch_counter;
    int truck_counter;
    int consignment_counter;
    private int login_counter;

    public void readDatabase() {
        try {
            Statement stmt = head_office.getDatabase().getConnection().createStatement();
            Statement stmt2 = head_office.getDatabase().getConnection().createStatement();
            Statement stmt3 = db.getConnection().createStatement();
            Statement stmt4 = db.getConnection().createStatement();

            String query = "SELECT * from Lists";
            String query2 = "SELECT * from ID_data";

            ResultSet rs1 = stmt.executeQuery(query);
            ResultSet rs2 = stmt2.executeQuery(query2);

            String query3 = "SELECT * FROM IP";
            ResultSet rs3 = stmt3.executeQuery(query3);
            rs3.next();
            Database.setIPAddress(rs3.getString("address"));

            String query4 = "SELECT * FROM Charge";
            ResultSet rs4 = stmt4.executeQuery(query4);
            rs4.next();
            Consignment.setCharge_per_km(rs4.getDouble("value"));

            List<byte[]> buf = new ArrayList<>();
            ObjectInputStream o;

            rs2.next();
            head_counter = rs2.getInt("counter");
            int temp = 0;
            while (rs1.next()) {
                buf.add(rs1.getBytes("list"));
            }
            if (head_counter != 0) {
                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                head_office = (HeadOffice) o.readObject();
            } else {
                head_office = new HeadOffice("transporters", new Address("9641183277", "LBS IITKGP"));
                String update = "UPDATE Lists SET list=? WHERE name='head_office'";
                PreparedStatement pstmt = db.getConnection().prepareStatement(update);
                pstmt.setObject(1, head_office);
                pstmt.executeUpdate();
                stmt.executeUpdate("UPDATE ID_data SET counter=1 WHERE name='head_counter'");
            }

            rs2.next();
            branch_counter = rs2.getInt("counter");
            //rs.next();
            if (branch_counter != 0) {
                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                branch_list = (ArrayList<Branch>) o.readObject();
            } else {
                branch_list = new ArrayList<>();
            }

            rs2.next();
            truck_counter = rs2.getInt("counter");
            //rs.next();
            if (truck_counter != 0) {

                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                truck_list = (ArrayList<Truck>) o.readObject();
            } else {
                truck_list = new ArrayList<>();
            }

            rs2.next();
            consignment_counter = rs2.getInt("counter");
            //rs.next();
            if (consignment_counter != 0) {

                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                consignment_list = (ArrayList<Consignment>) o.readObject();
            } else {
                consignment_list = new ArrayList<>();
            }

//            rs2.next();
//            login_counter = rs2.getInt("counter");
//            //rs.next();
//            if (login_counter != 0) {
//
//                //buf = rs.getBytes("list");
//                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
//                login_list = (ArrayList<Login>) o.readObject();
//            } else {
//                login_list = new ArrayList<>();
//            }
            rs1.close();
            rs2.close();
            rs3.close();
            rs4.close();
        } catch (SQLException | IOException | ClassNotFoundException ex) {//SQLException | IOException | ClassNotFoundException
            java.lang.System.out.println("What");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form Manager
     */
    public Manager() {
        initComponents();
        try {
            Database.setIPAddress("localhost");
            db = new Database();
            db.setUrl(Database.getBranchURL());
            db.setUser("root");
            db.setPassword("alsk");
            Statement stmt = db.getConnection().createStatement();
            Statement stmt2 = db.getConnection().createStatement();
            Statement stmt3 = db.getConnection().createStatement();
            Statement stmt4 = db.getConnection().createStatement();
            String query = "SELECT * FROM Lists";
            ResultSet rs = stmt.executeQuery(query);
            List<byte[]> buf = new ArrayList<>();
            ObjectInputStream o;

            String query2 = "SELECT * FROM ID_data";
            ResultSet rs2 = stmt2.executeQuery(query2);

            String query3 = "SELECT * FROM IP";
            ResultSet rs3 = stmt3.executeQuery(query3);

            rs3.next();
            Database.setIPAddress(rs3.getString("address"));

            String query4 = "SELECT * FROM Charge";
            ResultSet rs4 = stmt4.executeQuery(query4);
            rs4.next();
            Consignment.setCharge_per_km(rs4.getDouble("value"));

            rs2.next();
            head_counter = rs2.getInt("counter");
            int temp = 0;
            while (rs.next()) {
                buf.add(rs.getBytes("list"));
            }
            if (head_counter != 0) {
                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                head_office = (HeadOffice) o.readObject();
            } else {
                head_office = new HeadOffice("transporters", new Address("9641183277", "LBS IITKGP"));
                String update = "UPDATE Lists SET list=? WHERE name='head_office'";
                PreparedStatement pstmt = db.getConnection().prepareStatement(update);
                pstmt.setObject(1, head_office);
                pstmt.executeUpdate();
                stmt.executeUpdate("UPDATE ID_data SET counter=1 WHERE name='head_counter'");
            }

            rs2.next();
            branch_counter = rs2.getInt("counter");
            //rs.next();
            if (branch_counter != 0) {
                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                branch_list = (ArrayList<Branch>) o.readObject();
            } else {
                branch_list = new ArrayList<>();
            }

            rs2.next();
            truck_counter = rs2.getInt("counter");
            //rs.next();
            if (truck_counter != 0) {

                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                truck_list = (ArrayList<Truck>) o.readObject();
            } else {
                truck_list = new ArrayList<>();
            }

            rs2.next();
            consignment_counter = rs2.getInt("counter");
            //rs.next();
            if (consignment_counter != 0) {

                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                consignment_list = (ArrayList<Consignment>) o.readObject();
            } else {
                consignment_list = new ArrayList<>();
            }

//            rs2.next();
//            login_counter = rs2.getInt("counter");
//            //rs.next();
//            if (login_counter != 0) {
//
//                //buf = rs.getBytes("list");
//                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
//                login_list = (ArrayList<Login>) o.readObject();
//            } else {
//
//                login_list = new ArrayList<>();
//            }
            rs.close();
            rs2.close();
        } catch (SQLException | IOException | ClassNotFoundException ex) {//SQLException | IOException | ClassNotFoundException
            java.lang.System.out.println("What");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
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

        bg_company_stats = new javax.swing.ButtonGroup();
        tp_manager = new javax.swing.JTabbedPane();
        p_administration = new javax.swing.JPanel();
        tp_administration = new javax.swing.JTabbedPane();
        p_hire = new javax.swing.JPanel();
        b_view_applicatns = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        l_employee_name = new javax.swing.JLabel();
        l_employee_address = new javax.swing.JLabel();
        l_branch = new javax.swing.JLabel();
        tf_employee_name = new javax.swing.JTextField();
        tf_username = new javax.swing.JTextField();
        cmb_branch_list = new javax.swing.JComboBox();
        b_hire = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        admin_access_table = new javax.swing.JTable();
        cmb_admin_access = new javax.swing.JComboBox();
        b_remove_access = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tf_password = new javax.swing.JTextField();
        p_buy_truck = new javax.swing.JPanel();
        l_model = new javax.swing.JLabel();
        l_plate_number = new javax.swing.JLabel();
        l_cost = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_truck_model = new javax.swing.JTextField();
        tf_plate_number = new javax.swing.JTextField();
        tf_cost = new javax.swing.JTextField();
        cmb_branch = new javax.swing.JComboBox();
        b_add_to_fleet = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_truck_at_branch = new javax.swing.JTable();
        p_fire = new javax.swing.JPanel();
        b_view_employee = new javax.swing.JButton();
        if_employee_list = new javax.swing.JInternalFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        tf_employee_id = new javax.swing.JTextField();
        l_employee_id = new javax.swing.JLabel();
        l_fire_reason = new javax.swing.JLabel();
        tf_fire_reason = new javax.swing.JTextField();
        b_fire = new javax.swing.JButton();
        Address = new javax.swing.JPanel();
        l_branch_name = new javax.swing.JLabel();
        tf_mbn = new javax.swing.JTextField();
        l_contact = new javax.swing.JLabel();
        l_address = new javax.swing.JLabel();
        tf_mc = new javax.swing.JTextField();
        b_add_branch = new javax.swing.JButton();
        l_user_name = new javax.swing.JLabel();
        l_password = new javax.swing.JLabel();
        tf_mun = new javax.swing.JTextField();
        tf_mp = new javax.swing.JTextField();
        b_reset = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        l_set_ip = new javax.swing.JLabel();
        tf_set_ip = new javax.swing.JTextField();
        b_set_ip = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        tf_charge = new javax.swing.JTextField();
        b_mscvp = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tf_ma = new javax.swing.JTextArea();
        p_queries = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_query = new javax.swing.JTable();
        cmb_query = new javax.swing.JComboBox();
        b_get_details = new javax.swing.JButton();
        tf_query_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        b_view_consignments = new javax.swing.JButton();
        b_view_trucks = new javax.swing.JButton();
        p_company_statistics = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        l_truck_plate_number = new javax.swing.JLabel();
        tf_truck_plate_num = new javax.swing.JTextField();
        b_get_truck_usage = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cs_ta_tpn = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        cmb_cs_b = new javax.swing.JComboBox();
        rb_atit = new javax.swing.JRadioButton();
        rb_acwt = new javax.swing.JRadioButton();
        rb_bch = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cs_ta_b = new javax.swing.JTextArea();
        cs_query = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        b_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p_administration.setOpaque(false);

        tp_administration.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        tp_administration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tp_administrationFocusGained(evt);
            }
        });

        p_hire.setPreferredSize(new java.awt.Dimension(800, 600));

        b_view_applicatns.setText("View access");
        b_view_applicatns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_view_applicatnsMouseClicked(evt);
            }
        });
        b_view_applicatns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_view_applicatnsActionPerformed(evt);
            }
        });

        l_employee_name.setText("Name");

        l_employee_address.setText("Username");

        l_branch.setText("Branch");

        tf_employee_name.setText("Employee Name");
        tf_employee_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_employee_nameFocusGained(evt);
            }
        });
        tf_employee_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_employee_nameActionPerformed(evt);
            }
        });

        tf_username.setText("Username");
        tf_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_usernameFocusLost(evt);
            }
        });

        cmb_branch_list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branch" }));
        cmb_branch_list.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb_branch_listFocusGained(evt);
            }
        });

        b_hire.setText("Grant Access");
        b_hire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_hireActionPerformed(evt);
            }
        });

        admin_access_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Username", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        admin_access_table.getTableHeader().setResizingAllowed(false);
        admin_access_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(admin_access_table);
        if (admin_access_table.getColumnModel().getColumnCount() > 0) {
            admin_access_table.getColumnModel().getColumn(0).setResizable(false);
            admin_access_table.getColumnModel().getColumn(1).setResizable(false);
            admin_access_table.getColumnModel().getColumn(2).setResizable(false);
        }

        cmb_admin_access.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branch" }));
        cmb_admin_access.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb_admin_accessFocusGained(evt);
            }
        });

        b_remove_access.setBackground(new java.awt.Color(225, 22, 30));
        b_remove_access.setForeground(new java.awt.Color(253, 243, 243));
        b_remove_access.setText("Remove user");
        b_remove_access.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_remove_accessMouseClicked(evt);
            }
        });

        jLabel6.setText("Password");

        tf_password.setText("Password");
        tf_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_passwordFocusLost(evt);
            }
        });

        javax.swing.GroupLayout p_hireLayout = new javax.swing.GroupLayout(p_hire);
        p_hire.setLayout(p_hireLayout);
        p_hireLayout.setHorizontalGroup(
            p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(p_hireLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_hireLayout.createSequentialGroup()
                        .addComponent(cmb_admin_access, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                        .addComponent(b_view_applicatns))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_hireLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_remove_access, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_hireLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_employee_address)
                            .addComponent(jLabel6)
                            .addComponent(l_employee_name, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_hireLayout.createSequentialGroup()
                                .addComponent(tf_employee_name, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(l_branch))
                            .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_branch_list, 0, 180, Short.MAX_VALUE)
                            .addComponent(b_hire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        p_hireLayout.setVerticalGroup(
            p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_hireLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_view_applicatns)
                    .addComponent(cmb_admin_access, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_remove_access)
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_employee_name)
                    .addComponent(tf_employee_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_branch)
                    .addComponent(cmb_branch_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_employee_address)
                        .addComponent(tf_username))
                    .addComponent(b_hire))
                .addGap(15, 15, 15)
                .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_password))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tp_administration.addTab("Grant Access", p_hire);

        l_model.setText("Model");

        l_plate_number.setText("Plate Number");

        l_cost.setText("Cost");

        jLabel4.setText("Assigned Branch");

        tf_truck_model.setText("Truck Model");
        tf_truck_model.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_truck_modelFocusGained(evt);
            }
        });

        tf_plate_number.setText("Plate Number");
        tf_plate_number.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_plate_numberFocusGained(evt);
            }
        });
        tf_plate_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_plate_numberActionPerformed(evt);
            }
        });

        tf_cost.setText("Cost");
        tf_cost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_costFocusGained(evt);
            }
        });

        cmb_branch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branch" }));
        cmb_branch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb_branchFocusGained(evt);
            }
        });

        b_add_to_fleet.setText("Add to fleet");
        b_add_to_fleet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_add_to_fleetMouseClicked(evt);
            }
        });
        b_add_to_fleet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_add_to_fleetActionPerformed(evt);
            }
        });

        table_truck_at_branch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Truck Plate NUmber", "Current Office", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(table_truck_at_branch);

        javax.swing.GroupLayout p_buy_truckLayout = new javax.swing.GroupLayout(p_buy_truck);
        p_buy_truck.setLayout(p_buy_truckLayout);
        p_buy_truckLayout.setHorizontalGroup(
            p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_buy_truckLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addGroup(p_buy_truckLayout.createSequentialGroup()
                        .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_model)
                            .addComponent(l_plate_number)
                            .addComponent(l_cost)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_add_to_fleet)
                            .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_truck_model, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(tf_plate_number)
                                .addComponent(tf_cost)
                                .addComponent(cmb_branch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        p_buy_truckLayout.setVerticalGroup(
            p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_buy_truckLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_model)
                    .addComponent(tf_truck_model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_plate_number)
                    .addComponent(tf_plate_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_cost)
                    .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmb_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_add_to_fleet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_administration.addTab("Buy Trucks", p_buy_truck);

        p_fire.setPreferredSize(new java.awt.Dimension(800, 600));

        b_view_employee.setText("View Employees");
        b_view_employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_view_employeeActionPerformed(evt);
            }
        });

        if_employee_list.setVisible(true);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        if_employee_list.getContentPane().add(jScrollPane5, java.awt.BorderLayout.CENTER);

        tf_employee_id.setText("Employee Id");

        l_employee_id.setText("Employee Id");

        l_fire_reason.setText("Reason for firing");

        tf_fire_reason.setText("Employee's services are terminated due to following causes:");

        b_fire.setText("Fire");

        javax.swing.GroupLayout p_fireLayout = new javax.swing.GroupLayout(p_fire);
        p_fire.setLayout(p_fireLayout);
        p_fireLayout.setHorizontalGroup(
            p_fireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_fireLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_fireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(if_employee_list)
                    .addComponent(jSeparator2)
                    .addGroup(p_fireLayout.createSequentialGroup()
                        .addComponent(b_view_employee)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(p_fireLayout.createSequentialGroup()
                        .addGroup(p_fireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_employee_id)
                            .addComponent(l_fire_reason))
                        .addGap(54, 54, 54)
                        .addGroup(p_fireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_fire_reason, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                            .addGroup(p_fireLayout.createSequentialGroup()
                                .addGroup(p_fireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b_fire)
                                    .addComponent(tf_employee_id, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        p_fireLayout.setVerticalGroup(
            p_fireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_fireLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_view_employee)
                .addGap(18, 18, 18)
                .addComponent(if_employee_list, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(p_fireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_employee_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_employee_id))
                .addGap(18, 18, 18)
                .addGroup(p_fireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_fire_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_fire_reason))
                .addGap(18, 18, 18)
                .addComponent(b_fire)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp_administration.addTab("Remove Employee", p_fire);

        Address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AddressFocusGained(evt);
            }
        });
        Address.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                AddressComponentShown(evt);
            }
        });

        l_branch_name.setText("Branch Name");

        tf_mbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_mbnActionPerformed(evt);
            }
        });

        l_contact.setText("Contact");

        l_address.setText("Address");

        b_add_branch.setText("Add Branch");
        b_add_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_add_branchMouseClicked(evt);
            }
        });
        b_add_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_add_branchActionPerformed(evt);
            }
        });

        l_user_name.setText("User Name");

        l_password.setText("Password");

        b_reset.setText("Reset");
        b_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_resetMouseClicked(evt);
            }
        });

        l_set_ip.setText("IP Address");

        tf_set_ip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_set_ipFocusGained(evt);
            }
        });

        b_set_ip.setText("Set IP Address");
        b_set_ip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_set_ipMouseClicked(evt);
            }
        });

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setText("Charge/Volume");

        tf_charge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_chargeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_chargeFocusLost(evt);
            }
        });
        tf_charge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_chargeMouseClicked(evt);
            }
        });

        b_mscvp.setText("Set Charge/Volume");
        b_mscvp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_mscvpMouseClicked(evt);
            }
        });

        tf_ma.setColumns(20);
        tf_ma.setRows(5);
        jScrollPane4.setViewportView(tf_ma);

        javax.swing.GroupLayout AddressLayout = new javax.swing.GroupLayout(Address);
        Address.setLayout(AddressLayout);
        AddressLayout.setHorizontalGroup(
            AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddressLayout.createSequentialGroup()
                        .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddressLayout.createSequentialGroup()
                                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_branch_name)
                                    .addComponent(l_contact)
                                    .addComponent(l_address))
                                .addGap(18, 18, 18)
                                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(tf_mbn, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(tf_mc))
                                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddressLayout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(l_user_name)
                                            .addComponent(l_password))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tf_mun, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                            .addComponent(tf_mp)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddressLayout.createSequentialGroup()
                                        .addGap(213, 213, 213)
                                        .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(b_reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(b_add_branch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))))
                            .addGroup(AddressLayout.createSequentialGroup()
                                .addComponent(l_set_ip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_set_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b_set_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_charge)
                                    .addComponent(b_mscvp, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AddressLayout.setVerticalGroup(
            AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_branch_name)
                    .addComponent(tf_mbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_user_name)
                    .addComponent(tf_mun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_mc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_contact)
                    .addComponent(l_password)
                    .addComponent(tf_mp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddressLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(b_reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_add_branch))
                    .addGroup(AddressLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_address))))
                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddressLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddressLayout.createSequentialGroup()
                                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_set_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l_set_ip))
                                .addGap(18, 18, 18)
                                .addComponent(b_set_ip))
                            .addGroup(AddressLayout.createSequentialGroup()
                                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(tf_charge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(b_mscvp)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddressLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tp_administration.addTab("Miscellaneous", Address);

        javax.swing.GroupLayout p_administrationLayout = new javax.swing.GroupLayout(p_administration);
        p_administration.setLayout(p_administrationLayout);
        p_administrationLayout.setHorizontalGroup(
            p_administrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_administrationLayout.createSequentialGroup()
                .addComponent(tp_administration, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        p_administrationLayout.setVerticalGroup(
            p_administrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_administrationLayout.createSequentialGroup()
                .addComponent(tp_administration, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        tp_manager.addTab("Administration", p_administration);

        p_queries.setOpaque(false);
        p_queries.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                p_queriesComponentShown(evt);
            }
        });

        table_query.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Truck IDs", "From", "To", "Date of Dispatch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_query.setEnabled(false);
        jScrollPane6.setViewportView(table_query);

        cmb_query.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Consignment Details", "Truck Details" }));
        cmb_query.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_queryItemStateChanged(evt);
            }
        });
        cmb_query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_queryActionPerformed(evt);
            }
        });

        b_get_details.setText("Get Details");
        b_get_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_get_detailsMouseClicked(evt);
            }
        });

        tf_query_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_query_idFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel2.setText("Details");

        b_view_consignments.setText("View all Consignments");
        b_view_consignments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_view_consignmentsActionPerformed(evt);
            }
        });

        b_view_trucks.setText("View all trucks");
        b_view_trucks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_view_trucksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_queriesLayout = new javax.swing.GroupLayout(p_queries);
        p_queries.setLayout(p_queriesLayout);
        p_queriesLayout.setHorizontalGroup(
            p_queriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_queriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_queriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(p_queriesLayout.createSequentialGroup()
                        .addComponent(cmb_query, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(p_queriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_query_id, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_get_details, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_queriesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(p_queriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_view_trucks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_view_consignments, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                .addContainerGap())
        );
        p_queriesLayout.setVerticalGroup(
            p_queriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_queriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_queriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_query, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_query_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_get_details)
                .addGap(20, 20, 20)
                .addComponent(b_view_trucks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_queriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(b_view_consignments))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        tp_manager.addTab("Queries", p_queries);

        p_company_statistics.setOpaque(false);

        l_truck_plate_number.setText("Truck Plate Number");

        b_get_truck_usage.setText("Get Truck Usage");
        b_get_truck_usage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_get_truck_usageMouseClicked(evt);
            }
        });

        cs_ta_tpn.setEditable(false);
        cs_ta_tpn.setColumns(20);
        cs_ta_tpn.setRows(5);
        jScrollPane1.setViewportView(cs_ta_tpn);

        jLabel3.setText("Branch");

        cmb_cs_b.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branch" }));
        cmb_cs_b.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb_cs_bFocusGained(evt);
            }
        });

        bg_company_stats.add(rb_atit);
        rb_atit.setText("Average Truck Idle Time");

        bg_company_stats.add(rb_acwt);
        rb_acwt.setText("Average Consigment Waiting Time");

        bg_company_stats.add(rb_bch);
        rb_bch.setText("Branch Consignment Handling");

        cs_ta_b.setEditable(false);
        cs_ta_b.setColumns(20);
        cs_ta_b.setRows(5);
        jScrollPane2.setViewportView(cs_ta_b);

        cs_query.setText("Query");
        cs_query.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cs_queryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout p_company_statisticsLayout = new javax.swing.GroupLayout(p_company_statistics);
        p_company_statistics.setLayout(p_company_statisticsLayout);
        p_company_statisticsLayout.setHorizontalGroup(
            p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(p_company_statisticsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_company_statisticsLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_company_statisticsLayout.createSequentialGroup()
                                .addComponent(cs_query, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 582, Short.MAX_VALUE))
                            .addGroup(p_company_statisticsLayout.createSequentialGroup()
                                .addGroup(p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb_bch)
                                    .addComponent(rb_atit)
                                    .addComponent(cmb_cs_b, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rb_acwt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2))))
                    .addGroup(p_company_statisticsLayout.createSequentialGroup()
                        .addComponent(l_truck_plate_number)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_get_truck_usage)
                            .addComponent(tf_truck_plate_num, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)))
                .addContainerGap())
        );
        p_company_statisticsLayout.setVerticalGroup(
            p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_company_statisticsLayout.createSequentialGroup()
                .addGroup(p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_company_statisticsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmb_cs_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(rb_atit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_acwt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_bch))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_company_statisticsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cs_query)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_company_statisticsLayout.createSequentialGroup()
                        .addGroup(p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_truck_plate_number)
                            .addComponent(tf_truck_plate_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_get_truck_usage))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp_manager.addTab("Company Statistics", p_company_statistics);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/protectedimage.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 150));
        jLabel1.setMinimumSize(new java.awt.Dimension(800, 150));
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 150));

        b_back.setText("Back");
        b_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tp_manager)
                .addGap(18, 18, 18)
                .addComponent(b_back)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_employee_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_employee_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_employee_nameActionPerformed

    private void b_view_applicatnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_view_applicatnsActionPerformed
//        try {
//            Statement stmt = head_office.getDatabase().getConnection().createStatement();
//            String query = "SELECT counter FROM ID_data WHERE name='login_counter'";
//            ResultSet rs2 = stmt.executeQuery(query);
//            rs2.next();
//            login_counter = rs2.getInt("counter");
//
//            Statement stmt2 = head_office.getDatabase().getConnection().createStatement();
//            String query2 = "SELECT list FROM Lists WHERE name='login'";
//            ResultSet rs1 = stmt2.executeQuery(query);
//            rs1.next();
//            ObjectInputStream o;
//            byte[] buf;
//            if (login_counter != 0) {
//
//                buf = rs1.getBytes("list");
//
//                o = new ObjectInputStream(new ByteArrayInputStream(buf));
//                login_list = (ArrayList<Login>) o.readObject();
//            } else {
//                login_list = new ArrayList<>();
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return;
        // TODO add your handling code here:
    }//GEN-LAST:event_b_view_applicatnsActionPerformed

    private void tf_plate_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_plate_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_plate_numberActionPerformed

    private void b_view_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_view_employeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_view_employeeActionPerformed

    private void tf_mbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_mbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_mbnActionPerformed

    private void b_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_backMouseClicked
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_backMouseClicked

    private void tf_employee_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_employee_nameFocusGained
        tf_employee_name.setText("");
    }//GEN-LAST:event_tf_employee_nameFocusGained

    private void tf_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_usernameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_usernameFocusLost

    private void tf_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_usernameFocusGained
        tf_username.setText("");
    }//GEN-LAST:event_tf_usernameFocusGained

    private void tf_set_ipFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_set_ipFocusGained
        tf_set_ip.setText("");
    }//GEN-LAST:event_tf_set_ipFocusGained

    private void cmb_queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_queryActionPerformed
        if (cmb_query.getSelectedIndex() == 0) {
            tf_query_id.setText("Consignment Id");
        } else if (cmb_query.getSelectedIndex() == 1) {
            tf_query_id.setText("Truck Id");
        }
    }//GEN-LAST:event_cmb_queryActionPerformed

    private void tf_query_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_query_idFocusGained
        tf_query_id.setText("");

    }//GEN-LAST:event_tf_query_idFocusGained

    private void b_set_ipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_set_ipMouseClicked
        String ip_add = tf_set_ip.getText();
        Database.setIPAddress(ip_add);
        try {
            Statement smt = head_office.getDatabase().getConnection().createStatement();
            smt.executeUpdate("UPDATE IP SET address='" + ip_add + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        tf_set_ip.setText("IP: " + Database.getIP_ADDRESS());
        // TODO add your handling code here:
    }//GEN-LAST:event_b_set_ipMouseClicked

    private void b_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_resetMouseClicked
        tf_mbn.setText("");
        tf_mc.setText("");
        tf_ma.setText("");
        tf_mun.setText("");
        tf_mp.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_b_resetMouseClicked

    private void b_mscvpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_mscvpMouseClicked
        String charge_text = tf_charge.getText();
        double charge;
        try {
            charge = Double.valueOf(charge_text);
            try {
                Statement stmt = head_office.getDatabase().getConnection().createStatement();
                String query = "UPDATE Charge SET value=" + charge;
                stmt.executeUpdate(query);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "There was some problem in updating to the database. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Consignment.setCharge_per_km(charge);
            //JOptionPane.showMessageDialog(this, "Value: " + Double.toString(Consignment.getCharge()) + "", "Success", 1);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid input for charge", "Error", 0);
            return;
        }

        tf_charge.setText("Current charge: " + Double.toString(Consignment.getCharge_per_km()));
        // TODO add your handling code here:
    }//GEN-LAST:event_b_mscvpMouseClicked

    private void b_add_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_add_branchMouseClicked
        String branch_name = tf_mbn.getText();
        if (branch_name.equals("")) {
            JOptionPane.showMessageDialog(this, "Branch Name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String contact = tf_mc.getText();
        if (contact.equals("")) {
            JOptionPane.showMessageDialog(this, "Contact cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String address = tf_ma.getText();
        if (address.equals("")) {
            JOptionPane.showMessageDialog(this, "Address cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String username = tf_mun.getText();
        if (username.equals("")) {
            JOptionPane.showMessageDialog(this, "Username cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String password = tf_mp.getText();
        if (password.equals("")) {
            JOptionPane.showMessageDialog(this, "Password cannot empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Database tempdb = new Database();
        tempdb.setUser(username);
        tempdb.setPassword(password);
        try {
            Branch nb = new Branch(++branch_counter, branch_name, new Address(contact, address), tempdb);
            Statement stmt = head_office.getDatabase().getConnection().createStatement();
            String query = "UPDATE ID_data SET counter=" + branch_counter + " WHERE name='branch_counter'";
            stmt.executeUpdate(query);
            branch_list.add(nb);
            String update = "UPDATE Lists SET list=? WHERE name='branch'";
            PreparedStatement pstmt = head_office.getDatabase().getConnection().prepareStatement(update);
            pstmt.setObject(1, branch_list);
            pstmt.executeUpdate();
            query = "CREATE USER '" + username + "'@'%' IDENTIFIED BY '" + password + "'";
            stmt.executeUpdate(query);
            query = "GRANT ALL PRIVILEGES ON tccs . * TO '" + username + "'@'%'";
            stmt.executeUpdate(query);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        b_resetMouseClicked(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_b_add_branchMouseClicked

    private void tf_truck_modelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_truck_modelFocusGained
        tf_truck_model.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_truck_modelFocusGained

    private void tf_plate_numberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_plate_numberFocusGained
        tf_plate_number.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_plate_numberFocusGained

    private void tf_costFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_costFocusGained
        tf_cost.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_costFocusGained

    private void cmb_branchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb_branchFocusGained
        List<String> s = new ArrayList<>();
        for (Branch branch : branch_list) {
            s.add(branch.getName());
        }
        cmb_branch.setModel(new javax.swing.DefaultComboBoxModel(s.toArray()));
        cmb_branch.showPopup();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_branchFocusGained

    private void cmb_cs_bFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb_cs_bFocusGained
        List<String> s = new ArrayList<>();
        for (Branch branch : branch_list) {
            s.add(branch.getName());
        }
        cmb_cs_b.setModel(new javax.swing.DefaultComboBoxModel(s.toArray()));
        cmb_cs_b.showPopup();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_cs_bFocusGained

    private void b_add_to_fleetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_add_to_fleetMouseClicked
        readDatabase();
        String branch_name;
        Double cost;
        String model;
        String plate_number;
        try {

            model = tf_truck_model.getText();
            if ("Truck Model".equals(model) || "".equals(model)) {
                throw new NullPointerException("Truck Model");
            }

            plate_number = tf_plate_number.getText();
            if ("Plate Number".equals(plate_number) || "".equals(plate_number)) {
                throw new NullPointerException("Plate Number");
            }

            cost = Double.valueOf(tf_cost.getText());
            branch_name = cmb_branch.getSelectedItem().toString();
            if ("Branch".equals(branch_name)) {
                throw new NullPointerException("Branch");
            }

        } catch (NullPointerException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Input " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Truck nt = new Truck(++truck_counter);
            nt.setModel(model);
            nt.setPlate_number(plate_number);
            nt.setCost(cost);
            Branch branch = null;
            for (ListIterator<Branch> branch_iter = branch_list.listIterator(); branch_iter.hasNext();) {
                branch = branch_iter.next();
                if (branch.getName().equals(branch_name)) {
                    nt.setCurrent_office(branch);
                    ArrayList<Truck> trucks = branch.getTruck_list();
                    trucks.add(nt);
                    branch.setTruck_list(trucks);
                    branch_iter.set(branch);
                    break;
                }
            }
            DefaultTableModel tb = (DefaultTableModel) table_truck_at_branch.getModel();
            tb.setRowCount(0);

            for (Truck truck : branch.getTruck_list()) {
                String destination = "None";

                Object[] rowData = new Object[]{truck.getPlate_number(), truck.getCurrent_office().getName(), truck.getStatus().toString()};
                tb.addRow(rowData);
            }
            Statement stmt = head_office.getDatabase().getConnection().createStatement();
            String query = "UPDATE ID_data SET counter=" + truck_counter + " WHERE name='truck_counter'";
            stmt.executeUpdate(query);
            truck_list.add(nt);
            String update = "UPDATE Lists SET list=? WHERE name='truck'";
            PreparedStatement pstmt = head_office.getDatabase().getConnection().prepareStatement(update);
            pstmt.setObject(1, truck_list);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Truck" + nt.getPlate_number() + "successfully added", "Truck added", 1);

            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writeToDatabase();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_b_add_to_fleetMouseClicked

    private void cmb_admin_accessFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb_admin_accessFocusGained
        List<String> s = new ArrayList<>();
        for (Branch branch : branch_list) {
            s.add(branch.getName());
        }
        cmb_admin_access.setModel(new javax.swing.DefaultComboBoxModel(s.toArray()));
        cmb_admin_access.showPopup();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_admin_accessFocusGained

    private void cmb_branch_listFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb_branch_listFocusGained
        List<String> s = new ArrayList<>();
        for (Branch branch : branch_list) {
            s.add(branch.getName());
        }
        cmb_branch_list.setModel(new javax.swing.DefaultComboBoxModel(s.toArray()));
        cmb_branch_list.showPopup();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_branch_listFocusGained

    private void b_get_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_get_detailsMouseClicked
        try {
            String id = tf_query_id.getText();
            int ID = Integer.valueOf(id);
            String query_about = cmb_query.getSelectedItem().toString();
            Statement smt = head_office.getDatabase().getConnection().createStatement();
            ObjectInputStream o;
            DefaultTableModel model = (DefaultTableModel) table_query.getModel();
            int rowCount;
            rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            if (query_about.equals("Consignment Details")) {
                String query = "SELECT * FROM ID_data WHERE name='consignment_counter'";
                ResultSet rs = smt.executeQuery(query);
                rs.next();
                consignment_counter = rs.getInt("counter");
                if (consignment_counter <= 0) {
                    JOptionPane.showMessageDialog(this, "Nothing to show", "Info", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } else {
                    query = "SELECT * FROM Lists WHERE name='consignment'";
                    smt = head_office.getDatabase().getConnection().createStatement();
                    rs = smt.executeQuery(query);
                    rs.next();
                    byte[] buf = rs.getBytes("list");
                    o = new ObjectInputStream(new ByteArrayInputStream(buf));
                    consignment_list = (ArrayList<Consignment>) o.readObject();
                    for (Consignment consignment : consignment_list) {
                        if (consignment.getConsignment_id() == ID) {
                            String truck_ids = "";
                            List<Truck> consignment_truck_list = consignment.getCarrier_trucks();
                            for (Truck truck : consignment_truck_list) {
                                truck_ids += Integer.toString(truck.getId()) + "\n";
                            }
                            model.addRow(new Object[]{truck_ids,
                                consignment.getFrom_branch().getName(),
                                consignment.getTo_branch().getName(),
                                consignment.getEntry_date()});
                        }
                    }
                }
            } else {
                if (query_about.equals("Truck Details")) {
                    String query = "SELECT * FROM ID_data WHERE name='truck_counter'";
                    ResultSet rs = smt.executeQuery(query);
                    rs.next();
                    truck_counter = rs.getInt("counter");
                    if (truck_counter <= 0) {
                        JOptionPane.showMessageDialog(this, "Nothing to show", "Info", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else {
                        query = "SELECT * FROM Lists WHERE name='truck'";
                        smt = head_office.getDatabase().getConnection().createStatement();
                        rs = smt.executeQuery(query);
                        rs.next();
                        byte[] buf = rs.getBytes("list");
                        o = new ObjectInputStream(new ByteArrayInputStream(buf));
                        truck_list = (ArrayList<Truck>) o.readObject();
                        //JOptionPane.showMessageDialog(this, truck_list, "Message", JOptionPane.INFORMATION_MESSAGE);
                        for (Truck truck : truck_list) {
                            if (truck.getId() == ID) {
                                String consignment_ids = "";
                                List<Consignment> truck_consignment_list = truck.getConsignment_list();
                                for (Consignment consignment : truck_consignment_list) {
                                    consignment_ids += Integer.toString(consignment.getConsignment_id()) + "\n";
                                }
                                String dest_name = "";
                                try {

                                    dest_name = truck.getDestination_office().getName();
                                } catch (NullPointerException ex) {

                                }
                                model.addRow(new Object[]{truck.getPlate_number(),
                                    consignment_ids,
                                    truck.getCurrent_office().getName(),
                                    dest_name,
                                    truck.getStatus().toString()});
                                break;
                            }

                        }
                    }
                }
            }
        } catch (NullPointerException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Trouble getting connection to database.\n Please check and try again", "Error", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Trouble reading data", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_b_get_detailsMouseClicked

    private void cmb_queryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_queryItemStateChanged
        DefaultTableModel model = (DefaultTableModel) table_query.getModel();

        if (cmb_query.getSelectedItem().toString().equals("Consignment Details")) {
            model = new DefaultTableModel(new Object[]{"Truck IDs", "From", "To", "Date of Dispatch"}, 1);
            table_query.setModel(model);
        } else {
            if (cmb_query.getSelectedItem().toString().equals("Truck Details")) {
                model = new DefaultTableModel(new Object[]{"Plate number", "Consignment ID(s)", "From", "To", "Status"}, 1);
                table_query.setModel(model);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_queryItemStateChanged

    private void cs_queryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cs_queryMouseClicked
        String branch_name = cmb_cs_b.getSelectedItem().toString();
        Branch selected_branch = null;
        if (branch_name.equals("Branch")) {
            JOptionPane.showMessageDialog(this, "Select a valid branch", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean atit, acwt, bch;
        atit = rb_atit.isSelected();
        acwt = rb_acwt.isSelected();
        bch = rb_bch.isSelected();
        cs_ta_b.setText("");
        for (Branch branch : branch_list) {
            if (branch.getName().equals(branch_name)) {
                selected_branch = branch;
                break;
            }
        }
        try {
            if (atit) {
                String result = "Average Truck Idle Time :\n";
                result += Long.toString(selected_branch.getTruck_avg_idle_time() / (1000 * 60 * 60));
                result += " Hrs";
                cs_ta_b.setText(result);
            } else {
                if (acwt) {
                    String result = "Average Consignment Wating Time :\n";
                    result += Long.toString(selected_branch.getAvgConsignmentWaitingTime() / (1000 * 60 * 60));
                    result += " Hrs";
                    cs_ta_b.setText(result);
                } else {
                    if (bch) {
                        String result = "The branch has handled ";
                        result += Long.toString(selected_branch.getCumulative_consignment_count());
                        result += " consignments and ";
                        result += Long.toString(selected_branch.getCumulative_truck_count());
                        result += " trucks so far.";
                        cs_ta_b.setText(result);
                    } else {
                        JOptionPane.showMessageDialog(this, "Please specify what to query.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (NullPointerException ex) {
            cs_ta_b.setText("This data doesn't exist for this particular Branch");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cs_queryMouseClicked

    private void b_get_truck_usageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_get_truck_usageMouseClicked
        cs_ta_tpn.setText("");
        String pn = tf_truck_plate_num.getText();
        if (pn.equals("")) {
            JOptionPane.showMessageDialog(this, "Please input a plate number", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Truck selected_truck = null;
        try {
            for (Truck truck : truck_list) {
                if (truck.getPlate_number().equals(pn)) {
                    selected_truck = truck;
                    break;
                }
            }
            if (selected_truck == null) {
                JOptionPane.showMessageDialog(this, "No such truck found", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            String result = "The truck with plate number " + selected_truck.getPlate_number() + " and ID " + selected_truck.getId() + " has run ";
            result += Integer.toString(selected_truck.getTotalKM());
            result += " kms.";
            cs_ta_tpn.setText(result);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "No truck found with the plate number", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_b_get_truck_usageMouseClicked

    private void tp_administrationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tp_administrationFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tp_administrationFocusGained

    private void AddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AddressFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_AddressFocusGained

    private void AddressComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AddressComponentShown

        try {
            Statement stmt1 = head_office.getDatabase().getConnection().createStatement();
            Statement stmt2 = head_office.getDatabase().getConnection().createStatement();

            String query1 = "SELECT * FROM IP";
            String query2 = "SELECT * FROM Charge";

            ResultSet rs1 = stmt1.executeQuery(query1);
            rs1.next();
            Database.setIPAddress(rs1.getString("address"));

            ResultSet rs2 = stmt2.executeQuery(query2);
            rs2.next();
            Consignment.setCharge_per_km(rs2.getDouble("value"));
        } catch (SQLException ex) {

        }

        tf_charge.setText("Current charge: " + Double.toString(Consignment.getCharge_per_km()));
        tf_set_ip.setText("IP: " + Database.getIP_ADDRESS());


    }//GEN-LAST:event_AddressComponentShown

    private void tf_chargeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_chargeMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_tf_chargeMouseClicked

    private void tf_chargeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_chargeFocusGained
        tf_charge.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_chargeFocusGained

    private void tf_chargeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_chargeFocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_tf_chargeFocusLost

    private void tf_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_passwordFocusGained
        tf_password.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_passwordFocusGained

    private void tf_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_passwordFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_passwordFocusLost

    private void p_queriesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_p_queriesComponentShown
        try {
            Statement stmt = head_office.getDatabase().getConnection().createStatement();
            Statement stmt2 = head_office.getDatabase().getConnection().createStatement();
            Statement stmt3 = db.getConnection().createStatement();
            Statement stmt4 = db.getConnection().createStatement();

            String query = "SELECT * from Lists";
            String query2 = "SELECT * from ID_data";

            ResultSet rs1 = stmt.executeQuery(query);
            ResultSet rs2 = stmt2.executeQuery(query2);

            String query3 = "SELECT * FROM IP";
            ResultSet rs3 = stmt3.executeQuery(query3);
            rs3.next();
            Database.setIPAddress(rs3.getString("address"));

            String query4 = "SELECT * FROM Charge";
            ResultSet rs4 = stmt4.executeQuery(query4);
            rs4.next();
            Consignment.setCharge_per_km(rs4.getDouble("value"));

            List<byte[]> buf = new ArrayList<>();
            ObjectInputStream o;

            rs2.next();
            head_counter = rs2.getInt("counter");
            int temp = 0;
            while (rs1.next()) {
                buf.add(rs1.getBytes("list"));
            }
            if (head_counter != 0) {
                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                head_office = (HeadOffice) o.readObject();
            } else {
                head_office = new HeadOffice("transporters", new Address("9641183277", "LBS IITKGP"));
                String update = "UPDATE Lists SET list=? WHERE name='head_office'";
                PreparedStatement pstmt = db.getConnection().prepareStatement(update);
                pstmt.setObject(1, head_office);
                pstmt.executeUpdate();
                stmt.executeUpdate("UPDATE ID_data SET counter=1 WHERE name='head_counter'");
            }

            rs2.next();
            branch_counter = rs2.getInt("counter");
            //rs.next();
            if (branch_counter != 0) {
                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                branch_list = (ArrayList<Branch>) o.readObject();
            } else {
                branch_list = new ArrayList<>();
            }

            rs2.next();
            truck_counter = rs2.getInt("counter");
            //rs.next();
            if (truck_counter != 0) {

                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                truck_list = (ArrayList<Truck>) o.readObject();
            } else {
                truck_list = new ArrayList<>();
            }

            rs2.next();
            consignment_counter = rs2.getInt("counter");
            //rs.next();
            if (consignment_counter != 0) {

                //buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
                consignment_list = (ArrayList<Consignment>) o.readObject();
            } else {
                consignment_list = new ArrayList<>();
            }

//            rs2.next();
//            login_counter = rs2.getInt("counter");
//            //rs.next();
//            if (login_counter > 0) {
//
//                //buf = rs.getBytes("list");
//                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
//                login_list = (ArrayList<Login>) o.readObject();
//            } else {
//                login_list = new ArrayList<>();
//            }
            rs1.close();
            rs2.close();
            rs3.close();
            rs4.close();
        } catch (SQLException | IOException | ClassNotFoundException ex) {//SQLException | IOException | ClassNotFoundException
            //java.lang.System.out.println("What");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_p_queriesComponentShown

    private void b_hireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_hireActionPerformed

        try {
            Login login = new Login();

            Branch login_branch = null;
            String branch_name = cmb_branch_list.getSelectedItem().toString();
            if (branch_name.equals("")) {
                throw new Exception("Please select branch");
            }
            for (Branch branch_list_item : branch_list) {
                if (branch_list_item.getName().equals(branch_name)) {
                    login_branch = branch_list_item;
                }
            }
            String name = null;
            name = tf_employee_name.getText();
            if (name.equals("")) {
                throw new Exception("Enter employee name");
            }
            String login_id = null;
            login_id = tf_username.getText();
            if (login_id.equals("")) {
                throw new Exception("Enter username");
            }
            String password = null;
            password = tf_password.getText();
            if (password.equals("")) {
                throw new Exception("Enter password");
            }
            login.setBranch(login_branch);
            login.setName(name);
            login.setPassword(password);
            login.setLogin_id(login_id);
            login_counter++;
            login_list.add(login);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
        try {
            Statement stmt5 = head_office.getDatabase().getConnection().createStatement();
            String query5 = "UPDATE ID_data SET counter=" + login_counter + " WHERE name='login_counter'";
            stmt5.executeUpdate(query5);
            String update5 = "UPDATE Lists SET list=? WHERE name='login'";
            PreparedStatement pstmt5 = head_office.getDatabase().getConnection().prepareStatement(update5);
            pstmt5.setObject(1, login_list);
            pstmt5.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database could not be updated", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_b_hireActionPerformed

    private void b_view_applicatnsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_view_applicatnsMouseClicked
        readDatabase();
        try {
            String branch_name = cmb_admin_access.getSelectedItem().toString();
            Branch selected_branch = null;
            DefaultTableModel model = (DefaultTableModel) admin_access_table.getModel();
            int rowCount;
            rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            if (branch_name.equals("Branch")) {
                JOptionPane.showMessageDialog(this, "Select a valid branch", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                for (Branch branch : branch_list) {
                    if (branch.getName().equals(branch_name)) {
                        selected_branch = branch;
                        break;
                    }
                }
            }
            //JOptionPane.showMessageDialog(this, selected_branch.getName(), "info", JOptionPane.INFORMATION_MESSAGE);
//            Statement stmt = head_office.getDatabase().getConnection().createStatement();
//            String query = "SELECT * FROM ID_data WHERE name='login_counter'";
//
//            ResultSet rs1 = stmt.executeQuery(query);
//
//            rs1.next();
//            login_counter = rs1.getInt("counter");
//
//            if (login_counter > 0) {
//                ObjectInputStream o;
//                
//                Statement stmt2 = head_office.getDatabase().getConnection().createStatement();
//                String query2 = "SELECT * FROM Lists WHERE name='login'";
//                ResultSet rs2 = stmt2.executeQuery(query);
//                //rs2.next();
//
//                byte[] buf = rs2.getBytes("list");
//
//                o = new ObjectInputStream(new ByteArrayInputStream(buf));
//                login_list = (ArrayList<Login>) o.readObject();
//            } else {
//                login_list = new ArrayList<>();
//            }
            if (login_list.isEmpty()) {
                JOptionPane.showMessageDialog(this, "List Empty", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                for (Login login : login_list) {
                    if (selected_branch != null) {
                        if (login.getBranchName().equals(selected_branch.getName())) {
                            model.addRow(new Object[]{login.getName(), login.getLogin_id(), login.getPassword()});
                        }
                    }else{
                        throw new Exception("Select a branch");
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_b_view_applicatnsMouseClicked

    private void b_remove_accessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_remove_accessMouseClicked
        readDatabase();
        DefaultTableModel model = (DefaultTableModel) admin_access_table.getModel();
        int index = admin_access_table.getSelectedRow();
        String id = model.getValueAt(index, 1).toString();
        String name = model.getValueAt(index, 0).toString();
        for (Login login : login_list) {
            if (login.getLogin_id().equals(id) && login.getName().equals(name)) {
                login_list.remove(login);
                break;
            }
        }
        try {
            String update = "UPDATE Lists SET list=? WHERE name='login'";
            PreparedStatement pstmt = head_office.getDatabase().getConnection().prepareStatement(update);
            pstmt.setObject(1, login_list);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database could not be updated", "Error", JOptionPane.ERROR_MESSAGE);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_b_remove_accessMouseClicked

    private void b_add_to_fleetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_add_to_fleetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_add_to_fleetActionPerformed

    private void b_view_consignmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_view_consignmentsActionPerformed
        readDatabase();
        DefaultTableModel tb = (DefaultTableModel) table_query.getModel();
        tb.setRowCount(0);
        tb = new DefaultTableModel(new Object[]{"Consignment ID(s)", "Destination", "Source", "Status"}, 1);
        table_query.setModel(tb);
        tb.setRowCount(0);
        for (Consignment consignment : consignment_list) {
            Object[] rowData = new Object[]{consignment.getConsignment_id(), consignment.getTo_branch().getName(), consignment.getFrom_branch().getName(), consignment.getStatus_delivery().toString()};
            tb.addRow(rowData);
        }
    }//GEN-LAST:event_b_view_consignmentsActionPerformed

    private void b_add_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_add_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_add_branchActionPerformed

    private void b_view_trucksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_view_trucksActionPerformed
        readDatabase();
        DefaultTableModel tb = (DefaultTableModel) table_query.getModel();
        tb.setRowCount(0);
        tb = new DefaultTableModel(new Object[]{"Truck Plate number(s)", "Current office", "Destination office", "Status"}, 1);
        table_query.setModel(tb);
        tb.setRowCount(0);
        for (Truck truck : truck_list) {
            String destination = "None";
            if (!(truck.getDestination_office() == null)) {
                destination = truck.getDestination_office().getName();
            }
            Object[] rowData = new Object[]{truck.getPlate_number(), truck.getCurrent_office().getName(), destination, truck.getStatus().toString()};
            tb.addRow(rowData);
        }
    }//GEN-LAST:event_b_view_trucksActionPerformed
    public void writeToDatabase() {
        try {
            Statement stmt1 = head_office.getDatabase().getConnection().createStatement();
            Statement stmt2 = head_office.getDatabase().getConnection().createStatement();
            Statement stmt3 = head_office.getDatabase().getConnection().createStatement();
            Statement stmt4 = head_office.getDatabase().getConnection().createStatement();

            String query1 = "UPDATE ID_data SET counter=" + head_counter + " WHERE name='head_counter'";
            stmt1.executeUpdate(query1);
            String query2 = "UPDATE ID_data SET counter=" + branch_counter + " WHERE name='branch_counter'";
            stmt2.executeUpdate(query2);
            String query3 = "UPDATE ID_data SET counter=" + truck_counter + " WHERE name='truck_counter'";
            stmt3.executeUpdate(query3);
            String query4 = "UPDATE ID_data SET counter=" + consignment_counter + " WHERE name='consignment_counter'";
            stmt4.executeUpdate(query4);

            String update = "UPDATE Lists SET list=? WHERE name='head_office'";
            PreparedStatement pstmt = head_office.getDatabase().getConnection().prepareStatement(update);
            pstmt.setObject(1, head_office);
            pstmt.executeUpdate();

            String update2 = "UPDATE Lists SET list=? WHERE name='branch'";
            PreparedStatement pstmt2 = head_office.getDatabase().getConnection().prepareStatement(update2);
            pstmt2.setObject(1, branch_list);
            pstmt2.executeUpdate();

            String update3 = "UPDATE Lists SET list=? WHERE name='truck'";
            PreparedStatement pstmt3 = head_office.getDatabase().getConnection().prepareStatement(update3);
            pstmt3.setObject(1, truck_list);
            pstmt3.executeUpdate();

            String update4 = "UPDATE Lists SET list=? WHERE name='consignment'";
            PreparedStatement pstmt4 = head_office.getDatabase().getConnection().prepareStatement(update4);
            pstmt4.setObject(1, consignment_list);
            pstmt4.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Address;
    private javax.swing.JTable admin_access_table;
    private javax.swing.JButton b_add_branch;
    private javax.swing.JButton b_add_to_fleet;
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_fire;
    private javax.swing.JButton b_get_details;
    private javax.swing.JButton b_get_truck_usage;
    private javax.swing.JButton b_hire;
    private javax.swing.JButton b_mscvp;
    private javax.swing.JButton b_remove_access;
    private javax.swing.JButton b_reset;
    private javax.swing.JButton b_set_ip;
    private javax.swing.JButton b_view_applicatns;
    private javax.swing.JButton b_view_consignments;
    private javax.swing.JButton b_view_employee;
    private javax.swing.JButton b_view_trucks;
    private javax.swing.ButtonGroup bg_company_stats;
    private javax.swing.JComboBox cmb_admin_access;
    private javax.swing.JComboBox cmb_branch;
    private javax.swing.JComboBox cmb_branch_list;
    private javax.swing.JComboBox cmb_cs_b;
    private javax.swing.JComboBox cmb_query;
    private javax.swing.JButton cs_query;
    private javax.swing.JTextArea cs_ta_b;
    private javax.swing.JTextArea cs_ta_tpn;
    private javax.swing.JInternalFrame if_employee_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel l_address;
    private javax.swing.JLabel l_branch;
    private javax.swing.JLabel l_branch_name;
    private javax.swing.JLabel l_contact;
    private javax.swing.JLabel l_cost;
    private javax.swing.JLabel l_employee_address;
    private javax.swing.JLabel l_employee_id;
    private javax.swing.JLabel l_employee_name;
    private javax.swing.JLabel l_fire_reason;
    private javax.swing.JLabel l_model;
    private javax.swing.JLabel l_password;
    private javax.swing.JLabel l_plate_number;
    private javax.swing.JLabel l_set_ip;
    private javax.swing.JLabel l_truck_plate_number;
    private javax.swing.JLabel l_user_name;
    private javax.swing.JPanel p_administration;
    private javax.swing.JPanel p_buy_truck;
    private javax.swing.JPanel p_company_statistics;
    private javax.swing.JPanel p_fire;
    private javax.swing.JPanel p_hire;
    private javax.swing.JPanel p_queries;
    private javax.swing.JRadioButton rb_acwt;
    private javax.swing.JRadioButton rb_atit;
    private javax.swing.JRadioButton rb_bch;
    private javax.swing.JTable table_query;
    private javax.swing.JTable table_truck_at_branch;
    private javax.swing.JTextField tf_charge;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_employee_id;
    private javax.swing.JTextField tf_employee_name;
    private javax.swing.JTextField tf_fire_reason;
    private javax.swing.JTextArea tf_ma;
    private javax.swing.JTextField tf_mbn;
    private javax.swing.JTextField tf_mc;
    private javax.swing.JTextField tf_mp;
    private javax.swing.JTextField tf_mun;
    private javax.swing.JTextField tf_password;
    private javax.swing.JTextField tf_plate_number;
    private javax.swing.JTextField tf_query_id;
    private javax.swing.JTextField tf_set_ip;
    private javax.swing.JTextField tf_truck_model;
    private javax.swing.JTextField tf_truck_plate_num;
    private javax.swing.JTextField tf_username;
    private javax.swing.JTabbedPane tp_administration;
    private javax.swing.JTabbedPane tp_manager;
    // End of variables declaration//GEN-END:variables

}
