/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Randula
 */
public class Order implements Serializable{

    private String orderId;
    private String custName;
    private String telephone;
    private String qty;
    private TelephoneOperator telephoneOperator;
    private String telephoneOp;

    public Order() {
    }

    public Order(String orderId, String custName, String telephone, String qty, TelephoneOperator telephoneOperator) {
        this.orderId = orderId;
        this.custName = custName;
        this.telephone = telephone;
        this.qty = qty;
        this.telephoneOperator = telephoneOperator;
    }

    public Order(String orderId, String custName, String telephone, String qty, String telephoneOp) {
        this.orderId = orderId;
        this.custName = custName;
        this.telephone = telephone;
        this.qty = qty;      
        this.telephoneOp = telephoneOp;
    }

   

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the telephoneOperator
     */
    public TelephoneOperator getTelephoneOperator() {
        return telephoneOperator;
    }

    /**
     * @param telephoneOperator the telephoneOperator to set
     */
    public void setTelephoneOperator(TelephoneOperator telephoneOperator) {
        this.telephoneOperator = telephoneOperator;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
    }

    /**
     * @return the telephoneOp
     */
    public String getTelephoneOp() {
        return telephoneOp;
    }

    /**
     * @param telephoneOp the telephoneOp to set
     */
    public void setTelephoneOp(String telephoneOp) {
        this.telephoneOp = telephoneOp;
    }
       
}
