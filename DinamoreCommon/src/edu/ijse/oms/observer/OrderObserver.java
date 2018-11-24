/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.observer;

import edu.ijse.oms.model.Order;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Queue;

/**
 *
 * @author Randula
 */
public interface OrderObserver extends Remote{
    void update(Queue<Order> queue) throws RemoteException;
}
