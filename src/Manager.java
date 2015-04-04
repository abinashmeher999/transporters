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

    /**
     * Creates new form Manager
     */
    public Manager() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        tp_manager = new javax.swing.JTabbedPane();
        p_administration = new javax.swing.JPanel();
        tp_administration = new javax.swing.JTabbedPane();
        p_hire = new javax.swing.JPanel();
        b_view_applicatns = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        if_applicant_list = new javax.swing.JInternalFrame();
        l_employee_name = new javax.swing.JLabel();
        l_employee_address = new javax.swing.JLabel();
        l_branch = new javax.swing.JLabel();
        tf_employee_name = new javax.swing.JTextField();
        tf_employee_address = new javax.swing.JTextField();
        cmb_branch_list = new javax.swing.JComboBox();
        b_hire = new javax.swing.JButton();
        p_buy_truck = new javax.swing.JPanel();
        l_model = new javax.swing.JLabel();
        l_plate_number = new javax.swing.JLabel();
        l_cost = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_truck_model = new javax.swing.JTextField();
        tf_plate_number = new javax.swing.JTextField();
        tf_cost = new javax.swing.JTextField();
        cmb_branch = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        p_fire = new javax.swing.JPanel();
        b_view_employee = new javax.swing.JButton();
        if_employee_list = new javax.swing.JInternalFrame();
        jSeparator2 = new javax.swing.JSeparator();
        tf_employee_id = new javax.swing.JTextField();
        l_employee_id = new javax.swing.JLabel();
        l_fire_reason = new javax.swing.JLabel();
        tf_fire_reason = new javax.swing.JTextField();
        b_fire = new javax.swing.JButton();
        p_queries = new javax.swing.JPanel();
        p_company_statistics = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p_administration.setOpaque(false);

        tp_administration.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        p_hire.setPreferredSize(new java.awt.Dimension(800, 600));

        b_view_applicatns.setText("View Applicants");
        b_view_applicatns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_view_applicatnsActionPerformed(evt);
            }
        });

        if_applicant_list.setVisible(true);

        l_employee_name.setText("Name");

        l_employee_address.setText("Addresss");

        l_branch.setText("Branch");

        tf_employee_name.setText("Employee Name");
        tf_employee_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_employee_nameActionPerformed(evt);
            }
        });

        tf_employee_address.setText("Employee Address");

        cmb_branch_list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        b_hire.setText("Hire");

        javax.swing.GroupLayout p_hireLayout = new javax.swing.GroupLayout(p_hire);
        p_hire.setLayout(p_hireLayout);
        p_hireLayout.setHorizontalGroup(
            p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(p_hireLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_view_applicatns)
                    .addGroup(p_hireLayout.createSequentialGroup()
                        .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_employee_name)
                            .addComponent(l_employee_address))
                        .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_hireLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(tf_employee_name, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(l_branch))
                            .addGroup(p_hireLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tf_employee_address, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_branch_list, 0, 180, Short.MAX_VALUE)
                            .addComponent(b_hire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(if_applicant_list, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p_hireLayout.setVerticalGroup(
            p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_hireLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_view_applicatns)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(if_applicant_list, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_employee_name)
                    .addComponent(tf_employee_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_branch)
                    .addComponent(cmb_branch_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_hireLayout.createSequentialGroup()
                        .addComponent(tf_employee_address)
                        .addGap(284, 284, 284))
                    .addGroup(p_hireLayout.createSequentialGroup()
                        .addGroup(p_hireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_employee_address)
                            .addComponent(b_hire))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tp_administration.addTab("Hire Employee", p_hire);

        l_model.setText("Model");

        l_plate_number.setText("Plate Number");

        l_cost.setText("Cost");

        jLabel4.setText("Assigned Branch");

        tf_truck_model.setText("Truck Model");

        tf_plate_number.setText("Plate Number");
        tf_plate_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_plate_numberActionPerformed(evt);
            }
        });

        tf_cost.setText("Cost");

        cmb_branch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Add to fleet");

        javax.swing.GroupLayout p_buy_truckLayout = new javax.swing.GroupLayout(p_buy_truck);
        p_buy_truck.setLayout(p_buy_truckLayout);
        p_buy_truckLayout.setHorizontalGroup(
            p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_buy_truckLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_model)
                    .addComponent(l_plate_number)
                    .addComponent(l_cost)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(p_buy_truckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tf_truck_model, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(tf_plate_number)
                        .addComponent(tf_cost)
                        .addComponent(cmb_branch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(362, Short.MAX_VALUE))
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
                            .addComponent(tf_fire_reason, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
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
                .addComponent(if_employee_list, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(p_fireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_employee_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_employee_id))
                .addGap(18, 18, 18)
                .addGroup(p_fireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_fire_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_fire_reason))
                .addGap(18, 18, 18)
                .addComponent(b_fire)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp_administration.addTab("Fire Employee", p_fire);

        javax.swing.GroupLayout p_administrationLayout = new javax.swing.GroupLayout(p_administration);
        p_administration.setLayout(p_administrationLayout);
        p_administrationLayout.setHorizontalGroup(
            p_administrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_administrationLayout.createSequentialGroup()
                .addComponent(tp_administration, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        p_administrationLayout.setVerticalGroup(
            p_administrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_administration, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        tp_manager.addTab("Administration", p_administration);

        p_queries.setOpaque(false);

        javax.swing.GroupLayout p_queriesLayout = new javax.swing.GroupLayout(p_queries);
        p_queries.setLayout(p_queriesLayout);
        p_queriesLayout.setHorizontalGroup(
            p_queriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        p_queriesLayout.setVerticalGroup(
            p_queriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        tp_manager.addTab("Queries", p_queries);

        p_company_statistics.setOpaque(false);

        javax.swing.GroupLayout p_company_statisticsLayout = new javax.swing.GroupLayout(p_company_statistics);
        p_company_statistics.setLayout(p_company_statisticsLayout);
        p_company_statisticsLayout.setHorizontalGroup(
            p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        p_company_statisticsLayout.setVerticalGroup(
            p_company_statisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        tp_manager.addTab("Company Statistics", p_company_statistics);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_employee_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_employee_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_employee_nameActionPerformed

    private void b_view_applicatnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_view_applicatnsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_view_applicatnsActionPerformed

    private void tf_plate_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_plate_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_plate_numberActionPerformed

    private void b_view_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_view_employeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_view_employeeActionPerformed

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
    private javax.swing.JButton b_fire;
    private javax.swing.JButton b_hire;
    private javax.swing.JButton b_view_applicatns;
    private javax.swing.JButton b_view_employee;
    private javax.swing.JComboBox cmb_branch;
    private javax.swing.JComboBox cmb_branch_list;
    private javax.swing.JInternalFrame if_applicant_list;
    private javax.swing.JInternalFrame if_employee_list;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel l_branch;
    private javax.swing.JLabel l_cost;
    private javax.swing.JLabel l_employee_address;
    private javax.swing.JLabel l_employee_id;
    private javax.swing.JLabel l_employee_name;
    private javax.swing.JLabel l_fire_reason;
    private javax.swing.JLabel l_model;
    private javax.swing.JLabel l_plate_number;
    private javax.swing.JPanel p_administration;
    private javax.swing.JPanel p_buy_truck;
    private javax.swing.JPanel p_company_statistics;
    private javax.swing.JPanel p_fire;
    private javax.swing.JPanel p_hire;
    private javax.swing.JPanel p_queries;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_employee_address;
    private javax.swing.JTextField tf_employee_id;
    private javax.swing.JTextField tf_employee_name;
    private javax.swing.JTextField tf_fire_reason;
    private javax.swing.JTextField tf_plate_number;
    private javax.swing.JTextField tf_truck_model;
    private javax.swing.JTabbedPane tp_administration;
    private javax.swing.JTabbedPane tp_manager;
    // End of variables declaration//GEN-END:variables
}