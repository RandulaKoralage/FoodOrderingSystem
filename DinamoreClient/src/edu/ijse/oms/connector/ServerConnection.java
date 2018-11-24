/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.connector;

import edu.ijse.oms.controller.KitchenOrderController;
import edu.ijse.oms.controller.OrderController;
import edu.ijse.oms.controller.UserController;
import edu.ijse.oms.factory.DinamoreFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public class ServerConnection {

    private static ServerConnection serverConnection;
    private DinamoreFactory dinamoreFactory;
    private OrderController orderController;
    private KitchenOrderController kitchenOrderController;
    private UserController userController;

    private ServerConnection() throws NotBoundException, MalformedURLException, RemoteException {
        dinamoreFactory = (DinamoreFactory) Naming.lookup("rmi://localhost:5050/Server");

    }

    public static ServerConnection getServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (serverConnection == null) {
            serverConnection = new ServerConnection();
        }
        return serverConnection;
    }

    public OrderController getOrderController() throws RemoteException, IOException {
        if (orderController == null) {
            orderController = dinamoreFactory.getOrderController();
        }
        return orderController;
    }

    public KitchenOrderController getKitchenOrderController() throws RemoteException, IOException {
        if (kitchenOrderController == null) {
            kitchenOrderController = dinamoreFactory.getKitchenOrderController();
        }
        return kitchenOrderController;
    }
    public UserController getUserController() throws RemoteException, IOException {
        if (userController == null) {
            userController = dinamoreFactory.getUserController();
        }
        return userController;
    }
}
