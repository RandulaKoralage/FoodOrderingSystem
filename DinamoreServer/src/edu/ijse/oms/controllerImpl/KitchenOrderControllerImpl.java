/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.controllerImpl;

import edu.ijse.oms.controller.KitchenOrderController;
import edu.ijse.oms.dbAccess.KitchenOrderDBAccess;
import edu.ijse.oms.model.KitchenOrder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;

/**
 *
 * @author Randula
 */
public class KitchenOrderControllerImpl extends UnicastRemoteObject
            implements KitchenOrderController{
    
    private static  KitchenOrderDBAccess kitchenOrderDBAccess ;

    public KitchenOrderControllerImpl() throws RemoteException,IOException{
        kitchenOrderDBAccess = new KitchenOrderDBAccess();
    }
    @Override
    public boolean saveOrder(KitchenOrder kitchenOrder) throws RemoteException,
            IOException, FileNotFoundException, ParseException,Exception {
       return kitchenOrderDBAccess.saveOrder(kitchenOrder);
    }

    @Override
    public String[] getSummeryList(String date, String chefId) throws RemoteException, 
            IOException, FileNotFoundException, ParseException {
        return kitchenOrderDBAccess.getSummeryList(date, chefId);
    }
    
}
