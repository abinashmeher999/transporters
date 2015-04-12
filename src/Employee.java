
import com.transporters.Address;
import com.transporters.Branch;
import com.transporters.Consignment;
import com.transporters.Database;
import com.transporters.HeadOffice;
import com.transporters.Office;
import com.transporters.Truck;
import java.awt.HeadlessException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
public class Employee extends javax.swing.JFrame {

    int branch_id;
    Branch current_branch;
    Database db;
    HeadOffice head_office;
    List<Branch> branch_list;
    List<Truck> truck_list;
    List<Consignment> consignment_list;

    int head_counter;
    int branch_counter;
    int truck_counter;
    int consignment_counter;

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
            rs1.close();
            rs2.close();
            rs3.close();
            rs4.close();
        } catch (SQLException | IOException | ClassNotFoundException ex) {//SQLException | IOException | ClassNotFoundException
            //java.lang.System.out.println("What");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeToDatabase() {
        try {
            Statement stmt1 = current_branch.getDatabase().getConnection().createStatement();

            String query1 = "UPDATE ID_data SET counter=" + head_counter + " WHERE name='head_counter'";
            stmt1.executeUpdate(query1);
            query1 = "UPDATE ID_data SET counter=" + branch_counter + " WHERE name='branch_counter'";
            stmt1.executeUpdate(query1);
            query1 = "UPDATE ID_data SET counter=" + truck_counter + " WHERE name='truck_counter'";
            stmt1.executeUpdate(query1);
            query1 = "UPDATE ID_data SET counter=" + consignment_counter + " WHERE name='consignment_counter'";
            stmt1.executeUpdate(query1);

            String update = "UPDATE Lists SET list=? WHERE name='head_office'";
            PreparedStatement pstmt = current_branch.getDatabase().getConnection().prepareStatement(update);
            pstmt.setObject(1, head_office);
            pstmt.executeUpdate();

            String update2 = "UPDATE Lists SET list=? WHERE name='branch'";
            PreparedStatement pstmt2 = current_branch.getDatabase().getConnection().prepareStatement(update);
            pstmt2.setObject(1, branch_list);
            pstmt2.executeUpdate();

            String update3 = "UPDATE Lists SET list=? WHERE name='truck'";
            PreparedStatement pstmt3 = current_branch.getDatabase().getConnection().prepareStatement(update);
            pstmt3.setObject(1, truck_list);
            pstmt3.executeUpdate();

            String update4 = "UPDATE Lists SET list=? WHERE name='consignment'";
            PreparedStatement pstmt4 = current_branch.getDatabase().getConnection().prepareStatement(update);
            pstmt4.setObject(1, consignment_list);
            pstmt4.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    /**
     * Creates new form Employee
     */
    public Employee(int id) {
        branch_id = id;
        initComponents();
        try {
            Database.setIPAddress("localhost");
            db = new Database();
            db.setUrl(Database.getBranchURL());
            db.setUser("root");
            db.setPassword("alsk");
            Statement stmt = db.getConnection().createStatement();
            Statement stmt2 = db.getConnection().createStatement();
            String query = "SELECT * FROM Lists";
            ResultSet rs = stmt.executeQuery(query);
            byte[] buf;
            ObjectInputStream o;

            String query2 = "SELECT * FROM ID_data";
            ResultSet rs2 = stmt2.executeQuery(query2);

            rs2.next();
            head_counter = rs2.getInt("counter");
            rs.next();
            if (head_counter != 0) {
                buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf));
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
            rs.next();
            if (branch_counter != 0) {
                buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf));
                branch_list = (ArrayList<Branch>) o.readObject();
            } else {
                branch_list = new ArrayList<>();
            }

            rs2.next();
            truck_counter = rs2.getInt("counter");
            rs.next();
            if (truck_counter != 0) {
                buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf));
                truck_list = (ArrayList<Truck>) o.readObject();
            } else {
                truck_list = new ArrayList<>();
            }

            rs2.next();
            consignment_counter = rs2.getInt("counter");
            rs.next();
            if (consignment_counter != 0) {

                buf = rs.getBytes("list");
                o = new ObjectInputStream(new ByteArrayInputStream(buf));
                consignment_list = (ArrayList<Consignment>) o.readObject();
            } else {
                consignment_list = new ArrayList<>();
            }
            rs.close();
            rs2.close();
        } catch (SQLException | IOException | ClassNotFoundException ex) {//SQLException | IOException | ClassNotFoundException
            java.lang.System.out.println("What");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Branch branch : branch_list) {
            if (branch.getId() == branch_id) {
                current_branch = branch;
                break;
            }
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
        java.awt.GridBagConstraints gridBagConstraints;

        bg_delievery_type = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        p_employee = new javax.swing.JPanel();
        tp_employee = new javax.swing.JTabbedPane();
        p_distpatch = new javax.swing.JPanel();
        l_dispatch_truck_plate_num = new javax.swing.JLabel();
        tf_dispatch = new javax.swing.JTextField();
        b_dispatch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_dispatch_details = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        b_show_dispatchable_trucks = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_dispatchable_trucks = new javax.swing.JTable();
        p_receive = new javax.swing.JPanel();
        l_receive_truck_plate_num = new javax.swing.JLabel();
        tf_receive_truck_plate_num = new javax.swing.JTextField();
        b_receive_truck = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_consignment_id = new javax.swing.JTable();
        b_waiting_trucks_list = new javax.swing.JButton();
        l_waiting_trucks_or_consignment_id = new javax.swing.JLabel();
        p_new_consignment = new javax.swing.JPanel();
        tp_new_consignment = new javax.swing.JTabbedPane();
        p_general = new javax.swing.JPanel();
        l_volume = new javax.swing.JLabel();
        tf_volume = new javax.swing.JTextField();
        l_pieces = new javax.swing.JLabel();
        tf_pieces = new javax.swing.JTextField();
        rb_regular_delievery = new javax.swing.JRadioButton();
        rb_express_delievery = new javax.swing.JRadioButton();
        cmb_to_branch = new javax.swing.JComboBox();
        l_to_branch = new javax.swing.JLabel();
        p_sender = new javax.swing.JPanel();
        l_sender_name = new javax.swing.JLabel();
        l_sender_address = new javax.swing.JLabel();
        l_sender_contact = new javax.swing.JLabel();
        tf_sender_name = new javax.swing.JTextField();
        tf_sender_contact = new javax.swing.JTextField();
        tf_sender_address = new javax.swing.JTextField();
        p_receiver = new javax.swing.JPanel();
        l_reciever_name = new javax.swing.JLabel();
        l_receiver_contact = new javax.swing.JLabel();
        l_receiver_address = new javax.swing.JLabel();
        tf_receiver_name = new javax.swing.JTextField();
        tf_receiver_contact = new javax.swing.JTextField();
        tf_receiver_address = new javax.swing.JTextField();
        p_billing = new javax.swing.JPanel();
        b_bill_to_receiver = new javax.swing.JButton();
        l_billing_address = new javax.swing.JLabel();
        tf_billing_address = new javax.swing.JTextField();
        l_billing_name = new javax.swing.JLabel();
        l_billing_contact = new javax.swing.JLabel();
        tf_billing_name = new javax.swing.JTextField();
        tf_billing_contact = new javax.swing.JTextField();
        sp_billing_details = new javax.swing.JScrollPane();
        ta_billing_details = new javax.swing.JTextArea();
        b_generate_bill = new javax.swing.JButton();
        b_back = new javax.swing.JButton();
        b_refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        p_employee.setOpaque(false);

        tp_employee.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        l_dispatch_truck_plate_num.setText("Truck Plate Number");

        b_dispatch.setText("Dispatch Truck");
        b_dispatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_dispatchMouseClicked(evt);
            }
        });
        b_dispatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_dispatchActionPerformed(evt);
            }
        });

        ta_dispatch_details.setEditable(false);
        ta_dispatch_details.setColumns(20);
        ta_dispatch_details.setRows(5);
        jScrollPane1.setViewportView(ta_dispatch_details);

        jLabel7.setText("Dispatch Details");

        b_show_dispatchable_trucks.setText("Show Dispatchable Trucks");
        b_show_dispatchable_trucks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_show_dispatchable_trucksMouseClicked(evt);
            }
        });
        b_show_dispatchable_trucks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_show_dispatchable_trucksActionPerformed(evt);
            }
        });

        table_dispatchable_trucks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Truck Plate No.", "Destination"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table_dispatchable_trucks);

        javax.swing.GroupLayout p_distpatchLayout = new javax.swing.GroupLayout(p_distpatch);
        p_distpatch.setLayout(p_distpatchLayout);
        p_distpatchLayout.setHorizontalGroup(
            p_distpatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_distpatchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_distpatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_distpatchLayout.createSequentialGroup()
                        .addGroup(p_distpatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_distpatchLayout.createSequentialGroup()
                                .addComponent(l_dispatch_truck_plate_num)
                                .addGap(18, 18, 18)
                                .addGroup(p_distpatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b_dispatch)
                                    .addComponent(tf_dispatch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(b_show_dispatchable_trucks))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(p_distpatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        p_distpatchLayout.setVerticalGroup(
            p_distpatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_distpatchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_distpatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_distpatchLayout.createSequentialGroup()
                        .addGroup(p_distpatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_dispatch_truck_plate_num)
                            .addComponent(tf_dispatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_dispatch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_show_dispatchable_trucks))
                    .addGroup(p_distpatchLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(377, 377, 377))
        );

        tp_employee.addTab("Dispatch Truck", p_distpatch);

        l_receive_truck_plate_num.setText("Truck Plate Number");

        tf_receive_truck_plate_num.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_receive_truck_plate_numFocusGained(evt);
            }
        });

        b_receive_truck.setText("Receive Truck");
        b_receive_truck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_receive_truckMouseClicked(evt);
            }
        });
        b_receive_truck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_receive_truckActionPerformed(evt);
            }
        });

        table_consignment_id.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Consignement Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_consignment_id);

        b_waiting_trucks_list.setText("Get Waiting Trucks List");
        b_waiting_trucks_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_waiting_trucks_listActionPerformed(evt);
            }
        });

        l_waiting_trucks_or_consignment_id.setText("Waiting Trucks");

        javax.swing.GroupLayout p_receiveLayout = new javax.swing.GroupLayout(p_receive);
        p_receive.setLayout(p_receiveLayout);
        p_receiveLayout.setHorizontalGroup(
            p_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_receiveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_receiveLayout.createSequentialGroup()
                        .addComponent(l_receive_truck_plate_num)
                        .addGap(18, 18, 18)
                        .addGroup(p_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_receive_truck, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_receive_truck_plate_num, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 292, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_receiveLayout.createSequentialGroup()
                        .addComponent(l_waiting_trucks_or_consignment_id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_waiting_trucks_list)))
                .addContainerGap())
            .addGroup(p_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p_receiveLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        p_receiveLayout.setVerticalGroup(
            p_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_receiveLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(p_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_receive_truck_plate_num)
                    .addComponent(tf_receive_truck_plate_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_receive_truck)
                .addGap(18, 18, 18)
                .addGroup(p_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_waiting_trucks_list)
                    .addComponent(l_waiting_trucks_or_consignment_id))
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(p_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p_receiveLayout.createSequentialGroup()
                    .addGap(127, 127, 127)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        tp_employee.addTab("Receive Truck", p_receive);

        l_volume.setText("Total Volume");

        tf_volume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_volumeActionPerformed(evt);
            }
        });

        l_pieces.setText("Pieces");

        bg_delievery_type.add(rb_regular_delievery);
        rb_regular_delievery.setText("Regular Delivery");

        bg_delievery_type.add(rb_express_delievery);
        rb_express_delievery.setText("Express Delivery");
        rb_express_delievery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_express_delieveryActionPerformed(evt);
            }
        });

        cmb_to_branch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branch" }));
        cmb_to_branch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb_to_branchFocusGained(evt);
            }
        });

        l_to_branch.setText("To Branch");

        javax.swing.GroupLayout p_generalLayout = new javax.swing.GroupLayout(p_general);
        p_general.setLayout(p_generalLayout);
        p_generalLayout.setHorizontalGroup(
            p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_generalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_generalLayout.createSequentialGroup()
                        .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_volume)
                            .addComponent(l_pieces))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_volume, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_pieces, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_generalLayout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addComponent(rb_regular_delievery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_express_delievery))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_generalLayout.createSequentialGroup()
                        .addComponent(l_to_branch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmb_to_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        p_generalLayout.setVerticalGroup(
            p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_generalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_volume)
                    .addComponent(tf_volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_pieces)
                    .addComponent(tf_pieces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_express_delievery)
                    .addComponent(rb_regular_delievery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_to_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_to_branch))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tp_new_consignment.addTab("General", p_general);

        l_sender_name.setText("Name");

        l_sender_address.setText("Address");

        l_sender_contact.setText("Contact");

        javax.swing.GroupLayout p_senderLayout = new javax.swing.GroupLayout(p_sender);
        p_sender.setLayout(p_senderLayout);
        p_senderLayout.setHorizontalGroup(
            p_senderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_senderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_senderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_senderLayout.createSequentialGroup()
                        .addGroup(p_senderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_sender_name)
                            .addComponent(l_sender_address))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(p_senderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_sender_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_sender_address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(p_senderLayout.createSequentialGroup()
                        .addComponent(l_sender_contact)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_sender_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        p_senderLayout.setVerticalGroup(
            p_senderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_senderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_senderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_sender_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_sender_name))
                .addGap(7, 7, 7)
                .addGroup(p_senderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_sender_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_sender_contact))
                .addGap(7, 7, 7)
                .addGroup(p_senderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_senderLayout.createSequentialGroup()
                        .addComponent(l_sender_address)
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addComponent(tf_sender_address))
                .addContainerGap())
        );

        tp_new_consignment.addTab("Sender", p_sender);

        l_reciever_name.setText("Name");

        l_receiver_contact.setText("Contact");

        l_receiver_address.setText("Address");

        javax.swing.GroupLayout p_receiverLayout = new javax.swing.GroupLayout(p_receiver);
        p_receiver.setLayout(p_receiverLayout);
        p_receiverLayout.setHorizontalGroup(
            p_receiverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_receiverLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_receiverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_receiver_contact)
                    .addComponent(l_receiver_address)
                    .addComponent(l_reciever_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(p_receiverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_receiver_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_receiver_contact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_receiver_address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        p_receiverLayout.setVerticalGroup(
            p_receiverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_receiverLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_receiverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_receiver_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_reciever_name))
                .addGap(7, 7, 7)
                .addGroup(p_receiverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_receiver_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_receiver_contact))
                .addGap(7, 7, 7)
                .addGroup(p_receiverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_receiverLayout.createSequentialGroup()
                        .addComponent(l_receiver_address)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tf_receiver_address, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addContainerGap())
        );

        tp_new_consignment.addTab("Receiver", p_receiver);

        b_bill_to_receiver.setText("Bill to Receiver");
        b_bill_to_receiver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_bill_to_receiverMouseClicked(evt);
            }
        });

        l_billing_address.setText("Address");

        l_billing_name.setText("Name");

        l_billing_contact.setText("Contact");

        javax.swing.GroupLayout p_billingLayout = new javax.swing.GroupLayout(p_billing);
        p_billing.setLayout(p_billingLayout);
        p_billingLayout.setHorizontalGroup(
            p_billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_billingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_billingLayout.createSequentialGroup()
                        .addGroup(p_billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_billing_address)
                            .addComponent(l_billing_name)
                            .addComponent(l_billing_contact))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(p_billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_billing_name)
                            .addComponent(tf_billing_address, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(tf_billing_contact)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_billingLayout.createSequentialGroup()
                        .addGap(0, 182, Short.MAX_VALUE)
                        .addComponent(b_bill_to_receiver)))
                .addContainerGap())
        );
        p_billingLayout.setVerticalGroup(
            p_billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_billingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_billing_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_billing_name))
                .addGap(7, 7, 7)
                .addGroup(p_billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_billing_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_billing_contact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(p_billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_billing_address, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_billing_address))
                .addGap(5, 5, 5)
                .addComponent(b_bill_to_receiver))
        );

        tp_new_consignment.addTab("Billing Address", p_billing);

        ta_billing_details.setEditable(false);
        ta_billing_details.setColumns(20);
        ta_billing_details.setRows(5);
        sp_billing_details.setViewportView(ta_billing_details);

        b_generate_bill.setText("Generate Bill");
        b_generate_bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_generate_billMouseClicked(evt);
            }
        });
        b_generate_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_generate_billActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_new_consignmentLayout = new javax.swing.GroupLayout(p_new_consignment);
        p_new_consignment.setLayout(p_new_consignmentLayout);
        p_new_consignmentLayout.setHorizontalGroup(
            p_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_new_consignmentLayout.createSequentialGroup()
                .addComponent(tp_new_consignment, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(p_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_billing_details, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addGroup(p_new_consignmentLayout.createSequentialGroup()
                        .addComponent(b_generate_bill)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        p_new_consignmentLayout.setVerticalGroup(
            p_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_new_consignmentLayout.createSequentialGroup()
                .addGroup(p_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, p_new_consignmentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(b_generate_bill)
                        .addGap(2, 2, 2)
                        .addComponent(sp_billing_details))
                    .addComponent(tp_new_consignment, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        tp_employee.addTab("New Consignment", p_new_consignment);

        b_back.setText("Back");
        b_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_backMouseClicked(evt);
            }
        });

        b_refresh.setText("Refresh");
        b_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_employeeLayout = new javax.swing.GroupLayout(p_employee);
        p_employee.setLayout(p_employeeLayout);
        p_employeeLayout.setHorizontalGroup(
            p_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_employee)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_employeeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        p_employeeLayout.setVerticalGroup(
            p_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_employeeLayout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(tp_employee, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(p_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_back)
                    .addComponent(b_refresh))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(p_employee, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/protectedimage.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 150));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jLabel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_backMouseClicked
        //Save data in database
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_backMouseClicked

    private void rb_express_delieveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_express_delieveryActionPerformed

    }//GEN-LAST:event_rb_express_delieveryActionPerformed

    private void b_bill_to_receiverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_bill_to_receiverMouseClicked
        try {
            if (tf_receiver_name.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Enter receiver's name", "Error", 0);
            } else {
                tf_billing_name.setText(tf_receiver_name.getText().trim());
            }
            if (tf_receiver_address.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Enter receiver's address", "Error", 0);
            } else {
                tf_billing_address.setText(tf_receiver_address.getText().trim());
            }
            if (tf_receiver_contact.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Enter receiver's contact", "Error", 0);
            } else {
                tf_billing_contact.setText(tf_receiver_contact.getText().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error in receiver's details", "Error", 0);
        }
    }//GEN-LAST:event_b_bill_to_receiverMouseClicked

    private void b_generate_billMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_generate_billMouseClicked

    }//GEN-LAST:event_b_generate_billMouseClicked

    private void tf_volumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_volumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_volumeActionPerformed

    private void b_receive_truckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_receive_truckMouseClicked
        // TODO Check for plate number here;

    }//GEN-LAST:event_b_receive_truckMouseClicked

    private void b_receive_truckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_receive_truckActionPerformed
        readDatabase();
        l_waiting_trucks_or_consignment_id.setText("Consignments in the truck");
        DefaultTableModel tb = (DefaultTableModel) table_consignment_id.getModel();

        tb.setRowCount(0);
        boolean flag = false;
        Branch curr_branch = null;
        try {
            for (Branch branch : branch_list) {
                if (branch.getId() == branch_id) {
                    curr_branch = branch;
                }
            }
            if (curr_branch == null) {
                throw new Exception("No branch with this branch id");
            }

            String plate_num = null;
            if (tf_receive_truck_plate_num.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Provide Plate number", "Error", 0);
            } else {
                for (Truck truck : truck_list) {
                    if (plate_num.equals(truck.getPlate_number())) {
                        flag = true;
                        if (truck.getCurrent_office().equals(curr_branch)) {
                            if (truck.getStatus() == Truck.Status.ENROUTE) {
                                tb = new DefaultTableModel(new Object[]{"Consignment ID(s)"}, 1);
                                table_consignment_id.setModel(tb);
                                tb.setRowCount(0);
                                for (Consignment consignment : truck.getConsignment_list()) {
                                    Object[] rowData = new Object[]{consignment.getConsignment_id()};
                                    tb.addRow(rowData);
                                    consignment.setStatus_delivery(Consignment.Status.DELIVERED);
                                    truck.setStatus(Truck.Status.AVAILABLE);
                                    truck.setIdle_time_start(Calendar.getInstance());
                                    curr_branch.setRevenue(consignment.getDelivery_charge());
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Truck already unloaded", "Unavailable", 0);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Truck not present at this branch", "Unavailable", 0);
                        }
                    }
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(this, "No such truck exist in database.", "Error", 0);
                }
            }
        } catch (Exception e) {

        } finally {
            writeToDatabase();
        }
    }//GEN-LAST:event_b_receive_truckActionPerformed

    private void b_dispatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_dispatchActionPerformed
        readDatabase();
        try {
            String plate_num = null;
            plate_num = tf_dispatch.getText();
            if (plate_num.equals("")) {
                JOptionPane.showMessageDialog(this, "Provide Plate number", "Error", 0);
            } else {
                for (int i = 0; i < truck_list.size(); i++) {
                    if (plate_num.equals(truck_list.get(i).getPlate_number())) {
                        if (truck_list.get(i).getCurrent_office().getId() == branch_id) {
                            if (truck_list.get(i).getStatus() == Truck.Status.DISPATCHABLE) {
                                int option = JOptionPane.showConfirmDialog(this, "Confirm Dispatch", "Dispatch", 1);
                                if (option == 0) {
                                    int distance = (Math.abs(truck_list.get(i).getCurrent_office().getId() - truck_list.get(i).getDestination_office().getId())) * 100;
                                    truck_list.get(i).getCurrent_office().setCumulative_truck_count(truck_list.get(i).getCurrent_office().getCumulative_truck_count() + 1);
                                    truck_list.get(i).getDestination_office().setCumulative_truck_count(truck_list.get(i).getDestination_office().getCumulative_truck_count() + 1);
                                    truck_list.get(i).getCurrent_office().setVolume_dispatched(truck_list.get(i).getCurrent_office().getVolume_dispatched() + Truck.MAX_CAPACITY);
                                    truck_list.get(i).getCurrent_office().getTruck_list().remove(truck_list.get(i));
                                    truck_list.get(i).setCurrent_office(truck_list.get(i).getDestination_office());
                                    truck_list.get(i).getCurrent_office().getTruck_list().add(truck_list.get(i));
                                    truck_list.get(i).setDestination_office(null);
                                    truck_list.get(i).setStatus(com.transporters.Truck.Status.ENROUTE);
                                    truck_list.get(i).setTotalKM(truck_list.get(i).getTotalKM() + distance);
                                    ArrayList<Consignment> list_consignments = truck_list.get(i).getConsignment_list();
                                    Consignment consignment = null;
                                    long branch_waiting_time = 0;
                                    for (int j = 0; j < list_consignments.size(); j++) {
                                        consignment = list_consignments.get(j);
                                        truck_list.get(i).getConsignment_list().get(j).setWaiting_time((consignment.getEntry_date().getTimeInMillis() - Calendar.getInstance().getTimeInMillis()) / 1000);
                                        truck_list.get(i).getConsignment_list().get(j).setStatus_delivery(Consignment.Status.ENROUTE);
                                        branch_waiting_time += consignment.getWaiting_time();
                                    }
                                    long consignment_count = truck_list.get(i).getCurrent_office().getCumulative_truck_count();
                                    truck_list.get(i).getCurrent_office().setAvgConsignmentWaitingTime((truck_list.get(i).getCurrent_office().getAvg_consignment_waiting_time() * consignment_count + branch_waiting_time) / (consignment_count + list_consignments.size()));
                                    truck_list.get(i).getCurrent_office().setCumulative_consignment_count(consignment_count + list_consignments.size());
                                    String details = null;
                                    details = com.transporters.System.printDispatchDetails(truck_list.get(i));
                                    ta_dispatch_details.setText(details);
                                    JOptionPane.showMessageDialog(this, "Truck " + plate_num + "dispatched.", "Dispatch Successful", 1);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Truck not dispatchable yet", "Truck Undispatchable", 0);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Truck currently not present at this branch", "Truck Unavailable", 0);
                        }
                    }
                }
                JOptionPane.showMessageDialog(this, "No such truck in company", "Truck Unavailable", 0);
            }
        } catch (Exception e) {

        } finally {
            writeToDatabase();
        }
    }//GEN-LAST:event_b_dispatchActionPerformed

    private void b_dispatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_dispatchMouseClicked

    }//GEN-LAST:event_b_dispatchMouseClicked

    private void b_show_dispatchable_trucksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_show_dispatchable_trucksMouseClicked

    }//GEN-LAST:event_b_show_dispatchable_trucksMouseClicked

    private void b_show_dispatchable_trucksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_show_dispatchable_trucksActionPerformed
        readDatabase();
        DefaultTableModel tb = (DefaultTableModel) table_dispatchable_trucks.getModel();
        tb.setRowCount(0);
        for (Truck truck : truck_list) {
            if (truck.getCurrent_office().getId() == branch_id) {
                if (truck.getStatus() == Truck.Status.DISPATCHABLE) {
                    String plate_num = "";
                    plate_num = truck.getPlate_number();
                    String destination = "";
                    destination = truck.getDestination_office().getName();
                    Object[] rowData = new Object[]{plate_num, destination};
                    tb.addRow(rowData);
                }
            }
        }
    }//GEN-LAST:event_b_show_dispatchable_trucksActionPerformed

    private void b_generate_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_generate_billActionPerformed
        readDatabase();
        try {
            //To do: Abinash
            Consignment consignment = new Consignment();
            consignment.setConsignment_id(++(consignment_counter));
            consignment.setName_sender(tf_sender_name.getText());
            consignment.setName_receiver(tf_receiver_name.getText());
            consignment.setName_billing(tf_billing_name.getText());
            consignment.setAddress_sender(tf_sender_address.getText());
            consignment.setAddress_receiver(tf_receiver_address.getText());
            consignment.setAddress_billing(tf_billing_address.getText());
            if (rb_express_delievery.isSelected()) {
                consignment.setType_delivery(Consignment.DeliveryType.EXPRESS);
            } else {
                consignment.setType_delivery(Consignment.DeliveryType.REGULAR);
            }
            consignment.setVolume(Long.parseLong(tf_volume.getText()));
            if (consignment.getVolume() > Truck.MAX_CAPACITY) {
                throw new Exception("Consignment volume beyond max maximum limits");
            }
            consignment.setPieces(Integer.parseInt(tf_pieces.getText()));
            Branch curr_branch = null;
            Branch to_branch = null;
            String to_branch_name = null;
            to_branch_name = cmb_to_branch.getSelectedItem().toString();
            for (Branch branch : branch_list) {
                if (branch_id == branch.getId()) {
                    curr_branch = branch;
                }
                if (to_branch_name == branch.getName()) {
                    to_branch = branch;
                }
            }
            consignment.setFrom_branch(curr_branch);
            consignment.setTo_branch(to_branch);
            int distance;
            distance = Math.abs(curr_branch.getId() - to_branch.getId()) * 100;
            double delivery_charge = distance * consignment.getVolume() * consignment.getCharge_per_km();
            consignment.setDelivery_charge(delivery_charge);
            consignment.setDistance(distance);
            Truck truck = null;
            for (Truck truck_list_item : curr_branch.getTruck_list()) {
                if (truck_list_item.getDestination_office().equals(to_branch) && truck_list_item.getStatus().equals(Truck.Status.AVAILABLE)) {
                    if (truck_list_item.getCurrent_occupied_volume() + consignment.getVolume() < Truck.MAX_CAPACITY) {
                        truck_list_item.getConsignment_list().add(consignment);
                        consignment.setStatus_delivery(Consignment.Status.ENROUTE);
                        truck_list_item.setCurrent_occupied_volume(truck_list_item.getCurrent_occupied_volume() + consignment.getVolume());
                    }
                }
            }
            if (truck == null) {
                consignment.setWaiting_time_start(Calendar.getInstance());
                consignment.setStatus_delivery(Consignment.Status.PENDING);
                curr_branch.getWaiting_consignment_list().add(consignment);
            }
            String bill = null;
            bill = com.transporters.System.printBill(consignment);
            ta_billing_details.setText(bill);
            JOptionPane.showMessageDialog(this, "Consignment Added", "Success", 1);
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error in consignment Details", "Error", 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        } finally {
            writeToDatabase();
        }
    }//GEN-LAST:event_b_generate_billActionPerformed

    private void cmb_to_branchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb_to_branchFocusGained
        List<String> s = new ArrayList<>();
        for (Branch branch : branch_list) {
            s.add(branch.getName());
        }
        cmb_to_branch.setModel(new javax.swing.DefaultComboBoxModel(s.toArray()));
        cmb_to_branch.showPopup();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_to_branchFocusGained

    private void tf_receive_truck_plate_numFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_receive_truck_plate_numFocusGained
        l_waiting_trucks_or_consignment_id.setText("Waiting Trucks");
    }//GEN-LAST:event_tf_receive_truck_plate_numFocusGained

    private void b_waiting_trucks_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_waiting_trucks_listActionPerformed
        readDatabase();
        DefaultTableModel model = (DefaultTableModel) table_consignment_id.getModel();

        model = new DefaultTableModel(new Object[]{"Truck Id"}, 1);
        table_consignment_id.setModel(model);
        model.setRowCount(0);
        l_waiting_trucks_or_consignment_id.setText("Waiting Trucks");

    }//GEN-LAST:event_b_waiting_trucks_listActionPerformed
    private void refresh_write() {
        Branch branch = null;
        for (Branch branch_list_item : branch_list) {
            if (branch_list_item.getId() == branch_id) {
                branch = branch_list_item;
            }
        }
        for (Truck truck_list_item : truck_list) {
            if (truck_list_item.getCurrent_office().equals(branch)) {
                if (truck_list_item.getCurrent_occupied_volume() < Truck.MAX_CAPACITY && Truck.MAX_CAPACITY - truck_list_item.getCurrent_occupied_volume() < 50) {
                    truck_list_item.setStatus(Truck.Status.DISPATCHABLE);
                    branch.allotNext_available_truck(branch, truck_list_item.getDestination_office());
                }
            }
        }

        for (Consignment waiting_consignment_list_item : branch.getWaiting_consignment_list()) {
            Truck assigned_truck = null;
            for (Truck truck_list_item : branch.getTruck_list()) {
                if (truck_list_item.getDestination_office().equals(waiting_consignment_list_item.getTo_branch())) {
                    if (truck_list_item.getStatus().equals(Truck.Status.AVAILABLE)) {
                        if (truck_list_item.getCurrent_occupied_volume() + waiting_consignment_list_item.getVolume() < Truck.MAX_CAPACITY) {
                            assigned_truck = truck_list_item;
                            truck_list_item.getConsignment_list().add(waiting_consignment_list_item);
                            long waiting_time = (Calendar.getInstance().getTimeInMillis() - waiting_consignment_list_item.getWaiting_time_start().getTimeInMillis()) / 1000;
                            waiting_consignment_list_item.setWaiting_time(waiting_time);
                            waiting_consignment_list_item.setStatus_delivery(Consignment.Status.ENROUTE);
                            truck_list_item.setCurrent_occupied_volume(truck_list_item.getCurrent_occupied_volume() + waiting_consignment_list_item.getVolume());
                        }
                    }
                }
            }
        }
        writeToDatabase();
    }
    private void b_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_refreshActionPerformed
        //@Abinash : Read from database
        //@Abinash : Write to databse
        readDatabase();
        refresh_write();

    }//GEN-LAST:event_b_refreshActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Employee(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_bill_to_receiver;
    private javax.swing.JButton b_dispatch;
    private javax.swing.JButton b_generate_bill;
    private javax.swing.JButton b_receive_truck;
    private javax.swing.JButton b_refresh;
    private javax.swing.JButton b_show_dispatchable_trucks;
    private javax.swing.JButton b_waiting_trucks_list;
    private javax.swing.ButtonGroup bg_delievery_type;
    private javax.swing.JComboBox cmb_to_branch;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel l_billing_address;
    private javax.swing.JLabel l_billing_contact;
    private javax.swing.JLabel l_billing_name;
    private javax.swing.JLabel l_dispatch_truck_plate_num;
    private javax.swing.JLabel l_pieces;
    private javax.swing.JLabel l_receive_truck_plate_num;
    private javax.swing.JLabel l_receiver_address;
    private javax.swing.JLabel l_receiver_contact;
    private javax.swing.JLabel l_reciever_name;
    private javax.swing.JLabel l_sender_address;
    private javax.swing.JLabel l_sender_contact;
    private javax.swing.JLabel l_sender_name;
    private javax.swing.JLabel l_to_branch;
    private javax.swing.JLabel l_volume;
    private javax.swing.JLabel l_waiting_trucks_or_consignment_id;
    private javax.swing.JPanel p_billing;
    private javax.swing.JPanel p_distpatch;
    private javax.swing.JPanel p_employee;
    private javax.swing.JPanel p_general;
    private javax.swing.JPanel p_new_consignment;
    private javax.swing.JPanel p_receive;
    private javax.swing.JPanel p_receiver;
    private javax.swing.JPanel p_sender;
    private javax.swing.JRadioButton rb_express_delievery;
    private javax.swing.JRadioButton rb_regular_delievery;
    private javax.swing.JScrollPane sp_billing_details;
    private javax.swing.JTextArea ta_billing_details;
    private javax.swing.JTextArea ta_dispatch_details;
    private javax.swing.JTable table_consignment_id;
    private javax.swing.JTable table_dispatchable_trucks;
    private javax.swing.JTextField tf_billing_address;
    private javax.swing.JTextField tf_billing_contact;
    private javax.swing.JTextField tf_billing_name;
    private javax.swing.JTextField tf_dispatch;
    private javax.swing.JTextField tf_pieces;
    private javax.swing.JTextField tf_receive_truck_plate_num;
    private javax.swing.JTextField tf_receiver_address;
    private javax.swing.JTextField tf_receiver_contact;
    private javax.swing.JTextField tf_receiver_name;
    private javax.swing.JTextField tf_sender_address;
    private javax.swing.JTextField tf_sender_contact;
    private javax.swing.JTextField tf_sender_name;
    private javax.swing.JTextField tf_volume;
    private javax.swing.JTabbedPane tp_employee;
    private javax.swing.JTabbedPane tp_new_consignment;
    // End of variables declaration//GEN-END:variables

}
