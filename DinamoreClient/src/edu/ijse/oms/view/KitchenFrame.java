/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.view;

import edu.ijse.oms.connector.ServerConnection;
import edu.ijse.oms.controller.KitchenOrderController;
import edu.ijse.oms.controller.OrderController;
import edu.ijse.oms.model.KitchenOrder;
import edu.ijse.oms.model.Order;
import edu.ijse.oms.observer.OrderObserver;
import edu.ijse.oms.observerImpl.OrderObserverImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Randula
 */
public class KitchenFrame extends javax.swing.JFrame {

    /**
     * Creates new form KitchenFrame
     */
    private OrderObserver orderObserver;
    private Queue<Order> orderQueue;
    private Thread t;
    private long startTime;
    private Timer timer;
    private Calendar calendar;
    private long milliTime;
    private boolean isOrderInProcessing = false;

    public KitchenFrame() {

        initComponents();
        getDateAndTime();
        getClock();
        addToObserverList();
    }

    KitchenFrame(String userId, String userName) {
        initComponents();
        lblChef.setText(userId);
        getDateAndTime();
        getClock();
        addToObserverList();
        setTitle("Chef : " + userName);
        setButtonEnable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPending = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        panel = new javax.swing.JPanel();
        lblQty = new javax.swing.JLabel();
        lblTelephone = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        lblClientName = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        txtOrderId = new javax.swing.JTextField();
        lblOderId = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        txtOperatorId = new javax.swing.JTextField();
        lblOperatorId = new javax.swing.JLabel();
        lblFinishedOrder = new javax.swing.JLabel();
        lblTakeOrder = new javax.swing.JLabel();
        lblStartTimeTitle = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        lblChef = new javax.swing.JLabel();
        lblClock = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(102, 0, 0));
        lblTitle.setText("Buns Factory...");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, 46));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPending.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        lblPending.setForeground(new java.awt.Color(255, 51, 51));
        lblPending.setText("0 Orders are pending...");
        jPanel1.add(lblPending, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 340, 40));

        table.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Pending Orders"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);
        table.setSelectionBackground(new java.awt.Color(255, 204, 153));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, 460));

        panel.setBackground(new java.awt.Color(204, 204, 255));
        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblQty.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblQty.setText("Quantity");
        panel.add(lblQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 90, -1));

        lblTelephone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTelephone.setText("Telephone No");
        panel.add(lblTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, -1));

        txtQty.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtQty.setForeground(new java.awt.Color(153, 0, 51));
        txtQty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        panel.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 350, 30));

        lblClientName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblClientName.setText("Customer Name");
        panel.add(lblClientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, -1));

        txtClientName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtClientName.setForeground(new java.awt.Color(153, 0, 51));
        txtClientName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        panel.add(txtClientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 350, 30));

        txtOrderId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOrderId.setForeground(new java.awt.Color(153, 0, 51));
        txtOrderId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        panel.add(txtOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 350, 30));

        lblOderId.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblOderId.setText("Order Id");
        panel.add(lblOderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, -1));

        txtTelephone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelephone.setForeground(new java.awt.Color(153, 0, 51));
        txtTelephone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        panel.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 350, 30));

        txtOperatorId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOperatorId.setForeground(new java.awt.Color(153, 0, 51));
        txtOperatorId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));
        panel.add(txtOperatorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 350, 30));

        lblOperatorId.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblOperatorId.setText("Telephone Operator");
        panel.add(lblOperatorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 160, -1));

        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 370, 320));

        lblFinishedOrder.setForeground(new java.awt.Color(153, 0, 0));
        lblFinishedOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFinishedOrder.setText("FINISHED ORDER");
        lblFinishedOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 2));
        lblFinishedOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFinishedOrderMouseClicked(evt);
            }
        });
        jPanel1.add(lblFinishedOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 550, 170, 30));

        lblTakeOrder.setForeground(new java.awt.Color(153, 0, 0));
        lblTakeOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTakeOrder.setText("TAKE ORDER");
        lblTakeOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 2));
        lblTakeOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTakeOrderMouseClicked(evt);
            }
        });
        jPanel1.add(lblTakeOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 170, 30));

        lblStartTimeTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStartTimeTitle.setText("Processing Time");
        jPanel1.add(lblStartTimeTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 140, 30));

        label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label.setText("0-0-0");
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 70, 30));

        lblChef.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblChef.setForeground(new java.awt.Color(153, 0, 153));
        lblChef.setText("Chef Name");
        jPanel1.add(lblChef, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 70, 30));

        lblClock.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblClock.setText("Time");
        jPanel1.add(lblClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 180, 40));

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDate.setText("Date");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 190, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Chef ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hrs");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblTakeOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTakeOrderMouseClicked
        myTimmer(evt);
        getOrderDetails();
        removeOrderFromQueue();
        isOrderInProcessing = true;
        setButtonEnable();
    }//GEN-LAST:event_lblTakeOrderMouseClicked

    private void lblFinishedOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFinishedOrderMouseClicked
       finishOrder();
    }//GEN-LAST:event_lblFinishedOrderMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            OrderController orderController
                    = ServerConnection.getServerConnector().getOrderController();

            orderController.removeOrderObserver(orderObserver);
        } catch (IOException | NotBoundException ex) {
           JOptionPane.showMessageDialog(this, "Sever is Currently Disconnected", "Message", 1);
        }
    }//GEN-LAST:event_formWindowClosing

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

    }//GEN-LAST:event_tableMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KitchenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KitchenFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lblChef;
    private javax.swing.JLabel lblClientName;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFinishedOrder;
    private javax.swing.JLabel lblOderId;
    private javax.swing.JLabel lblOperatorId;
    private javax.swing.JLabel lblPending;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblStartTimeTitle;
    private javax.swing.JLabel lblTakeOrder;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtOperatorId;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables

    public void arrangeOrderList(Queue<Order> queue) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();

        orderQueue = queue;

        dtm.setRowCount(0);
        for (Order o : queue) {
            Object[] rows = {"Order Id : " + o.getOrderId() + " - " + "Order of : " + o.getQty()};
            dtm.addRow(rows);
        }
        if (table.getRowCount() == 1) {
            lblPending.setText(table.getRowCount() + " Order is pending...");
        } else {
            lblPending.setText(table.getRowCount() + " Orders are pending...");
        }
    }

    private void getOrderDetails() {
        Order order = null;
        if (!orderQueue.isEmpty()) {
            order = (Order) orderQueue.element();
            txtOrderId.setText(order.getOrderId());
            txtClientName.setText(order.getCustName());
            txtTelephone.setText(order.getTelephone());
            txtQty.setText(order.getQty());
            txtOperatorId.setText(order.getTelephoneOperator().getOperatorId());
        }

    }

    private void removeOrderFromQueue() {
        try {
            OrderController orderController
                    = ServerConnection.getServerConnector().getOrderController();
            orderController.removeFromQueue();

        } catch (IOException | NotBoundException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Sever is Currently Disconnected", "Message", 1);
        }
    }

    private void getDateAndTime() {
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        String new_DATE = simpledateformat.format(date);
        lblDate.setText(new_DATE);

    }

    private void getClock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Date curDate = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss aa");
                    String currentTime = dateFormat.format(curDate);

                    lblClock.setText(currentTime);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(KitchenFrame.this, "Database Error...");
                    }
                }
            }
        }).start();
    }

    private void addToObserverList() {
        try {
            orderObserver = new OrderObserverImpl(this);
            OrderController orderController
                    = ServerConnection.getServerConnector().getOrderController();
            orderController.addOrderObserver(orderObserver);

        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, "Sever is Currently Disconnected", "Message", 1);

        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(this, "Sever is Currently Disconnected", "Message", 1);

        } catch (MalformedURLException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void myTimmer(java.awt.event.MouseEvent evt) {
        calendar = Calendar.getInstance();
        this.startTime = System.currentTimeMillis();
        if (timer == null) {
            timer = new Timer(1000, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int[] out = updateTime();
                    label.setText(out[0] + "-" + out[1] + "-" + out[2]);
                    repaint();
                }

            });
            timer.start();
        }

    }

    private int[] updateTime() {
        milliTime = System.currentTimeMillis() - this.startTime;
        int[] out = new int[]{0, 0, 0, 0};
        out[0] = (int) (milliTime / 3600000);
        out[1] = (int) (milliTime / 60000) % 60;
        out[2] = (int) (milliTime / 1000) % 60;
        out[3] = (int) (milliTime) % 1000;

        return out;
    }

    private void setButtonEnable() {
        if (isOrderInProcessing == false) {
            lblTakeOrder.setEnabled(true);
            lblFinishedOrder.setEnabled(false);
        } else {
            lblTakeOrder.setEnabled(false);
            lblFinishedOrder.setEnabled(true);
        }
    }

    private void finishOrder() {
        timer.stop();
        timer = null;
        try {
            String date = lblDate.getText();
            String oid = txtOrderId.getText();
            Order order = new Order(txtOrderId.getText(), txtClientName.getText(),
                    txtTelephone.getText(), txtQty.getText(), txtOperatorId.getText());
            String chef = lblChef.getText();

            KitchenOrder kitchenOrder = new KitchenOrder(date, label.getText(), order, chef);
            KitchenOrderController kitchenOrderController
                    = ServerConnection.getServerConnector().getKitchenOrderController();

            boolean isAdded = kitchenOrderController.saveOrder(kitchenOrder);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Saved Successfully", "Message", 1);
                txtOrderId.setText(null);
                txtClientName.setText(null);
                txtTelephone.setText(null);
                txtQty.setText(null);
                txtOperatorId.setText(null);
                label.setText("0-0-0");
                isOrderInProcessing = false;
                setButtonEnable();

            } else {
                JOptionPane.showMessageDialog(this, "Try Again", "Message", 1);
            }
        } catch (IOException | NotBoundException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Sever is Currently Disconnected", "Message", 1);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
