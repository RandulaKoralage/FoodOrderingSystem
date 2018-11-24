/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.controllerImpl;

import edu.ijse.oms.controller.OrderController;
import edu.ijse.oms.dbAccess.OrderDBAccess;
import edu.ijse.oms.model.Order;
import edu.ijse.oms.observeble.OrderObserverble;
import edu.ijse.oms.observer.OrderObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Randula
 */
public class OrderControllerImpl extends UnicastRemoteObject implements OrderController {

    private static OrderDBAccess orderDBAccess;
    private static final Queue<Order> queue = new LinkedList<>();
    private static final OrderObserverble orderObserverble = new OrderObserverble();

    public OrderControllerImpl() throws RemoteException, IOException {
        orderDBAccess = new OrderDBAccess();
    }

    @Override
    public boolean saveOrder(Order order) throws RemoteException, IOException,
            FileNotFoundException, ParseException, Exception {
        boolean isAdded = orderDBAccess.saveOrder(order);
        if (isAdded) {
            addToQueue(order);
        }
        return isAdded;
    }

    @Override
    public boolean addToQueue(Order order) throws RemoteException, IOException,
            FileNotFoundException, ParseException {
        boolean add = queue.add(order);
        System.out.println("Object In Server : " + order);
        System.out.println("Size " + queue.size());
        if (add) {
            orderObserverble.notify(queue);
        }
        return add;
    }

    @Override
    public boolean removeFromQueue() throws RemoteException, IOException,
            FileNotFoundException, ParseException {

        boolean remove = queue.remove(queue.element());
        if (remove) {
            orderObserverble.notify(queue);
        }
        return remove;

    }

    @Override
    public Order searchOrder(String orderId) throws RemoteException,
            IOException, FileNotFoundException, ParseException {

        return orderDBAccess.searchOrder(orderId);

    }

    @Override
    public void addOrderObserver(OrderObserver orderObserver) throws RemoteException,
            IOException, FileNotFoundException {

        orderObserverble.addObserver(orderObserver);
        orderObserverble.notify(queue);

    }

    @Override
    public void removeOrderObserver(OrderObserver orderObserver) throws RemoteException,
            IOException, FileNotFoundException {
        orderObserverble.removeObserver(orderObserver);

    }

    @Override
    public String nextId() throws RemoteException, IOException, FileNotFoundException {
        return orderDBAccess.nextId();
    }

}
