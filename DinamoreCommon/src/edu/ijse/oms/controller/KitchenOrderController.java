/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.controller;

import edu.ijse.oms.model.KitchenOrder;
import edu.ijse.oms.model.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;

/**
 *
 * @author Randula
 */
public interface KitchenOrderController extends Remote {

    public boolean saveOrder(KitchenOrder kitchenOrder) throws RemoteException, 
            IOException, FileNotFoundException, ParseException,Exception;

    public String[] getSummeryList(String date, String chefId) throws RemoteException, 
            IOException, FileNotFoundException, ParseException;
}
