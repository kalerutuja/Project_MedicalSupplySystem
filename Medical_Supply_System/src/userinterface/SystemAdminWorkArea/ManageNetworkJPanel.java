/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Network.Network;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rutuja
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageNetworkJPanel
     */
    
    private JPanel userProcessContainer;
    private EcoSystem system;
    
    public ManageNetworkJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateNetworkTable(); 
    }
    
    private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) NetworkJTable.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            Object[] row = new Object[1];
            row[0] = network.getName();
            model.addRow(row);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAddNetwork = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NetworkJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblEnterName = new javax.swing.JLabel();
        txtNetworkName = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddNetwork.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblAddNetwork.setForeground(new java.awt.Color(252, 92, 59));
        lblAddNetwork.setText("Add Networks");
        add(lblAddNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jScrollPane1.setForeground(new java.awt.Color(252, 92, 59));

        NetworkJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(NetworkJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 400, 150));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 92, 59));
        jLabel2.setText("Network List");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 100, -1));

        lblEnterName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblEnterName.setForeground(new java.awt.Color(252, 92, 59));
        lblEnterName.setText("Please enter the Network name:");
        add(lblEnterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 336, -1, 20));
        add(txtNetworkName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 170, 30));

        btnSubmit.setText("Submit");
        btnSubmit.setMaximumSize(new java.awt.Dimension(79, 29));
        btnSubmit.setMinimumSize(new java.awt.Dimension(79, 29));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 120, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String name = txtNetworkName.getText();
        if (name.trim().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Please enter valid input!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for( Network network : system.getNetworkList()){
            if(name.equals(network.getName())){
                JOptionPane.showConfirmDialog(null, "Network name alreay exists. Please choose another!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
            }
        }
        Network network = system.createAndAddNetwork();
        network.setName(name);
        JOptionPane.showMessageDialog(null, "Network Created!!", "INFO", JOptionPane.INFORMATION_MESSAGE);

        populateNetworkTable();
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable NetworkJTable;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddNetwork;
    private javax.swing.JLabel lblEnterName;
    private javax.swing.JTextField txtNetworkName;
    // End of variables declaration//GEN-END:variables

   
}
