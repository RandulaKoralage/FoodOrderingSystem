/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.factory;

import edu.ijse.oms.controller.KitchenOrderController;
import edu.ijse.oms.controller.OrderController;
import edu.ijse.oms.controller.UserController;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public interface DinamoreFactory extends Remote{
    public OrderController getOrderController() throws RemoteException,IOException;
    public KitchenOrderController getKitchenOrderController() throws RemoteException,IOException;
    public UserController getUserController()throws RemoteException,IOException;
    
}
