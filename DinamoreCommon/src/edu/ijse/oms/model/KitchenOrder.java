/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.oms.model;

import java.io.Serializable;

/**
 *
 * @author Randula
 */
public class KitchenOrder implements Serializable{
    private String date;
    private String processingTime;
    private Order order;
    private String chef;

    public KitchenOrder() {
    }

    public KitchenOrder(String date, String processingTime, Order order, String chef) {
        this.date = date;
        this.processingTime = processingTime;
        this.order = order;
        this.chef = chef;
    }

    

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * @return the chef
     */
    public String getChef() {
        return chef;
    }

    /**
     * @param chef the chef to set
     */
    public void setChef(String chef) {
        this.chef = chef;
    }

    /**
     * @return the processingTime
     */
    public String getProcessingTime() {
        return processingTime;
    }

    /**
     * @param processingTime the processingTime to set
     */
    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
       
}
