
import com.transporters.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    Database db;
    HeadOffice head_office;
    List<Branch> branch_list;
    List<Truck> truck_list;
    List<Consignment> consignment_list;

    int head_counter;
    int branch_counter;
    int truck_counter;
    int consignment_counter;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        try {
            Database.setIPAddress("localhost");
            db.setUrl(Database.getBranchURL());
            db.setUser("root");
            db.setPassword("alsk");
            db.connect();

            Statement stmt = db.getConnection().createStatement();
            String query = "SELECT * FROM Lists;";
            ResultSet rs = stmt.executeQuery(query);
            byte[] buf;
            ObjectInputStream o;

            rs.next();
            buf = rs.getBytes("list");
            o = new ObjectInputStream(new ByteArrayInputStream(buf));
            branch_list = (ArrayList<Branch>) o.readObject();

            rs.next();
            buf = rs.getBytes("list");
            o = new ObjectInputStream(new ByteArrayInputStream(buf));
            truck_list = (ArrayList<Truck>) o.readObject();

            rs.next();
            buf = rs.getBytes("list");
            o = new ObjectInputStream(new ByteArrayInputStream(buf));
            consignment_list = (ArrayList<Consignment>) o.readObject();

            rs.next();
            buf = rs.getBytes("list");
            o = new ObjectInputStream(new ByteArrayInputStream(buf));
            head_office = (HeadOffice) o.readObject();

            query = "SELECT * ID_data;";
            rs = stmt.executeQuery(query);
            
            rs.next();
            head_counter = rs.getInt("counter");
            
            rs.next();
            branch_counter = rs.getInt("counter");
            
            rs.next();
            truck_counter = rs.getInt("counter");
            
            rs.next();
            consignment_counter = rs.getInt("counter");

        } catch (SQLException | IOException | ClassNotFoundException ex) {
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

        b_login.setText("Login");
        b_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_loginMouseClicked(evt);
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
                        .addGap(347, 347, 347)
                        .addComponent(b_login))
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
                        .addComponent(jLabel1)))
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
        //Check for id and password
        if(tf_employee_id.getText().equals("1")){
            Manager manager = new Manager();
            manager.setVisible(true);
        }else if(tf_employee_id.getText().equals("2")){
            Employee employee = new Employee();
            employee.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_b_loginMouseClicked

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
