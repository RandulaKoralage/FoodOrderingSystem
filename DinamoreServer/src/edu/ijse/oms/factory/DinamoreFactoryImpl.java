/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.factory;

import edu.ijse.oms.controller.KitchenOrderController;
import edu.ijse.oms.controller.OrderController;
import edu.ijse.oms.controller.UserController;
import edu.ijse.oms.controllerImpl.KitchenOrderControllerImpl;
import edu.ijse.oms.controllerImpl.OrderControllerImpl;
import edu.ijse.oms.controllerImpl.UserControllerImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Randula
 */
public class DinamoreFactoryImpl extends UnicastRemoteObject implements DinamoreFactory{

    public DinamoreFactoryImpl() throws RemoteException , IOException{}
    
    @Override
    public OrderController getOrderController() throws RemoteException , IOException{
        return new OrderControllerImpl();
    }

    @Override
    public KitchenOrderController getKitchenOrderController() throws RemoteException, IOException {
        return new KitchenOrderControllerImpl();
    }

    @Override
    public UserController getUserController() throws RemoteException, IOException {
       return new UserControllerImpl();
    }
    
}
