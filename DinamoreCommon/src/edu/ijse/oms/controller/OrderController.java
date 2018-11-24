/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.controller;

import edu.ijse.oms.model.Order;
import edu.ijse.oms.observer.OrderObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;

/**
 *
 * @author Randula
 */
public interface OrderController extends Remote {

    public boolean saveOrder(Order order) throws RemoteException, IOException,
            FileNotFoundException, ParseException,Exception;

    public boolean addToQueue(Order order) throws RemoteException, IOException,
            FileNotFoundException, ParseException;

    public boolean removeFromQueue() throws RemoteException, IOException,
            FileNotFoundException, ParseException;

    public Order searchOrder(String orderId) throws RemoteException, IOException,
            FileNotFoundException, ParseException;

    public void addOrderObserver(OrderObserver orderObserver) throws RemoteException,
            IOException, FileNotFoundException;

    public void removeOrderObserver(OrderObserver orderObserver) throws RemoteException,
            IOException, FileNotFoundException;

    public String nextId() throws RemoteException, IOException, FileNotFoundException;
}
