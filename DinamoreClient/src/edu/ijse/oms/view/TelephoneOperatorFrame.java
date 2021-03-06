/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.view;

import edu.ijse.oms.connector.ServerConnection;
import edu.ijse.oms.controller.OrderController;
import edu.ijse.oms.model.Order;
import edu.ijse.oms.model.TelephoneOperator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Randula
 */
public class TelephoneOperatorFrame extends javax.swing.JFrame {

    /**
     * Creates new form TelephoneOperatorFrame
     */
    public TelephoneOperatorFrame() {
        initComponents();
    }

    TelephoneOperatorFrame(String userId, String userName) {
        initComponents();
        lblOperatorName.setText(userId);
        setTitle("Telephone Operator : " + userName);
        getNextId();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        lblOperatorName = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        lblSendToKitchen = new javax.swing.JLabel();
        spnnrQty = new javax.swing.JSpinner();
        lblQty = new javax.swing.JLabel();
        lblTelephone = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        lblClientName = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        txtOrderId = new javax.swing.JTextField();
        lblOderId = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Make Order");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setForeground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOperatorName.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblOperatorName.setForeground(new java.awt.Color(153, 0, 153));
        lblOperatorName.setText("Operator Name");
        backgroundPanel.add(lblOperatorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 100, 30));

        panel.setBackground(new java.awt.Color(204, 204, 255));
        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSendToKitchen.setBackground(new java.awt.Color(255, 255, 255));
        lblSendToKitchen.setForeground(new java.awt.Color(153, 0, 0));
        lblSendToKitchen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSendToKitchen.setText("SEND TO KITCHEN");
        lblSendToKitchen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 2));
        lblSendToKitchen.setOpaque(true);
        lblSendToKitchen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSendToKitchenMouseClicked(evt);
            }
        });
        panel.add(lblSendToKitchen, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 210, 30));

        spnnrQty.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spnnrQty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        panel.add(spnnrQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 30));

        lblQty.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblQty.setText("Quantity");
        panel.add(lblQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 90, -1));

        lblTelephone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTelephone.setText("Telephone No");
        panel.add(lblTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, -1));

        txtTelephone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelephone.setForeground(new java.awt.Color(153, 0, 51));
        txtTelephone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        panel.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 350, 30));

        lblClientName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblClientName.setText("Customer Name");
        panel.add(lblClientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, -1));

        txtClientName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtClientName.setForeground(new java.awt.Color(153, 0, 51));
        txtClientName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        panel.add(txtClientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 350, 30));

        txtOrderId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOrderId.setForeground(new java.awt.Color(153, 0, 51));
        txtOrderId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        panel.add(txtOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 30));

        lblOderId.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblOderId.setText("Order Id");
        panel.add(lblOderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        backgroundPanel.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 370, 270));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(102, 0, 0));
        lblTitle.setText("Orders...");
        backgroundPanel.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 199, 46));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Operator ID:");
        backgroundPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 70, 30));

        getContentPane().add(backgroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblSendToKitchenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSendToKitchenMouseClicked
        try {
            String orderId = txtOrderId.getText();
            String cName = txtClientName.getText();
            String cTel = txtTelephone.getText();
            String qty = Integer.toString((int) spnnrQty.getValue());
            TelephoneOperator telephoneOperator = 
                    new TelephoneOperator(lblOperatorName.getText());

            Order order = new Order(orderId, cName, cTel, qty, telephoneOperator);
            OrderController orderController
                    = ServerConnection.getServerConnector().getOrderController();
            boolean isAdded = orderController.saveOrder(order);

            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Saved Successfully", "Message", 1);
                getNextId();
                txtClientName.setText(null);
                txtTelephone.setText(null);
                spnnrQty.setValue(0);
            } else {
                JOptionPane.showMessageDialog(this, "Try Again", "Message", 0);
            }
        } catch (NotBoundException | ParseException | MalformedURLException | RemoteException ex) {
            JOptionPane.showMessageDialog(this, "Sever is Currently Disconnected", "Message", 1);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
           System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_lblSendToKitchenMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelephoneOperatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelephoneOperatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelephoneOperatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelephoneOperatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelephoneOperatorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblClientName;
    private javax.swing.JLabel lblOderId;
    private javax.swing.JLabel lblOperatorName;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblSendToKitchen;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JSpinner spnnrQty;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables

    private void getNextId() {
        try {
            OrderController orderController 
                    = ServerConnection.getServerConnector().getOrderController();

            String id = orderController.nextId();
            txtOrderId.setText(id);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (NotBoundException ex) {
           System.err.println(ex.getMessage());
        }
    }
}
