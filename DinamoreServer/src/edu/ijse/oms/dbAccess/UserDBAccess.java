/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.dbAccess;

import edu.ijse.oms.encryptDecript.AESencrp;
import edu.ijse.oms.model.Order;
import edu.ijse.oms.model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randula
 */
public class UserDBAccess {
     private static final File file = new File("./src/db/user.txt");
    public UserDBAccess() throws IOException {
         if (!file.exists()) {
            file.createNewFile();
        }     
    }
    
    
    
     public User getUser(String userName) throws RemoteException, IOException, FileNotFoundException {
        BufferedReader reader = null;
        User user = null;
        String tab = ":";
        try {
            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            
            String line = null;
            while ((line = reader.readLine()) != null) {                             
                String[] data = line.split(tab);
                if (data[1].equalsIgnoreCase(userName)) {
                   
                    user = new User(data[0], data[1], data[2], data[3]);                  
                }
            }
            return user;
        }
         finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
     public User getUserFromId(String userId) throws RemoteException, IOException, FileNotFoundException {
        BufferedReader reader = null;
        User user = null;
        String tab = ":";
        try {
            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            
            String line = null;
            while ((line = reader.readLine()) != null) {                             
                String[] data = line.split(tab);
                if (data[0].equalsIgnoreCase(userId)) {
                   
                    user = new User(data[0], data[1], data[2], data[3]);                  
                }
            }
            return user;
        }
         finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
