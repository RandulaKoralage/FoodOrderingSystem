/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.observerImpl;

import edu.ijse.oms.model.Order;
import edu.ijse.oms.observer.OrderObserver;
import edu.ijse.oms.view.KitchenFrame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Queue;

/**
 *
 * @author Randula
 */
public class OrderObserverImpl extends UnicastRemoteObject implements OrderObserver {

    private KitchenFrame kitchenFrame;

    public OrderObserverImpl(KitchenFrame kitchenFrame) throws RemoteException {
        this.kitchenFrame = kitchenFrame;
    }

    @Override
    public void update(Queue<Order> queue) throws RemoteException {
      
        kitchenFrame.arrangeOrderList(queue);
    }

}
