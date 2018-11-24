/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.controller;

import edu.ijse.oms.model.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public interface UserController extends Remote{
    User getUser(String userName) throws  RemoteException, IOException, FileNotFoundException;
}
