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

    /**
     * Creates new form Employee
     */
    public Employee() {
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

        bg_delievery_type = new javax.swing.ButtonGroup();
        p_employee = new javax.swing.JPanel();
        tp_employee = new javax.swing.JTabbedPane();
        p_distpatch = new javax.swing.JPanel();
        p_receive = new javax.swing.JPanel();
        p_new_consignment = new javax.swing.JPanel();
        tp_new_consignment = new javax.swing.JTabbedPane();
        p_general = new javax.swing.JPanel();
        l_volume = new javax.swing.JLabel();
        tf_volume = new javax.swing.JTextField();
        l_pieces = new javax.swing.JLabel();
        tf_pieces = new javax.swing.JTextField();
        rb_regular_delievery = new javax.swing.JRadioButton();
        rb_express_delievery = new javax.swing.JRadioButton();
        p_sender = new javax.swing.JPanel();
        p_receiver = new javax.swing.JPanel();
        if_new_consignment = new javax.swing.JInternalFrame();
        sp_billing_details = new javax.swing.JScrollPane();
        ta_billing_details = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        b_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        p_employee.setOpaque(false);

        tp_employee.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout p_distpatchLayout = new javax.swing.GroupLayout(p_distpatch);
        p_distpatch.setLayout(p_distpatchLayout);
        p_distpatchLayout.setHorizontalGroup(
            p_distpatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        p_distpatchLayout.setVerticalGroup(
            p_distpatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        tp_employee.addTab("Dispatch", p_distpatch);

        javax.swing.GroupLayout p_receiveLayout = new javax.swing.GroupLayout(p_receive);
        p_receive.setLayout(p_receiveLayout);
        p_receiveLayout.setHorizontalGroup(
            p_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        p_receiveLayout.setVerticalGroup(
            p_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        tp_employee.addTab("Receive", p_receive);

        l_volume.setText("Total Volume");

        l_pieces.setText("Pieces");

        bg_delievery_type.add(rb_regular_delievery);
        rb_regular_delievery.setText("Regular Delivery");

        bg_delievery_type.add(rb_express_delievery);
        rb_express_delievery.setText("Express Delivery");

        javax.swing.GroupLayout p_generalLayout = new javax.swing.GroupLayout(p_general);
        p_general.setLayout(p_generalLayout);
        p_generalLayout.setHorizontalGroup(
            p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_generalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_generalLayout.createSequentialGroup()
                        .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_pieces)
                            .addComponent(l_volume, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_volume, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_pieces, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_generalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_express_delievery, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rb_regular_delievery, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        p_generalLayout.setVerticalGroup(
            p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_generalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_volume)
                    .addComponent(tf_volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_pieces)
                    .addComponent(tf_pieces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rb_express_delievery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_regular_delievery)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tp_new_consignment.addTab("General", p_general);

        javax.swing.GroupLayout p_senderLayout = new javax.swing.GroupLayout(p_sender);
        p_sender.setLayout(p_senderLayout);
        p_senderLayout.setHorizontalGroup(
            p_senderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );
        p_senderLayout.setVerticalGroup(
            p_senderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        tp_new_consignment.addTab("Sender", p_sender);

        javax.swing.GroupLayout p_receiverLayout = new javax.swing.GroupLayout(p_receiver);
        p_receiver.setLayout(p_receiverLayout);
        p_receiverLayout.setHorizontalGroup(
            p_receiverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );
        p_receiverLayout.setVerticalGroup(
            p_receiverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        tp_new_consignment.addTab("Receiver", p_receiver);

        if_new_consignment.setVisible(true);

        javax.swing.GroupLayout if_new_consignmentLayout = new javax.swing.GroupLayout(if_new_consignment.getContentPane());
        if_new_consignment.getContentPane().setLayout(if_new_consignmentLayout);
        if_new_consignmentLayout.setHorizontalGroup(
            if_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        if_new_consignmentLayout.setVerticalGroup(
            if_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );

        ta_billing_details.setColumns(20);
        ta_billing_details.setRows(5);
        sp_billing_details.setViewportView(ta_billing_details);

        jButton1.setText("Generate Bill");

        javax.swing.GroupLayout p_new_consignmentLayout = new javax.swing.GroupLayout(p_new_consignment);
        p_new_consignment.setLayout(p_new_consignmentLayout);
        p_new_consignmentLayout.setHorizontalGroup(
            p_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_new_consignmentLayout.createSequentialGroup()
                .addGroup(p_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_new_consignmentLayout.createSequentialGroup()
                        .addComponent(tp_new_consignment, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(p_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sp_billing_details, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addGroup(p_new_consignmentLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(p_new_consignmentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(if_new_consignment)))
                .addContainerGap())
        );
        p_new_consignmentLayout.setVerticalGroup(
            p_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_new_consignmentLayout.createSequentialGroup()
                .addGroup(p_new_consignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, p_new_consignmentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(2, 2, 2)
                        .addComponent(sp_billing_details))
                    .addComponent(tp_new_consignment, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(if_new_consignment)
                .addContainerGap())
        );

        tp_employee.addTab("New Consignment", p_new_consignment);

        b_back.setText("Back");

        javax.swing.GroupLayout p_employeeLayout = new javax.swing.GroupLayout(p_employee);
        p_employee.setLayout(p_employeeLayout);
        p_employeeLayout.setHorizontalGroup(
            p_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_employee)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_employeeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        p_employeeLayout.setVerticalGroup(
            p_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_employeeLayout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(tp_employee, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_back)
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
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_back;
    private javax.swing.ButtonGroup bg_delievery_type;
    private javax.swing.JInternalFrame if_new_consignment;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel l_pieces;
    private javax.swing.JLabel l_volume;
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
    private javax.swing.JTextField tf_pieces;
    private javax.swing.JTextField tf_volume;
    private javax.swing.JTabbedPane tp_employee;
    private javax.swing.JTabbedPane tp_new_consignment;
    // End of variables declaration//GEN-END:variables
}
