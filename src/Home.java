
import com.transporters.*;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author best1yash
 */
public class Home extends javax.swing.JFrame {

    enum Session {

        EMPLOYEE,
        MANAGER
    }
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
    int login_counter;

    Branch current_branch;

    public void readDatabase() {
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

            List<byte[]> buf = new ArrayList<>();
            ObjectInputStream o;


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
//                ObjectInputStream o1 = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
//                login_list = (ArrayList<Login>) o1.readObject();
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
     * Creates new form Home
     */
    public Home() {
        initComponents();
        readDatabase();
//        try {
//            Database.setIPAddress("localhost");
//            db = new Database();
//            db.setUrl(Database.getBranchURL());
//            db.setUser("root");
//            db.setPassword("alsk");
//            Statement stmt = db.getConnection().createStatement();
//            Statement stmt2 = db.getConnection().createStatement();
//            Statement stmt3 = db.getConnection().createStatement();
//            Statement stmt4  = db.getConnection().createStatement();
//            
//            String query = "SELECT * FROM Lists";
//            ResultSet rs = stmt.executeQuery(query);
//            List<byte[]> buf = new ArrayList<>();
//            ObjectInputStream o;
//
//            String query2 = "SELECT * FROM ID_data";
//            ResultSet rs2 = stmt2.executeQuery(query2);
//
//            String query3 = "SELECT * FROM IP";
//            ResultSet rs3 = stmt3.executeQuery(query3);
//
//            rs3.next();
//            Database.setIPAddress(rs3.getString("address"));
//            
//            String query4  = "SELECT * FROM Charge";
//            ResultSet rs4 = stmt4.executeQuery(query4);
//            rs4.next();
//            Consignment.setCharge_per_km(rs4.getDouble("value"));
//
//            rs2.next();
//            head_counter = rs2.getInt("counter");
//            int temp = 0;
//            while (rs.next()) {
//                buf.add(rs.getBytes("list"));
//            }
//            if (head_counter != 0) {
//                //buf = rs.getBytes("list");
//                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
//                head_office = (HeadOffice) o.readObject();
//            } else {
//                head_office = new HeadOffice("transporters", new Address("9641183277", "LBS IITKGP"));
//                String update = "UPDATE Lists SET list=? WHERE name='head_office'";
//                PreparedStatement pstmt = db.getConnection().prepareStatement(update);
//                pstmt.setObject(1, head_office);
//                pstmt.executeUpdate();
//                stmt.executeUpdate("UPDATE ID_data SET counter=1 WHERE name='head_counter'");
//            }
//
//            rs2.next();
//            branch_counter = rs2.getInt("counter");
//            //rs.next();
//            if (branch_counter != 0) {
//                //buf = rs.getBytes("list");
//                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
//                branch_list = (ArrayList<Branch>) o.readObject();
//            } else {
//                branch_list = new ArrayList<>();
//            }
//
//            rs2.next();
//            truck_counter = rs2.getInt("counter");
//            //rs.next();
//            if (truck_counter != 0) {
//
//                //buf = rs.getBytes("list");
//                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
//                truck_list = (ArrayList<Truck>) o.readObject();
//            } else {
//                truck_list = new ArrayList<>();
//            }
//
//            rs2.next();
//            consignment_counter = rs2.getInt("counter");
//            //rs.next();
//            if (consignment_counter != 0) {
//
//                //buf = rs.getBytes("list");
//                o = new ObjectInputStream(new ByteArrayInputStream(buf.get(temp++)));
//                consignment_list = (ArrayList<Consignment>) o.readObject();
//            } else {
//                consignment_list = new ArrayList<>();
//            }
//
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
//            rs.close();
//            rs2.close();
//        } catch (SQLException | IOException | ClassNotFoundException ex) {//SQLException | IOException | ClassNotFoundException
//            java.lang.System.out.println("What");
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
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

        p_home = new javax.swing.JPanel();
        l_name = new javax.swing.JLabel();
        b_login = new javax.swing.JButton();
        tf_employee_id = new javax.swing.JTextField();
        pf_password = new javax.swing.JPasswordField();
        l_employee_id = new javax.swing.JLabel();
        l_password = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        l_home_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        p_home.setOpaque(false);

        l_name.setFont(new java.awt.Font("Droid Serif", 0, 100)); // NOI18N
        l_name.setForeground(new java.awt.Color(255, 255, 255));
        l_name.setText("Transformer");

        b_login.setBackground(new java.awt.Color(141, 235, 137));
        b_login.setForeground(new java.awt.Color(22, 93, 20));
        b_login.setText("Login");
        b_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_loginMouseClicked(evt);
            }
        });
        b_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loginActionPerformed(evt);
            }
        });

        tf_employee_id.setText("Employee Id");
        tf_employee_id.setToolTipText("");
        tf_employee_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_employee_idFocusGained(evt);
            }
        });
        tf_employee_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_employee_idActionPerformed(evt);
            }
        });

        pf_password.setText("Password");
        pf_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pf_passwordFocusGained(evt);
            }
        });

        l_employee_id.setText("Employee Id");

        l_password.setText("Password");

        jLabel1.setFont(new java.awt.Font("Droid Serif", 0, 100)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Trucks");

        javax.swing.GroupLayout p_homeLayout = new javax.swing.GroupLayout(p_home);
        p_home.setLayout(p_homeLayout);
        p_homeLayout.setHorizontalGroup(
            p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_homeLayout.createSequentialGroup()
                .addGroup(p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_homeLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_employee_id)
                            .addComponent(l_password))
                        .addGap(51, 51, 51)
                        .addGroup(p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_employee_id, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(p_homeLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(l_name))
                    .addGroup(p_homeLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1))
                    .addGroup(p_homeLayout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(b_login, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        p_homeLayout.setVerticalGroup(
            p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_homeLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(l_name)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_employee_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_employee_id))
                .addGap(18, 18, 18)
                .addGroup(p_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_password))
                .addGap(43, 43, 43)
                .addComponent(b_login)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(p_home, gridBagConstraints);
        p_home.getAccessibleContext().setAccessibleName("");

        l_home_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/142807853182618.gif"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(l_home_background, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_employee_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_employee_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_employee_idActionPerformed

    private void tf_employee_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_employee_idFocusGained
        tf_employee_id.setText("");
    }//GEN-LAST:event_tf_employee_idFocusGained

    private void pf_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pf_passwordFocusGained
        pf_password.setText("");
    }//GEN-LAST:event_pf_passwordFocusGained

    private void b_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_loginMouseClicked

    }//GEN-LAST:event_b_loginMouseClicked

    private void b_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_loginActionPerformed
        //Check for id and password
        try {
            char[] temp = pf_password.getPassword();
            String password = new String(temp);
            String login_id = tf_employee_id.getText();
            if (login_id.equals("") || login_id.equals(null)) {
                throw new Exception("Enter Login id");
            }
            if (password.equals("") || password.equals(null)) {
                throw new Exception("Enter Password");
            }
            if (login_id.equals("manager")) {
                if (password.equals("manager")) {
                    Manager manager = new Manager();
                    manager.setVisible(true);
                    dispose();
                } else {
                    throw new Exception("Password doesn't match");
                }
            } else {
                int login_num;
                try {
                    login_num = Integer.valueOf(login_id);
                } catch (NumberFormatException ex) {
                    throw new Exception("Invalid login id");

                }

                if (login_num > 0 && login_num < branch_counter) {
                    if (password.equals("akash")) {
//                    int branch_id = 2;
                        Employee employee = new Employee(Integer.valueOf(login_id));
                        employee.setVisible(true);
                        dispose();
                    } else {
                        throw new Exception("Password doesn't match");
                    }
                } else {
                    throw new Exception("Invalid login id");
                }
//                int branch_id = -1;
//                Login login = null;
//                for (Login login_list_item : login_list) {
//                    if (login_list_item.getLogin_id().equals(login_id)) {
//                        login = login_list_item;
//                    }
//                }
//                if (login == null) {
//                    throw new Exception("Invalid id");
//                }
//                for (Branch branch_list_item : branch_list) {
//                    if (login.getBranch().equals(branch_list_item)) {
//                        branch_id = branch_list_item.getId();
//                    }
//                }
//                if(branch_id == -1){
//                    throw new Exception("Employee branch invalid");
//                }
//                if (login.getPassword().equals(password)) {
//                    Employee employee = new Employee(branch_id);
//                    employee.setVisible(true);
//                    dispose();
//                } else {
//                    throw new Exception("Password doesn't match");
//                }

            }
        } catch (Exception e) {
            //if (e.getMessage().equals("Invalid login id"))
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_b_loginActionPerformed

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
    private javax.swing.JButton b_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel l_employee_id;
    private javax.swing.JLabel l_home_background;
    private javax.swing.JLabel l_name;
    private javax.swing.JLabel l_password;
    private javax.swing.JPanel p_home;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JTextField tf_employee_id;
    // End of variables declaration//GEN-END:variables
}
