/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.dbAccess;

import edu.ijse.oms.encryptDecript.AESencrp;
import edu.ijse.oms.model.KitchenOrder;
import edu.ijse.oms.model.Order;
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
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randula
 */
public class KitchenOrderDBAccess {

    private static final File file = new File("./src/db/kitchenOrder.txt");
    private final static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public KitchenOrderDBAccess() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public boolean saveOrder(KitchenOrder kitchenOrder) throws RemoteException,
            IOException, FileNotFoundException, ParseException, Exception {
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
            // This will print data line by line
            String data = "";
            data += kitchenOrder.getDate() + tab;
            data += kitchenOrder.getOrder().getOrderId() + tab;
            data += kitchenOrder.getOrder().getCustName() + tab;
            data += kitchenOrder.getOrder().getTelephone() + tab;
            data += kitchenOrder.getOrder().getQty() + tab;
            data += kitchenOrder.getChef() + tab;
            data += kitchenOrder.getProcessingTime() + tab;

            String encrypt = AESencrp.encrypt(data);

            bw.write(encrypt);
            bw.flush();
            isAdded = true;

        } finally {
            try {
                readWriteLock.writeLock().unlock();
                bw.close();
            } catch (IOException ex1) {
                System.err.println("Error in database manipulation, code: "
                        + ex1.getMessage());;
            }
        }
        return isOrderAvailable(kitchenOrder.getOrder().getOrderId());
    }

    public KitchenOrder searchKitchenOrder(String orderId) throws RemoteException,
            IOException, FileNotFoundException, ParseException {
        BufferedReader reader = null;
        KitchenOrder kitchenOrder = null;
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
                    kitchenOrder = new KitchenOrder();
                }
            }
            return kitchenOrder;
        } finally {
            if (reader != null) {
                reader.close();
            }
            readWriteLock.readLock().unlock();
        }
    }

    private boolean isOrderAvailable(String orderId) throws IOException,
            FileNotFoundException, ParseException {
        KitchenOrder kitchenOrder = searchKitchenOrder(orderId);
        return kitchenOrder == null;
    }

    private List<KitchenOrder> getKitchenOrder(String date, String chefId) throws
            FileNotFoundException, IOException, ParseException {
        BufferedReader reader = null;
        List<KitchenOrder> list = new ArrayList<>();
        try {

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
                String[] data = decrypt.split(":");
                System.out.println(data.length);
                System.out.println(data[0] + date + "   " + data[5] + chefId);
                if (date.equals(data[0]) && chefId.equals(data[5])) {
                    KitchenOrder kitchenOrder = new KitchenOrder();
                    Order order = new Order();
                    order.setCustName(data[2]);
                    order.setTelephone(data[3]);
                    order.setQty(data[4]);

                    kitchenOrder.setDate(data[0]);
                    kitchenOrder.setOrder(order);
                    kitchenOrder.setChef(data[5]);
                    kitchenOrder.setProcessingTime(data[6]);
                    list.add(kitchenOrder);
                }
            }
            return list;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public String[] getSummeryList(String date, String chefId) {
        String[] array = new String[4];

        String chefName = null;
        int noOfOrders = 0;
        int qty = 0;
        int min = 0;
        int sec = 0;
        int hrs = 0;
        String noOfOrdersString = null;
        String processTimeString = null;
        String qtyString = null;
        try {
            List<KitchenOrder> list = getKitchenOrder(date, chefId);
            System.out.println(new UserDBAccess().getUserFromId(chefId));
            chefName = new UserDBAccess().getUserFromId(chefId).getUserName();

            noOfOrders = list.size();
            for (KitchenOrder kitchenOrder : list) {
                int tempQty = Integer.parseInt(kitchenOrder.getOrder().getQty());
                qty += tempQty;
                String timeTextTemp[] = kitchenOrder.getProcessingTime().split("-");
                int tempHour = Integer.parseInt(timeTextTemp[0]);
                hrs = hrs + tempHour;

                int tempMin = Integer.parseInt(timeTextTemp[1]);

                if (min > 59) {
                    hrs += min / 60;
                    min = min % 60;
                } else {
                    min += tempMin;
                }
                int tempSec = Integer.parseInt(timeTextTemp[2]);
                if (sec > 59) {
                    min += sec / 60;
                    sec = sec % 60;
                } else {
                    sec += tempSec;
                }

                noOfOrdersString = Integer.toString(noOfOrders);
                processTimeString = hrs + ":" + min + ":" + sec + "Hrs";
                qtyString = Integer.toString(qty);
            }

            array[0] = chefName;
            array[1] = noOfOrdersString;
            array[2] = qtyString;
            array[3] = processTimeString;

        } catch (IOException | ParseException ex) {
            System.err.print(ex.getMessage());
        }
        return array;
    }
}
