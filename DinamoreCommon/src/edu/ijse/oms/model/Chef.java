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
public class Chef implements Serializable{
    private String name;
    private int chefNo;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the chefNo
     */
    public int getChefNo() {
        return chefNo;
    }

    /**
     * @param chefNo the chefNo to set
     */
    public void setChefNo(int chefNo) {
        this.chefNo = chefNo;
    }
       
}
