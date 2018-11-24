/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.controllerImpl;

import edu.ijse.oms.controller.UserController;
import edu.ijse.oms.dbAccess.UserDBAccess;
import edu.ijse.oms.model.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Randula
 */
public class UserControllerImpl extends UnicastRemoteObject implements UserController{

    private static UserDBAccess userDBAccess;
    public UserControllerImpl()throws RemoteException, IOException{
        userDBAccess = new UserDBAccess();
    }
    
    
    @Override
    public User getUser(String userName) throws RemoteException, IOException, FileNotFoundException {
       return userDBAccess.getUser(userName);
    }
    
}
