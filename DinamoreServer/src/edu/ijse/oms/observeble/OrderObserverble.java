/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.observeble;

import edu.ijse.oms.model.Order;
import edu.ijse.oms.observer.OrderObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randula
 */
public class OrderObserverble {

    private final static ArrayList<OrderObserver> observerList = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observerList.remove(observer);
    }

    public void notify(Queue<Order> queue) throws RemoteException {
        for (OrderObserver observer : observerList) {
            new Thread() {
                public void run() {
                    try {
                        
                        observer.update(queue);
                    } catch (RemoteException ex) {
                        Logger.getLogger(OrderObserverble.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
