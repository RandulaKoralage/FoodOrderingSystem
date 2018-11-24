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
public class TelephoneOperator implements Serializable{
    private String name;
    private String operatorId;

    public TelephoneOperator() {
    }

    public TelephoneOperator(String name, String operatorId) {
        this.name = name;
        this.operatorId = operatorId;
    }
      public TelephoneOperator(String operatorId) {
        this.operatorId = operatorId;     
    }

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
     * @return the operatorId
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId the operatorId to set
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }    
    
}
