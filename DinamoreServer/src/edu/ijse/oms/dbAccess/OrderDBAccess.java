/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.dbAccess;

import edu.ijse.oms.encryptDecript.AESencrp;
import edu.ijse.oms.model.Order;
import edu.ijse.oms.model.TelephoneOperator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randula
 */
public class OrderDBAccess {

    private static final LinkedList<String> keyList = new LinkedList<>();
    private static final File file = new File("./src/db/order.txt");
    private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    int count = 0;

    public OrderDBAccess() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public boolean saveOrder(Order order) throws RemoteException, IOException,
            FileNotFoundException, ParseException, Exception {
        boolean isAdded = false;
        FileInputStream fs = new FileInputStream(file);
        DataInputStream in = new DataInputStream(fs);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

        try {
            readWriteLock.writeLock().lock();
            String tab = ":";

            if (br.readLine() != null) {
                bw.newLine();
            }

            String data = "";
            data += order.getOrderId() + tab;
            data += order.getCustName() + tab;
            data += order.getTelephone() + tab;
            data += order.getQty() + tab;
            data += order.getTelephoneOperator().getOperatorId();

            String encrypt = AESencrp.encrypt(data);

            bw.write(encrypt);
            //   bw.flush();
            isAdded = true;

       
        } finally {
            try {
                bw.close();
                readWriteLock.writeLock().unlock();
            } catch (IOException ex1) {
                System.err.println("Error in database manipulation, code: "
                        + ex1.getMessage());;
            }
        }
        return !isOrderAvailable(order.getOrderId());
    }


    public Order searchOrder(String orderId) throws RemoteException, IOException, 
            FileNotFoundException, ParseException {
        BufferedReader reader = null;
        Order order = null;
        String tab = ":";
        try {
            readWriteLock.readLock().lock();
            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                String decrypt = null;
                try {
                    decrypt = AESencrp.decrypt(line);
                } catch (Exception ex) {
                    System.err.print(ex.getMessage());
                }
                String[] data = decrypt.split(tab);
                if (data[0].equals(orderId)) {
                    order = new Order(data[0], data[1], data[2], data[3], data[4]);
                }
            }
            return order;
        } finally {
            if (reader != null) {
                reader.close();
            }
            readWriteLock.readLock().unlock();
        }
    }

    private boolean isOrderAvailable(String orderId) throws IOException, 
            FileNotFoundException, ParseException {
        Order order = searchOrder(orderId);
        return order == null;
    }

    public String nextId() throws RemoteException, IOException, FileNotFoundException {
        generateKey();
        String key = keyList.element();
        keyList.remove(keyList.element());
        return key;
    }

    private void generateKey() throws FileNotFoundException, IOException {
        FileReader fileReader = null;
        int newId = 0;
        try {
            if (keyList.size() != 4) {
                readWriteLock.readLock().lock();
                BufferedReader reader = null;
                ArrayList<Integer> list = new ArrayList();
                fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String line = reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String decrypt = null;
                    try {
                        decrypt = AESencrp.decrypt(line);
                    } catch (Exception ex) {
                         System.err.print(ex.getMessage());
                    }
                    String[] data = decrypt.split(":");
                    list.add(Integer.parseInt(data[0]));
                }
                if (line == null) {
                    list.add(0);
                }
                Collections.sort(list);
                newId = list.get(list.size() - 1) + 1;

                for (int i = 0; i < 4; i++) {
                    keyList.add(Integer.toString(newId));
                    newId++;
                }
            }          
       
        } finally {
            try {
                fileReader.close();
                readWriteLock.readLock().unlock();
            } catch (IOException ex) {
                 System.err.print(ex.getMessage());
            }
        }
    }
}
